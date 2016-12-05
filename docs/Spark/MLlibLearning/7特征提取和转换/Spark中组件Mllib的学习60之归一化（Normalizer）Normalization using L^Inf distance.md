
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

归一化

Normalization using L^Inf distance

公式：分母为元素中绝对值最大值


2.代码：
	
	test("Normalization using L^Inf distance.") {
    val lInfNormalizer = new Normalizer(Double.PositiveInfinity)

    val dataInf = data.map(lInfNormalizer.transform)
    val dataInfRDD = lInfNormalizer.transform(dataRDD)

    println("dataRDD:")
    dataRDD.foreach(println)
    println("dataInf:")
    dataInf.foreach(println)
    println("dataInfRDD:")
    dataInfRDD.foreach(println)

    assert((data, dataInf, dataInfRDD.collect()).zipped.forall {
      case (v1: DenseVector, v2: DenseVector, v3: DenseVector) => true
      case (v1: SparseVector, v2: SparseVector, v3: SparseVector) => true
      case _ => false
    }, "The vector type should be preserved after normalization.")

    assert((dataInf, dataInfRDD.collect()).zipped.forall((v1, v2) => v1 ~== v2 absTol 1E-5))

    assert(dataInf(0).toArray.map(math.abs).max ~== 1.0 absTol 1E-5)
    assert(dataInf(2).toArray.map(math.abs).max ~== 1.0 absTol 1E-5)
    assert(dataInf(3).toArray.map(math.abs).max ~== 1.0 absTol 1E-5)
    assert(dataInf(4).toArray.map(math.abs).max ~== 1.0 absTol 1E-5)

    assert(dataInf(0) ~== Vectors.sparse(3, Seq((0, -0.86956522), (1, 1.0))) absTol 1E-5)
    assert(dataInf(1) ~== Vectors.dense(0.0, 0.0, 0.0) absTol 1E-5)
    assert(dataInf(2) ~== Vectors.dense(0.2, -0.36666667, -1.0) absTol 1E-5)
    assert(dataInf(3) ~== Vectors.sparse(3, Seq((1, 0.284375), (2, 1.0))) absTol 1E-5)
    assert(dataInf(4) ~== Vectors.dense(1.0, 0.12631579, 0.473684211) absTol 1E-5)
    assert(dataInf(5) ~== Vectors.sparse(3, Seq()) absTol 1E-5)
  }


3.结果：

	dataRDD:
	[0.6,-1.1,-3.0]
	(3,[1,2],[0.91,3.2])
	(3,[0,1],[-2.0,2.3])
	[0.0,0.0,0.0]
	(3,[0,1,2],[5.7,0.72,2.7])
	(3,[],[])
	dataInf:
	(3,[0,1],[-0.8695652173913044,1.0])
	[0.0,0.0,0.0]
	[0.19999999999999998,-0.3666666666666667,-1.0]
	(3,[1,2],[0.284375,1.0])
	(3,[0,1,2],[1.0,0.12631578947368421,0.4736842105263158])
	(3,[],[])
	dataInfRDD:
	[0.19999999999999998,-0.3666666666666667,-1.0]
	(3,[1,2],[0.284375,1.0])
	(3,[0,1],[-0.8695652173913044,1.0])
	[0.0,0.0,0.0]
	(3,[0,1,2],[1.0,0.12631578947368421,0.4736842105263158])
	(3,[],[])


结果分析：


	-3/3=-1

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
