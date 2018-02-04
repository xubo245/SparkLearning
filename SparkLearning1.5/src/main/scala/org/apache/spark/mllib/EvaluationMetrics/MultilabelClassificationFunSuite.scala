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
class MultilabelClassificationFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {


    import org.apache.spark.mllib.evaluation.MultilabelMetrics
    import org.apache.spark.rdd.RDD;

    val scoreAndLabels: RDD[(Array[Double],Array[Double])] = sc.parallelize(
      Seq((Array(0.0, 1.0), Array(0.0, 2.0)), (Array(0.0, 2.0), Array(0.0, 1.0)),
      (Array(), Array(0.0)),
      (Array(2.0), Array(2.0)),
      (Array(2.0, 0.0), Array(2.0, 0.0)),
      (Array(0.0, 1.0, 2.0), Array(0.0, 1.0)), (Array(1.0), Array(1.0, 2.0))), 2)

    // Instantiate metrics object
    val metrics = new MultilabelMetrics(scoreAndLabels)

    // Summary stats
    println(s"Recall = ${metrics.recall}")
    println(s"Precision = ${metrics.precision}")
    println(s"F1 measure = ${metrics.f1Measure}")
    println(s"Accuracy = ${metrics.accuracy}")

    // Individual label stats
    metrics.labels.foreach(label => println(s"Class $label precision = ${metrics.precision(label)}"))
    metrics.labels.foreach(label => println(s"Class $label recall = ${metrics.recall(label)}"))
    metrics.labels.foreach(label => println(s"Class $label F1-score = ${metrics.f1Measure(label)}"))

    // Micro stats
    println(s"Micro recall = ${metrics.microRecall}")
    println(s"Micro precision = ${metrics.microPrecision}")
    println(s"Micro F1 measure = ${metrics.microF1Measure}")

    // Hamming loss
    println(s"Hamming loss = ${metrics.hammingLoss}")

    // Subset accuracy
    println(s"Subset accuracy = ${metrics.subsetAccuracy}")


  }
}
