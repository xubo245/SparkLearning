/**
 * @author xubo
 * ref http://spark.apache.org/docs/1.5.2/graphx-programming-guide.html
 * time 20160503
 */

package org.apache.spark.graphx.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.graphx.Graph
import org.apache.spark.graphx.Graph.graphToGraphOps
import org.apache.spark.graphx.VertexId
import org.apache.spark.graphx.util.GraphGenerators
import org.apache.spark.graphx.GraphLoader
import org.apache.spark.graphx.PartitionStrategy

object TriangleCounting {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ConnectedComponents").setMaster("local[4]")
    val sc = new SparkContext(conf)

    // Load the edges in canonical order and partition the graph for triangle count
    val graph = GraphLoader.edgeListFile(sc, "file/data/graphx/input/followers.txt", true).partitionBy(PartitionStrategy.RandomVertexCut)
    // Find the triangle count for each vertex
    val triCounts = graph.triangleCount().vertices
    // Join the triangle counts with the usernames
    val users = sc.textFile("file/data/graphx/input/users.txt").map { line =>
      val fields = line.split(",")
      (fields(0).toLong, fields(1))
    }
    val triCountByUsername = users.join(triCounts).map {
      case (id, (username, tc)) =>
        (username, tc)
    }
    // Print the result 
    println("\ngraph edges");
    println("edges:");
    graph.edges.collect.foreach(println)
//    graph.edges.collect.foreach(println)
    println("vertices:");
    graph.vertices.collect.foreach(println)
    println("triplets:");
    graph.triplets.collect.foreach(println)
    println("\nusers");
    users.collect.foreach(println)
    
    println("\n triCounts:");
    triCounts.collect.foreach(println)
    println("\n triCountByUsername:");
    println(triCountByUsername.collect().mkString("\n"))
   sc.stop()
  }
}