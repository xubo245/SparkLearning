
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释
   
具体请参考【4】，讲的比较详细


2.代码：

	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.DimensionalityReduction
	
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  * book:Machine Learning with Spark ,Nick Pertreach
	  */
	class SVDSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	    import org.apache.spark.mllib.linalg.Matrix
	    import org.apache.spark.mllib.linalg.distributed.RowMatrix
	    import org.apache.spark.mllib.linalg.SingularValueDecomposition
	
	    //    val mat: RowMatrix =...
	    val rdd = sc.textFile("file/data/mllib/input/basic/MatrixRow33.txt") //创建RDD文件路径
	      .map(_.split(' ') //按“ ”分割
	      .map(_.toDouble)) //转成Double类型
	      .map(line => Vectors.dense(line)) //转成Vector格式
	    val mat = new RowMatrix(rdd)
	
	
	    // Compute the top 3 singular values and corresponding singular vectors.
	    val svd: SingularValueDecomposition[RowMatrix, Matrix] = mat.computeSVD(3, computeU = true)
	    val U: RowMatrix = svd.U // The U factor is a RowMatrix.
	    val s = svd.s // The singular values are stored in a local dense vector.
	    val V: Matrix = svd.V // The V factor is a local dense matrix.
	
	    println("mat:")
	    mat.rows.foreach(println)
	    println("U:")
	    U.rows.foreach(println)
	    println("s:" + s)
	    println("V:\n" + V)
	  }
	}



3.结果：

	mat:
	[1.0,1.0,1.0]
	[1.0,1.0,1.0]
	[1.0,0.0,0.0]
	[1.0,1.0,0.0]
	U:
	[-0.6067637394094294,-0.3352266406762714,0.13950220040841022]
	[-0.2418162496491055,0.712015746118639,0.6592104964916438]
	[-0.45299054127146393,0.517957311021789,-0.7256168365450623]
	[-0.6067637394094294,-0.3352266406762714,0.13950220040841022]
	s:[2.809211800166755,0.88646771116676,0.5678944081980605]
	V:
	-0.6793130619863371  0.6311789687764828   0.37436195478307166  
	-0.5932333119173848  -0.1720265367929079  -0.7864356987513785  
	-0.431981482758553   -0.7563200248659911  0.49129626351156824  


参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://spark.apache.org/docs/1.5.2/mllib-dimensionality-reduction.html
	【5】book:Machine Learning with Spark ,Nick Pertreach
