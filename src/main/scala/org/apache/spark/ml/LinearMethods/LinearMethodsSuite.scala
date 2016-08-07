package org.apache.spark.ml.LinearMethods

import breeze.linalg.max
import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xingyun.xb on 2016/7/24.
  */
class LinearMethodsSuite extends SparkLearningFunSuite {
  test("Logistic Regression Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.classification.LogisticRegression
    import org.apache.spark.mllib.util.MLUtils

    // Load training data
    val trainingRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")

    val training = sqlContext.createDataFrame(trainingRDD)

    val lr = new LogisticRegression()
      .setMaxIter(10)
      .setRegParam(0.3)
      .setElasticNetParam(0.8)

    // Fit the model
    val lrModel = lr.fit(training)

    // Print the weights and intercept for logistic regression
    println(s"Weights: ${lrModel.weights} Intercept: ${lrModel.intercept}")

  }

  test("BinaryLogisticRegressionSummary Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.classification.LogisticRegression
    import org.apache.spark.mllib.util.MLUtils
    import org.apache.spark.ml.classification.BinaryLogisticRegressionSummary

    val trainingRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")

    val training = sqlContext.createDataFrame(trainingRDD)

    val lr = new LogisticRegression()
      .setMaxIter(10)
      .setRegParam(0.3)
      .setElasticNetParam(0.8)

    // Fit the model
    val lrModel = lr.fit(training)

    // Extract the summary from the returned LogisticRegressionModel instance trained in the earlier example
    val trainingSummary = lrModel.summary

    // Obtain the objective per iteration.
    val objectiveHistory = trainingSummary.objectiveHistory
    objectiveHistory.foreach(loss => println("loss:" + loss))

    // Obtain the metrics useful to judge performance on test data.
    // We cast the summary to a BinaryLogisticRegressionSummary since the problem is a
    // binary classification problem.
    val binarySummary = trainingSummary.asInstanceOf[BinaryLogisticRegressionSummary]

    // Obtain the receiver-operating characteristic as a dataframe and areaUnderROC.
    val roc = binarySummary.roc
    println(" roc.show()")
    roc.show()
    println("binarySummary.areaUnderROC")
    println(binarySummary.areaUnderROC)

    // Set the model threshold to maximize F-Measure
    val fMeasure = binarySummary.fMeasureByThreshold
    println("fMeasure")
    fMeasure.show()

    println("maxFMeasure:")
    val maxFMeasure = fMeasure.select("F-Measure").head().getDouble(0)
    //    val maxFMeasure2 = fMeasure.select(max("F-Measure")).head().getDouble(0)

    /**
      * 没有解决
      * http://spark.apache.org/docs/1.5.2/ml-linear-methods.html
      */
    var df1 = fMeasure.select("F-Measure")
    println("****************")
    df1.foreach(println)
    println("****************")
    println(maxFMeasure)
    println()
    fMeasure.select("F-Measure").take(10).foreach(println)

    println(fMeasure.select("F-Measure").count())
    //    val bestThreshold = fMeasure.where($"F-Measure" === maxFMeasure).
    //      select("threshold").head().getDouble(0)
    //    lrModel.setThreshold(bestThreshold)

  }

  test("Linear Regression Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.regression.LinearRegression
    import org.apache.spark.mllib.util.MLUtils

    // Load training data
    val trainingRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")
    val training=sqlContext.createDataFrame(trainingRDD)

    val lr = new LinearRegression()
      .setMaxIter(10)
      .setRegParam(0.3)
      .setElasticNetParam(0.8)

    // Fit the model
    val lrModel = lr.fit(training)

    // Print the weights and intercept for linear regression
    println(s"Weights: ${lrModel.weights} Intercept: ${lrModel.intercept}")

    // Summarize the model over the training set and print out some metrics
    val trainingSummary = lrModel.summary
    println(s"numIterations: ${trainingSummary.totalIterations}")
    println(s"objectiveHistory: ${trainingSummary.objectiveHistory.toList}")
    trainingSummary.residuals.show()
    println(s"RMSE: ${trainingSummary.rootMeanSquaredError}")
    println(s"r2: ${trainingSummary.r2}")
  }


  /**
    * 线性回归，逻辑回归
    *
    */
}
