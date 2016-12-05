
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

TF-IDF(Term frequency-inverse document frequency ) 是文本挖掘中一种广泛使用的特征向量化方法。TF-IDF反映了语料中单词对文档的重要程度。假设单词用t表示，文档用d表示，语料用D表示，那么文档频度DF(t, D)是包含单词t的文档数。如果我们只是使用词频度量重要性，就会很容易过分强调重负次数多但携带信息少的单词，例如：”a”, “the”以及”of”。如果某个单词在整个语料库中高频出现，意味着它没有携带专门针对某特殊文档的信息。逆文档频度(IDF)是单词携带信息量的数值度量。

TF-IDF的概念参考【4】中也讲的很详细，例子也很详细。




2.代码：

	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.FeatureExtractionAndTransformation
	
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class TFIDFSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	    import org.apache.spark.rdd.RDD
	    import org.apache.spark.SparkContext
	    import org.apache.spark.mllib.feature.HashingTF
	    import org.apache.spark.mllib.linalg.Vector
	
	    //    val sc: SparkContext = ...
	
	    // Load documents (one per line).
	    val documents: RDD[Seq[String]] = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/a.txt").map(_.split(" ").toSeq)
	
	    val hashingTF = new HashingTF()
	    val tf: RDD[Vector] = hashingTF.transform(documents)
	    println("tf:" + tf)
	    tf.foreach(println)
	    import org.apache.spark.mllib.feature.IDF
	
	    // ... continue from the previous example
	    tf.cache()
	    val idf = new IDF().fit(tf)
	    val tfidf: RDD[Vector] = idf.transform(tf)
	    //    println("idf:" + idf.idf)
	    //    idf.idf
	    println("tfidf:" + tfidf)
	    tfidf.foreach(println)
	    import org.apache.spark.mllib.feature.IDF
	
	    // ... continue from the previous example
	    //    tf.cache()
	    val idf2 = new IDF(minDocFreq = 2).fit(tf)
	    val tfidf2: RDD[Vector] = idf2.transform(tf)
	    //    println("idf2:" + idf2.idf)
	    //    tf.foreach(println)
	    println("tfidf2:" + tfidf2)
	    tfidf2.foreach(println)
	  }
	}

第一次数据：

	hello scala
	goodbyr spark
	hello spark
	hello mllib
	spark
	goodbyr spark

第二次数据：

	hello scala hello scala hello scala hello
	goodbyr spark
	hello spark
	hello mllib
	spark
	goodbyr spark


3.结果：

第一次：
	
	tf:MapPartitionsRDD[3] at map at HashingTF.scala:78
	2016-06-13 21:40:33 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:482:722f:5976:ce1f%39, but we couldn't find any external IP address!
	(1048576,[179334,596178],[1.0,1.0])
	(1048576,[198982,596178],[1.0,1.0])
	(1048576,[586461],[1.0])
	(1048576,[452894,586461],[1.0,1.0])
	(1048576,[452894,586461],[1.0,1.0])
	(1048576,[586461,596178],[1.0,1.0])
	tfidf:MapPartitionsRDD[5] at mapPartitions at IDF.scala:182
	(1048576,[198982,596178],[1.252762968495368,0.5596157879354227])
	(1048576,[452894,586461],[0.8472978603872037,0.3364722366212129])
	(1048576,[586461,596178],[0.3364722366212129,0.5596157879354227])
	(1048576,[179334,596178],[1.252762968495368,0.5596157879354227])
	(1048576,[586461],[0.3364722366212129])
	(1048576,[452894,586461],[0.8472978603872037,0.3364722366212129])
	tfidf2:MapPartitionsRDD[7] at mapPartitions at IDF.scala:182
	(1048576,[198982,596178],[0.0,0.5596157879354227])
	(1048576,[452894,586461],[0.8472978603872037,0.3364722366212129])
	(1048576,[586461,596178],[0.3364722366212129,0.5596157879354227])
	(1048576,[179334,596178],[0.0,0.5596157879354227])
	(1048576,[586461],[0.3364722366212129])
	(1048576,[452894,586461],[0.8472978603872037,0.3364722366212129])

第二次：
	
	tf:MapPartitionsRDD[3] at map at HashingTF.scala:78
	2016-06-13 21:51:20 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:482:722f:5976:ce1f%39, but we couldn't find any external IP address!
	(1048576,[198982,596178],[3.0,4.0])
	(1048576,[586461,596178],[1.0,1.0])
	(1048576,[452894,586461],[1.0,1.0])
	(1048576,[179334,596178],[1.0,1.0])
	(1048576,[586461],[1.0])
	(1048576,[452894,586461],[1.0,1.0])
	idf:1048576
	tfidf:MapPartitionsRDD[5] at mapPartitions at IDF.scala:182
	(1048576,[198982,596178],[3.758288905486104,2.2384631517416906])
	(1048576,[452894,586461],[0.8472978603872037,0.3364722366212129])
	(1048576,[586461,596178],[0.3364722366212129,0.5596157879354227])
	(1048576,[179334,596178],[1.252762968495368,0.5596157879354227])
	(1048576,[586461],[0.3364722366212129])
	(1048576,[452894,586461],[0.8472978603872037,0.3364722366212129])
	idf2:1048576
	tfidf2:MapPartitionsRDD[7] at mapPartitions at IDF.scala:182
	(1048576,[198982,596178],[0.0,2.2384631517416906])
	(1048576,[452894,586461],[0.8472978603872037,0.3364722366212129])
	(1048576,[586461,596178],[0.3364722366212129,0.5596157879354227])
	(1048576,[179334,596178],[0.0,0.5596157879354227])
	(1048576,[586461],[0.3364722366212129])
	(1048576,[452894,586461],[0.8472978603872037,0.3364722366212129])

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
	【6】http://www.fuqingchuan.com/2015/03/643.html#tf-idf
