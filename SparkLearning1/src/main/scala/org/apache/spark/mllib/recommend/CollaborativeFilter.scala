/**
  * @author xubo
  *         time 20160516
  *         ref 《Spark MlLib 机器学习实战》P64
  *         http://spark.apache.org/docs/1.5.2/mllib-collaborative-filtering.html#collaborative-filtering
  *         spark 1.5.2
  *         该例子成功
  */
package org.apache.spark.mllib.recommend

import org.apache.spark._
import org.apache.spark.mllib.recommendation.{ALS, Rating}

object CollaborativeFilter {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    //设置环境变量
    val sc = new SparkContext(conf) //实例化环境
    //    val data = sc.textFile("c://u1.txt") //设置数据集  //data/mllib/als/test.data
    //    val data = sc.textFile("file/data/mllib/input/movielens/ml-100k/u.data")
    val data = sc.textFile("file/data/mllib/input/test.data")
    //    D:\all\idea\SparkLearning\file\data\mllib\input\test.data
    val ratings = data.map(_.split(',') match {
      //处理数据
      case Array(user, item, rate) => //将数据集转化
        Rating(user.toInt, item.toInt, rate.toDouble) //将数据集转化为专用Rating
    })
    val rank = 2 //设置隐藏因子
    val numIterations = 2 //设置迭代次数
    val model = ALS.train(ratings, rank, numIterations, 0.01) //进行模型训练
    var rs = model.recommendProducts(2, 1)

    //        var rs = model.recommendProducts(2, 1) //为用户2推荐一个商品
    rs.foreach(println) //打印结果
    println("success")
  }
}
