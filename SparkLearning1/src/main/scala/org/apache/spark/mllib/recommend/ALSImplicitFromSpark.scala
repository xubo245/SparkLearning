/**
  *
  * 不对，没有利用隐式数据
  */
package org.apache.spark.mllib.recommend

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.mllib.recommendation.{ALS, MatrixFactorizationModel, Rating}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/16.
  */
object ALSImplicitFromSpark {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    //    println(this.getClass().getSimpleName().filter(!_.equals('$')))
    //设置环境变量
    val sc = new SparkContext(conf)

    // Load and parse the data
    //    val data = sc.textFile("data/mllib/als/test.data")
    val data = sc.textFile("file/data/mllib/input/test.data")

    val ratings = data.map(_.split(',') match { case Array(user, item, rate) =>
      Rating(user.toInt, item.toInt, rate.toDouble)
    })

    // Build the recommendation model using ALS
    val rank = 10
    val numIterations = 10

    val alpha = 0.01
    val lambda = 0.01
    val model = ALS.trainImplicit(ratings, rank, numIterations, lambda, alpha)
    //    val model = ALS.train(ratings, rank, numIterations, 0.01)

    // Evaluate the model on rating data
    val usersProducts = ratings.map { case Rating(user, product, rate) =>
      (user, product)
    }
    val predictions =
      model.predict(usersProducts).map { case Rating(user, product, rate) =>
        ((user, product), rate)
      }
    val ratesAndPreds = ratings.map { case Rating(user, product, rate) =>
      ((user, product), rate)
    }.join(predictions)
    val MSE = ratesAndPreds.map { case ((user, product), (r1, r2)) =>
      val err = (r1 - r2)
      err * err
    }.mean()
    println("Mean Squared Error = " + MSE)

    // Save and load model
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    model.save(sc, "file/data/mllib/output/als/myModelPath" + iString)
    val sameModel = MatrixFactorizationModel.load(sc, "file/data/mllib/output/als/myModelPath" + iString)

    /**
      * recommend
      */
    val rs = sameModel.recommendProducts(2, 1)
    rs.foreach(println)
    println("error")
    sc.stop()
  }
}
