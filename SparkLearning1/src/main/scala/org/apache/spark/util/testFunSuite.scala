package org.apache.spark.util

/**
  * Created by xubo on 2016/6/13.
  */
class testFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    //    val conf = new SparkConf()
    //      .setMaster("local[2]")
    //      .setAppName("MLlibUnitTest")
    //    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(Array(1, 2, 3))
    val rdd2 = sc.parallelize(Array(11, 21, 31))
    println("count:" + rdd.count())
    rdd.foreach(println)
    println("union:")
    rdd.union(rdd2).foreach(println)
    //    sc.stop()
  }
}
