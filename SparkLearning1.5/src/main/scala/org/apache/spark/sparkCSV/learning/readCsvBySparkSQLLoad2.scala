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
object readCsvBySparkSQLLoad2 {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SparkLearning:SparkCSV").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext._
    val file1 = "file/data/sparkCSV/input/sample_submission.csv"
    println(file1);

    val df = sqlContext.load("com.databricks.spark.csv", Map("path" -> file1, "header" -> "false"))
    //    df.select("year", "model").save("newcars.csv", "com.databricks.spark.csv")
    df.show

    sc.stop

  }
}