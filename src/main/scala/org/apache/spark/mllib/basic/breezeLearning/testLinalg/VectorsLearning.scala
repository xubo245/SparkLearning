package org.apache.spark.mllib.basic.breezeLearning.testLinalg

import org.apache.spark.annotation.Since

/**
  * Created by xingyun.xb on 2016/7/30.
  */
object VectorsLearning {

}

//class DenseVector @Since("1.0.0") (){
//
//  /**
//    * Generate a `DenseMatrix` consisting of zeros.
//    * @param numRows number of rows of the matrix
//    * @param numCols number of columns of the matrix
//    * @return `DenseMatrix` with size `numRows` x `numCols` and values of zeros
//    */
//  @Since("1.3.0")
//  def zeros(numRows: Int, numCols: Int): DenseMatrix = {
//    require(numRows.toLong * numCols <= Int.MaxValue,
//      s"$numRows x $numCols dense matrix is too large to allocate")
//    new DenseMatrix(numRows, numCols, new Array[Double](numRows * numCols))
//  }
//}
