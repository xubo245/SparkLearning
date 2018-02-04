package org.apache.spark.mllib.FeatureExtractionAndTransformation

/**
  * Created by xubo on 2016/6/13.
  * data:http://mattmahoney.net/dc/text8.zip
  */
object Word2VecSparkWeb {
  def main(args: Array[String]) {
    import org.apache.spark._
    import org.apache.spark.rdd._
    import org.apache.spark.SparkContext._
    import org.apache.spark.mllib.feature.{Word2Vec, Word2VecModel}
    val conf = new SparkConf()
      .setAppName("Word2VecSparkWeb")
    //    println("start sc")
    val sc = new SparkContext(conf)
//    "file/data/mllib/input/FeatureExtractionAndTransformation/text8"
    val input = sc.textFile(args(0)).map(line => line.split(" ").toSeq)
    //java.lang.OutOfMemoryError: Java heap space


    //    val input = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/a.txt").map(line => line.split(" ").toSeq)

    val word2vec = new Word2Vec()

    val model = word2vec.fit(input)

    val synonyms = model.findSynonyms("china", 40)
    //    val synonyms = model.findSynonyms("hello", 2)
    //    val synonyms = model.findSynonyms("hell", 2)
    println("synonyms:" + synonyms.length)
    for ((synonym, cosineSimilarity) <- synonyms) {
      println(s"$synonym $cosineSimilarity")
    }
  }
}
