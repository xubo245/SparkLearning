
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0
#0 以下分析是主要是基于spark-1.5.2和alluxio-1.3.0分析的，默认不支持数据本地化，所以会有跨节点传输
# 1.解释 #

先加载到mem，然后count

出现问题，D9是block丢失，主要是因为alluxio内存使用问题，每个work会将数据缓存，而不是分布式缓存，导致后面的不经常用的数据丢失

# 2.代码： #

	for j in 1 2 3 4 5 6 7 8 9
	do
	        for i in 1 2 3 4 5 6 7 8 9 10
	        do
	                echo 'time:'$i
	                sh test.sh 6G  alluxio://Master:19998/xubo/alluxio/uniref/'D'$j'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	        done
	
	
	done


# 3.结果： #

##alluxio-1.3.0
	
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f run1time201611122335.txt \
	> ;
	time:1
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.455s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.432s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.486s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.605s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.874s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.66s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.488s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.391s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.064s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.018s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.9s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.706s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.779s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.809s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.063s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.188s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.882s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:7.166s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.786s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.84s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:5.316s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:5.533s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:5.299s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:5.381s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:10.477s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:5.333s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.183s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:10.117s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:5.327s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.247s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:24.306s
	16/11/12 23:43:00 WARN QueuedThreadPool: 1 threads could not be stopped         
	time:2
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:15.898s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:5.999s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:6.053s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:14.931s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.422s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.535s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:6.46s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:6.261s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.549s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:16.498s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:17.061s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:6.414s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:7.03s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:6.505s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:6.117s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:6.952s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.545s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.553s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:17.072s
	time:1                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:18.648s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:18.926s
	time:3
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:17.453s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:18.81s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:16.726s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:7.699s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:8.189s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:16.938s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:6.611s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:6.54s
	time:1
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:28.424s
	time:2
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:28.496s
	time:3
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:34.933s
	time:4
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:28.524s
	time:5
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:28.146s
	time:6
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:29.543s
	time:7
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:41.073s
	time:8
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:28.614s
	time:9
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:28.967s
	time:10
	input:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:32.312s
	time:1
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:90.415s
	time:2
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:58.984s
	time:3
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:31.455s
	time:4
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:40.781s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:34.593s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:49.076s
	time:7
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:29.161s
	time:8
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:36.917s
	time:9
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:31.651s
	time:10
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:28.131s
	time:1
	
## alluxio-0.7.1

	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f run1-0.7.1time201611131949.txt 
	time:1
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.893s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.882s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.912s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.939s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.877s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.784s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.835s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.835s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.01s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.865s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.01s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.107s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.029s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:3.908s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:3.929s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:3.716s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.085s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.016s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.071s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:3.903s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.228s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.168s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.232s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.072s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.254s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.385s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.201s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.381s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.162s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.18s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.288s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.337s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.447s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.312s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.376s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.322s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.446s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.47s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.354s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.429s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:6.288s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.551s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.598s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.623s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:5.115s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.651s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.472s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.659s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.565s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.891s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.928s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.711s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.772s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.683s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.58s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.882s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.819s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:5.149s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.627s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.74s


