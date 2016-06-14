package org.apache.spark.mllib.recommend

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.mllib.recommendation.{ALS, MatrixFactorizationModel, Rating}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/16.
  */
object ALSFromSparkPredict {
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
    val model = ALS.train(ratings, rank, numIterations, 0.01)

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

    println("user 2 ,top 1")
    var rs = sameModel.recommendProducts(2, 1)

    rs.foreach(println)
    println("user 2 ,top 2")
    rs = sameModel.recommendProducts(2, 2)

    rs.foreach(println)
    println("user 2 ,top 3")
    rs = sameModel.recommendProducts(2, 3)

    rs.foreach(println)
    println("user 2 ,top 4")
    rs = sameModel.recommendProducts(2, 4)

    rs.foreach(println)
    println("user 2 ,top 5")
    rs = sameModel.recommendProducts(2, 5)
    rs.foreach(println)

    println(sameModel.predict(2, 1))
    println(sameModel.predict(2, 2))
    println(sameModel.predict(2, 3))
    println(sameModel.predict(2, 4))
    //    println(sameModel.predict(2,5))//error


  }
}
