更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之基础概念篇  
1解释  
创建分布式矩阵  

2.代码：  

```

	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.basic
	
	import org.apache.spark.mllib.linalg.Matrices
	import org.apache.spark.mllib.util.MLUtils
	import org.apache.spark.{SparkContext, SparkConf}
	
	/**
	  * Created by xubo on 2016/5/23.
	  * 创建分布式矩阵
	  */
	object MatrixLearning {
	  def main(args: Array[String]) {
	    val mx = Matrices.dense(2, 3, Array(1, 2, 3, 4, 5, 6)) //创建一个分布式矩阵
	    println(mx) //打印结果
	
	    val arr=(1 to 6).toArray.map(_.toDouble)
	    val mx2 = Matrices.dense(2, 3, arr) //创建一个分布式矩阵
	    println(mx2) //打印结果
	
	    val arr3=(1 to 20).toArray.map(_.toDouble)
	    val mx3 = Matrices.dense(4, 5, arr3) //创建一个分布式矩阵
	    println(mx3) //打印结果
	      println(mx3.index(0,0))
	    println(mx3.index(1,1))
	    println(mx3.index(2,2))
	    println(mx3.numRows)
	    println(mx3.numCols)
	  }
	}
	

```

3.结果：

	```
	1.0  3.0  5.0  
	2.0  4.0  6.0  
	
	1.0  3.0  5.0  
	2.0  4.0  6.0  
	
	1.0  5.0  9.0   13.0  17.0  
	2.0  6.0  10.0  14.0  18.0  
	3.0  7.0  11.0  15.0  19.0  
	4.0  8.0  12.0  16.0  20.0  
	0
	5
	10
	4
	5
```

感觉index有问题：  
源码：

	```
	  /** Return the index for the (i, j)-th element in the backing array. */
	  private[mllib] def index(i: Int, j: Int): Int
	```	

在dense的时候：

	```
	  private[mllib] def index(i: Int, j: Int): Int = {
	    if (!isTransposed) i + numRows * j else j + numCols * i
	  }

```
如果按照这个源码理解没问题
将数组改为：

	```
	val arr3=(21 to 40).toArray.map(_.toDouble)
	```

	```
	21.0  25.0  29.0  33.0  37.0  
	22.0  26.0  30.0  34.0  38.0  
	23.0  27.0  31.0  35.0  39.0  
	24.0  28.0  32.0  36.0  40.0  
	0
	5
	10
	4
	5
	```

疑问：如何按照坐标打印元素？比如（1，1）对应6


参考  
【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html   
【2】http://spark.apache.org/docs/1.5.2/programming-guide.html  
【3】https://github.com/xubo245/SparkLearning  
