
更多代码请见：https://github.com/xubo245

Ubuntu学习

1.上传文件

	scp /tmp/test.tar root@192.168.1.190:/home/test.tar

2.下载文件

	scp root@192.168.1.190:/home/test.tar /tmp/test.tar

3.上传整个目录

	scp -r /tmp/testdir root@192.168.1.190:home

4.下载整个目录

	scp -r root@192.168.1.190:home/testdir /tmp

5.断点续传

	rsync -P --rsh=ssh /tmp/test.tar 192.168.1.190:/home/test.tar

6.效果

	xubo@xubo:~/xubo/tools/sap/compare$ rsync -P --rsh=ssh hadoop@Mcnode1:/home/hadoop/disk2/xubo/data/SparkSW/uniref/uniref100Line.fasta ref/uniref100Line.fasta 
	uniref100Line.fasta
	 34,305,501,776 100%   13.86MB/s    0:39:19 (xfr#1, to-chk=0/1)



参考

	【1】https://github.com/xubo245
	【2] http://blog.csdn.net/xubo245/
	【3】http://blog.csdn.net/sysprogram/article/details/52494828
