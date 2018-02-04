/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.clustering.PowerIterationClusteringLearning

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class PICFromWebSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    import org.apache.spark.mllib.clustering.{PowerIterationClustering, PowerIterationClusteringModel}
    import org.apache.spark.mllib.linalg.Vectors

    // Load and parse the data
    val data = sc.textFile("file/data/mllib/input/mllibFromSpark/pic_data.txt")
    val similarities = data.map { line =>
      val parts = line.split(' ')
      (parts(0).toLong, parts(1).toLong, parts(2).toDouble)
    }

    // Cluster the data into two classes using PowerIterationClustering
    val pic = new PowerIterationClustering()
      .setK(2)
      .setMaxIterations(10)
    val model = pic.run(similarities)

    model.assignments.foreach { a =>
      println(s"${a.id} -> ${a.cluster}")
    }
//    model.pre
    // Save and load model
    //    model.save(sc, "myModelPath")
    //    val sameModel = PowerIterationClusteringModel.load(sc, "myModelPath")F
  }
}
