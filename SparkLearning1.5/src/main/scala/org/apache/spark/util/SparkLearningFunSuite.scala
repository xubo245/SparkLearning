package org.apache.spark.util

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterAll, FunSuite, Suite}

/**
  * Created by xubo on 2016/6/13.
  */
class SparkLearningFunSuite extends FunSuite with BeforeAndAfterAll {
  self: Suite =>
  @transient var sc: SparkContext = _
  @transient var sqlContext: SQLContext = _
  Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
  Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

  //   val conf = new SparkConf().setMaster("local[2]").setAppName("MLlibUnitTest")
  //   sc = new SparkContext(conf)
  override def beforeAll() {
    super.beforeAll()
    val conf = new SparkConf()
      .setMaster("local[4]")
      .setAppName("SparkLearningTest")
    //    println("start sc")
    sc = new SparkContext(conf)
    sqlContext = new SQLContext(sc)
  }

  override def afterAll() {
    //    println(sc)
    sqlContext = null
    if (sc != null) {
      sc.stop()
    }
    sc = null
    //    println(sc)
    super.afterAll()
  }
}
