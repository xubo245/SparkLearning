更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之分类篇  
1解释  
GBRT（Gradient Boost Regression Tree）渐进梯度回归树   
同样的setCategoricalFeaturesInfo有问题。注释掉了。  

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
	import org.apache.spark.mllib.tree.GradientBoostedTrees
	import org.apache.spark.mllib.tree.configuration.BoostingStrategy
	import org.apache.spark.mllib.tree.model.GradientBoostedTreesModel
	import org.apache.spark.mllib.util.MLUtils
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object GBTs2Regression {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    // Load and parse the data file.
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/sample_libsvm_data.txt")
	
	    // Split the data into training and test sets (30% held out for testing)
	    val splits = data.randomSplit(Array(0.7, 0.3))
	    val (trainingData, testData) = (splits(0), splits(1))
	
	    // Train a GradientBoostedTrees model.
	    //  The defaultParams for Classification use LogLoss by default.
	    val boostingStrategy = BoostingStrategy.defaultParams("Regression")
	    boostingStrategy.setNumIterations(3)
	    boostingStrategy.treeStrategy.setMaxDepth(5)
	    //    boostingStrategy.treeStrategy.setCategoricalFeaturesInfo(Map[Int, Int]())
	
	    // Train a GradientBoostedTrees model.
	    //  The defaultParams for Regression use SquaredError by default.
	    //    val boostingStrategy = BoostingStrategy.defaultParams("Regression")
	    //    boostingStrategy.numIterations = 3 // Note: Use more iterations in practice.
	    //    boostingStrategy.treeStrategy.maxDepth = 5
	    //    //  Empty categoricalFeaturesInfo indicates all features are continuous.
	    //    boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int, Int]()
	
	    val model = GradientBoostedTrees.train(trainingData, boostingStrategy)
	
	    // Evaluate model on test instances and compute test error
	    val labelsAndPredictions = testData.map { point =>
	      val prediction = model.predict(point.features)
	      (point.label, prediction)
	    }
	    val testMSE = labelsAndPredictions.map { case (v, p) => math.pow((v - p), 2) }.mean()
	    println("Test Mean Squared Error = " + testMSE)
	    println("Learned regression GBT model:\n" + model.toDebugString)
	
	
	
	    println("data.count:" + data.count())
	    println("trainingData.count:" + trainingData.count())
	    println("testData.count:" + testData.count())
	    println("model.algo:" + model.algo)
	    println("model.trees:" + model.trees)
	    println("model.treeWeights:" + model.treeWeights)
	
	
	
	    //     Save and load model
	    //    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    //    val path = "file/data/mllib/output/classification/GradientBoostedTreesModel" + iString + "/result"
	    //    model.save(sc, path)
	    //    val sameModel = DecisionTreeModel.load(sc, path)
	    //    println(sameModel.algo)
	    sc.stop
	  }
	}
	
	```
	
3.结果：
	
	```
	Test Mean Squared Error = 0.06896551724137932
	Learned regression GBT model:
	TreeEnsembleModel regressor with 3 trees
	
	  Tree 0:
	    If (feature 406 <= 72.0)
	     If (feature 99 <= 0.0)
	      Predict: 0.0
	     Else (feature 99 > 0.0)
	      Predict: 1.0
	    Else (feature 406 > 72.0)
	     Predict: 1.0
	  Tree 1:
	    Predict: 0.0
	  Tree 2:
	    Predict: 0.0
	
	data.count:100
	trainingData.count:71
	testData.count:29
	model.algo:Regression
	model.trees:[Lorg.apache.spark.mllib.tree.model.DecisionTreeModel;@5e9a7c29
	model.treeWeights:[D@78bf694d
	```
	
参考
	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning