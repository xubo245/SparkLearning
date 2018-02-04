/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.classification

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
    println(model.toDebugString)
    sc.stop
  }
}
