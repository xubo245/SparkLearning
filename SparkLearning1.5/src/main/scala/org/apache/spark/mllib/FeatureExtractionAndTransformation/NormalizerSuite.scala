/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.FeatureExtractionAndTransformation

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class NormalizerSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    import org.apache.spark.SparkContext._
    import org.apache.spark.mllib.feature.Normalizer
    import org.apache.spark.mllib.linalg.Vectors
    import org.apache.spark.mllib.util.MLUtils

    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_libsvm_data.txt")

//    val data = MLUtils.loadLibSVMFile(sc, "data/mllib/sample_libsvm_data.txt")
    val normalizer1 = new Normalizer()
    val normalizer2 = new Normalizer(p = Double.PositiveInfinity)


    // Each sample in data1 will be normalized using $L^2$ norm.
    val data1 = data.map(x => (x.label, normalizer1.transform(x.features)))

    // Each sample in data2 will be normalized using $L^\infty$ norm.
    val data2 = data.map(x => (x.label, normalizer2.transform(x.features)))
    println("model:")

    println("data:")
    data.take(10).foreach { each =>
      println(each.label + " " + each.features)
      //      println(each.features.size)
    }
    println("data1:")
    data1.take(10).foreach { each =>
      println(each._1 + " " + each._2)
      //      println(each._2.size)
    }
    println("data2:")
    data2.take(10).foreach { each =>
      println(each._1 + " " + each._2)
      //      println(each._2.size)
    }


  }
}
