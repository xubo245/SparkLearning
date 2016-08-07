	更多代码请见：https://github.com/xubo245/SparkLearning
	Spark中组件Mllib的学习之回归分析篇
1解释
	
对多组数据进行model的training,然后再利用model来predict具体的值。过程中有输出model的权重 公式：f(x)=a1X1+a2X2+a3X3+......
	
2.代码：
	
	```
	package org.apache.spark.mllib.learning.regression
	
	import java.text.SimpleDateFormat
	import java.util.Date
	
	import org.apache.log4j.{Level, Logger}
	import org.apache.spark.mllib.linalg.Vectors
	import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}
	import org.apache.spark.{SparkConf, SparkContext}
	
	import scala.Array.canBuildFrom
	
	object LinearRegression {
	  def main(args: Array[String]): Unit = {
	    // 屏蔽不必要的日志显示终端上
	    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
	    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
	
	    // 设置运行环境
	    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
	    val sc = new SparkContext(conf)
	
	    // Load and parse the data
	    val data = sc.textFile("file/data/mllib/input/ridge-data/lpsa.data",1)
	    //如果读入不加1，会产生两个文件，应该是默认生成了两个partition
	    val parsedData = data.map { line =>
	      val parts = line.split(',')
	      LabeledPoint(parts(0).toDouble, Vectors.dense(parts(1).split(' ').map(_.toDouble)))
	    }
	
	    // Building the model
	    //建立model的数据和predict的数据没有分开
	    val numIterations = 100
	    val model = LinearRegressionWithSGD.train(parsedData, numIterations)
	    //    for(i<-parsedData) println(i.label+":"+i.features);
	    // Evaluate model on training examples and compute training error
	    val valuesAndPreds = parsedData.map { point =>
	      val prediction = model.predict(point.features)
	      (point.label, prediction)
	    }
	    //print model.weights
	    var weifhts=model.weights
	    println("model.weights"+weifhts)
	    
	    //save as file
	    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
	    val path = "file/data/mllib/output/LinearRegression/" + iString + "/result"
	    valuesAndPreds.saveAsTextFile(path)
	    val MSE = valuesAndPreds.map { case (v, p) => math.pow((v - p), 2) }.reduce(_ + _) / valuesAndPreds.count
	    println("training Mean Squared Error = " + MSE)
	
	    sc.stop()
	  }
	}
	```
数据请见github或者spark源码
	
3.结果：
	
	```
	model.weights[0.5808575763272221,0.18930001482946976,0.2803086929991066,0.1110834181777876,0.4010473965597895,-0.5603061626684255,-0.5804740464000981,0.8742741176970946]
	training Mean Squared Error = 6.207597210613579
	```
	
	参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】Spark MlLib机器学习实战
