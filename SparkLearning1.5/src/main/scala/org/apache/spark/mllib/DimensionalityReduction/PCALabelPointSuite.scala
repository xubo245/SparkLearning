/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.DimensionalityReduction

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class PCALabelPointSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    import org.apache.spark.mllib.linalg.Matrix
    import org.apache.spark.mllib.linalg.distributed.RowMatrix

    //    val mat: RowMatrix = ...
    import org.apache.spark.mllib.regression.LabeledPoint
    import org.apache.spark.mllib.feature.PCA

    val data: RDD[LabeledPoint] = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")

    // Compute the top 10 principal components.
    val pca = new PCA(10).fit(data.map(_.features))

    // Project vectors to the linear space spanned by the top 10 principal components, keeping the label
    val projected = data.map(p => p.copy(features = pca.transform(p.features)))

    println("data:" + data.count())
    data.take(20).foreach(println)
    println("pca:")
    println(pca)
    println("pca.k:" + pca.k)
    //    println("pca.pc:"+pca.pc)

    println("projected:" + projected.count())
    projected.take(20).foreach(println)
  }
}
