	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之分类篇
1解释
	
MLlib决策树支持三种不纯度的计算：gini、entropy、variance。其他的目前不支持

	```
	  def fromString(name: String): Impurity = name match {
	    case "gini" => Gini
	    case "entropy" => Entropy
	    case "variance" => Variance
	    case _ => throw new IllegalArgumentException(s"Did not recognize Impurity name: $name")
	  }
	}
	```

![这里写图片描述](http://img.blog.csdn.net/20160525150243291)
参考【4】  
官网：

![这里写图片描述](http://img.blog.csdn.net/20160525151508370)
	
主要的决策树算法包括ID3，C4.5， CART等,参考【5】
	
2.代码：
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.classification
	
	import org.apache.spark.mllib.tree.DecisionTree
	import org.apache.spark.mllib.util.MLUtils
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  *
	  */
	object DecisionTrees2ByEntropy {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    // Load and parse the data file.
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/dt.txt")
	    // Split the data into training and test sets (30% held out for testing)
	    val numClasses = 2 //设定分类数量
	    val categoricalFeaturesInfo = Map[Int, Int]() //设定输入格式
	    val impurity = "entropy" //设定信息增益计算方式
	    val maxDepth = 5 //设定树高度
	    val maxBins = 3 //设定分裂数据集
	
	    val model = DecisionTree.trainClassifier(data, numClasses, categoricalFeaturesInfo,
	      impurity, maxDepth, maxBins) //建立模型
	    println("model.depth:" + model.depth)
	    println("model.numNodes:" + model.numNodes)
	    println("model.topNode:" + model.topNode)
	
	    val labelAndPreds = data.take(2).map { point =>
	      val prediction = model.predict(point.features)
	      (point.label, prediction)
	    }
	    labelAndPreds.foreach(println)
	    sc.stop
	  }
	}
	
	```
	
	```
	1 1:1 2:0 3:0 4:1
	0 1:1 2:0 3:1 4:1
	0 1:0 2:1 3:0 4:0
	1 1:1 2:1 3:0 4:0
	1 1:1 2:0 3:0 4:0
	1 1:1 2:1 3:0 4:0
	
	```
	
	
3.结果：
	
	```
	model.depth:2
	model.numNodes:5
	model.topNode:id = 1, isLeaf = false, predict = 1.0 (prob = 0.6666666666666666), impurity = 0.9182958340544896, split = Some(Feature = 0, threshold = 0.0, featureType = Continuous, categories = List()), stats = Some(gain = 0.31668908831502096, impurity = 0.9182958340544896, left impurity = 0.0, right impurity = 0.7219280948873623)
	(1.0,1.0)
	(0.0,0.0)
	
	```
	
参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】《数据挖掘导论》
	【5】http://blog.csdn.net/taigw/article/details/44840771