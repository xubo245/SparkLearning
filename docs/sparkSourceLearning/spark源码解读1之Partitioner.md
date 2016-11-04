
更多代码请见：https://github.com/xubo245/SparkLearning

spark源码解读系列环境：spark-1.5.2、hadoop-2.6.0、scala-2.10.4

# 1.理解 #

# Partitioner类 #
Partitioner类是用于处理key-value类型的RDD，根据key进行元素划分。

Partitioner是一个抽象类。只有两个方法：numPartitions和getPartition(key: Any)。 

    /**
	 * An object that defines how the elements in a key-value pair RDD are partitioned by key.
	 * Maps each key to a partition ID, from 0 to `numPartitions - 1`.
	 */
	abstract class Partitioner extends Serializable {
	  def numPartitions: Int
	  def getPartition(key: Any): Int
	}  
Partitioner同时有一个伴生对象，有defaultPartitioner方法，默认是：HashPartitioner

	object Partitioner {
	  def defaultPartitioner(rdd: RDD[_], others: RDD[_]*): Partitioner = {
	    val bySize = (Seq(rdd) ++ others).sortBy(_.partitions.size).reverse
	    for (r <- bySize if r.partitioner.isDefined && r.partitioner.get.numPartitions > 0) {
	      return r.partitioner.get
	    }
	    if (rdd.context.conf.contains("spark.default.parallelism")) {
	      new HashPartitioner(rdd.context.defaultParallelism)
	    } else {
	      new HashPartitioner(bySize.head.partitions.size)
	    }
	  }
	}


# Spark的Partitioner类的子类 #

在Spark的Partitioner类中，存在两类Partitioner函数：HashPartitioner和RangePartitioner，它们都是继承自Partitioner，主要提供了每个RDD有几个分区（numPartitions）以及对于给定的值返回一个分区ID（0~numPartitions-1），也就是决定这个值是属于那个分区的。

## （1）HashPartitioner ##
　HashPartitioner分区的原理很简单，对于给定的key，计算其hashCode，并除于分区的个数取余，如果余数小于0，则用余数+分区的个数，最后返回的值就是这个key所属的分区ID。

子类继承父抽象类，需要实现抽象类中的抽象方法。Partitioner主要有两个：numPartitions和getPartition。   

HashPartitioner实现：
	  def numPartitions: Int = partitions
	
	  def getPartition(key: Any): Int = key match {
	    case null => 0
	    case _ => Utils.nonNegativeMod(key.hashCode, numPartitions)
	  }
numPartitions好理解，getPartition使用了Utils的方法：

	  def nonNegativeMod(x: Int, mod: Int): Int = {
	    val rawMod = x % mod
	    rawMod + (if (rawMod < 0) mod else 0)
	  }
主要是由于key.hashCode有可能为赋值，需要判断和处理。

另外HashPatitioner重写了两个方法：

	  override def equals(other: Any): Boolean = other match {
	    case h: HashPartitioner =>
	      h.numPartitions == numPartitions
	    case _ =>
	      false
	  }
	
	  override def hashCode: Int = numPartitions
这个好理解。


## （2）RangePartitioner ##
从HashPartitioner分区的实现原理我们可以看出，其结果可能导致每个分区中数据量的不均匀，极端情况下会导致某些分区拥有RDD的全部数据，这显然不是我们需要的。而RangePartitioner分区则尽量保证每个分区中数据量的均匀，而且分区与分区之间是有序的，也就是说一个分区中的元素肯定都是比另一个分区内的元素小或者大；但是分区内的元素是不能保证顺序的。简单的说就是将一定范围内的数映射到某一个分区内。    

RangePartitioner分区器的主要作用就是将一定范围内的数映射到某一个分区内，所以它的实现中分界的算法尤为重要   

rangeBounds的边界方法rangeBounds，主要是利用 RangePartitioner伴生对象的sketch方法进行抽样，抽样方法采取的是水塘抽样(Reservoir Sampling)，详细可以参考【8】、【9】。  
水塘抽样(Reservoir Sampling)的主要思想是：

	在序列流中取一个数，如何确保随机性，即取出某个数据的概率为:1/(已读取数据个数)
	
	　　假设已经读取n个数，现在保留的数是Ax，取到Ax的概率为(1/n)。
	
	　　对于第n+1个数An+1，以1/(n+1)的概率取An+1，否则仍然取Ax。依次类推，可以保证取到数据的随机性。
	
	　　数学归纳法证明如下：
	
	　　　　当n=1时，显然，取A1。取A1的概率为1/1。
	
	           假设当n=k时，取到的数据Ax。取Ax的概率为1/k。
	
	           当n=k+1时，以1/(k+1)的概率取An+1，否则仍然取Ax。
	
	　　　　(1)如果取Ak+1，则概率为1/(k+1)；
	
	　　　　(2)如果仍然取Ax，则概率为(1/k)*(k/(k+1))=1/(k+1)
	   
