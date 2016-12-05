
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

#0 以下分析是主要是基于spark-1.5.2和alluxio-1.3.0分析的，默认不支持数据本地化，所以会有跨节点传输

# 1.解释 #

## 1.1 问题##
   当将文件通过fs copyFromLocal传到alluxio时，开始8台大概是16G左右，但是多次运行	Space Usage会增加，即使每增加新文件。
   不知道alluxio里面的实现机制是什么？

# 2.代码： #

## 2.1 run.sh##

	#~/cloud/alluxio-1.3.0/bin/alluxio fs mkdir -p /xubo/project/SparkSW/input/
	for j in 1 2 3 4 5 6 7 8 9
	do
	  sh test.sh 10G  hdfs://Master:9000/xubo/project/SparkSW/input/'D'$j'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	  sh test.sh 10G  alluxio://Master:19998/xubo/alluxio/uniref/'D'$j'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	  #sh test.sh 10G  alluxio://Master:19998/xubo/project/SparkSW/input/'D'$j'Line.fasta' alluxio://Master:19998/xubo/project/alluxio/output/TimeCount
	done
	~        

## 2.2 test.sh##

test.sh文件是一个读取并进行count的脚本

# 3.结果： #
## 3.1 运行前
copyFromLocal之后：总共16G左右
![](http://i.imgur.com/Stqg6ow.png)
##第一次运行
第一次运行count后，明显增加，总共32G左右
![](http://i.imgur.com/fHNRu6h.png)
	
运行记录

	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run.sh 
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:9.706s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:7.656s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:6.719s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:15.477s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:5.013s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:16.75s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:7.942s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:17.642s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:26.711s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:31.092s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:15.409s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:73.364s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:35.338s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:64.195s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:87.111s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:76.951s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:132.447s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:190.699s

ganglia中明显可以看到network开销：

![](http://i.imgur.com/Hfi0wLv.png)

##第二次运行
![](http://i.imgur.com/deHFlpJ.png)
运行记录

	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run.sh 
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:9.706s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:7.656s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:6.719s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:15.477s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:5.013s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:16.75s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:7.942s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:17.642s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:26.711s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:31.092s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:15.409s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:73.364s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:35.338s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:64.195s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:87.111s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:76.951s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:132.447s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:190.699s
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run.sh 
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:5.355s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:7.633s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:3.989s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.384s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.478s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.671s
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid13258.log
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:8.492s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:6.681s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:11.47s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:8.213s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:21.302s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:45.31s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:30.39s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:63.646s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:69.009s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:96.257s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:129.645s


第三次：

![](http://i.imgur.com/Y8LZKs9.png)

![](http://i.imgur.com/BB8I8U4.png)
	
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run.sh 
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:4.205s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.907s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:6.637s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.212s
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid17054.log
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:6.732s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:17.264s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:9.099s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:26.775s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:30.943s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:18.174s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:17.044s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:45.236s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:36.763s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:61.551s
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:73.987s
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid19730.log
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:139.039s

## 第N次后：
###总共：
![](http://i.imgur.com/Sev5mEY.png)
###Mcnode1:
![](http://i.imgur.com/VFcl9Tr.png)
###Mcnode2:
![](http://i.imgur.com/Pycc7Ib.png)
###Mcnode3:
![](http://i.imgur.com/h5ADuci.png)

参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
