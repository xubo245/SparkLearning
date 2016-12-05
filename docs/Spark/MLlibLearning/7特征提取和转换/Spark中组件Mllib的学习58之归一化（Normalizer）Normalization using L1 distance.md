
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

  规则化器缩放单个样本让其拥有单位范数。这是文本分类和聚类常用的操作。例如，两个规则化的TFIDF向量的点乘就是两个向量的cosine相似度。

  Normalizer实现VectorTransformer，将一个向量规则化为转换的向量，或者将一个RDD规则化为另一个RDD。下面是一个规则化的例子。

Normalization using L1 distance ,来自spark mllib 的test

  

2.代码：

	 val data = Array(
	    Vectors.sparse(3, Seq((0, -2.0), (1, 2.3))),
	    Vectors.dense(0.0, 0.0, 0.0),
	    Vectors.dense(0.6, -1.1, -3.0),
	    Vectors.sparse(3, Seq((1, 0.91), (2, 3.2))),
	    Vectors.sparse(3, Seq((0, 5.7), (1, 0.72), (2, 2.7))),
	    Vectors.sparse(3, Seq())
	  )
	
	  lazy val dataRDD = sc.parallelize(data, 3)
	
	  test("Normalization using L1 distance") {
	    val l1Normalizer = new Normalizer(1)
	
	    val data1 = data.map(l1Normalizer.transform)
	    val data1RDD = l1Normalizer.transform(dataRDD)
	
	    println("dataRDD:")
	    dataRDD.foreach(println)
	    println("data1RDD:")
	    data1RDD.foreach(println)
	    assert((data, data1, data1RDD.collect()).zipped.forall {
	      case (v1: DenseVector, v2: DenseVector, v3: DenseVector) => true
	      case (v1: SparseVector, v2: SparseVector, v3: SparseVector) => true
	      case _ => false
	    }, "The vector type should be preserved after normalization.")
	
	    assert((data1, data1RDD.collect()).zipped.forall((v1, v2) => v1 ~== v2 absTol 1E-5))
	
	    assert(brzNorm(data1(0).toBreeze, 1) ~== 1.0 absTol 1E-5)
	    assert(brzNorm(data1(2).toBreeze, 1) ~== 1.0 absTol 1E-5)
	    assert(brzNorm(data1(3).toBreeze, 1) ~== 1.0 absTol 1E-5)
	    assert(brzNorm(data1(4).toBreeze, 1) ~== 1.0 absTol 1E-5)
	
	    assert(data1(0) ~== Vectors.sparse(3, Seq((0, -0.465116279), (1, 0.53488372))) absTol 1E-5)
	    assert(data1(1) ~== Vectors.dense(0.0, 0.0, 0.0) absTol 1E-5)
	    assert(data1(2) ~== Vectors.dense(0.12765957, -0.23404255, -0.63829787) absTol 1E-5)
	    assert(data1(3) ~== Vectors.sparse(3, Seq((1, 0.22141119), (2, 0.7785888))) absTol 1E-5)
	    assert(data1(4) ~== Vectors.dense(0.625, 0.07894737, 0.29605263) absTol 1E-5)
	    assert(data1(5) ~== Vectors.sparse(3, Seq()) absTol 1E-5)
	  }

3.结果：

	dataRDD:
	[0.6,-1.1,-3.0]
	(3,[0,1],[-2.0,2.3])
	(3,[1,2],[0.91,3.2])
	[0.0,0.0,0.0]
	(3,[0,1,2],[5.7,0.72,2.7])
	(3,[],[])
	data1RDD:
	[0.1276595744680851,-0.23404255319148937,-0.6382978723404255]
	(3,[1,2],[0.2214111922141119,0.778588807785888])
	(3,[0,1],[-0.46511627906976744,0.5348837209302325])
	[0.0,0.0,0.0]
	(3,[0,1,2],[0.625,0.07894736842105261,0.29605263157894735])
	(3,[],[])

结果分析:

-3/(0.6+1.1+3)=-0.6382978723404255

	scala> 3.0/4.7
	res16: Double = 0.6382978723404255
	
	scala> 5.7/9.12
	res17: Double = 0.6250000000000001

故L1来归一化是将每个值除以所有元素绝对值只和

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
