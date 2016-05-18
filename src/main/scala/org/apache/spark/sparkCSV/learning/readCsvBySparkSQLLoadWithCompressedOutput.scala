/**
 * @author xubo
 * sparkCSV learning
 * @time 20160419
 * reference https://github.com/databricks/spark-csv
 * blog http://blog.csdn.net/xubo245/article/details/51184946
 */
package org.apache.spark.sparkCSV.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.types.{ StructType, StructField, StringType, IntegerType };
import java.io.File

object readCsvBySparkSQLLoadWithCompressedOutput {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SparkLearning:SparkCSV").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext._

    val file = "file/data/sparkCSV/input/cars.csv"
    val fileOut = "file/data/sparkCSV/output/newcars.csv.gz"

    val df = sqlContext.read
      .format("com.databricks.spark.csv")
      .option("header", "true") // Use first line of all files as header
      .option("inferSchema", "true") // Automatically infer data types
      .load(file)

    val selectedData = df.select("year", "model")
    selectedData.write
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .option("codec", "org.apache.hadoop.io.compress.GzipCodec")
      .save(fileOut)

    sc.stop

  }
}