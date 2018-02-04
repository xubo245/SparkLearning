package org.apache.spark.mllib.book.book1.CS04

import org.apache.spark._
import org.apache.spark.mllib.linalg.distributed.{IndexedRow, RowMatrix, IndexedRowMatrix}
import org.apache.spark.mllib.linalg.{Vector, Vectors}

object testIndexedRowMatrix {
  def main(args: Array[String]) {
    val conf = new SparkConf() //创建环境变量
      .setMaster("local") //设置本地化处理
      .setAppName("testIndexedRowMatrix") //设定名称
    val sc = new SparkContext(conf) //创建环境变量实例
    val rdd = sc.textFile("c://a.txt") //创建RDD文件路径
        .map(_.split(' ') //按“ ”分割
        .map(_.toDouble)) //转成Double类型
        .map(line => Vectors.dense(line)) //转化成向量存储
        .map((vd) => new IndexedRow(vd.size, vd)) //转化格式
    val irm = new IndexedRowMatrix(rdd) //建立索引行矩阵实例
    println(irm.getClass) //打印类型
    println(irm.rows.foreach(println)) //打印内容数据
  }
}
