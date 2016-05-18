/**
 * @author xubo
 * ref http://spark.apache.org/docs/1.5.2/graphx-programming-guide.html
 * time 20160503
 */

package org.apache.spark.graphx.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.graphx.Graph
import org.apache.spark.graphx.VertexId
import org.apache.spark.graphx.VertexRDD
import org.apache.spark.graphx.util.GraphGenerators
import org.jets3t.apps.synchronize.Synchronize
import breeze.linalg.reverse
import breeze.linalg.reverse

object GraphGeneratorsAndTopK {

  val K = 3
  var arr = new Array[(Int, Int)](K)
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("GraphGeneratorsAndTopK").setMaster("local[4]")
    // Assume the SparkContext has already been constructed
    val sc = new SparkContext(conf)

    // Import random graph generation library
    // Create a graph with "age" as the vertex property.  Here we use a random graph for simplicity.
    val graph: Graph[Double, Int] =
      GraphGenerators.logNormalGraph(sc, numVertices = 10).mapVertices((id, _) => id.toDouble)
    // Compute the number of older followers and their total age

    println("Graph:");
    println("sc.defaultParallelism:" + sc.defaultParallelism);
    println("vertices:");
    graph.vertices.collect.foreach(println(_))
    println("edges:");
    graph.edges.collect.foreach(println(_))
    println("count:" + graph.edges.count);
    println("\ninDegrees");
    graph.inDegrees.foreach(println)

    for (i <- 0 until K) {
      arr(i) = (0, 0)
    }

    // Define a reduce operation to compute the highest degree vertex
    def max(a: (VertexId, Int), b: (VertexId, Int)): (VertexId, Int) = {
      if (a._2 > b._2) a else b
    }

    // Define a reduce operation to compute the highest degree vertex
    def min(a: (VertexId, Int), b: (VertexId, Int)): (VertexId, Int) = {
      if (a._2 < b._2) a else b
    }
    def minInt(a: (Int, Int), b: (Int, Int)): (Int, Int) = {
      if (a._2 < b._2) a else b
    }

    //    arr.reduce(minInt)

    println("\ntopK:K=" + K);
    def topK(a: (VertexId, Int)): Unit = {
      if (a._2 >= arr.reduce(minInt)._2) {
        arr = arr.sortBy(_._2).reverse
        var tmp = (a._1.toInt, a._2)
        var flag = true
        for (i <- 0 until arr.length) {
          if (a._2 >= arr(i)._2) { //newest max,remove = and last max
            if (flag == true) {
              for (j <- i + 1 until arr.length reverse) {
                arr(j) = arr(j - 1)
              }
              arr(i) = tmp
            }
            flag = false
          }
        }
      }
    }

    graph.inDegrees.foreach(topK(_))
    arr.foreach(println)
    println("end");
    sc.stop()
  }
}