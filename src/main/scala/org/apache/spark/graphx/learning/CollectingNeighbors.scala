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
import org.apache.spark.graphx.EdgeDirection

object CollectingNeighbors {

  val K = 3
  var arr = new Array[(Int, Int)](K)
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("CollectingNeighbors").setMaster("local[4]")
    // Assume the SparkContext has already been constructed
    val sc = new SparkContext(conf)

    // Import random graph generation library
    // Create a graph with "age" as the vertex property.  Here we use a random graph for simplicity.
    val graph: Graph[Double, Int] =
      GraphGenerators.logNormalGraph(sc, numVertices = 6).mapVertices((id, _) => id.toDouble)
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

    println("\nneighborsIds:");
    val neighbors0 = graph.collectNeighborIds(EdgeDirection.Out)
    neighbors0.foreach(println)
    neighbors0.collect.foreach { a =>
      {
        println(a._1 + ":")
        a._2.foreach(b => print(b + " "))
        println();
      }
    }

    println("\nneighbors:");
    val neighbors1 = graph.collectNeighbors(EdgeDirection.Out)
    neighbors1.foreach(println)
    neighbors1.collect.foreach { a =>
      {
        println(a._1 + ":")
        a._2.foreach(b => print(b + " "))
        println();
      }
    }
    sc.stop()
  }
}