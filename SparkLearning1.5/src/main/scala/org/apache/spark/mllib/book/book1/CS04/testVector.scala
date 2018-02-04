package org.apache.spark.mllib.book.book1.CS04

import org.apache.spark.mllib.linalg.{Vector, Vectors}

object testVector {
  def main(args: Array[String]) {
    val vd: Vector = Vectors.dense(2, 0, 6)                             //建立密集向量
println(vd(2))	                                                //打印稀疏向量第3个值
val vs: Vector = Vectors.sparse(4, Array(0,1,2,3), Array(9,5,2,7))		 //建立稀疏向量
    println(vs(2))											 //打印稀疏向量第3个值
  }
}
