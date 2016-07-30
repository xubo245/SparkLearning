package org.apache.spark.ml.FeatureExtractors

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * 去除掉stop word，这些词一般频繁出现，或者没有特殊的含义
  * list：http://ir.dcs.gla.ac.uk/resources/linguistic_utils/stop_words
  * Created by xingyun.xb on 2016/7/24.
  */
class StopWordsRemoverSuite extends SparkLearningFunSuite{
  test("Suite"){
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.feature.StopWordsRemover

    val remover = new StopWordsRemover()
      .setInputCol("raw")
      .setOutputCol("filtered")
    val dataSet = sqlContext.createDataFrame(Seq(
      (0, Seq("I", "saw", "the", "red", "baloon")),
      (1, Seq("Mary", "had", "a", "little", "lamb"))
    )).toDF("id", "raw")

    remover.transform(dataSet).show()
  }

}
