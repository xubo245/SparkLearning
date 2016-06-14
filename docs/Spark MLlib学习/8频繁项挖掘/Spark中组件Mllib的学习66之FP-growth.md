
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

FP-growth是数据挖掘里面很常见的一个算法


2.代码：
	
	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.FrequentPatternMining
	
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class FPgroupFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	    import org.apache.spark.rdd.RDD
	    import org.apache.spark.mllib.fpm.FPGrowth
	
	    val data = sc.textFile("file/data/mllib/input/mllibFromSpark/sample_fpgrowth.txt")
	
	    val transactions: RDD[Array[String]] = data.map(s => s.trim.split(' '))
	
	    val fpg = new FPGrowth()
	      .setMinSupport(0.2)
	      .setNumPartitions(10)
	    val model = fpg.run(transactions)
	
	    model.freqItemsets.collect().foreach { itemset =>
	      println(itemset.items.mkString("[", ",", "]") + ", " + itemset.freq)
	    }
	
	    val minConfidence = 0.8
	    model.generateAssociationRules(minConfidence).collect().foreach { rule =>
	      println(
	        rule.antecedent.mkString("[", ",", "]")
	          + " => " + rule.consequent.mkString("[", ",", "]")
	          + ", " + rule.confidence)
	    }
	  }
	}


3.结果：

	[z], 5
	[x], 4
	[x,z], 3
	[y], 3
	[y,x], 3
	[y,x,z], 3
	[y,z], 3
	[r], 3
	[r,x], 2
	[r,z], 2
	[s], 3
	[s,y], 2
	[s,y,x], 2
	[s,y,x,z], 2
	[s,y,z], 2
	[s,x], 3
	[s,x,z], 2
	[s,z], 2
	[t], 3
	[t,y], 3
	[t,y,x], 3
	[t,y,x,z], 3
	[t,y,z], 3
	[t,s], 2
	[t,s,y], 2
	[t,s,y,x], 2
	[t,s,y,x,z], 2
	[t,s,y,z], 2
	[t,s,x], 2
	[t,s,x,z], 2
	[t,s,z], 2
	[t,x], 3
	[t,x,z], 3
	[t,z], 3
	[p], 2
	[p,r], 2
	[p,r,z], 2
	[p,z], 2
	[q], 2
	[q,y], 2
	[q,y,x], 2
	[q,y,x,z], 2
	[q,y,z], 2
	[q,t], 2
	[q,t,y], 2
	[q,t,y,x], 2
	[q,t,y,x,z], 2
	[q,t,y,z], 2
	[q,t,x], 2
	[q,t,x,z], 2
	[q,t,z], 2
	[q,x], 2
	[q,x,z], 2
	[q,z], 2
	[t,s,y] => [x], 1.0
	[t,s,y] => [z], 1.0
	[y,x,z] => [t], 1.0
	[y] => [x], 1.0
	[y] => [z], 1.0
	[y] => [t], 1.0
	[p] => [r], 1.0
	[p] => [z], 1.0
	[q,t,z] => [y], 1.0
	[q,t,z] => [x], 1.0
	[q,y] => [x], 1.0
	[q,y] => [z], 1.0
	[q,y] => [t], 1.0
	[t,s,x] => [y], 1.0
	[t,s,x] => [z], 1.0
	[q,t,y,z] => [x], 1.0
	[q,t,x,z] => [y], 1.0
	[q,x] => [y], 1.0
	[q,x] => [t], 1.0
	[q,x] => [z], 1.0
	[t,x,z] => [y], 1.0
	[x,z] => [y], 1.0
	[x,z] => [t], 1.0
	[p,z] => [r], 1.0
	[t] => [y], 1.0
	[t] => [x], 1.0
	[t] => [z], 1.0
	[y,z] => [x], 1.0
	[y,z] => [t], 1.0
	[p,r] => [z], 1.0
	[t,s] => [y], 1.0
	[t,s] => [x], 1.0
	[t,s] => [z], 1.0
	[q,z] => [y], 1.0
	[q,z] => [t], 1.0
	[q,z] => [x], 1.0
	[q,y,z] => [x], 1.0
	[q,y,z] => [t], 1.0
	[y,x] => [z], 1.0
	[y,x] => [t], 1.0
	[q,x,z] => [y], 1.0
	[q,x,z] => [t], 1.0
	[t,y,z] => [x], 1.0
	[q,y,x] => [z], 1.0
	[q,y,x] => [t], 1.0
	[q,t,y,x] => [z], 1.0
	[t,s,x,z] => [y], 1.0
	[s,y,x] => [z], 1.0
	[s,y,x] => [t], 1.0
	[s,x,z] => [y], 1.0
	[s,x,z] => [t], 1.0
	[q,y,x,z] => [t], 1.0
	[s,y] => [x], 1.0
	[s,y] => [z], 1.0
	[s,y] => [t], 1.0
	[q,t,y] => [x], 1.0
	[q,t,y] => [z], 1.0
	[t,y] => [x], 1.0
	[t,y] => [z], 1.0
	[t,z] => [y], 1.0
	[t,z] => [x], 1.0
	[t,s,y,x] => [z], 1.0
	[t,y,x] => [z], 1.0
	[q,t] => [y], 1.0
	[q,t] => [x], 1.0
	[q,t] => [z], 1.0
	[q] => [y], 1.0
	[q] => [t], 1.0
	[q] => [x], 1.0
	[q] => [z], 1.0
	[t,s,z] => [y], 1.0
	[t,s,z] => [x], 1.0
	[t,x] => [y], 1.0
	[t,x] => [z], 1.0
	[s,z] => [y], 1.0
	[s,z] => [x], 1.0
	[s,z] => [t], 1.0
	[s,y,x,z] => [t], 1.0
	[s] => [x], 1.0
	[t,s,y,z] => [x], 1.0
	[s,y,z] => [x], 1.0
	[s,y,z] => [t], 1.0
	[q,t,x] => [y], 1.0
	[q,t,x] => [z], 1.0
	[r,z] => [p], 1.0
	
	

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
