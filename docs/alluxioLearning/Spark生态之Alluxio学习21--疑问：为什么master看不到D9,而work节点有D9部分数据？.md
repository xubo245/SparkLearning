
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

# 1.解释 #

## 1.1 疑问##
为什么master看不到D9,而work节点有D9部分数据？

master也显示内存不止D7,因为D7大概2G

可以free掉D9

# 2.截图 #

## 2.1 master
![](http://i.imgur.com/7lgfEo4.png)

![](http://i.imgur.com/fgUeUk8.png)

## 2.2 works
![](http://i.imgur.com/YMkfaE5.png)

![](http://i.imgur.com/QoKJ1Px.png)

![](http://i.imgur.com/FACVCgx.png)




参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
