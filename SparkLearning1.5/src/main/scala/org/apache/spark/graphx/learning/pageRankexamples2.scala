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

object pageRankexamples2 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ConnectedComponents").setMaster("local[4]")
    val sc = new SparkContext(conf)

    // Load my user data and parse into tuples of user id and attribute list
    val users = (sc.textFile("file/data/graphx/input/users.txt")
      .map(line => line.split(",")).map(parts => (parts.head.toLong, parts.tail)))

    // Parse the edge data which is already in userId -> userId format
    val followerGraph = GraphLoader.edgeListFile(sc, "file/data/graphx/input/followers.txt")

    // Attach the user attributes
    val graph = followerGraph.outerJoinVertices(users) {
      case (uid, deg, Some(attrList)) => attrList
      // Some users may not have attributes so we set them as empty
      case (uid, deg, None) => Array.empty[String]
    }

    // Restrict the graph to users with usernames and names
    val subgraph = graph.subgraph(vpred = (vid, attr) => attr.size == 2)

    // Compute the PageRank
    val pagerankGraph = subgraph.pageRank(0.001)

    // Get the attributes of the top pagerank users
    val userInfoWithPageRank = subgraph.outerJoinVertices(pagerankGraph.vertices) {
      case (uid, attrList, Some(pr)) => (pr, attrList.toList)
      case (uid, attrList, None) => (0.0, attrList.toList)
    }

    println("\ngraph edges");
    println("edges:");
    graph.edges.collect.foreach(println)

    println("vertices:");
    graph.vertices.collect.foreach { a =>
      if (a._1 != -1) {
        print(a._1 + ",")
      }
      if (a._2 != null) {
        (a._2).foreach { b => print(b + " ") }
      }
      println();
    }
    println("triplets:");
    //    graph.triplets.collect.foreach(println)
    graph.triplets.collect.foreach { a =>
      println("(" + a.srcId + ",(" + a.srcAttr(0) + "," + a.srcAttr(1) + "),(" + a.dstId + "," + a.dstAttr(0) + "," + a.dstAttr(1) + ")," + a.attr + ")")
    }
    println("\nusers");
    users.collect.foreach { a =>
      if (a._1 != -1) {
        print(a._1 + ",")
      }
      if (a._2 != null) {
        (a._2).foreach { b => print(b + " ") }
      }
      println();
    }
    println();
    println(userInfoWithPageRank.vertices.top(7)(Ordering.by(_._2._1)).mkString("\n"))
    println("methods 2:");
    userInfoWithPageRank.vertices.collect.foreach(println)
    sc.stop()
  }
}