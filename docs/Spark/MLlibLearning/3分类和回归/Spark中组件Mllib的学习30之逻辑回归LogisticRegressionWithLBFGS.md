	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之分类篇
1解释
	
	Limited-memory BFGS (L-BFGS or LM-BFGS)
	Broyden–Fletcher–Goldfarb–Shanno (BFGS) algorithm
	=》
	LBFGS ：Limited-memory  Broyden–Fletcher–Goldfarb–Shanno
	
具体的概念在【4】、【5】中都有讲到，还没细看
	
	
2.代码：
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.regression
	
	import java.text.SimpleDateFormat
	import java.util.Date
	
	import org.apache.spark.{SparkConf, SparkContext}
	import org.apache.spark.mllib.classification.{LogisticRegressionModel, LogisticRegressionWithLBFGS}
	import org.apache.spark.mllib.evaluation.MulticlassMetrics
	import org.apache.spark.mllib.regression.LabeledPoint
	import org.apache.spark.mllib.util.MLUtils
	
	/**
	  * Created by xubo on 2016/5/23.
	  * 一元逻辑回归
	  */
	object LogisticRegressionWithLDFGS {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    // Load training data in LIBSVM format.
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/regression/sample_libsvm_data.txt")
	
	    // Split data into training (60%) and test (40%).
	    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)
	    val training = splits(0).cache()
	    val test = splits(1)
	
	    // Run training algorithm to build the model
	    val model = new LogisticRegressionWithLBFGS()
	      .setNumClasses(10)
	      .run(training)
	
	    // Compute raw scores on the test set.
	    val predictionAndLabels = test.map { case LabeledPoint(label, features) =>
	      val prediction = model.predict(features)
	      (prediction, label)
	    }
	
	    // Get evaluation metrics.
	    val metrics = new MulticlassMetrics(predictionAndLabels)
	    val precision = metrics.precision
	    println("Precision = " + precision)
	
	    // Save and load model
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    val path = "file/data/mllib/output/regression/LogisticRegressionWithLDFGS" + iString + "/result"
	    model.save(sc, path)
	    val sameModel = LogisticRegressionModel.load(sc, path)
	    sc.stop
	  }
	}
	
	```
	
3.结果：
	
	```
	Precision = 1.0
	```
准确率也是1
	
	
参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://blog.csdn.net/itplus/article/details/21897715
	【5】http://blog.csdn.net/zhirom/article/details/38332111
	【6】https://en.wikipedia.org/wiki/Broyden%E2%80%93Fletcher%E2%80%93Goldfarb%E2%80%93Shanno_algorithm