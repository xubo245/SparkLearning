/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.classification

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.mllib.classification.{LogisticRegressionModel, NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  */
object Bayes_MultinomialNaiveBayes {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)


    val data = sc.textFile("file/data/mllib/input/classification/sample_naive_bayes_data.txt")
    val parsedData = data.map { line =>
      val parts = line.split(',')
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
    }
    // Split data into training (60%) and test (40%).
    parsedData.foreach(println)
    val splits = parsedData.randomSplit(Array(0.6, 0.4), seed = 11L)
    val training = splits(0)
    val test = splits(1)

    val model = NaiveBayes.train(training, lambda = 1.0, modelType = "multinomial")

    val predictionAndLabel = test.map(p => (model.predict(p.features), p.label))
    val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / test.count()


    println("result:")
    println("training.count:" + training.count())
    training.foreach(println)
    println("test.count:" + test.count())
    test.foreach(println)
    println("model.modelType:" + model.modelType)
    println("accuracy:" + accuracy)
    predictionAndLabel.take(10).foreach(println)
    //    model.

    // Save and load model
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val path = "file/data/mllib/output/classification/NaiveBayesModel" + iString + "/result"
    model.save(sc, path)
    val sameModel = NaiveBayesModel.load(sc, path)
    println(sameModel.modelType)

    println("end")
    //    model.save(sc, "myModelPath")
    //    val sameModel = NaiveBayesModel.load(sc, "myModelPath")

    sc.stop
  }
}
