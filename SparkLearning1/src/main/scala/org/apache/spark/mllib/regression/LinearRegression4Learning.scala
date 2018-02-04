/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.regression

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  */
object LinearRegression4Learning {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    val data = sc.textFile("file/data/mllib/input/regression/linearRegression3.txt") //获取数据集路径
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

    sc.stop
  }
}
