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
object LinearRegression3Learning {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    val data = sc.textFile("file/data/mllib/input/regression/linearRegression3.txt") //获取数据集路径
    val parsedData = data.map { line => //开始对数据集处理
        val parts = line.split('|') //根据逗号进行分区
        LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(',').map(_.toDouble)))
      }.cache() //转化数据格式
    val model = LinearRegressionWithSGD.train(parsedData, 20, 0.1) //建立模型

    val result = model.predict(Vectors.dense(7, 400)) //通过模型预测模型
    println("data:")
    parsedData.foreach(println)
    println("model.")
    println(model.weights)
    println(result) //打印预测结果

    sc.stop
  }
}
