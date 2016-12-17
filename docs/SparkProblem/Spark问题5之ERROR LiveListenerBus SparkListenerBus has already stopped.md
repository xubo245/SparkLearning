
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio（tachyon） 0.7.1，spark-1.5.2,hadoop-2.6.0

# 1.问题描述 #

## 1.1 描述##

将uniref按照序列长度[0,100).[100,)...进行划分，然后使用sparkSW从HDFS和Alluxio分别读取，并进行性能分析

运行过程中出现ERROR LiveListenerBus: SparkListenerBus has already stopped

## 1.2 问题显示##
	hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ tail -f alluxioHDFSSplittime201611241456.txt

	time:2
	(55,UniRef100_UPI000697D1C0)                                                    
	(55,UniRef100_UPI00064D62DA)
	(53,UniRef100_A0A194XVF9)
	(53,UniRef100_Q1ATC3)
	(52,UniRef100_C5J6S2)
	16/11/25 03:32:15 ERROR LiveListenerBus: SparkListenerBus has already stopped! Dropping event SparkListenerExecutorMetricsUpdate(3,WrappedArray())


# 2.解决办法： #

待解决


参考

	【1】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【2】https://github.com/xubo245/SparkLearning
