package org.apache.spark.sourceCode.partitionerLearning

import org.apache.spark.Partitioner

/**
  * Created by xubo on 2016/10/8.
  */
class URLHashPartitioner(numParts: Int) extends Partitioner {
  override def numPartitions: Int = numParts

  override def getPartition(key: Any): Int = {
    val domain = new java.net.URL(key.toString).getHost()
    val code = (domain.hashCode % numPartitions)
    if (code < 0) {
      code + numPartitions
    } else {
      code
    }
  }

  override def equals(other: Any): Boolean = other match {
    case url: URLHashPartitioner =>
      url.numPartitions == numPartitions
    case _ =>
      false
  }

  override def hashCode: Int = numPartitions
}

object URLHashPartitioner {
  def main(args: Array[String]) {

  }
}