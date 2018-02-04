package org.apache.spark.mllib.book.book1.C07

import org.apache.spark.mllib.classification.SVMWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

object SVM {
  def main(args: Array[String]) {
val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("SVM")                              			//设定名称
    val sc = new SparkContext(conf)                                //创建环境变量实例
    val data = sc.textFile("c:/u.txt")							  	//获取数据集路径
    val parsedData = data.map { line =>							//开始对数据集处理
      val parts = line.split('|')									//根据逗号进行分区
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
    }.cache()                                                      //转化数据格式
    val model = SVMWithSGD.train(parsedData, 10)				//训练数据模型
    println(model.weights)									//打印权重
    println(model.intercept)									//打印截距
  }
}
