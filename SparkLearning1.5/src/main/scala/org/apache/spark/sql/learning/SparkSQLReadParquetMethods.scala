/**
 * @author xubo
 * spark 1.5.2
 *
 * reference :http://spark.apache.org/docs/1.5.2/sql-programming-guide.html
 */
package org.apache.spark.sql.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object SparkSQLReadParquetMethods {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("SQLOnSpark").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    //parquet：first method to reads from parquet file
    val parquetFile = sqlContext.read.parquet("file/data/sql/input/wiki_parquet")
    parquetFile.show

    //parquet：second method to reads from parquet file
    val parquetFile2 = sqlContext.parquetFile("file/data/sql/input/wiki_parquet")
    parquetFile2.show
    //    parquetFile.saveA
    //    parquetFile.write.save("file/sql/text/wiki10.txt")

    val df = parquetFile
    // Print the schema in a tree format
    df.printSchema()

    // Select only the "name" column
    df.select("id").show()

    // Select everybody, but increment the age by 1
    df.select(df("id"), df("modified") + 1).show()

    // Select people older than 21
    df.filter(df("id") > 12904870).show()

    // Count people by age
    df.groupBy("id").count().show()

    parquetFile.registerTempTable("parquetFileTable")
    val teenagers = sqlContext.sql("SELECT id,modified FROM parquetFileTable WHERE id >= 12904870 AND id <= 13069742")
    teenagers.map(t => "id: " + t(0) + " and modified:" + t(1)).collect().foreach(println)

    parquetFile.select("title").show
    val title1 = parquetFile.select("title")
    //    println(title1.columns);
    //    println(title1.columns.length);

    title1.select("title").printSchema
    //    root
    // |-- title: binary (nullable = true)
//       title1.select("title").toDF.

  }

}