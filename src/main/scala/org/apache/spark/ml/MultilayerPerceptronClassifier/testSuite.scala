package org.apache.spark.ml.MultilayerPerceptronClassifier

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * 多层感知器分类器
  * Multilayer perceptron classifier (MLPC) is a classifier based on the feedforward artificial neural network.
  *
  * Created by xingyun.xb on 2016/7/24.
  */
class testSuite extends SparkLearningFunSuite {
  test("Multilayer perceptron classifier Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
    import org.apache.spark.mllib.util.MLUtils
    import org.apache.spark.sql.Row

    // Load training data
    val dataRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_multiclass_classification_data.txt")
    val data = sqlContext.createDataFrame(dataRDD)
    // Split the data into train and test
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
    val train = splits(0)
    val test = splits(1)
    // specify layers for the neural network:
    // input layer of size 4 (features), two intermediate of size 5 and 4 and output of size 3 (classes)
    val layers = Array[Int](4, 5, 4, 3)
    // create the trainer and set its parameters
    val trainer = new MultilayerPerceptronClassifier()
      .setLayers(layers)
      .setBlockSize(128)
      .setSeed(1234L)
      .setMaxIter(100)
    // train the model
    val model = trainer.fit(train)
    // compute precision on the test set
    val result = model.transform(test)
    val predictionAndLabels = result.select("prediction", "label")

    data.show()
    data.take(20).foreach(println)
    result.show()
    result.take(20).foreach(println)

    val evaluator = new MulticlassClassificationEvaluator()
      .setMetricName("precision")
    println("Precision:" + evaluator.evaluate(predictionAndLabels))

  }

}
