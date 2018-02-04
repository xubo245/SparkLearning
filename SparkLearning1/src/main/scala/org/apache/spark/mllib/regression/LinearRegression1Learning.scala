package org.apache.spark.mllib.regression

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

import scala.Array.canBuildFrom

object LinearRegression1Learning {
  def main(args: Array[String]): Unit = {
    // 屏蔽不必要的日志显示终端上
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)

    // 设置运行环境
    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
    val sc = new SparkContext(conf)

    // Load and parse the data
    val data = sc.textFile("file/data/mllib/input/ridge-data/lpsa.data",1)
    //如果读入不加1，会产生两个文件，应该是默认生成了两个partition
    val parsedData = data.map { line =>
      val parts = line.split(',')
      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
    }

    // Building the model
    //建立model的数据和predict的数据没有分开
    val numIterations = 100
    val model = LinearRegressionWithSGD.train(parsedData, numIterations)
    //    for(i<-parsedData) println(i.label+":"+i.features);
    // Evaluate model on training examples and compute training error
    val valuesAndPreds = parsedData.map { point =>
      val prediction = model.predict(point.features)
      (point.label, prediction)
    }
    //print model.weights
    var weifhts=model.weights
    println("model.weights"+weifhts)
    
    //save as file
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    val path = "file/data/mllib/output/LinearRegression/" + iString + "/result"
    valuesAndPreds.saveAsTextFile(path)
    val MSE = valuesAndPreds.map { case (v, p) => math.pow((v - p), 2) }.reduce(_ + _) / valuesAndPreds.count
    println("training Mean Squared Error = " + MSE)

    sc.stop()
  }
}