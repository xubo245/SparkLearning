package org.apache.spark.examplesByXubo
import org.apache.spark.SparkContext._
import org.apache.spark._
object test2 {
//  package org.apache.spark.examples.ByXubo
  def main(arg:Array[String]){
   val sc = new SparkContext("local", "testpara",System.getenv("SPARK_HOME"), Seq(System.getenv("SPARK_TEST_JAR")))
  val collection=sc.parallelize(1 to 10000000)
  }
}
