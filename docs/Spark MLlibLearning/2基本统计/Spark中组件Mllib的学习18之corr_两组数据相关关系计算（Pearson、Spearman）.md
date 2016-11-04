更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之基础概念篇   
1解释  

（1）皮尔森Pearson  
皮尔森相似度的原始计算公式为：  
 ![这里写图片描述](http://img.blog.csdn.net/20160523211215618)  
书上也有

例子：  
![这里写图片描述](http://img.blog.csdn.net/20160523213633949)
![这里写图片描述](http://img.blog.csdn.net/20160523213648775)

（2） 斯皮尔曼等级相关 Spearman  
![这里写图片描述](http://img.blog.csdn.net/20160523213715901)  
di=xi-yi  
**注意：这里的Xi、Yi是原始数据的等级，也就是排序序号，不是元素数据值**

例子：
![这里写图片描述](http://img.blog.csdn.net/20160523213845497)


2.代码：
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         http://blog.csdn.net/dc_726/article/details/40017997
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  *
	  */
	package org.apache.spark.mllib.learning.basic
	
	import org.apache.spark.mllib.stat.Statistics
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object StatisticsCorrLearning {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    val rddX = sc.textFile("file/data/mllib/input/basic/StatisticsCorrLearningx.txt") //读取数据
	      .flatMap(_.split(' ') //进行分割
	      .map(_.toDouble)) //转化为Double类型
	    val rddY = sc.textFile("file/data/mllib/input/basic/StatisticsCorrLearningy.txt") //读取数据
	        .flatMap(_.split(' ') //进行分割
	        .map(_.toDouble)) //转化为Double类型
	    println("rddX:")
	    rddX.foreach(each => print(each + " "))
	    println("\nrddY:")
	    rddY.foreach(each => print(each + " "))
	    var correlationPearson: Double = Statistics.corr(rddX, rddY) //计算不同数据之间的相关系数:皮尔逊
	    println("\ncorrelationPearson：" + correlationPearson) //打印结果
	
	    var correlationSpearman: Double = Statistics.corr(rddX, rddY, "spearman") //使用斯皮尔曼计算不同数据之间的相关系数
	    println("correlationSpearman：" + correlationSpearman) //打印结果
	
	    //不读取文件直接生成
	    println("\nSecond:")
	    val arr1 = (1 to 10).toArray.map(_.toDouble)
	    val arr2 = (1 to 10).toArray.map(_.toDouble)
	    val rdd1 = sc.parallelize(arr1)
	    val rdd2 = sc.parallelize(arr2)
	    println("rdd1:")
	    rdd1.foreach(each => print(each + " "))
	    println("\nrdd2:")
	    rdd2.foreach(each => print(each + " "))
	    correlationPearson = Statistics.corr(rdd1, rdd2) //计算不同数据之间的相关系数:皮尔逊
	    println("\ncorrelationPearson：" + correlationPearson) //打印结果
	    correlationSpearman = Statistics.corr(rdd1, rdd2, "spearman") //使用斯皮尔曼计算不同数据之间的相关系数
	    println("correlationSpearman：" + correlationSpearman) //打印结果
	
	    println("\nThird:")
	    val arr3 = (1 to 5).toArray.map(_.toDouble)
	    val arr4 = (2 to 10 by 2).toArray.map(_.toDouble)
	    val rdd3 = sc.parallelize(arr3)
	    val rdd4 = sc.parallelize(arr4)
	    println("rdd3:")
	    rdd3.foreach(each => print(each + " "))
	    println("\nrdd4:")
	    rdd4.foreach(each => print(each + " "))
	    val correlationPearson3 = Statistics.corr(rdd3, rdd4) //计算不同数据之间的相关系数:皮尔逊
	    println("\ncorrelationPearson3：" + correlationPearson3) //打印结果
	
	    val correlationSpearman3 = Statistics.corr(rdd3, rdd4, "spearman") //使用斯皮尔曼计算不同数据之间的相关系数
	    println("correlationSpearman3：" + correlationSpearman3) //打印结果
	
	    println("\nFourth:")
	    val rdd5 = sc.parallelize(Array(5.0, 3.0, 2.5))
	    val rdd6 = sc.parallelize(Array(4.0, 3.0, 2.0))
	    println("rdd5:")
	    rdd5.foreach(each => print(each + " "))
	    println("\nrdd6:")
	    rdd6.foreach(each => print(each + " "))
	    val correlationPearson5 = Statistics.corr(rdd5, rdd6) //计算不同数据之间的相关系数:皮尔逊
	    println("\ncorrelationPearson5：" + correlationPearson5) //打印结果
	    //与链接和书计算结果一致：http://blog.csdn.net/dc_726/article/details/40017997 书：ref
	
	    val correlationSpearman5 = Statistics.corr(rdd5, rdd6, "spearman") //使用斯皮尔曼计算不同数据之间的相关系数
	    println("correlationSpearman5：" + correlationSpearman5) //打印结果
	
	    println("\nFifth:")
	    val rdd7 = sc.parallelize(Array(170.0, 150.0, 210.0,180.0,160.0))
	    val rdd8 = sc.parallelize(Array(180.0, 165.0, 190.0,168.0,172.0))
	    println("rdd:")
	    rdd7.foreach(each => print(each + " "))
	    println("\nrdd:")
	    rdd8.foreach(each => print(each + " "))
	    val correlationPearson7 = Statistics.corr(rdd7, rdd8) //计算不同数据之间的相关系数:皮尔逊
	    println("\ncorrelationPearson：" + correlationPearson7) //打印结果
	    //与链接和书计算结果一致：http://baike.baidu.com/link?url=s9aiihE4mMpF2sZLqR33JKz3FNk8R8IWWh9-ZgNFO4aZB5ez9mnADNQZQSApniWXUJGwhr-Ar9mjWEFVwncQlq书：ref
	
	    val correlationSpearman7 = Statistics.corr(rdd7, rdd8, "spearman") //使用斯皮尔曼计算不同数据之间的相关系数
	    println("correlationSpearman：" + correlationSpearman7) //打印结果
	
	
	    sc.stop
	  }
	}
	
	```

文件在github

3.结果：
	
	```
	rddX:
	2016-05-23 21:25:10 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:482:722f:5976:ce1f%20, but we couldn't find any external IP address!
	1.0 6.0 7.0 8.0 9.0 10.0 2.0 3.0 4.0 5.0 
	rddY:
	6.0 7.0 8.0 9.0 10.0 1.0 2.0 3.0 4.0 5.0 2016-05-23 21:25:12 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
	2016-05-23 21:25:12 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
	
	correlationPearson：1.0
	correlationSpearman：1.0000000000000009
	
	Second:
	rdd1:
	3.0 4.0 5.0 1.0 2.0 8.0 9.0 10.0 6.0 7.0 
	rdd2:
	1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 10.0 
	correlationPearson：1.0
	correlationSpearman：1.0000000000000009
	
	Third:
	rdd3:
	3.0 4.0 5.0 2.0 1.0 
	rdd4:
	4.0 2.0 6.0 8.0 10.0 
	correlationPearson3：0.9999999999999998
	correlationSpearman3：0.9999999999999998
	
	Fourth:
	rdd5:
	3.0 5.0 2.5 
	rdd6:
	4.0 3.0 2.0 
	correlationPearson5：0.944911182523068
	correlationSpearman5：1.0
	
	Fifth:
	rdd:
	150.0 180.0 160.0 210.0 170.0 
	rdd:
	165.0 190.0 180.0 168.0 172.0 
	correlationPearson：0.8171759569273293
	correlationSpearman：0.6999999999999998
	
	```

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://blog.csdn.net/dc_726/article/details/40017997
	【5】http://baike.baidu.com/link?url=s9aiihE4mMpF2sZLqR33JKz3FNk8R8IWWh9-ZgNFO4aZB5ez9mnADNQZQSApniWXUJGwhr-Ar9mjWEFVwncQlq
