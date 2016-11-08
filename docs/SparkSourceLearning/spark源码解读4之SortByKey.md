
更多代码请见：https://github.com/xubo245/SparkLearning

spark源码解读系列环境：spark-2.0.1 （20161103github下载版）

# 1.理解 #

## 1.1 需求 ##
使用spark的时候会经常使用sortBykey，比如wordCount后需要排序，可以使用sortBy，也可以先map然后再sortByKey，soerBy也是调用SortByKey

## 1.2 源码  ##
SortByKey：org.apache.spark.rdd.OrderedRDDFunctions#sortByKey

	  /**
	   * Sort the RDD by key, so that each partition contains a sorted range of the elements. Calling
	   * `collect` or `save` on the resulting RDD will return or output an ordered list of records
	   * (in the `save` case, they will be written to multiple `part-X` files in the filesystem, in
	   * order of the keys).
	   */
	  // TODO: this currently doesn't work on P other than Tuple2!
	  def sortByKey(ascending: Boolean = true, numPartitions: Int = self.partitions.length)
	      : RDD[(K, V)] = self.withScope
	  {
	    val part = new RangePartitioner(numPartitions, self, ascending)
	    new ShuffledRDD[K, V, V](self, part)
	      .setKeyOrdering(if (ascending) ordering else ordering.reverse)
	  }

sortBy：org.apache.spark.rdd.RDD#sortBy

	  /**
	   * Return this RDD sorted by the given key function.
	   */
	  def sortBy[K](
	      f: (T) => K,
	      ascending: Boolean = true,
	      numPartitions: Int = this.partitions.length)
	      (implicit ord: Ordering[K], ctag: ClassTag[K]): RDD[T] = withScope {
	    this.keyBy[K](f)
	        .sortByKey(ascending, numPartitions)
	        .values
	  }

## 1.3 分析 ##
### 1.3.1 sortByKey之数据partitioner类RangePartitioner ###
sortByKey使用了RangePartitioner，这个在前面的博文“spark源码解读1之Partitioner”中已经有初步分析。RangePartitioner能很大程度上避免hash出现数据的数据分布不均匀的情况

RangePartitioner会在determineBounds对边界进行排序，用的是scala.collection.SeqLike#sorted  ，调用的是java.util.Arrays#sort(T[], java.util.Comparator<? super T>)：

    public static <T> void sort(T[] a, Comparator<? super T> c) {
        if (LegacyMergeSort.userRequested)
            legacyMergeSort(a, c);
        else
            TimSort.sort(a, c);
    }

默认使用的是TimSort，一种java 7加入的新的排序算法，之前使用的是传统的归并排序。

TimSort使用的归并排序和binary insertion sort的结合，并且根据具体的数据特征确定runLength，更加高效，但也有人形式化分析会有bug：https://www.zhihu.com/question/28352462

TimSort下次再具体分析。

### 1.3.2 ShuffleRDD###
 new ShuffledRDD并且返回，即为排序好的soetByKey的结果

1.3.2.1  partitions_属性
 new ShuffledRDD的数据存储在partitions_属性中，这个继承自父类RDD，final方法partitions会给partitions_赋值，调用的是getPartitions方法，然后zipWithIndex

partitions源码：

	  final def partitions: Array[Partition] = {
	    checkpointRDD.map(_.partitions).getOrElse {
	      if (partitions_ == null) {
	        partitions_ = getPartitions
	        partitions_.zipWithIndex.foreach { case (partition, index) =>
	          require(partition.index == index,
	            s"partitions($index).partition == ${partition.index}, but it should equal $index")
	        }
	      }
	      partitions_
	    }
	  }

1.3.2.2  getPartitions方法

getPartitions在ShuffledRDD重写了：

	 override def getPartitions: Array[Partition] = {
	    Array.tabulate[Partition](part.numPartitions)(i => new ShuffledRDDPartition(i))
	  }

part.numPartitions实际为1.3.1中传入的RangePartitioner的属性：

	def numPartitions: Int = rangeBounds.length + 1

而rangeBounds则是用水塘抽样算法（Reservoir Sampling）建立的边界范围，

	 1 = 632826677
	 0 = -841013005
	rangeBounds = {int[2]@5390} 

getPartitions后是确定RDD的partition数量和index

只有当进行取数操作时，比如top（k）然后显示，数据才会划分到partitions_的每个values下

debug数据copy：

	"WrappedArray$ofRef" size = 333
	values = {WrappedArray$ofRef@5956} "WrappedArray$ofRef" size = 333
	 0 = {Tuple2$mcII$sp@7560} "(-1813557161,-1212512531)"
	 1 = {Tuple2$mcII$sp@7561} "(-1144323740,933490971)"
	 2 = {Tuple2$mcII$sp@7562} "(-12508600,-329995331)"
	 3 = {Tuple2$mcII$sp@7563} "(-1570574142,-743284380)"
	 5 = {Tuple2$mcII$sp@7565} "(-532362478,1106605038)"
	 4 = {Tuple2$mcII$sp@7564} "(249668146,-1487774671)"
	 6 = {Tuple2$mcII$sp@7566} "(-146176592,666226908)"

本地debug的代码是：

	  test("large array") {
	    val rand = new scala.util.Random()
	    val pairArr = Array.fill(1000) {
	      (rand.nextInt(), rand.nextInt())
	    }
	    val pairs = sc.parallelize(pairArr, 3)
	    val sorted = pairs.sortByKey()
	    sorted.count()
	    sorted.top(3).foreach(println)
	    assert(sorted.partitions.size === 3)
	    assert(sorted.collect() === pairArr.sortBy(_._1))
	  }

ShuffledRDD的partitions_对应的是三个ParallelCollectionPartition，这个是RDD的依赖关系得到的，ParallelCollectionPartition类重写了getPartitions方法，所以

	  override def getPartitions: Array[Partition] = {
	    val slices = ParallelCollectionRDD.slice(data, numSlices).toArray
	    slices.indices.map(i => new ParallelCollectionPartition(id, i, slices(i))).toArray
	  }

里面partition 的排序方法没找到，不知道逻辑，需要后续去学习RDD和DAG、Stage等代码。

# 2.代码： #

sortByKey使用：org.apache.spark.rdd.SortingSuite

	  test("sortByKey") {
	    val pairs = sc.parallelize(Array((1, 0), (2, 0), (0, 0), (3, 0)), 2)
	    assert(pairs.sortByKey().collect() === Array((0, 0), (1, 0), (2, 0), (3, 0)))
	  }

sortBy：org.apache.spark.rdd.RDDSuite

	 test("sortBy") {
	    val data = sc.parallelize(Seq("5|50|A", "4|60|C", "6|40|B"))
	
	    val col1 = Array("4|60|C", "5|50|A", "6|40|B")
	    val col2 = Array("6|40|B", "5|50|A", "4|60|C")
	    val col3 = Array("5|50|A", "6|40|B", "4|60|C")
	
	    assert(data.sortBy(_.split("\\|")(0)).collect() === col1)
	    assert(data.sortBy(_.split("\\|")(1)).collect() === col2)
	    assert(data.sortBy(_.split("\\|")(2)).collect() === col3)
	  }


# 3.结果： #

3.1 TimSort有待学习   
3.2 RangePartitioner只是确定numPartitions和getPartition(key: Any)，partition内部如何排序没有看到

参考

	【1】http://spark.apache.org/
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:《深入理解spark核心思想与源码分析》
    【5】book:《spark核心源码分析和开发实战》
	【6】http://blog.csdn.net/u014393917/article/details/50602047
