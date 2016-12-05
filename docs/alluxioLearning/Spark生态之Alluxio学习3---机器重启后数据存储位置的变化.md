
1.重启后数据没有在内存里了，由于安装时用的是bin，而且设置的是local，及其重启后需要重启tachyon：

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

2.重启后的数据没在内存，而在local，根据tachyon.env.sh可以知道存储的位置在：

	xubo@xubo:~/cloud/tachyon-0.7.1/underFSStorage/tmp/tachyon/data$ ll -h
	total 114M
	drwxrwxrwt 2 xubo xubo 4.0K May  5 14:02 ./
	drwxrwxr-x 4 xubo xubo 4.0K May  4 22:03 ../
	-rwxrwxrwt 1 xubo xubo   80 May  4 22:19 3*
	-rwxrwxrwt 1 xubo xubo  17K May  4 22:22 4*
	-rwxrwxrwt 1 xubo xubo 114M May  4 22:25 5*
	-rwxrwxrwt 1 xubo xubo   21 May  4 22:29 6*
	xubo@xubo:~/cloud/tachyon-0.7.1/underFSStorage/tmp/tachyon/data$ cat 6 
	hello tachyon
	1
	2
	3


