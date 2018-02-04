package org.apache.spark.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/11/7.
  */
object RDDLearning {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[4]").setAppName("hello RDD")
    val sc = new SparkContext(conf)
    sc.makeRDD(Array(1, 2, 3)).foreach(println)

    val rdd = sc.parallelize(List("coffee panda","happy panda","happiest panda party"))
    val mapRDD=rdd.map{x=>x.split(" ")}
    mapRDD.foreach(println)

    val flatmapRDD=rdd.flatMap{x=>x.split(" ")}
    flatmapRDD.foreach(println)
    sc.stop()

  }
}
