package org.apache.spark.mllib.book.book1.CS04

import org.apache.spark.{SparkConf, SparkContext}

object testStratifiedSampling2 {
  def main(args: Array[String]) {
val conf = new SparkConf()                                       //创建环境变量
.setMaster("local")                                               //设置本地化处理
.setAppName("testSingleCorrect2 ")                                //设定名称
    val sc = new SparkContext(conf)                                  //创建环境变量实例
    val data = sc.textFile("c://a.txt")                                   //读取数据
      .map(row => {                                                //开始处理
      if(row.length == 3)                                            //判断字符数
        (row,1)                                                    //建立对应map
      else (row,2)                                                  //建立对应map
    })
    val fractions: Map[String, Double] = Map("aa" -> 2)                 //设定抽样格式
    val approxSample = data.sampleByKey(withReplacement = false, fractions,0) //计算抽样样本
    approxSample.foreach(println)                                   //打印结果
  }
}
