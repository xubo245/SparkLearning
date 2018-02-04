/**
 * @author xubo
 * @time 20160502
 * ref https://github.com/databricks/spark-avro
 * 
 */
package org.apache.spark.avro.learning

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import java.text.SimpleDateFormat
import java.util.Date
/**
 * read avro by SparkAvro
 */
object bySparkSQL {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("bySparkSQL").setMaster("local")
    val sc = new SparkContext(conf)
    // import needed for the .avro method to be added
    import com.databricks.spark.avro._

    val sqlContext = new SQLContext(sc)

    // The Avro records get converted to Spark types, filtered, and
    // then written back out as Avro records
    val df = sqlContext.read.avro("file/data/avro/input/episodes.avro")
    df.show
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())

    df.filter("doctor > 5").write.avro("file/data/avro/output/episodes/bySparkSQL" + iString)
    df.filter("doctor > 5").show
  }
}