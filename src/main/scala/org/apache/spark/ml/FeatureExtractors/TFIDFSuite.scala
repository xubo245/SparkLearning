package org.apache.spark.ml.FeatureExtractors

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xingyun.xb on 2016/7/24.
  */
class TFIDFSuite extends SparkLearningFunSuite {
  test("TFIDFSuite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.{HashingTF, IDF, Tokenizer}

    val sentenceData = sqlContext.createDataFrame(Seq(
      (0, "Hi I heard about Spark"),
      (0, "I wish Java could use case classes"),
      (1, "Logistic regression models are neat")
    )).toDF("label", "sentence")
    val tokenizer = new Tokenizer().setInputCol("sentence").setOutputCol("words")
    val wordsData = tokenizer.transform(sentenceData)
    //    val hashingTF = new HashingTF().setInputCol("words").setOutputCol("rawFeatures").setNumFeatures(20)
    /**
      * 如果NumFeatures设置为了20，则很多word的哈希值容易重复，故：
      * 为2000，
      */
    val hashingTF = new HashingTF().setInputCol("words").setOutputCol("rawFeatures").setNumFeatures(2000)
    val featurizedData = hashingTF.transform(wordsData)
    val idf = new IDF().setInputCol("rawFeatures").setOutputCol("features")
    val idfModel = idf.fit(featurizedData)
    val rescaledData = idfModel.transform(featurizedData)


    println("sentenceData：")
    sentenceData.show()
    sentenceData.foreach(println)
    println("wordsData：")
    wordsData.show()
    wordsData.foreach(println)
    println("featurizedData：")
    featurizedData.show()
    featurizedData.foreach(println)
    println("sentenceData：")
    sentenceData.show()
    sentenceData.foreach(println)
    println("rescaledData:")
    rescaledData.select("features", "label").take(3).foreach(println)

    /**
      *
      * featurizedData：
      * [0,Hi I heard about Spark,WrappedArray(hi, i, heard, about, spark),(2000,[105,365,1329,1469,1926],[1.0,1.0,1.0,1.0,1.0])]
      * [1,Logistic regression models are neat,WrappedArray(logistic, regression, models, are, neat),(2000,[65,618,852,992,1194],[1.0,1.0,1.0,1.0,1.0])]
      * [0,I wish Java could use case classes,WrappedArray(i, wish, java, could, use, case, classes),(2000,[103,105,192,774,818,1265,1703],[1.0,1.0,1.0,1.0,1.0,1.0,1.0])]
      *
      * 105应该是指i
      * TF*IDF
      *
      *rescaledData:
      * [(2000,[105,365,1329,1469,1926],[0.28768207245178085,0.6931471805599453,0.6931471805599453,0.6931471805599453,0.6931471805599453]),0]
      * [(2000,[103,105,192,774,818,1265,1703],[0.6931471805599453,0.28768207245178085,0.6931471805599453,0.6931471805599453,0.6931471805599453,0.6931471805599453,0.6931471805599453]),0]
      * [(2000,[65,618,852,992,1194],[0.6931471805599453,0.6931471805599453,0.6931471805599453,0.6931471805599453,0.6931471805599453]),1]
      *
      */
  }

}
