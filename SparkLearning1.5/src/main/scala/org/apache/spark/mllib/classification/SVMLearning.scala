/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.classification

import org.apache.spark.mllib.classification.SVMWithSGD
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  * SVM
  */
object SVMLearning {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    val data = sc.textFile("file/data/mllib/input/regression/logisticRegression1.data") //获取数据集路径
    val parsedData = data.map { line => //开始对数据集处理
        val parts = line.split('|') //根据逗号进行分区
        LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
      }.cache() //转化数据格式
    val model = SVMWithSGD.train(parsedData, 10) //训练数据模型
    println(model.weights) //打印权重
    println(model.intercept) //打印截距
    println(model.predict(Vectors.dense(1)))
    println(model.predict(Vectors.dense(10)))
    sc.stop
  }
}
