package org.apache.spark.ml.FeatureExtractors

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xingyun.xb on 2016/7/24.
  */
class Word2VecSuite extends SparkLearningFunSuite {
  test("Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.feature.Word2Vec

    // Input data: Each row is a bag of words from a sentence or document.
    val documentDF = sqlContext.createDataFrame(Seq(
      "Hi I heard about Spark".split(" "),
      "I wish Java could use case classes".split(" "),
      "Logistic regression models are neat".split(" ")
    ).map(Tuple1.apply)).toDF("text")

    // Learn a mapping from words to Vectors.
    val word2Vec = new Word2Vec()
      .setInputCol("text")
      .setOutputCol("result")
      .setVectorSize(3)
      .setMinCount(0)
    val model = word2Vec.fit(documentDF)
    val result = model.transform(documentDF)
    result.select("result").take(3).foreach(println)

    documentDF.show()
    documentDF.foreach(println)

    result.show()
    result.foreach(println)


  }

}