采用水塘抽样(Reservoir Sampling)主要是解决Spark 1.1中rangeBounds需要先知道rdd的size，然后再去抽样的的问题，因为这种需要两次遍历RDD，而水塘抽样(Reservoir Sampling)可以在不知道总size的情况下进行抽样，特别适用于数据在内存存不下的情况。  

   RangePartitioner伴生对象的sketch方法：

	  /**
	   * Sketches the input RDD via reservoir sampling on each partition.
	   *
	   * @param rdd the input RDD to sketch
	   * @param sampleSizePerPartition max sample size per partition
	   * @return (total number of items, an array of (partitionId, number of items, sample))
	   */
	  def sketch[K : ClassTag](
	      rdd: RDD[K],
	      sampleSizePerPartition: Int): (Long, Array[(Int, Int, Array[K])]) = {
	    val shift = rdd.id
	    // val classTagK = classTag[K] // to avoid serializing the entire partitioner object
	    val sketched = rdd.mapPartitionsWithIndex { (idx, iter) =>
	      val seed = byteswap32(idx ^ (shift << 16))
	      val (sample, n) = SamplingUtils.reservoirSampleAndCount(
	        iter, sampleSizePerPartition, seed)
	      Iterator((idx, n, sample))
	    }.collect()
	    val numItems = sketched.map(_._2.toLong).sum
	    (numItems, sketched)
	  }
 
　RangePartitioner.sketch的第一个参数是rdd.map(_._1)，也就是把父RDD的key传进来，因为分区只需要对Key进行操作即可。该函数返回值是val (numItems, sketched) ，其中numItems相当于记录rdd元素的总数；而sketched的类型是Array[(Int, Int, Array[K])]，记录的是分区的编号、该分区中总元素的个数以及从父RDD中每个分区采样的数据。

　sketch函数对父RDD中的每个分区进行采样，并记录下分区的ID和分区中数据总和。

　reservoirSampleAndCount函数就是典型的水塘抽样实现，唯一不同的是该算法还记录下i的值，这个就是该分区中元素的总和。

如果获取的数据分布不均匀，则边界方法rangeBounds会再次抽样，但是只对抽象数少于要求的partition进行sample，其他抽样好的不会。

最后获取到每个partition中每个样本和对应的weight（ 类似candidates += ((key, weight))），weight为partition中元素数量与抽样数量的比值，对于重新抽样的，则为1.

最后再进行边界确定：determineBounds

	 /**
	   * Determines the bounds for range partitioning from candidates with weights indicating how many
	   * items each represents. Usually this is 1 over the probability used to sample this candidate.
	   *
	   * @param candidates unordered candidates with weights
	   * @param partitions number of partitions
	   * @return selected bounds
	   */
	  def determineBounds[K : Ordering : ClassTag](
	      candidates: ArrayBuffer[(K, Float)],
	      partitions: Int): Array[K] = {
	    val ordering = implicitly[Ordering[K]]
	    val ordered = candidates.sortBy(_._1)
	    val numCandidates = ordered.size
	    val sumWeights = ordered.map(_._2.toDouble).sum
	    val step = sumWeights / partitions
	    var cumWeight = 0.0
	    var target = step
	    val bounds = ArrayBuffer.empty[K]
	    var i = 0
	    var j = 0
	    var previousBound = Option.empty[K]
	    while ((i < numCandidates) && (j < partitions - 1)) {
	      val (key, weight) = ordered(i)
	      cumWeight += weight
	      if (cumWeight > target) {
	        // Skip duplicate values.
	        if (previousBound.isEmpty || ordering.gt(key, previousBound.get)) {
	          bounds += key
	          target += step
	          j += 1
	          previousBound = Some(key)
	        }
	      }
	      i += 1
	    }
	    bounds.toArray
	  }
	}

determineBounds主要对 candidates先按key进行排序，然后获取总抽样元素除以partition大小即为每个partition理论的大小，即代码中的step。
然后再对排序好的ordered进行遍历，当所代表的权重大于step的整数倍时，返回此时的key，作为划分条件。然后依次类推，获得每个partition的边界key。


**总结：RangePartitioner是采取抽样的策略，每个partition理论的是抽取20个元素，实际采用水塘抽样(Reservoir Sampling)时为了避免抽样少于期望，会乘以3.然后再用determineBounds对抽样数据进行排序，weight是每个key所代表的抽样数量，再按weight确定每个partition接近理论的边界，并进行返回，即为partitionid（getPartition返回值）。**

