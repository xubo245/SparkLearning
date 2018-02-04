package org.apache.spark.sql.learning

import java.text.SimpleDateFormat
import java.util.Date

/**
  * Created by xubo on 2016/11/14.
  */
class DataSourcesLearning extends SparkSessionLearning {
  test("Generic Load/Save Functions") {
    val usersDF = spark.read.load("examples/src/main/resources/users.parquet")
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    usersDF.select("name", "favorite_color").write.save("file/sql/output/namesAndFavColors.parquet" + iString)
  }

  test("Manually Specifying Options") {
    val peopleDF = spark.read.format("json").load("examples/src/main/resources/people.json")
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    peopleDF.select("name", "age").write.format("parquet").save("file/sql/output/namesAndAges.parquet" + iString)
  }

  test("Run SQL on files directly") {
    val sqlDF = spark.sql("SELECT * FROM parquet.`examples/src/main/resources/users.parquet`")
    sqlDF.show()
  }
}
