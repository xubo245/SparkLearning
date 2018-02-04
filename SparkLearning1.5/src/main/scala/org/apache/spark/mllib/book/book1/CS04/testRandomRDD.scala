package org.apache.spark.mllib.book.book1.CS04

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.random.RandomRDDs._

object testRandomRDD {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("testRandomRDD")
    val sc = new SparkContext(conf)
    val randomNum = normalRDD(sc, 100)
    randomNum.foreach(println)
  }
}
