package org.apache.spark.examples
import org.apache.spark._
import org.apache.spark.SparkContext._
import java.util._
import java.text.SimpleDateFormat
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object WordCountByTimeNoSort {
  def main(args: Array[String]) {
     val s0="local"
     val sinput= "file/data/examples/input/wordCount/*"
     val iString=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date() )
	   val soutput="file/data/examples/output/wordCount" + iString;
       
    if (args.length > 0 ){
      println("usage is org.test.WordCount <master> <input> <output>")
      return
    }
    val sc = new SparkContext(s0, "WordCount",
    System.getenv("SPARK_HOME"), Seq(System.getenv("SPARK_TEST_JAR")))
    val textFile = sc.textFile(sinput)
    val result = textFile.flatMap(line => line.split("\\s+"))
        .map(word => (word, 1)).reduceByKey(_ + _)
//        result.count();
    result.saveAsTextFile(soutput)
    println("end");
    sc.stop
  }
}