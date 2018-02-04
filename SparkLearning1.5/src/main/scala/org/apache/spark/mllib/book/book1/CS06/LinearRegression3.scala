package org.apache.spark.mllib.book.book1.CS06

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}

object LinearRegression3 {
  val conf = new SparkConf() //创建环境变量
    .setMaster("local") //设置本地化处理
    .setAppName("LinearRegression3 ")
  //设定名称
  val sc = new SparkContext(conf) //创建环境变量实例

  def main(args: Array[String]) {
    val data = sc.textFile("c:/lr.txt") //获取数据集路径
    val parsedData = data.map { line => //开始对数据集处理
        val parts = line.split('|') //根据逗号进行分区
        LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(',').map(_.toDouble)))
      }.cache() //转化数据格式
    val model = LinearRegressionWithSGD.train(parsedData, 2, 0.1) //建立模型
    val valuesAndPreds = parsedData.map { point => {
        //获取真实值与预测值
        val prediction = model.predict(point.features) //对系数进行预测
        (point.label, prediction) //按格式存储
      }
      }

    val MSE = valuesAndPreds.map { case (v, p) => math.pow((v - p), 2) }.mean() //计算MSE
    println(MSE)
  }

}
