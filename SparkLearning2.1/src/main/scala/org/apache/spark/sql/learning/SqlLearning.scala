package org.apache.spark.sql.learning

/**
  * Created by xubo on 2016/11/7.
  */
object SqlLearning {
  def main(args: Array[String]) {
    import org.apache.spark.sql.SparkSession

    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
        .master("local[4]")
      .getOrCreate()


    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._
    val df = spark.read.json("examples/src/main/resources/people.json")

    // Displays the content of the DataFrame to stdout
    df.show()
  }
}
