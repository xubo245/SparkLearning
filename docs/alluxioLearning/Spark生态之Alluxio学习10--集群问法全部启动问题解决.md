
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio（tachyon） 0.7.1，spark-1.5.2,hadoop-2.6.0

# 1.解释 #
## 1.1 问题描述 ##

之前博文没有解决的问题：http://blog.csdn.net/xubo245/article/details/51325834

具体：

	hadoop@Master:~/cloud/alluxio-0.7.1$ ./bin/tachyon format
	Connecting to Mcnode1 as hadoop...
	Formatting Tachyon Worker @ Mcnode1
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	Formatting Tachyon Worker @ Mcnode2
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting Tachyon Worker @ Mcnode3
	/home/hadoop/cloud/alluxio-0.7.1/bin/tachyon: line 264: /../bin/java: No such file or directory
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting Tachyon Worker @ Mcnode4
	/home/hadoop/cloud/alluxio-0.7.1/bin/tachyon: line 264: /../bin/java: No such file or directory
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting Tachyon Worker @ Mcnode5
	/home/hadoop/cloud/alluxio-0.7.1/bin/tachyon: line 264: /../bin/java: No such file or directory
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Formatting Tachyon Worker @ Mcnode6
	Connection to mcnode6 closed.
	Formatting Tachyon Master @ Master
## 1.2分析： ##

  主要是没有bin/java,因为Mcnode3，4，5节点在/usr/bin和/usr/local/bin没有java，java和javac在其他位置，而alluxio调用的是/usr/bin路径下的指令

## 1.3 解决办法 ##

	sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.7.0/bin/java 300
	sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk1.7.0/bin/javac 300

## 1.4 解决效果： ##
    将第五个节点按照解决办法处理后，就没有报错了：

	hadoop@Master:~/cloud/alluxio-0.7.1$ ./bin/tachyon format
	Connecting to Mcnode1 as hadoop...
	Formatting Tachyon Worker @ Mcnode1
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	Formatting Tachyon Worker @ Mcnode2
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting Tachyon Worker @ Mcnode3
	/home/hadoop/cloud/alluxio-0.7.1/bin/tachyon: line 264: /../bin/java: No such file or directory
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting Tachyon Worker @ Mcnode4
	/home/hadoop/cloud/alluxio-0.7.1/bin/tachyon: line 264: /../bin/java: No such file or directory
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	Formatting Tachyon Worker @ Mcnode5
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Formatting Tachyon Worker @ Mcnode6
	Connection to mcnode6 closed.
	Formatting Tachyon Master @ Master



# 2.代码： #

## 2.1 解决办法 ##

	sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.7.0/bin/java 300
	sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk1.7.0/bin/javac 300

## 2.2 运行结果 ##

	hadoop@Mcnode3:~/cloud/alluxio-0.7.1$ sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.7.0/bin/java 300
	[sudo] password for hadoop: 
	update-alternatives: using /usr/lib/jvm/jdk1.7.0/bin/java to provide /usr/bin/java (java) in auto mode
	hadoop@Mcnode3:~/cloud/alluxio-0.7.1$ sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk1.7.0/bin/javac 300
	update-alternatives: using /usr/lib/jvm/jdk1.7.0/bin/javac to provide /usr/bin/javac (javac) in auto mode
	hadoop@Mcnode3:~/cloud/alluxio-0.7.1$ 

# 3.结果： #

都按照解决办法解决：截图在本周的周报中
	
	hadoop@Master:~/cloud/alluxio-0.7.1$ ./bin/tachyon format
	Connecting to Mcnode1 as hadoop...
	Formatting Tachyon Worker @ Mcnode1
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	Formatting Tachyon Worker @ Mcnode2
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	Formatting Tachyon Worker @ Mcnode3
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	Formatting Tachyon Worker @ Mcnode4
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	Formatting Tachyon Worker @ Mcnode5
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Formatting Tachyon Worker @ Mcnode6
	Connection to mcnode6 closed.
	Connecting to Mcnode7 as hadoop...
	Formatting Tachyon Worker @ Mcnode7
	Connection to mcnode7 closed.
	Formatting Tachyon Master @ Master
	hadoop@Master:~/cloud/alluxio-0.7.1$ ./bin/tachyon-start.sh all SudoMount
	Killed 1 processes on Master
	Killed 0 processes on Master
	Connecting to Mcnode1 as hadoop...
	Killed 1 processes on Mcnode1
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	Killed 1 processes on Mcnode2
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	Killed 0 processes on Mcnode3
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	Killed 0 processes on Mcnode4
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	Killed 1 processes on Mcnode5
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Killed 1 processes on Mcnode6
	Connection to mcnode6 closed.
	Connecting to Mcnode7 as hadoop...
	Killed 0 processes on Mcnode7
	Connection to mcnode7 closed.
	Starting master @ Master
	Connecting to Mcnode1 as hadoop...
	[sudo] password for hadoop: 
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode1
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	[sudo] password for hadoop: 
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode2
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	[sudo] password for hadoop: 
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode3
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	[sudo] password for hadoop: 
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode4
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	[sudo] password for hadoop: 
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode5
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	[sudo] password for hadoop: 
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode6
	Connection to mcnode6 closed.
	Connecting to Mcnode7 as hadoop...
	[sudo] password for hadoop: 
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode7
	Connection to mcnode7 closed.
	hadoop@Master:~/cloud/alluxio-0.7.1$ 


参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
	【5】http://blog.csdn.net/edwzhang/article/details/7759933
