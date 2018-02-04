/**
 * @author xubo
 * spark 1.5.2
 * status success
 * reference :http://spark.apache.org/docs/1.5.2/sql-programming-guide.html
 */
package org.apache.spark.sql.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object SparkSQLExamplesFromJson2 {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("SQLOnSpark").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val people = sqlContext.read.json("file/data/examples/src/main/resources/people.json")
    people.show

    // The inferred schema can be visualized using the printSchema() method.
    people.printSchema()
    // root
    //  |-- age: integer (nullable = true)
    //  |-- name: string (nullable = true)

    // Register this DataFrame as a table.
    people.registerTempTable("people")

    // SQL statements can be run by using the sql methods provided by sqlContext.
    val teenagers = sqlContext.sql("SELECT name FROM people WHERE age >= 13 AND age <= 19")
    teenagers.foreach(println)

    // Alternatively, a DataFrame can be created for a JSON dataset represented by
    // an RDD[String] storing one JSON object per string.
    val anotherPeopleRDD = sc.parallelize(
      """{"name":"Yin","address":{"city":"Columbus","state":"Ohio"}}""" :: Nil)
    val anotherPeople = sqlContext.read.json(anotherPeopleRDD)
    anotherPeople.show
    
    //显示两层中的元素
    anotherPeople.select("address").show
    anotherPeople.select("address").printSchema
    anotherPeople.select("address.city").show
  }

}