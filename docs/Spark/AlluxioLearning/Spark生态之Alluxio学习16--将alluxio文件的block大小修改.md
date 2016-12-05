
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

# 1.alluxio-1.3.0 #

## 1.0 默认大小##
alluxio-1.3.0的block默认大小为512M，对于我每个节点只有10几个G的小内存来说，而且还需要进行spark运算，用于alluxio的大小不能太大，所以512M粒度比较大。需要修改

## 1.1 操作##
   将配置文件中增加为：
	alluxio.user.block.size.bytes.default=128MB


# 1.2.代码： #

## 1.2.1 copy##

    hadoop@Master:~/cloud/alluxio-1.3.0/conf$ cp alluxio-site.properties.template alluxio-site.properties

## 1.2.2 修改##
 在alluxio-site.properties最后增加一行，大小根据情况设置，我的修改为128M，与HDFS一致

	# User properties
	# alluxio.user.file.readtype.default=CACHE_PROMOTE
	# alluxio.user.file.writetype.default=MUST_CACHE
	alluxio.user.block.size.bytes.default=128MB

scp到其他节点，重启生效

# 1.3.结果： #

##19999查看生效：
  ![](http://i.imgur.com/Q4Vm2fV.png)

##是128M的倍数，不是512的倍数：
![](http://i.imgur.com/K1rE4TW.png)

# 2. alluxio-0.7.1

##2.1 修改

	hadoop@Master:~/cloud/tachyon-0.7.1-hadoop2.6-bin/conf$ cp ../common/src/main/resources/tachyon-default.properties tachyon-site.properties
	hadoop@Master:~/cloud/tachyon-0.7.1-hadoop2.6-bin/conf$ ls
	core-site.xml.template  log4j.properties  metrics.properties.template  slaves  tachyon-env.sh  tachyon-env.sh.swift  tachyon-env.sh.template  tachyon-glusterfs-env.sh.template  tachyon-site.properties  workers
	hadoop@Master:~/cloud/tachyon-0.7.1-hadoop2.6-bin/conf$ vi tachyon-site.properties 
	
修改内容：

	# User properties
	tachyon.user.failed.space.request.limits=3
	tachyon.user.heartbeat.interval.ms=1000
	tachyon.user.file.writetype.default=CACHE_THROUGH
	tachyon.user.default.block.size.byte=128MB
分发到各个节点，重启alluxio

## 2.2 结果

![](http://i.imgur.com/c79ZMs3.png)

参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
