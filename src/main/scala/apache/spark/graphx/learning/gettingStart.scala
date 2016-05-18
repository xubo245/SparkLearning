/**
 * @author xubo
 * ref http://spark.apache.org/docs/1.5.2/graphx-programming-guide.html
 * time 20160503
 */
package org.apache.spark.graphx.learning
import org.apache.spark._
import org.apache.spark.graphx._
// To make some of the examples work we will also need RDD
import org.apache.spark.rdd.RDD

object gettingStart {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("gettingStart").setMaster("local[4]")
    // Assume the SparkContext has already been constructed
    val sc = new SparkContext(conf)
    // Create an RDD for the vertices
    val users: RDD[(VertexId, (String, String))] =
      sc.parallelize(Array((3L, ("rxin", "student")), (7L, ("jgonzal", "postdoc")),
        (5L, ("franklin", "prof")), (2L, ("istoica", "prof"))))
    // Create an RDD for edges
    val relationships: RDD[Edge[String]] =
      sc.parallelize(Array(Edge(3L, 7L, "collab"), Edge(5L, 3L, "advisor"),
        Edge(2L, 5L, "colleague"), Edge(5L, 7L, "pi")))
    // Define a default user in case there are relationship with missing user
    val defaultUser = ("John Doe", "Missing")
    // Build the initial Graph
    val graph = Graph(users, relationships, defaultUser)

    // Count all users which are postdocs
    println(graph.vertices.filter { case (id, (name, pos)) => pos == "postdoc" }.count)

    // Count all the edges where src > dst
    println(graph.edges.filter(e => e.srcId > e.dstId).count)

    //another method
    println(graph.edges.filter { case Edge(src, dst, prop) => src > dst }.count)

    //  reverse
    println(graph.edges.filter { case Edge(src, dst, prop) => src < dst }.count)

    // Use the triplets view to create an RDD of facts.
    val facts: RDD[String] =
      graph.triplets.map(triplet =>
        triplet.srcAttr._1 + " is the " + triplet.attr + " of " + triplet.dstAttr._1)
    facts.collect.foreach(println(_))

    // Use the triplets view to create an RDD of facts.
    println("\ntriplets:");
    val facts2: RDD[String] =
      graph.triplets.map(triplet =>
        triplet.srcId + "(" + triplet.srcAttr._1 + " " + triplet.srcAttr._2 + ")" + " is the" + triplet.attr + " of " + triplet.dstId + "(" + triplet.dstAttr._1 + " " + triplet.dstAttr._2 + ")")
    facts2.collect.foreach(println(_))
    sc.stop()
  }
}