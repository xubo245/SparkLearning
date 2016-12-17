
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

>>alluxio-0.7.1 通过copyFromLocal指令上传文件，发现D1Line.fasta-D6Line.fasta都在一个节点，Mcnode1;
但是alluxio-1.3.1,通过load一个大文件，发现数据会分布在不同节点；但是使用sparkContext的textfile，发现有两份数据,具体请见下面的分析

master没有部署work

#0 以下分析是主要是基于spark-1.5.2和alluxio-1.3.0分析的，默认不支持数据本地化，所以会有跨节点传输
# 1 load和free分析 ##

## 1.1 load和free分析和观察结果##
	（1）master load,各个节点都会有数据;work节点load，只有work节点有数据，前提是master节点没有work节点
	（2）load数据来源是hdfs，数据大小放到内存也是128M
	（3）alluxio数据分布与hdfs不一致，D7Line.fasta:在HDFS没有存在Mcnode5，但是load后会有（master运行）
	（4）D7Line.fasta大概2.01G,load很慢，超过一分钟，但是free是秒级的
	（5）从hdfs加载到alluxio，内存中查看到是一个节点一个节点串行操作，没有并行，而且是一个block一个block操作，节点内也没有并行，因为load是单线程
	（6）load运行在Master，通过ganglia发现Mcnode1的节点cache很多，接近饱和14G
	（7）数据分布基本均匀（master运行）
	（8）串行加载时应该是按照文件的block顺序加载，应为最小的文件应该是最后加载的--可以优化成并行
	（9）free后释放了部分内存， cache还是比较大，但不确定这部分数据是什么
	(10) 在Mcnode2 load，在Mcnode3可以free
	(11)load 加载数据一份，没有copy
	
## 1.2 代码 ##
## 1.2.1 load##

	hadoop@Master:~/xubo/project/alignment/SparkSW/SparkSW20161026/file$ ~/cloud/alluxio-1.3.0/bin/alluxio fs load /xubo/project/SparkSW/input/D7Line.fasta
	/xubo/project/SparkSW/input/D7Line.fasta loaded

D10Line.fasta很久：14.16 GB大概load超过半个小时

	hadoop@Master:~/xubo/project/alignment/SparkSW/SparkSW20161026/file$ ~/cloud/alluxio-1.3.0/bin/alluxio fs load /xubo/project/SparkSW/input/D10Line.fasta
	/xubo/project/SparkSW/input/D10Line.fasta loaded

## 1.2.2 free##

	hadoop@Master:~/xubo/project/alignment/SparkSW/SparkSW20161026/file$ ~/cloud/alluxio-1.3.0/bin/alluxio fs free /xubo/project/SparkSW/input/D7Line.fasta
	/xubo/project/SparkSW/input/D7Line.fasta was successfully freed from memory.

