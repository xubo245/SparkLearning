

//class SparkWordCount {
//  
//}
//package spark.examples

//import org.apache.spark.SparkConf
//import org.apache.spark.SparkContext
//
//import org.apache.spark.SparkContext._

package org.apache.spark.examples

import org.apache.spark._
import org.apache.spark.rdd.RDD.rddToOrderedRDDFunctions
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object SparkWordCount {
  def main(args: Array[String]) {

    if (args.length < 1) {
      System.err.println("Usage: <file>")
      System.exit(1)
    }

    val conf = new SparkConf()
    conf.setAppName("SparkWordCount")

    val sc = new SparkContext(conf)

    val rdd = sc.textFile(args(0))

    rdd.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).map(x => (x._2, x._1)).sortByKey(false).map(x => (x._2, x._1)).saveAsTextFile(args(1))

    sc.stop
  }
}