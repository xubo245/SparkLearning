更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之基础概念篇  
1解释  
colStats:以列为基础计算统计量的基本数据

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
	import org.apache.spark.mllib.stat.Statistics
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object StatisticsColStatsLearning {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	    //    val rdd = sc.textFile("file/data/mllib/input/basic/MatrixRow.txt") //读取文件
	    val rdd = sc.textFile("file/data/mllib/input/basic/stats.txt") //读取文件
	      .map(_.split(' ') //按“ ”分割
	      .map(_.toDouble)) //转成Double类型
	      .map(line => Vectors.dense(line))
	    val summary = Statistics.colStats(rdd) //获取Statistics实例
	
	    //    rdd.foreach(each => print(each + " "))
	    rdd.foreach(println)
	    println("rdd.count:" + rdd.count())
	    println()
	    println(summary)
	    println(summary.max) //最大
	    println(summary.min) //最小
	    println("count" + summary.count) //个数
	    println(summary.numNonzeros) //非零
	    println("variance:" + summary.variance) //方差
	    println(summary.mean) //计算均值
	    println(summary.variance) //计算标准差
	    println(summary.normL1) //计算曼哈段距离:相加
	    println(summary.normL2) //计算欧几里得距离：平方根
	
	
	    //    /行向量
	    println("\n row Vector:")
	    val vec = Vectors.dense(1, 2, 3, 4, 5)
	    println(vec)
	    println(vec.size)
	    println(vec.numActives)
	    //    println(vec.variance)//不存在
	
	    sc.stop
	  }
	}
	
	```

3.结果：
	
	```
	[1.0]
	[2.0]
	[3.0]
	[4.0]
	[5.0]
	rdd.count:5
	
	org.apache.spark.mllib.stat.MultivariateOnlineSummarizer@7f9de19a
	[5.0]
	[1.0]
	count5
	[5.0]
	variance:[2.5]
	[3.0]
	[2.5]
	[15.0]
	[7.416198487095663]
	
	 row Vector:
	[1.0,2.0,3.0,4.0,5.0]
	5
	5
	```

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
