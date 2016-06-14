
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

GaussianMixture可以理解为多个高斯函数进行混合，每个高斯函数权重不一样。

源码分析请见【4】



2.代码：
	
	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.clustering.GaussianMixture
	
	import java.text.SimpleDateFormat
	import java.util.Date
	
	import org.apache.spark.mllib.clustering.{GaussianMixture, GaussianMixtureModel}
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class GaussianMixtureSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	    // Load and parse the data
	    val data = sc.textFile("file/data/mllib/input/mllibFromSpark/gmm_data.txt")
	    val parsedData = data.map(s => Vectors.dense(s.trim.split(' ').map(_.toDouble))).cache()
	
	    // Cluster the data into two classes using GaussianMixture
	    val gmm = new GaussianMixture().setK(2).run(parsedData)
	
	    // Save and load model
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    val output = "file/data/mllib/output/mllibFromSpark/myGMMModel" + iString
	    println("output:" + output)
	    println("gmm.weights:" + gmm.weights)
	    println("gmm.weights:" + gmm.weights)
	    println("gmm.weights.length:" + gmm.weights.length)
	
	    //    gmm.save(sc, output)
	    //    val sameModel = GaussianMixtureModel.load(sc, output)
	
	    // output parameters of max-likelihood model
	    for (i <- 0 until gmm.k) {
	      println("weight=%f\nmu=%s\nsigma=\n%s\n" format
	        (gmm.weights(i), gmm.gaussians(i).mu, gmm.gaussians(i).sigma))
	    }
	  }
	}



3.结果：
k=2：

	output:file/data/mllib/output/mllibFromSpark/myGMMModel20160613172124714
	gmm.weights:[D@76556aff
	gmm.weights.length:2
	weight=0.479516
	mu=[0.07229334132596348,0.016699872146612848]
	sigma=
	4.787456829778775   1.8802887426093131  
	1.8802887426093131  0.9160786892956797  
	
	weight=0.520484
	mu=[-0.10418516009966565,0.04279316009103921]
	sigma=
	4.899755775046639   -2.002791396537124  
	-2.002791396537124  1.0099533766097555  


k=3:

	output:file/data/mllib/output/mllibFromSpark/myGMMModel20160613173058582
	gmm.weights:[D@63f7f62
	gmm.weights.length:3
	weight=0.478456
	mu=[0.07294229123698849,0.016880200460870468]
	sigma=
	4.799622783996325  1.884861638240691   
	1.884861638240691  0.9186484216430504  
	
	weight=0.352254
	mu=[-0.016078882202045494,-0.09041925014095285]
	sigma=
	4.214865453249383   -1.679616942501954  
	-1.679616942501954  0.8180392275099243  
	
	weight=0.169290
	mu=[-0.2882428708757841,0.31930454247949075]
	sigma=
	6.239284901444058    -2.5886021455230255  
	-2.5886021455230255  1.288079844267794   



参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://blog.csdn.net/notheory/article/details/50219451
