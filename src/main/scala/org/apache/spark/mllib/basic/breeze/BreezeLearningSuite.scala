package org.apache.spark.mllib.basic.breeze


import java.util.Random

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.linalg.DenseMatrix
import org.apache.spark.util.SparkLearningFunSuite

/**
  * ref:Spark MLlib 机器学习 算法、源码及实战详解
  * Created by xingyun.xb on 2016/7/24.
  */
class BreezeLearningSuite extends SparkLearningFunSuite {
  test("mllib linalg Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    val dm1 = DenseMatrix.zeros(2, 3)
    println(dm1)

    println()
    val dm2 = DenseMatrix.ones(2, 3)
    println(dm2)

    println()
    println(DenseMatrix.eye(3))

    println()
    println(DenseMatrix.eye(6))

    println()
    println(DenseMatrix.eye(10))


    println()
    //    val rng = mock[Random]

    println(DenseMatrix.rand(2, 3, new Random(10)))

    //    DenseVector

  }

//  test("Breeze suite"){
//    DenseMatrix
//  }

}
