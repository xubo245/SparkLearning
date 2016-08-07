package org.apache.spark.mllib.basic

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.book.book1.C07.SVM
import org.apache.spark.mllib.util.{KMeansDataGenerator, LinearDataGenerator, LogisticRegressionDataGenerator, SVMDataGenerator}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * 产生仿真数据
  *
  * ref:Spark MLlib 机器学习 算法、源码及实战详解
  * Created by xingyun.xb on 2016/7/24.
  */
class createRDDSuite extends SparkLearningFunSuite {

  test("kmeansRDD Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    val kmeansRDD = KMeansDataGenerator.generateKMeansRDD(sc, 40, 5, 4, 1.0, 2)
    kmeansRDD.foreach { each =>
      each.foreach { every => println(every + " ") }
      println
    }
    print(kmeansRDD.count())
  }

  test("generateLinearRDD Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    val linearRDD = LinearDataGenerator.generateLinearRDD(sc, 40, 3, 1.0, 2, 0.0)
    linearRDD.foreach(println)
    print(linearRDD.count())
  }

  test("generateLogisticRDD Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    val logisticRDD = LogisticRegressionDataGenerator.generateLogisticRDD(sc, 40, 3, 1.0, 2, 0.5)
    logisticRDD.foreach(println)
    print(logisticRDD.count())
  }

}
