
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

#0 以下分析是主要是基于spark-1.5.2和alluxio-1.3.0分析的，默认不支持数据本地化，所以会有跨节点传输

# 1.解释 #

## 1.1 分析##
alluxio会把数据缓存在work的本地，虽然使用spark从alluxio读取hdfs会使得文件分布与hdfs不一致，但还是可以达到加速的目的，特别是hdfs与spark不在一个集群，alluxio可以达到很好的缓存作用；baidu 30倍提升的背景和方法类似

## 1.2 实验##
   分别从hdfs读取文件和alluxio读取文件，进行count计算，文件大小从32M到7.8G

# 2.代码： #
脚本

	#~/cloud/alluxio-1.3.0/bin/alluxio fs mkdir -p /xubo/project/SparkSW/input/
	for j in 1 2 3 4 5 6 7 8 9
	do
	       for i in 1 2 3 4 5 6 7 8 9 10
	       do
	               echo 'time:'$i
	                 sh test.sh 14G  hdfs://Master:9000/xubo/project/SparkSW/input/'D'$j'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	       done
	 done
	
	for j in 1 2 3 4 5 6 7 8 9
	do
	        for i in 1 2 3 4 5 6 7 8 9 10
	        do
	                echo 'time:'$i
	                sh test.sh 6G  alluxio://Master:19998/xubo/project/SparkSW/input/'D'$j'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	        done
	
	
	done



# 3.结果： #
	
## 3.1 从hdfs读取文件进行count
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f run1_201611121727.txt 
	time:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:4.1s
	time:2                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:5.14s
	time:3                                                                          
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid26806.log
	time:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:5.023s
	time:5                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.984s
	time:6                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:4.037s
	time:7                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.847s
	time:8                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.966s
	time:9                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:5.015s
	time:10                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:5.425s
	time:1                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:4.012s
	time:2                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:6.533s
	time:3                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:6.44s
	time:4                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:6.528s
	time:5                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:4.048s
	time:6                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:4.145s
	time:7                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:4.055s
	time:8                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:4.031s
	time:9                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:6.665s
	time:10                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:4.065s
	time:1                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:5.41s
	time:2                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.779s
	time:3                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:9.414s
	time:4                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.267s
	time:5                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:9.446s
	time:6                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.53s
	time:7                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.306s
	time:8                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:9.39s
	time:9                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:9.307s
	time:10                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.463s
	time:1                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:16.953s
	time:2                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:8.625s
	time:3                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:8.015s
	time:4                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:6.104s
	time:5                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:12.854s
	time:6                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:6.274s
	time:7                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:17.06s
	time:8                                                                          
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid1475.log
	time:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:16.995s
	time:10                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:7.915s
	time:1                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:15.202s
	time:2                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:7.891s
	time:3                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:6.638s
	time:4                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:5.049s
	time:5                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:5.176s
	time:6                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:5.181s
	time:7                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:4.888s
	time:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:15.406s
	time:9                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:6.229s
	time:10                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:6.14s
	time:1                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:26.699s
	time:2                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:15.33s
	time:3                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:26.675s
	time:4                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:15.361s
	time:5                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:26.745s
	time:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:16.951s
	time:7                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:17.046s
	time:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:26.805s
	time:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:27.031s
	time:10                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:15.89s
	time:1                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:55.006s
	time:2
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:43.435s
	time:3
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:30.068s
	time:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:35.5s
	time:5
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:30.111s
	time:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:30.015s
	time:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:44.477s
	time:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:41.526s
	time:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:30.072s
	time:10
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:30.481s
	time:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:84.314s
	time:2
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:27.691s
	time:3
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:44.684s
	time:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:96.937s
	time:5
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:61.365s
	time:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:38.072s
	time:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:43.018s
	time:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:85.482s
	time:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:27.828s
	time:10
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:52.804s
	time:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:110.129s
	time:2
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:166.146s
	time:3
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:97.836s
	time:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:51.683s
	time:5
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:107.544s
	time:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:96.966s
	time:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:100.279s
	time:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:61.431s
	time:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:38.482s
	time:10
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:63.901s
	    
## 3.2 从alluxio读取文件进行count	
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f run1_201611121727_2.txt 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:7.512s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:5.323s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:3.979s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:5.322s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:4.447s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:4.042s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:3.931s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:4.977s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:3.951s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:4.086s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:5.199s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:5.605s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:4.147s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.868s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:5.324s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:10.215s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:4.079s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:4.097s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:4.082s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:4.134s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:16.241s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:16.245s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:8.147s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:5.934s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.395s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.12s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.392s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.268s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.156s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.242s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:16.096s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:25.805s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:13.501s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:4.419s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:13.76s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:7.432s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:7.975s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:4.239s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:4.489s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:4.519s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:28.792s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:12.711s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:28.76s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:18.752s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:10.026s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:4.53s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:4.789s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:4.793s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:5.761s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:4.6s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:63.302s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:11.117s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:9.801s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:9.064s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:28.815s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:7.811s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:9.686s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:4.816s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:6.598s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:4.728s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:93.021s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:39.388s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:50.501s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:45.915s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:44.043s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.48s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:32.945s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.906s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.884s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:29.972s
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:145.837s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:57.805s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:66.785s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:53.351s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:48.176s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:31.527s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:49.615s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:44.39s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.008s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:31.557s
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:228.964s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:200.829s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:167.487s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:87.298s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:68.357s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:71.835s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:61.462s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:44.198s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:40.567s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.631s
## 3.3 从alluxio读取文件进行count后alluxio文件情况
master：
![](http://i.imgur.com/AYOiuvl.png)
Mcnode7
![](http://i.imgur.com/VsHYPar.png)
Mcnode5
![](http://i.imgur.com/1aZkVTz.png)
Mcnode4
![](http://i.imgur.com/WTku1Yl.png)
Mcnode3:
![](http://i.imgur.com/7ub8mTf.png)
Mcnode2:
![](http://i.imgur.com/xqmLCjF.png)
Mcnode1:
![](http://i.imgur.com/Pm5e6zv.png)
network:
![](http://i.imgur.com/X1VL4Vq.png)

## 3.5 D9提升进一步实验
由于alluxio中D9的数据仍然没有100%，所以再运行了20遍：

	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f run1D9time201611122031.txt 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:31.358s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:36.08s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.398s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:31.578s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:29.958s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:29.9s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:29.807s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.638s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.583s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:29.812s
	^C
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f run1D9time201611122038.txt 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.169s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.898s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.523s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.764s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.492s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.109s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.657s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.765s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.927s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:33.635s

运行D9 30次后：

![](http://i.imgur.com/Shv4tN6.png)
![](http://i.imgur.com/aStad0e.png)
![](http://i.imgur.com/4pSfQSK.png)
![](http://i.imgur.com/Fwuhrk9.png)
![](http://i.imgur.com/q5vqsVy.png)
![](http://i.imgur.com/Q3DOcno.png)

参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
