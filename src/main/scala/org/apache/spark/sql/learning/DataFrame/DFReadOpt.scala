package org.apache.spark.sql.learning.DataFrame

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object DFReadOpt {
  case class Person(name: String, age: Int)
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("DataFrame").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    /**
     * produce dataFrame from txt and save as parquet file
     */
    //    val people = sc.textFile("file/data/examples/src/main/resources/people.txt").map(_.split(",")).map(p => Person(p(0), p(1).trim.toInt)).toDF()
    //    people.registerTempTable("people")
    //    people.write.save("file/data/sql/input/people")

    /**
     * read file from parquet
     */
    val people = sqlContext.read.parquet("file/data/sql/input/people")
    people.show
    people.printSchema

    //To select a column from the data frame, use apply method in Scala and col in Java.
    val ageCol = people("age")
    val groupByAge=people.groupBy("age").count.show
    
    people.registerTempTable("people")
    val ageColumn=sqlContext.sql("select age from people")
    ageColumn.show

    println(ageCol);

    people.select("age").show
    people("age") + 10

    println("DataFrame end");
    sc.stop
  }
}