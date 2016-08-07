package org.apache.spark.ml.Ensembles

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xingyun.xb on 2016/7/24.
  */
class EnsemblesSuite extends SparkLearningFunSuite {
  test("Random Forests Classification Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.Pipeline
    import org.apache.spark.ml.classification.RandomForestClassifier
    import org.apache.spark.ml.classification.RandomForestClassificationModel
    import org.apache.spark.ml.feature.{StringIndexer, IndexToString, VectorIndexer}
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
    import org.apache.spark.mllib.util.MLUtils

    // Load and parse the data file, converting it to a DataFrame.
    val dataRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")
    val data = sqlContext.createDataFrame(dataRDD)

    data.show()

    // Index labels, adding metadata to the label column.
    // Fit on whole dataset to include all labels in index.
    val labelIndexer = new StringIndexer()
      .setInputCol("label")
      .setOutputCol("indexedLabel")
      .fit(data)
    // Automatically identify categorical features, and index them.
    // Set maxCategories so features with > 4 distinct values are treated as continuous.
    val featureIndexer = new VectorIndexer()
      .setInputCol("features")
      .setOutputCol("indexedFeatures")
      .setMaxCategories(4)
      .fit(data)

    // Split the data into training and test sets (30% held out for testing)
    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

    // Train a RandomForest model.
    val rf = new RandomForestClassifier()
      .setLabelCol("indexedLabel")
      .setFeaturesCol("indexedFeatures")
      .setNumTrees(10)

    // Convert indexed labels back to original labels.
    val labelConverter = new IndexToString()
      .setInputCol("prediction")
      .setOutputCol("predictedLabel")
      .setLabels(labelIndexer.labels)

    // Chain indexers and forest in a Pipeline
    val pipeline = new Pipeline()
      .setStages(Array(labelIndexer, featureIndexer, rf, labelConverter))

    // Train model.  This also runs the indexers.
    val model = pipeline.fit(trainingData)

    // Make predictions.
    val predictions = model.transform(testData)

    // Select example rows to display.
    predictions.select("predictedLabel", "label", "features").show(5)

    // Select (prediction, true label) and compute test error
    val evaluator = new MulticlassClassificationEvaluator()
      .setLabelCol("indexedLabel")
      .setPredictionCol("prediction")
      .setMetricName("precision")
    val accuracy = evaluator.evaluate(predictions)
    println("Test Error = " + (1.0 - accuracy))

    val rfModel = model.stages(2).asInstanceOf[RandomForestClassificationModel]
    println("Learned classification forest model:\n" + rfModel.toDebugString)

  }


  test("Random Forests  Regression  Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.Pipeline
    import org.apache.spark.ml.regression.RandomForestRegressor
    import org.apache.spark.ml.regression.RandomForestRegressionModel
    import org.apache.spark.ml.feature.VectorIndexer
    import org.apache.spark.ml.evaluation.RegressionEvaluator
    import org.apache.spark.mllib.util.MLUtils

    // Load and parse the data file, converting it to a DataFrame.
    val dataRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")
    val data = sqlContext.createDataFrame(dataRDD)

    // Automatically identify categorical features, and index them.
    // Set maxCategories so features with > 4 distinct values are treated as continuous.
    val featureIndexer = new VectorIndexer()
      .setInputCol("features")
      .setOutputCol("indexedFeatures")
      .setMaxCategories(4)
      .fit(data)

    // Split the data into training and test sets (30% held out for testing)
    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

    // Train a RandomForest model.
    val rf = new RandomForestRegressor()
      .setLabelCol("label")
      .setFeaturesCol("indexedFeatures")

    // Chain indexer and forest in a Pipeline
    val pipeline = new Pipeline()
      .setStages(Array(featureIndexer, rf))

    // Train model.  This also runs the indexer.
    val model = pipeline.fit(trainingData)

    // Make predictions.
    val predictions = model.transform(testData)

    // Select example rows to display.
    predictions.select("prediction", "label", "features").show(5)

    // Select (prediction, true label) and compute test error
    val evaluator = new RegressionEvaluator()
      .setLabelCol("label")
      .setPredictionCol("prediction")
      .setMetricName("rmse")
    val rmse = evaluator.evaluate(predictions)
    println("Root Mean Squared Error (RMSE) on test data = " + rmse)

    val rfModel = model.stages(1).asInstanceOf[RandomForestRegressionModel]
    println("Learned regression forest model:\n" + rfModel.toDebugString)

  }

