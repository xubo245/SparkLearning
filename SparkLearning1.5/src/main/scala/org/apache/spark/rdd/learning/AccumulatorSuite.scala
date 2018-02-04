package org.apache.spark.rdd.learning

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2017/3/20.
  */
class AccumulatorSuite extends SparkLearningFunSuite{

  test(" Accumulator test"){
    val accum = sc.accumulator(0, "My Accumulator")
    sc.parallelize(Array(1, 2, 3, 4)).foreach(x => accum += x)
    println(accum.value)
    assert(accum.value===10)
  }

}
