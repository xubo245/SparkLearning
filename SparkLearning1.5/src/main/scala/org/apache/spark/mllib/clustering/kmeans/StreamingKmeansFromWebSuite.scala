/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.clustering.kmeans

import org.apache.spark.SparkConf
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.clustering.StreamingKMeans
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  * 需要集群运行，目前没有运行测试
  */
class StreamingKmeansFromWebSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    val conf = new SparkConf()
      .setMaster("local[4]")
      .setAppName("SparkLearningTest")
    val ssc = new StreamingContext(conf, Seconds(1))
    val trainingData = ssc.textFileStream("file/data/mllib/input/trainingDic").map(Vectors.parse)
    val testData = ssc.textFileStream("file/data/mllib/input/testingDic").map(LabeledPoint.parse)
    val numDimensions = 3
    val numClusters = 2
    val model = new StreamingKMeans()
      .setK(numClusters)
      .setDecayFactor(1.0)
      .setRandomCenters(numDimensions, 0.0)
    model.trainOn(trainingData)
    model.predictOnValues(testData.map(lp => (lp.label, lp.features))).print()

    ssc.start()
    ssc.awaitTermination()
  }
}
