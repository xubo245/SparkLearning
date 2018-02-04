package org.apache.spark.rdd

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/10/8.
  */
class PartitionerSparkPackageTest extends SparkLearningFunSuite {

  test("rdd partitions_") {
    var rdd = sc.parallelize(Array(11, 12, 13, 14, 15), 2)
    println(rdd.partitions.size)

    /**
      * 没有成功，不是subclass
      */
    //    val test1=rdd.getPartitions
    //    test1.foreach(println)
  }

  test("rdd partition id") {
    val RDD = sc.parallelize(Array(11, 12, 13, 14, 15), 2)
    RDD.partitions.foreach { each =>
      println(each)
      println("\t" + each.index)
      println("\t" + each.hashCode())
    }
    RDD.foreachPartition { each =>
      println("***" + each.size + "***")
      each.foreach(println)
      println(each.length)

    }

    //debug 可以在RDDzhong的partitions_看到partition数据，但是是private，无法调用
    //    RDD.partitions_
  }

}
