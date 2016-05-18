package org.apache.spark.sql.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object sqlTest2 {
  def main(args: Array[String]) {
    println("hello scala sql");

    val conf = new SparkConf().setAppName("sqlTest2").setMaster("local")
    val sc = new SparkContext(conf)
    val people =sc.textFile("file/data/sql/input/people.txt", 1)
    println(people.count);
    val scSQL= new SQLContext(sc)
    import scSQL._
//    import SQL
//    people.
  }
}