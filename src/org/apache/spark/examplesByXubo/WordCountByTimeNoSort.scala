package org.apache.spark.examplesByXubo;
import org.apache.spark._
import SparkContext._
import java.util._;
import java.text.SimpleDateFormat

object WordCountByTimeNoSort {
  def main(args: Array[String]) {
     val s0="local"
     val sinput= "hdfs://219.219.220.149:9000/input/*"
     val iString=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date() )
	   val soutput="hdfs://219.219.220.149:9000/output/"+iString;
       
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
  }
}