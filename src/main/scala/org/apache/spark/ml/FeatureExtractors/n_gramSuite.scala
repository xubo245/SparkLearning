package org.apache.spark.ml.FeatureExtractors

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * 获取长为n的单词片段，n默认为2
  * Created by xingyun.xb on 2016/7/24.
  */
class n_gramSuite extends SparkLearningFunSuite {
  test("Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.feature.NGram

    val wordDataFrame = sqlContext.createDataFrame(Seq(
      (0, Array("Hi", "I", "heard", "about", "Spark")),
      (1, Array("I", "wish", "Java", "could", "use", "case", "classes")),
      (2, Array("Logistic", "regression", "models", "are", "neat"))
    )).toDF("label", "words")

    //    val ngram = new NGram().setInputCol("words").setOutputCol("ngrams")
    val ngram = new NGram().setInputCol("words").setOutputCol("ngrams").setN(3)
    val ngramDataFrame = ngram.transform(wordDataFrame)
    ngramDataFrame.take(3).map(_.getAs[Stream[String]]("ngrams").toList).foreach(println)
  }

}