getPartition查找某个元素应该所属的partitionid时，如果partition数量过大，会采取二分查找。   
源代码中为了避免抽样数量少于partition数量，也采取了相对应的措施。


## （3）GridPartitioner ##

除了上述两个子类，Partitioner的子类还有：mllib中的GridPartitioner（org.apache.spark.mllib.linalg.distributed.GridPartitioner），是一个网格Partitioner，采用了规则的网格划分坐标。   
numPartitions等于行和列的partitioners之积：

  	override val numPartitions: Int = rowPartitions * colPartitions	
根据（i,j）获取partition的id：

	  private def getPartitionId(i: Int, j: Int): Int = {
	    require(0 <= i && i < rows, s"Row index $i out of range [0, $rows).")
	    require(0 <= j && j < cols, s"Column index $j out of range [0, $cols).")
	    i / rowsPerPart + j / colsPerPart * rowPartitions
	  }

## PartitionIdPassthrough ##
还有：PartitionIdPassthrough（org.apache.spark.sql.execution.PartitionIdPassthrough），是一个虚拟的partitioner，这些partition的id已经提前计算好了，所以直接返回。

	/**
	 * A dummy partitioner for use with records whose partition ids have been pre-computed (i.e. for
	 * use on RDDs of (Int, Row) pairs where the Int is a partition id in the expected range).
	 */
	private class PartitionIdPassthrough(override val numPartitions: Int) extends Partitioner {
	  override def getPartition(key: Any): Int = key.asInstanceOf[Int]
	}

## ReferencePartitioner ##
除了spark源码中，spark上层的系统也有partitioner类的子类，比如Adam系统中的：ReferencePartitioner（org.bdgenomics.adam.rdd.ReferencePartitioner），ReferencePartitioner主要是根据参考位置或者参考域进行划分，划分一句是referenceName。

## GenomicPositionPartitioner和GenomicRegionPartitioner ##
Adam中还有：
GenomicPositionPartitioner（org.bdgenomics.adam.rdd.GenomicPositionPartitioner）和GenomicRegionPartitioner（org.bdgenomics.adam.rdd.GenomicRegionPartitioner）   
这两个partitioner主要是将ReferencePosition对象划分到分开的，物理位置相关的基因组位置。这样主要是方便基因数据可以根据空间分布进行划分，然后进行计算。


# 2.代码： #

自己写的Partitioner：主要对url的数据进行划分，按域名来，如果域名相同，则hashCode相同。
比如"https://github.com/xubo245/SparkLearning"和"https://github.com/xubo245"网址不同但域名相同，但想划分到一个Partition中，于是可以改写getPartition的数量

	package org.apache.spark.sourceCode.partitionerLearning
	
	import org.apache.spark.Partitioner
	
	/**
	  * Created by xubo on 2016/10/8.
	  */
	class URLHashPartitioner(numParts: Int) extends Partitioner {
	  override def numPartitions: Int = numParts
	
	  override def getPartition(key: Any): Int = {
	    val domain = new java.net.URL(key.toString).getHost()
	    val code = (domain.hashCode % numPartitions)
	    if (code < 0) {
	      code + numPartitions
	    } else {
	      code
	    }
	  }
	
	  override def equals(other: Any): Boolean = other match {
	    case url: URLHashPartitioner =>
	      url.numPartitions == numPartitions
	    case _ =>
	      false
	  }
	
	  override def hashCode: Int = numPartitions
	}
	
	object URLHashPartitioner {
	  def main(args: Array[String]) {
	
	  }
	}

测试代码：

	package org.apache.spark.sourceCode.partitionerLearning
	
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/10/8.
	  */
	class PartitionerTest extends SparkLearningFunSuite {
	  test("URLHashPartitioner") {
	    var url1 = new URLHashPartitioner(20)
	    var partition1 = url1.getPartition("https://github.com/xubo245/SparkLearning")
	    var partition2 = url1.getPartition("https://github.com/xubo245")
	    println(partition1)
	    println(partition2)
	  }
	}

SparkLearningFunSuite主要是方便测试，可以在参考【3】中看到源码

3.结果：

	14
	14

参考中【7】描述的比较详细，背景也介绍的很好，建议多参考。

参考

	【1】http://spark.apache.org/
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:《深入理解spark核心思想与源码分析》
    【5】book:《spark核心源码分析和开发实战》
	【6】https://www.iteblog.com/archives/1368
	【7】https://www.iteblog.com/archives/1522
	【8】https://www.iteblog.com/archives/1525
	【9】http://www.cnblogs.com/xudong-bupt/p/4053652.html
