
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

　　元素智能乘积

  ElementwiseProduct对每一个输入向量乘以一个给定的“权重”向量。换句话说，就是通过一个乘子对数据集的每一列进行缩放。这个转换可以表示为如下的形式：

![](http://i.imgur.com/d6lY7G0.png)

2.代码：
	
	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.FeatureExtractionAndTransformation
	
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class ElementwiseProductFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	
	    import org.apache.spark.SparkContext._
	    import org.apache.spark.mllib.feature.ElementwiseProduct
	    import org.apache.spark.mllib.linalg.Vectors
	
	    // Create some vector data; also works for sparse vectors
	    val data = sc.parallelize(Array(Vectors.dense(1.0, 2.0, 3.0), Vectors.dense(4.0, 5.0, 6.0)))
	
	    val transformingVector = Vectors.dense(0.0, 1.0, 2.0)
	    val transformer = new ElementwiseProduct(transformingVector)
	
	    // Batch transform and per-row transform give the same results:
	    val transformedData = transformer.transform(data)
	    val transformedData2 = data.map(x => transformer.transform(x))
	
	    println("data:")
	    data.foreach(println)
	    println("transformer:" + transformer.scalingVec)
	
	    //    transformer.foreach(println)
	    println("transformedData:")
	    transformedData.foreach(println)
	
	  }
	}


3.结果：

	data:
	[1.0,2.0,3.0]
	[4.0,5.0,6.0]
	transformer:[0.0,1.0,2.0]
	transformedData:
	[0.0,5.0,12.0]
	[0.0,2.0,6.0]


参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
