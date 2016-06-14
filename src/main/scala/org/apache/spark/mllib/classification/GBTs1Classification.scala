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

/**
  * Created by xubo on 2016/5/23.
  */
object GBTs1Classification {
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
    var boostingStrategy = BoostingStrategy.defaultParams("Classification")
    boostingStrategy.setNumIterations(3)
    boostingStrategy.treeStrategy.setNumClasses(2)
    boostingStrategy.treeStrategy.setMaxDepth(5)
    //    boostingStrategy.treeStrategy.setCategoricalFeaturesInfo( java.util.Map[Integer, Integer]())

    //error
    //    boostingStrategy.numIterations = 3 // Note: Use more iterations in practice.
    //    boostingStrategy.treeStrategy.numClasses = 2
    //    boostingStrategy.treeStrategy.maxDepth = 5
    //    //  Empty categoricalFeaturesInfo indicates all features are continuous.
    //        boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int, Int]()

    val model = GradientBoostedTrees.train(trainingData, boostingStrategy)

    // Evaluate model on test instances and compute test error
    val labelAndPreds = testData.map { point =>
      val prediction = model.predict(point.features)
      (point.label, prediction)
    }
    val testErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble / testData.count()
    println("Test Error = " + testErr)
    println("Learned classification GBT model:\n" + model.toDebugString)


    println("data.count:" + data.count())
    println("trainingData.count:" + trainingData.count())
    println("testData.count:" + testData.count())
    println("model.algo:" + model.algo)
    println("model.trees:" + model.trees)
    println("model.treeWeights:" + model.treeWeights)

    println("labelAndPreds")
    labelAndPreds.take(10).foreach(println)


    //     Save and load model
    //    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    //    val path = "file/data/mllib/output/classification/GradientBoostedTreesModel" + iString + "/result"
    //    model.save(sc, path)
    //    val sameModel = DecisionTreeModel.load(sc, path)
    //    println(sameModel.algo)
    sc.stop
  }
}
