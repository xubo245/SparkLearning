更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之基础概念篇   
1解释  
分层抽样的概念就不讲了，具体的操作：  
RDD有个操作可以直接进行抽样：sampleByKey和sample等，这里主要介绍这两个  
（1）将字符串长度为2划分为层1和层2，对层1和层2按不同的概率进行抽样  
数据  

	```
	aa
	bb
	cc
	dd
	ee
	aaa
	bbb
	ccc
	ddd
	eee
	```
比如：  
val fractions: Map[Int, Double] = (List((1, 0.2), (2, 0.8))).toMap //设定抽样格式  
sampleByKey(withReplacement = false, fractions, 0)  
fractions表示在层1抽0.2，在层2中抽0.8  
withReplacement false表示不重复抽样  
0表示随机的seed  

源码：
	
	```
	  /**
	   * Return a subset of this RDD sampled by key (via stratified sampling).
	   *
	   * Create a sample of this RDD using variable sampling rates for different keys as specified by
	   * `fractions`, a key to sampling rate map, via simple random sampling with one pass over the
	   * RDD, to produce a sample of size that's approximately equal to the sum of
	   * math.ceil(numItems * samplingRate) over all key values.
	   *
	   * @param withReplacement whether to sample with or without replacement
	   * @param fractions map of specific keys to sampling rates
	   * @param seed seed for the random number generator
	   * @return RDD containing the sampled subset
	   */
	  def sampleByKey(withReplacement: Boolean,
	      fractions: Map[K, Double],
	      seed: Long = Utils.random.nextLong): RDD[(K, V)] = self.withScope {
	
	    require(fractions.values.forall(v => v >= 0.0), "Negative sampling rates.")
	
	    val samplingFunc = if (withReplacement) {
	      StratifiedSamplingUtils.getPoissonSamplingFunction(self, fractions, false, seed)
	    } else {
	      StratifiedSamplingUtils.getBernoulliSamplingFunction(self, fractions, false, seed)
	    }
	    self.mapPartitionsWithIndex(samplingFunc, preservesPartitioning = true)
	  }
	```

（2）和（3）类似，请看代码


2.代码：
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.basic
	
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object StratifiedSamplingLearning {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	    println("First:")
	    val data = sc.textFile("file/data/mllib/input/basic/StratifiedSampling.txt") //读取数
	      .map(row => {
	      //开始处理
	      if (row.length == 3) //判断字符数
	        (row, 1) //建立对应map
	      else (row, 2) //建立对应map
	    }).map(each => (each._2, each._1))
	    data.foreach(println)
	    println("sampleByKey:")
	    val fractions: Map[Int, Double] = (List((1, 0.2), (2, 0.8))).toMap //设定抽样格式
	    val approxSample = data.sampleByKey(withReplacement = false, fractions, 0) //计算抽样样本
	    approxSample.foreach(println)
	
	    println("Second:")
	    //http://homepage.cs.latrobe.edu.au/zhe/ZhenHeSparkRDDAPIExamples.html#sampleByKey
	    val randRDD = sc.parallelize(List((7, "cat"), (6, "mouse"), (7, "cup"), (6, "book"), (7, "tv"), (6, "screen"), (7, "heater")))
	    val sampleMap = List((7, 0.4), (6, 0.8)).toMap
	    val sample2 = randRDD.sampleByKey(false, sampleMap, 42).collect
	    sample2.foreach(println)
	
	    println("Third:")
	    //http://bbs.csdn.net/topics/390953396
	    val a = sc.parallelize(1 to 20, 3)
	    val b = a.sample(true, 0.8, 0)
	    val c = a.sample(false, 0.8, 0)
	    println("RDD a : " + a.collect().mkString(" , "))
	    println("RDD b : " + b.collect().mkString(" , "))
	    println("RDD c : " + c.collect().mkString(" , "))
	    sc.stop
	  }
	}
	
	```

3.结果：
	
	```
	First:
	2016-05-23 22:37:34 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:482:722f:5976:ce1f%20, but we couldn't find any external IP address!
	(2,aa)
	(1,bbb)
	(2,bb)
	(1,ccc)
	(2,cc)
	(1,ddd)
	(2,dd)
	(1,eee)
	(2,ee)
	(1,aaa)
	sampleByKey:
	(2,aa)
	(2,bb)
	(2,cc)
	(2,ee)
	Second:
	(7,cat)
	(6,mouse)
	(6,book)
	(6,screen)
	(7,heater)
	Third:
	RDD a : 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13 , 14 , 15 , 16 , 17 , 18 , 19 , 20
	RDD b : 2 , 4 , 5 , 6 , 10 , 14 , 19 , 20
	RDD c : 1 , 2 , 4 , 5 , 8 , 10 , 12 , 13 , 14 , 15 , 16 , 17 , 18 , 19 , 20
	```

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning