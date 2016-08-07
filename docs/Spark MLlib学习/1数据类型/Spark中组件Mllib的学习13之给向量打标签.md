更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之基础概念篇  
1解释  
给数据打label，用于后续监督学习等  

2.代码：  
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.basic
	
	import org.apache.spark.mllib.util.MLUtils
	import org.apache.spark.{SparkConf, SparkContext}
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.mllib.regression.LabeledPoint
	
	/**
	  * Created by xubo on 2016/5/23.
	  * 给Vector打Label
	  */
	object LabeledPointLearning {
	  def main(args: Array[String]) {
	
	    val vd = Vectors.dense(2, 0, 6)
	    val pos = LabeledPoint(1, vd) //对密集向量建立标记点
	    println(pos.features)
	    println(pos.label)
	    println(pos)
	
	    val vs = Vectors.sparse(4, Array(0, 1, 2, 3), Array(9, 5, 2, 7))
	    val neg = LabeledPoint(2, vs) //对稀疏向量建立标记点
	    println(neg.features)
	    println(neg.label)
	    println(neg)
	
	
	  }
	}
	
	```

3.结果：
	
	```
	[2.0,0.0,6.0]
	1.0
	(1.0,[2.0,0.0,6.0])
	(4,[0,1,2,3],[9.0,5.0,2.0,7.0])
	2.0
	(2.0,(4,[0,1,2,3],[9.0,5.0,2.0,7.0]))
	
	```

参考  
【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html   
【2】http://spark.apache.org/docs/1.5.2/programming-guide.html  
【3】https://github.com/xubo245/SparkLearning  
