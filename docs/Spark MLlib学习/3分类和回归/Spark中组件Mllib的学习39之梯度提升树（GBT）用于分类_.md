	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之分类篇
1解释
	
（1）GBDT基本概念
	        用ID3算法和C4.5算法学习得到的决策树，有可能导致模型过拟合，通常使用剪枝算法来解决。随着集成学习的发展，出现了比较典型的迭代决策树GBDT和随机森林RF，即将多棵单决策树进行模型组合，形成多决策树，可以看成Treelink。
	
迭代决策树有以下名称：

	GBDT（Gradient Boost Decision Tree）渐进梯度决策树
	GBRT（Gradient Boost Regression Tree）渐进梯度回归树
	MART（Multiple Additive Regression Tree）多决策回归树
请参考【4】、【5】、【6】
	
（2）梯度提升树用于分类  
【1】中给的方法有问题，需要进行修改，另外：
	
	```
	boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int, Int]()
	```
没办法设置
	
	```
	 boostingStrategy.treeStrategy.setCategoricalFeaturesInfo( java.util.Map[Integer, Integer]())
	```
也不行，只好注释掉了。
	
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
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object GBTs1 {
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
	    var boostingStrategy = BoostingStrategy.defaultParams("Classification")
	    boostingStrategy.setNumIterations(3)
	    boostingStrategy.treeStrategy.setNumClasses(2)
	    boostingStrategy.treeStrategy.setMaxDepth(5)
	    //    boostingStrategy.treeStrategy.setCategoricalFeaturesInfo( java.util.Map[Integer, Integer]())
	
	    //error
	    //    boostingStrategy.numIterations = 3 // Note: Use more iterations in practice.
	    //    boostingStrategy.treeStrategy.numClasses = 2
	    //    boostingStrategy.treeStrategy.maxDepth = 5
	    //    //  Empty categoricalFeaturesInfo indicates all features are continuous.
	    //        boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int, Int]()
	
	    val model = GradientBoostedTrees.train(trainingData, boostingStrategy)
	
	    // Evaluate model on test instances and compute test error
	    val labelAndPreds = testData.map { point =>
	      val prediction = model.predict(point.features)
	      (point.label, prediction)
	    }
	    val testErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble / testData.count()
	    println("Test Error = " + testErr)
	    println("Learned classification GBT model:\n" + model.toDebugString)
	
	
	    println("data.count:" + data.count())
	    println("trainingData.count:" + trainingData.count())
	    println("testData.count:" + testData.count())
	    println("model.algo:" + model.algo)
	    println("model.trees:" + model.trees)
	    println("model.treeWeights:" + model.treeWeights)
	
	    println("labelAndPreds")
	    labelAndPreds.take(10).foreach(println)
	
	
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
	Test Error = 0.034482758620689655
	Learned classification GBT model:
	TreeEnsembleModel classifier with 3 trees
	
	  Tree 0:
	    If (feature 406 <= 72.0)
	     If (feature 100 <= 165.0)
	      Predict: -1.0
	     Else (feature 100 > 165.0)
	      Predict: 1.0
	    Else (feature 406 > 72.0)
	     Predict: 1.0
	  Tree 1:
	    If (feature 433 <= 0.0)
	     If (feature 351 <= 251.0)
	      If (feature 183 <= 228.0)
	       Predict: -0.4768116880884702
	      Else (feature 183 > 228.0)
	       Predict: -0.4768116880884703
	     Else (feature 351 > 251.0)
	      Predict: 0.4768116880884694
	    Else (feature 433 > 0.0)
	     Predict: 0.47681168808847
	  Tree 2:
	    If (feature 434 <= 0.0)
	     If (feature 435 <= 0.0)
	      If (feature 241 <= 19.0)
	       Predict: -0.4381935810427206
	      Else (feature 241 > 19.0)
	       If (feature 215 <= 40.0)
	        Predict: -0.4381935810427206
	       Else (feature 215 > 40.0)
	        Predict: -0.43819358104272066
	     Else (feature 435 > 0.0)
	      Predict: 0.43819358104271977
	    Else (feature 434 > 0.0)
	     If (feature 123 <= 0.0)
	      If (feature 407 <= 218.0)
	       Predict: 0.4381935810427206
	      Else (feature 407 > 218.0)
	       Predict: 0.43819358104272066
	     Else (feature 123 > 0.0)
	      Predict: 0.43819358104272155
	
	data.count:100
	trainingData.count:71
	testData.count:29
	model.algo:Classification
	model.trees:[Lorg.apache.spark.mllib.tree.model.DecisionTreeModel;@4d65c183
	model.treeWeights:[D@5dbbb110
	labelAndPreds
	(1.0,1.0)
	(0.0,0.0)
	(0.0,0.0)
	(0.0,0.0)
	(1.0,1.0)
	(1.0,1.0)
	(1.0,1.0)
	(1.0,1.0)
	(0.0,0.0)
	(0.0,0.0)
	
	```
	
参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】《统计学习方法》
	【5】http://my.oschina.net/keyven/blog/615436
	【6】http://blog.csdn.net/w28971023/article/details/8240756
	【7】http://spark.apache.org/docs/1.5.2/mllib-ensembles.html