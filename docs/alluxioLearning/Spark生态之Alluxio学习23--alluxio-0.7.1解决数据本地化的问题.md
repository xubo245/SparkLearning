
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

# 1.解释 #

spark-1.5.2和alluxio-1.3.0默认不支持数据本地化，所以会有跨节点传输

# 2.解决办法： #

## 2.1 方法1##
使用alluxio-0.7.1

## 2.2 方法2##

设置spark本地化配置，参考【5】  
各个节点分别配置  
实验分析支持NODE_LOCAL

# 3.结果： #
	
	hadoop@Master:~/disk2/xubo/project/alluxio/timeCount$ tail -f run1-0.7.1time201611132026.txt 
	time:1
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.812s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.87s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:4.046s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.942s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.818s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.773s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.837s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.756s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.864s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D1Line.fasta   count:78295     countTime:3.811s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:3.964s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.792s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.013s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:3.87s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.066s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:3.976s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:3.893s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.242s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:3.969s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D2Line.fasta   count:156590    countTime:4.183s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:3.987s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.035s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.128s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.137s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.253s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.139s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.059s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.051s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.074s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D3Line.fasta   count:313180    countTime:4.197s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.313s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.36s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.372s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.329s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.379s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.299s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.382s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.33s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.26s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D4Line.fasta   count:626360    countTime:4.306s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.565s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.419s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.39s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:5.67s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.632s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.513s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.474s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.492s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.574s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D5Line.fasta   count:1252720   countTime:4.586s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.643s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.67s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:5.148s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.722s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.639s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.561s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:5.089s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:5.238s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.677s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D6Line.fasta   count:2505440   countTime:4.723s
	time:1
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:6.634s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:6.763s
	time:3
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:5.376s
	time:4
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:5.515s
	time:5
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:5.274s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:5.447s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:5.512s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:6.46s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:5.394s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D7Line.fasta   count:5019006   countTime:5.373s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.527s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.64s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.574s
	time:4                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.482s
	time:5                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.718s
	time:6
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.509s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.583s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.643s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.602s
	time:10                                                                         
	input:tachyon://Master:19998/xubo/alluxio/uniref/D8Line.fasta   count:10038012  countTime:6.573s
	time:1                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:10.066s
	time:2                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:10.084s
	time:3                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:10.93s
	time:4
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:10.347s
	time:5
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:9.976s
	time:6                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:10.817s
	time:7                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:10.358s
	time:8                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:9.881s
	time:9                                                                          
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:10.23s
	time:10
	input:tachyon://Master:19998/xubo/alluxio/uniref/D9Line.fasta   count:20076024  countTime:10.119s
	

参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
	【5】http://www.alluxio.org/docs/master/cn/Running-Spark-on-Alluxio.html
