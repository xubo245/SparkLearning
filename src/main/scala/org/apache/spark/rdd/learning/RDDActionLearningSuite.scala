package org.apache.spark.rdd.learning

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * ref:Spark MLlib 机器学习 算法、源码及实战详解
  * http://spark.apache.org/docs/1.5.2/programming-guide.html
  * Created by xingyun.xb on 2016/7/24.
  */
class RDDActionLearningSuite extends SparkLearningFunSuite{
  test("reduce Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(1 to 9, 3)
    val value = rdd1.reduce(_+_)
    println(value)

  }
  test("takeOrdered Suite"){
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    val rdd1 = sc.parallelize(1 to 9, 3)
    val value = rdd1.takeOrdered(3)
    value.foreach(println)

  }

  test("countByKey Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(Array((1, 1), (1, 2), (1, 4), (3, 1), (3, 2), (2, 3)), 3)
    val rdd2 = rdd1.countByKey()
    rdd2.foreach(println)

  }


}
