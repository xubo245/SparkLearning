
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释


![](http://i.imgur.com/iX6xZ1w.png)
![](http://i.imgur.com/WHgsjX8.png)

2.代码：
	
	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.EvaluationMetrics
	
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class MultilabelClassificationFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	
	    import org.apache.spark.mllib.evaluation.MultilabelMetrics
	    import org.apache.spark.rdd.RDD;
	
	    val scoreAndLabels: RDD[(Array[Double],Array[Double])] = sc.parallelize(
	      Seq((Array(0.0, 1.0), Array(0.0, 2.0)), (Array(0.0, 2.0), Array(0.0, 1.0)),
	      (Array(), Array(0.0)),
	      (Array(2.0), Array(2.0)),
	      (Array(2.0, 0.0), Array(2.0, 0.0)),
	      (Array(0.0, 1.0, 2.0), Array(0.0, 1.0)), (Array(1.0), Array(1.0, 2.0))), 2)
	
	    // Instantiate metrics object
	    val metrics = new MultilabelMetrics(scoreAndLabels)
	
	    // Summary stats
	    println(s"Recall = ${metrics.recall}")
	    println(s"Precision = ${metrics.precision}")
	    println(s"F1 measure = ${metrics.f1Measure}")
	    println(s"Accuracy = ${metrics.accuracy}")
	
	    // Individual label stats
	    metrics.labels.foreach(label => println(s"Class $label precision = ${metrics.precision(label)}"))
	    metrics.labels.foreach(label => println(s"Class $label recall = ${metrics.recall(label)}"))
	    metrics.labels.foreach(label => println(s"Class $label F1-score = ${metrics.f1Measure(label)}"))
	
	    // Micro stats
	    println(s"Micro recall = ${metrics.microRecall}")
	    println(s"Micro precision = ${metrics.microPrecision}")
	    println(s"Micro F1 measure = ${metrics.microF1Measure}")
	
	    // Hamming loss
	    println(s"Hamming loss = ${metrics.hammingLoss}")
	
	    // Subset accuracy
	    println(s"Subset accuracy = ${metrics.subsetAccuracy}")
	
	
	  }
	}



3.结果：

	Recall = 0.6428571428571429
	Precision = 0.6666666666666666
	F1 measure = 0.6380952380952382
	Accuracy = 0.5476190476190476
	Class 0.0 precision = 1.0
	Class 1.0 precision = 0.6666666666666666
	Class 2.0 precision = 0.5
	Class 0.0 recall = 0.8
	Class 1.0 recall = 0.6666666666666666
	Class 2.0 recall = 0.5
	Class 0.0 F1-score = 0.888888888888889
	Class 1.0 F1-score = 0.6666666666666666
	Class 2.0 F1-score = 0.5
	Micro recall = 0.6666666666666666
	Micro precision = 0.7272727272727273
	Micro F1 measure = 0.6956521739130435
	Hamming loss = 0.3333333333333333
	Subset accuracy = 0.2857142857142857

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
