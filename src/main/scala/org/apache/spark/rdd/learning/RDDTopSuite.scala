package org.apache.spark.rdd.learning

import org.apache.log4j.{Level, Logger}
import org.apache.spark.rdd.learning.RDDTopSuite.NameOrdering
import org.apache.spark.util.SparkLearningFunSuite

import scala.collection.mutable.ArrayBuffer

/**
  * ref:Spark MLlib 机器学习 算法、源码及实战详解
  * Created by xingyun.xb on 2016/7/24.
  */
class RDDTopSuite extends SparkLearningFunSuite {
  test("top Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    var arr = ArrayBuffer[Person]()
    for (i <- 0 to 9) {
      arr.append(new Person("name" + i, i))
    }

    val RDD = sc.parallelize(arr)
    RDD.foreach(println)

    println("\n\nTop:")
    implicit val ord = implicitly[Ordering[Int]]
    RDD.top(2)(NameOrdering).foreach {
      println
    }
  }

}

class Person extends Serializable {
  var name = "";
  var age = 0;

  def this(name: String, age: Int) {
    this()
    this.name = name
    this.age = age
  }

  override def toString = s"Person($name, $age)"

}

object RDDTopSuite {

  object NameOrdering extends Ordering[Person] {
    def compare(a: Person, b: Person): Int =
      implicitly[Ordering[Int]].compare(a.age, b.age)
  }

}