/**
 * @author xubo
 * ref http://spark.apache.org/docs/1.5.2/graphx-programming-guide.html
 * http://snap.stanford.edu/data/web-Google.html
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
import org.apache.spark.graphx.VertexRDD

object webGoogle {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ConnectedComponents").setMaster("local[4]")
    val sc = new SparkContext(conf)

    // Parse the edge data which is already in userId -> userId format
    val graph = GraphLoader.edgeListFile(sc, "file/data/graphx/input/web-Google.txt")
    println("graph.numEdges:" + graph.numEdges);
    println("graph.numVertices:" + graph.numVertices);
    println("\n edges 10:");
    graph.edges.take(10).foreach(println);
    println("\n vertices 10:");
    graph.vertices.take(10).foreach(println);

    //***************************************************************************************************
    //*******************************          图的属性          *****************************************
    //***************************************************************************************************
    println("**********************************************************")
    println("属性演示")
    println("**********************************************************")
    println("Graph:");

    //Degrees操作
    println("找出图中最大的出度、入度、度数：")
    def max(a: (VertexId, Int), b: (VertexId, Int)): (VertexId, Int) = {
      if (a._2 > b._2) a else b
    }
    println("max of outDegrees:" + graph.outDegrees.reduce(max) + " max of inDegrees:" + graph.inDegrees.reduce(max) + " max of Degrees:" + graph.degrees.reduce(max))
    println

    sc.stop
  }
}