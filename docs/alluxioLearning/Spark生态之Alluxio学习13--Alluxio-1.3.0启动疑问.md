
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

# 1.解释 #

## 1.1 alluxio.env.sh 配置##

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


启动：

	hadoop@Master:~/cloud/alluxio-1.3.0/conf$ ../bin/alluxio-stop.sh all
	Killed 0 processes on Master
	Killed 0 processes on Master
	Waiting for WORKERS tasks to finish...
	All WORKERS tasks finished, please analyze the log at /home/hadoop/cloud/alluxio-1.3.0/logs/task.log.
	hadoop@Master:~/cloud/alluxio-1.3.0/conf$ ../bin/alluxio-start.sh all Mount
	/home/hadoop/cloud/alluxio-1.3.0/bin
	Killed 0 processes on Master
	Killed 0 processes on Master
	Waiting for WORKERS tasks to finish...
	All WORKERS tasks finished, please analyze the log at /home/hadoop/cloud/alluxio-1.3.0/logs/task.log.
	Starting master @ Master. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	Waiting for MASTER tasks to finish...
	All MASTER tasks finished, please analyze the log at /home/hadoop/cloud/alluxio-1.3.0/logs/task.log.


## 1.2 启动记录 ##

	2016-11-11 16:35:48,582
	   INFO MASTER  Connecting to Mcnode1 as hadoop...
	2016-11-11 16:35:48,595
	   INFO MASTER  Connecting to Mcnode2 as hadoop...
	2016-11-11 16:35:48,604
	   INFO MASTER  Connecting to Mcnode3 as hadoop...
	2016-11-11 16:35:48,627
	   INFO MASTER  Connecting to Mcnode4 as hadoop...
	2016-11-11 16:35:48,632
	   INFO MASTER  Connecting to Mcnode5 as hadoop...
	2016-11-11 16:35:48,649
	   INFO MASTER  Connecting to Mcnode6 as hadoop...
	2016-11-11 16:35:48,669
	   INFO MASTER  Connecting to Mcnode7 as hadoop...
	/home/hadoop/cloud/alluxio-1.3.0/bin
	/home/hadoop/cloud/alluxio-1.3.0/bin
	/home/hadoop/cloud/alluxio-1.3.0/bin
	Formatting RamFS: /home/hadoop/cloud/alluxio-1.3.0/ramdisk (6gb)
	mount: only root can do that
	Starting worker @ Mcnode1. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	/home/hadoop/cloud/alluxio-1.3.0/bin
	/home/hadoop/cloud/alluxio-1.3.0/bin
	Formatting RamFS: /home/hadoop/cloud/alluxio-1.3.0/ramdisk (6gb)
	mount: only root can do that
	Starting worker @ Mcnode3. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	/home/hadoop/cloud/alluxio-1.3.0/bin
	Formatting RamFS: /home/hadoop/cloud/alluxio-1.3.0/ramdisk (6gb)
	mount: only root can do that
	Starting worker @ Mcnode2. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	/home/hadoop/cloud/alluxio-1.3.0/bin
	Formatting RamFS: /home/hadoop/cloud/alluxio-1.3.0/ramdisk (6gb)
	mount: only root can do that
	Formatting RamFS: /home/hadoop/cloud/alluxio-1.3.0/ramdisk (6gb)
	Starting worker @ Mcnode4. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	mount: only root can do that
	Starting worker @ Mcnode5. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	Formatting RamFS: /home/hadoop/cloud/alluxio-1.3.0/ramdisk (6gb)
	Formatting RamFS: /home/hadoop/cloud/alluxio-1.3.0/ramdisk (6gb)
	mount: only root can do that
	mount: only root can do that
	Starting worker @ Mcnode6. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	Starting worker @ Mcnode7. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	Connection to mcnode1 closed.
	Connection to mcnode3 closed.
	Connection to mcnode2 closed.
	Connection to mcnode4 closed.
	Connection to mcnode5 closed.
	Connection to mcnode6 closed.
	Connection to mcnode7 closed.


# 2.疑问： #
显示mount: only root can do that
有问题吗？
不确定会不会有影响

但是加sudo启动不了

	hadoop@Master:~/cloud/alluxio-1.3.0/conf$ ../bin/alluxio-start.sh all SudoMount
	/home/hadoop/cloud/alluxio-1.3.0/bin
	Killed 0 processes on Master
	Killed 0 processes on Master
	Waiting for WORKERS tasks to finish...
	All WORKERS tasks finished, please analyze the log at /home/hadoop/cloud/alluxio-1.3.0/logs/task.log.
	Starting master @ Master. Logging to /home/hadoop/cloud/alluxio-1.3.0/logs
	Waiting for MASTER tasks to finish...

task.log：

	2016-11-11 16:33:40,423
	   INFO MASTER  Connecting to Mcnode1 as hadoop...
	2016-11-11 16:33:40,435
	   INFO MASTER  Connecting to Mcnode2 as hadoop...
	2016-11-11 16:33:40,444
	   INFO MASTER  Connecting to Mcnode3 as hadoop...
	2016-11-11 16:33:40,463
	   INFO MASTER  Connecting to Mcnode4 as hadoop...
	2016-11-11 16:33:40,480
	   INFO MASTER  Connecting to Mcnode5 as hadoop...
	2016-11-11 16:33:40,486
	   INFO MASTER  Connecting to Mcnode6 as hadoop...
	2016-11-11 16:33:40,526
	   INFO MASTER  Connecting to Mcnode7 as hadoop...
	/home/hadoop/cloud/alluxio-1.3.0/bin
	/home/hadoop/cloud/alluxio-1.3.0/bin
	/home/hadoop/cloud/alluxio-1.3.0/bin
	/home/hadoop/cloud/alluxio-1.3.0/bin
	/home/hadoop/cloud/alluxio-1.3.0/bin
	/home/hadoop/cloud/alluxio-1.3.0/bin
	[sudo] password for hadoop: [sudo] password for hadoop: /home/hadoop/cloud/alluxio-1.3.0/bin
	[sudo] password for hadoop: [sudo] password for hadoop: [sudo] password for hadoop: [sudo] password for hadoop: [sudo] password for hadoop: 2016-11-11 16:35:40,728
	

参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
