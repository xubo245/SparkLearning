
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0
#0 以下分析是主要是基于spark-1.5.2和alluxio-1.3.0分析的，默认不支持数据本地化，所以会有跨节点传输
# 1.解释 #

## 1.1 数据##
D7:2.01 GB
D8:4.16 GB
D9:7.79 GB

## 1.2 说明
   在D7-9上运行count，spark分布式执行，最后都是稳定在30s左右，不知道为什么？三个数据集大小不一样，但是最后收敛一样？
  
   猜想：
   		block设置的大小为128M，但是

# 2.运行记录 #

## 2.1 运行记录 D7-D9
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
	^C

## 3.2 多次运行D9
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
	^[[B^[[B^C

## 2.3 多次运行D8

	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f rund8time201611122051.txt 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:127.607s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:44.799s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:85.756s
	time:4                                                                          
	Java HotSpot(TM) 64-Bit Server VM warning: INFO: os::commit_memory(0x00000003fff80000, 11453595648, 0) failed; error='Cannot allocate memory' (errno=12)
	#
	# There is insufficient memory for the Java Runtime Environment to continue.
	# Native memory allocation (malloc) failed to allocate 11453595648 bytes for committing reserved memory.
	# An error report file with more information is saved as:
	# /home/hadoop/disk2/xubo/project/alluxio/timeCount/hs_err_pid12705.log
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:46.596s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:46.065s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:53.594s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.673s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.201s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:41.336s
	^C
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f rund8time201611122104.txt 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:31.531s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:29.741s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:33.394s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:29.74s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:34.75s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:29.809s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.483s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.412s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:29.812s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.721s
	^C
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f rund8time201611122110.txt 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.438s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.56s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.617s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.418s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.432s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.504s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.574s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.526s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.793s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.535s
	^[[A^C
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f rund8time201611122118.txt 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.539s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.512s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.536s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.771s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.383s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.626s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.361s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.663s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.693s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:30.894s
	^C
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f rund7time201611122125.txt 

## 3.4 多次运行D7
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:118.782s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:50.964s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:45.109s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:44.266s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:31.002s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.822s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.46s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.673s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.686s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.062s
	time:11
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:29.93s
	time:12
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:31.033s
	time:13
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.61s
	time:14
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.656s
	time:15
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:31.083s
	time:16
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.639s
	time:17
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:29.984s
	time:18
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.637s
	time:19
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.219s
	time:20
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.777s
	time:21
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.849s
	time:22
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.763s
	time:23
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.83s
	time:24
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.728s
	time:25
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.615s
	time:26
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.652s
	time:27
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.678s
	time:28
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.705s
	time:29
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:31.004s
	time:30
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.04s

## 3.5 改变运行内存：10G excutor

	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f rund7time201611122159mem10g.txt 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.642s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:29.375s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.765s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.63s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.639s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.66s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.659s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.741s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:29.925s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.55s
	time:11
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.787s
	time:12
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.585s
	time:13
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.626s
	time:14
	^C

##  3.6 改变运行内存：10G excutor， 且释放掉alluxio其他文件
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f rund7time201611122211mem10g.txt 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.76s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.588s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.821s
	time:4
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.517s
	time:5
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.626s
	time:6
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.831s
	time:7
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.68s
	time:8
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.684s
	time:9
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.73s
	time:10
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.741s
	time:11
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.819s
	time:12
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:30.812s
	time:13
	[Stage 0:=================================================>       (14 + 2) / 16]

## 3.7 使用saveAsTextFile：
	
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f run1d9time201611131738.txt 
	time:1
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:176.505s
	time:2
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:160.029s
	time:3
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:77.369s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:63.931s
	time:5
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:51.872s
	time:6
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:40.886s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:36.764s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.678s
	time:9
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:36.897s
	time:10
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:52.303s
	time:11
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.534s
	time:12
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.507s
	time:13
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.622s
	time:14
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.395s
	time:15
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.366s
	time:16
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:32.348s
	time:17
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:44.949s
	time:18
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.473s
	time:19
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.086s
	time:20
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.495s
	time:21
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.259s
	time:22
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.362s
	time:23
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.78s
	time:24
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.974s
	time:25
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.396s
	time:26
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.641s
	time:27
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:29.052s
	time:28
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.5s
	time:29
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.573s
	time:30
	input:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:28.224s

参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
