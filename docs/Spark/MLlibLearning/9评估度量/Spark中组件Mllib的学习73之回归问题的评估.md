
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

Regression model evaluation
![](http://i.imgur.com/uxyr2kb.png)

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
	class RegressionModelEvaluationFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	
	    import org.apache.spark.mllib.regression.LabeledPoint
	    import org.apache.spark.mllib.regression.LinearRegressionModel
	    import org.apache.spark.mllib.regression.LinearRegressionWithSGD
	    import org.apache.spark.mllib.linalg.Vectors
	    import org.apache.spark.mllib.evaluation.RegressionMetrics
	    import org.apache.spark.mllib.util.MLUtils
	
	    // Load the data
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_linear_regression_data.txt").cache()
	
	    // Build the model
	    val numIterations = 100
	    val model = LinearRegressionWithSGD.train(data, numIterations)
	
	    // Get predictions
	    val valuesAndPreds = data.map{ point =>
	      val prediction = model.predict(point.features)
	      (prediction, point.label)
	    }
	
	    // Instantiate metrics object
	    val metrics = new RegressionMetrics(valuesAndPreds)
	
	    // Squared error
	    println(s"MSE = ${metrics.meanSquaredError}")
	    println(s"RMSE = ${metrics.rootMeanSquaredError}")
	
	    // R-squared
	    println(s"R-squared = ${metrics.r2}")
	
	    // Mean absolute error
	    println(s"MAE = ${metrics.meanAbsoluteError}")
	
	    // Explained variance
	    println(s"Explained variance = ${metrics.explainedVariance}")
	
	
	  }
	}
		


3.结果：

	MSE = 103.30968681818085
	RMSE = 10.164137288436281
	R-squared = 0.027639110967836777
	MAE = 8.148691907953307
	Explained variance = 2.888395201717894

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
