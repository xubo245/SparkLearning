//package mllib
//
//import org.apache.spark.SparkConf
//import org.apache.spark.SparkContext
//import org.apache.spark.mllib.classification.SVMWithSGD
//import org.apache.spark.mllib.regression.LabeledPoint
//
//object svmTest {
//
//  val conf = new SparkConf().setAppName("Spark MLlib Exercise:K-Means Clustering").setMaster("local")
//  val sc = new SparkContext(conf)
//
//  // 加载和解析数据文件
//  val data = sc.textFile("mllib/data/sample_svm_data.txt")
//  val parsedData = data.map { line =>
//    val parts = line.split(' ')
//    LabeledPoint(parts(0).toDouble, parts.tail.map(x => x.toDouble).toArray)
//  }
//
//  // 设置迭代次数并进行进行训练
//  val numIterations = 20
//  val model = SVMWithSGD.train(parsedData, numIterations)
//
//  // 统计分类错误的样本比例
//  val labelAndPreds = parsedData.map { point =>
//    val prediction = model.predict(point.features)
//    (point.label, prediction)
//  }
//  val trainErr = labelAndPreds.filter(r => r._1 != r._2).count.toDouble / parsedData.count
//  println("Training Error = " + trainErr)
//}