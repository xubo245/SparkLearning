

//class SparkWordCount {
//  
//}
//package spark.examples

//import org.apache.spark.SparkConf
//import org.apache.spark.SparkContext
//
//import org.apache.spark.SparkContext._

package org.apache.spark.examplesByXubo.wordCount

import org.apache.spark._

object SparkWordCount {
  def main(args: Array[String]) {

    if (args.length < 1) {
      System.err.println("Usage: <file>")
      System.exit(1)
    }

    //����Spark����ʱ��������Ϣ
    /*
      Configuration for a Spark application. Used to set various Spark parameters as key-value pairs.
      Most of the time, you would create a SparkConf object with `new SparkConf()`, which will load
      values from any `spark.*` Java system properties set in your application as well. In this case,
      parameters you set directly on the `SparkConf` object take priority over system properties.
     */
    val conf = new SparkConf()
    conf.setAppName("SparkWordCount")

    //����Spark��������

    /*
       Main entry point for Spark functionality. A SparkContext represents the connection to a Spark
       cluster, and can be used to create RDDs, accumulators and broadcast variables on that cluster.
       Only one SparkContext may be active per JVM.  You must `stop()` the active SparkContext before
       creating a new one.  This limitation may eventually be removed; see SPARK-2243 for more details.
  
       @param config a Spark Config object describing the application configuration. Any settings in this config overrides the default configs as well as system properties.
    */

    val sc = new SparkContext(conf)

    ///��HDFS�л�ȡ�ı�(û��ʵ�ʵĽ��ж�ȡ)������MappedRDD
    val rdd = sc.textFile(args(0))

    //�������value reduceByKey is not a member of org.apache.spark.rdd.RDD[(String, Int)]������Ҫimport org.apache.spark.SparkContext._
    rdd.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).map(x => (x._2, x._1)).sortByKey(false).map(x => (x._2, x._1)).saveAsTextFile(args(1))

    sc.stop
  }
}