/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.classification

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.tree.GradientBoostedTrees
import org.apache.spark.mllib.tree.configuration.BoostingStrategy
import org.apache.spark.mllib.tree.model.{DecisionTreeModel, GradientBoostedTreesModel}
import org.apache.spark.mllib.util.MLUtils
import java.util.Map
import org.apache.spark.mllib.tree.GradientBoostedTrees
import org.apache.spark.mllib.tree.configuration.BoostingStrategy
import org.apache.spark.mllib.tree.model.GradientBoostedTreesModel
import org.apache.spark.mllib.util.MLUtils

/**
  * Created by xubo on 2016/5/23.
  */
object GBTs2Regression {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    // Load and parse the data file.
    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/sample_libsvm_data.txt")

    // Split the data into training and test sets (30% held out for testing)
    val splits = data.randomSplit(Array(0.7, 0.3))
    val (trainingData, testData) = (splits(0), splits(1))

    // Train a GradientBoostedTrees model.
    //  The defaultParams for Classification use LogLoss by default.
    val boostingStrategy = BoostingStrategy.defaultParams("Regression")
    boostingStrategy.setNumIterations(3)
    boostingStrategy.treeStrategy.setMaxDepth(5)
    //    boostingStrategy.treeStrategy.setCategoricalFeaturesInfo(Map[Int, Int]())

    // Train a GradientBoostedTrees model.
    //  The defaultParams for Regression use SquaredError by default.
    //    val boostingStrategy = BoostingStrategy.defaultParams("Regression")
    //    boostingStrategy.numIterations = 3 // Note: Use more iterations in practice.
    //    boostingStrategy.treeStrategy.maxDepth = 5
    //    //  Empty categoricalFeaturesInfo indicates all features are continuous.
    //    boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int, Int]()

    val model = GradientBoostedTrees.train(trainingData, boostingStrategy)

    // Evaluate model on test instances and compute test error
    val labelsAndPredictions = testData.map { point =>
      val prediction = model.predict(point.features)
      (point.label, prediction)
    }
    val testMSE = labelsAndPredictions.map { case (v, p) => math.pow((v - p), 2) }.mean()
    println("Test Mean Squared Error = " + testMSE)
    println("Learned regression GBT model:\n" + model.toDebugString)



    println("data.count:" + data.count())
    println("trainingData.count:" + trainingData.count())
    println("testData.count:" + testData.count())
    println("model.algo:" + model.algo)
    println("model.trees:" + model.trees)
    println("model.treeWeights:" + model.treeWeights)



    //     Save and load model
    //    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    //    val path = "file/data/mllib/output/classification/GradientBoostedTreesModel" + iString + "/result"
    //    model.save(sc, path)
    //    val sameModel = DecisionTreeModel.load(sc, path)
    //    println(sameModel.algo)
    sc.stop
  }
}
