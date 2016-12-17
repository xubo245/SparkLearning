
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio（tachyon） 0.7.1，spark-1.5.2,hadoop-2.6.0

# 1.问题描述 #

window下打开hdfs，会出现问题：hdfs常配置了hosts，访问或者下载hdfs的文件时（通过浏览器），回出现跳转的是hostname，而不是ip，而window下没有配置hosts，所以访问不了，需要手动设置ip，麻烦

# 2.解决办法： #
设置window的hosts
修改C:\Windows\System32\drivers\etc下的hosts文件
 
在

	#   127.0.0.1       localhost  
	#   ::1             localhost  
后加入自己的host关联


# 3.运行记录： #

可以访问集群并且下载文件：

	http://Master:50070/webhdfs/v1/xubo/project/SparkSW/output/time/20161106204334687SparkSW_queryFile_0P18691.file_dbFile_D1Line.fasta_splitNum_32_taskNum_1_file/part-00000?op=OPEN

参考

	【1】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【2】https://github.com/xubo245/SparkLearning
