package org.apache.spark.mllib.basic.breeze

import java.util.Random

import org.apache.spark.mllib.linalg.{Matrices, Matrix}

/**
  * Created by xingyun.xb on 2016/8/7.
  */
object MarticsRandTest {
  def main(args: Array[String]) {
    val rng: Random = new Random(24)
    val r: Matrix = Matrices.rand(3, 4, rng)
    println(r)
    for (i <- 1 to 10) {
      println(i + ":" + rng.nextDouble())
    }
    var rng1: Random = new Random(10)
    for (i <- 1 to 10) {
      println(i + ":" + rng1.nextDouble())
    }
    rng1 = new Random()
    for (i <- 1 to 10) {
      println(i + ":" + rng1.nextDouble())
    }


  }

}
