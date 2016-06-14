/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.basic

import org.apache.spark.mllib.linalg.Vectors

/**
  * Created by xubo on 2016/5/23.
  * Vector
  */
object VectorLearning {
  def main(args: Array[String]) {

    val vd = Vectors.dense(2, 0, 6)
    println(vd(2))
    println(vd)

    //数据个数，序号，value
    val vs = Vectors.sparse(4, Array(0, 1, 2, 3), Array(9, 5, 2, 7))
    println(vs(2))
    println(vs)

    val vs2 = Vectors.sparse(4, Array(0, 2, 1, 3), Array(9, 5, 2, 7))
    println(vs2(2))
    println(vs2)



  }
}
