package org.apache.spark.utils.learning

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterAll, FunSuite, Suite}

/**
  * Created by xubo on 2016/6/13.
  */
class SparkLearningFunSuite extends FunSuite with BeforeAndAfterAll {
  self: Suite =>
  @transient var sc: SparkContext = _
  @transient var sqlContext: SQLContext = _
   var spark: SparkSession = _
  Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
  Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

  // For implicit conversions like converting RDDs to DataFrames


  //   val conf = new SparkConf().setMaster("local[2]").setAppName("MLlibUnitTest")
  //   sc = new SparkContext(conf)
  override def beforeAll() {
    super.beforeAll()
    val conf = new SparkConf()
      .setMaster("local[4]")
      .setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))

    sc = new SparkContext(conf)
    //    sqlContext = new SQLContext(sc)
    spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .master("local[4]")
      .getOrCreate()
  }

  override def afterAll() {
    //    println(sc)
    //    sqlContext = null
    if (sc != null) {
      sc.stop()
    }
    sc = null
    //    println(sc)
    super.afterAll()
  }
}
