package org.apache.spark.mllib.basic.breeze.breezeFromScalaNLP

import breeze.linalg.{diag, DenseMatrix => BDM, DenseVector => BDV}
import breeze.linalg._
import breeze.numerics._
import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * scalaNLP下面的project breeze的实用方法
  * Created by xingyun.xb on 2016/8/1.
  */
class BreezeFromScalaNLPSuite extends SparkLearningFunSuite {

  test(" create functions: scalaNLP breeze Suite") {

    println()
    println(BDM.zeros[Double](2, 3))

    println()
    println(BDV.zeros[Double](2))

    println()
    println(BDV.ones[Double](2))

    println()
    println(BDV.fill[Double](5) {
      3.0
    })

    println()
    println(BDV.range(3, 10))

    println()
    println(BDV.range(3, 10, 2))

    println()
    println(BDM.eye[Double](5))

    diag
    println()
    println(diag(BDV(1.0, 2, 3)))

    println()
    println(BDM((1.0, 2.0), (3.0, 4.0)))

    println()
    println(BDV(1, 2, 3, 10))

    println()
    println(BDV(1, 2, 3, 10).t)

    println()
    println(BDV.tabulate(6) { i => 4 * i })

    println()
    println(BDM.tabulate(6, 8) { case (i, j) => i + j })

    println()
    println(new BDV(Array(1, 2, 3, 4)))

    println()
    println(new BDM(2, 3, Array(1, 2, 3, 4, 5, 6)))

    println()
    println(BDV.rand(10))

    println()
    println(BDM.rand(3, 10))

  }

  test(" examples to get data: scalaNLP breeze Suite") {
    val bdm = BDM.rand(3, 8)
    println(bdm)
    println()
    println(bdm(::, 1))

    println()
    println(bdm(1, ::))


    println()
    println(bdm(::, 0 to 1))

    println()
    println(bdm(1, 0 to 1))
  }

  test(" examples to set data: scalaNLP breeze Suite") {
    var m = BDM.rand(4, 5)
    println(m)

    println()
    val n = m.reshape(10, 2)
    println(m)

    println()
    println(n)

    linePrintln(m.toDenseVector)

    //下三角
    linePrintln(lowerTriangular(m))

    //下三角
    linePrintln(upperTriangular(m))

    var x = BDM.rand(5, 5)
    linePrintln(x)
    linePrintln(diag(x))

    x(::, 0) := 1.0
    linePrintln(x)

    var y = BDM.rand(5, 5)
    linePrintln(y)
    linePrintln(BDM.vertcat(x, y))
    linePrintln(BDM.horzcat(x, y))

    var hc = BDM.horzcat(x, y)

    linePrintln(hc(0, ::))


    var a = BDV.rand(5)
    var b = BDV.rand(4)
    linePrintln(a)
    linePrintln(b)
    linePrintln(BDV.vertcat(a, b))
  }

  test(" examples to compute data: scalaNLP breeze Suite") {
    //    var a = BDV.rand(5)
    //    var b = BDV.rand(4)
    var x = BDM.fill(4, 4)(2.0)
    var y = BDM.fill(4, 4)(3.0)
    linePrintln(x)
    linePrintln(y)
    linePrintln((x + y))
    linePrintln((x - y))
    linePrintln((x :/ y))
    linePrintln((x :* y))
    linePrintln((x :< y))
    linePrintln((x :== y))
    linePrintln((x :+= 10.0))
    linePrintln((x :*= 2.0))
    linePrintln((x :-= 3.0))
    linePrintln((x :/= 3.0))

    var a = BDM.rand(4, 4)
    var b = BDM.rand(4, 4)
    linePrintln(a)
    linePrintln(b)
    val aa = max(a)
    println(aa)
    val aa1 = argmax(a)
    println(aa1)
    //    linePrintln(aa)
    //    linePrintln(argmax(a))
  }

  test(" examples to compute data--sum: scalaNLP breeze Suite") {
    //    var x = BDM.fill(4, 4)(2.0)
    //    var y = BDM.fill(4, 4)(3.0)
    var x = BDM.rand(4, 4)
    var y = BDM.rand(4, 4)
    linePrintln(x)
    linePrintln(y)
    val sumx = sum(x)
    println(sumx)

    var sumx1 = sum(x(::, *))
    println(sumx1)
    sumx1 = sum(x, Axis._0)
    println(sumx1)

    var sumy1 = sum(y(::, *))
    println(sumy1)
    sumy1 = sum(y, Axis._0)
    println(sumy1)

    println(trace(x))
    println(trace(y))

    println(accumulate(x(1, ::)))


  }

  test(" examples to compute data--boolean function: scalaNLP breeze Suite") {
    val a = BDV(true, false, true)
    val b = BDV(false, true, false)
    println(a :& b)
    println(a :| b)
    println(!a)

    val c = BDV(1.0, 0.0, -2.0)
    println(any(c))
    println(all(c))
  }

  def linePrintln(a: Object) {
    println()
    println(a)
  }


}
