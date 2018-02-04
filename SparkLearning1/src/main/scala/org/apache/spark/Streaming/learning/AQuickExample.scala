/**
  * @author xubo
  *         ref http://spark.apache.org/docs/1.5.2/streaming-programming-guide.html
  * @time 20160425
  * @spark-1.5.2
  */
package org.apache.spark.Streaming.learning

import org.apache.spark.streaming.dstream._

object AQuickExample {

  def main(args: Array[String]): Unit = {

    import org.apache.spark._
    import org.apache.spark.streaming._
    import org.apache.spark.streaming.StreamingContext._
    // not necessary since Spark 1.3

    // Create a local StreamingContext with two working thread and batch interval of 1 second.
    // The master requires 2 cores to prevent from a starvation scenario.

    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(1))
    val lines = ssc.socketTextStream("localhost", 9999)
    val words = lines.flatMap(_.split(" "))
    //words.g
    import org.apache.spark.streaming.StreamingContext._
    // not necessary since Spark 1.3
    // Count each word in each batch
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)

    // Print the first ten elements of each RDD generated in this DStream to the console
    wordCounts.print()
    ssc.start() // Start the computation
    ssc.awaitTermination()
  }

}