
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio（tachyon） 0.7.1，spark-1.5.2,hadoop-2.6.0

# 1.问题描述 #

## 1.1 spark lost excutor ##

hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ tail -f DSWSparkSWlengthBigtime201611291725.txt 
SparkSW:
time:1
[Stage 1:=================>                                     (41 + 16) / 128]16/11/29 17:52:31 ERROR TaskSchedulerImpl: Lost executor 1 on Mcnode6: Executor heartbeat timed out after 147971 ms
(268435469,UniRef100_B0B7U3)                                                    
(268435464,UniRef100_B8M044)
(268435462,UniRef100_Q9LZW4)
(268435458,UniRef100_Q9QWV9)
(268435456,UniRef100_Q8DD41)


## 1.2 ##

![](http://i.imgur.com/VIjBXWI.png)

博客【3】中说是系统crash导致ubuntu发送error，占比高

# 2.解决办法： #

## 2.1 ##


## 2.2 ##



# 3.运行记录： #


参考

	【1】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【2】https://github.com/xubo245/SparkLearning
	【3】http://blog.csdn.net/chrisniu1984/article/details/12050951
