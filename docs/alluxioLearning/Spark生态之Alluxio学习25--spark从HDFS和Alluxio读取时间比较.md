	
更多代码请见：https://github.com/xubo245/SparkLearning
	
Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0
	
# 1.解释 #
	
	想要分析alluxio加速效果，发现alluxio会出现长尾效应，导致有些task特别耗时，相对于HDFS，并没有明显优势。
	
	
	
# 2.代码： #
	
	#~/cloud/alluxio-1.3.0/bin/alluxio fs mkdir -p /xubo/project/SparkSW/input/
	for i in 1 2 3 4 5 6 7 8 9 10
	do
	echo 'time:'$i
	for j in 1 2 3 4 5 6 7 8 9 10
	do
	          sh test.sh 10G  hdfs://Master:9000/xubo/project/SparkSW/input/'D'$i'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	  #sh test.sh 10G  alluxio://Master:19998/xubo/alluxio/uniref/'D'$j'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	  #sh test.sh 10G  alluxio://Master:19998/xubo/project/SparkSW/input/'D'$j'Line.fasta' alluxio://Master:19998/xubo/project/alluxio/output/TimeCount
	done
	
	for j in 1 2 3 4 5 6 7 8 9 10
	do
	        sh test.sh 10G  alluxio://Master:19998/xubo/project/SparkSW/input/'D'$i'Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	done
	done

	
	
# 3.结果： #
	
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f runtime201611231839.txt 
	time:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.918s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.923s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.848s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.959s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.85s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.816s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:4.208s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.925s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:3.001s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        count:78295	countTime:2.817s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:3.466s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:2.83s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:2.757s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:2.824s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:2.813s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:2.802s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:2.847s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:2.88s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:3.963s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta    count:78295	countTime:2.788s
	time:2
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:3.074s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:2.945s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:3.023s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:3.999s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:3.073s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:4.206s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:3.028s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:4.049s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:3.927s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        count:156590	countTime:3.964s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.875s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:6.505s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.001s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.276s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.047s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.081s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.365s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.083s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.141s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D2Line.fasta    count:156590	countTime:3.027s
	time:3
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.572s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.45s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.342s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.336s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.508s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.268s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.558s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.401s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.457s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        count:313180	countTime:4.513s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:5.515s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.846s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.215s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.242s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.181s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.236s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:3.047s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.178s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.24s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D3Line.fasta    count:313180	countTime:4.178s
	time:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:7.852s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:6.148s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:7.575s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:16.612s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:8.009s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:8.02s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:7.937s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:8.007s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:16.949s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        count:626360	countTime:7.795s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:7.182s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:4.506s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:3.463s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:3.501s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:3.544s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:3.747s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:3.523s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:3.4s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:3.325s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D4Line.fasta    count:626360	countTime:3.519s
	time:5
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:3.988s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:4.004s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:5.494s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:4.916s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:5.479s
	16/11/23 18:56:20 WARN QueuedThreadPool: 4 threads could not be stopped
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:3.891s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:4.73s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:4.851s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:4.9s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        count:1252720	countTime:4.966s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:7.924s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:6.396s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:3.487s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:5.417s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:4.272s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:3.465s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:3.437s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:4.067s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:6.194s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta    count:1252720	countTime:5.352s
	time:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:4.883s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:4.119s
	16/11/23 18:59:47 WARN QueuedThreadPool: 4 threads could not be stopped
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:4.172s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:5.09s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:7.57s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:4.578s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:7.317s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:4.857s
	16/11/23 19:01:03 WARN QueuedThreadPool: 1 threads could not be stopped
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:4.854s
	16/11/23 19:01:16 WARN QueuedThreadPool: 1 threads could not be stopped
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        count:2505440	countTime:3.994s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:15.504s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:6.336s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:6.456s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:4.951s
	16/11/23 19:02:27 WARN QueuedThreadPool: 2 threads could not be stopped
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:5.525s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:15.943s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:4.665s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:4.814s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:15.965s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D6Line.fasta    count:2505440	countTime:4.915s
	time:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:9.814s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:9.196s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:9.434s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:9.172s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:20.193s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:10.454s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:9.551s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:9.321s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:10.313s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        count:5019006	countTime:9.707s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:52.331s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:6.583s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:16.998s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:16.55s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:6.496s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:6.781s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:7.477s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:17.51s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:6.494s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta    count:5019006	countTime:17.511s
	time:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:10.427s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:9.993s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:11.242s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:10.868s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:7.354s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:7.015s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:7.344s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:7.182s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:7.262s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        count:10038012	countTime:8.282s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:42.406s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:16.769s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:18.197s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:7.881s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:8.913s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:8.174s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:20.971s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:8.434s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:8.316s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D8Line.fasta    count:10038012	countTime:16.767s
	time:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:32.624s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:19.688s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:17.345s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:20.98s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:13.478s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:27.69s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:15.567s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:14.237s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:16.413s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.537s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:99.776s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.482s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:29.184s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:17.949s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:17.29s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.279s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.892s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.895s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.351s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:20.001s
	time:10
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:38.227s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:25.727s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:23.691s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:19.047s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:19.611s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:14.391s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:16.036s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:16.249s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:15.324s
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       count:40152048	countTime:13.936s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:151.861s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:46.322s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:31.237s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:31.318s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:19.097s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:19.043s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:30.663s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:43.809s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:20.463s
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D10Line.fasta   count:40152048	countTime:31.099s
	
	
参考
	
		【1】https://github.com/Alluxio/alluxio
		【2】http://www.alluxio.org/
		【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
		【4】https://github.com/xubo245/SparkLearning
