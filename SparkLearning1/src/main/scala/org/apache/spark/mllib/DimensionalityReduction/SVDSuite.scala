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
  * book:Machine Learning with Spark ,Nick Pertreach
  */
class SVDSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    import org.apache.spark.mllib.linalg.Matrix
    import org.apache.spark.mllib.linalg.distributed.RowMatrix
    import org.apache.spark.mllib.linalg.SingularValueDecomposition

    //    val mat: RowMatrix =...
    val rdd = sc.textFile("file/data/mllib/input/basic/MatrixRow33.txt") //创建RDD文件路径
      .map(_.split(' ') //按“ ”分割
      .map(_.toDouble)) //转成Double类型
      .map(line => Vectors.dense(line)) //转成Vector格式
    val mat = new RowMatrix(rdd)


    // Compute the top 3 singular values and corresponding singular vectors.
    val svd: SingularValueDecomposition[RowMatrix, Matrix] = mat.computeSVD(3, computeU = true)
    val U: RowMatrix = svd.U // The U factor is a RowMatrix.
    val s = svd.s // The singular values are stored in a local dense vector.
    val V: Matrix = svd.V // The V factor is a local dense matrix.

    println("mat:")
    mat.rows.foreach(println)
    println("U:")
    U.rows.foreach(println)
    println("s:" + s)
    println("V:\n" + V)
  }
}
