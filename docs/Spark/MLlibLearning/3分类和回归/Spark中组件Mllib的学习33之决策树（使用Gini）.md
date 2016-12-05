	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之分类篇
1解释  
	决策树：Decision Trees    
	请见【4】【5】  
	数据每次是随机划分，所以准确率每次不一定  
	
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
	object DecisionTreesLearning {
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
	    val numClasses = 2
	    val categoricalFeaturesInfo = Map[Int, Int]()
	    val impurity = "gini"
	    val maxDepth = 5
	    val maxBins = 32
	
	    val model = DecisionTree.trainClassifier(trainingData, numClasses, categoricalFeaturesInfo,
	      impurity, maxDepth, maxBins)
	
	    // Evaluate model on test instances and compute test error
	    val labelAndPreds = testData.map { point =>
	      val prediction = model.predict(point.features)
	      (point.label, prediction)
	    }
	    val testErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble / testData.count()
	    println("Test Error = " + testErr)
	    println("Learned classification tree model:\n" + model.toDebugString)
	    println("data.count:" + data.count())
	    println("trainingData.count:" + trainingData.count())
	    println("testData.count:" + testData.count())
	    println("model.depth:"+model.depth)
	    println("model.numNodes:"+model.numNodes)
	    println("model.topNode:"+model.topNode)
	
	    println("labelAndPreds")
	    labelAndPreds.take(30).foreach(println)
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
	Test Error = 0.0
	Learned classification tree model:
	DecisionTreeModel classifier of depth 2 with 5 nodes
	  If (feature 434 <= 0.0)
	   If (feature 100 <= 165.0)
	    Predict: 0.0
	   Else (feature 100 > 165.0)
	    Predict: 1.0
	  Else (feature 434 > 0.0)
	   Predict: 1.0
	
	data.count:100
	trainingData.count:78
	testData.count:22
	model.depth:2
	model.numNodes:5
	model.topNode:id = 1, isLeaf = false, predict = 1.0 (prob = 0.5384615384615384), impurity = 0.49704142011834324, split = Some(Feature = 434, threshold = 0.0, featureType = Continuous, categories = List()), stats = Some(gain = 0.47209339517031834, impurity = 0.49704142011834324, left impurity = 0.05259313367421467, right impurity = 0.0)
	labelAndPreds
	(0.0,0.0)
	(0.0,0.0)
	(1.0,1.0)
	(1.0,1.0)
	(1.0,1.0)
	(0.0,0.0)
	(1.0,1.0)
	(0.0,0.0)
	(1.0,1.0)
	(0.0,0.0)
	(1.0,1.0)
	(1.0,1.0)
	(0.0,0.0)
	(1.0,1.0)
	(1.0,1.0)
	(1.0,1.0)
	(0.0,0.0)
	(1.0,1.0)
	(1.0,1.0)
	(1.0,1.0)
	(1.0,1.0)
	(1.0,1.0)
	```
	
参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://blog.csdn.net/dark_scope/article/details/13168827
	【5】http://spark.apache.org/docs/1.5.2/mllib-decision-tree.html