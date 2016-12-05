
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

# 1.解释 #

	测量alluxio和hdfs哪个速度快


# 2.代码： #

## 2.1 hdfs ##
	        for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
	        do
	                echo 'time:'$i
	                sh test.sh 10G  hdfs://Master:9000/xubo/project/SparkSW/input/'D9Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
	        done

## 2.2 aluxio ##

	for i in 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30
        do
                echo 'time:'$i
                sh test.sh 10G  alluxio://Master:19998/xubo/project/SparkSW/input/'D9Line.fasta' hdfs://Master:9000/xubo/project/alluxio/output/TimeCount
        done
## 2.3 test.sh

	mem=$1
	input=$2
	
	#/home/zgg/lib/spark-1.0.1-bin-hadoop2/bin/spark-submit \
	  spark-submit \
	  --class alluxio.TimeCount \
	  --master spark://219.219.220.149:7077 \
	  --executor-memory $mem \
	  SparkSW.jar $input $3


# 3.结果： #

##3.1 HDFS

	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run1D9hdfs.sh 
	time:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:34.178s
	time:2                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:23.82s
	time:3                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:18.884s
	time:4                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:19.471s
	time:5                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:14.446s
	time:6                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.18s
	16/11/17 17:45:25 ERROR LiveListenerBus: SparkListenerBus has already stopped! Dropping event SparkListenerExecutorMetricsUpdate(6,WrappedArray())
	time:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.474s
	time:8                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:13.26s
	time:9                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.699s
	time:10                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.991s
	time:11                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.977s
	time:12                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.933s
	time:13                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.322s
	time:14                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.735s
	time:15                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.489s
	time:16                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.832s
	time:17                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.883s
	time:18
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.917s
	time:19                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.032s
	time:20                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.208s
	time:21                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.089s
	time:22                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.055s
	time:23                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.839s
	time:24                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.651s
	time:25                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.999s
	time:26                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.73s
	time:27                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.621s
	time:28                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.672s
	time:29                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.65s
	time:30                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.054s
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run1D9hdfs.sh           
	time:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.726s
	time:2                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.86s
	time:3
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.724s
	time:4                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.393s
	time:5                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.963s
	time:6                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.96s
	time:7                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.866s
	time:8                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.52s
	time:9                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.084s
	time:10                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.081s
	time:11                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.56s
	time:12                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.043s
	time:13
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.598s
	time:14                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.569s
	time:15                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.594s
	time:16                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.674s
	time:17                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.713s
	time:18                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.733s
	time:19                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.691s
	time:20                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.816s
	time:21                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.64s
	time:22                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.841s
	time:23                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.537s
	time:24                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.629s
	time:25
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.702s
	time:26                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:11.089s
	time:27                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.99s
	time:28                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.672s
	time:29                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.597s
	time:30                                                                         
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:10.612s
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run1D9hdfs.sh           
	time:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:13.733s
	time:2                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.415s
	time:3                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.306s
	time:4                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.588s
	time:5                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.306s
	time:6                                                                          
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        count:20076024	countTime:12.848s
	[Stage 1:==========================================>              (12 + 4) / 16]^CException in thread "main" org.apache.spark.SparkException: Job cancelled because SparkContext was shut down

## 3.2 alluxio-1.3.0

	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run1D9.sh 
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:202.784s
	time:2
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:124.612s
	time:3
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:66.245s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:63.52s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:29.778s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:75.229s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:50.952s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:41.106s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:39.525s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:39.792s
	time:11                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:17.647s
	time:12                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.726s
	time:13                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:39.813s
	time:14                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:40.184s
	time:15                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.303s
	time:16                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.322s
	time:17                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:21.089s
	time:18                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:20.824s
	time:19                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:16.833s
	time:20                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:31.777s
	time:21                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.146s
	time:22                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:16.895s
	time:23                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.393s
	time:24
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.626s
	time:25                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.516s
	time:26                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.707s
	time:27                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:17.168s
	time:28                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:39.63s
	time:29
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.63s
	time:30                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:20.168s
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run1D9.sh               
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:17.111s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.414s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:17.674s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.614s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.574s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.633s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.124s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:8.262s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.193s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.095s
	time:11                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:20.203s
	time:12                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.528s
	time:13                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:9.224s
	time:14                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.559s
	time:15                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.397s
	time:16                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.286s
	time:17                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:40.486s
	time:18                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:16.913s
	time:19                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:16.914s
	time:20                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.536s
	time:21                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.72s
	time:22                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.176s
	time:23                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:39.896s
	time:24                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.339s
	time:25                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.388s
	time:26                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.289s
	time:27                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.886s
	time:28                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.935s
	time:29                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.754s
	time:30                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.431s
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ ./run1D9.sh               
	time:1
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:16.877s
	time:2                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.576s
	time:3                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.556s
	time:4                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:31.889s
	time:5                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:8.711s
	time:6                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.514s
	time:7                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.962s
	time:8                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:20.938s
	time:9                                                                          
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.465s
	time:10                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.108s
	time:11                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.865s
	time:12                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.47s
	time:13
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:17.94s
	time:14                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.688s
	time:15                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:31.033s
	time:16                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:17.846s
	time:17                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.637s
	time:18                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:30.046s
	time:19                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.653s
	time:20                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.897s
	time:21                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.641s
	time:22                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.49s
	time:23                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:28.21s
	time:24                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.12s
	time:25                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.996s
	time:26                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:18.852s
	time:27                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:19.955s
	time:28
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:29.634s
	time:29                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.581s
	time:30                                                                         
	input:alluxio://Master:19998/xubo/project/SparkSW/input/D9Line.fasta    count:20076024	countTime:7.489s



参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
