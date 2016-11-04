	
	更多代码请见：https://github.com/xubo245/SparkLearning
	
	Spark中组件Mllib的学习
	
1.解释
	
		对二分类的结果进行评估
	
	    True Positive (TP) - label is positive and prediction is also positive
	    True Negative (TN) - label is negative and prediction is also negative
	    False Positive (FP) - label is negative but prediction is positive
	    False Negative (FN) - label is positive but prediction is negative
	
	
	![](http://i.imgur.com/ozKmz9T.png)
	
	
	
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
		class BinaryClassificationFunSuite extends SparkLearningFunSuite {
		  test("testFunSuite") {
		
		
		    import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS
		    import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
		    import org.apache.spark.mllib.regression.LabeledPoint
		    import org.apache.spark.mllib.util.MLUtils
		
		    // Load training data in LIBSVM format
		    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_binary_classification_data.txt")
		
		    // Split data into training (60%) and test (40%)
		    val Array(training, test) = data.randomSplit(Array(0.6, 0.4), seed = 11L)
		    training.cache()
		
		    // Run training algorithm to build the model
		    val model = new LogisticRegressionWithLBFGS()
		      .setNumClasses(2)
		      .run(training)
		
		    // Clear the prediction threshold so the model will return probabilities
		    model.clearThreshold
		
		    // Compute raw scores on the test set
		    val predictionAndLabels = test.map { case LabeledPoint(label, features) =>
		      val prediction = model.predict(features)
		      (prediction, label)
		    }
		
		    // Instantiate metrics object
		    val metrics = new BinaryClassificationMetrics(predictionAndLabels)
		
		    // Precision by threshold
		    val precision = metrics.precisionByThreshold
		    precision.foreach { case (t, p) =>
		      println(s"Threshold: $t, Precision: $p")
		    }
		
		    // Recall by threshold
		    val recall = metrics.recallByThreshold
		    recall.foreach { case (t, r) =>
		      println(s"Threshold: $t, Recall: $r")
		    }
		
		    // Precision-Recall Curve
		    val PRC = metrics.pr
		
		    // F-measure
		    val f1Score = metrics.fMeasureByThreshold
		    f1Score.foreach { case (t, f) =>
		      println(s"Threshold: $t, F-score: $f, Beta = 1")
		    }
		
		    val beta = 0.5
		    val fScore = metrics.fMeasureByThreshold(beta)
		    f1Score.foreach { case (t, f) =>
		      println(s"Threshold: $t, F-score: $f, Beta = 0.5")
		    }
		
		    // AUPRC
		    val auPRC = metrics.areaUnderPR
		    println("Area under precision-recall curve = " + auPRC)
		
		    // Compute thresholds used in ROC and PR curves
		    val thresholds = precision.map(_._1)
		
		    // ROC Curve
		    val roc = metrics.roc
		
		    // AUROC
		    val auROC = metrics.areaUnderROC
		    println("Area under ROC = " + auROC)
		
		
		  }
		}
		
	
	
3.结果：
	
	Threshold: 0.9999999079591919, Precision: 1.0
	Threshold: 0.9999999999876286, Precision: 1.0
	Threshold: 0.9999998675651154, Precision: 1.0
	Threshold: 0.9999999999870894, Precision: 1.0
	Threshold: 0.9999998641357251, Precision: 1.0
	Threshold: 0.9999999999710736, Precision: 1.0
	Threshold: 0.9999997679097353, Precision: 1.0
	Threshold: 0.9999999999555567, Precision: 1.0
	Threshold: 0.9999997216281737, Precision: 1.0
	Threshold: 0.9999999999444416, Precision: 1.0
	Threshold: 0.9999994059976933, Precision: 1.0
	Threshold: 0.9999999999150586, Precision: 1.0
	Threshold: 0.9999986216854592, Precision: 1.0
	Threshold: 0.9999999975304283, Precision: 1.0
	Threshold: 0.9999891849269185, Precision: 1.0
	Threshold: 0.9999999970626474, Precision: 1.0
	Threshold: 0.02150801663469168, Precision: 0.9615384615384616
	Threshold: 0.999999995931889, Precision: 1.0
	Threshold: 0.9999999940968229, Precision: 1.0
	Threshold: 1.1765590077517976E-5, Precision: 0.9259259259259259
	Threshold: 0.9999999925440884, Precision: 1.0
	Threshold: 0.9999999917914727, Precision: 1.0
	Threshold: 9.941882509964225E-7, Precision: 0.8928571428571429
	Threshold: 0.9999999888515382, Precision: 1.0
	Threshold: 0.9999999869153129, Precision: 1.0
	Threshold: 2.8999966973540173E-7, Precision: 0.8620689655172413
	Threshold: 0.9999999612772754, Precision: 1.0
	Threshold: 0.9999999590978567, Precision: 1.0
	Threshold: 0.9999999157118056, Precision: 1.0
	Threshold: 2.7425346096972394E-7, Precision: 0.8333333333333334
	Threshold: 2.3309367465375773E-7, Precision: 0.8064516129032258
	Threshold: 3.4202198911005806E-8, Precision: 0.78125
	Threshold: 2.0448636806606493E-8, Precision: 0.7575757575757576
	Threshold: 9.963472192622139E-9, Precision: 0.7352941176470589
	Threshold: 7.825072495953635E-9, Precision: 0.7142857142857143
	Threshold: 6.297277292078781E-11, Precision: 0.6944444444444444
	Threshold: 0.9999999079591919, Recall: 0.72
	Threshold: 0.9999998675651154, Recall: 0.76
	Threshold: 0.9999998641357251, Recall: 0.8
	Threshold: 0.9999999999876286, Recall: 0.04
	Threshold: 0.9999997679097353, Recall: 0.84
	Threshold: 0.9999999999870894, Recall: 0.08
	Threshold: 0.9999997216281737, Recall: 0.88
	Threshold: 0.9999999999710736, Recall: 0.12
	Threshold: 0.9999994059976933, Recall: 0.92
	Threshold: 0.9999999999555567, Recall: 0.16
	Threshold: 0.9999986216854592, Recall: 0.96
	Threshold: 0.9999999999444416, Recall: 0.2
	Threshold: 0.9999891849269185, Recall: 1.0
	Threshold: 0.9999999999150586, Recall: 0.24
	Threshold: 0.02150801663469168, Recall: 1.0
	Threshold: 0.9999999975304283, Recall: 0.28
	Threshold: 0.9999999970626474, Recall: 0.32
	Threshold: 1.1765590077517976E-5, Recall: 1.0
	Threshold: 0.999999995931889, Recall: 0.36
	Threshold: 0.9999999940968229, Recall: 0.4
	Threshold: 9.941882509964225E-7, Recall: 1.0
	Threshold: 0.9999999925440884, Recall: 0.44
	Threshold: 0.9999999917914727, Recall: 0.48
	Threshold: 2.8999966973540173E-7, Recall: 1.0
	Threshold: 0.9999999888515382, Recall: 0.52
	Threshold: 0.9999999869153129, Recall: 0.56
	Threshold: 2.7425346096972394E-7, Recall: 1.0
	Threshold: 0.9999999612772754, Recall: 0.6
	Threshold: 0.9999999590978567, Recall: 0.64
	Threshold: 2.3309367465375773E-7, Recall: 1.0
	Threshold: 0.9999999157118056, Recall: 0.68
	Threshold: 3.4202198911005806E-8, Recall: 1.0
	Threshold: 2.0448636806606493E-8, Recall: 1.0
	Threshold: 9.963472192622139E-9, Recall: 1.0
	Threshold: 7.825072495953635E-9, Recall: 1.0
	Threshold: 6.297277292078781E-11, Recall: 1.0
	Threshold: 0.9999999999876286, F-score: 0.07692307692307693, Beta = 1
	Threshold: 0.9999999999870894, F-score: 0.14814814814814814, Beta = 1
	Threshold: 0.9999999999710736, F-score: 0.21428571428571425, Beta = 1
	Threshold: 0.9999999999555567, F-score: 0.2758620689655173, Beta = 1
	Threshold: 0.9999999999444416, F-score: 0.33333333333333337, Beta = 1
	Threshold: 0.9999999999150586, F-score: 0.3870967741935484, Beta = 1
	Threshold: 0.9999999975304283, F-score: 0.43750000000000006, Beta = 1
	Threshold: 0.9999999970626474, F-score: 0.48484848484848486, Beta = 1
	Threshold: 0.999999995931889, F-score: 0.5294117647058824, Beta = 1
	Threshold: 0.9999999940968229, F-score: 0.5714285714285715, Beta = 1
	Threshold: 0.9999999925440884, F-score: 0.6111111111111112, Beta = 1
	Threshold: 0.9999999917914727, F-score: 0.6486486486486487, Beta = 1
	Threshold: 0.9999999888515382, F-score: 0.6842105263157895, Beta = 1
	Threshold: 0.9999999869153129, F-score: 0.717948717948718, Beta = 1
	Threshold: 0.9999999612772754, F-score: 0.7499999999999999, Beta = 1
	Threshold: 0.9999999590978567, F-score: 0.7804878048780487, Beta = 1
	Threshold: 0.9999999157118056, F-score: 0.8095238095238095, Beta = 1
	Threshold: 0.9999999079591919, F-score: 0.8372093023255813, Beta = 1
	Threshold: 0.9999998675651154, F-score: 0.8636363636363636, Beta = 1
	Threshold: 0.9999998641357251, F-score: 0.888888888888889, Beta = 1
	Threshold: 0.9999997679097353, F-score: 0.9130434782608696, Beta = 1
	Threshold: 0.9999997216281737, F-score: 0.9361702127659575, Beta = 1
	Threshold: 0.9999994059976933, F-score: 0.9583333333333334, Beta = 1
	Threshold: 0.9999986216854592, F-score: 0.9795918367346939, Beta = 1
	Threshold: 0.9999891849269185, F-score: 1.0, Beta = 1
	Threshold: 0.02150801663469168, F-score: 0.9803921568627451, Beta = 1
	Threshold: 1.1765590077517976E-5, F-score: 0.9615384615384615, Beta = 1
	Threshold: 9.941882509964225E-7, F-score: 0.9433962264150945, Beta = 1
	Threshold: 2.8999966973540173E-7, F-score: 0.9259259259259259, Beta = 1
	Threshold: 2.7425346096972394E-7, F-score: 0.9090909090909091, Beta = 1
	Threshold: 2.3309367465375773E-7, F-score: 0.8928571428571428, Beta = 1
	Threshold: 3.4202198911005806E-8, F-score: 0.8771929824561403, Beta = 1
	Threshold: 2.0448636806606493E-8, F-score: 0.8620689655172413, Beta = 1
	Threshold: 9.963472192622139E-9, F-score: 0.8474576271186441, Beta = 1
	Threshold: 7.825072495953635E-9, F-score: 0.8333333333333333, Beta = 1
	Threshold: 6.297277292078781E-11, F-score: 0.819672131147541, Beta = 1
	Threshold: 0.9999999079591919, F-score: 0.8372093023255813, Beta = 0.5
	Threshold: 0.9999998675651154, F-score: 0.8636363636363636, Beta = 0.5
	Threshold: 0.9999998641357251, F-score: 0.888888888888889, Beta = 0.5
	Threshold: 0.9999997679097353, F-score: 0.9130434782608696, Beta = 0.5
	Threshold: 0.9999997216281737, F-score: 0.9361702127659575, Beta = 0.5
	Threshold: 0.9999994059976933, F-score: 0.9583333333333334, Beta = 0.5
	Threshold: 0.9999986216854592, F-score: 0.9795918367346939, Beta = 0.5
	Threshold: 0.9999891849269185, F-score: 1.0, Beta = 0.5
	Threshold: 0.02150801663469168, F-score: 0.9803921568627451, Beta = 0.5
	Threshold: 1.1765590077517976E-5, F-score: 0.9615384615384615, Beta = 0.5
	Threshold: 9.941882509964225E-7, F-score: 0.9433962264150945, Beta = 0.5
	Threshold: 2.8999966973540173E-7, F-score: 0.9259259259259259, Beta = 0.5
	Threshold: 2.7425346096972394E-7, F-score: 0.9090909090909091, Beta = 0.5
	Threshold: 2.3309367465375773E-7, F-score: 0.8928571428571428, Beta = 0.5
	Threshold: 0.9999999999876286, F-score: 0.07692307692307693, Beta = 0.5
	Threshold: 0.9999999999870894, F-score: 0.14814814814814814, Beta = 0.5
	Threshold: 0.9999999999710736, F-score: 0.21428571428571425, Beta = 0.5
	Threshold: 0.9999999999555567, F-score: 0.2758620689655173, Beta = 0.5
	Threshold: 0.9999999999444416, F-score: 0.33333333333333337, Beta = 0.5
	Threshold: 0.9999999999150586, F-score: 0.3870967741935484, Beta = 0.5
	Threshold: 0.9999999975304283, F-score: 0.43750000000000006, Beta = 0.5
	Threshold: 0.9999999970626474, F-score: 0.48484848484848486, Beta = 0.5
	Threshold: 0.999999995931889, F-score: 0.5294117647058824, Beta = 0.5
	Threshold: 0.9999999940968229, F-score: 0.5714285714285715, Beta = 0.5
	Threshold: 0.9999999925440884, F-score: 0.6111111111111112, Beta = 0.5
	Threshold: 0.9999999917914727, F-score: 0.6486486486486487, Beta = 0.5
	Threshold: 0.9999999888515382, F-score: 0.6842105263157895, Beta = 0.5
	Threshold: 0.9999999869153129, F-score: 0.717948717948718, Beta = 0.5
	Threshold: 3.4202198911005806E-8, F-score: 0.8771929824561403, Beta = 0.5
	Threshold: 2.0448636806606493E-8, F-score: 0.8620689655172413, Beta = 0.5
	Threshold: 0.9999999612772754, F-score: 0.7499999999999999, Beta = 0.5
	Threshold: 9.963472192622139E-9, F-score: 0.8474576271186441, Beta = 0.5
	Threshold: 0.9999999590978567, F-score: 0.7804878048780487, Beta = 0.5
	Threshold: 0.9999999157118056, F-score: 0.8095238095238095, Beta = 0.5
	Threshold: 7.825072495953635E-9, F-score: 0.8333333333333333, Beta = 0.5
	Threshold: 6.297277292078781E-11, F-score: 0.819672131147541, Beta = 0.5
	Area under precision-recall curve = 1.0
	Area under ROC = 1.0
	
	
参考
	
		【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
		【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
		【3】https://github.com/xubo245/SparkLearning
		【4】book:Machine Learning with Spark ,Nick Pertreach
	    【5】book:Spark MlLib机器学习实战
