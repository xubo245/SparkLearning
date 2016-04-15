

//class WordCountSpark {
//  
//}

package org.apache.spark.examplesByXubo.wordCount

import org.apache.spark._
import SparkContext._
object WordCountSpark {
  def main(args:Array[String]) {
    if (args.length != 3 ){
      println("usage is org.test.WordCount <master> <input> <output>")
      return
    }
    val sc = new SparkContext(args(0), "WordCount",
    System.getenv("SPARK_HOME"), Seq(System.getenv("SPARK_TEST_JAR")))
    val textFile = sc.textFile(args(1))
    val result = textFile.flatMap(line => line.split("\\s+"))
        .map(word => (word, 1)).reduceByKey(_ + _)
//        result.count();
    result.saveAsTextFile(args(2))
 
  }
}