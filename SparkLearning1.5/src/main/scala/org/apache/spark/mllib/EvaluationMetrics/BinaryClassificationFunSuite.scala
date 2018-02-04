/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.EvaluationMetrics

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class BinaryClassificationFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {


    import org.apache.spark.mllib.classification.LogisticRegressionWithLBFGS
    import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
    import org.apache.spark.mllib.regression.LabeledPoint
    import org.apache.spark.mllib.util.MLUtils

    // Load training data in LIBSVM format
    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_binary_classification_data.txt")

    // Split data into training (60%) and test (40%)
    val Array(training, test) = data.randomSplit(Array(0.6, 0.4), seed = 11L)
    training.cache()

    // Run training algorithm to build the model
    val model = new LogisticRegressionWithLBFGS()
      .setNumClasses(2)
      .run(training)

    // Clear the prediction threshold so the model will return probabilities
    model.clearThreshold

    // Compute raw scores on the test set
    val predictionAndLabels = test.map { case LabeledPoint(label, features) =>
      val prediction = model.predict(features)
      (prediction, label)
    }

    // Instantiate metrics object
    val metrics = new BinaryClassificationMetrics(predictionAndLabels)

    // Precision by threshold
    val precision = metrics.precisionByThreshold
    precision.foreach { case (t, p) =>
      println(s"Threshold: $t, Precision: $p")
    }

    // Recall by threshold
    val recall = metrics.recallByThreshold
    recall.foreach { case (t, r) =>
      println(s"Threshold: $t, Recall: $r")
    }

    // Precision-Recall Curve
    val PRC = metrics.pr

    // F-measure
    val f1Score = metrics.fMeasureByThreshold
    f1Score.foreach { case (t, f) =>
      println(s"Threshold: $t, F-score: $f, Beta = 1")
    }

    val beta = 0.5
    val fScore = metrics.fMeasureByThreshold(beta)
    f1Score.foreach { case (t, f) =>
      println(s"Threshold: $t, F-score: $f, Beta = 0.5")
    }

    // AUPRC
    val auPRC = metrics.areaUnderPR
    println("Area under precision-recall curve = " + auPRC)

    // Compute thresholds used in ROC and PR curves
    val thresholds = precision.map(_._1)

    // ROC Curve
    val roc = metrics.roc

    // AUROC
    val auROC = metrics.areaUnderROC
    println("Area under ROC = " + auROC)


  }
}
