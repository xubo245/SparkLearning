/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.basic

import org.apache.spark.mllib.linalg.Matrices
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by xubo on 2016/5/23.
  * 创建分布式矩阵
  * 疑问：如何按照坐标打印元素？比如（1，1）对应6
  */
object MatrixLearning {
  def main(args: Array[String]) {
    val mx = Matrices.dense(2, 3, Array(1, 2, 3, 4, 5, 6)) //创建一个分布式矩阵
    println(mx) //打印结果

    val arr = (1 to 6).toArray.map(_.toDouble)
    val mx2 = Matrices.dense(2, 3, arr) //创建一个分布式矩阵
    println(mx2) //打印结果

    //    val arr3=(1 to 20).toArray.map(_.toDouble)
    val arr3 = (21 to 40).toArray.map(_.toDouble)
    val mx3 = Matrices.dense(4, 5, arr3) //创建一个分布式矩阵
    println(mx3) //打印结果
    println(mx3.index(0, 0))
    println(mx3.index(1, 1))
    println(mx3.index(2, 2))
    println(mx3.numRows)
    println(mx3.numCols)
    //Find the number of values stored explicitly. These values can be zero as well.
    println(mx3.numActives)
    //非零的元素个数
    println(mx3.numNonzeros)
    //最大值
    //    println(mx3.)
  }
}
