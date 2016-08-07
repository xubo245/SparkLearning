package org.apache.spark.rdd.learning

import org.apache.log4j.{Level, Logger}
import org.apache.spark.util.SparkLearningFunSuite

/**
  * ref:Spark MLlib 机器学习 算法、源码及实战详解
  * http://spark.apache.org/docs/1.5.2/programming-guide.html
  * Created by xingyun.xb on 2016/7/24.
  */
class RDDTransformationsLearningSuite extends SparkLearningFunSuite with Serializable {
  test("map Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    var rdd1 = sc.parallelize(1 to 9, 3)
    val rdd2 = rdd1.map(x => x * 2)
    rdd2.collect().foreach(println)

  }

  test("filter Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    var rdd1 = sc.parallelize(1 to 9, 3)
    val rdd2 = rdd1.filter(_ > 5)
    rdd2.collect().foreach(println)
  }

  test("flatMap suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    var rdd1 = sc.parallelize(1 to 9, 3)
    val rdd2 = rdd1.flatMap(x => x to 10)
    rdd2.collect().foreach(println)

  }


  //  test("mapPartitions Suite") {
  //    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
  //    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
  //
  //    val rdd1 = sc.parallelize(1 to 9, 3)
  //    val rdd2 = rdd1.mapPartitions(myfunc)
  //    println(rdd2.toDebugString)
  //    //    rdd2.collect().foreach(println)
  //
  //  }

  test("mapPartitions Suite 2") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    var rdd1 = sc.makeRDD(1 to 5, 2)
    println("rdd1.partitions.size=" + rdd1.partitions.size)
    var rdd2 = rdd1.partitions
    println(rdd2(1).index)
    println(rdd2(0).index)

    //    rdd1.partitioner.foreach(println)
    var rdd3 = rdd1.mapPartitions { x => {
      var result = List[Int]()
      var i = 0
      while (x.hasNext) {
        i += x.next()
      }
      result.::(i).iterator
    }
    }
    rdd3.foreach(println)

  }

  def myfunc[T](iter: Iterator[T]): Iterator[(T, T)] = {
    var res = List[(T, T)]()
    var pre = iter.next
    while (iter.hasNext) {
      val cur = iter.next
      res.::=(pre, cur)
      pre = cur
    }
    res.iterator
  }


  def myfuncInt(iter: Iterator[Int]): Iterator[(Int, Int)] = {
    var res = List[(Int, Int)]()
    var pre = iter.next
    while (iter.hasNext) {
      val cur = iter.next
      res.::=(pre, cur)
      pre = cur
    }
    res.iterator
  }


  test("mapPartitionsWithIndex Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    println("no finish")
  }

  test("sample Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(1 to 1000, 3)
    val rdd2 = rdd1.sample(false, 0.1, 0)

    rdd2.collect().foreach(println)
    println(rdd2.count())

  }


  test("union Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(1 to 9, 3)
    val rdd11 = sc.parallelize(1 to 3, 3)
    val rdd2 = rdd1.union(rdd11)
    rdd2.collect().foreach(println)

  }

  test("intersection Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(1 to 9, 3)
    val rdd11 = sc.parallelize(1 to 3, 3)
    val rdd2 = rdd1.intersection(rdd11)
    rdd2.collect().foreach(println)

  }

  test("distinct Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(1 to 9, 3)
    val rdd11 = sc.parallelize(1 to 3, 3)
    val rdd2 = rdd1.union(rdd11).distinct()
    rdd2.collect().foreach(println)

  }

  test("groupByKey Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(Array((1, 1), (1, 2), (1, 4), (3, 1), (3, 2), (2, 3)), 3)
    val rdd2 = rdd1.groupByKey()
    rdd2.collect().foreach(println)

  }


  test("reduceByKey Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(Array((1, 1), (1, 2), (1, 4), (3, 1), (3, 2), (2, 3)), 3)
    val rdd2 = rdd1.reduceByKey((x, y) => x + y)
    rdd2.collect().foreach(println)

  }

  test("aggregateByKey Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(List((1, 1), (1, 2), (1, 4), (3, 1), (3, 2), (2, 3)))
    val rdd2 = rdd1.aggregateByKey(0)(math.max(_, _), _ + _)
    rdd2.foreach(println)

  }

  test("combineByKey Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(Array((1, 1), (1, 2), (1, 4), (3, 1), (3, 2), (2, 3)), 2)

    //    val rdd2 = rdd1.combineByKey(createCombiner = (v:Double)  => (v: Double, 1),
    //      mergeValue = (c: (Double, Int), v: Double) => (c._1 + v, c._2 + 1),
    //      mergeCombiners = (c1: (Double, Int), c2: (Double, Int)) => (c1._1 + c2._1, c1._2 + c2._2),
    //      numPartitions = 2)

    //    val rdd2 = rdd1.combineByKey(createCombiner = { (v: Double) => (v: Double, 1) },
    //      mergeValue = { (c: (Double, Int), v: Double) => (c._1 + v, c._2 + 1) },
    //      mergeCombiners = { (c1: (Double, Int), c2: (Double, Int)) => (c1._1 + c2._1, c1._2 + c2._2) },
    //      numPartitions = 2)
    //    rdd2.collect().foreach(println)

  }


  test("sortByKey Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(List((1, 1), (1, 2), (1, 4), (3, 1), (3, 2), (2, 3)))
    val rdd2 = rdd1.sortByKey()
    rdd2.foreach(println)

  }

  test("cogroup Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(Array((1, 1), (1, 2), (1, 4), (3, 1), (3, 2), (2, 3)), 3)
    val rdd2 = rdd1.cogroup(rdd1)
    rdd2.collect().foreach(println)

  }

  /**
    * pipe中执行shell脚本处理RDD
    */
  test("pipe Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(1 to 9, 3)
    rdd1.pipe("head -n 1")
    val rdd2 =  rdd1.pipe("head -n 1")
    rdd2.collect().foreach(println)

  }

  /**
    * 随机划分
    */
  test("randomSplit Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(1 to 9, 3)
    rdd1.pipe("head -n 1")
    val rdd2 =  rdd1.randomSplit(Array(0.3,0.7),1)
    rdd2(0).foreach(println)

  }

  /**
    *集合进行减法操作
    */
  test("subtract Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    val rdd1 = sc.parallelize(1 to 9, 3)
    val rdd11 = sc.parallelize(1 to 3, 3)
    val rdd2 =  rdd1.subtract(rdd11)
    rdd2.foreach(println)

  }




}
