/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.classification

import org.apache.spark.mllib.tree.{RandomForest, DecisionTree}
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  *
  */
object RandomForest1EntropyClassification {
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
