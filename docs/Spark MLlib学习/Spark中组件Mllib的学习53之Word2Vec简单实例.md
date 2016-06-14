
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

	word2vec是NLP领域的重要算法，它的功能是将word用K维的dense vector来表达，训练集是语料库，不含标点，以空格断句。因此可以看作是种特征处理方法。
	
	主要优点：
	
	    加法操作。
	    高效。单机可处理1小时2千万词。



![](http://images0.cnblogs.com/blog2015/679630/201506/181709121708170.png)


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
	class word2VecSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	    import org.apache.spark._
	    import org.apache.spark.rdd._
	    import org.apache.spark.SparkContext._
	    import org.apache.spark.mllib.feature.{Word2Vec, Word2VecModel}
	
	    val input = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/text8").map(line => line.split(" ").toSeq)
	    //java.lang.OutOfMemoryError: Java heap space
	
	
	    //    val input = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/a.txt").map(line => line.split(" ").toSeq)
	
	    val word2vec = new Word2Vec()
	
	    val model = word2vec.fit(input)
	
	    val synonyms = model.findSynonyms("china", 1)
	    //    val synonyms = model.findSynonyms("hello", 2)
	    //    val synonyms = model.findSynonyms("hell", 2)
	    println("synonyms:" + synonyms.length)
	    for ((synonym, cosineSimilarity) <- synonyms) {
	      println(s"$synonym $cosineSimilarity")
	    }
	
	    // Save and load model
	    //    model.save(sc, "myModelPath")
	    //    val sameModel = Word2VecModel.load(sc, "myModelPath")
	
	  }
	
	  test("testFunSuite ,code From book by pk") {
	
	    import org.apache.spark.mllib.feature.Word2Vec
	
	    //        val input = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/text8").map(line => line.split(" ").toSeq)
	    //java.lang.OutOfMemoryError: Java heap space
	    val data = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/aWord2vec.txt").map(line => line.split(" ").toSeq)
	
	
	    val word2vec = new Word2Vec() //创建词向量实例
	    val model = word2vec.fit(data) //训练模型
	    println(model.getVectors) //打印向量模型
	    val synonyms = model.findSynonyms("spark", 1) //寻找spar的相似词
	    println("synonyms:" + synonyms.length)
	    for (synonym <- synonyms) {
	      //打印找到的内容
	      println(synonym)
	    }
	  }
	}



3.结果：

	Map(hello -> [F@21cab9e, spark -> [F@28471327)
	synonyms:1
	(hello,-8.927243828523911E-4)

前面一个spark官网的test由于报内存不足，所以没有放上来。

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
	【6】http://www.cnblogs.com/aezero/p/4586605.html
