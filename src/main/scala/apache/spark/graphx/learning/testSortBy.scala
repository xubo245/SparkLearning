package org.apache.spark.graphx.learning

object testSortBy {

  def main(args: Array[String]): Unit = {
    var arr = Array((1, 2), (2, 1), (3, 5), (4, 4))
    arr.sortBy(_._2).reverse.foreach(println)

  }

}