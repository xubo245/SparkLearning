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
class ElementwiseProductFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {


    import org.apache.spark.SparkContext._
    import org.apache.spark.mllib.feature.ElementwiseProduct
    import org.apache.spark.mllib.linalg.Vectors

    // Create some vector data; also works for sparse vectors
    val data = sc.parallelize(Array(Vectors.dense(1.0, 2.0, 3.0), Vectors.dense(4.0, 5.0, 6.0)))

    val transformingVector = Vectors.dense(0.0, 1.0, 2.0)
    val transformer = new ElementwiseProduct(transformingVector)

    // Batch transform and per-row transform give the same results:
    val transformedData = transformer.transform(data)
    val transformedData2 = data.map(x => transformer.transform(x))

    println("data:")
    data.foreach(println)
    println("transformer:" + transformer.scalingVec)

    //    transformer.foreach(println)
    println("transformedData:")
    transformedData.foreach(println)

  }
}