## 1.3 结果 ##
## 1.3.1 D7Line.fasta的load和free ##
load D7Line.fasta:
![](http://i.imgur.com/QKqvqI4.png)

free D7Line.fasta:
![](http://i.imgur.com/HINvWot.png)

## 1.3.2 D10Line.fasta的load ##
load D10Line.fasta:
![](http://i.imgur.com/NWbdfpq.png)

load时内存监控
![](http://i.imgur.com/rEdRzZx.png)

## 1.3.3 D9Line.fasta的load（没有删除D10） ##

D9D10 load：
![](http://i.imgur.com/GDekoTn.png)

两个文件加载后内存情况：
![](http://i.imgur.com/lb4IQcv.png)

network:
![](http://i.imgur.com/2tORima.png)

##  1.3.4 free D9 D10 ##
该数据是在运行copyFromLocal之后再free的

![](http://i.imgur.com/Dus0yUI.png)

##  1.3.5 work load##
Mcnode2 ：
![](http://i.imgur.com/aTy6kvu.png)

Mcnode3：

![](http://i.imgur.com/Oo0jmyN.png) 


# 2 copyFromLocal分析 
运行在Mcnode1
## 2.1 copyFromLocal分析和观察结果##
	（1）copyFromLocal是本地缓存，即从本地磁盘加载到本地的内存，没有跨Alluio节点传输缓存（work节点运行）
	（2）由于（1），但文件大于单个节点，小雨集群容量时，使用copyFromLocal没法成功（work节点运行），而且会删除原来节点缓存的文件，应该算是bug**
	（3）copyFromLocal速度很快，12G左右的数据在2分钟左右，明显快于load
	（3）copyFromLocal可以跨节点存储（master节点运行）

## 2.2 代码： ##

## 2.2.1 copyFromLocal ##

	hadoop@Mcnode1:~/disk2/xubo/data/SparkSW/uniref$ ~/cloud/alluxio-1.3.0/bin/alluxio fs copyFromLocal uniref100.fasta /
	Failed to cache: Not enough space left on worker Mcnode1/Mcnode1IP:29998 to store blockId 33638318104. Please consult http://www.alluxio.org/docs/1.3/en/Debugging-Guide.html for common solutions to address this problem.


## 2.3 结果： 
## 2.3.1 copyFromLocal数据大于alluxio单节点内存 ##

	hadoop@Mcnode1:~/disk2/xubo/data/SparkSW/uniref$ ~/cloud/alluxio-1.3.0/bin/alluxio fs copyFromLocal uniref100.fasta /
	Failed to cache: Not enough space left on worker Mcnode1/Mcnode1:29998 to store blockId 33621540888. Please consult http://www.alluxio.org/docs/1.3/en/Debugging-Guide.html for common solutions to address this problem.

99%的内存使用：

![](http://i.imgur.com/eLXwSqQ.png)

第二次运行：

	hadoop@Mcnode1:~/disk2/xubo/data/SparkSW/uniref$ ~/cloud/alluxio-1.3.0/bin/alluxio fs copyFromLocal uniref100.fasta /
	Failed to cache: Not enough space left on worker Mcnode1/Mcnode1:29998 to store blockId 33638318104. Please consult http://www.alluxio.org/docs/1.3/en/Debugging-Guide.html for common solutions to address this problem.

![](http://i.imgur.com/DpWAot2.png)

fail之后变成0
![](http://i.imgur.com/U80Cudf.png)

但是内存变化没那么大：
![](http://i.imgur.com/ezvkfOn.png)



# 3 SparkContext.textfile and count分析 #
形式：sc.textFile("alluxio://Master:19998/xubo/project/SparkSW/input/D1Line.fasta")
## 3.1 SparkContext.textfile and count分析和观察结果##

	（1）通过SparkContext.textfile加载alluxio中的文件也会缓存数据到alluxio内存中
	（2）通过分析D5Line.fasta数据集可以发现，在Mcnode6有D5Line.fasta的完整数据集，其他数据分布在Mcnode1、Mcnode5，Mcnode6中，而D5Line.fasta在hdfs主要分布在Mcnode1、2、3、4中，所以数据分布也不是按照HDFS进行读取和存储，需要跨节点传输
	（3）通过分析D7Line.fasta数据集可以发现，2.01G的数据并没有出现在一个节点上，而且多个节点
	（4）根据上一条发现，有两份数据集会被加载
	（5）D5,D7没有存在Mcnode5、6，但是textFile后会有，所以也不是按照HDFS读取到内存
	（6）Mcnode1、2、3、4的内存cache明显大于Mcnode5、6、7，猜测是HDFS主要存储在前四个节点
	（7）Master的内存使用已满，而且use部分相对于其他七个work节点，明显要大，master的use接近10G

## 3.2 代码： 

	val rdd1= sc.textFile("alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta")
	rdd1.count

spark-shell：

	scala> val rdd1= sc.textFile("alluxio://Master:19998/xubo/project/SparkSW/input/D5Line.fasta")
	rdd1: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[3] at textFile at <console>:21
	
	scala> rdd1.count
	res1: Long = 1252720   

	scala> val rdd1= sc.textFile("alluxio://Master:19998/xubo/project/SparkSW/input/D7Line.fasta")
	rdd1: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[5] at textFile at <console>:21
	
	scala> rdd1.count
	res2: Long = 5019006   

## 3.3 结果： 

## 3.3.1 D5文件 
总共大小405.63 MB
Mcnode4和5同步加载，Mcnode4数据在前：开始
![](http://i.imgur.com/8YTEtMd.png)
Mcnode4和Mcnode5同步加载，Mcnode4数据在前：增加
![](http://i.imgur.com/tfEyBmY.png)
Mcnode4和Mcnode6同步加载，Mcnode4数据在前：Mcnode5已经加载好，Mcnode6开始
![](http://i.imgur.com/WtJ2exX.png)
Mcnode4和Mcnode1同步加载，Mcnode4数据在前：Mcnode5、Mcnode6已经加载好，Mcnode1开始
![](http://i.imgur.com/qY7NaL3.png)
均加载好：
![](http://i.imgur.com/9v4cVMe.png)

## 3.3.2 D7文件 
![](http://i.imgur.com/CbgbBQa.png)

加载顺序：
![](http://i.imgur.com/5lAVczv.png)

![](http://i.imgur.com/xb3o4Jv.png)

![](http://i.imgur.com/IJxT2NG.png)

![](http://i.imgur.com/d9Z1dHu.png)

## 3.3.3 Master和Mcnode1-7等work的内存情况

![](http://i.imgur.com/u5PkSZ5.png)

# 4. textFile hdfs and saveAsTextFile alluxio分析
形式：

	val rdd1= sc.textFile("hdfs://Master:9000//xubo/project/SparkSW/input/D1Line.fasta")
	rdd1.saveAsTextFile("alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta")

## 4.1 textFile hdfs and saveAsTextFile alluxio分析和观察结果##
	（1）在master使用spark submit执行，rdd读入的时候会进行partition，然后存储的时候在hdfs block所在节点，试了7次，而且较大概率会分布在不同的节点
	（2）spark-shell报错
	（3）写到alluxio中的时候是多线程并行的
	

## 4.2 代码
      
	val rdd1= sc.textFile("hdfs://Master:9000//xubo/project/SparkSW/input/D1Line.fasta")
	rdd1.saveAsTextFile("alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta")
脚本

	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ vi saveFile.sh 

        for i in 1 2 3 4 5 6 7 8 9
        do
                echo 'time:'$i
                sh test.sh 6G  hdfs://Master:9000/xubo/project/SparkSW/input/'D'$i'Line.fasta' 'alluxio://Master:19998/xubo/alluxio/uniref/D'$i'Line.fasta' save
        done
## 4.3 结果
## 4.3.1 存储的是partition
![](http://i.imgur.com/Bmdn9MG.png)

![](http://i.imgur.com/pwRCZtv.png)

##4.3.2 多线程并行
![](http://i.imgur.com/Fa29iTl.png)
![](http://i.imgur.com/irMpk6v.png)
![](http://i.imgur.com/PLcMgHf.png)
![](http://i.imgur.com/EuapQfr.png)
![](http://i.imgur.com/OfNW8tW.png)
![](http://i.imgur.com/L0MlpVC.png)
最后存储的数据分布很均匀

## 4.3.3 记录

	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ sh test.sh 6G  hdfs://Master:9000/xubo/project/SparkSW/input/'D6Line.fasta' alluxio://Master:19998/xubo/alluxio/uniref/'D6Line.fasta'
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta	countTime:39.499s	partitons.length:8
	

##记录

##第一次：alluxio-1.3.0

	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ tail -f saveFile201611122308.txt 
	time:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D1Line.fasta/SaveFile20161112230807255	countTime:6.142s	partitons.length:2
	time:2
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D2Line.fasta/SaveFile20161112230818840	countTime:5.413s	partitons.length:2
	time:3
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta/SaveFile20161112230829721	countTime:10.416s	partitons.length:2
	time:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta/SaveFile20161112230845420	countTime:7.973s	partitons.length:2
	time:5
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta/SaveFile20161112230858790	countTime:16.227s	partitons.length:4
	time:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta/SaveFile20161112230920089	countTime:16.411s	partitons.length:8
	time:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta/SaveFile20161112230941702	countTime:33.634s	partitons.length:16
	time:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta/SaveFile20161112231020474	countTime:32.927s	partitons.length:34
	time:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta/SaveFile20161112231058702	countTime:136.582s	partitons.length:63

##第二次：Alluxio-1.3.0

	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ tail -f saveFile201611122328.txt 
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D3Line.fasta	countTime:5.697s	partitons.length:2
	time:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D4Line.fasta	countTime:7.714s	partitons.length:2
	time:5
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D5Line.fasta	countTime:7.813s	partitons.length:4
	16/11/12 23:29:43 WARN QueuedThreadPool: 1 threads could not be stopped
	time:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D6Line.fasta	countTime:18.261s	partitons.length:8
	time:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D7Line.fasta	countTime:77.04s	partitons.length:16
	time:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D8Line.fasta	countTime:77.75s	partitons.length:34
	time:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta	countTime:92.287s	partitons.length:63

D9：

	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ time sh test.sh 6G  hdfs://Master:9000/xubo/project/SparkSW/input/'D9Line.fasta' alluxio://Master:19998/xubo/alluxio/uniref/'D9Line.fasta'
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        out:alluxio://Master:19998/xubo/alluxio/uniref/D9Line.fasta	countTime:156.214s	partitons.length:63
	
	real	2m41.526s
	user	0m14.578s
	sys	0m0.941s

##第三次：Alluxio-0.7.1

	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ ./saveFile-0.7.1.sh 
	time:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta	countTime:11.446s	partitons.length:2
	time:2
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta	countTime:11.666s	partitons.length:2
	16/11/13 19:22:22 WARN QueuedThreadPool: 2 threads could not be stopped
	time:3
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta	countTime:19.249s	partitons.length:2
	time:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta	countTime:23.373s	partitons.length:2
	time:5
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta	countTime:42.418s	partitons.length:4
	time:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta	countTime:89.122s	partitons.length:8
	
第七个文件D7卡住了20多分钟没完成，重新跑：

	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ ./saveFile-0.7.1.sh 
	time:7
	^C^[[Ahadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ vi saveFile-0.7.1.sh 
	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ ./saveFile-0.7.1.sh 
	file:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta	countTime:92.267s	partitons.length:16
	file:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta	countTime:110.32s	partitons.length:34
	file:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta	countTime:373.661s	partitons.length:63

##第四次：Alluxio-0.7.1

	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ tail -f saveFile-0.7.1time201611132245.txt 
	file:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta	countTime:6.339s	partitons.length:2
	file:2
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta	countTime:11.167s	partitons.length:2
	file:3
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta	countTime:10.849s	partitons.length:2
	16/11/13 22:45:49 WARN QueuedThreadPool: 2 threads could not be stopped
	file:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta	countTime:15.198s	partitons.length:2
	file:5
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta	countTime:28.717s	partitons.length:4
	file:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta	countTime:40.355s	partitons.length:8
	file:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta	countTime:60.063s	partitons.length:16
	file:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta	countTime:147.046s	partitons.length:34
	file:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta	countTime:320.456s	partitons.length:63

## 第五次：Alluxio-0.7.1

	hadoop@Master:~/disk2/xubo/project/alluxio/saveFile$ tail -f saveFile-0.7.1time201611140810.txt 
	file:1
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D1Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta	Time:7.743s	partitons.length:2
	file:2
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D2Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta	Time:7.977s	partitons.length:2
	file:3
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D3Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta	Time:10.45s	partitons.length:2
	16/11/14 08:11:32 WARN QueuedThreadPool: 3 threads could not be stopped
	file:4
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D4Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta	Time:29.436s	partitons.length:2
	file:5
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D5Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta	Time:18.999s	partitons.length:4
	file:6
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D6Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta	Time:64.348s	partitons.length:8
	file:7
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D7Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta	Time:102.527s	partitons.length:16
	file:8
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D8Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta	Time:149.429s	partitons.length:34
	file:9
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D9Line.fasta        out:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta	Time:338.072s	partitons.length:63
	file:10
	input:hdfs://Master:9000/xubo/project/SparkSW/input/D10Line.fasta       out:tachyon://Master:19998/xubo/alluxio/uniref/D10Line.fasta	Time:619.74s	partitons.length:114


# 5 总结#
## 5.1说明

    没去看源码，之后需要去学习，是观察所得
## 5.1 区别

## 5.1.1 alluxio中load和textFile的区别：

- （1）load单个一个一个加载，textFile多个block并行加载


- （2）load和textFile加载后数据分布不一致
![1](http://i.imgur.com/Y8N5rlo.png)

- （3）load加载后一份，textFile加载后两份数据
-  （4）load串行，textFile两个并行加载

## 5.1.2 多次使用textfile

 多次使用textfile，最后数据会比原来文件大，而且每个节点数据会差不多，推测是每次textfile会重新分布数据，而不是从alluxio读取，没有截图，之前跑alluxio-0.7.1留下的印象  
free之后同一个文件将在各个节点的cache都会free

## 5.2 问题
当在Mcnode1运行时，数据都存在Mcnode1，但在Master运行时，数据存储在work各个节点

原因分析：master没有alluxio的work节点，不存储数据，只管理元数据，所以需要分配到各个节点存储

## textfile（alluxiofile）与 textfile（hdfs file）在saveAsTextFile（alluxio file）的区别
   textfile（alluxiofile）会缓存block，进行count

参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
