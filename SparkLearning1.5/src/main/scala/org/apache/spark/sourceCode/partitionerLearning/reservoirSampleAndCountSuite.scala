package org.apache.spark.sourceCode.partitionerLearning

import org.apache.spark.util.SparkLearningFunSuite
import org.apache.spark.util.random.SamplingUtils

import scala.util.Random

/**
  * Created by xubo on 2016/10/9.
  */
class reservoirSampleAndCountSuite extends SparkLearningFunSuite {
  test("reservoirSampleAndCount") {
    val input = Seq.fill(100)(Random.nextInt())
    val (sample1, count1) = SamplingUtils.reservoirSampleAndCount(input.iterator, 150)
    assert(count1 === 100)
    assert(input === sample1.toSeq)

    // input size == k
    val (sample2, count2) = SamplingUtils.reservoirSampleAndCount(input.iterator, 100)
    assert(count2 === 100)
    assert(input === sample2.toSeq)

    // input size > k
    val (sample3, count3) = SamplingUtils.reservoirSampleAndCount(input.iterator, 10)
    assert(count3 === 100)
    assert(sample3.length === 10)
    println(input)
    sample3.foreach{each=>print(each+" ")}
  }

}
