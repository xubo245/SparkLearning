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

object GraphGeneratorsAndTopKBackup {

  val K = 3
  var arr = new Array[(Int, Int)](K)
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("GraphGeneratorsAndTopKBackup").setMaster("local[4]")
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
    //    println("\ndegrees");
    //    graph.degrees.foreach(println)
    println("\ninDegrees");
    graph.inDegrees.foreach(println)
    //    println("\noutDegrees");
    //    graph.outDegrees.foreach(println)

    //    arr.foreach(println)
    for (i <- 0 until K) {
      arr(i) = (0, 0)
    }
    //    arr.foreach(println)
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

    println("\ntopK");
    def topK(a: (VertexId, Int)): Unit = {
      if (a._2 >= arr.reduce(minInt)._2) {
        println(a._1 + " " + a._2 + "****");
        println("min:" + arr.reduce(minInt)._2);
        arr = arr.sortBy(_._2).reverse
        arr.foreach(println)
        println("sort end");
        var tmp = (a._1.toInt, a._2)
        var flag = true
        for (i <- 0 until arr.length) {

          if (a._2 > arr(i)._2) {
            if (flag == true) {
              for (j <- i + 1 until arr.length reverse) {
                print(j + " ")
                arr(j) = arr(j - 1)
              }
              println();
              arr(i) = tmp
            }
            flag = false
          }
        }

        arr.foreach(println)
      }
    }

    graph.inDegrees.foreach(topK(_))
    println("end");
    arr.foreach(println)
    //    // Compute the max degrees
    //    val maxInDegree: (VertexId, Int) = graph.inDegrees.reduce(max)
    //    val maxOutDegree: (VertexId, Int) = graph.outDegrees.reduce(max)
    //    val maxDegrees: (VertexId, Int) = graph.degrees.reduce(max)
    //
    //    println("\nmax:");
    //    println("maxDegree:" + (graph.degrees.reduce(max)));
    //    println("maxInDegree:" + graph.inDegrees.reduce(max));
    //    println("maxoutDegree:" + graph.outDegrees.reduce(max));
    //    println("\nmin:");
    //    println("minDegree:" + (graph.degrees.reduce(min)));
    //    println("minInDegree:" + graph.inDegrees.reduce(min));
    //    println("minoutDegree:" + graph.outDegrees.reduce(min));
    //    println("end");
    sc.stop()
  }
}