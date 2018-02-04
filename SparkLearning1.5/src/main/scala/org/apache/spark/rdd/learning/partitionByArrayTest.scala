package org.apache.spark.rdd.learning

import org.apache.spark.{SparkConf, SparkContext}

/**
  * @author xubo
  *         测试contains是否可以包含两个字符串，split可以用array。但是contains的默认是any，所以只能一个字符串
  *         下面是验证的代码，源码可以看SeqLike
  */
object partitionByArrayTest {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("partitionByArrayTest").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val text1 = sc.textFile("file/data/RDD/input/als/sample_movielens_ratings.txt")
    println("text1:")
    text1.take(10).foreach(println)
    println("contains:")
    val con = text1.map { each => if (each.contains("11::")) {
      each
    } else {
      null
    }
    }.filter(_ != null)

    con.take(10).foreach(println)
    println(con.count())
    println("con2:")
    val con2 = text1.map { each =>
      //      each.toString.contains
      if (each.contains(Array("11::", "80::").toSeq)) {
        //      if (each.toString.contains(Array("11::", "80::").toSeq)) {
        each
      } else {
        null
      }
    }.filter(_ != null)
    con2.take(10).foreach(println)
    println(con2.count())

    sc.stop()
    //    rdd1.zip
  }
}