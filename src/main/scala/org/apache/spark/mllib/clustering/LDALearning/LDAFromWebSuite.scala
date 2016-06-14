/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.clustering.LDALearning

import org.apache.spark.mllib.clustering.LDA
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class LDAFromWebSuite extends SparkLearningFunSuite {
  test("testFunSuite") {


    import org.apache.spark.mllib.linalg.Vectors

    // Load and parse the data
    val data = sc.textFile("file/data/mllib/input/mllibFromSpark/sample_lda_data.txt")
    val parsedData = data.map(s => Vectors.dense(s.trim.split(' ').map(_.toDouble)))
    // Index documents with unique IDs
    val corpus = parsedData.zipWithIndex.map(_.swap).cache()

    // Cluster the documents into three topics using LDA
    val ldaModel = new LDA().setK(3).run(corpus)

    //input data
    println("parsedData:")
    parsedData.foreach(println)
    println("corpus:")
    corpus.foreach(println)

    // Output topics. Each is a distribution over words (matching word count vectors)
    println("Learned topics (as distributions over vocab of " + ldaModel.vocabSize + " words):")
    val topics = ldaModel.topicsMatrix
    for (topic <- Range(0, 3)) {
      print("Topic " + topic + ":")
      for (word <- Range(0, ldaModel.vocabSize)) {
        print(" " + topics(word, topic));
      }
      println()
    }

    // Save and load model.
    //    ldaModel.save(sc, "myLDAModel")
    //    val sameModel = DistributedLDAModel.load(sc, "myLDAModel")


  }
}
