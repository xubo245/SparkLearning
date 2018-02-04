package org.apache.spark.mllib.book.book1.C08

import org.apache.spark.mllib.regression.IsotonicRegression
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}

object IS {
  def main(args: Array[String]) {

    val conf = new SparkConf() //创建环境变量
      .setMaster("local") //设置本地化处理
      .setAppName("IS") //设定名称
    val sc = new SparkContext(conf) //创建环境变量实例
    //    val data = MLUtils.loadLibSVMFile(sc, "c://u.txt") //输入数据集
    //
    //    val parsedData = data.map { line => //处理数据格式
    //      val parts = line.split(',').map(_.toDouble) //切分数据
    //      (parts(0), parts(1), 1.0) //分配数据格式
    //    }
    //
    //    val model = new IsotonicRegression().setIsotonic(true).run(parsedData) //建立模型
    //
    //    model.predictions.foreach(println) //打印保序回归模型
    //
    //    val res = model.predict(5) //创建预测值
    //    println(res) //打印预测结果


  }
}
