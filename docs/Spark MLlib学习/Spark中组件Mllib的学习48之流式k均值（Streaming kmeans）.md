
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

流式K均值
	
当数据以流式到达，就需要动态预测分类，每当新数据到来时要更新模型。MLlib提供了流式k均值聚类，该方法使用参数来控制数据的衰减。这个算法使用mini-batch k均值更新规则的一种泛化版本。对于每一批数据，将所有点赋给最近的簇，计算新的簇中心，然后使用下面的方法更新簇：
![](http://www.fuqingchuan.com/wp-content/uploads/2015/03/111.png)



2.代码：

 	test("accuracy for single center and equivalence to grand average") {
    // set parameters
    val numBatches = 10
    val numPoints = 50
    val k = 1
    val d = 5
    val r = 0.1

    // create model with one cluster
    val model = new StreamingKMeans()
      .setK(1)
      .setDecayFactor(1.0)
      .setInitialCenters(Array(Vectors.dense(0.0, 0.0, 0.0, 0.0, 0.0)), Array(0.0))

    // generate random data for k-means
    val (input, centers) = StreamingKMeansDataGenerator(numPoints, numBatches, k, d, r, 42)

    // setup and run the model training
    ssc = setupStreams(input, (inputDStream: DStream[Vector]) => {
      model.trainOn(inputDStream)
      inputDStream.count()
    })
    runStreams(ssc, numBatches, numBatches)

    // estimated center should be close to true center
    assert(centers(0) ~== model.latestModel().clusterCenters(0) absTol 1E-1)
    /** ****************add by xubo 20160613 *************/
    println("model.latestModel().clusterCenters:")
      model.latestModel().clusterCenters.foreach(println)
    println("model.latestModel().clusterWeights:")
    model.latestModel().clusterWeights.foreach(println)

    /** ****************add by xubo 20160613 *************/
    // estimated center from streaming should exactly match the arithmetic mean of all data points
    // because the decay factor is set to 1.0
    val grandMean =
      input.flatten.map(x => x.toBreeze).reduce(_ + _) / (numBatches * numPoints).toDouble
    assert(model.latestModel().clusterCenters(0) ~== Vectors.dense(grandMean.toArray) absTol 1E-5)
    /** ****************add by xubo 20160613 *************/
    //println("input")
    //input.foreach(println)
    println("grandMean")
    grandMean.foreach(println)

    /** ****************add by xubo 20160613 *************/
  }



3.结果：

	model.latestModel().clusterCenters:
	[-0.4725511979691583,0.9644503899125422,-1.668776373542808,1.2721254429935838,0.37815209739836425]
	model.latestModel().clusterWeights:
	500.0
	grandMean
	-0.4725511979691581
	0.9644503899125427
	-1.6687763735428087
	1.2721254429935853
	0.37815209739836464

input数据量有点多，就没有放上来了。

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning


附录：

	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.clustering.kmeans
	
	import org.apache.spark.SparkConf
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.mllib.regression.LabeledPoint
	import org.apache.spark.mllib.clustering.StreamingKMeans
	import org.apache.spark.streaming.{Seconds, StreamingContext}
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  * 需要集群运行，目前没有运行测试
	  */
	class StreamingKmeansFromWebSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	    val conf = new SparkConf()
	      .setMaster("local[4]")
	      .setAppName("SparkLearningTest")
	    val ssc = new StreamingContext(conf, Seconds(1))
	    val trainingData = ssc.textFileStream("file/data/mllib/input/trainingDic").map(Vectors.parse)
	    val testData = ssc.textFileStream("file/data/mllib/input/testingDic").map(LabeledPoint.parse)
	    val numDimensions = 3
	    val numClusters = 2
	    val model = new StreamingKMeans()
	      .setK(numClusters)
	      .setDecayFactor(1.0)
	      .setRandomCenters(numDimensions, 0.0)
	    model.trainOn(trainingData)
	    model.predictOnValues(testData.map(lp => (lp.label, lp.features))).print()
	
	    ssc.start()
	    ssc.awaitTermination()
	  }
	}
