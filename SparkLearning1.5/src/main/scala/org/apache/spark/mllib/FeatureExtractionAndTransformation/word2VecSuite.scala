/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.FeatureExtractionAndTransformation

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class word2VecSuite extends SparkLearningFunSuite {
  test("testFunSuite") {

    import org.apache.spark._
    import org.apache.spark.rdd._
    import org.apache.spark.SparkContext._
    import org.apache.spark.mllib.feature.{Word2Vec, Word2VecModel}

    val input = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/text8").map(line => line.split(" ").toSeq)
    //java.lang.OutOfMemoryError: Java heap space


    //    val input = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/a.txt").map(line => line.split(" ").toSeq)

    val word2vec = new Word2Vec()

    val model = word2vec.fit(input)

    val synonyms = model.findSynonyms("taiwan", 40)
    //    val synonyms = model.findSynonyms("hello", 2)
    //    val synonyms = model.findSynonyms("hell", 2)
    println("synonyms:" + synonyms.length)
    for ((synonym, cosineSimilarity) <- synonyms) {
      println(s"$synonym $cosineSimilarity")
    }

    // Save and load model
    //    model.save(sc, "myModelPath")
    //    val sameModel = Word2VecModel.load(sc, "myModelPath")

  }

  test("testFunSuite ,code From book by pk") {

    import org.apache.spark.mllib.feature.Word2Vec

    //        val input = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/text8").map(line => line.split(" ").toSeq)
    //java.lang.OutOfMemoryError: Java heap space
    val data = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/aWord2vec.txt").map(line => line.split(" ").toSeq)


    val word2vec = new Word2Vec() //创建词向量实例
    val model = word2vec.fit(data) //训练模型
    println(model.getVectors) //打印向量模型
    val synonyms = model.findSynonyms("spark", 1) //寻找spar的相似词
    println("synonyms:" + synonyms.length)
    for (synonym <- synonyms) {
      //打印找到的内容
      println(synonym)
    }
  }
}
