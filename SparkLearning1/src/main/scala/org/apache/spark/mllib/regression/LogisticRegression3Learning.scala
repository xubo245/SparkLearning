/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.regression

import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by xubo on 2016/5/23.
  * 多元逻辑回归,带验证
  */
object LogisticRegression3Learning {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/regression/sample_libsvm_data.txt") //读取数据文件
    val splits = data.randomSplit(Array(0.6, 0.4), seed = 11L) //对数据集切分
    val parsedData = splits(0) //分割训练数据
    val parseTtest = splits(1) //分割测试数据
    val model = LogisticRegressionWithSGD.train(parsedData, 50) //训练模型
    println(model.weights) //打印θ值
    println("model.weights.size:" + model.weights.size) //打印θ数量
    val predictionAndLabels = parseTtest.map {
        //计算测试值
        case LabeledPoint(label, features) => //计算测试值
          val prediction = model.predict(features) //计算测试值
          (prediction, label) //存储测试和预测值
      }
    val metrics = new MulticlassMetrics(predictionAndLabels) //创建验证类
    val precision = metrics.precision //计算验证值
    println("data:" + data.count())
    println("parsedData:" + parsedData.count())
    println("parseTtest:" + parseTtest.count())
    println("Precision = " + precision) //打印验证值
    predictionAndLabels.take(10).foreach(println)

    sc.stop
  }
}
