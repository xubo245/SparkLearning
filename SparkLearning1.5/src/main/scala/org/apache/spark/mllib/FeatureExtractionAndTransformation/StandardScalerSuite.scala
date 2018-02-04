/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.FeatureExtractionAndTransformation

import org.apache.spark.mllib.feature.StandardScalerModel
import org.apache.spark.util.SparkLearningFunSuite
import org.apache.spark.SparkContext._
import org.apache.spark.mllib.feature.StandardScaler
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.util.MLUtils

/**
  * Created by xubo on 2016/6/13.
  */
class StandardScalerSuite extends SparkLearningFunSuite {
  test("testFunSuite") {

    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_libsvm_data.txt")

    val scaler1 = new StandardScaler().fit(data.map(x => x.features))
    val scaler2 = new StandardScaler(withMean = true, withStd = true).fit(data.map(x => x.features))
    // scaler3 is an identical model to scaler2, and will produce identical transformations
    val scaler3 = new StandardScalerModel(scaler2.std, scaler2.mean)

    // data1 will be unit variance.
    val data1 = data.map(x => (x.label, scaler1.transform(x.features)))

    // Without converting the features into dense vectors, transformation with zero mean will raise
    // exception on sparse vector.
    // data2 will be unit variance and zero mean.
    val data2 = data.map(x => (x.label, scaler2.transform(Vectors.dense(x.features.toArray))))

    println("model:")
    println("scaler1.mean:" + scaler1.mean)
    println("scaler1.std:" + scaler1.std)
    println("scaler1.withMean:" + scaler1.withMean)
    println("scaler1.withStd:" + scaler1.withStd)
    println("scaler2.mean:" + scaler2.mean)
    println("scaler2.std:" + scaler2.std)
    println("scaler2.withMean:" + scaler2.withMean)
    println("scaler2.withStd:" + scaler2.withStd)
    println("scaler3.mean:" + scaler3.mean)
    println("scaler3.std:" + scaler3.std)
    println("scaler3.withMean:" + scaler3.withMean)
    println("scaler3.withStd:" + scaler3.withStd)
    println("data:")
    data.take(10).foreach { each =>
      println(each.label + " " + each.features)
      println(each.features.size)
    }
    println("data1:")
    data1.take(10).foreach { each =>
      println(each._1 + " " + each._2)
      println(each._2.size)
    }
    println("data2:")
    data2.take(10).foreach { each =>
      println(each._1 + " " + each._2)
      println(each._2.size)
    }
  }
}
