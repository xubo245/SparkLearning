
更多代码请见：https://github.com/xubo245/SparkLearning

spark源码解读系列环境：spark-1.5.2、hadoop-2.6.0、scala-2.10.4，ganglia-3.6.1

系统：ubuntu 14.04

# 1.理解 #

## 1.1 ganglia的概述 ##

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ganglia是UC Berkeley发起的一个开源集群监视项目，设计用于测量数以千计的节点。Ganglia的核心包含gmond、gmetad以及一个Web前端。主要是用来监控系统性能，如：cpu 、mem、硬盘利用率， I/O负载、网络流量情况等，通过曲线很容易见到每个节点的工作状态，对合理调整、分配系统资源，提高系统整体性能起到重要作用。  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ganglia是一个集群监控工具，hadoop和spark已经支持   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ganglia有论文，“The ganglia distributed monitoring system:
design, implementation, and experience”。  
## 1.2 Ganglia architecture： ##
![](http://i.imgur.com/sa6JsSV.png)

## 1.3 集群配置 ##

## 1.3.1 准备   ##
需要先配置apache2和php

安装 Apache2：
 
	sudo apt-get install apache2
 
安装PHP模块：
 
	sudo apt-get install php5
其他模块安装：
 
	sudo apt-get install libapache2-mod-php5
	sudo apt-get install libapache2-mod-auth-mysql
具体请参考【5】或者搜索，网上有很多

## 1.3.2 安装ganglia单节点 ##

打开终端，运行以下命令：

	sudo apt-get install ganglia-monitor rrdtool gmetad ganglia-webfrontend

在安装过程中，你应该会看到安装后与apache2服务器重启选择，直接 Yes，然后按Enter键。

需要复制 Ganglia webfrontend Apache 配置，使用下面的命令来正确的位置：

	sudo cp /etc/ganglia-webfrontend/apache.conf /etc/apache2/sites-enabled/ganglia.conf

需要重启服务：

	sudo /etc/init.d/ganglia-monitor start
	sudo /etc/init.d/gmetad start
	sudo /etc/init.d/apache2 restart

现在你可以使用以下命令访问gnglia webinterface：

	http://serverip/ganglia/

可以参考【6】


## 1.3.3 安装ganglia集群 ##

**主节点：Mcnode7**

**客户端：Master Mcnode1 Mcnode2 Mcnode3 Mcnode4 Mcnode5 Mcnode6 Mcnode7**

## 主节点(一个) ##
 现在需要使用以下命令来编辑 Ganglia 元守护程序的配置文件：

	sudo vi /etc/ganglia/gmetad.conf

更改如下：

	data_source "Spark" 10 Mcnode7:8649

通过以上列出机器服务的数据源，IP：端口或服务器名称：端口。如果未指定端口号8649（默认gmond端口）。

	case_sensitive_hostnames 0 
设置为1，则不会将hostname中大写变成小写
 
 需要重启服务：

	sudo /etc/init.d/ganglia-monitor restart
	sudo /etc/init.d/gmetad start
	sudo /etc/init.d/apache2 restart

   现在你可以使用以下命令访问ganglia webinterface：

	http://192.168.1.50/ganglia/

## 客户端（8个） ##

**（1） ganglia 客户端安装**

你需要安装以下所有服务器要监视客户端包

	sudo apt-get install ganglia-monitor
**（2）客户端配置：**  

  使用了单播模式，需要使用下面的命令编辑主节点的配置文件：

	sudo vi /etc/ganglia/gmond.conf

   更改如下：（----注释为改动）

	/* If a cluster attribute is specified, then all gmond hosts are wrapped inside
	 * of a <CLUSTER> tag.  If you do not specify a cluster tag, then all <HOSTS> will
	 * NOT be wrapped inside of a <CLUSTER> tag. */
	cluster {
	  name = "Spark"             ------集群名称
	  owner = "unspecified"
	  latlong = "unspecified"
	  url = "unspecified"
	}
	
	/* The host section describes attributes of the host, like the location */
	host {
	  location = "unspecified"
	}
	
	/* Feel free to specify as many udp_send_channels as you like.  Gmond
	   used to only support having a single channel */
	udp_send_channel {
	  #mcast_join = 239.2.11.71   ------注释掉组播
	  host = Mcnode7   ------发送给安装gmetad的机器
	  port = 8649
	  ttl = 1
	}
	
	/* You can specify as many udp_recv_channels as you like as well. */
	udp_recv_channel {
	  #mcast_join = 239.2.11.71   ------注释掉组播 
	  port = 8649
	  #bind = 239.2.11.71        ------注释掉
	}


   保存并关闭文件。  
**（3）客户端生效**
重启 ganglia monitor 服务

	sudo /etc/init.d/ganglia-monitor restart

   具体参考【6】【7】

效果：

![](http://i.imgur.com/SEvew29.png)


## 1.3.4 配置hadoop metrics设置，连接ganglia集群 ##

  修改Hadoop的配置文件hadoop/etc/hadoop/hadoop-metrics.properties（适用于Ganglia老版本）

	dfs.class=org.apache.hadoop.metrics.ganglia.GangliaContext31
	dfs.period=10
	dfs.servers=192.168.1.50:8649
	
	mapred.class=org.apache.hadoop.metrics.ganglia.GangliaContext31
	mapred.period=10
	mapred.servers=192.168.1.50:8649
	
	jvm.class=org.apache.hadoop.metrics.ganglia.GangliaContext31
	jvm.period=10
	jvm.servers=192.168.1.50:8649
	
	rpc.class=org.apache.hadoop.metrics.ganglia.GangliaContext31
	rpc.period=10
	rpc.servers=192.168.1.50:8649
	
	ugi.class=org.apache.hadoop.metrics.ganglia.GangliaContext31
	ugi.period=10
	ugi.servers=192.168.1.50:8649

(2) 修改Hadoop的配置文件hadoop/etc/hadoop/hadoop-metrics2.properties（适用于Ganglia新版本）

	*.sink.file.class=org.apache.hadoop.metrics2.sink.FileSink
	*.period=10
	*.sink.ganglia.class=org.apache.hadoop.metrics2.sink.ganglia.GangliaSink31
	*.sink.ganglia.period=10
	*.sink.ganglia.slope=jvm.metrics.gcCount=zero,jvm.metrics.memHeapUsedM=both
	*.sink.ganglia.dmax=jvm.metrics.threadsBlocked=70,jvm.metrics.memHeapUsedM=40
	
	namenode.sink.ganglia.servers=192.168.1.50:8649
	datanode.sink.ganglia.servers=192.168.1.50:8649
	resourcemanager.sink.ganglia.servers=192.168.1.50:8649
	nodemanager.sink.ganglia.servers=192.168.1.50:8649
	
	maptask.sink.ganglia.servers=192.168.1.50:8649
	reducetask.sink.ganglia.servers=192.168.1.50:8649
   所有的servers都修改为安装为gmetad的机器IP（Spark-Master），保存完以后将配置文件分发到各个Slave节点的${HADOOP_HOME}/etc/hadoop目录下，重启Hadoop集群即可。

效果：

![](http://i.imgur.com/z22xV9V.png)

**dfs.datanode.BlocksRead：**

![](http://i.imgur.com/gQVoRhh.png)
参考见【8】
## 1.3.5 配置spark metrics设置，连接ganglia集群 ##

## （1）配置环境 ##
由于license问题，spark的bin里面没有自带ganglia，需要自己弄  

方法1： 编译的时候自己加上
mvn -DskipTests -Pspark-ganglia-lgpl -Phadoop-2.6 -Dhadoop.version=2.6.0 clean package

方法2：运行的时候用jar形式加入  
--jars lib/spark-ganglia-lgpl_2.10-x.x.x.jar  ...


## （2）设置spark metrics ##
自行部署spark集群，编辑$SPARK_HOME/conf/metrics.properties文件（没有可以拷贝metrics.properties.template），添加以下内容：
复制代码

	*.sink.ganglia.class=org.apache.spark.metrics.sink.GangliaSink
	*.sink.ganglia.host=spmaster
	*.sink.ganglia.port=8649
	*.sink.ganglia.period=10
	*.sink.ganglia.unit=seconds
	*.sink.ganglia.ttl=1
	*.sink.ganglia.mode=unicast
	*.sink.ganglia.name=unspecified
	
	master.source.jvm.class=org.apache.spark.metrics.source.JvmSource
	worker.source.jvm.class=org.apache.spark.metrics.source.JvmSource
	driver.source.jvm.class=org.apache.spark.metrics.source.JvmSource
	executor.source.jvm.class=org.apache.spark.metrics.source.JvmSource

更改后scp到其它spark节点，启动spark集群。

**(3) 启动服务进行监控**  
启动ganglia的gmetad,gmond以及httpd服务：

	service gmond start
	service gmetad start
	service httpd start

参考见【9】




### 效果： ###

![](http://i.imgur.com/Lz1CUam.png)



参考

	【1】http://spark.apache.org/
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】http://ganglia.info/
	【5】http://www.cnblogs.com/ylks/p/4244532.html
	【6】http://www.linuxidc.com/Linux/2014-08/105838.htm
	【7】http://www.linuxidc.com/Linux/2014-08/105838p2.htm
	【8】http://blog.sina.com.cn/s/blog_8fd85b850102vv5o.html
	【9】http://www.cnblogs.com/czm1032851561/p/5869891.html
	【10】https://github.com/ganglia/ganglia-web/wiki#Installation

