

//class WordCountSpark {
//  
//}
package saveAsFile
import org.apache.spark._
import SparkContext._
import java.text.SimpleDateFormat
import java.util.Date
object WordCountSpark {
  def main(args: Array[String]) {
    //    if (args.length != 3 ){
    //      println("usage is org.test.WordCount <master> <input> <output>")
    //      return
    //    }
    //    val sc = new SparkContext(args(0), "WordCount",System.getenv("SPARK_HOME"), Seq(System.getenv("SPARK_TEST_JAR")))
    val conf = new SparkConf().setAppName("WordCountSpark").setMaster("local")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("hdfs://219.219.220.149:9000/xubo/input/wordcount")
    val result = textFile.flatMap(line => line.split("\\s+"))
      .map(word => (word, 1)).reduceByKey(_ + _)
    //        result.count();
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val soutput = "hdfs://219.219.220.149:9000/xubo/output/wordcount/WordCountSpark" + iString + "/";

    result.saveAsTextFile(soutput)
    println("success");
    sc.stop()

  }
}