## 报错
	
	input:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:28.131s
	time:1
	[Stage 0:>                                                        (1 + 16) / 63]16/11/13 00:06:31 ERROR TaskSetManager: Task 43 in stage 0.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 43 in stage 0.0 failed 4 times, most recent failure: Lost task 43.3 in stage 0.0 (TID 22, Mcnode3IP): java.io.IOException: Block 5469372416 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	
	Driver stacktrace:
		at org.apache.spark.scheduler.DAGScheduler.org$apache$spark$scheduler$DAGScheduler$$failJobAndIndependentStages(DAGScheduler.scala:1283)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1271)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1270)
		at scala.collection.mutable.ResizableArray$class.foreach(ResizableArray.scala:59)
		at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:47)
		at org.apache.spark.scheduler.DAGScheduler.abortStage(DAGScheduler.scala:1270)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at scala.Option.foreach(Option.scala:236)
		at org.apache.spark.scheduler.DAGScheduler.handleTaskSetFailed(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.doOnReceive(DAGScheduler.scala:1496)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1458)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1447)
		at org.apache.spark.util.EventLoop$$anon$1.run(EventLoop.scala:48)
		at org.apache.spark.scheduler.DAGScheduler.runJob(DAGScheduler.scala:567)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1824)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1837)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1850)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1921)
		at org.apache.spark.rdd.RDD.count(RDD.scala:1125)
		at alluxio.TimeCount$.compute(TimeCount.scala:32)
		at alluxio.TimeCount$.main(TimeCount.scala:24)
		at alluxio.TimeCount.main(TimeCount.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: java.io.IOException: Block 5469372416 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	time:2
	[Stage 0:=>                                                       (2 + 16) / 63]16/11/13 00:06:41 ERROR TaskSetManager: Task 24 in stage 0.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 24 in stage 0.0 failed 4 times, most recent failure: Lost task 24.3 in stage 0.0 (TID 23, Mcnode1IP): java.io.IOException: Block 5721030656 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	
	Driver stacktrace:
		at org.apache.spark.scheduler.DAGScheduler.org$apache$spark$scheduler$DAGScheduler$$failJobAndIndependentStages(DAGScheduler.scala:1283)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1271)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1270)
		at scala.collection.mutable.ResizableArray$class.foreach(ResizableArray.scala:59)
		at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:47)
		at org.apache.spark.scheduler.DAGScheduler.abortStage(DAGScheduler.scala:1270)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at scala.Option.foreach(Option.scala:236)
		at org.apache.spark.scheduler.DAGScheduler.handleTaskSetFailed(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.doOnReceive(DAGScheduler.scala:1496)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1458)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1447)
		at org.apache.spark.util.EventLoop$$anon$1.run(EventLoop.scala:48)
		at org.apache.spark.scheduler.DAGScheduler.runJob(DAGScheduler.scala:567)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1824)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1837)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1850)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1921)
		at org.apache.spark.rdd.RDD.count(RDD.scala:1125)
		at alluxio.TimeCount$.compute(TimeCount.scala:32)
		at alluxio.TimeCount$.main(TimeCount.scala:24)
		at alluxio.TimeCount.main(TimeCount.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: java.io.IOException: Block 5721030656 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	time:3
	[Stage 0:>                                                        (1 + 16) / 63]16/11/13 00:06:52 ERROR TaskSetManager: Task 43 in stage 0.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 43 in stage 0.0 failed 4 times, most recent failure: Lost task 43.3 in stage 0.0 (TID 23, Mcnode3): java.io.IOException: Block 5469372416 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	
	Driver stacktrace:
		at org.apache.spark.scheduler.DAGScheduler.org$apache$spark$scheduler$DAGScheduler$$failJobAndIndependentStages(DAGScheduler.scala:1283)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1271)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1270)
		at scala.collection.mutable.ResizableArray$class.foreach(ResizableArray.scala:59)
		at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:47)
		at org.apache.spark.scheduler.DAGScheduler.abortStage(DAGScheduler.scala:1270)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at scala.Option.foreach(Option.scala:236)
		at org.apache.spark.scheduler.DAGScheduler.handleTaskSetFailed(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.doOnReceive(DAGScheduler.scala:1496)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1458)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1447)
		at org.apache.spark.util.EventLoop$$anon$1.run(EventLoop.scala:48)
		at org.apache.spark.scheduler.DAGScheduler.runJob(DAGScheduler.scala:567)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1824)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1837)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1850)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1921)
		at org.apache.spark.rdd.RDD.count(RDD.scala:1125)
		at alluxio.TimeCount$.compute(TimeCount.scala:32)
		at alluxio.TimeCount$.main(TimeCount.scala:24)
		at alluxio.TimeCount.main(TimeCount.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: java.io.IOException: Block 5469372416 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	time:4
	[Stage 0:>                                                        (0 + 16) / 63]16/11/13 00:07:02 ERROR TaskSetManager: Task 59 in stage 0.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 59 in stage 0.0 failed 4 times, most recent failure: Lost task 59.3 in stage 0.0 (TID 22, Mcnode4IP): java.io.IOException: Block 5486149632 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	
	Driver stacktrace:
		at org.apache.spark.scheduler.DAGScheduler.org$apache$spark$scheduler$DAGScheduler$$failJobAndIndependentStages(DAGScheduler.scala:1283)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1271)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1270)
		at scala.collection.mutable.ResizableArray$class.foreach(ResizableArray.scala:59)
		at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:47)
		at org.apache.spark.scheduler.DAGScheduler.abortStage(DAGScheduler.scala:1270)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at scala.Option.foreach(Option.scala:236)
		at org.apache.spark.scheduler.DAGScheduler.handleTaskSetFailed(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.doOnReceive(DAGScheduler.scala:1496)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1458)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1447)
		at org.apache.spark.util.EventLoop$$anon$1.run(EventLoop.scala:48)
		at org.apache.spark.scheduler.DAGScheduler.runJob(DAGScheduler.scala:567)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1824)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1837)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1850)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1921)
		at org.apache.spark.rdd.RDD.count(RDD.scala:1125)
		at alluxio.TimeCount$.compute(TimeCount.scala:32)
		at alluxio.TimeCount$.main(TimeCount.scala:24)
		at alluxio.TimeCount.main(TimeCount.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: java.io.IOException: Block 5486149632 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	time:5
	[Stage 0:>                                                        (1 + 16) / 63]16/11/13 00:07:13 ERROR TaskSetManager: Task 59 in stage 0.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 59 in stage 0.0 failed 4 times, most recent failure: Lost task 59.3 in stage 0.0 (TID 23, Mcnode3): java.io.IOException: Block 5486149632 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	
	Driver stacktrace:
		at org.apache.spark.scheduler.DAGScheduler.org$apache$spark$scheduler$DAGScheduler$$failJobAndIndependentStages(DAGScheduler.scala:1283)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1271)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$abortStage$1.apply(DAGScheduler.scala:1270)
		at scala.collection.mutable.ResizableArray$class.foreach(ResizableArray.scala:59)
		at scala.collection.mutable.ArrayBuffer.foreach(ArrayBuffer.scala:47)
		at org.apache.spark.scheduler.DAGScheduler.abortStage(DAGScheduler.scala:1270)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGScheduler$$anonfun$handleTaskSetFailed$1.apply(DAGScheduler.scala:697)
		at scala.Option.foreach(Option.scala:236)
		at org.apache.spark.scheduler.DAGScheduler.handleTaskSetFailed(DAGScheduler.scala:697)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.doOnReceive(DAGScheduler.scala:1496)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1458)
		at org.apache.spark.scheduler.DAGSchedulerEventProcessLoop.onReceive(DAGScheduler.scala:1447)
		at org.apache.spark.util.EventLoop$$anon$1.run(EventLoop.scala:48)
		at org.apache.spark.scheduler.DAGScheduler.runJob(DAGScheduler.scala:567)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1824)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1837)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1850)
		at org.apache.spark.SparkContext.runJob(SparkContext.scala:1921)
		at org.apache.spark.rdd.RDD.count(RDD.scala:1125)
		at alluxio.TimeCount$.compute(TimeCount.scala:32)
		at alluxio.TimeCount$.main(TimeCount.scala:24)
		at alluxio.TimeCount.main(TimeCount.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: java.io.IOException: Block 5486149632 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
	time:6
	[Stage 0:=>                                                       (2 + 16) / 63]16/11/13 00:07:24 ERROR TaskSetManager: Task 59 in stage 0.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 59 in stage 0.0 failed 4 times, most recent failure: Lost task 59.3 in stage 0.0 (TID 23, Mcnode3): java.io.IOException: Block 5486149632 is not available in Alluxio
		at alluxio.client.block.AlluxioBlockStore.getInStream(AlluxioBlockStore.java:134)
		at alluxio.client.file.FileInStream.updateBlockInStream(FileInStream.java:519)
		at alluxio.client.file.FileInStream.updateStreams(FileInStream.java:426)
		at alluxio.client.file.FileInStream.close(FileInStream.java:145)
		at alluxio.hadoop.HdfsFileInputStream.read(HdfsFileInputStream.java:194)
		at java.io.DataInputStream.read(DataInputStream.java:100)
		at org.apache.hadoop.util.LineReader.fillBuffer(LineReader.java:180)
		at org.apache.hadoop.util.LineReader.readDefaultLine(LineReader.java:216)
		at org.apache.hadoop.util.LineReader.readLine(LineReader.java:174)
		at org.apache.hadoop.mapred.LineRecordReader.skipUtfByteOrderMark(LineRecordReader.java:206)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:244)
		at org.apache.hadoop.mapred.LineRecordReader.next(LineRecordReader.java:47)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:248)
		at org.apache.spark.rdd.HadoopRDD$$anon$1.getNext(HadoopRDD.scala:216)
		at org.apache.spark.util.NextIterator.hasNext(NextIterator.scala:73)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:39)
		at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:327)
		at org.apache.spark.util.Utils$.getIteratorSize(Utils.scala:1553)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.rdd.RDD$$anonfun$count$1.apply(RDD.scala:1125)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.SparkContext$$anonfun$runJob$5.apply(SparkContext.scala:1850)
		at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)

参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
