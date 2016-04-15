package com.apache.spark.rdd.test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object rddTest {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark MLlib Exercise:K-Means Clustering(KMeansTest4ByIBmSaveAsFileCluster)").setMaster("local")
    val sc = new SparkContext(conf)
    var text1 = sc.textFile("hdfs://219.219.220.149:9000/xubo/spark/data/mllib/als", 1)
    println(text1.count);
    println(text1.id);
    println(text1.name);
    println(text1.partitions.length);
    text1.partitions.foreach(println)
    println(text1.toDebugString);
    var text2 = sc.textFile("hdfs://219.219.220.149:9000/xubo/spark/data/mllib/kmeans", 1)
    println("\ntext2:");
    println(text2.count);
    println(text2.id);
    println(text2.name);
    println(text2.partitions.length);
    text2.partitions.foreach(println)
    println(text2.toDebugString);
//    for (i <- text2.partitions) {
//      for (j <- i.toString()) println(j)
//    }

    sc.stop

  }
}