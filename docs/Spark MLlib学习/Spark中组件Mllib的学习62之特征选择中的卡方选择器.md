	
	更多代码请见：https://github.com/xubo245/SparkLearning
	
	Spark中组件Mllib的学习
	
1.解释
	
　　特征选择试图识别相关的特征用于模型构建。它改变特征空间的大小，它可以提高速度以及统计学习行为。ChiSqSelector实现卡方特征选择，它操作于带有类别特征的标注数据。 ChiSqSelector根据独立的卡方测试对特征进行排序，然后选择排序最高的特征。
	
	卡方选择（ChiSqSelector）
	
	ChiSqSelector是指使用卡方（Chi-Squared）做特征选择。该方法操作的是有标签的类别型数据。ChiSqSelector基于卡方检验来排序数据，然后选出卡方值较大(也就是跟标签最相关)的特征（topk)。
	模型拟合
	
	ChiSqSelector 的构造函数有如下特征：
	
	    numTopFeatures 保留的卡方较大的特征的数量。
	
	ChiSqSelector.fit() 方法以具有类别特征的RDD[LabeledPoint]为输入，计算汇总统计信息，然后返回ChiSqSelectorModel，这个类将输入数据转化到降维的特征空间。
	
	模型实现了 VectorTransformer，这个类可以在Vector和RDD[Vector]上做卡方特征选择。
	
	注意：也可以手工构造一个ChiSqSelectorModel，需要提供升序排列的特征索引。
	
2.代码：
	
	/*
	 * Licensed to the Apache Software Foundation (ASF) under one or more
	 * contributor license agreements.  See the NOTICE file distributed with
	 * this work for additional information regarding copyright ownership.
	 * The ASF licenses this file to You under the Apache License, Version 2.0
	 * (the "License"); you may not use this file except in compliance with
	 * the License.  You may obtain a copy of the License at
	 *
	 *    http://www.apache.org/licenses/LICENSE-2.0
	 *
	 * Unless required by applicable law or agreed to in writing, software
	 * distributed under the License is distributed on an "AS IS" BASIS,
	 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	 * See the License for the specific language governing permissions and
	 * limitations under the License.
	 */
	
	package org.apache.spark.mllib.FeatureExtractionAndTransformation
	
	import org.apache.spark.SparkFunSuite
	import org.apache.spark.mllib.feature.ChiSqSelector
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.mllib.regression.LabeledPoint
	import org.apache.spark.mllib.util.MLlibTestSparkContext
	
	class ChiSqSelectorSuite extends SparkFunSuite with MLlibTestSparkContext {
	
	  /*
	   *  Contingency tables
	   *  feature0 = {8.0, 0.0}
	   *  class  0 1 2
	   *    8.0||1|0|1|
	   *    0.0||0|2|0|
	   *
	   *  feature1 = {7.0, 9.0}
	   *  class  0 1 2
	   *    7.0||1|0|0|
	   *    9.0||0|2|1|
	   *
	   *  feature2 = {0.0, 6.0, 8.0, 5.0}
	   *  class  0 1 2
	   *    0.0||1|0|0|
	   *    6.0||0|1|0|
	   *    8.0||0|1|0|
	   *    5.0||0|0|1|
	   *
	   *  Use chi-squared calculator from Internet
	   */
	
	  test("ChiSqSelector transform test (sparse & dense vector)") {
	    val labeledDiscreteData = sc.parallelize(
	      Seq(LabeledPoint(0.0, Vectors.sparse(3, Array((0, 8.0), (1, 7.0)))),
	        LabeledPoint(1.0, Vectors.sparse(3, Array((1, 9.0), (2, 6.0)))),
	        LabeledPoint(1.0, Vectors.dense(Array(0.0, 9.0, 8.0))),
	        LabeledPoint(2.0, Vectors.dense(Array(8.0, 9.0, 5.0)))), 2)
	    val preFilteredData =
	      Set(LabeledPoint(0.0, Vectors.dense(Array(0.0))),
	        LabeledPoint(1.0, Vectors.dense(Array(6.0))),
	        LabeledPoint(1.0, Vectors.dense(Array(8.0))),
	        LabeledPoint(2.0, Vectors.dense(Array(5.0))))
	    val model = new ChiSqSelector(2).fit(labeledDiscreteData)
	    val filteredData = labeledDiscreteData.map { lp =>
	      LabeledPoint(lp.label, model.transform(lp.features))
	    }.collect().toSet
	    //    assert(filteredData == preFilteredData)
	
	    println("labeledDiscreteData:")
	    labeledDiscreteData.foreach(println)
	    println("model:")
	    model.selectedFeatures.foreach(println)
	    //    model.selectedFeatures.
	    println("filteredData:")
	    filteredData.foreach(println)
	    println("preFilteredData:")
	    preFilteredData.foreach(println)
	  }
	}
	
	
	3.结果：
	
	（1）new ChiSqSelector(1)
	
	labeledDiscreteData:
	(0.0,(3,[0,1],[8.0,7.0]))
	(1.0,(3,[1,2],[9.0,6.0]))
	(1.0,[0.0,9.0,8.0])
	(2.0,[8.0,9.0,5.0])
	model:
	2
	filteredData:
	(0.0,(1,[],[]))
	(1.0,(1,[0],[6.0]))
	(1.0,[8.0])
	(2.0,[5.0])
	preFilteredData:
	(0.0,[0.0])
	(1.0,[6.0])
	(1.0,[8.0])
	(2.0,[5.0])
	
	（2）new ChiSqSelector(2)
	
	labeledDiscreteData:
	(1.0,[0.0,9.0,8.0])
	(2.0,[8.0,9.0,5.0])
	(0.0,(3,[0,1],[8.0,7.0]))
	(1.0,(3,[1,2],[9.0,6.0]))
	model:
	0
	2
	filteredData:
	(0.0,(2,[0],[8.0]))
	(1.0,(2,[1],[6.0]))
	(1.0,[0.0,8.0])
	(2.0,[8.0,5.0])
	preFilteredData:
	(0.0,[0.0])
	(1.0,[6.0])
	(1.0,[8.0])
	(2.0,[5.0])
	
	
	
参考
	
		【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
		【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
		【3】https://github.com/xubo245/SparkLearning
		【4】book:Machine Learning with Spark ,Nick Pertreach
	    【5】book:Spark MlLib机器学习实战
		【6】https://github.com/endymecy/spark-ml-source-analysis/blob/master/%E7%89%B9%E5%BE%81%E6%8A%BD%E5%8F%96%E5%92%8C%E8%BD%AC%E6%8D%A2/chi-square-selector.md
		【７】http://www.fuqingchuan.com/2015/03/643.html#standardscaler
