/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.util
import org.apache.spark.util.SparkLearningFunSuite
/**
  * Created by xubo on 2016/6/13.
  */
class modelFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    val rdd = sc.parallelize(Array(1, 2, 3))
    println("count:" + rdd.count())
  }
}
