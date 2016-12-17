环境
ubuntu 14.04
Spark-1.5.2
Tachyon-0.7.1

1．由于最近用的Spark-1.5.2系统默认的tachyon为0.7.1，在Spark-core的pom.xml可以查看
另外虽然现在Tachyon改名为Alluxio ，但是不影响这个版本的使用

2.单机版搭建：
下载地址：

	https://github.com/Alluxio/alluxio/releases/tag/v0.7.1

下载的是：tachyon-0.7.1-bin.tar.gz

3.安装
修改配置文件：

	cp conf/alluxio-env.sh.template conf/alluxio-env.sh
然后format和start：
	
	 ./bin/alluxio format
	 ./bin/alluxio-start.sh local

查看安装情况：
	
	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ ./tachyon format
	Connecting to localhost as xubo...
	Warning: Permanently added 'localhost' (ECDSA) to the list of known hosts.
	Formatting Tachyon Worker @ xubo
	Connection to localhost closed.
	Formatting Tachyon Master @ localhost
	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ jps
	12576 SparkSubmit
	13760 Jps
	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ ls
	tachyon  tachyon-mount.sh  tachyon-start.sh  tachyon-stop.sh  tachyon-workers.sh
	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ ./tachyon-start.sh local
	Killed 0 processes on xubo
	Killed 0 processes on xubo
	Connecting to localhost as xubo...
	Killed 0 processes on xubo
	Connection to localhost closed.
	[sudo] password for xubo: 
	Formatting RamFS: /mnt/ramdisk (1gb)
	Starting master @ localhost
	Starting worker @ xubo
	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ jps
	12576 SparkSubmit
	14088 Jps
	14058 TachyonWorker
	14030 TachyonMaster
	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ 

可以看出来master和worker已经启动了
另外也可以从浏览器看：

	http://localhost:19999/home
localhost为自己的ip

说明安装成功

4. 使用
（1）指令
	
	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ ./tachyon tfs -help
	Usage: java TFsShell
	       [cat <path>]
	       [count <path>]
	       [ls <path>]
	       [lsr <path>]
	       [mkdir <path>]
	       [rm <path>]
	       [rmr <path>]
	       [tail <path>]
	       [touch <path>]
	       [mv <src> <dst>]
	       [copyFromLocal <src> <remoteDst>]
	       [copyToLocal <src> <localDst>]
	       [fileinfo <path>]
	       [location <path>]
	       [report <path>]
	       [request <tachyonaddress> <dependencyId>]
	       [pin <path>]
	       [unpin <path>]
	       [free <file path|folder path>]
	       [getUsedBytes]
	       [getCapacityBytes]
	       [du <path>]

（2）测试用例
	
	xubo@xubo:~/cloud/tachyon-0.7.1$ ./bin/tachyon runTest Basic CACHE_THROUGH
	/default_tests_files/BasicFile_CACHE_THROUGH has been removed
	2016-05-04 22:19:45,075 INFO   (MasterClient.java:connect) - Tachyon client (version 0.7.1) is trying to connect with master @ localhost/127.0.0.1:19998
	2016-05-04 22:19:45,104 INFO   (MasterClient.java:connect) - User registered with the master @ localhost/127.0.0.1:19998; got UserId 4
	2016-05-04 22:19:45,130 INFO   (CommonUtils.java:printTimeTakenMs) - createFile with fileId 3 took 59 ms.
	2016-05-04 22:19:45,153 INFO   (WorkerClient.java:connect) - Trying to get local worker host : xubo
	2016-05-04 22:19:45,166 INFO   (WorkerClient.java:connect) - Connecting local worker @ xubo/xuboIP:29998
	2016-05-04 22:19:45,230 INFO   (BlockOutStream.java:get) - Writing with local stream. tachyonFile: /default_tests_files/BasicFile_CACHE_THROUGH, blockIndex: 0, opType: CACHE_THROUGH
	2016-05-04 22:19:45,289 INFO   (CommonUtils.java:createBlockPath) - Folder /mnt/ramdisk/tachyonworker/4 was created!
	2016-05-04 22:19:45,294 INFO   (LocalBlockOutStream.java:<init>) - /mnt/ramdisk/tachyonworker/4/3221225472 was created! tachyonFile: /default_tests_files/BasicFile_CACHE_THROUGH, blockIndex: 0, blockId: 3221225472, blockCapacityByte: 536870912
	2016-05-04 22:19:45,370 INFO   (CommonUtils.java:printTimeTakenMs) - writeFile to file /default_tests_files/BasicFile_CACHE_THROUGH took 239 ms.
	2016-05-04 22:19:45,420 INFO   (CommonUtils.java:printTimeTakenMs) - readFile file /default_tests_files/BasicFile_CACHE_THROUGH took 50 ms.
	Passed the test!

（3）从本地上传文件到remote：
	
	xubo@xubo:~/cloud/tachyon-0.7.1$ ./bin/tachyon tfs copyFromLocal pom.xml /
	Copied pom.xml to /
可以在浏览器中查看

（4）显示文件内容：

	xubo@xubo:~/cloud/test/tachyon$ ../../tachyon-0.7.1/bin/tachyon tfs copyFromLocal 1.txt /
	Copied 1.txt to /
	xubo@xubo:~/cloud/test/tachyon$ ../../tachyon-0.7.1/bin/tachyon tfs cat /1.txt
	hello tachyon
	1
	2
	3

（5）Spark调用tachyon文件：待完成，Spark出问题了，请见下一篇博文

（6）关闭tachyon

	hadoop@Master:~/cloud/testByXubo/spark/tachyon/tachyon-0.7.1$ ./bin/tachyon-stop.sh 
	Killed 1 processes on Master
	Killed 1 processes on Master
	Connecting to localhost as hadoop...
	jjKilled 0 processes on Master
	Connection to localhost closed.


附：将tachyon脚本cp到usr的bin下：（需要本地编译，直接start的不行）

	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ sudo cp tachyon /usr/
	bin/     games/   include/ lib/     lib64/   local/   sbin/    share/   src/     
	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ sudo cp tachyon /usr/local/bin/
	xubo@xubo:~/cloud/tachyon-0.7.1/bin$ ta
	tabs        tac         tachyon     tail        tailf       tali        tangle      tap2deb     tap2rpm     tapconvert  tar         tarcat      targen      taskset 
方便使用


参考
【1】http://alluxio.org/documentation/v0.7.1/
【2】https://github.com/xubo245/SparkLearning
【3】http://alluxio.org/documentation/v0.7.1/Running-Tachyon-Locally.html



