
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

Power iteration clustering是生成图聚类的聚类算法，翻译为幂迭代聚类
测试数据为：


	0 1 1.0
	0 2 1.0
	0 3 1.0

其中第一列和第二列都是点的id，第三列为相似度的值。

	对于图的顶点聚类（顶点相似度作为边的属性）问题，幂迭代聚类(PIC)是高效并且易扩展的算法（参考： Lin and Cohen, Power Iteration Clustering）。MLlib包含了一个使用GraphX(MLlib)为基础的实现。算法的输入是RDD[srcID, dstID, similarity]，输出是每个顶点对应的聚类的模型。相似度(similarity)必须是非负值。PIC假设相似度的衡量是对称的，也就是说在输入数据中，(srcID, dstID)顺序无关（例如：<1, 2, 0.1>, <2, 1, 0.1等价），但是只能出现一次。输入中没有指定相似度的点对，相似度会置0。MLlib中的PIC实现具有下列参数：
	
	    k:  聚簇的数量
	    maxIterations: 最大迭代次数
	    initializationMode: 初始化模式：默认值“random”，表示使用一个随机向量作为顶点的聚类属性；也可以是“degree”，表示使用归一化的相似度和（作为顶点的聚类属性）。
具体请间【4】

2.代码：

	/**
	  * @author xubo
	  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
	  *         more code:https://github.com/xubo245/SparkLearning
	  *         more blog:http://blog.csdn.net/xubo245
	  */
	package org.apache.spark.mllib.clustering.PowerIterationClusteringLearning
	
	import org.apache.spark.util.SparkLearningFunSuite
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	class PICFromWebSuite extends SparkLearningFunSuite {
	  test("testFunSuite") {
	    import org.apache.spark.mllib.clustering.{PowerIterationClustering, PowerIterationClusteringModel}
	    import org.apache.spark.mllib.linalg.Vectors
	
	    // Load and parse the data
	    val data = sc.textFile("file/data/mllib/input/mllibFromSpark/pic_data.txt")
	    val similarities = data.map { line =>
	      val parts = line.split(' ')
	      (parts(0).toLong, parts(1).toLong, parts(2).toDouble)
	    }
	
	    // Cluster the data into two classes using PowerIterationClustering
	    val pic = new PowerIterationClustering()
	      .setK(2)
	      .setMaxIterations(10)
	    val model = pic.run(similarities)
	
	    model.assignments.foreach { a =>
	      println(s"${a.id} -> ${a.cluster}")
	    }
	//    model.pre
	    // Save and load model
	    //    model.save(sc, "myModelPath")
	    //    val sameModel = PowerIterationClusteringModel.load(sc, "myModelPath")F
	  }
	}


数据：

	0 1 1.0
	0 2 1.0
	0 3 1.0
	1 2 1.0
	1 3 1.0
	2 3 1.0
	3 4 0.1
	4 5 1.0
	4 15 1.0
	5 6 1.0
	6 7 1.0
	7 8 1.0
	8 9 1.0
	9 10 1.0
	10 11 1.0
	11 12 1.0
	12 13 1.0
	13 14 1.0
	14 15 1.0


3.结果：

	4 -> 0
	14 -> 0
	0 -> 1
	6 -> 0
	8 -> 0
	12 -> 0
	10 -> 0
	2 -> 1
	13 -> 0
	15 -> 0
	11 -> 0
	1 -> 1
	3 -> 1
	7 -> 0
	9 -> 0
	5 -> 0

该模型中没有看到predict函数

参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://www.fuqingchuan.com/2015/03/609.html#power-iteration-clustering-pic
