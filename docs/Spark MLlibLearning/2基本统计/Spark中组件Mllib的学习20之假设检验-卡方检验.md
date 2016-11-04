更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之基础概念篇   
1解释  
分别对Vector和Matrix进行卡方检验  


2.代码：
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.basic
	
	import org.apache.spark.mllib.linalg.{Matrices, Vectors}
	import org.apache.spark.mllib.stat.Statistics
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object ChiSqLearning {
	  def main(args: Array[String]) {
	    val vd = Vectors.dense(1, 2, 3, 4, 5)
	    val vdResult = Statistics.chiSqTest(vd)
	    println(vdResult)
	    println("-------------------------------")
	    val mtx = Matrices.dense(3, 2, Array(1, 3, 5, 2, 4, 6))
	    val mtxResult = Statistics.chiSqTest(mtx)
	    println(mtxResult)
	    //print :方法、自由度、方法的统计量、p值
	  }
	}
	
	```

3.结果：
	
	```
	Chi squared test summary:
	method: pearson
	degrees of freedom = 4 
	statistic = 3.333333333333333 
	pValue = 0.5036682742334986 
	No presumption against null hypothesis: observed follows the same distribution as expected..
	-------------------------------
	Chi squared test summary:
	method: pearson
	degrees of freedom = 2 
	statistic = 0.14141414141414144 
	pValue = 0.931734784568187 
	No presumption against null hypothesis: the occurrence of the outcomes is statistically independent..
	```

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning