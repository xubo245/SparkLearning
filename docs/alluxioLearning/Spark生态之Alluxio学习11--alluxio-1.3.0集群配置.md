
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

在spark上运行alluxio请参考下一个博客

# 1.解释 #

## 1.1 下载##

	wget http://alluxio.org/downloads/files/1.3.0/alluxio-1.3.0-bin.tar.gz
	tar xvfz alluxio-1.3.0-bin.tar.gz
## 1.2 配置##
复制

	cp conf/alluxio-env.sh.template conf/alluxio-env.sh

修改：	
	vi conf/alluxio-env.sh
修改内容：

	# The directory where Alluxio deployment is installed. (Default: the parent directory of libexec/).
	# ALLUXIO_HOME
	export ALLUXIO_HOME=/home/hadoop/cloud/alluxio-1.3.0
	
	# The directory where log files are stored. (Default: ${ALLUXIO_HOME}/logs).
	# ALLUXIO_LOGS_DIR
	
	# Hostname of the master.
	# ALLUXIO_MASTER_HOSTNAME
	export  ALLUXIO_MASTER_HOSTNAME=Master
	
	# This is now deprecated. Support will be removed in v2.0
	# ALLUXIO_MASTER_ADDRESS
	
	# The directory where a worker stores in-memory data. (Default: /mnt/ramdisk).
	# E.g. On linux,  /mnt/ramdisk for ramdisk, /dev/shm for tmpFS; on MacOS, /Volumes/ramdisk for ramdisk
	# ALLUXIO_RAM_FOLDER
	export ALLUXIO_RAM_FOLDER=/home/hadoop/cloud/alluxio-1.3.0/ramdisk
	
	# Address of the under filesystem address. (Default: ${ALLUXIO_HOME}/underFSStorage)
	# E.g. "/my/local/path" to use local fs, "hdfs://localhost:9000/alluxio" to use a local hdfs
	# ALLUXIO_UNDERFS_ADDRESS
	export ALLUXIO_UNDERFS_ADDRESS=hdfs://Master:9000
	
	# How much memory to use per worker. (Default: 1GB)
	# E.g. "1000MB", "2GB"
	# ALLUXIO_WORKER_MEMORY_SIZE
	export ALLUXIO_WORKER_MEMORY_SIZE=6GB

保存，scp到集群中每个节点

## 1.3 启动##

	hadoop@Master:~/cloud/alluxio-1.3.0$ ./bin/alluxio format
	Waiting for MASTER tasks to finish...
	All MASTER tasks finished, please analyze the log at /home/hadoop/cloud/alluxio-1.3.0/logs/task.log.
	Formatting Alluxio Master @ Master
	hadoop@Master:~/cloud/alluxio-1.3.0$ ./bin/alluxio-start.sh all Mount
	/home/hadoop/cloud/alluxio-1.3.0/bin
	Killed 1 processes on Master
	Killed 0 processes on Master
	Waiting for WORKERS tasks to finish...
	All WORKERS tasks finished, please analyze the log at /home/hadoop/cloud/alluxio-1.3.0/logs/task.log.
	Starting master @ Master. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	Waiting for MASTER tasks to finish...
	All MASTER tasks finished, please analyze the log at /home/hadoop/cloud/alluxio-1.3.0/logs/task.log.

# 3.结果： #

