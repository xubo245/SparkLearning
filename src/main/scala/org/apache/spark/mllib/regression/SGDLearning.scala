/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.regression

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.HashMap

/**
  * Created by xubo on 2016/5/23.
  */
object SGDLearning {
  val data = HashMap[Int, Int]()

  //创建数据集
  def getData(): HashMap[Int, Int] = {
    //生成数据集内容
    for (i <- 1 to 50) {
      //创建50个数据
      data += (i -> (20 * i)) //写入公式y=2x
    }
    data //返回数据集
  }

  var θ: Double = 0
  //第一步假设θ为0
  var α: Double = 0.5 //设置步进系数

  def sgd(x: Double, y: Double) = {
    //设置迭代公式
    θ = θ - α * ((θ * x) - y) //迭代公式
  }

  def main(args: Array[String]) {
    val dataSource = getData() //获取数据集
    println("data:")
    dataSource.foreach(each => print(each + " "))
    println("\nresult:")
    var num = 1;
    dataSource.foreach(myMap => {
      //开始迭代
      println(num + ":" + θ+" ("+myMap._1+","+myMap._2+")")
      sgd(myMap._1, myMap._2) //输入数据
      num = num + 1;
    })
    println("最终结果θ值为 " + θ) //显示结果
  }
}
