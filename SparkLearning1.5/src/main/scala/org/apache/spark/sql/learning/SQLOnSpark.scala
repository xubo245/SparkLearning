package org.apache.spark.sql.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext

case class Person(name: String, age: Int)

object SQLOnSpark {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SQLOnSpark").setMaster("local")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)
    import sqlContext._
    import sqlContext.implicits._

    val people: RDD[Person] = sc.textFile("file/data/sql/input/people.txt").map(_.split(",")).map(p => Person(p(0), p(1).trim.toInt))
     println(people);
    for (i <- people) {
      println(i.age + ":" + i.name);
    }

    //parquet：first method to reads from parquet file
    val parquetFile = sqlContext.read.parquet("file/data/sql/input/wiki_parquet")
    //parquet：second method to reads from parquet file

    println(parquetFile);
    println(parquetFile.count);
    for (i <- parquetFile.take(10)) {
      //      for (j <- i) { print(j); }
      println(i);
    }
    parquetFile.show
    parquetFile.registerTempTable("parquetWiki")
    //    val parquetQuery=sql("")
    val parquetQuery = sqlContext.sql("SELECT id FROM parquetWiki")
    parquetQuery.take(20).foreach(println)
    val parquetQuery2 = sqlContext.sql("SELECT title FROM parquetWiki")
    parquetQuery2.take(20).foreach(println)
    //    people.
    //    people.
    //        people.registerAsTable("people")
    ////    people.
    //
    //    val teenagers = sqlContext.sql("SELECT name FROM people WHERE age >= 10 and age <= 19")
    //    teenagers.map(t => "Name: " + t(0)).collect().foreach(println)

    sc.stop()
  }
}