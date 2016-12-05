六个worker只启动了3个：
	
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
	hadoop@Master:~/cloud/alluxio-0.7.1$ ./bin/tachyon-start.sh all Mount
	Killed 0 processes on Master
	Killed 0 processes on Master
	Connecting to Mcnode1 as hadoop...
	Killed 0 processes on Mcnode1
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	Killed 0 processes on Mcnode2
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode3
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode4
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode5
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Killed 0 processes on Mcnode6
	Connection to mcnode6 closed.
	Starting master @ Master
	Connecting to Mcnode1 as hadoop...
	Formatting RamFS: /mnt/ramdisk (256mb)
	umount: only root can do that
	ERROR: umount RamFS /mnt/ramdisk failed
	Mount failed, not starting worker
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	Formatting RamFS: /mnt/ramdisk (256mb)
	umount: only root can do that
	ERROR: umount RamFS /mnt/ramdisk failed
	Mount failed, not starting worker
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	TACHYON_LOGS_DIR: /home/hadoop/cloud/alluxio-0.7.1/logs
	Formatting RamFS: /mnt/ramdisk (256mb)
	umount: only root can do that
	ERROR: umount RamFS /mnt/ramdisk failed
	Mount failed, not starting worker
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	TACHYON_LOGS_DIR: /home/hadoop/cloud/alluxio-0.7.1/logs
	Formatting RamFS: /mnt/ramdisk (256mb)
	umount: only root can do that
	ERROR: umount RamFS /mnt/ramdisk failed
	Mount failed, not starting worker
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	TACHYON_LOGS_DIR: /home/hadoop/cloud/alluxio-0.7.1/logs
	Formatting RamFS: /mnt/ramdisk (256mb)
	umount: only root can do that
	ERROR: umount RamFS /mnt/ramdisk failed
	Mount failed, not starting worker
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Formatting RamFS: /mnt/ramdisk (256mb)
	umount: only root can do that
	ERROR: umount RamFS /mnt/ramdisk failed
	Mount failed, not starting worker
	Connection to mcnode6 closed.
	hadoop@Master:~/cloud/alluxio-0.7.1$ ./bin/tachyon-start.sh all SudoMount
	Killed 1 processes on Master
	Killed 0 processes on Master
	Connecting to Mcnode1 as hadoop...
	Killed 0 processes on Mcnode1
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	Killed 0 processes on Mcnode2
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode3
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode4
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode5
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Killed 0 processes on Mcnode6
	Connection to mcnode6 closed.
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
	dirname: missing operand
	Try 'dirname --help' for more information.
	[sudo] password for hadoop: 
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode3
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	[sudo] password for hadoop: 
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode4
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	[sudo] password for hadoop: 
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode5
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	[sudo] password for hadoop: 
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting worker @ Mcnode6
	Connection to mcnode6 closed.
	hadoop@Master:~/cloud/alluxio-0.7.1$ 
	hadoop@Master:~/cloud/alluxio-0.7.1$ jps
	30101 SparkSubmit
	17541 ResourceManager
	2526 TachyonMaster
	17389 SecondaryNameNode
	27677 CoarseGrainedExecutorBackend
	2610 Jps
	17173 NameNode
	17935 Master
	18125 Worker
	1450 SparkSubmit
	27574 SparkSubmit
	3528 HistoryServer


解决办法：
方法1：
在每个节点各自启动，可以将所有节点启动，在master的19999可以看到：
	
	Last login: Thu May  5 20:26:04 2016 from mcnode4
	hadoop@Mcnode5:~$ cd cloud/alluxio-0.7.1/bin/
	hadoop@Mcnode5:~/cloud/alluxio-0.7.1/bin$ ./tachyon-start.sh local
	Killed 0 processes on Mcnode5
	Killed 0 processes on Mcnode5
	Connecting to Mcnode1 as hadoop...
	Killed 1 processes on Mcnode1
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	Killed 1 processes on Mcnode2
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	Warning: Permanently added 'mcnode3,219.219.220.131' (ECDSA) to the list of known hosts.
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode3
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 1 processes on Mcnode4
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	Warning: Permanently added 'mcnode5,219.219.220.215' (ECDSA) to the list of known hosts.
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode5
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Killed 1 processes on Mcnode6
	Connection to mcnode6 closed.
	[sudo] password for hadoop: 
	dirname: missing operand
	Try 'dirname --help' for more information.
	Formatting RamFS: /mnt/ramdisk (256mb)
	Starting master @ Master
	Starting worker @ Mcnode5



但是上传一个文件后又报错：
	
	hadoop@Mcnode3:~/cloud/tachyon-0.7.1-hadoop2.6-bin$ jps
	Error occurred during initialization of VM
	java.lang.Error: Properties init: Could not determine current working directory.
		at java.lang.System.initProperties(Native Method)
		at java.lang.System.initializeSystemClass(System.java:1119)

关闭集群：
	
	hadoop@Master:~/cloud/tachyon-0.7.1-hadoop2.6-bin$ ./bin/tachyon-stop.sh 
	Killed 1 processes on Master
	Killed 0 processes on Master
	Connecting to Mcnode1 as hadoop...
	Killed 1 processes on Mcnode1
	Connection to mcnode1 closed.
	Connecting to Mcnode2 as hadoop...
	Killed 1 processes on Mcnode2
	Connection to mcnode2 closed.
	Connecting to Mcnode3 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode3
	Connection to mcnode3 closed.
	Connecting to Mcnode4 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 0 processes on Mcnode4
	Connection to mcnode4 closed.
	Connecting to Mcnode5 as hadoop...
	dirname: missing operand
	Try 'dirname --help' for more information.
	Killed 1 processes on Mcnode5
	Connection to mcnode5 closed.
	Connecting to Mcnode6 as hadoop...
	Killed 1 processes on Mcnode6
	Connection to mcnode6 closed.

方法2：可以启动全部节点

	http://blog.csdn.net/xubo245/article/details/53056482

