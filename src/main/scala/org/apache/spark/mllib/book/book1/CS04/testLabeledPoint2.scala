package org.apache.spark.mllib.book.book1.CS04

import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark._
import org.apache.spark.mllib.util.MLUtils

object testLabeledPoint2 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("SparkPi") //建立本地环境变量
    val sc = new SparkContext(conf) //建立Spark处理

    val mu = MLUtils.loadLibSVMFile(sc, "c://a.txt") //从C路径盘读取文件
    mu.foreach(println) //打印内容
  }
}
