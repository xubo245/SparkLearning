	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之逻辑回归篇 
1解释  
	什么是逻辑回归？
	
Logistic回归与多重线性回归实际上有很多相同之处，最大的区别就在于它们的因变量不同，其他的基本都差不多。正是因为如此，这两种回归可以归于同一个家族，即广义线性模型（generalizedlinear model）。
	
这一家族中的模型形式基本上都差不多，不同的就是因变量不同。  
	    如果是连续的，就是多重线性回归；  
	    如果是二项分布，就是Logistic回归；  
	    如果是Poisson分布，就是Poisson回归；  
	    如果是负二项分布，就是负二项回归。  
	
Logistic回归的因变量可以是二分类的，也可以是多分类的，但是二分类的更为常用，也更加容易解释。所以实际中最常用的就是二分类的Logistic回归。
	
Logistic回归的主要用途：
	
寻找危险因素：寻找某一疾病的危险因素等；  
	    预测：根据模型，预测在不同的自变量情况下，发生某病或某种情况的概率有多大；  
	    判别：实际上跟预测有些类似，也是根据模型，判断某人属于某病或属于某种情况的概率有多大，也就是看一下这个人有多大的可能性是属于某病。  
	
更多请见参考【4】，【4】中还有推理、迭代更新和求解过程，正则化也有
	
逻辑回归：  
	![这里写图片描述](http://img.blog.csdn.net/20160524215642836)
	
2.代码：
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.regression
	
	import org.apache.spark.mllib.classification.LogisticRegressionWithSGD
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.mllib.regression.LabeledPoint
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  * 一元逻辑回归
	  */
	object LogisticRegressionLearning {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    val data = sc.textFile("file/data/mllib/input/regression/logisticRegression1.data") //获取数据集路径
	    val parsedData = data.map { line => //开始对数据集处理
	        val parts = line.split('|') //根据逗号进行分区
	        LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
	      }.cache() //转化数据格式
	    parsedData.foreach(println)
	    val model = LogisticRegressionWithSGD.train(parsedData, 50) //建立模型
	    val target = Vectors.dense(-1) //创建测试值
	    val resulet = model.predict(target) //根据模型计算结果
	    println("model.weights:")
	    println(model.weights)
	    println(resulet) //打印结果
	    println(model.predict(Vectors.dense(10)))
	    sc.stop
	  }
	}
	
	```
	
数据：
	
	```
	1|2
	1|3
	1|4
	1|5
	1|6
	0|7
	0|8
	0|9
	0|10
	0|11
	```
	
3.结果：
	
	```
	2016-05-24 21:59:06 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:482:722f:5976:ce1f%20, but we couldn't find any external IP address!
	(0.0,[8.0])
	(1.0,[2.0])
	(0.0,[9.0])
	(1.0,[3.0])
	(0.0,[10.0])
	(1.0,[4.0])
	(0.0,[11.0])
	(1.0,[5.0])
	(1.0,[6.0])
	(0.0,[7.0])
	2016-05-24 21:59:07 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
	2016-05-24 21:59:07 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
	model.weights:
	[-0.10590621151462867]
	1.0
	0.0
	```
	
参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://blog.csdn.net/pakko/article/details/37878837