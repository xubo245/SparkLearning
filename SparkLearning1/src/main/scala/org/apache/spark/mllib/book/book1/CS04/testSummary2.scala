package org.apache.spark.mllib.book.book1.CS04

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkContext, SparkConf}

object testSummary3 {
  def main(args: Array[String]) {
    val conf = new SparkConf() //创建环境变量
      .setMaster("local") //设置本地化处理
      .setAppName("testSummary2") //设定名称
    val sc = new SparkContext(conf) //创建环境变量实例
    val rdd = sc.textFile("c://a.txt") //创建RDD文件路径
        .map(_.split(' ') //按“ ”分割
        .map(_.toDouble)) //转成Double类型
        .map(line => Vectors.dense(line)) //转成Vector格式
    val summary = Statistics.colStats(rdd) //获取Statistics实例
    println(summary.normL1) //计算曼哈段距离
    println(summary.normL2) //计算欧几里得距离
  }
}

