/**
 * @author xubo
 * spark 1.5.2
 *
 * reference :http://spark.apache.org/docs/1.5.2/sql-programming-guide.html
 */
package com.apache.spark.sql.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.rdd.RDD

object SparkSQLExamplesFromParquet {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("SQLOnSpark").setMaster("local")
    val sc = new SparkContext(conf)
    //    val sqlContext = new SQLContext(sc)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext._
    import sqlContext.implicits._

//    val people = sc.textFile("hdfs://219.219.220.149:9000/xubo/spark/examples/src/main/resources/people.txt")

    val df = sqlContext.read.load("file/data/examples/src/main/resources/users.parquet")
    df.show
    df.select("name", "favorite_color").write.save("file/data/sql/output/namesAndFavColors.parquet")

  }

}