/**
  * @author xubo
  *         spark 1.5.2
  *
  *         reference :http://spark.apache.org/docs/1.5.2/sql-programming-guide.html
  */
package org.apache.spark.sql.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object SparkSQLExamplesFromJson {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("SQLOnSpark").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val df = sqlContext.read.json("file/data/examples/src/main/resources/people.json")

    //    // Displays the content of the DataFrame to stdout
    //    df.show()

    // Show the content of the DataFrame
    df.show()
    // age  name
    // null Michael
    // 30   Andy
    // 19   Justin

    // Print the schema in a tree format
    df.printSchema()
    // root
    // |-- age: long (nullable = true)
    // |-- name: string (nullable = true)

    // Select only the "name" column
    df.select("name").show()
    // name
    // Michael
    // Andy
    // Justin

    // Select everybody, but increment the age by 1
    df.select(df("name"), df("age") + 1).show()
    // name    (age + 1)
    // Michael null
    // Andy    31
    // Justin  20

    // Select people older than 21
    df.filter(df("age") > 21).show()
    // age name
    // 30  Andy

    // Count people by age
    df.groupBy("age").count().show()
    // age  count
    // null 1
    // 19   1
    // 30   1
  }

}