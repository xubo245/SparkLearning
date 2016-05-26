//package org.apache.spark.mllib.learning.book.book1.C07
//
//import org.apache.spark.mllib.util.MLUtils
//import org.apache.spark.{SparkConf, SparkContext}
//import org.apache.spark.mllib.classification.NaiveBayes
//import org.apache.spark.mllib.linalg.Vectors
//import org.apache.spark.mllib.regression.LabeledPoint
//
//object Bayes {
//
//  def main(args: Array[String]) {
//    val conf = new SparkConf() //创建环境变量
//      .setMaster("local") //设置本地化处理
//      .setAppName("BayesTest ") //设定名称
//    val sc = new SparkContext(conf) //创建环境变量实例
//    val file = MLUtils.loadLabeledPoints(sc, "file/data/mllib/input/ridge-data/lpsa2.data") //读取数据集
//    val data = file.map { line => //处理数据
//        val parts = line.split(',') //分割数据
//        LabeledPoint(parts(0).toDouble, //标签数据转换
//          Vectors.dense(parts(1).split(' ').map(_.toDouble))) //向量数据转换
//      }
//
//    val splits = data.randomSplit(Array(0.7, 0.3), seed = 11L) //对数据进行分配
//    val trainingData = splits(0) //设置训练数据
//    val testData = splits(1) //设置测试数据
//    val model = NaiveBayes.train(trainingData, lambda = 1.0) //训练贝叶斯模型
//    val predictionAndLabel = testData.map(p => (model.predict(p.features), p.label)) //验证模型
//    val accuracy = 1.0 * predictionAndLabel.filter(//计算准确度
//        label => label._1 == label._2).count() //比较结果
//    println(accuracy) //打印准确度
//  }
//}
//
