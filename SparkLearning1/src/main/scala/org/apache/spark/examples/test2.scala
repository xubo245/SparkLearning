package org.apache.spark.examples
import org.apache.spark.SparkContext._
import org.apache.spark._
object test2 {
  def main(arg:Array[String]){
   val sc = new SparkContext("local", "testpara",System.getenv("SPARK_HOME"), Seq(System.getenv("SPARK_TEST_JAR")))
  val collection=sc.parallelize(1 to 10000000)
  println("end");
   sc.stop
  }
}
