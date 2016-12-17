
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio（tachyon） 0.7.1，spark-1.5.2,hadoop-2.6.0

# 1.问题描述 #

## 1.1 ##

Mcnode1 的一个excutor丢失：	ExecutorLostFailure (executor 2 lost)

## 1.2 ##

	http://Master:18080/history/app-20161121121144-2893

导致整个计算过程拖长，其他节点都在一分钟结束，但是excutor丢失的节点耗时3min
# 2.解决办法： #

待解决

# 3.运行记录： #

![](http://i.imgur.com/WyfGE8c.png)

![](http://i.imgur.com/hkpowyL.png)

![](http://i.imgur.com/AcfUsHW.png)

参考

	【1】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【2】https://github.com/xubo245/SparkLearning
