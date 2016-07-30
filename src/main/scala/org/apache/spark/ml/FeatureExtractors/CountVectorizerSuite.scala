package org.apache.spark.ml.FeatureExtractors

import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.feature.CountVectorizerModel
import org.apache.spark.util.SparkLearningFunSuite
import org.apache.spark.ml.feature.CountVectorizer

/**
  * Created by xingyun.xb on 2016/7/24.
  */
class CountVectorizerSuite extends SparkLearningFunSuite {
  test("Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val df = sqlContext.createDataFrame(Seq(
      (0, Array("a", "b", "c")),
      (1, Array("a", "b", "b", "c", "a"))
      //      (1, Array("a", "b", "b", "c", "a", "d", "d", "d"))
    )).toDF("id", "words")

    // fit a CountVectorizerModel from the corpus
    val cvModel: CountVectorizerModel = new CountVectorizer()
      .setInputCol("words")
      .setOutputCol("features")
      .setVocabSize(3) //显示的单词个数，并且是按词频从大大小排序
      .setMinDF(2) // a term must appear in more or equal to 2 documents to be included in the vocabulary
      .fit(df)

    // alternatively, define CountVectorizerModel with a-priori vocabulary
    val cvm = new CountVectorizerModel(Array("a", "b", "c"))
      .setInputCol("words")
      .setOutputCol("features")

    cvModel.transform(df).select("features").show()
    cvModel.transform(df).select("features").foreach(println)

    cvm.transform(df).select("features").show()
    cvm.transform(df).select("features").foreach(println)
  }

}
