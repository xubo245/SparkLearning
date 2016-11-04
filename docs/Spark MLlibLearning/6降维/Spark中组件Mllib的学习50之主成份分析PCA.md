
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

Principal component analysis (PCA)：主成份分析

从数据矩阵中抽取矩阵的k个主向量，代表矩阵的主要影响向量

具体请看【5】和【6】

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
	  */
	class PCASuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	    import org.apache.spark.mllib.linalg.Matrix
	    import org.apache.spark.mllib.linalg.distributed.RowMatrix
	
	    //    val mat: RowMatrix = ...
	    val rdd = sc.textFile("file/data/mllib/input/basic/MatrixRow33.txt") //创建RDD文件路径
	      .map(_.split(' ') //按“ ”分割
	      .map(_.toDouble)) //转成Double类型
	      .map(line => Vectors.dense(line)) //转成Vector格式
	    val mat = new RowMatrix(rdd)
	
	    // Compute the top 10 principal components.
	    val pc: Matrix = mat.computePrincipalComponents(3) // Principal components are stored in a local dense matrix.
	
	    // Project the rows to the linear space spanned by the top 10 principal components.
	    val projected: RowMatrix = mat.multiply(pc)
	
	    println("mat:")
	    mat.rows.foreach(println)
	    println("pc:")
	    println(pc)
	    println("projected:")
	    projected.rows.foreach(println)
	  }
	}


3.结果：

主成份为2：

	mat:
	[1.0,0.0,0.0]
	[1.0,1.0,1.0]
	[1.0,1.0,0.0]
	[1.0,1.0,1.0]
	pc:
	0.0                  0.0                  
	-0.6154122094026357  -0.7882054380161092  
	-0.7882054380161091  0.6154122094026356   
	projected:
	[0.0,0.0]
	[-1.403617647418745,-0.17279322861347357]
	[-0.6154122094026357,-0.7882054380161092]
	[-1.403617647418745,-0.17279322861347357]

主成份为3：
	
	mat:
	[1.0,0.0,0.0]
	[1.0,1.0,1.0]
	[1.0,1.0,0.0]
	[1.0,1.0,1.0]
	pc:
	0.0                  0.0                  1.0  
	-0.6154122094026357  -0.7882054380161092  0.0  
	-0.7882054380161091  0.6154122094026356   0.0  
	projected:
	[0.0,0.0,1.0]
	[-1.403617647418745,-0.17279322861347357,1.0]
	[-0.6154122094026357,-0.7882054380161092,1.0]
	[-1.403617647418745,-0.17279322861347357,1.0]

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】Spark MlLib机器学习实战
 	【6】http://spark.apache.org/docs/1.5.2/mllib-dimensionality-reduction.html
