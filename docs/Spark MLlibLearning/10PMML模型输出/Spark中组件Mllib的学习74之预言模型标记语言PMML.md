
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

全称预言模型标记语言（Predictive Model Markup Language），利用XML描述和存储数据挖掘模型，是一个已经被W3C所接受的标准。MML是一种基于XML的语言，用来定义预言模型。



2.代码：

	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.EvaluationMetrics
	
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class RegressionModelEvaluationFunSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	
	
	    import org.apache.spark.mllib.regression.LabeledPoint
	    import org.apache.spark.mllib.regression.LinearRegressionModel
	    import org.apache.spark.mllib.regression.LinearRegressionWithSGD
	    import org.apache.spark.mllib.linalg.Vectors
	    import org.apache.spark.mllib.evaluation.RegressionMetrics
	    import org.apache.spark.mllib.util.MLUtils
	
	    // Load the data
	    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_linear_regression_data.txt").cache()
	
	    // Build the model
	    val numIterations = 100
	    val model = LinearRegressionWithSGD.train(data, numIterations)
	
	    // Get predictions
	    val valuesAndPreds = data.map{ point =>
	      val prediction = model.predict(point.features)
	      (prediction, point.label)
	    }
	
	    // Instantiate metrics object
	    val metrics = new RegressionMetrics(valuesAndPreds)
	
	    // Squared error
	    println(s"MSE = ${metrics.meanSquaredError}")
	    println(s"RMSE = ${metrics.rootMeanSquaredError}")
	
	    // R-squared
	    println(s"R-squared = ${metrics.r2}")
	
	    // Mean absolute error
	    println(s"MAE = ${metrics.meanAbsoluteError}")
	
	    // Explained variance
	    println(s"Explained variance = ${metrics.explainedVariance}")
	
	
	  }
	}



3.结果：

	PMML Model:
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<PMML xmlns="http://www.dmg.org/PMML-4_2">
	    <Header description="k-means clustering">
	        <Application name="Apache Spark MLlib" version="1.5.2"/>
	        <Timestamp>2016-06-14T21:20:36</Timestamp>
	    </Header>
	    <DataDictionary numberOfFields="3">
	        <DataField name="field_0" optype="continuous" dataType="double"/>
	        <DataField name="field_1" optype="continuous" dataType="double"/>
	        <DataField name="field_2" optype="continuous" dataType="double"/>
	    </DataDictionary>
	    <ClusteringModel modelName="k-means" functionName="clustering" modelClass="centerBased" numberOfClusters="2">
	        <MiningSchema>
	            <MiningField name="field_0" usageType="active"/>
	            <MiningField name="field_1" usageType="active"/>
	            <MiningField name="field_2" usageType="active"/>
	        </MiningSchema>
	        <ComparisonMeasure kind="distance">
	            <squaredEuclidean/>
	        </ComparisonMeasure>
	        <ClusteringField field="field_0" compareFunction="absDiff"/>
	        <ClusteringField field="field_1" compareFunction="absDiff"/>
	        <ClusteringField field="field_2" compareFunction="absDiff"/>
	        <Cluster name="cluster_0">
	            <Array n="3" type="real">9.099999999999998 9.099999999999998 9.099999999999998</Array>
	        </Cluster>
	        <Cluster name="cluster_1">
	            <Array n="3" type="real">0.1 0.1 0.1</Array>
	        </Cluster>
	    </ClusteringModel>
	</PMML>
	
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<PMML xmlns="http://www.dmg.org/PMML-4_2">
	    <Header description="k-means clustering">
	        <Application name="Apache Spark MLlib" version="1.5.2"/>
	        <Timestamp>2016-06-14T21:20:40</Timestamp>
	    </Header>
	    <DataDictionary numberOfFields="3">
	        <DataField name="field_0" optype="continuous" dataType="double"/>
	        <DataField name="field_1" optype="continuous" dataType="double"/>
	        <DataField name="field_2" optype="continuous" dataType="double"/>
	    </DataDictionary>
	    <ClusteringModel modelName="k-means" functionName="clustering" modelClass="centerBased" numberOfClusters="2">
	        <MiningSchema>
	            <MiningField name="field_0" usageType="active"/>
	            <MiningField name="field_1" usageType="active"/>
	            <MiningField name="field_2" usageType="active"/>
	        </MiningSchema>
	        <ComparisonMeasure kind="distance">
	            <squaredEuclidean/>
	        </ComparisonMeasure>
	        <ClusteringField field="field_0" compareFunction="absDiff"/>
	        <ClusteringField field="field_1" compareFunction="absDiff"/>
	        <ClusteringField field="field_2" compareFunction="absDiff"/>
	        <Cluster name="cluster_0">
	            <Array n="3" type="real">9.099999999999998 9.099999999999998 9.099999999999998</Array>
	        </Cluster>
	        <Cluster name="cluster_1">
	            <Array n="3" type="real">0.1 0.1 0.1</Array>
	        </Cluster>
	    </ClusteringModel>
	</PMML>

analysis:

    clusters.clusterCenters.foreach(println)

	[9.099999999999998,9.099999999999998,9.099999999999998]
	[0.1,0.1,0.1]

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
