更多代码请见：https://github.com/xubo245/SparkLearning
环境：
hadoop-2.6.0
spark-1.5.2
scala-1.7


1解释
完成tachyon的集群配置与运行
前提：安装好java、hdfs等

2.下载

	https://github.com/Alluxio/alluxio/releases
具体的：

	https://github.com/Alluxio/alluxio/releases/download/v0.7.1/tachyon-0.7.1-hadoop2.6-bin.tar.gz

如果下载tachyon-0.7.1-bin.tar.g会出现版本不兼容，会报错：

	Server IPC version 9 cannot communicate with client version 4

3.配置：【3】讲的比较详细
在conf/tachyon-env.sh配置：

	export TACHYON_MASTER_ADDRESS=<strong>Master</strong>
	#export TACHYON_UNDERFS_ADDRESS=$TACHYON_HOME/underFSStorage
	export TACHYON_UNDERFS_ADDRESS=hdfs://<span style="font-family: Arial, Helvetica, sans-serif; font-size: 12px;"><strong>Master</strong></span>:9000
	export TACHYON_WORKER_MEMORY_SIZE=256MB

Master为集群master IP，或者自己在本地设置好映射

4.安装：

	$ cd tachyon
	$ ./bin/tachyon format
	$ ./bin/tachyon-start.sh # use the right parameters here. e.g. all Mount
一般start需要sudo才能mount：

	./bin/tachyon-start.sh all SudoMount

每个节点都要输入密码，好麻烦

5.查看：
在Master的19999端口可以查看，六个worker启动了三个，
解决办法：http://blog.csdn.net/xubo245/article/details/53056482

6.使用：
上传：

	hadoop@Master:~/cloud/tachyon-0.7.1-hadoop2.6-bin$ ./bin/tachyon tfs copyFromLocal test/2.txt /
	Copied test/2.txt to /

展示没问题


7.记录
ipc版本不同：
	
	hadoop@Master:~/cloud/tachyon-0.7.1$ ./bin/tachyon format
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
	/home/hadoop/cloud/tachyon-0.7.1/bin/tachyon: line 264: /../bin/java: No such file or directory
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting Tachyon Worker @ Mcnode4
	/home/hadoop/cloud/tachyon-0.7.1/bin/tachyon: line 264: /../bin/java: No such file or directory
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting Tachyon Worker @ Mcnode5
	/home/hadoop/cloud/tachyon-0.7.1/bin/tachyon: line 264: /../bin/java: No such file or directory
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Formatting Tachyon Worker @ Mcnode6
	Connection to mcnode6 closed.
	Formatting Tachyon Master @ localhost
	Exception in thread "main" java.lang.IllegalArgumentException: All eligible Under File Systems were unable to create an instance for the given path: hdfs://Master:9000/tmp/tachyon/data
	java.lang.RuntimeException: org.apache.hadoop.ipc.RemoteException: Server IPC version 9 cannot communicate with client version 4

		at tachyon.underfs.UnderFileSystemRegistry.create(UnderFileSystemRegistry.java:132)
		at tachyon.underfs.UnderFileSystem.get(UnderFileSystem.java:99)
		at tachyon.underfs.UnderFileSystem.get(UnderFileSystem.java:83)
		at tachyon.Format.formatFolder(Format.java:38)
		at tachyon.Format.main(Format.java:77)



参考
【1】http://alluxio.org/documentation/v0.7.1/
【2】https://github.com/xubo245/SparkLearning
【3】 http://alluxio.org/documentation/v0.7.1/Running-Tachyon-on-a-Cluster.html
