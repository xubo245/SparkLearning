	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之分类篇
1 解释
（1） 贝叶斯：  
![这里写图片描述](http://img.blog.csdn.net/20160525100938165)  

推广：  
![这里写图片描述](http://img.blog.csdn.net/20160525100949310)
	
（2）朴素贝叶斯：
	    
为了简化计算，朴素贝叶斯算法做了一假设：“朴素的认为各个特征相互独立”。这么一来，上式的分子就简化成了：
	
	    P(C)*P(F1|C)*P(F2|C)...P(Fn|C)。
	
这样简化过后，计算起来就方便多了。

朴素贝叶斯分类器 naive Bayes有：

	       多项式朴素贝叶斯（ multinomial naive Bayes ）和伯努利朴素贝叶斯（ Bernoulli naive Bayes）
	        要注意的是，MultinomialNB这个分类器以出现次数作为特征值，使用的TF-IDF也能符合这类分布。
	        其他的朴素贝叶斯分类器如GaussianNB适用于高斯分布（正态分布）的特征，而BernoulliNB适用于伯努利分布（二值分布）的特征。
	
贝叶斯理论是处理不确定性信息的重要工具。作为一种不确定性推理方法，它基于概率和统计理论，具有坚实的数学基础，贝叶斯网络在处理不确定信息的智能化系统中已经得到了广泛的应用，并且成功地用于医疗诊断、统计决策、专家系统等领域。这些成功的应用，充分说明了贝叶斯技术是一种强有力的不确定性推理方法。贝叶斯分类器分为两种：一种是朴素贝叶斯分类器，另一种贝叶斯网分类器。
	
朴素贝叶斯分类器是一种有监督的学习方法，其假定一个属性的值对给定类的影响而独立于其他属性值，此限制条件较强，现实中往往不能满足，但是朴素贝叶斯分类器取得了较大的成功，表现出高精度和高效率，具有最小的误分类率，耗时开销小的特征。贝叶斯网分类器是一种有向无环图模型，能够表示属性集间的因果依赖。通过提供图形化的方法来表示知识，以条件概率分布表表示属性依赖关系的强弱，将先验信息和样本知识有机结合起来；通过贝叶斯概率对某一事件未来可能发生的概率进行估计，克服了基于规则的系统所具有的许多概念和计算上的困难。其优点是具有很强的学习和推理能力，能够很好地利用先验知识，缺点是对发生频率较低的事件预测效果不好，且推理与学习过程是NP—Hard的。
	
具体请看参考【4】【5】
	
	
	
2.代码：
	
	```
	/**
	  * @author xubo
	  *         ref:Spark MlLib机器学习实战
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.learning.classification
	
	import java.text.SimpleDateFormat
	import java.util.Date
	
	import org.apache.spark.mllib.classification.{LogisticRegressionModel, NaiveBayes, NaiveBayesModel}
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.mllib.regression.LabeledPoint
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  */
	object NaiveBayesLearning {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	
	    val data = sc.textFile("file/data/mllib/input/classification/sample_naive_bayes_data.txt")
	    val parsedData = data.map { line =>
	      val parts = line.split(',')
	      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
	    }
	    // Split data into training (60%) and test (40%).
	    val splits = parsedData.randomSplit(Array(0.6, 0.4), seed = 11L)
	    val training = splits(0)
	    val test = splits(1)
	
	    val model = NaiveBayes.train(training, lambda = 1.0, modelType = "multinomial")
	
	    val predictionAndLabel = test.map(p => (model.predict(p.features), p.label))
	    val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / test.count()
	
	
	    println("result:")
	    println("training.count:" + training.count())
	    println("test.count:" + test.count())
	    println("model.modelType:" + model.modelType)
	    println("accuracy:" + accuracy)
	    predictionAndLabel.take(10).foreach(println)
	    //    model.
	
	    // Save and load model
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    val path = "file/data/mllib/output/classification/NaiveBayesModel" + iString + "/result"
	    model.save(sc, path)
	    val sameModel = NaiveBayesModel.load(sc, path)
	    println(sameModel.modelType)
	
	    println("end")
	    //    model.save(sc, "myModelPath")
	    //    val sameModel = NaiveBayesModel.load(sc, "myModelPath")
	
	    sc.stop
	  }
	}
	
	```
	
3.结果：
	
	```
	result:
	training.count:10
	test.count:2
	model.modelType:multinomial
	accuracy:1.0
	(1.0,1.0)
	(2.0,2.0)
	SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	SLF4J: Defaulting to no-operation (NOP) logger implementation
	SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	2016-05-24 23:00:45 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
	multinomial
	end
	```
准确率为1
	
	
参考
	
	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://blog.csdn.net/sulliy/article/details/6629201
	【5】http://blog.csdn.net/lsldd/article/details/41542107