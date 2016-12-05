
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

L-BFGS的概念请参考【6】



2.代码：
	
	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.Optimization
	
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class LBFGSFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	
	    import org.apache.spark.SparkContext
	    import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
	    import org.apache.spark.mllib.linalg.Vectors
	    import org.apache.spark.mllib.util.MLUtils
	    import org.apache.spark.mllib.classification.LogisticRegressionModel
	    import org.apache.spark.mllib.optimization.{LBFGS, LogisticGradient, SquaredL2Updater}
	
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_libsvm_data.txt")
	    val numFeatures = data.take(1)(0).features.size
	
	    // Split data into training (60%) and test (40%).
	    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)
	
	    // Append 1 into the training data as intercept.
	    val training = splits(0).map(x => (x.label, MLUtils.appendBias(x.features))).cache()
	
	    val test = splits(1)
	
	    // Run training algorithm to build the model
	    val numCorrections = 10
	    val convergenceTol = 1e-4
	    val maxNumIterations = 20
	    val regParam = 0.1
	    val initialWeightsWithIntercept = Vectors.dense(new Array[Double](numFeatures + 1))
	
	    val (weightsWithIntercept, loss) = LBFGS.runLBFGS(
	      training,
	      new LogisticGradient(),
	      new SquaredL2Updater(),
	      numCorrections,
	      convergenceTol,
	      maxNumIterations,
	      regParam,
	      initialWeightsWithIntercept)
	
	    val model = new LogisticRegressionModel(
	      Vectors.dense(weightsWithIntercept.toArray.slice(0, weightsWithIntercept.size - 1)),
	      weightsWithIntercept(weightsWithIntercept.size - 1))
	
	    // Clear the default threshold.
	    model.clearThreshold()
	
	    // Compute raw scores on the test set.
	    val scoreAndLabels = test.map { point =>
	      val score = model.predict(point.features)
	      (score, point.label)
	    }
	
	    // Get evaluation metrics.
	    val metrics = new BinaryClassificationMetrics(scoreAndLabels)
	    val auROC = metrics.areaUnderROC()
	
	    println("Loss of each step in training process")
	    loss.foreach(println)
	    println("Area under ROC = " + auROC)
	
	
	  }
	}



3.结果：

	Loss of each step in training process
	0.6931471805599448
	0.6493820266740578
	0.21500294643532605
	0.0021993980987416607
	5.202713917046544E-4
	3.4927255641289994E-4
	1.888143055954077E-4
	1.2596418162046915E-4
	9.190860508937821E-5
	7.563586578488929E-5
	6.752517240852286E-5
	6.361011786413444E-5
	6.141097383991715E-5
	5.932972379127243E-5
	5.554554457038146E-5
	4.480277717224111E-5
	3.240944275555446E-5
	3.0444586625324565E-5
	Area under ROC = 1.0

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
	【6】https://github.com/endymecy/spark-ml-source-analysis/blob/master/%E6%9C%80%E4%BC%98%E5%8C%96%E7%AE%97%E6%B3%95/L-BFGS/lbfgs.md
	 
