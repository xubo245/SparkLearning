
为了更好的学习和理解spark，也为了记录自己学习过程中遇到的各种问题，方便以后查询，故写了相关博客，也公开了代码和数据，代码基本都可以本地(local)运行。论文部分由于是ppt，故没有放上来。

# 0.总目录：
SparkLearning博客：http://blog.csdn.net/bob601450868/article/category/5730447  
SparkLearning代码和数据：https://github.com/xubo245/SparkLearning  
书籍和视频等学习资料推荐：<a href="https://github.com/xubo245/SparkLearning/blob/master/docs/Spark%E5%AD%A6%E4%B9%A0%E8%B5%84%E6%96%99%E6%B1%87%E6%80%BB.md"> Spark学习资料汇总 </a>

# 1.环境 
SparkLearning是在spark上运行的，spark搭建等请见spark官网或其他网站。
SparkLearning运行环境:  
Spark-1.5.2  
eclipse-4.3.2  
scala-2.10.4  
jdk1.7  
idea 15.04  
spark-assembly-1.5.2-hadoop2.6.0.jar(下载地址: http://pan.baidu.com/s/1hrSxiDI)   


# 2.说明： 
SparkLearning项目带有数据，下载会比较慢，如果只想下载部分文件夹，可以使用svn。另外也在20160810弄了一个没有数据的project，方便下载：https://github.com/xubo245/SparkLearning_NoData

# 3.具体博客目录： 
## (1).Spark基本学习篇： 
[SparkBaseLearning文档](./docs/Spark/SparkBaseLearning)  
[SparkBaseLearning代码](./src/main/scala/org/apache/spark/examples)

## (2).Spark代码篇： 
[SparkCodeLearning文档](./docs/Spark/SparkCodeLearning)  
[SparkCodeLearning代码](./src/main/scala/org/apache/spark/rdd)

## (3).Spark组件之Mllib学习篇 
[MLlibLearning文档](./docs/Spark/MLlibLearning)  
[MLlibLearning代码](./src/main/scala/org/apache/spark/mllib)

## (4).Spark组件之SparkSQL学习篇 
[SparkSQLLearning文档](./docs/Spark/SparkSQLLearning)  
[SparkSQLLearning代码](./src/main/scala/org/apache/spark/sql)

## (5).Spark组件之SparkR学习篇 
[SparkRLearning文档](./docs/Spark/SparkRLearning)  
[SparkRLearning代码](./src/main/scala/org/apache/spark/R)

## (6).Spark组件之Spark Streaming学习篇 
[SparkStreamingLearning文档](./docs/Spark/SparkStreamingLearning)  
[SparkStreamingLearning代码](./src/main/scala/org/apache/spark/Streaming)

## (7). Spark组件之GraphX学习篇 
[GraphXLearning文档](./docs/Spark/GraphXLearning)  
[GraphXLearning代码](./src/main/scala/org/apache/spark/graphx)

## (8).Spark-Avro学习篇 
[SparkAvroLearning文档](./docs/Spark/SparkAvroLearning)  
[SparkAvroLearning代码](./src/main/scala/org/apache/spark/avro)

## (9).Spark生态之Alluxio(Tachyon)学习篇 
[AlluxioLearning文档](./docs/Spark/AlluxioLearning)  
[AlluxioLearning代码](./src/main/scala/org/apache/spark/tachyon)
 
## (10).Spark生态之spark-csv篇： 
[SparkCsvLearning文档](./docs/Spark/SparkCsvLearning)  
[SparkCsvLearning代码](./src/main/scala/org/apache/spark/sparkCSV)

## (11).Spark疑问篇 
[SparkQuestion文档](./docs/Spark/SparkQuestion)

## (12).MLLearning： 
[MLLearning文档](./docs/Spark/MLLearning)  
[MLLearning代码](./src/main/scala/org/apache/spark/ml)

## (13). Spark源码学习
[SparkSourceLearning文档](./docs/SparkSourceLearning)  
[SparkSourceLearning代码](./src/main/scala/org/apache/spark/sourceCode)


##Help 
If you have any questions or suggestions, please write it in the issue of this project or send an e-mail to me: xubo245@mail.ustc.edu.cn

Wechat: xu601450868  
QQ: 601450868