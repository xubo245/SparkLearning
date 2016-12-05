更多代码请见：https://github.com/xubo245/SparkLearning  
Spark中组件Mllib的学习之基础概念篇   
1解释  
在org.apache.spark.mllib.random下RandomRDDs对象，处理生成RandomRDD，还可以生成uniformRDD、poissonRDD、exponentialRDD、gammaRDD等  


2.代码：  
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.basic
	
	import org.apache.spark.mllib.random.RandomRDDs._
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object RandomRDDLearning {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	    println("normalRDD:")
	    val randomNum = normalRDD(sc, 10)
	    randomNum.foreach(println)
	    println("uniformRDD:")
	    uniformRDD(sc, 10).foreach(println)
	    println("poissonRDD:")
	    poissonRDD(sc, 5,10).foreach(println)
	    println("exponentialRDD:")
	    exponentialRDD(sc,7, 10).foreach(println)
	    println("gammaRDD:")
	    gammaRDD(sc, 3,3,10).foreach(println)
	    sc.stop
	  }
	}
	
	```

3.结果：

	```
	normalRDD:
	0.19139342057444655
	0.42847625833602926
	0.432676150766411
	2.031243580737701
	-1.6210366564577097
	-0.5736390968158938
	0.5118950917391826
	0.36612870444413614
	-0.7841387585110905
	0.11439913262616007
	uniformRDD:
	0.2438450552072624
	0.7003522704053741
	0.24235558263747725
	0.49701950142885765
	0.46652368533423283
	0.980827677073354
	0.6825558070196546
	0.4817949839139517
	0.9965017651788755
	0.7568845648015728
	poissonRDD:
	2.0
	2.0
	4.0
	6.0
	4.0
	2.0
	4.0
	2.0
	3.0
	9.0
	exponentialRDD:
	12.214082193307469
	4.682554578220504
	0.9758739534780947
	1.0228072708547165
	5.844697536923258
	1.11718191688843
	18.3001169404778
	3.0254219574726964
	1.9807047388403134
	7.218371820752084
	gammaRDD:
	15.362945490679401
	12.508341430761691
	6.284582685039609
	2.731284321611819
	19.032454731810525
	14.508395124068773
	8.684880785422951
	3.5329956660355206
	15.852625148469828
	4.284198644233831
		
```

参考  
【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html   
【2】http://spark.apache.org/docs/1.5.2/programming-guide.html  
【3】https://github.com/xubo245/SparkLearning