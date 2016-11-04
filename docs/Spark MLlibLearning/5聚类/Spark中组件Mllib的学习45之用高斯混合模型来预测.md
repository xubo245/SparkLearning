
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释
前面主要是建立模型，这篇讲的是使用mllib中的gmm来预测，主要改自mllib test中的suite



2.代码：
	
	 test("model prediction, parallel and local") {
	    val data = sc.parallelize(GaussianTestData.data)
	    val gmm = new GaussianMixture().setK(4).setSeed(0).run(data)
	
	    val batchPredictions = gmm.predict(data)
	    batchPredictions.zip(data).collect().foreach { case (batchPred, datum) =>
	      print("batchPred:"+batchPred)
	      println("  datum:"+datum)
	      assert(batchPred === gmm.predict(datum))
	    }
	    /** ****************add by xubo 20160613 *************/
	    for (i <- 0 until gmm.k) {
	      println("weight=%f\nmu=%s\nsigma=\n%s\n" format
	        (gmm.weights(i), gmm.gaussians(i).mu, gmm.gaussians(i).sigma))
	    }
	
	    /** ****************add by xubo 20160613 *************/
	  }

数据：

	object GaussianTestData {
	
	    val data = Array(
	      Vectors.dense(-5.1971), Vectors.dense(-2.5359), Vectors.dense(-3.8220),
	      Vectors.dense(-5.2211), Vectors.dense(-5.0602), Vectors.dense(4.7118),
	      Vectors.dense(6.8989), Vectors.dense(3.4592), Vectors.dense(4.6322),
	      Vectors.dense(5.7048), Vectors.dense(4.6567), Vectors.dense(5.5026),
	      Vectors.dense(4.5605), Vectors.dense(5.2043), Vectors.dense(6.2734)
	    )
	
	    val data2: Array[Vector] = Array.tabulate(25) { i: Int =>
	      Vectors.dense(Array.tabulate(50)(i + _.toDouble))
	    }
	
	  }

3.结果：
k=2:
	
	batchPred:1  datum:[-5.1971]
	batchPred:1  datum:[-2.5359]
	batchPred:1  datum:[-3.822]
	batchPred:1  datum:[-5.2211]
	batchPred:1  datum:[-5.0602]
	batchPred:0  datum:[4.7118]
	batchPred:0  datum:[6.8989]
	batchPred:0  datum:[3.4592]
	batchPred:0  datum:[4.6322]
	batchPred:0  datum:[5.7048]
	batchPred:0  datum:[4.6567]
	batchPred:0  datum:[5.5026]
	batchPred:0  datum:[4.5605]
	batchPred:0  datum:[5.2043]
	batchPred:0  datum:[6.2734]
	weight=0.666667
	mu=[5.160440000000388]
	sigma=
	0.8664462983997272  
	
	weight=0.333333
	mu=[-4.367259999996172]
	sigma=
	1.1098061864295243  

k=4:


	batchPred:0  datum:[-5.2211]
	batchPred:0  datum:[-5.0602]
	batchPred:2  datum:[4.7118]
	batchPred:1  datum:[6.8989]
	batchPred:2  datum:[3.4592]
	batchPred:2  datum:[4.6322]
	batchPred:2  datum:[5.7048]
	batchPred:2  datum:[4.6567]
	batchPred:2  datum:[5.5026]
	batchPred:2  datum:[4.5605]
	batchPred:2  datum:[5.2043]
	batchPred:2  datum:[6.2734]
	weight=0.199703
	mu=[-5.159541319359388]
	sigma=
	0.005019244232416107  
	
	weight=0.264231
	mu=[5.2562903953513125]
	sigma=
	0.9154479492242813  
	
	weight=0.402436
	mu=[5.09750654075634]
	sigma=
	0.8242799738536565  
	
	weight=0.133631
	mu=[-3.183244472524267]
	sigma=
	0.42087592390746537  


参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning



完整代码路径：【3】中可以找到

package org.apache.spark.mllib.learning.clustering.GaussianMixture

class GaussianMixtureFromSparkSuite