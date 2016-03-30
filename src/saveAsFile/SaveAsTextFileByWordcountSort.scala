package saveAsFile
import org.apache.spark._
import java.text.SimpleDateFormat
import java.util._;

object SaveAsTextFileByWordcountSort {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SaveAsTextFileByWordcountSort").setMaster("local")
    //  val conf=new SparkConf().setAppName("SaveAsFileByWordcount").setMaster("local")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile("hdfs://219.219.220.149:9000/xubo/input/wordcount",1)

    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val soutput = "hdfs://219.219.220.149:9000/xubo/output/wordcount/SaveAsTextFileByWordcountSort" + iString + "/";

    textFile.flatMap(_.split("\\s+")).map(word => (word, 1)).reduceByKey(_ + _).map(_.swap).sortByKey(ascending = false).saveAsTextFile(soutput)
    println("success");
    sc.stop()

  }
}