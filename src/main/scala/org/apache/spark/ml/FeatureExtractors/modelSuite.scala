package org.apache.spark.ml.FeatureExtractors

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xingyun.xb on 2016/7/24.
  */
class modelSuite extends SparkLearningFunSuite{
  test("Suite"){
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

  }

}
