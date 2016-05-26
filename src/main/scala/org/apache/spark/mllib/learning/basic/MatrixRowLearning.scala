/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.learning.basic

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed._
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  */
object MatrixRowLearning {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    println("First:Matrix ")
    val rdd = sc.textFile("file/data/mllib/input/basic/MatrixRow.txt") //创建RDD文件路径
      .map(_.split(' ') //按“ ”分割
      .map(_.toDouble)) //转成Double类型
      .map(line => Vectors.dense(line)) //转成Vector格式
    val rm = new RowMatrix(rdd) //读入行矩阵
    //    for(i <- rm){
    //      println(i)
    //    }
    //error
    //疑问：如何打印行矩阵所有值，如何定位？
    println(rm.numRows()) //打印列数
    println(rm.numCols()) //打印行数
    rm.rows.foreach(println)

    println("Second:index Row Matrix ")
    val rdd2 = sc.textFile("file/data/mllib/input/basic/MatrixRow.txt") //创建RDD文件路径
      .map(_.split(' ') //按“ ”分割
      .map(_.toDouble)) //转成Double类型
      .map(line => Vectors.dense(line)) //转化成向量存储
      .map((vd) => new IndexedRow(vd.size, vd)) //转化格式
    val irm = new IndexedRowMatrix(rdd2) //建立索引行矩阵实例
    println(irm.getClass) //打印类型
    irm.rows.foreach(println) //打印内容数据
    //如何定位？

    println("Third: Coordinate Row Matrix ")
    val rdd3 = sc.textFile("file/data/mllib/input/basic/MatrixRow.txt") //创建RDD文件路径
      .map(_.split(' ') //按“ ”分割
      .map(_.toDouble)) //转成Double类型
      .map(vue => (vue(0).toLong, vue(1).toLong, vue(2))) //转化成坐标格式
      .map(vue2 => new MatrixEntry(vue2 _1, vue2 _2, vue2 _3)) //转化成坐标矩阵格式
    val crm = new CoordinateMatrix(rdd3) //实例化坐标矩阵
    crm.entries.foreach(println) //打印数据
    println(crm.numCols())
    println(crm.numCols())
    //    Return approximate number of distinct elements in the RDD.
    println(crm.entries.countApproxDistinct())


    println("Fourth: Block Matrix :null")
    //块矩阵待完善

    sc.stop
  }
}
