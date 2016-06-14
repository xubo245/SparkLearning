/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.classification

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.mllib.regression.{IsotonicRegression, IsotonicRegressionModel}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  */
object IsotonicRegression1 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    // Load and parse the data file.
    //    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/dt.txt")

    val data = sc.textFile("file/data/mllib/input/classification/sample_isotonic_regression_data.txt")

    // Create label, feature, weight tuples from input data with weight set to default value 1.0.
    val parsedData = data.map { line =>
      val parts = line.split(',').map(_.toDouble)
      (parts(0), parts(1), 1.0)
    }

    // Split data into training (60%) and test (40%) sets.
    val splits = parsedData.randomSplit(Array(0.6, 0.4), seed = 11L)
    val training = splits(0)
    val test = splits(1)

    // Create isotonic regression model from training data.
    // Isotonic parameter defaults to true so it is only shown for demonstration
    val model = new IsotonicRegression().setIsotonic(true).run(training)

    // Create tuples of predicted and real labels.
    val predictionAndLabel = test.map { point =>
      val predictedLabel = model.predict(point._2)
      (predictedLabel, point._1)
    }

    // Calculate mean squared error between predicted and real labels.
    val meanSquaredError = predictionAndLabel.map { case (p, l) => math.pow((p - l), 2) }.mean()
    println("Mean Squared Error = " + meanSquaredError)
    println("data.count:" + data.count())
    println("trainingData.count:" + training.count())
    println("testData.count:" + test.count())
    println(model.boundaries)
    println(model.isotonic)
    model.predictions.take(10).foreach(println)
    println("predictionAndLabel")
    predictionAndLabel.take(10).foreach(println)


    //         Save and load model
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val path = "file/data/mllib/output/classification/IsotonicRegressionModel" + iString + "/result"
    model.save(sc, path)
    val sameModel = IsotonicRegressionModel.load(sc, path)
    println(sameModel.isotonic)

    sc.stop
  }
}
