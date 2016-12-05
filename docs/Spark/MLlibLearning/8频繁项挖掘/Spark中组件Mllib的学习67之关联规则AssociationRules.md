
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

Association Rules

AssociationRules implements a parallel rule generation algorithm for constructing rules that have a single item as the consequent.


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
	class AssociationRulesFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	    import org.apache.spark.rdd.RDD
	    import org.apache.spark.mllib.fpm.AssociationRules
	    import org.apache.spark.mllib.fpm.FPGrowth.FreqItemset
	
	    val freqItemsets = sc.parallelize(Seq(
	      new FreqItemset(Array("a"), 15L),
	      new FreqItemset(Array("b"), 35L),
	      new FreqItemset(Array("a", "b"), 12L)
	    ));
	
	    val ar = new AssociationRules()
	      .setMinConfidence(0.8)
	    val results = ar.run(freqItemsets)
	
	    results.collect().foreach { rule =>
	      println("[" + rule.antecedent.mkString(",")
	        + "=>"
	        + rule.consequent.mkString(",") + "]," + rule.confidence)
	    }
	  }
	}


3.结果：

	[a=>b],0.8

结果分析：12/15=0.8

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
