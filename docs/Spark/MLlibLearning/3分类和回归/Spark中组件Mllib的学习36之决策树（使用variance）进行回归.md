	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之分类篇
1解释  
	决策树（使用variance）进行回归
	
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
	import org.apache.spark.mllib.tree.model.DecisionTreeModel
	import org.apache.spark.mllib.util.MLUtils
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object DecisionTrees4ByVarianceRegression {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    // Load and parse the data file.
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/sample_libsvm_data.txt")
	
	    // Split the data into training and test sets (30% held out for testing)
	    val splits = data.randomSplit(Array(0.7, 0.3))
	    val (trainingData, testData) = (splits(0), splits(1))
	
	    // Train a DecisionTree model.
	    //  Empty categoricalFeaturesInfo indicates all features are continuous.
	    val categoricalFeaturesInfo = Map[Int, Int]()
	    val impurity = "variance"
	    val maxDepth = 5
	    val maxBins = 32
	
	    val model = DecisionTree.trainRegressor(trainingData, categoricalFeaturesInfo, impurity,
	      maxDepth, maxBins)
	
	    // Evaluate model on test instances and compute test error
	    val labelsAndPredictions = testData.map { point =>
	      val prediction = model.predict(point.features)
	      (point.label, prediction)
	    }
	    //    println("Learned classification tree model:\n" + model.toDebugString)
	    println("data.count:" + data.count())
	    println("trainingData.count:" + trainingData.count())
	    println("testData.count:" + testData.count())
	    println("model.depth:" + model.depth)
	    println("model.numNodes:" + model.numNodes)
	    println("model.topNode:" + model.topNode)
	
	    println("labelAndPreds")
	    labelsAndPredictions.take(10).foreach(println)
	
	    val testMSE = labelsAndPredictions.map { case (v, p) => math.pow((v - p), 2) }.mean()
	    println("Test Mean Squared Error = " + testMSE)
	    println("Learned regression tree model:\n" + model.toDebugString)
	
	    // Save and load model
	    //    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    //    val path = "file/data/mllib/output/classification/DecisionTreesLearning" + iString + "/result"
	    //    model.save(sc, path)
	    //    val sameModel = DecisionTreeModel.load(sc, path)
	    //    println(sameModel.algo)
	    sc.stop
	  }
	}
	
	```
	
3.结果：
	
	```
	data.count:100
	trainingData.count:65
	testData.count:35
	model.depth:2
	model.numNodes:5
	model.topNode:id = 1, isLeaf = false, predict = 0.6307692307692307 (prob = -1.0), impurity = 0.23289940828402367, split = Some(Feature = 434, threshold = 0.0, featureType = Continuous, categories = List()), stats = Some(gain = 0.2181301775147929, impurity = 0.23289940828402367, left impurity = 0.0384, right impurity = 0.0)
	labelAndPreds
	(1.0,1.0)
	(0.0,0.0)
	(1.0,1.0)
	(0.0,0.0)
	(0.0,0.0)
	(1.0,1.0)
	(0.0,0.0)
	(0.0,0.0)
	(1.0,1.0)
	(1.0,1.0)
	Test Mean Squared Error = 0.0
	Learned regression tree model:
	DecisionTreeModel regressor of depth 2 with 5 nodes
	  If (feature 434 <= 0.0)
	   If (feature 100 <= 165.0)
	    Predict: 0.0
	   Else (feature 100 > 165.0)
	    Predict: 1.0
	  Else (feature 434 > 0.0)
	   Predict: 1.0
	```
	
参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning