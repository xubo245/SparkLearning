/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.PredictiveModelMarkupLanguage

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class PMMLFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    import org.apache.spark.mllib.clustering.KMeans
    import org.apache.spark.mllib.linalg.Vectors

    // Load and parse the data
    val data = sc.textFile("file/data/mllib/input/mllibFromSpark/kmeans_data.txt")
    val parsedData = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble))).cache()

    // Cluster the data into two classes using KMeans
    val numClusters = 2
    val numIterations = 20
    val clusters = KMeans.train(parsedData, numClusters, numIterations)

    // Export to PMML
    println("PMML Model:\n" + clusters.toPMML)
    clusters.clusterCenters.foreach(println)
    // Export the model to a String in PMML format
    clusters.toPMML

    //    // Export the model to a local file in PMML format
    //    clusters.toPMML("file/data/mllib/output/mllibFromSpark/kmeans.xml")
    //
    //    // Export the model to a directory on a distributed file system in PMML format
    //    clusters.toPMML(sc, "file/data/mllib/output/mllibFromSpark/kmeans")

    // Export the model to the OutputStream in PMML format
    //    clusters.toPMML(System.out)
  }
}
