package org.apache.spark.mllib.book.book1.CS04

import org.apache.spark._
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.linalg.distributed.RowMatrix

object testRowMatrix {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //创建环境变量
.setMaster("local")                                               //设置本地化处理
.setAppName("testRowMatrix")                                    //设定名称
    val sc = new SparkContext(conf)                                   //创建环境变量实例
    val rdd = sc.textFile("c://a.txt")                                     //创建RDD文件路径
      .map(_.split(' ')                                                //按“ ”分割
      .map(_.toDouble))                                             //转成Double类型
      .map(line => Vectors.dense(line))                                //转成Vector格式
    val rm = new RowMatrix(rdd)                                      //读入行矩阵
    println(rm.numRows())                                           //打印列数
    println(rm.numCols())                                            //打印行数
  }
}
