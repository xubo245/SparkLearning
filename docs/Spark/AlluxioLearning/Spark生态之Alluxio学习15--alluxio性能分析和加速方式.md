
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0
#0 以下分析是主要是基于spark-1.5.2和alluxio-1.3.0分析的，默认不支持数据本地化，所以会有跨节点传输
# 1.解释 #

## 1.1 使用count进行简单数据分析##
	count比较常见，分别对D1Line.fasta等数据集进行分析，

## 1.2 ##


# 2.代码： #

## 2.1 run.sh 脚本##

	for j in 1 2 3 4 5 6
	do
	  sh test.sh 10G  hdfs://Master:9000/xubo/project/SparkSW/input/'D'$j'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	  sh test.sh 10G  alluxio://Master:19998/xubo/project/SparkSW/input/'D'$j'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	  #sh test.sh 10G  alluxio://Master:19998/xubo/project/SparkSW/input/'D'$j'Line.fasta' alluxio://Master:19998/xubo/project/alluxio/output/TimeCount
	done


## 2.2 ##


# 3.结果： #
	
数据越大加速越明显

##第一次
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run.sh 
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fastacount:78295countTime:3.791s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fastacount:78295countTime:4.726s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fastacount:156590countTime:4.001s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fastacount:156590countTime:5.244s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fastacount:313180countTime:4.329s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fastacount:313180countTime:26.376s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fastacount:626360countTime:7.918s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fastacount:626360countTime:6.199s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fastacount:1252720countTime:15.128s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fastacount:1252720countTime:9.661s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fastacount:2505440countTime:15.288s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fastacount:2505440countTime:8.724s
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ rm SparkSW.jar            
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ rz
	rz waiting to receive.
##第二次
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run.sh 
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fastacount:78295countTime:4.092s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fastacount:78295countTime:4.819s
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid21271.log
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fastacount:156590countTime:12.183s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fastacount:313180countTime:10.532s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fastacount:313180countTime:4.685s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fastacount:626360countTime:8.789s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fastacount:626360countTime:26.1s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fastacount:1252720countTime:5.16s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fastacount:1252720countTime:6.694s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fastacount:2505440countTime:19.338s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fastacount:2505440countTime:29.997s
##第三次
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run.sh 
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fastacount:78295countTime:4.335s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fastacount:78295countTime:5.461s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fastacount:156590countTime:4.352s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fastacount:156590countTime:6.373s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fastacount:313180countTime:10.727s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fastacount:313180countTime:6.621s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fastacount:626360countTime:17.001s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fastacount:626360countTime:8.243s
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid25150.log
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fastacount:1252720countTime:21.476s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fastacount:2505440countTime:9.553s
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid25626.log

## 第四次
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run.sh 
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:5.055s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:4.044s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:4.961s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:4.892s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:5.071s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.461s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:9.366s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:15.696s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:17.386s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:6.127s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:41.361s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:7.352s

##问题：
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid25626.log

节点间scp传输速度为10M：

![](http://i.imgur.com/MNpJevk.png)

参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
