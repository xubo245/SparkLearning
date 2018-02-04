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
class FeatureSelectionSuite extends SparkLearningFunSuite {
  test("ChiSqSelector") {
    import org.apache.spark.SparkContext._
    import org.apache.spark.mllib.linalg.Vectors
    import org.apache.spark.mllib.regression.LabeledPoint
    import org.apache.spark.mllib.util.MLUtils
    import org.apache.spark.mllib.feature.ChiSqSelector

    // Load some data in libsvm format
    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_libsvm_data.txt")
    // Discretize data in 16 equal bins since ChiSqSelector requires categorical features
    // Even though features are doubles, the ChiSqSelector treats each unique value as a category
    val discretizedData = data.map { lp =>
      LabeledPoint(lp.label, Vectors.dense(lp.features.toArray.map { x => (x / 16).floor }))
    }
    // Create ChiSqSelector that will select top 50 of 692 features
    val selector = new ChiSqSelector(50)
    // Create ChiSqSelector model (selecting features)
    val transformer = selector.fit(discretizedData)
    // Filter the top 50 features from each feature vector
    val filteredData = discretizedData.map { lp =>
      LabeledPoint(lp.label, transformer.transform(lp.features))
    }
    println("data:")
    data.take(10).foreach(println)
    println("filteredData:")
    filteredData.take(10).foreach(println)

  }
}
