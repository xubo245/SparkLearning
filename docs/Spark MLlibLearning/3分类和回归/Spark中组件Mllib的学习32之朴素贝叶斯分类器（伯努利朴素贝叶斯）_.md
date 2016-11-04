	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之分类篇
1解释

（1） 朴素贝叶斯分类器种类
	
在把训练集中的每个文档向量化的过程中，存在两个模型。一个是统计词在文档中出现的次数（多项式模型）;一个是统计词是否在文档中出现过（柏努利模型）  
目前mllib只支持多项式朴素贝叶斯和伯努利贝叶斯（spark-1.5.2）,不支持高斯朴素贝叶斯。
      
根据：

	```
	/**
	 * Trains a Naive Bayes model given an RDD of `(label, features)` pairs.
	 *
	 * This is the Multinomial NB ([[http://tinyurl.com/lsdw6p]]) which can handle all kinds of
	 * discrete data.  For example, by converting documents into TF-IDF vectors, it can be used for
	 * document classification.  By making every vector a 0-1 vector, it can also be used as
	 * Bernoulli NB ([[http://tinyurl.com/p7c96j6]]). The input feature values must be nonnegative.
	 */
	@Since("0.9.0")
	class NaiveBayes private (
	    private var lambda: Double,
	    private var modelType: String) extends Serializable with Logging {
	
	  import NaiveBayes.{Bernoulli, Multinomial}
	
	  @Since("1.4.0")
	  def this(lambda: Double) = this(lambda, NaiveBayes.Multinomial)
	
	```

三种朴素贝叶斯分类器都在【4】中有提到
	
（2）伯努利贝叶斯分类器
	![这里写图片描述](http://img.blog.csdn.net/20160525103109299)
	参考【5】
	
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
	
	import org.apache.spark.mllib.classification.NaiveBayes._
	import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.mllib.regression.LabeledPoint
	import org.apache.spark.{SparkException, SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/5/23.
	  * From:NaiveBayesSuite.scala in spark 1.5.2 sources
	  * another examples:NaiveBayesSuite  test("Naive Bayes Bernoulli")
	  */
	object BernoulliNaiveBayesLearning {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    val sc = new SparkContext(conf)
	
	    val badTrain = Seq(
	      LabeledPoint(1.0, Vectors.dense(1.0)),
	      //      LabeledPoint(0.0, Vectors.dense(2.0)),
	      LabeledPoint(1.0, Vectors.dense(1.0)),
	      LabeledPoint(1.0, Vectors.dense(0.0)))
	
	
	    val model1 = NaiveBayes.train(sc.makeRDD(badTrain, 2), 1.0, Bernoulli)
	    println("model1:")
	    println(model1)
	    sc.makeRDD(badTrain, 2).foreach(println)
	
	    val okTrain = Seq(
	      LabeledPoint(1.0, Vectors.dense(1.0)),
	      LabeledPoint(0.0, Vectors.dense(0.0)),
	      LabeledPoint(1.0, Vectors.dense(1.0)),
	      LabeledPoint(1.0, Vectors.dense(1.0)),
	      LabeledPoint(0.0, Vectors.dense(0.0)),
	      LabeledPoint(1.0, Vectors.dense(1.0)),
	      LabeledPoint(1.0, Vectors.dense(1.0))
	    )
	
	    val badPredict = Seq(
	      Vectors.dense(1.0),
	      //      Vectors.dense(2.0),
	      Vectors.dense(1.0),
	      Vectors.dense(0.0))
	
	    val model = NaiveBayes.train(sc.makeRDD(okTrain, 2), 1.0, Bernoulli)
	    //    intercept[SparkException] {
	    val pre2 = model.predict(sc.makeRDD(badPredict, 2)).collect()
	    //    }
	    println("model2:")
	    sc.makeRDD(okTrain, 2).foreach(println)
	    println("predict data:")
	    sc.makeRDD(badPredict, 2).foreach(println)
	    println(model)
	    println("predict result:")
	    pre2.foreach(println)
	
	    sc.stop
	  }
	}
	
	```
	
3.结果：
	
	```
	model1:
	org.apache.spark.mllib.classification.NaiveBayesModel@79d63340
	(1.0,[1.0])
	(1.0,[1.0])
	(1.0,[0.0])
	model2:
	(1.0,[1.0])
	(0.0,[0.0])
	(1.0,[1.0])
	(1.0,[1.0])
	(0.0,[0.0])
	(1.0,[1.0])
	(1.0,[1.0])
	predict data:
	[1.0]
	[0.0]
	[1.0]
	org.apache.spark.mllib.classification.NaiveBayesModel@3eda0bed
	predict result:
	1.0
	1.0
	0.0
	```
	
参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://www.letiantian.me/2014-10-12-three-models-of-naive-nayes/
	【5】http://blog.csdn.net/xlinsist/article/details/51264829