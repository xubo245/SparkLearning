/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.basic

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.rdd.RDD
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  * ref:http://blog.csdn.net/openspirit/article/details/13800067
  * 结论：与ref一致
  * 有些矩阵无法QR分解，会报空指针异常
  */
class RowMatrixSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    //    val rdd = sc.parallelize(Array(1, 2, 3))
    //    println("count:" + rdd.count())
    import org.apache.spark.mllib.linalg.Vector
    import org.apache.spark.mllib.linalg.distributed.RowMatrix
    val rdd = sc.textFile("file/data/mllib/input/basic/MatrixRow33.txt") //创建RDD文件路径
      .map(_.split(' ') //按“ ”分割
      .map(_.toDouble)) //转成Double类型
      .map(line => Vectors.dense(line)) //转成Vector格式
    val mat = new RowMatrix(rdd)

    // Get its size.
    val m = mat.numRows()
    val n = mat.numCols()
    println("m:" + m)
    println("n:" + n)
    println("mat:" + mat)
    // QR decomposition
    val qrResult = mat.tallSkinnyQR(true)
    println()
    println("qrResult.R:\n" + qrResult.R)
    println("qrResult.Q:" + qrResult.Q)
    qrResult.Q.rows.foreach(println)
  }
}
