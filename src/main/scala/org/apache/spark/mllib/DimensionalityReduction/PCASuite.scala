/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.DimensionalityReduction

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class PCASuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    import org.apache.spark.mllib.linalg.Matrix
    import org.apache.spark.mllib.linalg.distributed.RowMatrix

    //    val mat: RowMatrix = ...
    val rdd = sc.textFile("file/data/mllib/input/basic/MatrixRow33.txt") //创建RDD文件路径
      .map(_.split(' ') //按“ ”分割
      .map(_.toDouble)) //转成Double类型
      .map(line => Vectors.dense(line)) //转成Vector格式
    val mat = new RowMatrix(rdd)

    // Compute the top 3 principal components.
    val pc: Matrix = mat.computePrincipalComponents(3) // Principal components are stored in a local dense matrix.

    // Project the rows to the linear space spanned by the top 10 principal components.
    val projected: RowMatrix = mat.multiply(pc)

    println("mat:")
    mat.rows.foreach(println)
    println("pc:")
    println(pc)
    println("projected:")
    projected.rows.foreach(println)
  }
}
