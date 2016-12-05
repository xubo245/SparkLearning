
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

# 1.解释 #

alluxio-0.7.1 启动的时候spark集群直接可以调用，但是alluxio-1.3.0需要自动配置

# 2.代码： #

## 2.1 下载##
  http://www.alluxio.org/download 下选择： 

	alluxio spark client   
  或者：  

	http://downloads.alluxio.org/downloads/files/1.3.0/alluxio-1.3.0-spark-client-jar-with-dependencies.jar

## 2.2 配置##
   请添加如下代码到spark/conf/spark-defaults.conf：

	spark.driver.extraClassPath /home/hadoop/cloud/alluxio-1.3.0/jar/alluxio-1.3.0-spark-client-jar-with-dependencies.jar
	spark.executor.extraClassPath /home/hadoop/cloud/alluxio-1.3.0/jar/alluxio-1.3.0-spark-client-jar-with-dependencies.jar

    jar包需要scp到每个节点
## 2.2 启动##
	重启spark集群
# 3.结果： #
   spark-shell可以操作alluxio集群
	
	scala>  val rdd1= sc.textFile("hdfs://219.219.220.149:9000//xubo/project/SparkSW/input/D1Line.fasta")
	rdd1: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[1] at textFile at <console>:21
	
	scala> rdd1.count
	res0: Long = 78295                                                              
	
	scala> rdd1.saveAsTextFile("alluxio://219.219.220.149:19998/D1Line.fasta")
	


参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
