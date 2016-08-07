更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之基础概念篇  
1解释  
mllib生成Vector  

2.代码：
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.basic
	
	import org.apache.spark.mllib.linalg.Vectors
	
	/**
	  * Created by xubo on 2016/5/23.
	  * Vector
	  */
	object VectorLearning {
	  def main(args: Array[String]) {
	
	    val vd = Vectors.dense(2, 0, 6)
	    println(vd(2))
	    println(vd)
	
	    //数据个数，序号，value
	    val vs = Vectors.sparse(4, Array(0, 1, 2, 3), Array(9, 5, 2, 7))
	    println(vs(2))
	    println(vs)
	
	    val vs2 = Vectors.sparse(4, Array(0, 2, 1, 3), Array(9, 5, 2, 7))
	    println(vs2(2))
	    println(vs2)
	
	
	  }
	}
	
	```

3.结果：
	
	```
	6.0
	[2.0,0.0,6.0]
	2.0
	(4,[0,1,2,3],[9.0,5.0,2.0,7.0])
	5.0
	(4,[0,2,1,3],[9.0,5.0,2.0,7.0])
	```

参考  
【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html   
【2】http://spark.apache.org/docs/1.5.2/programming-guide.html  
【3】https://github.com/xubo245/SparkLearning  
