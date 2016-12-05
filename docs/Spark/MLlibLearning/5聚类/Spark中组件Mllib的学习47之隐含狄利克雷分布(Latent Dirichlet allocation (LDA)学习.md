
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

隐含狄利克雷分布(Latent Dirichlet allocation (LDA)

隐含狄利克雷分布(LDA) 是一个主题模型，它能够推理出一个文本文档集合的主体。LDA可以认为是一个聚类算法，原因如下：

    主题对应聚类中心，文档对应数据集中的样本（数据行）
    主题和文档都在一个特征空间中，其特征向量是词频向量。
    跟使用传统的距离来评估聚类不一样的是，LDA使用评估方式是一个函数，该函数基于文档如何生成的统计模型。

LDA以词频向量表示的文档集合作为输入。然后在最大似然函数上使用期望最大（EM）算法 来学习聚类。完成文档拟合之后，LDA提供：

    Topics: 推断出的主题，每个主体是单词上的概率分布。
    Topic distributions for documents: 对训练集中的每个文档，LDA给了一个在主题上的概率分布。

LDA参数如下：

    k:  主题数量（或者说聚簇中心数量）
    maxIterations: EM算法的最大迭代次数。
    docConcentration: 文档在主题上分布的先验参数。当前必须大于1，值越大，推断出的分布越平滑。
    topicConcentration: 主题在单词上的先验分布参数。当前必须大于1，值越大，推断出的分布越平滑。
    checkpointInterval: 检查点间隔。maxIterations很大的时候，检查点可以帮助减少shuffle文件大小并且可以帮助故障恢复。

参考【4】

2.代码：
	
	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.clustering.LDALearning
	
	import org.apache.spark.mllib.clustering.LDA
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class LDAFromWebSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	
	    import org.apache.spark.mllib.linalg.Vectors
	
	    // Load and parse the data
	    val data = sc.textFile("file/data/mllib/input/mllibFromSpark/sample_lda_data.txt")
	    val parsedData = data.map(s => Vectors.dense(s.trim.split(' ').map(_.toDouble)))
	    // Index documents with unique IDs
	    val corpus = parsedData.zipWithIndex.map(_.swap).cache()
	
	    // Cluster the documents into three topics using LDA
	    val ldaModel = new LDA().setK(3).run(corpus)
	
	    //input data
	    println("parsedData:")
	    parsedData.foreach(println)
	    println("corpus:")
	    corpus.foreach(println)
	
	    // Output topics. Each is a distribution over words (matching word count vectors)
	    println("Learned topics (as distributions over vocab of " + ldaModel.vocabSize + " words):")
	    val topics = ldaModel.topicsMatrix
	    for (topic <- Range(0, 3)) {
	      print("Topic " + topic + ":")
	      for (word <- Range(0, ldaModel.vocabSize)) {
	        print(" " + topics(word, topic));
	      }
	      println()
	    }
	
	    // Save and load model.
	    //    ldaModel.save(sc, "myLDAModel")
	    //    val sameModel = DistributedLDAModel.load(sc, "myLDAModel")
	
	
	  }
	}

数据：

	1 2 6 0 2 3 1 1 0 0 3
	1 3 0 1 3 0 0 2 0 0 1
	1 4 1 0 0 4 9 0 1 2 0
	2 1 0 3 0 0 5 0 2 3 9
	3 1 1 9 3 0 2 0 0 1 3
	4 2 0 3 4 5 1 1 1 4 0
	2 1 0 3 0 0 5 0 2 2 9
	1 1 1 9 2 1 2 0 0 1 3
	4 4 0 3 4 2 1 3 0 0 0
	2 8 2 0 3 0 2 0 2 7 2
	1 1 1 9 0 2 2 0 0 3 3
	4 1 0 0 4 5 1 3 0 1 0


3.结果：
	
	parsedData:
	[1.0,1.0,1.0,9.0,2.0,1.0,2.0,0.0,0.0,1.0,3.0]
	[1.0,2.0,6.0,0.0,2.0,3.0,1.0,1.0,0.0,0.0,3.0]
	[4.0,4.0,0.0,3.0,4.0,2.0,1.0,3.0,0.0,0.0,0.0]
	[1.0,3.0,0.0,1.0,3.0,0.0,0.0,2.0,0.0,0.0,1.0]
	[2.0,8.0,2.0,0.0,3.0,0.0,2.0,0.0,2.0,7.0,2.0]
	[1.0,4.0,1.0,0.0,0.0,4.0,9.0,0.0,1.0,2.0,0.0]
	[1.0,1.0,1.0,9.0,0.0,2.0,2.0,0.0,0.0,3.0,3.0]
	[2.0,1.0,0.0,3.0,0.0,0.0,5.0,0.0,2.0,3.0,9.0]
	[4.0,1.0,0.0,0.0,4.0,5.0,1.0,3.0,0.0,1.0,0.0]
	[3.0,1.0,1.0,9.0,3.0,0.0,2.0,0.0,0.0,1.0,3.0]
	[4.0,2.0,0.0,3.0,4.0,5.0,1.0,1.0,1.0,4.0,0.0]
	[2.0,1.0,0.0,3.0,0.0,0.0,5.0,0.0,2.0,2.0,9.0]
	corpus:
	(7,[1.0,1.0,1.0,9.0,2.0,1.0,2.0,0.0,0.0,1.0,3.0])
	(8,[4.0,4.0,0.0,3.0,4.0,2.0,1.0,3.0,0.0,0.0,0.0])
	(9,[2.0,8.0,2.0,0.0,3.0,0.0,2.0,0.0,2.0,7.0,2.0])
	(0,[1.0,2.0,6.0,0.0,2.0,3.0,1.0,1.0,0.0,0.0,3.0])
	(10,[1.0,1.0,1.0,9.0,0.0,2.0,2.0,0.0,0.0,3.0,3.0])
	(1,[1.0,3.0,0.0,1.0,3.0,0.0,0.0,2.0,0.0,0.0,1.0])
	(11,[4.0,1.0,0.0,0.0,4.0,5.0,1.0,3.0,0.0,1.0,0.0])
	(2,[1.0,4.0,1.0,0.0,0.0,4.0,9.0,0.0,1.0,2.0,0.0])
	(3,[2.0,1.0,0.0,3.0,0.0,0.0,5.0,0.0,2.0,3.0,9.0])
	(4,[3.0,1.0,1.0,9.0,3.0,0.0,2.0,0.0,0.0,1.0,3.0])
	(5,[4.0,2.0,0.0,3.0,4.0,5.0,1.0,1.0,1.0,4.0,0.0])
	(6,[2.0,1.0,0.0,3.0,0.0,0.0,5.0,0.0,2.0,2.0,9.0])
	Learned topics (as distributions over vocab of 11 words):
	Topic 0: 10.452679685126427 10.181668875779492 2.558644879228586 3.851438041310386 9.929534544713832 11.940154625598604 14.086100675895626 4.8961707413781115 2.2995952755592106 7.381361487130488 8.981150231959049
	Topic 1: 10.279220142758316 5.956661018866242 4.910211518699095 30.538789151743963 5.928882165794898 5.447495432535608 6.549479250479619 3.011959583638183 1.0753194351327675 3.217481558556803 9.62611924184504
	Topic 2: 5.268100172115256 12.861670105354264 4.531143602072319 5.6097728069456565 9.141583289491269 4.612349941865787 10.364420073624755 2.0918696749837067 4.625085289308021 13.40115695431271 14.392730526195912
	


参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://www.fuqingchuan.com/2015/03/609.html#latent-dirichlet-allocation-lda