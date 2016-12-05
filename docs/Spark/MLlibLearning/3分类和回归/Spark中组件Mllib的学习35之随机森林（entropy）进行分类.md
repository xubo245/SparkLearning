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
	
	import org.apache.spark.mllib.tree.{RandomForest, DecisionTree}
	import org.apache.spark.mllib.util.MLUtils
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  *
	  */
	object DecisionTrees3GBT {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    // Load and parse the data file.
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/dt.txt")
	    val numClasses = 2 //设定分类的数量
	    val categoricalFeaturesInfo = Map[Int, Int]() //设置输入数据格式
	    val numTrees = 3 //设置随机雨林中决策树的数目
	    val featureSubsetStrategy = "auto" //设置属性在节点计算数
	    val impurity = "entropy" //设定信息增益计算方式
	    val maxDepth = 5 //设定树高度
	    val maxBins = 3 //设定分裂数据集
	
	    val model = RandomForest.trainClassifier(data, numClasses, categoricalFeaturesInfo,
	      numTrees, featureSubsetStrategy, impurity, maxDepth, maxBins) //建立模型
	
	    model.trees.foreach(println) //打印每棵树的相信信息
	
	    val labelAndPreds = data.take(2).map { point =>
	      val prediction = model.predict(point.features)
	      (point.label, prediction)
	    }
	    labelAndPreds.foreach(println)
	     println(model.toDebugString)
	    sc.stop
	  }
	}
	
	```
	
3.结果：
	
	```
	DecisionTreeModel classifier of depth 2 with 5 nodes
	DecisionTreeModel classifier of depth 1 with 3 nodes
	DecisionTreeModel classifier of depth 0 with 1 nodes
	(1.0,1.0)
	(0.0,0.0)
	TreeEnsembleModel classifier with 3 trees
	
	  Tree 0:
	    If (feature 2 <= 0.0)
	     If (feature 0 <= 0.0)
	      Predict: 0.0
	     Else (feature 0 > 0.0)
	      Predict: 1.0
	    Else (feature 2 > 0.0)
	     Predict: 0.0
	  Tree 1:
	    If (feature 2 <= 0.0)
	     Predict: 1.0
	    Else (feature 2 > 0.0)
	     Predict: 0.0
	  Tree 2:
	    Predict: 1.0
	```
	
参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning