
更多代码请见：https://github.com/xubo245/SparkLearning  

Spark中组件Mllib的学习

1.解释

![](http://latex.codecogs.com/gif.latex?A=QR)

求矩阵A的Q和R分解矩阵
更多请见：【4】



2.代码：

	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.basic
	
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.rdd.RDD
	import org.apache.spark.util.SparkLearningFunSuite

	/**
	  * Created by xubo on 2016/6/13.
	  * ref:http://blog.csdn.net/openspirit/article/details/13800067
	  * 结论：与ref一致
	  * 有些矩阵无法QR分解，会报空指针异常
	  */
	class RowMatrixSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	    //    val rdd = sc.parallelize(Array(1, 2, 3))
	    //    println("count:" + rdd.count())
	    import org.apache.spark.mllib.linalg.Vector
	    import org.apache.spark.mllib.linalg.distributed.RowMatrix
	    val rdd = sc.textFile("file/data/mllib/input/basic/MatrixRow33.txt") //创建RDD文件路径
	      .map(_.split(' ') //按“ ”分割
	      .map(_.toDouble)) //转成Double类型
	      .map(line => Vectors.dense(line)) //转成Vector格式
	    val mat = new RowMatrix(rdd)
	
	    // Get its size.
	    val m = mat.numRows()
	    val n = mat.numCols()
	    println("m:" + m)
	    println("n:" + n)
	    println("mat:" + mat)
	    // QR decomposition
	    val qrResult = mat.tallSkinnyQR(true)
	    println()
	    println("qrResult.R:\n" + qrResult.R)
	    println("qrResult.Q:" + qrResult.Q)
	    qrResult.Q.rows.foreach(println)
	  }
	}


数据：

	1 0 0
	1 1 0
	1 1 1
	1 1 1

3.结果：
	
	m:4
	n:3
	mat:org.apache.spark.mllib.linalg.distributed.RowMatrix@4a34ddc9
	2016-06-13 16:30:55 WARN  LAPACK:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemLAPACK
	2016-06-13 16:30:55 WARN  LAPACK:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefLAPACK
	
	qrResult.R:
	2.0000000000000004  1.4999999999999996   0.9999999999999998   
	0.0                 -0.8660254037844386  -0.577350269189626   
	0.0                 0.0                  -0.8164965809277259  
	qrResult.Q:org.apache.spark.mllib.linalg.distributed.RowMatrix@29dbcdf9
	2016-06-13 16:30:56 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
	2016-06-13 16:30:56 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
	[0.4999999999999999,-0.2886751345948133,-0.4082482904638629]
	[0.4999999999999999,-0.2886751345948133,-0.4082482904638629]
	[0.4999999999999999,0.8660254037844384,-2.719479911021037E-16]
	[0.4999999999999999,-0.2886751345948133,0.8164965809277263]



参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://blog.csdn.net/openspirit/article/details/13800067
