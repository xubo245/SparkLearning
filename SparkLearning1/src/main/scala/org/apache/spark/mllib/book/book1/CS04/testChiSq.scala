package org.apache.spark.mllib.book.book1.CS04

import org.apache.spark.mllib.linalg.{Matrices, Vectors}
import org.apache.spark.mllib.stat.Statistics

object testChiSq{
  def main(args: Array[String]) {
    val vd = Vectors.dense(1,2,3,4,5)                                 //
    val vdResult = Statistics.chiSqTest(vd)
    println(vdResult)
    println("-------------------------------")
    val mtx = Matrices.dense(3, 2, Array(1, 3, 5, 2, 4, 6))
    val mtxResult = Statistics.chiSqTest(mtx)
    println(mtxResult)
  }
}
