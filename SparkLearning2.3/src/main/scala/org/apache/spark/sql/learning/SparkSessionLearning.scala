package org.apache.spark.sql.learning

import org.apache.spark.utils.learning.SparkLearningFunSuite

/**
  * Created by xubo on 2016/11/7.
  */
class SparkSessionLearning extends SparkLearningFunSuite {

  test("start") {
    sc.makeRDD(Array(1, 2, 3)).foreach(println)
  }

  test("Starting Point") {
    val df = spark.read.json("examples/src/main/resources/people.json")
    // Displays the content of the DataFrame to stdout
    df.show()


    // This import is needed to use the $-notation
    // Print the schema in a tree format
    df.printSchema()
    // root
    // |-- age: long (nullable = true)
    // |-- name: string (nullable = true)

    // Select only the "name" column
    df.select("name").show()
    // +-------+
    // |   name|
    // +-------+
    // |Michael|
    // |   Andy|
    // | Justin|
    // +-------+

  }

}
