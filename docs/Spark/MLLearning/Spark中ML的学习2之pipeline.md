
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

pipeline：  
使用Pipeline对数据进行操作，指定数据读取哪些维度，转换方法，分类回归方法，然后进行训练
然后对测试数据进行转换，产生预测值等信息

  val pipeline = new Pipeline()
      .setStages(Array(tokenizer, hashingTF, lr))

    // Fit the pipeline to training documents.
    val model = pipeline.fit(training)


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
	class PipelineFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	    import org.apache.spark.ml.Pipeline
	    import org.apache.spark.ml.classification.LogisticRegression
	    import org.apache.spark.ml.feature.{HashingTF, Tokenizer}
	    import org.apache.spark.mllib.linalg.Vector
	    import org.apache.spark.sql.Row
	
	    // Prepare training documents from a list of (id, text, label) tuples.
	    val training = sqlContext.createDataFrame(Seq(
	      (0L, "a b c d e spark", 1.0),
	      (1L, "b d", 0.0),
	      (2L, "spark f g h", 1.0),
	      (3L, "hadoop mapreduce", 0.0)
	    )).toDF("id", "text", "label")
	
	    // Configure an ML pipeline, which consists of three stages: tokenizer, hashingTF, and lr.
	    val tokenizer = new Tokenizer()
	      .setInputCol("text")
	      .setOutputCol("words")
	    val hashingTF = new HashingTF()
	      .setNumFeatures(1000)
	      .setInputCol(tokenizer.getOutputCol)
	      .setOutputCol("features")
	    val lr = new LogisticRegression()
	      .setMaxIter(10)
	      .setRegParam(0.01)
	    val pipeline = new Pipeline()
	      .setStages(Array(tokenizer, hashingTF, lr))
	
	    // Fit the pipeline to training documents.
	    val model = pipeline.fit(training)
	
	    // Prepare test documents, which are unlabeled (id, text) tuples.
	    val test = sqlContext.createDataFrame(Seq(
	      (4L, "spark i j k"),
	      (5L, "l m n"),
	      (6L, "mapreduce spark"),
	      (7L, "apache hadoop")
	    )).toDF("id", "text")
	
	    // Make predictions on test documents.
	    model.transform(test)
	      .select("id", "text", "probability", "prediction")
	      .collect()
	      .foreach { case Row(id: Long, text: String, prob: Vector, prediction: Double) =>
	        println(s"($id, $text) --> prob=$prob, prediction=$prediction")
	      }
	
	  }
	}



3.结果：

	(4, spark i j k) --> prob=[0.5406433544851446,0.4593566455148554], prediction=0.0
	(5, l m n) --> prob=[0.9334382627383266,0.06656173726167333], prediction=0.0
	(6, mapreduce spark) --> prob=[0.7799076868203906,0.2200923131796095], prediction=0.0
	(7, apache hadoop) --> prob=[0.9768636139518305,0.023136386048169488], prediction=0.0

参考

	【1】http://spark.apache.org/docs/1.5.2/ml-guide.html
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
