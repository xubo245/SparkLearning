package org.apache.spark.sourceCode.partitionerLearning

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/10/8.
  */
class PartitionerTest extends SparkLearningFunSuite {
  test("URLHashPartitioner") {
    var url1 = new URLHashPartitioner(20)
    var partition1 = url1.getPartition("https://github.com/xubo245/SparkLearning")
    var partition2 = url1.getPartition("https://github.com/xubo245")
    println(partition1)
    println(partition2)
  }

  test("rdd partition"){
    var rdd=sc.parallelize( Array((11,21),(12,22),(13,29),(14,24)),2)
    println(rdd.partitions.size)
  }

  test("rdd partition2"){
    var rdd=sc.parallelize( Array((11,21),(12,22),(13,29),(14,24)),3)
    println(rdd.partitions.size)
  }

  test("rdd id"){
    var rdd=sc.parallelize( Array((11,21),(12,22),(13,29),(14,24)),3)
    println(rdd.id)
    var rdd2=sc.parallelize( Array((11,21),(12,22),(13,29),(14,24)),5)
    println(rdd2.id)
  }

}
