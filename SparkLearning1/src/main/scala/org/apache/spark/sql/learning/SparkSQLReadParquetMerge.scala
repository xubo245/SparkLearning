/**
 * @author xubo
 * spark 1.5.2
 * status :success
 * reference :http://spark.apache.org/docs/1.5.2/sql-programming-guide.html
 */
package org.apache.spark.sql.learning

import org.apache.spark.sql.SQLContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import java.text.SimpleDateFormat
import java.util.Date

object SparkSQLReadParquetMerge {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("SQLOnSpark").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    // sqlContext from the previous example is used in this example.
    // This is used to implicitly convert an RDD to a DataFrame.
    //    import sqlContext.implicits._
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    // Create a simple DataFrame, stored into a partition directory
    val df1 = sc.makeRDD(1 to 5).map(i => (i, i * 2)).toDF("single", "double")
    df1.write.parquet("file/data/sql/output/" + iString + "/test_table/key=1/")
    df1.show

    // Create another DataFrame in a new partition directory,
    // adding a new column and dropping an existing column
    val df2 = sc.makeRDD(6 to 10).map(i => (i, i * 3)).toDF("single", "triple")
    df2.write.parquet("file/data/sql/output/" + iString + "/test_table/key=2/")
    df2.show

    // Read the partitioned table
    val df3 = sqlContext.read.option("mergeSchema", "true").parquet("file/data/sql/output/" + iString + "/test_table/")
    df3.printSchema()
    df3.show

    //    val df4 = sqlContext.read.parquet("file/data/sql/input/var1.txt")
    //    df4.printSchema
    //    df4.show
    //     val df4 = sqlContext.read.option("mergeSchema", "true").parquet("data/test_table/"+iString)
    //    df4.printSchema()
    //    df4.show
    sc.stop
  }

}