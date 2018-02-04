package org.apache.spark.examples

//class SparkWordCount {
//  
//}
//package spark.examples

//import org.apache.spark.SparkConf
//import org.apache.spark.SparkContext
//
//import org.apache.spark.SparkContext._

import org.apache.spark._
import org.apache.spark.SparkContext._
import java.util._
import java.text.SimpleDateFormat
import org.apache.spark.rdd.RDD.rddToOrderedRDDFunctions
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object WordCountByTime {
  def main(args: Array[String]) {

    val conf = new SparkConf()
    conf.setAppName("SparkWordCount").setMaster("local[4]")

    val sc = new SparkContext(conf)
    val s0 = "file/data/examples/input/wordCount/*"

    val rdd = sc.textFile(s0)

    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val s1 = "file/data/examples/output/wordCount" + iString;

    rdd.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).map(x => (x._2, x._1)).sortByKey(false).map(x => (x._2, x._1)).saveAsTextFile(s1)
    println("end");
    sc.stop
  }
}