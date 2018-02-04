package org.apache.spark.mllib.basic.breezeLearning.breezeFromScalaNLP

import breeze.linalg.DenseMatrix
import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * ref:Spark MLlib 机器学习 算法、源码及实战详解
  */
class breezeFromMllibSuite extends SparkLearningFunSuite{
  test("Suite"){
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
//    val dm1=DenseMatrix.zeros(2,3)
//    println(dm1)
  }

}
