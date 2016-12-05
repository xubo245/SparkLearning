	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之分类篇
1解释  
	随机森林：RandomForest   
	大概思想就是生成多个决策树，都单独训练；如果来了一个数据，用各个决策树进行回归预测，如果是非连续结果，则取最多个数的值；如果连续，则取多个决策树结果的平均值。
	
	
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
	
	import org.apache.spark.mllib.tree.RandomForest
	import org.apache.spark.mllib.tree.model.RandomForestModel
	import org.apache.spark.mllib.util.MLUtils
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object RandomForest2Spark {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    // Load and parse the data file.
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/sample_libsvm_data.txt")
	
	    // Split the data into training and test sets (30% held out for testing)
	    val splits = data.randomSplit(Array(0.7, 0.3))
	    val (trainingData, testData) = (splits(0), splits(1))
	
	    // Train a RandomForest model.
	    //  Empty categoricalFeaturesInfo indicates all features are continuous.
	    val numClasses = 2
	    val categoricalFeaturesInfo = Map[Int, Int]()
	    val numTrees = 3 // Use more in practice.
	    val featureSubsetStrategy = "auto" // Let the algorithm choose.
	    val impurity = "gini"
	    val maxDepth = 4
	    val maxBins = 32
	
	    val model = RandomForest.trainClassifier(trainingData, numClasses, categoricalFeaturesInfo,
	      numTrees, featureSubsetStrategy, impurity, maxDepth, maxBins)
	
	    // Evaluate model on test instances and compute test error
	    val labelAndPreds = testData.map { point =>
	      val prediction = model.predict(point.features)
	      (point.label, prediction)
	    }
	    val testErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble / testData.count()
	    println("Test Error = " + testErr)
	    println("Learned classification forest model:\n" + model.toDebugString)
	
	
	    //    println("Learned classification tree model:\n" + model.toDebugString)
	    println("data.count:" + data.count())
	    println("trainingData.count:" + trainingData.count())
	    println("testData.count:" + testData.count())
	    println("model.algo:" + model.algo)
	    println("model.trees:" + model.trees)
	
	    println("labelAndPreds")
	    labelAndPreds.take(10).foreach(println)
	
	    //     Save and load model
	    //    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    //    val path = "file/data/mllib/output/classification/RandomForestModel" + iString + "/result"
	    //    model.save(sc, path)
	    //    val sameModel = RandomForestModel.load(sc, path)
	    //    println(sameModel.algo)
	    sc.stop
	  }
	}
	
	```
	
3.结果：
	
	```
	Test Error = 0.04
	Learned classification forest model:
	TreeEnsembleModel classifier with 3 trees
	
	  Tree 0:
	    If (feature 511 <= 0.0)
	     If (feature 434 <= 0.0)
	      Predict: 0.0
	     Else (feature 434 > 0.0)
	      Predict: 1.0
	    Else (feature 511 > 0.0)
	     Predict: 0.0
	  Tree 1:
	    If (feature 490 <= 31.0)
	     Predict: 0.0
	    Else (feature 490 > 31.0)
	     Predict: 1.0
	  Tree 2:
	    If (feature 302 <= 0.0)
	     If (feature 461 <= 0.0)
	      If (feature 208 <= 107.0)
	       Predict: 1.0
	      Else (feature 208 > 107.0)
	       Predict: 0.0
	     Else (feature 461 > 0.0)
	      Predict: 1.0
	    Else (feature 302 > 0.0)
	     Predict: 0.0
	
	data.count:100
	trainingData.count:75
	testData.count:25
	model.algo:Classification
	model.trees:[Lorg.apache.spark.mllib.tree.model.DecisionTreeModel;@753c93d5
	labelAndPreds
	(1.0,1.0)
	(1.0,0.0)
	(0.0,0.0)
	(0.0,0.0)
	(1.0,1.0)
	(0.0,0.0)
	(1.0,1.0)
	(1.0,1.0)
	(1.0,1.0)
	(0.0,0.0)
	```
	
参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning