/**
 * @author xubo
 * ref http://spark.apache.org/docs/1.5.2/graphx-programming-guide.html
 * time 20160503
 */

package org.apache.spark.graphx.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.graphx.Graph
import org.apache.spark.graphx.VertexRDD
import org.apache.spark.graphx.util.GraphGenerators

object GraphGeneratorsAndIndegreeOutdegree {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("GraphOperatorsStructuralMask").setMaster("local[4]")
    // Assume the SparkContext has already been constructed
    val sc = new SparkContext(conf)

    // Import random graph generation library
    // Create a graph with "age" as the vertex property.  Here we use a random graph for simplicity.
    val graph: Graph[Double, Int] =
      GraphGenerators.logNormalGraph(sc, numVertices = 5).mapVertices((id, _) => id.toDouble)
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
    println("\noutDegrees");
    graph.outDegrees.foreach(println)

    //    println(graph.degrees.reduce(max));

    println("\nreverse");
    println("\nreverse vertices");
    graph.reverse.vertices.collect.foreach(println)
    println("\nreverse edges");
    graph.reverse.edges.collect.foreach(println)
    println("\nreverse inDegrees");
    graph.reverse.inDegrees.foreach(println)
    println("\nreverse inDegrees");
    graph.reverse.outDegrees.foreach(println)
    sc.stop()
  }

}