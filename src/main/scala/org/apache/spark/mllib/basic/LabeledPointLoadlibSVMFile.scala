/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.basic

import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkContext, SparkConf}

/**
  * 从文本中读取带标签的数据
  *
  * Created by xubo on 2016/5/23.
  *
  */
object LabeledPointLoadlibSVMFile {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    //  println(this.getClass().getSimpleName().filter(!_.equals('$')))
    //设置环境变量
    val sc = new SparkContext(conf)

    val mu = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt") //读取文件
    mu.foreach(println) //打印内容

    sc.stop
  }
}
