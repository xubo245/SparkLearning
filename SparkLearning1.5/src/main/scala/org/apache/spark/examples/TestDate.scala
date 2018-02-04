package org.apache.spark.examples
import java.util._
import java.text.SimpleDateFormat

object TestDate {
  def main(args: Array[String]) {
//  
//  val sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss")
//  
  val iString=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date() );
  val s1="file/data/examples/output/"+iString;
	println(s1)
	 val s0= "file/data/examples/input/*"
	 println(s0)
  }
}

//class can not export jar