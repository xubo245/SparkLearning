/**
 * @author xubo
 * spark 1.5.2
 * status :success
 * reference :http://spark.apache.org/docs/1.5.2/sql-programming-guide.html
 */
package org.apache.spark.sql.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.rdd.RDD
import java.text.SimpleDateFormat
import java.util.Date

object SparkSQLExamplesTransform {
  case class Person(name: String, age: Int)
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("SQLOnSpark").setMaster("local")
    val sc = new SparkContext(conf)
    //    val sqlContext = new SQLContext(sc)
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext._
    import sqlContext.implicits._

    //1.parquet to parquet
    val df = sqlContext.read.load("file/data/examples/src/main/resources/users.parquet")
    df.show
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val soutput = "file/data/sql/output/parquet/namesAndFavColors" + iString + "namesAndFavColors";

    df.select("name", "favorite_numbers").write.save(soutput)

    val df2 = sqlContext.read.load(soutput)
    df2.show

    //2.txt to parquet
    val people = sc.textFile("file/data/examples/src/main/resources/people.txt").map(_.split(",")).map(p => Person(p(0), p(1).trim.toInt)).toDF()
    people.registerTempTable("people")
    //    person.
    people.show

    val soutput2 = "file/data/sql/output/text/namesAndFavColors" + iString + "namesAndFavColors";
    people.write.save(soutput2)
    val df3 = sqlContext.read.load(soutput2)
    df3.show
    
    //3.json to parquet
    val df4 = sqlContext.read.format("json").load("file/data/examples/src/main/resources/people.json")
    df4.show
    val soutput4 = "file/data/sql/output/json/namesAndFavColors" + iString + "namesAndFavColors";
    df4.select("name", "age").write.format("parquet").save(soutput4)
    val df5 = sqlContext.read.load(soutput4)
    df5.show

  }

}