/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.clustering.GaussianMixtureLearning

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.mllib.clustering.{GaussianMixture, GaussianMixtureModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class GaussianMixtureFromWebSuite extends SparkLearningFunSuite {
  test("testFunSuite") {

    // Load and parse the data
    val data = sc.textFile("file/data/mllib/input/mllibFromSpark/gmm_data.txt")
    val parsedData = data.map(s => Vectors.dense(s.trim.split(' ').map(_.toDouble))).cache()

    // Cluster the data into two classes using GaussianMixture
    val gmm = new GaussianMixture().setK(3).run(parsedData)

    // Save and load model
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val output = "file/data/mllib/output/mllibFromSpark/myGMMModel" + iString
    println("output:" + output)
    println("gmm.weights:" + gmm.weights)
    println("gmm.weights.length:" + gmm.weights.length)

    //    gmm.save(sc, output)
    //    val sameModel = GaussianMixtureModel.load(sc, output)

    // output parameters of max-likelihood model
    for (i <- 0 until gmm.k) {
      println("weight=%f\nmu=%s\nsigma=\n%s\n" format
        (gmm.weights(i), gmm.gaussians(i).mu, gmm.gaussians(i).sigma))
    }
  }
}
