package org.apache.spark.mllib.book.book1.C08

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.tree.RandomForest
import org.apache.spark.mllib.util.MLUtils

object RFDTree {
  def main(args: Array[String]) {
    val conf = new SparkConf() //创建环境变量
      .setMaster("local") //设置本地化处理
      .setAppName("DT2") //设定名称
    val sc = new SparkContext(conf) //创建环境变量实例
    val data = MLUtils.loadLibSVMFile(sc, "c://DTree.txt") //输入数据集

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
  }
}
