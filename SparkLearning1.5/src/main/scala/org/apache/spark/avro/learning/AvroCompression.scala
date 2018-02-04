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
/**
 * Avro Compression different level 
 */
object AvroCompression {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("AvroCompression").setMaster("local")
    val sc = new SparkContext(conf)
    // import needed for the .avro method to be added
    import com.databricks.spark.avro._

    val sqlContext = new SQLContext(sc)
    sqlContext.setConf("spark.sql.avro.compression.codec", "deflate")
    sqlContext.setConf("spark.sql.avro.deflate.level", "5")
    
    // The Avro records get converted to Spark types, filtered, and
    // then written back out as Avro records
    val df = sqlContext.read
      .format("com.databricks.spark.avro")
      .load("file/data/avro/input/episodes.avro")
    df.show

    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())

    df.filter("doctor > 5").write
      .format("com.databricks.spark.avro")
      .save("file/data/avro/output/episodes/AvroCompression" + iString)
    df.filter("doctor > 5").show

  }
}