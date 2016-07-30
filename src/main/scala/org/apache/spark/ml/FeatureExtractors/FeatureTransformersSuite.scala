package org.apache.spark.ml.FeatureExtractors

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * 分词，将句子划分为word
  *Tokenizer最后word都是小写
  * regexTokenizer，word大小写不变
  * Created by xingyun.xb on 2016/7/24.
  */
class FeatureTransformersSuite extends SparkLearningFunSuite {
  test("Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.{Tokenizer, RegexTokenizer}

    val sentenceDataFrame = sqlContext.createDataFrame(Seq(
      (0, "Hi I heard about Spark"),
      (1, "I wish Java could use case classes"),
      (2, "Logistic,regression,models,are,neat")
    )).toDF("label", "sentence")
    val tokenizer = new Tokenizer().setInputCol("sentence").setOutputCol("words")
    val regexTokenizer = new RegexTokenizer()
      .setInputCol("sentence")
      .setOutputCol("words")
      .setPattern("\\W") // alternatively .setPattern("\\w+").setGaps(false)

    val tokenized = tokenizer.transform(sentenceDataFrame)
    tokenized.select("words", "label").take(3).foreach(println)
    val regexTokenized = regexTokenizer.transform(sentenceDataFrame)
    println("regexTokenized：")
    regexTokenized.select("words", "label").take(3).foreach(println)

  }

}


//result
//[WrappedArray(hi, i, heard, about, spark),0]
//[WrappedArray(i, wish, java, could, use, case, classes),1]
//[WrappedArray(logistic,regression,models,are,neat),2]
//regexTokenized：
//[WrappedArray(Hi, I, heard, about, Spark),0]
//[WrappedArray(I, wish, Java, could, use, case, classes),1]
//[WrappedArray(Logistic, regression, models, are, neat),2]
