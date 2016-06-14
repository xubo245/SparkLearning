/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.classification

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.mllib.classification.NaiveBayes._
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkException, SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  * From:NaiveBayesSuite.scala in spark 1.5.2 sources
  * another examples:NaiveBayesSuite  test("Naive Bayes Bernoulli")
  */
object Bayes_BernoulliNaiveBayes {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    val badTrain = Seq(
      LabeledPoint(1.0, Vectors.dense(1.0)),
      //      LabeledPoint(0.0, Vectors.dense(2.0)),
      LabeledPoint(1.0, Vectors.dense(1.0)),
      LabeledPoint(1.0, Vectors.dense(0.0)))


    val model1 = NaiveBayes.train(sc.makeRDD(badTrain, 2), 1.0, Bernoulli)
    println("model1:")
    println(model1)
    sc.makeRDD(badTrain, 2).foreach(println)

    val okTrain = Seq(
      LabeledPoint(1.0, Vectors.dense(1.0)),
      LabeledPoint(0.0, Vectors.dense(0.0)),
      LabeledPoint(1.0, Vectors.dense(1.0)),
      LabeledPoint(1.0, Vectors.dense(1.0)),
      LabeledPoint(0.0, Vectors.dense(0.0)),
      LabeledPoint(1.0, Vectors.dense(1.0)),
      LabeledPoint(1.0, Vectors.dense(1.0))
    )

    val badPredict = Seq(
      Vectors.dense(1.0),
      //      Vectors.dense(2.0),
      Vectors.dense(1.0),
      Vectors.dense(0.0))

    val model = NaiveBayes.train(sc.makeRDD(okTrain, 2), 1.0, Bernoulli)
    //    intercept[SparkException] {
    val pre2 = model.predict(sc.makeRDD(badPredict, 2)).collect()
    //    }
    println("model2:")
    sc.makeRDD(okTrain, 2).foreach(println)
    println("predict data:")
    sc.makeRDD(badPredict, 2).foreach(println)
    println(model)
    println("predict result:")
    pre2.foreach(println)

    sc.stop
  }
}
