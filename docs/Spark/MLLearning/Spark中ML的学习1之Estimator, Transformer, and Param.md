	
	更多代码请见：https://github.com/xubo245/SparkLearning
	
	Spark中组件Mllib的学习
	
1.解释
	
	Example: Estimator, Transformer, and Param
	
	创建dataFrame，然后进行参数设置，模型训练，转换等，最后可以进行预测
 	感觉比MLlib方便不少
	
2.代码：
	
	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.ml.MainConcepts
	
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class EstimatorTransformerAndParamFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	    import org.apache.spark.ml.classification.LogisticRegression
	    import org.apache.spark.ml.param.ParamMap
	    import org.apache.spark.mllib.linalg.{Vector, Vectors}
	    import org.apache.spark.sql.Row
	
	    // Prepare training data from a list of (label, features) tuples.
	    val training = sqlContext.createDataFrame(Seq(
	      (1.0, Vectors.dense(0.0, 1.1, 0.1)),
	      (0.0, Vectors.dense(2.0, 1.0, -1.0)),
	      (0.0, Vectors.dense(2.0, 1.3, 1.0)),
	      (1.0, Vectors.dense(0.0, 1.2, -0.5))
	    )).toDF("label", "features")
	
	    // Create a LogisticRegression instance.  This instance is an Estimator.
	    val lr = new LogisticRegression()
	    // Print out the parameters, documentation, and any default values.
	    println("LogisticRegression parameters:\n" + lr.explainParams() + "\n")
	
	    // We may set parameters using setter methods.
	    lr.setMaxIter(10)
	      .setRegParam(0.01)
	
	    // Learn a LogisticRegression model.  This uses the parameters stored in lr.
	    val model1 = lr.fit(training)
	    // Since model1 is a Model (i.e., a Transformer produced by an Estimator),
	    // we can view the parameters it used during fit().
	    // This prints the parameter (name: value) pairs, where names are unique IDs for this
	    // LogisticRegression instance.
	    println("Model 1 was fit using parameters: " + model1.parent.extractParamMap)
	
	    // We may alternatively specify parameters using a ParamMap,
	    // which supports several methods for specifying parameters.
	    val paramMap = ParamMap(lr.maxIter -> 20)
	      .put(lr.maxIter, 30) // Specify 1 Param.  This overwrites the original maxIter.
	      .put(lr.regParam -> 0.1, lr.threshold -> 0.55) // Specify multiple Params.
	
	    // One can also combine ParamMaps.
	    val paramMap2 = ParamMap(lr.probabilityCol -> "myProbability") // Change output column name
	    val paramMapCombined = paramMap ++ paramMap2
	
	    // Now learn a new model using the paramMapCombined parameters.
	    // paramMapCombined overrides all parameters set earlier via lr.set* methods.
	    val model2 = lr.fit(training, paramMapCombined)
	    println("Model 2 was fit using parameters: " + model2.parent.extractParamMap)
	
	    // Prepare test data.
	    val test = sqlContext.createDataFrame(Seq(
	      (1.0, Vectors.dense(-1.0, 1.5, 1.3)),
	      (0.0, Vectors.dense(3.0, 2.0, -0.1)),
	      (1.0, Vectors.dense(0.0, 2.2, -1.5))
	    )).toDF("label", "features")
	
	    // Make predictions on test data using the Transformer.transform() method.
	    // LogisticRegression.transform will only use the 'features' column.
	    // Note that model2.transform() outputs a 'myProbability' column instead of the usual
	    // 'probability' column since we renamed the lr.probabilityCol parameter previously.
	    model2.transform(test)
	      .select("features", "label", "myProbability", "prediction")
	      .collect()
	      .foreach { case Row(features: Vector, label: Double, prob: Vector, prediction: Double) =>
	        println(s"($features, $label) -> prob=$prob, prediction=$prediction")
	      }
	  }
	}
	
	
3.结果：
	
	LogisticRegression parameters:
	elasticNetParam: the ElasticNet mixing parameter, in range [0, 1]. For alpha = 0, the penalty is an L2 penalty. For alpha = 1, it is an L1 penalty. (default: 0.0)
	featuresCol: features column name (default: features)
	fitIntercept: whether to fit an intercept term (default: true)
	labelCol: label column name (default: label)
	maxIter: maximum number of iterations (>= 0) (default: 100)
	predictionCol: prediction column name (default: prediction)
	probabilityCol: Column name for predicted class conditional probabilities. Note: Not all models output well-calibrated probability estimates! These probabilities should be treated as confidences, not precise probabilities. (default: probability)
	rawPredictionCol: raw prediction (a.k.a. confidence) column name (default: rawPrediction)
	regParam: regularization parameter (>= 0) (default: 0.0)
	standardization: whether to standardize the training features before fitting the model. (default: true)
	threshold: threshold in binary classification prediction, in range [0, 1] (default: 0.5)
	thresholds: Thresholds in multi-class classification to adjust the probability of predicting each class. Array must have length equal to the number of classes, with values >= 0. The class with largest value p/t is predicted, where p is the original probability of that class and t is the class' threshold. (undefined)
	tol: the convergence tolerance for iterative algorithms (default: 1.0E-6)
	
	2016-06-14 22:49:47 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
	2016-06-14 22:49:47 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
	Model 1 was fit using parameters: {
		logreg_2dd393e84a66-elasticNetParam: 0.0,
		logreg_2dd393e84a66-featuresCol: features,
		logreg_2dd393e84a66-fitIntercept: true,
		logreg_2dd393e84a66-labelCol: label,
		logreg_2dd393e84a66-maxIter: 10,
		logreg_2dd393e84a66-predictionCol: prediction,
		logreg_2dd393e84a66-probabilityCol: probability,
		logreg_2dd393e84a66-rawPredictionCol: rawPrediction,
		logreg_2dd393e84a66-regParam: 0.01,
		logreg_2dd393e84a66-standardization: true,
		logreg_2dd393e84a66-threshold: 0.5,
		logreg_2dd393e84a66-tol: 1.0E-6
	}
	Model 2 was fit using parameters: {
		logreg_2dd393e84a66-elasticNetParam: 0.0,
		logreg_2dd393e84a66-featuresCol: features,
		logreg_2dd393e84a66-fitIntercept: true,
		logreg_2dd393e84a66-labelCol: label,
		logreg_2dd393e84a66-maxIter: 30,
		logreg_2dd393e84a66-predictionCol: prediction,
		logreg_2dd393e84a66-probabilityCol: myProbability,
		logreg_2dd393e84a66-rawPredictionCol: rawPrediction,
		logreg_2dd393e84a66-regParam: 0.1,
		logreg_2dd393e84a66-standardization: true,
		logreg_2dd393e84a66-threshold: 0.55,
		logreg_2dd393e84a66-tol: 1.0E-6
	}
	([-1.0,1.5,1.3], 1.0) -> prob=[0.05707304171034109,0.9429269582896589], prediction=1.0
	([3.0,2.0,-0.1], 0.0) -> prob=[0.9238522311704136,0.07614776882958636], prediction=0.0
	([0.0,2.2,-1.5], 1.0) -> prob=[0.1097277611478009,0.8902722388521991], prediction=1.0
	
	
参考
	
		【1】http://spark.apache.org/docs/1.5.2/ml-guide.html
		【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
		【3】https://github.com/xubo245/SparkLearning
		【4】book:Machine Learning with Spark ,Nick Pertreach
	    【5】book:Spark MlLib机器学习实战
