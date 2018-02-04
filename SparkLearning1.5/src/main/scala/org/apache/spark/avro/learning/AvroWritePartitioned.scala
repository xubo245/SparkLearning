/**
 * @author xubo
 * @time 20160502
 * ref https://github.com/databricks/spark-avro
 */
package org.apache.spark.avro.learning

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import java.text.SimpleDateFormat
import java.util.Date
import com.databricks.spark.avro._

/**
 * partitioned Avro records 
 */
object AvroWritePartitioned {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("AvroWritePartitioned").setMaster("local")
    val sc = new SparkContext(conf)
    // import needed for the .avro method to be added

    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val df = Seq((2012, 8, "Batman", 9.8),
      (2012, 8, "Hero", 8.7),
      (2012, 7, "Robot", 5.5),
      (2011, 7, "Git", 2.0))
      .toDF("year", "month", "title", "rating")
    df.show
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    df.write.partitionBy("year", "month").avro("file/data/avro/output/episodes/WriteAvro" + iString)

    val dfread = sqlContext.read
      .format("com.databricks.spark.avro")
      .load("file/data/avro/output/episodes/WriteAvro" + iString)
    dfread.show

    val dfread2 = sqlContext.read.avro("file/data/avro/output/episodes/WriteAvro" + iString)
    dfread2.show
  }
}