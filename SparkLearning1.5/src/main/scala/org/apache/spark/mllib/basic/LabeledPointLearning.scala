/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.basic

import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint

/**
  * Created by xubo on 2016/5/23.
  * 给Vector打Label
  */
object LabeledPointLearning {
  def main(args: Array[String]) {

    val vd = Vectors.dense(2, 0, 6)
    val pos = LabeledPoint(1, vd) //对密集向量建立标记点
    println(pos.features)
    println(pos.label)
    println(pos)

    val vs = Vectors.sparse(4, Array(0, 1, 2, 3), Array(9, 5, 2, 7))
    val neg = LabeledPoint(2, vs) //对稀疏向量建立标记点
    println(neg.features)
    println(neg.label)
    println(neg)


  }
}
