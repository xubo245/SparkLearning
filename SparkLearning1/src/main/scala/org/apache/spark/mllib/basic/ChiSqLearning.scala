/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.basic

import org.apache.spark.mllib.linalg.{Matrix, Matrices, Vectors}
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  */
object ChiSqLearning {
  def main(args: Array[String]) {
    val vd = Vectors.dense(1, 2, 3, 4, 5)
    val vdResult = Statistics.chiSqTest(vd)
    println(vd)
    println(vdResult)
    println("-------------------------------")
    val mtx = Matrices.dense(3, 2, Array(1, 3, 5, 2, 4, 6))
    val mtxResult = Statistics.chiSqTest(mtx)
    println(mtx)
    println(mtxResult)
    //print :方法、自由度、方法的统计量、p值
    println("-------------------------------")
    val mtx2 = Matrices.dense(2, 2, Array(19.0, 34, 24, 10.0))
    printChiSqTest(mtx2)
    printChiSqTest( Matrices.dense(2, 2, Array(26.0, 36, 7, 2.0)))
//    val mtxResult2 = Statistics.chiSqTest(mtx2)
//    println(mtx2)
//    println(mtxResult2)
  }

  def printChiSqTest(matrix: Matrix): Unit = {
    println("-------------------------------")
    val mtxResult2 = Statistics.chiSqTest(matrix)
    println(matrix)
    println(mtxResult2)
  }


}
