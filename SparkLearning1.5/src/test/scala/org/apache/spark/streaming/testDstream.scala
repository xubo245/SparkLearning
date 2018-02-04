package org.apache.spark.streaming

import java.util.Date

import org.apache.spark.SparkConf

/**
  * Created by xubo on 2016/5/22.
  */
object testDstream {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(1))
    val lines = ssc.socketTextStream("localhost", 9999)
    val words = lines.flatMap(_.split(" "))
    //            words.getOrCompute(time) //time:Time

    ssc.stop()
  }
}
