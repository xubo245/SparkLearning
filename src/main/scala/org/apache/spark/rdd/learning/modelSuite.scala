package org.apache.spark.rdd.learning

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * ref:Spark MLlib 机器学习 算法、源码及实战详解
  * Created by xingyun.xb on 2016/7/24.
  */
class modelSuite extends SparkLearningFunSuite{
  test("Suite"){
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

  }

}
