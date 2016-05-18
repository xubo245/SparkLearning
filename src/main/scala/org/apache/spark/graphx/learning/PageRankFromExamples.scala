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

object PageRankFromExamples {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("PageRank").setMaster("local[4]")
    val sc = new SparkContext(conf)

    // Load the edges as a graph
    val graph = GraphLoader.edgeListFile(sc, "file/data/graphx/input/followers.txt")

    // Run PageRank
    val ranks = graph.pageRank(0.0001).vertices
    // Join the ranks with the usernames
    val users = sc.textFile("file/data/graphx/input/users.txt").map { line =>
      val fields = line.split(",")
      (fields(0).toLong, fields(1))
    }

    val ranksByUsername = users.join(ranks).map {
      case (id, (username, rank)) => (username, rank)
    }
    println("graph:");
    graph.edges.collect.foreach(println)
    println("users:");
    users.collect.foreach(println)
    println("ranks:");
    ranks.collect.foreach(println)

    // Print the result
    println("\nranksByUsername");
    println(ranksByUsername.collect().mkString("\n"))
    sc.stop()
  }
}