package org.apache.spark.mllib.book.book1.CS04

import org.apache.spark._
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.linalg.distributed.{CoordinateMatrix, MatrixEntry}

object testCoordinateRowMatrix {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //创建环境变量
.setMaster("local")                                               //设置本地化处理
.setAppName("testIndexedRowMatrix")						  //设定名称
    val sc = new SparkContext(conf)                                  //创建环境变量实例
    val rdd = sc.textFile("c://a.txt")                                     //创建RDD文件路径
      .map(_.split(' ')                                                //按“ ”分割
      .map(_.toDouble))                                             //转成Double类型
      .map(vue => (vue(0).toLong,vue(1).toLong,vue(2)))                //转化成坐标格式
      .map(vue2 => new MatrixEntry(vue2 _1,vue2 _2,vue2 _3))         //转化成坐标矩阵格式
    val crm = new CoordinateMatrix(rdd)                              //实例化坐标矩阵
    println(crm.entries.foreach(println))                                //打印数据
  }
}
