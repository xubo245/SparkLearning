package org.apache.spark.sql.learning

import java.text.SimpleDateFormat
import java.util.Date

/**
  * Created by xubo on 2016/11/14.
  */
class ParquetLearning extends SparkSessionLearning {
  test("Loading Data Programmatically") {

    // Encoders for most common types are automatically provided by importing spark.implicits._
    val spark = this.spark
    import spark.implicits._

    val peopleDF = spark.read.json("examples/src/main/resources/people.json")
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    // DataFrames can be saved as Parquet files, maintaining the schema information
    peopleDF.write.parquet("file/sql/output/people.parquet" + iString)

    // Read in the parquet file created above
    // Parquet files are self-describing so the schema is preserved
    // The result of loading a Parquet file is also a DataFrame
    val parquetFileDF = spark.read.parquet("file/sql/output/people.parquet" + iString)

    // Parquet files can also be used to create a temporary view and then used in SQL statements
    parquetFileDF.createOrReplaceTempView("parquetFile")
    val namesDF = spark.sql("SELECT name FROM parquetFile WHERE age BETWEEN 13 AND 19")
    namesDF.map(attributes => "Name: " + attributes(0)).show()
    // +------------+
    // |       value|
    // +------------+
    // |Name: Justin|
    // +------------+
  }

  test("Schema Merging") {
    // This is used to implicitly convert an RDD to a DataFrame.
    val spark = this.spark
    import spark.implicits._
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    // Create a simple DataFrame, store into a partition directory
    val squaresDF = spark.sparkContext.makeRDD(1 to 5).map(i => (i, i * i)).toDF("value", "square")
    squaresDF.write.parquet("file/sql/data/test_table/key=1" + iString)

    // Create another DataFrame in a new partition directory,
    // adding a new column and dropping an existing column
    val cubesDF = spark.sparkContext.makeRDD(6 to 10).map(i => (i, i * i * i)).toDF("value", "cube")
    cubesDF.write.parquet("file/sql/data/test_table/key=2" + iString)

    // Read the partitioned table
    val mergedDF = spark.read.option("mergeSchema", "true").parquet("file/sql/data/test_table")
    mergedDF.printSchema()
    mergedDF.show()
    // The final schema consists of all 3 columns in the Parquet files together
    // with the partitioning column appeared in the partition directory paths
    // root
    //  |-- value: int (nullable = true)
    //  |-- square: int (nullable = true)
    //  |-- cube: int (nullable = true)
    //  |-- key: int (nullable = true)
  }
}
