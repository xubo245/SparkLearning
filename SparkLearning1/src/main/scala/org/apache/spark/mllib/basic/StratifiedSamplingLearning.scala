/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.basic

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  */
object StratifiedSamplingLearning {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)
    println("First:")
    val data = sc.textFile("file/data/mllib/input/basic/StratifiedSampling.txt") //读取数
      .map(row => {
      //开始处理
      if (row.length == 3) //判断字符数
        (row, 1) //建立对应map
      else (row, 2) //建立对应map
    }).map(each => (each._2, each._1))
    data.foreach(println)
    println("sampleByKey:")
    val fractions: Map[Int, Double] = (List((1, 0.2), (2, 0.8))).toMap //设定抽样格式
    val approxSample = data.sampleByKey(withReplacement = false, fractions, 0) //计算抽样样本
    approxSample.foreach(println)

    println("Second:")
    //http://homepage.cs.latrobe.edu.au/zhe/ZhenHeSparkRDDAPIExamples.html#sampleByKey
    val randRDD = sc.parallelize(List((7, "cat"), (6, "mouse"), (7, "cup"), (6, "book"), (7, "tv"), (6, "screen"), (7, "heater")))
    val sampleMap = List((7, 0.4), (6, 0.8)).toMap
    val sample2 = randRDD.sampleByKey(false, sampleMap, 42).collect
    sample2.foreach(println)

    println("Third:")
    //http://bbs.csdn.net/topics/390953396
    val a = sc.parallelize(1 to 20, 3)
    val b = a.sample(true, 0.8, 0)
    val c = a.sample(false, 0.8, 0)
    println("RDD a : " + a.collect().mkString(" , "))
    println("RDD b : " + b.collect().mkString(" , "))
    println("RDD c : " + c.collect().mkString(" , "))
    sc.stop
  }
}
