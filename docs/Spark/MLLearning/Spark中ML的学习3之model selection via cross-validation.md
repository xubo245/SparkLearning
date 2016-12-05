
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

model selection via cross-validation

使用前面提到的pipeline，然后使用ParamGridBuilder设置参数网格，使用CrossValidator交叉验证来对不同的参数进行训练，产生最优的参数配置，之后用最优的模型进行数据转换预测


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
	class modelSelectionViaVrossValidationFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	
	    import org.apache.spark.ml.Pipeline
	    import org.apache.spark.ml.classification.LogisticRegression
	    import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
	    import org.apache.spark.ml.feature.{HashingTF, Tokenizer}
	    import org.apache.spark.ml.tuning.{ParamGridBuilder, CrossValidator}
	    import org.apache.spark.mllib.linalg.Vector
	    import org.apache.spark.sql.Row
	
	    // Prepare training data from a list of (id, text, label) tuples.
	    val training = sqlContext.createDataFrame(Seq(
	      (0L, "a b c d e spark", 1.0),
	      (1L, "b d", 0.0),
	      (2L, "spark f g h", 1.0),
	      (3L, "hadoop mapreduce", 0.0),
	      (4L, "b spark who", 1.0),
	      (5L, "g d a y", 0.0),
	      (6L, "spark fly", 1.0),
	      (7L, "was mapreduce", 0.0),
	      (8L, "e spark program", 1.0),
	      (9L, "a e c l", 0.0),
	      (10L, "spark compile", 1.0),
	      (11L, "hadoop software", 0.0)
	    )).toDF("id", "text", "label")
	
	    // Configure an ML pipeline, which consists of three stages: tokenizer, hashingTF, and lr.
	    val tokenizer = new Tokenizer()
	      .setInputCol("text")
	      .setOutputCol("words")
	    val hashingTF = new HashingTF()
	      .setInputCol(tokenizer.getOutputCol)
	      .setOutputCol("features")
	    val lr = new LogisticRegression()
	      .setMaxIter(10)
	    val pipeline = new Pipeline()
	      .setStages(Array(tokenizer, hashingTF, lr))
	
	    // We use a ParamGridBuilder to construct a grid of parameters to search over.
	    // With 3 values for hashingTF.numFeatures and 2 values for lr.regParam,
	    // this grid will have 3 x 2 = 6 parameter settings for CrossValidator to choose from.
	    val paramGrid = new ParamGridBuilder()
	      .addGrid(hashingTF.numFeatures, Array(10, 100, 1000))
	      .addGrid(lr.regParam, Array(0.1, 0.01))
	      .build()
	
	    // We now treat the Pipeline as an Estimator, wrapping it in a CrossValidator instance.
	    // This will allow us to jointly choose parameters for all Pipeline stages.
	    // A CrossValidator requires an Estimator, a set of Estimator ParamMaps, and an Evaluator.
	    // Note that the evaluator here is a BinaryClassificationEvaluator and its default metric
	    // is areaUnderROC.
	    val cv = new CrossValidator()
	      .setEstimator(pipeline)
	      .setEvaluator(new BinaryClassificationEvaluator)
	      .setEstimatorParamMaps(paramGrid)
	      .setNumFolds(2) // Use 3+ in practice
	
	    // Run cross-validation, and choose the best set of parameters.
	    val cvModel = cv.fit(training)
	
	    // Prepare test documents, which are unlabeled (id, text) tuples.
	    val test = sqlContext.createDataFrame(Seq(
	      (4L, "spark i j k"),
	      (5L, "l m n"),
	      (6L, "mapreduce spark"),
	      (7L, "apache hadoop")
	    )).toDF("id", "text")
	
	    // Make predictions on test documents. cvModel uses the best model found (lrModel).
	    cvModel.transform(test)
	      .select("id", "text", "probability", "prediction")
	      .collect()
	      .foreach { case Row(id: Long, text: String, prob: Vector, prediction: Double) =>
	        println(s"($id, $text) --> prob=$prob, prediction=$prediction")
	      }
	
	
	  }
	}



3.结果：

	(4, spark i j k) --> prob=[0.24804795226775067,0.7519520477322493], prediction=1.0
	(5, l m n) --> prob=[0.9647209186740324,0.03527908132596761], prediction=0.0
	(6, mapreduce spark) --> prob=[0.4248344997494982,0.5751655002505017], prediction=1.0
	(7, apache hadoop) --> prob=[0.6899594200690095,0.3100405799309906], prediction=0.0


参考

	【1】http://spark.apache.org/docs/1.5.2/ml-guide.html
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
