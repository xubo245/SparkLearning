
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

PrefixSpan 是一种序列模式挖掘算法

序列模式定义：给定一个由不同序列组成的集合，其中，每个序列由不同的元素按顺序有序排列，每个元素由不同项目组成，同时给定一个用户指定的最小支持度阈值，序列模式挖掘就是找出所有的频繁子序列，即该子序列在序列集中的出现频率不低于用户指定的最小支持度阈值

Spak.mllib PrefixSpan 需要配置以下参数

1) minSupport : 满足频度序列模式的最小支持度

2) maxPatternLength: 频度序列的最大长度。凡是超过此长度的频度序列都会被乎略。

3) maxLocalProjDBSize:本地迭代处理投影数据库(projected database)之前，需要满足前缀投影数据库(prefix-projecteddatabase)中最大的物品数。

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
	class PrefixSpanFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	    import org.apache.spark.mllib.fpm.PrefixSpan
	
	    val sequences = sc.parallelize(Seq(
	      Array(Array(1, 2), Array(3)),
	      Array(Array(1), Array(3, 2), Array(1, 2)),
	      Array(Array(1, 2), Array(5)),
	      Array(Array(6))
	    ), 2).cache()
	    val prefixSpan = new PrefixSpan()
	      .setMinSupport(0.5)
	      .setMaxPatternLength(5)
	    val model = prefixSpan.run(sequences)
	    model.freqSequences.collect().foreach { freqSequence =>
	      println(
	        freqSequence.sequence.map(_.mkString("[", ", ", "]")).mkString("[", ", ", "]") + ", " + freqSequence.freq)
	    }
	  }
	}


3.结果：

	[[2]], 3
	[[3]], 2
	[[1]], 3
	[[2, 1]], 3
	[[1], [3]], 2

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
	【6】http://www.jone.tech/?p=41
