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
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  */
object DecisionTrees1ByGiniClassification {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    // Load and parse the data file.
    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/sample_libsvm_data.txt")
    // Split the data into training and test sets (30% held out for testing)
    val splits = data.randomSplit(Array(0.7, 0.3))
    val (trainingData, testData) = (splits(0), splits(1))

    // Train a DecisionTree model.
    //  Empty categoricalFeaturesInfo indicates all features are continuous.
    val numClasses = 2
    val categoricalFeaturesInfo = Map[Int, Int]()
    val impurity = "gini"
    val maxDepth = 5
    val maxBins = 32

    val model = DecisionTree.trainClassifier(trainingData, numClasses, categoricalFeaturesInfo,
      impurity, maxDepth, maxBins)

    // Evaluate model on test instances and compute test error
    val labelAndPreds = testData.map { point =>
      val prediction = model.predict(point.features)
      (point.label, prediction)
    }
    val testErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble / testData.count()
    println("Test Error = " + testErr)
    println("Learned classification tree model:\n" + model.toDebugString)
    println("data.count:" + data.count())
    println("trainingData.count:" + trainingData.count())
    println("testData.count:" + testData.count())
    println("model.depth:"+model.depth)
    println("model.numNodes:"+model.numNodes)
    println("model.topNode:"+model.topNode)

    println("labelAndPreds")
    labelAndPreds.take(30).foreach(println)
    // Save and load model
    //    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    //    val path = "file/data/mllib/output/classification/DecisionTreesLearning" + iString + "/result"
    //    model.save(sc, path)
    //    val sameModel = DecisionTreeModel.load(sc, path)
    //    println(sameModel.algo)
    sc.stop
  }
}
