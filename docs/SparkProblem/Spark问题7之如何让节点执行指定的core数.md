
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio（tachyon） 0.7.1，spark-1.5.2,hadoop-2.6.0

# 1.问题描述 #

## 1.1 ##
使用1，2的代码会有1个节点执行连个core


## 1.2 ## 代码

hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ vi testDSWscalability.sh 

	#!/bin/bash
	
	#sbt clean
	#sbt package
	
	mem=$1
	subMatrixFile=$2
	queryFile=$3
	dbFile=$4
	splitNum=$5
	taskNum=$6
	topK=$7
	cores=$8
	
	#/home/zgg/lib/spark-1.0.1-bin-hadoop2/bin/spark-submit \
	  spark-submit \
	  --class "org.dsw.core.DSW" \
	  --conf spark.executor.cores=1 \
	  --conf "spark.executor.extraJavaOptions=-Djava.library.path=/home/hadoop/disk2/xubo/lib" \
	  --master spark://219.219.220.149:7077 \
	  --total-executor-cores $cores \
	  --executor-memory $mem \
	  SparkSW.jar $subMatrixFile $queryFile $dbFile $splitNum $taskNum $topK

# 2.解决办法： #

## 2.1 ##

不知道如何解决？

## 2.2 ##

不加--conf spark.executor.cores=1 \，core小于节点数，即8时都是每个节点执行一个core。


# 3.运行记录： #

展示采取2.2

参考

	【1】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【2】https://github.com/xubo245/SparkLearning
