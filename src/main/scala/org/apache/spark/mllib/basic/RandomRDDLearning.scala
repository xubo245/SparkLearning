/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.basic

import org.apache.spark.mllib.random.RandomRDDs._
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  */
object RandomRDDLearning {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)
    println("normalRDD:")
    val randomNum = normalRDD(sc, 10)
    randomNum.foreach(println)
    println("uniformRDD:")
    uniformRDD(sc, 10).foreach(println)
    println("poissonRDD:")
    poissonRDD(sc, 5,10).foreach(println)
    println("exponentialRDD:")
    exponentialRDD(sc,7, 10).foreach(println)
    println("gammaRDD:")
    gammaRDD(sc, 3,3,10).foreach(println)
    sc.stop
  }
}
