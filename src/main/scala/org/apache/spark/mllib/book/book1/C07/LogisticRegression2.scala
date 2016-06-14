package org.apache.spark.mllib.book.book1.C07

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object LogisticRegression2 {
  val conf = new SparkConf() //创建环境变量
    .setMaster("local") //设置本地化处理
    .setAppName("LogisticRegression2 ")
  //设定名称
  val sc = new SparkContext(conf) //创建环境变量实例

  def main(args: Array[String]) {
    val data = MLUtils.loadLibSVMFile(sc, "c://sample_libsvm_data.txt") //读取数据文件
    val model = LogisticRegressionWithSGD.train(data, 50) //训练数据模型
    println(model.weights.size) //打印θ值
    println(model.weights) //打印θ值个数
    println(model.weights.toArray.filter(_ != 0).size) //打印θ中不为0的数
  }
}
