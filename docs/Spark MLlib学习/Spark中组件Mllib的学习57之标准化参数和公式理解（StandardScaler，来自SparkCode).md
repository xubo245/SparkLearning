	
	更多代码请见：https://github.com/xubo245/SparkLearning
	
	Spark中组件Mllib的学习
	
1.解释
	
	由于前一篇的ref的表达不一样，所以：
	学习spark mllib的test代码，理解标准化的计算
	具体请看最后的结果分析
 
结论为：

（1）当参数为：
	
	equivalentModel1.withMean:true
	equivalentModel1.withStd:true
公式就是(x-u)/sqrt(variance)，x为标准化前的值，u为该列的平均值，variance为该列的方差，开方即为标准差

（2）当参数为：
	
	equivalentModel2.withMean:false
	equivalentModel2.withStd:true
公式就是(x)/sqrt(variance)，x为标准化前的值，variance为该列的方差，开方即为标准差


（3）当参数为：
	
	equivalentModel2.withMean:true
	equivalentModel2.withStd:true
公式就是(x-u)，x为标准化前的值，u为该列的平均值
	
2.代码：
	
	  val constantData = Array(
	    Vectors.dense(2.0),
	    Vectors.dense(2.0),
	    Vectors.dense(2.0)
	  )
	
	  val sparseData = Array(
	    Vectors.sparse(3, Seq((0, -2.0), (1, 2.3))),
	    Vectors.sparse(3, Seq((1, -1.0), (2, -3.0))),
	    Vectors.sparse(3, Seq((1, -5.1))),
	    Vectors.sparse(3, Seq((0, 3.8), (2, 1.9))),
	    Vectors.sparse(3, Seq((0, 1.7), (1, -0.6))),
	    Vectors.sparse(3, Seq((1, 1.9)))
	  )
	
	  val denseData = Array(
	    Vectors.dense(-2.0, 2.3, 0),
	    Vectors.dense(0.0, -1.0, -3.0),
	    Vectors.dense(0.0, -5.1, 0.0),
	    Vectors.dense(3.8, 0.0, 1.9),
	    Vectors.dense(1.7, -0.6, 0.0),
	    Vectors.dense(0.0, 1.9, 0.0)
	  )
	
	  private def computeSummary(data: RDD[Vector]): MultivariateStatisticalSummary = {
	    data.treeAggregate(new MultivariateOnlineSummarizer)(
	      (aggregator, data) => aggregator.add(data),
	      (aggregator1, aggregator2) => aggregator1.merge(aggregator2))
	  }
	
	  test("Standardization with dense input when means and stds are provided") {
	
	    val dataRDD = sc.parallelize(denseData, 3)
	
	    val standardizer1 = new StandardScaler(withMean = true, withStd = true)
	    val standardizer2 = new StandardScaler()
	    val standardizer3 = new StandardScaler(withMean = true, withStd = false)
	
	    val model1 = standardizer1.fit(dataRDD)
	    val model2 = standardizer2.fit(dataRDD)
	    val model3 = standardizer3.fit(dataRDD)
	
	    val equivalentModel1 = new StandardScalerModel(model1.std, model1.mean)
	    val equivalentModel2 = new StandardScalerModel(model2.std, model2.mean, true, false)
	    val equivalentModel3 = new StandardScalerModel(model3.std, model3.mean, false, true)
	
	    val data1 = denseData.map(equivalentModel1.transform)
	    val data2 = denseData.map(equivalentModel2.transform)
	    val data3 = denseData.map(equivalentModel3.transform)
	
	    val data1RDD = equivalentModel1.transform(dataRDD)
	    val data2RDD = equivalentModel2.transform(dataRDD)
	    val data3RDD = equivalentModel3.transform(dataRDD)
	
	    val summary = computeSummary(dataRDD)
	    val summary1 = computeSummary(data1RDD)
	    val summary2 = computeSummary(data2RDD)
	    val summary3 = computeSummary(data3RDD)
	
	    println("denseData:")
	    denseData.take(10).foreach { each =>
	      println(each.size + ":" + each)
	      //      println(each.size)
	    }
	    println("dataRDD:")
	    dataRDD.take(10).foreach { each =>
	      println(each.size + ":" + each)
	      //      println(each.size)
	    }
	    println("equivalentModel1.mean:" + equivalentModel1.mean)
	    println("equivalentModel1.std:" + equivalentModel1.std)
	    println("equivalentModel1.withMean:" + equivalentModel1.withMean)
	    println("equivalentModel1.withStd:" + equivalentModel1.withStd)
	    println("data1RDD:")
	    data1RDD.take(10).foreach { each =>
	      println(each.size + ":" + each)
	      //      println(each.size)
	    }
	    println("equivalentModel2.mean:" + equivalentModel2.mean)
	    println("equivalentModel2.std:" + equivalentModel2.std)
	    println("equivalentModel2.withMean:" + equivalentModel2.withMean)
	    println("equivalentModel2.withStd:" + equivalentModel2.withStd)
	    println("data2RDD:")
	    data2RDD.take(10).foreach { each =>
	      println(each.size + ":" + each)
	      //      println(each.size)
	    }
	    println("equivalentModel3.mean:" + equivalentModel3.mean)
	    println("equivalentModel3.std:" + equivalentModel3.std)
	    println("equivalentModel3.withMean:" + equivalentModel3.withMean)
	    println("equivalentModel3.withStd:" + equivalentModel3.withStd)
	    println("data3RDD:")
	    data3RDD.take(10).foreach { each =>
	      println(each.size + ":" + each)
	      //      println(each.size)
	    }
	
	
3.结果：
	
	denseData:
	3:[-2.0,2.3,0.0]
	3:[0.0,-1.0,-3.0]
	3:[0.0,-5.1,0.0]
	3:[3.8,0.0,1.9]
	3:[1.7,-0.6,0.0]
	3:[0.0,1.9,0.0]
	dataRDD:
	3:[-2.0,2.3,0.0]
	3:[0.0,-1.0,-3.0]
	3:[0.0,-5.1,0.0]
	3:[3.8,0.0,1.9]
	3:[1.7,-0.6,0.0]
	3:[0.0,1.9,0.0]
	equivalentModel1.mean:[0.5833333333333333,-0.4166666666666665,-0.1833333333333334]
	equivalentModel1.std:[1.9640943629741079,2.6543674701643454,1.5753306531222795]
	equivalentModel1.withMean:true
	equivalentModel1.withStd:true
	data1RDD:
	3:[-1.3152796433983698,1.023470449062753,0.11637768424677686]
	3:[-0.2969986291544706,-0.21976359335703294,-1.7879844216095708]
	3:[-0.2969986291544706,-1.7643877066664642,0.11637768424677686]
	3:[1.6377352979089383,0.15697399525502342,1.3224736846224638]
	3:[0.5685402329528438,-0.06906855791221038,0.11637768424677686]
	3:[-0.2969986291544706,0.8727754136179304,0.11637768424677686]
	equivalentModel2.mean:[0.5833333333333333,-0.4166666666666667,-0.18333333333333326]
	equivalentModel2.std:[1.9640943629741079,2.6543674701643454,1.5753306531222793]
	equivalentModel2.withMean:false
	equivalentModel2.withStd:true
	data2RDD:
	3:[-1.0182810142438994,0.8664964538077295,0.0]
	3:[0.0,-0.37673758861205636,-1.904362105856348]
	3:[0.0,-1.9213617019214873,0.0]
	3:[1.9347339270634087,0.0,1.206096000375687]
	3:[0.8655388621073145,-0.22604255316723382,0.0]
	3:[0.0,0.715801418362907,0.0]
	equivalentModel3.mean:[0.5833333333333333,-0.4166666666666665,-0.1833333333333334]
	equivalentModel3.std:[1.9640943629741079,2.6543674701643454,1.5753306531222795]
	equivalentModel3.withMean:true
	equivalentModel3.withStd:false
	data3RDD:
	3:[-2.583333333333333,2.7166666666666663,0.1833333333333334]
	3:[-0.5833333333333333,-0.5833333333333335,-2.8166666666666664]
	3:[-0.5833333333333333,-4.683333333333334,0.1833333333333334]
	3:[3.216666666666667,0.4166666666666665,2.0833333333333335]
	3:[1.1166666666666667,-0.18333333333333346,0.1833333333333334]
	3:[-0.5833333333333333,2.3166666666666664,0.1833333333333334]
	

结果分析：
（1）

	dataRDD:
	3:[-2.0,2.3,0.0]
	3:[0.0,-1.0,-3.0]
	3:[0.0,-5.1,0.0]
	3:[3.8,0.0,1.9]
	3:[1.7,-0.6,0.0]
	3:[0.0,1.9,0.0]
第一列的平均值是0.5833333333333333，标准差是1.9640943629741079，训练时：

	equivalentModel1.withMean:true
	equivalentModel1.withStd:true

所以结果为：】

	data1RDD:
	3:[-1.3152796433983698,1.023470449062753,0.11637768424677686]
	3:[-0.2969986291544706,-0.21976359335703294,-1.7879844216095708]
	3:[-0.2969986291544706,-1.7643877066664642,0.11637768424677686]
	3:[1.6377352979089383,0.15697399525502342,1.3224736846224638]
	3:[0.5685402329528438,-0.06906855791221038,0.11637768424677686]
	3:[-0.2969986291544706,0.8727754136179304,0.11637768424677686]

其中：
-1.3152796433983698=（-2-0.5833333333333333）/1.9640943629741079

	scala> (-2-0.583)/1.96
	res11: Double = -1.317857142857143
	
	scala> (-0.583)/1.96
	res12: Double = -0.29744897959183675


所以公式为：公式就是(x-u)/sqrt(variance)，x为标准化前的值，u为该列的平均值，variance为该列的方差，开方即为标准差


（2）

	dataRDD:
	3:[-2.0,2.3,0.0]
	3:[0.0,-1.0,-3.0]
	3:[0.0,-5.1,0.0]
	3:[3.8,0.0,1.9]
	3:[1.7,-0.6,0.0]
	3:[0.0,1.9,0.0]
	
	equivalentModel2.mean:[0.5833333333333333,-0.4166666666666667,-0.18333333333333326]
	equivalentModel2.std:[1.9640943629741079,2.6543674701643454,1.5753306531222793]
	equivalentModel2.withMean:false
	equivalentModel2.withStd:true
	data2RDD:
	3:[-1.0182810142438994,0.8664964538077295,0.0]
	3:[0.0,-0.37673758861205636,-1.904362105856348]
	3:[0.0,-1.9213617019214873,0.0]
	3:[1.9347339270634087,0.0,1.206096000375687]
	3:[0.8655388621073145,-0.22604255316723382,0.0]
	3:[0.0,0.715801418362907,0.0]

同理计算：
	
	scala> (-2)/1.964094
	res14: Double = -1.018281202427175

所以公式为：

	(x)/sqrt(variance)	

（3）


	equivalentModel3.mean:[0.5833333333333333,-0.4166666666666665,-0.1833333333333334]
	equivalentModel3.std:[1.9640943629741079,2.6543674701643454,1.5753306531222795]
	equivalentModel3.withMean:true
	equivalentModel3.withStd:false
	data3RDD:
	3:[-2.583333333333333,2.7166666666666663,0.1833333333333334]
	3:[-0.5833333333333333,-0.5833333333333335,-2.8166666666666664]
	3:[-0.5833333333333333,-4.683333333333334,0.1833333333333334]
	3:[3.216666666666667,0.4166666666666665,2.0833333333333335]
	3:[1.1166666666666667,-0.18333333333333346,0.1833333333333334]
	3:[-0.5833333333333333,2.3166666666666664,0.1833333333333334]

同理，所以公式为：

	(x-u)

参考
	
		【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
		【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
		【3】https://github.com/xubo245/SparkLearning
		【4】book:Machine Learning with Spark ,Nick Pertreach
	    【5】book:Spark MlLib机器学习实战
