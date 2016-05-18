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
 * specify the record name and namespace
 */
object AvroReadSpecifyName {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("AvroReadSpecifyName").setMaster("local")
    val sc = new SparkContext(conf)
    // import needed for the .avro method to be added

    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val df = sqlContext.read.avro("file/data/avro/input/episodes.avro")
    df.show

    val name = "AvroTest"
    val namespace = "com.databricks.spark.avro"
    val parameters = Map("recordName" -> name, "recordNamespace" -> namespace)

    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    df.write.options(parameters).avro("file/data/avro/output/episodes/AvroReadSpecifyName" + iString)

    val dfread = sqlContext.read
      .format("com.databricks.spark.avro")
      .load("file/data/avro/output/episodes/AvroReadSpecifyName" + iString)
    dfread.show

    val dfread2 = sqlContext.read.avro("file/data/avro/output/episodes/AvroReadSpecifyName" + iString)
    dfread2.show
  }
}