![](http://i.imgur.com/J5IjaLM.png)

alluxio fs 等命令测试可以用

	hadoop@Mcnode1:~/disk2/xubo/data/SparkSW/uniref$ time cat D6Line.fasta |grep -c GC
	618260
	
	real	0m6.313s
	user	0m6.169s
	sys	0m1.056s
	hadoop@Mcnode1:~/disk2/xubo/data/SparkSW/uniref$ time ~/cloud/alluxio-1.3.0/bin/alluxio fs cat /D6Line.fasta |grep -c GC
	618260
	
	real	0m7.725s
	user	0m9.663s
	sys	0m1.247s


测试：
	
	hadoop@Master:~/cloud/alluxio-1.3.0$ ./bin/alluxio runTests
	2016-11-09 23:23:10,739 INFO  type (MetricsSystem.java:startSinksFromConfig) - Starting sinks with config: {}.
	2016-11-09 23:23:10,742 INFO  type (MetricsSystem.java:startSinks) - Sinks have already been started.
	2016-11-09 23:23:10,843 INFO  type (AbstractClient.java:connect) - Alluxio client (version 1.3.0) is trying to connect with FileSystemMasterClient master @ Master/219.219.220.149:19998
	2016-11-09 23:23:10,868 INFO  type (AbstractClient.java:connect) - Client registered with FileSystemMasterClient master @ Master/219.219.220.149:19998
	runTest Basic CACHE_PROMOTE MUST_CACHE
	2016-11-09 23:23:11,088 INFO  type (AbstractClient.java:connect) - Alluxio client (version 1.3.0) is trying to connect with BlockMasterClient master @ Master/219.219.220.149:19998
	2016-11-09 23:23:11,090 INFO  type (AbstractClient.java:connect) - Client registered with BlockMasterClient master @ Master/219.219.220.149:19998
	2016-11-09 23:23:11,209 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@8408396
	2016-11-09 23:23:11,315 INFO  type (NettyChannelPool.java:createNewResource) - Created netty channel to with netty boostrap alluxio.client.block.BlockStoreContext$2@5087f4d0.
	2016-11-09 23:23:11,406 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@62b3a353
	2016-11-09 23:23:11,461 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_CACHE_PROMOTE_MUST_CACHE took 472 ms.
	2016-11-09 23:23:11,567 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_CACHE_PROMOTE_MUST_CACHE took 106 ms.
	Passed the test!
	runTest BasicNonByteBuffer CACHE_PROMOTE MUST_CACHE
	2016-11-09 23:23:11,600 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@6dd8ade8
	2016-11-09 23:23:11,611 INFO  type (NettyChannelPool.java:createNewResource) - Created netty channel to with netty boostrap alluxio.client.block.BlockStoreContext$2@4aaf32dc.
	2016-11-09 23:23:11,682 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@18607df6
	2016-11-09 23:23:11,699 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_CACHE_PROMOTE_MUST_CACHE took 114 ms.
	2016-11-09 23:23:11,755 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_CACHE_PROMOTE_MUST_CACHE took 56 ms.
	Passed the test!
	runTest Basic CACHE_PROMOTE CACHE_THROUGH
	2016-11-09 23:23:11,806 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@32c81878
	2016-11-09 23:23:11,825 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@2928fd34
	2016-11-09 23:23:11,990 INFO  type (NettyChannelPool.java:createNewResource) - Created netty channel to with netty boostrap alluxio.client.block.BlockStoreContext$2@7ae5fdad.
	2016-11-09 23:23:12,397 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_CACHE_PROMOTE_CACHE_THROUGH took 637 ms.
	2016-11-09 23:23:12,408 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_CACHE_PROMOTE_CACHE_THROUGH took 10 ms.
	Passed the test!
	runTest BasicNonByteBuffer CACHE_PROMOTE CACHE_THROUGH
	2016-11-09 23:23:12,422 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@9d14a9
	2016-11-09 23:23:12,435 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@7fe96694
	2016-11-09 23:23:12,587 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@366872f6
	2016-11-09 23:23:12,597 INFO  type (NettyChannelPool.java:createNewResource) - Created netty channel to with netty boostrap alluxio.client.block.BlockStoreContext$2@414ad9fb.
	2016-11-09 23:23:13,006 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@65c83981
	2016-11-09 23:23:13,022 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_CACHE_PROMOTE_CACHE_THROUGH took 442 ms.
	2016-11-09 23:23:13,057 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_CACHE_PROMOTE_CACHE_THROUGH took 35 ms.
	Passed the test!
	runTest Basic CACHE_PROMOTE THROUGH
	2016-11-09 23:23:13,070 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@a4f5b6d
	2016-11-09 23:23:13,082 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@6de4f076
	2016-11-09 23:23:13,231 INFO  type (NettyChannelPool.java:createNewResource) - Created netty channel to with netty boostrap alluxio.client.block.BlockStoreContext$2@34aa287f.
	2016-11-09 23:23:13,614 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_CACHE_PROMOTE_THROUGH took 556 ms.
	2016-11-09 23:23:13,660 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@5ee179dc
	2016-11-09 23:23:13,674 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@6f860b23
	2016-11-09 23:23:13,907 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_CACHE_PROMOTE_THROUGH took 292 ms.
	Passed the test!
	runTest BasicNonByteBuffer CACHE_PROMOTE THROUGH
	2016-11-09 23:23:13,917 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@aa1e2a5
	2016-11-09 23:23:13,928 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@7713c735
	2016-11-09 23:23:14,423 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_CACHE_PROMOTE_THROUGH took 352 ms.
	2016-11-09 23:23:14,472 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@633e5715
	2016-11-09 23:23:14,537 INFO  type (NettyChannelPool.java:createNewResource) - Created netty channel to with netty boostrap alluxio.client.block.BlockStoreContext$2@b14de02.
	2016-11-09 23:23:14,610 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@65a714ff
	2016-11-09 23:23:14,624 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_CACHE_PROMOTE_THROUGH took 201 ms.
	Passed the test!
	runTest Basic CACHE_PROMOTE ASYNC_THROUGH
	2016-11-09 23:23:14,633 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@4f4fe346
	2016-11-09 23:23:14,664 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@5a62681b
	2016-11-09 23:23:14,707 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_CACHE_PROMOTE_ASYNC_THROUGH took 82 ms.
	2016-11-09 23:23:14,744 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_CACHE_PROMOTE_ASYNC_THROUGH took 37 ms.
	Passed the test!
	runTest BasicNonByteBuffer CACHE_PROMOTE ASYNC_THROUGH
	2016-11-09 23:23:14,763 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_CACHE_PROMOTE_ASYNC_THROUGH took 14 ms.
	2016-11-09 23:23:14,773 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_CACHE_PROMOTE_ASYNC_THROUGH took 10 ms.
	Passed the test!
	runTest Basic CACHE MUST_CACHE
	2016-11-09 23:23:14,786 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_CACHE_MUST_CACHE took 12 ms.
	2016-11-09 23:23:14,794 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_CACHE_MUST_CACHE took 8 ms.
	Passed the test!
	runTest BasicNonByteBuffer CACHE MUST_CACHE
	2016-11-09 23:23:14,806 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@2a37801c
	2016-11-09 23:23:14,834 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@47089c2c
	2016-11-09 23:23:14,852 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_CACHE_MUST_CACHE took 52 ms.
	2016-11-09 23:23:14,880 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_CACHE_MUST_CACHE took 28 ms.
	Passed the test!
	runTest Basic CACHE CACHE_THROUGH
	2016-11-09 23:23:15,195 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_CACHE_CACHE_THROUGH took 314 ms.
	2016-11-09 23:23:15,220 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_CACHE_CACHE_THROUGH took 25 ms.
	Passed the test!
	runTest BasicNonByteBuffer CACHE CACHE_THROUGH
	2016-11-09 23:23:15,325 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_CACHE_CACHE_THROUGH took 73 ms.
	2016-11-09 23:23:15,336 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_CACHE_CACHE_THROUGH took 11 ms.
	Passed the test!
	runTest Basic CACHE THROUGH
	2016-11-09 23:23:15,412 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_CACHE_THROUGH took 75 ms.
	2016-11-09 23:23:15,534 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_CACHE_THROUGH took 122 ms.
	Passed the test!
	runTest BasicNonByteBuffer CACHE THROUGH
	2016-11-09 23:23:15,549 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@7ef30fce
	2016-11-09 23:23:15,561 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.FileSystemWorkerClientService$Client@3b4d67bb
	2016-11-09 23:23:15,715 INFO  type (NettyChannelPool.java:createNewResource) - Created netty channel to with netty boostrap alluxio.client.block.BlockStoreContext$2@2bf9bcc6.
	2016-11-09 23:23:16,130 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_CACHE_THROUGH took 417 ms.
	2016-11-09 23:23:16,277 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_CACHE_THROUGH took 146 ms.
	Passed the test!
	runTest Basic CACHE ASYNC_THROUGH
	2016-11-09 23:23:16,285 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@43036682
	2016-11-09 23:23:16,309 INFO  type (ThriftClientPool.java:createNewResource) - Created a new thrift client alluxio.thrift.BlockWorkerClientService$Client@5051f26e
	2016-11-09 23:23:16,326 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_CACHE_ASYNC_THROUGH took 48 ms.
	2016-11-09 23:23:16,350 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_CACHE_ASYNC_THROUGH took 23 ms.
	Passed the test!
	runTest BasicNonByteBuffer CACHE ASYNC_THROUGH
	2016-11-09 23:23:16,362 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_CACHE_ASYNC_THROUGH took 9 ms.
	2016-11-09 23:23:16,370 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_CACHE_ASYNC_THROUGH took 7 ms.
	Passed the test!
	runTest Basic NO_CACHE MUST_CACHE
	2016-11-09 23:23:16,382 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_NO_CACHE_MUST_CACHE took 12 ms.
	2016-11-09 23:23:16,389 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_NO_CACHE_MUST_CACHE took 7 ms.
	Passed the test!
	runTest BasicNonByteBuffer NO_CACHE MUST_CACHE
	2016-11-09 23:23:16,401 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_NO_CACHE_MUST_CACHE took 9 ms.
	2016-11-09 23:23:16,412 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_NO_CACHE_MUST_CACHE took 11 ms.
	Passed the test!
	runTest Basic NO_CACHE CACHE_THROUGH
	2016-11-09 23:23:16,543 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_NO_CACHE_CACHE_THROUGH took 130 ms.
	2016-11-09 23:23:16,552 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_NO_CACHE_CACHE_THROUGH took 9 ms.
	Passed the test!
	runTest BasicNonByteBuffer NO_CACHE CACHE_THROUGH
	2016-11-09 23:23:16,651 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_NO_CACHE_CACHE_THROUGH took 66 ms.
	2016-11-09 23:23:16,675 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_NO_CACHE_CACHE_THROUGH took 23 ms.
	Passed the test!
	runTest Basic NO_CACHE THROUGH
	2016-11-09 23:23:16,745 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_NO_CACHE_THROUGH took 69 ms.
	2016-11-09 23:23:16,813 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_NO_CACHE_THROUGH took 68 ms.
	Passed the test!
	runTest BasicNonByteBuffer NO_CACHE THROUGH
	2016-11-09 23:23:16,887 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_NO_CACHE_THROUGH took 52 ms.
	2016-11-09 23:23:16,961 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_NO_CACHE_THROUGH took 74 ms.
	Passed the test!
	runTest Basic NO_CACHE ASYNC_THROUGH
	2016-11-09 23:23:16,974 INFO  type (BasicOperations.java:writeFile) - writeFile to file /default_tests_files/Basic_NO_CACHE_ASYNC_THROUGH took 12 ms.
	2016-11-09 23:23:16,982 INFO  type (BasicOperations.java:readFile) - readFile file /default_tests_files/Basic_NO_CACHE_ASYNC_THROUGH took 8 ms.
	Passed the test!
	runTest BasicNonByteBuffer NO_CACHE ASYNC_THROUGH
	2016-11-09 23:23:17,005 INFO  type (BasicNonByteBufferOperations.java:write) - writeFile to file /default_tests_files/BasicNonByteBuffer_NO_CACHE_ASYNC_THROUGH took 19 ms.
	2016-11-09 23:23:17,012 INFO  type (BasicNonByteBufferOperations.java:read) - readFile file /default_tests_files/BasicNonByteBuffer_NO_CACHE_ASYNC_THROUGH took 7 ms.
	Passed the test!
	hadoop@Master:~/cloud/alluxio-1.3.0$ 


参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
	【5】http://www.cnblogs.com/seaspring/p/5726695.html
