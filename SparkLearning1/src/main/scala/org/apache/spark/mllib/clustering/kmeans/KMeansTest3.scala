/**
 * 测试了mllib。KMeans的聚类，使用的是自带的数据集
 * 之进行了聚类和误差平方和分析
 * 参考：
 * （1）http://www.cnblogs.com/shishanyuan/p/4747778.html
 * （2）炼数成金教学视频
 * 改进：
 * （1）在存储路径中加入了当前时间，每次运行都不一样，避免每次修改
 * (2)加入runs，多次运行
 *
 * train 调用方法：
 * def train(
      data: RDD[Vector],
      k: Int,
      maxIterations: Int,
      runs: Int,
      initializationMode: String,
      seed: Long)
 */
package org.apache.spark.mllib.clustering.kmeans

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

import scala.Array.canBuildFrom
object KMeansTest3 {
  def main(args: Array[String]) {
    // 屏蔽不必要的日志显示在终端上
    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)

    // 设置运行环境
    //    val conf = new SparkConf().setAppName("Kmeans").setMaster("local[4]")
    val conf = new SparkConf().setAppName("KMeansTest3").setMaster("local")
    val sc = new SparkContext(conf)

    // 装载数据集
    val data = sc.textFile("file/data/mllib/input/kmeans_data.txt", 1)
    val parsedData = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble)))

    // 将数据集聚类，2个类，20次迭代，进行模型训练形成数据模型
    val numClusters = 2
    val numIterations = 20
    val runs = 10
    val model = KMeans.train(parsedData, numClusters, numIterations,runs)
    
    // 打印原来数组
    println("Input data:");
    for(i<-parsedData) println(" "+i);
    
    // 打印数据模型的中心点
    println("Cluster centers:")
    for (c <- model.clusterCenters) println("  " + c.toString)

    // 使用误差平方之和来评估数据模型
    val cost = model.computeCost(parsedData)
    println("Within Set Sum of Squared Errors = " + cost)

    // 使用模型测试单点数据
    println("Vectors 0.2 0.2 0.2 is belongs to clusters:" + model.predict(Vectors.dense("0.2 0.2 0.2".split(' ').map(_.toDouble))))
    println("Vectors 0.25 0.25 0.25 is belongs to clusters:" + model.predict(Vectors.dense("0.25 0.25 0.25".split(' ').map(_.toDouble))))
    println("Vectors 8 8 8 is belongs to clusters:" + model.predict(Vectors.dense("8 8 8".split(' ').map(_.toDouble))))
    println("Vectors 5 5 5 is belongs to clusters:" + model.predict(Vectors.dense("5 5 5".split(' ').map(_.toDouble))))
    println("Vectors 5.1 5.1 5.1 is belongs to clusters:" + model.predict(Vectors.dense("5.1 5.1 5.1".split(' ').map(_.toDouble))))
  
    //生成当前时间的字符串，时间每次运行都不一样
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
  
    // 交叉评估1，只返回结果
    // 用训练数据作为预测数据不严谨，应该说是过拟合   by xubo
    val testdata = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble)))
    val result1 = model.predict(testdata)
    result1.saveAsTextFile("file/data/mllib/output/kmeans_data/"+iString+"/1")

    // 交叉评估2，返回数据集和结果
    val result2 = data.map {
      line =>
        val linevectore = Vectors.dense(line.split(' ').map(_.toDouble))
        val prediction = model.predict(linevectore)
        line + " " + prediction
    }.saveAsTextFile("file/data/mllib/output/kmeans_data/"+iString+"/2")
    sc.stop()
  }
}