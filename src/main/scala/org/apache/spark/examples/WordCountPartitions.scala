/**
 * @author xubo
 * You can change the number of output files by changing partitions
 */
package org.apache.spark.examples

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import java.text.SimpleDateFormat
import java.util.Date
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object WordCountPartitions {
  def main(args: Array[String]) {
    //    val conf = new SparkConf().setAppName("WordCountPartitions").setMaster("local")
    val conf = new SparkConf().setAppName("WordCountPartitions").setMaster("local[4]")
    val sc = new SparkContext(conf)
    //    val text1 = sc.textFile("file/wordCount").flatMap(_.split("\\s+")).map(word => (word, 1)).reduceByKey(_ + _)
    var text1 = sc.textFile("file/data/examples/input/wordCount/*").flatMap(_.split("\\s+")).map(word => (word, 1)).reduceByKey(_ + _, 1)
    //    text1.map((k,v)=>(v,k))
    //    text1 = text1.sortBy(_._2, ascending = false) //down
    text1 = text1.sortBy(_._2, ascending = true, 2) //up
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    text1.saveAsTextFile("file/data/examples/output/wordCount" + iString);
    text1.foreach(println)
    println("WordCountPartitions Success");
    sc.stop
  }
}