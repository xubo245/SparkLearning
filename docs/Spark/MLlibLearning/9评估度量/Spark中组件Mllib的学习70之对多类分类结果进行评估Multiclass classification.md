
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

对多分类结果进行评估

![](http://i.imgur.com/uB5zk5z.png)
![](http://i.imgur.com/TwJs11O.png)



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
	class MulticlassClassificationFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	
	    import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS
	    import org.apache.spark.mllib.evaluation.MulticlassMetrics
	    import org.apache.spark.mllib.regression.LabeledPoint
	    import org.apache.spark.mllib.util.MLUtils
	
	    // Load training data in LIBSVM format
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_multiclass_classification_data.txt")
	
	    // Split data into training (60%) and test (40%)
	    val Array(training, test) = data.randomSplit(Array(0.6, 0.4), seed = 11L)
	    training.cache()
	
	    // Run training algorithm to build the model
	    val model = new LogisticRegressionWithLBFGS()
	      .setNumClasses(3)
	      .run(training)
	
	    // Compute raw scores on the test set
	    val predictionAndLabels = test.map { case LabeledPoint(label, features) =>
	      val prediction = model.predict(features)
	      (prediction, label)
	    }
	
	    // Instantiate metrics object
	    val metrics = new MulticlassMetrics(predictionAndLabels)
	
	    // Confusion matrix
	    println("Confusion matrix:")
	    println(metrics.confusionMatrix)
	
	    // Overall Statistics
	    val precision = metrics.precision
	    val recall = metrics.recall // same as true positive rate
	    val f1Score = metrics.fMeasure
	    println("Summary Statistics")
	    println(s"Precision = $precision")
	    println(s"Recall = $recall")
	    println(s"F1 Score = $f1Score")
	
	    // Precision by label
	    val labels = metrics.labels
	    labels.foreach { l =>
	      println(s"Precision($l) = " + metrics.precision(l))
	    }
	
	    // Recall by label
	    labels.foreach { l =>
	      println(s"Recall($l) = " + metrics.recall(l))
	    }
	
	    // False positive rate by label
	    labels.foreach { l =>
	      println(s"FPR($l) = " + metrics.falsePositiveRate(l))
	    }
	
	    // F-measure by label
	    labels.foreach { l =>
	      println(s"F1-Score($l) = " + metrics.fMeasure(l))
	    }
	
	    // Weighted stats
	    println(s"Weighted precision: ${metrics.weightedPrecision}")
	    println(s"Weighted recall: ${metrics.weightedRecall}")
	    println(s"Weighted F1 score: ${metrics.weightedFMeasure}")
	    println(s"Weighted false positive rate: ${metrics.weightedFalsePositiveRate}")
	
	
	  }
	}


3.结果：

	Confusion matrix:
	11.0  0.0   1.0   
	0.0   12.0  0.0   
	10.0  0.0   16.0  
	Summary Statistics
	Precision = 0.78
	Recall = 0.78
	F1 Score = 0.78
	Precision(0.0) = 0.5238095238095238
	Precision(1.0) = 1.0
	Precision(2.0) = 0.9411764705882353
	Recall(0.0) = 0.9166666666666666
	Recall(1.0) = 1.0
	Recall(2.0) = 0.6153846153846154
	FPR(0.0) = 0.2631578947368421
	FPR(1.0) = 0.0
	FPR(2.0) = 0.041666666666666664
	F1-Score(0.0) = 0.6666666666666667
	F1-Score(1.0) = 1.0
	F1-Score(2.0) = 0.744186046511628
	Weighted precision: 0.8551260504201681
	Weighted recall: 0.78
	Weighted F1 score: 0.7869767441860466
	Weighted false positive rate: 0.08482456140350877
	


参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
