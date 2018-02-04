/**
 * @author xubo
 * @time 20160503
 * ref:
 * http://spark.apache.org/docs/1.5.2/graphx-programming-guide.html
 * http://blog.csdn.net/zcf1002797280/article/details/50007913
 */

package org.apache.spark.graphx.learning

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.graphx.Graph
import org.apache.spark.graphx.Graph.graphToGraphOps
import org.apache.spark.graphx.lib.ShortestPaths

object ShortPaths {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ShortPaths").setMaster("local[4]")
    val sc = new SparkContext(conf)

    // 测试的真实结果，后面用于对比
    val shortestPaths = Set(
      (1, Map(1 -> 0, 4 -> 2)), (2, Map(1 -> 1, 4 -> 2)), (3, Map(1 -> 2, 4 -> 1)),
      (4, Map(1 -> 2, 4 -> 0)), (5, Map(1 -> 1, 4 -> 1)), (6, Map(1 -> 3, 4 -> 1)))

    // 构造无向图的边序列
    val edgeSeq = Seq((1, 2), (1, 5), (2, 3), (2, 5), (3, 4), (4, 5), (4, 6)).flatMap {
      case e => Seq(e, e.swap)
    }

    // 构造无向图
    val edges = sc.parallelize(edgeSeq).map { case (v1, v2) => (v1.toLong, v2.toLong) }
    val graph = Graph.fromEdgeTuples(edges, 1)

    // 要求最短路径的点集合
    val landmarks = Seq(1, 2, 3,4,5,6).map(_.toLong)

    // 计算最短路径
    val results = ShortestPaths.run(graph, landmarks).vertices.collect.map {
      case (v, spMap) => (v, spMap.mapValues(i => i))
    }

    val shortestPath1 = ShortestPaths.run(graph, landmarks)
    // 与真实结果对比
    println("\ngraph edges");
    println("edges:");
    graph.edges.collect.foreach(println)
    //    graph.edges.collect.foreach(println)
    println("vertices:");
    graph.vertices.collect.foreach(println)
    //    println("triplets:");
    //    graph.triplets.collect.foreach(println)
    println();

    println("\n shortestPath1");
    println("edges:");
    shortestPath1.edges.collect.foreach(println)
    println("vertices:");
    shortestPath1.vertices.collect.foreach(println)
    //    println("vertices:")

    //    assert(results.toSet == shortestPaths)
    println("results.toSet:" + results.toSet);
    println("end");

    sc.stop()
  }
}