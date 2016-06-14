/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.Optimization

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class LBFGSFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {


    import org.apache.spark.SparkContext
    import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
    import org.apache.spark.mllib.linalg.Vectors
    import org.apache.spark.mllib.util.MLUtils
    import org.apache.spark.mllib.classification.LogisticRegressionModel
    import org.apache.spark.mllib.optimization.{LBFGS, LogisticGradient, SquaredL2Updater}

    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_libsvm_data.txt")
    val numFeatures = data.take(1)(0).features.size

    // Split data into training (60%) and test (40%).
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)

    // Append 1 into the training data as intercept.
    val training = splits(0).map(x => (x.label, MLUtils.appendBias(x.features))).cache()

    val test = splits(1)

    // Run training algorithm to build the model
    val numCorrections = 10
    val convergenceTol = 1e-4
    val maxNumIterations = 20
    val regParam = 0.1
    val initialWeightsWithIntercept = Vectors.dense(new Array[Double](numFeatures + 1))

    val (weightsWithIntercept, loss) = LBFGS.runLBFGS(
      training,
      new LogisticGradient(),
      new SquaredL2Updater(),
      numCorrections,
      convergenceTol,
      maxNumIterations,
      regParam,
      initialWeightsWithIntercept)

    val model = new LogisticRegressionModel(
      Vectors.dense(weightsWithIntercept.toArray.slice(0, weightsWithIntercept.size - 1)),
      weightsWithIntercept(weightsWithIntercept.size - 1))

    // Clear the default threshold.
    model.clearThreshold()

    // Compute raw scores on the test set.
    val scoreAndLabels = test.map { point =>
      val score = model.predict(point.features)
      (score, point.label)
    }

    // Get evaluation metrics.
    val metrics = new BinaryClassificationMetrics(scoreAndLabels)
    val auROC = metrics.areaUnderROC()

    println("Loss of each step in training process")
    loss.foreach(println)
    println("Area under ROC = " + auROC)


  }
}
