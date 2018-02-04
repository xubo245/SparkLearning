/**
 * @author xubo
 * ref http://spark.apache.org/docs/1.5.2/graphx-programming-guide.html
 * time 20160503
 */

package org.apache.spark.tachyon.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.graphx.Graph
import org.apache.spark.graphx.Graph.graphToGraphOps
import org.apache.spark.graphx.VertexId
import org.apache.spark.graphx.util.GraphGenerators
import org.apache.spark.graphx.GraphLoader
import org.apache.spark.graphx.PartitionStrategy

object tachyonTest {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("tachyonTest").setMaster("local[4]")
    val sc = new SparkContext(conf)

    val text1 = sc.textFile("tachyon://219.219.220.222:19998/1.txt")
    //    val text1 = sc.textFile("http://219.219.220.222:19999/browse?path=%2F1.txt")
    //默认不支持非localhost访问
    text1.foreach(println)

    sc.stop()
  }
}