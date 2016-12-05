
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

归一化

Normalization using L2 distance

公式：

分母为：其中本例中p为2

![](http://i.imgur.com/Ll5M0O8.png)


2.代码：
	
	test("Normalization using L2 distance") {
	    val l2Normalizer = new Normalizer()
	
	    val data2 = data.map(l2Normalizer.transform)
	    val data2RDD = l2Normalizer.transform(dataRDD)
	
	    println("dataRDD:")
	    dataRDD.foreach(println)
	    println("data2RDD:")
	    data2RDD.foreach(println)
	
	    assert((data, data2, data2RDD.collect()).zipped.forall {
	      case (v1: DenseVector, v2: DenseVector, v3: DenseVector) => true
	      case (v1: SparseVector, v2: SparseVector, v3: SparseVector) => true
	      case _ => false
	    }, "The vector type should be preserved after normalization.")
	
	    assert((data2, data2RDD.collect()).zipped.forall((v1, v2) => v1 ~== v2 absTol 1E-5))
	
	    assert(brzNorm(data2(0).toBreeze, 2) ~== 1.0 absTol 1E-5)
	    assert(brzNorm(data2(2).toBreeze, 2) ~== 1.0 absTol 1E-5)
	    assert(brzNorm(data2(3).toBreeze, 2) ~== 1.0 absTol 1E-5)
	    assert(brzNorm(data2(4).toBreeze, 2) ~== 1.0 absTol 1E-5)
	
	    assert(data2(0) ~== Vectors.sparse(3, Seq((0, -0.65617871), (1, 0.75460552))) absTol 1E-5)
	    assert(data2(1) ~== Vectors.dense(0.0, 0.0, 0.0) absTol 1E-5)
	    assert(data2(2) ~== Vectors.dense(0.184549876, -0.3383414, -0.922749378) absTol 1E-5)
	    assert(data2(3) ~== Vectors.sparse(3, Seq((1, 0.27352993), (2, 0.96186349))) absTol 1E-5)
	    assert(data2(4) ~== Vectors.dense(0.897906166, 0.113419726, 0.42532397) absTol 1E-5)
	    assert(data2(5) ~== Vectors.sparse(3, Seq()) absTol 1E-5)
	  }


3.结果：

	dataRDD:
	[0.6,-1.1,-3.0]
	(3,[0,1],[-2.0,2.3])
	(3,[1,2],[0.91,3.2])
	[0.0,0.0,0.0]
	(3,[0,1,2],[5.7,0.72,2.7])
	(3,[],[])
	data2RDD:
	[0.18454987557625951,-0.3383414385564758,-0.9227493778812975]
	(3,[1,2],[0.2735299305180406,0.9618634919315713])
	(3,[0,1,2],[0.8979061661970154,0.11341972625646508,0.4253239734617441])
	(3,[],[])
	(3,[0,1],[-0.6561787149247866,0.7546055221635046])
	[0.0,0.0,0.0]

结果分析：


	scala> 0.6/Math.sqrt(0.6*0.6+1.1*1.1+3.0*3)
	res32: Double = 0.18454987557625951
	
	scala> -1.1/Math.sqrt(0.6*0.6+1.1*1.1+3.0*3)
	res33: Double = -0.3383414385564758
	
	scala> -3.0/Math.sqrt(0.6*0.6+1.1*1.1+3.0*3)
	res34: Double = -0.9227493778812975

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
	【6】https://github.com/endymecy/spark-ml-source-analysis/blob/master/%E7%89%B9%E5%BE%81%E6%8A%BD%E5%8F%96%E5%92%8C%E8%BD%AC%E6%8D%A2/normalizer.md

