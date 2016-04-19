package org.apache.spark.examples.saveAsFile
import org.apache.spark._
import java.text.SimpleDateFormat
import java.util._;

object SaveAsTextFileByWordcount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SaveAsTextFileByWordcount").setMaster("local")
    //  val conf=new SparkConf().setAppName("SaveAsFileByWordcount").setMaster("local")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("file/data/examples/input/wordCount/*")

    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())

    val soutput = "file/data/examples/output/wordcount/SaveAsTextFileByWordcount" + iString + "/";

    textFile.flatMap(_.split("\\s+")).map(word => (word, 1)).reduceByKey(_ + _).saveAsTextFile(soutput)
    println("success");
    sc.stop()

  }
}