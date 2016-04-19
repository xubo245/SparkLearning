package org.apache.spark.examples.saveAsFile
import org.apache.spark._
import java.text.SimpleDateFormat
import java.util._;

object SaveAsObjectFileByWordcountSort {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SaveAsObjectFileByWordcountSort").setMaster("local")
    //  val conf=new SparkConf().setAppName("SaveAsFileByWordcount").setMaster("local")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("file/data/examples/input/wordCount/*")

    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val soutput = "file/data/examples/output/wordcount/SaveAsObjectFileByWordcountSort" + iString + "/";

    textFile.flatMap(_.split("\\s+")).map(word => (word, 1)).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false).saveAsObjectFile(soutput)
    println("success");
    sc.stop()

  }
}