package org.apache.spark.mllib.book.book1.C07

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

object LogisticRegression {
  val conf = new SparkConf() //创建环境变量
    .setMaster("local") //设置本地化处理
    .setAppName("LogisticRegression ")
  //设定名称
  val sc = new SparkContext(conf) //创建环境变量实例

  def main(args: Array[String]) {
    val data = sc.textFile("c:/u.txt") //获取数据集路径
    val parsedData = data.map { line => //开始对数据集处理
        val parts = line.split('|') //根据逗号进行分区
        LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
      }.cache() //转化数据格式
    val model = LogisticRegressionWithSGD.train(parsedData, 50) //建立模型
    val target = Vectors.dense(-1) //创建测试值
    val resulet = model.predict(target) //根据模型计算结果
    println(resulet) //打印结果
  }
}

