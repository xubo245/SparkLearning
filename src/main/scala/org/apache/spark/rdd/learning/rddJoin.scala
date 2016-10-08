package org.apache.spark.rdd.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object rddJoin {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("rddJoin").setMaster("local")
    val sc = new SparkContext(conf)

    val rdd1 = sc.parallelize(Array((1, 21), (2, 42), (3, 41)), 1)
    val rdd2 = sc.parallelize(Array((3, 4), (4, 41)), 1)
    val rdd3 = rdd1.join(rdd2)
    rdd3.foreach(println)
    rdd1.zipWithIndex.foreach(println)
    var rdd4=rdd1.sortByKey();
    //    rdd1.zip
  }
  //   def alignment()=withScope{}
}