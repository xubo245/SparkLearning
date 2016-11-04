更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之分类篇  
1解释  

    问题描述：给定一个无序数字序列，要求不改变每个元素的位置，但可以修改每个元素的值，修改后得到一个非递减序列，问如何使误差（该处取平方差）最小？
    保序回归法：从该序列的首元素往后观察，一旦出现乱序现象停止该轮观察，从该乱序元素开始逐个吸收元素组成一个序列，直到该序列所有元素的平均值小于或等于下一个待吸收的元素。
    举例：
    原始序列：<9, 10, 14>
    结果序列：<9, 10, 14>
    分析：从9往后观察，到最后的元素14都未发现乱序情况，不用处理。
    原始序列：<9, 14, 10>
    结果序列：<9, 12, 12>
参考【4】

2.代码：
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.classification
	
	import java.text.SimpleDateFormat
	import java.util.Date
	
	import org.apache.spark.mllib.tree.DecisionTree
	import org.apache.spark.mllib.util.MLUtils
	import org.apache.spark.{SparkConf, SparkContext}
	import org.apache.spark.mllib.tree.GradientBoostedTrees
	import org.apache.spark.mllib.tree.configuration.BoostingStrategy
	import org.apache.spark.mllib.tree.model.{DecisionTreeModel, GradientBoostedTreesModel}
	import org.apache.spark.mllib.util.MLUtils
	import java.util.Map
	import org.apache.spark.mllib.regression.{IsotonicRegression, IsotonicRegressionModel}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object IsotonicRegression1 {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    // Load and parse the data file.
	    //    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/dt.txt")
	
	    val data = sc.textFile("file/data/mllib/input/classification/sample_isotonic_regression_data.txt")
	
	    // Create label, feature, weight tuples from input data with weight set to default value 1.0.
	    val parsedData = data.map { line =>
	      val parts = line.split(',').map(_.toDouble)
	      (parts(0), parts(1), 1.0)
	    }
	
	    // Split data into training (60%) and test (40%) sets.
	    val splits = parsedData.randomSplit(Array(0.6, 0.4), seed = 11L)
	    val training = splits(0)
	    val test = splits(1)
	
	    // Create isotonic regression model from training data.
	    // Isotonic parameter defaults to true so it is only shown for demonstration
	    val model = new IsotonicRegression().setIsotonic(true).run(training)
	
	    // Create tuples of predicted and real labels.
	    val predictionAndLabel = test.map { point =>
	      val predictedLabel = model.predict(point._2)
	      (predictedLabel, point._1)
	    }
	
	    // Calculate mean squared error between predicted and real labels.
	    val meanSquaredError = predictionAndLabel.map { case (p, l) => math.pow((p - l), 2) }.mean()
	    println("Mean Squared Error = " + meanSquaredError)
	    println("data.count:" + data.count())
	    println("trainingData.count:" + training.count())
	    println("testData.count:" + test.count())
	    println(model.boundaries)
	    println(model.isotonic)
	    model.predictions.take(10).foreach(println)
	    println("predictionAndLabel")
	    predictionAndLabel.take(10).foreach(println)
	
	
	    //         Save and load model
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    val path = "file/data/mllib/output/classification/IsotonicRegressionModel" + iString + "/result"
	    model.save(sc, path)
	    val sameModel = IsotonicRegressionModel.load(sc, path)
	    println(sameModel.isotonic)
	
	    sc.stop
	  }
	}
	
	```

3.结果：
	
	```
	Mean Squared Error = 0.004883368896285485
	data.count:100
	trainingData.count:64
	testData.count:36
	[D@7dd9d603
	true
	0.1739693246153848
	0.1739693246153848
	0.196430394
	0.196430394
	0.20040796
	0.29576747
	0.51300357
	0.51300357
	0.5566037736363637
	0.5566037736363637
	predictionAndLabel
	(0.1739693246153848,0.03926568)
	(0.1739693246153848,0.12952575)
	(0.1739693246153848,0.08873024)
	(0.18519985930769242,0.15247323)
	(0.196430394,0.19581846)
	(0.196430394,0.13717491)
	(0.196430394,0.19020908)
	(0.196430394,0.2009179)
	(0.198419177,0.18510964)
	(0.40438552,0.43396226)
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	2016-05-25 16:58:04 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-05-25 16:58:04 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-05-25 16:58:04 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	2016-05-25 16:58:04 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	true
	```

参考
	
	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://blog.csdn.net/fsz521/article/details/7706250