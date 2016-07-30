package org.apache.spark.ml.FeatureExtractors

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * 二值化，大于阈值的为1，小于等于阈值的为0
  * Created by xingyun.xb on 2016/7/24.
  */
class BinarizerSuite extends SparkLearningFunSuite {
  test("Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.feature.Binarizer
    import org.apache.spark.sql.DataFrame

    val data = Array(
      (0, 0.1),
      (1, 0.8),
      (2, 0.2)
    )
    val dataFrame: DataFrame = sqlContext.createDataFrame(data).toDF("label", "feature")

    val binarizer: Binarizer = new Binarizer()
      .setInputCol("feature")
      .setOutputCol("binarized_feature")
      .setThreshold(0.5)

    val binarizedDataFrame = binarizer.transform(dataFrame)
    val binarizedFeatures = binarizedDataFrame.select("binarized_feature")
    binarizedFeatures.collect().foreach(println)
  }

}
