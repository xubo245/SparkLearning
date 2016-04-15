package org.apache.spark.examplesByXubo.wordCount
import java.util._;
import java.text.SimpleDateFormat

object TestDate {
  def main(args: Array[String]) {
//  
//  val sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss")
//  
  val iString=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date() );
  val s1="hdfs://219.219.220.149:9000/output/"+iString;
	println(s1)
	 val s0= "hdfs://219.219.220.149:9000/input/*"
	 println(s0)
  }
}

//class can not export jar