  test("Gradient-Boosted Trees (GBTs) Classification Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.Pipeline
    import org.apache.spark.ml.classification.GBTClassifier
    import org.apache.spark.ml.classification.GBTClassificationModel
    import org.apache.spark.ml.feature.{StringIndexer, IndexToString, VectorIndexer}
    import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
    import org.apache.spark.mllib.util.MLUtils

    // Load and parse the data file, converting it to a DataFrame.
    //    val data = MLUtils.loadLibSVMFile(sc, "data/mllib/sample_libsvm_data.txt").toDF()
    val dataRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")
    val data = sqlContext.createDataFrame(dataRDD)

    // Index labels, adding metadata to the label column.
    // Fit on whole dataset to include all labels in index.
    val labelIndexer = new StringIndexer()
      .setInputCol("label")
      .setOutputCol("indexedLabel")
      .fit(data)
    // Automatically identify categorical features, and index them.
    // Set maxCategories so features with > 4 distinct values are treated as continuous.
    val featureIndexer = new VectorIndexer()
      .setInputCol("features")
      .setOutputCol("indexedFeatures")
      .setMaxCategories(4)
      .fit(data)

    // Split the data into training and test sets (30% held out for testing)
    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

    // Train a GBT model.
    val gbt = new GBTClassifier()
      .setLabelCol("indexedLabel")
      .setFeaturesCol("indexedFeatures")
      .setMaxIter(10)

    // Convert indexed labels back to original labels.
    val labelConverter = new IndexToString()
      .setInputCol("prediction")
      .setOutputCol("predictedLabel")
      .setLabels(labelIndexer.labels)

    // Chain indexers and GBT in a Pipeline
    val pipeline = new Pipeline()
      .setStages(Array(labelIndexer, featureIndexer, gbt, labelConverter))

    // Train model.  This also runs the indexers.
    val model = pipeline.fit(trainingData)

    // Make predictions.
    val predictions = model.transform(testData)

    // Select example rows to display.
    predictions.select("predictedLabel", "label", "features").show(5)

    // Select (prediction, true label) and compute test error
    val evaluator = new MulticlassClassificationEvaluator()
      .setLabelCol("indexedLabel")
      .setPredictionCol("prediction")
      .setMetricName("precision")
    val accuracy = evaluator.evaluate(predictions)
    println("Test Error = " + (1.0 - accuracy))

    val gbtModel = model.stages(2).asInstanceOf[GBTClassificationModel]
    println("Learned classification GBT model:\n" + gbtModel.toDebugString)

  }


  test("Gradient-Boosted Trees (GBTs)  Regression  Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.Pipeline
    import org.apache.spark.ml.regression.GBTRegressor
    import org.apache.spark.ml.regression.GBTRegressionModel
    import org.apache.spark.ml.feature.VectorIndexer
    import org.apache.spark.ml.evaluation.RegressionEvaluator
    import org.apache.spark.mllib.util.MLUtils

    // Load and parse the data file, converting it to a DataFrame.
    //    val data = MLUtils.loadLibSVMFile(sc, "data/mllib/sample_libsvm_data.txt").toDF()
    val dataRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")
    val data = sqlContext.createDataFrame(dataRDD)

    // Automatically identify categorical features, and index them.
    // Set maxCategories so features with > 4 distinct values are treated as continuous.
    val featureIndexer = new VectorIndexer()
      .setInputCol("features")
      .setOutputCol("indexedFeatures")
      .setMaxCategories(4)
      .fit(data)

    // Split the data into training and test sets (30% held out for testing)
    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

    // Train a GBT model.
    val gbt = new GBTRegressor()
      .setLabelCol("label")
      .setFeaturesCol("indexedFeatures")
      .setMaxIter(10)

    // Chain indexer and GBT in a Pipeline
    val pipeline = new Pipeline()
      .setStages(Array(featureIndexer, gbt))

    // Train model.  This also runs the indexer.
    val model = pipeline.fit(trainingData)

    // Make predictions.
    val predictions = model.transform(testData)

    // Select example rows to display.
    predictions.select("prediction", "label", "features").show(5)

    // Select (prediction, true label) and compute test error
    val evaluator = new RegressionEvaluator()
      .setLabelCol("label")
      .setPredictionCol("prediction")
      .setMetricName("rmse")
    val rmse = evaluator.evaluate(predictions)
    println("Root Mean Squared Error (RMSE) on test data = " + rmse)

    val gbtModel = model.stages(1).asInstanceOf[GBTRegressionModel]
    println("Learned regression GBT model:\n" + gbtModel.toDebugString)
  }

  test("One-vs-Rest (a.k.a. One-vs-All)  Regression  Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
    import org.apache.spark.mllib.evaluation.MulticlassMetrics
    import org.apache.spark.mllib.util.MLUtils
    import org.apache.spark.sql.{Row, SQLContext}

    val sqlContext = new SQLContext(sc)

    // parse data into dataframe
    //    val data = MLUtils.loadLibSVMFile(sc, "data/mllib/sample_multiclass_classification_data.txt")

    val dataRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_multiclass_classification_data.txt")
    val data = sqlContext.createDataFrame(dataRDD)

    val Array(train, test) = data.randomSplit(Array(0.7, 0.3))

    // instantiate multiclass learner and train
    val ovr = new OneVsRest().setClassifier(new LogisticRegression)

    val ovrModel = ovr.fit(train)

    // score model on test data
    val predictions = ovrModel.transform(test).select("prediction", "label")
    val predictionsAndLabels = predictions.map { case Row(p: Double, l: Double) => (p, l) }

    // compute confusion matrix
    val metrics = new MulticlassMetrics(predictionsAndLabels)
    println(metrics.confusionMatrix)

    // the Iris DataSet has three classes
    val numClasses = 3

    println("label\tfpr\n")
    (0 until numClasses).foreach { index =>
      val label = index.toDouble
      println(label + "\t" + metrics.falsePositiveRate(label))
    }
  }
}
