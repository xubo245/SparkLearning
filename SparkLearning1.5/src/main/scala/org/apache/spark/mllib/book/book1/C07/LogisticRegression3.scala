package org.apache.spark.mllib.book.book1.C07

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.evaluation.MulticlassMetrics

object LinearRegression3{
val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("LogisticRegression3")                              //设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例

  def main(args: Array[String]) {
    val data = MLUtils.loadLibSVMFile(sc, "c://sample_libsvm_data.txt")	//读取数据集
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L)			//对数据集切分
    val parsedData = splits(0)									//分割训练数据
    val parseTtest = splits(1)									//分割测试数据
    val model = LogisticRegressionWithSGD.train(parsedData,50)		//训练模型
    println(model.weights)									//打印θ值
   val predictionAndLabels = parseTtest.map { 					//计算测试值
case LabeledPoint(label, features) =>						//计算测试值
 val prediction = model.predict(features)						//计算测试值
      (prediction, label)										//存储测试和预测值
    }
    val metrics = new MulticlassMetrics(predictionAndLabels)			//创建验证类
    val precision = metrics.precision								//计算验证值
    println("Precision = " + precision)							//打印验证值
  }
}
