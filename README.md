
为了更好的学习和理解spark，也为了记录自己学习过程中的遇到的各种问题，方便以后查询，故谢了相关博客，也公开了代码和数据，代码基本都可以本地(local)运行。论文部分由于是ppt，故没有放上来。

总目录：  
SparkLearning博客：http://blog.csdn.net/bob601450868/article/category/5730447  
SparkLearning代码和数据：https://github.com/xubo245/SparkLearning

SparkLearning是在spark上运行的，spark搭建等请见spark官网或其他网站。
SparkLearning运行环境:  
Spark-1.5.2  
eclipse-4.3.2  
scala-2.10.4  
jdk1.7  
spark-assembly-1.5.2-hadoop2.6.0.jar
idea 15.04


具体博客目录：  
**1.Spark基本学习篇：**  
spark学习1之examples运行：http://blog.csdn.net/xubo245/article/details/48548079  
spark学习2之OutOfMemoryError错误的解决办法：http://blog.csdn.net/xubo245/article/details/48548507  
spark学习3之examples中的SparkPi：http://blog.csdn.net/xubo245/article/details/50596227  
spark学习4之集群上直接用scalac编译.scala出现的MissingRequirementError问题（已解决）:http://blog.csdn.net/xubo245/article/details/50596822   
spark学习5之sbt问题:http://blog.csdn.net/xubo245/article/details/50603502  
spark学习6之scala版本不同的问题：http://blog.csdn.net/xubo245/article/  details/50609476    
spark学习7之IDEA下搭建SPark本地编译环境并上传到集群运行：http://blog.csdn.net/xubo245/article/details/50789983    
spark学习8之eclipse安装scala2.10和spark编译环境并上传到集群运行：http://blog.csdn.net/xubo245/article/details/50790463  
spark学习9之在window下进行源码编译打包：http://blog.csdn.net/xubo245/article/details/51386564  
spark学习10之将spark的AppName设置为自动获取当前类名：http://blog.csdn.net/xubo245/article/details/51428158  
spark学习11之在idea中将eclipse导入的java project改成maven project：http://blog.csdn.net/xubo245/article/details/51428502   

**2.Spark代码篇：**
Spark代码1之RDDparallelizeSaveAsFile：http://blog.csdn.net/xubo245/article/details/50791485  
Spark代码2之Transformation：union，distinct，join：http://blog.csdn.net/xubo245/article/details/50792201  
Spark代码3之Action：reduce，reduceByKey,sorted,lookup,take,saveAsTextFile：http://blog.csdn.net/xubo245/article/details/50800934  
Spark代码4之Spark 文件API及其对搜狗数据的操作：http://blog.csdn.net/xubo245/article/details/50801827  


**3.Spark组件之Mllib学习篇**  
Spark中组件Mllib的学习1之Kmeans错误解决：http://blog.csdn.net/xubo245/article/details/51007690  
Spark中组件Mllib的学习2之MovieLensALS学习（集群run-eaxmples运行）：http://blog.csdn.net/xubo245/article/details/51264145  
Spark中组件Mllib的学习3之用户相似度计算：http://blog.csdn.net/xubo245/article/details/51428175  
Spark中组件Mllib的学习4之examples中的MovieLensALS修改本地运行：http://blog.csdn.net/xubo245/article/details/51429221  
Spark中组件Mllib的学习5之ALS测试（apache spark）：http://blog.csdn.net/xubo245/article/details/51429365  
Spark中组件Mllib的学习6之ALS测试（apache spark 含隐式转换）：http://blog.csdn.net/xubo245/article/details/51429391  
Spark中组件Mllib的学习7之ALS隐式转换训练的model来预测数据：http://blog.csdn.net/xubo245/article/details/51429490  
Spark中组件Mllib的学习8之ALS训练的model来预测数据：http://blog.csdn.net/xubo245/article/details/51429503  
Spark中组件Mllib的学习9之ALS训练的model来预测数据的准确率研究：http://blog.csdn.net/xubo245/article/details/51439208  
Spark中组件Mllib的学习10之修改MovieLens来对movieLen中的100k数据进行预测：http://blog.csdn.net/xubo245/article/details/51439491   
Spark中组件Mllib的学习11之使用ALS对movieLens中一百万条（1M）数据集进行训练，并对输入的新用户数据进行电影推荐：http://blog.csdn.net/xubo245/article/details/51439920   
更多请见：https://github.com/xubo245/SparkLearning/tree/master/docs/Spark%20MLlib%E5%AD%A6%E4%B9%A0

**4.Spark组件之SparkSQL学习篇**  
Spark组件之SparkSQL学习1之问题报错No TypeTag available for Person：http://blog.csdn.net/xubo245/article/details/51153243  
SparkSQL在代码库中还有不少，当时没写成博客

**5.Spark组件之SparkR学习篇**  
Spark组件之SparkR学习1--安装与测试：http://blog.csdn.net/xubo245/article/details/51195287  
Spark组件之SparkR学习2--使用spark-submit向集群提交R代码文件dataframe.R：http://blog.csdn.net/xubo245/article/details/51199216  
 Spark组件之SparkR学习3--使用spark-submit向集群提交R代码文件data-manipulation.R：http://blog.csdn.net/xubo245/article/details/51199813  
 Spark组件之SparkR学习4--Eclipse下R语言环境搭建：http://blog.csdn.net/xubo245/article/details/51199918  
 Spark组件之SparkR学习5--R语言函数调用（跨文件调用）：http://blog.csdn.net/xubo245/article/details/51205276  

**6.Spark组件之Spark Streaming学习篇**  
Spark组件之Spark Streaming学习1--NetworkWordCount学习：http://blog.csdn.net/xubo245/article/details/51251970  
Spark组件之Spark Streaming学习2--StatefulNetworkWordCount 学习：http://blog.csdn.net/xubo245/article/details/51252142  
Spark组件之Spark Streaming学习3--结合SparkSQL的使用(wordCount)：http://blog.csdn.net/xubo245/article/details/51252229  
Spark组件之Spark Streaming学习4--HdfsWordCount 学习：http://blog.csdn.net/xubo245/article/details/51254412  

**7. Spark组件之GraphX学习篇**  
Spark组件之GraphX学习1--入门实例Property Graph：http://blog.csdn.net/xubo245/article/details/51306975  
Spark组件之GraphX学习2--triplets实践：http://blog.csdn.net/xubo245/article/details/51307037  
Spark组件之GraphX学习3--Structural Operators：subgraph：http://blog.csdn.net/xubo245/article/details/51307162  
Spark组件之GraphX学习4--Structural Operators：mask：http://blog.csdn.net/xubo245/article/details/51307237  
Spark组件之GraphX学习5--随机图生成和消息发送aggregateMessages以及mapreduce操作（含源码分析）：http://blog.csdn.net/xubo245/article/details/51307386  
Spark组件之GraphX学习6--随机图生成和出度入度等信息显示：http://blog.csdn.net/xubo245/article/details/51307641  
Spark组件之GraphX学习7--随机图生成和reduce最大或最小出度/入度/度：http://blog.csdn.net/xubo245/article/details/51307774    
Spark组件之GraphX学习8--随机图生成和TopK最大入度：http://blog.csdn.net/xubo245/article/details/51308278  
Spark组件之GraphX学习8--邻居集合：http://blog.csdn.net/xubo245/article/details/51308337  
Spark组件之GraphX学习9--使用pregel函数求单源最短路径：http://blog.csdn.net/xubo245/article/details/51314928  
Spark组件之GraphX学习10--PageRank学习和使用（From examples）：http://blog.csdn.net/xubo245/article/details/51315240  
Spark组件之GraphX学习11--PageRank例子（PageRankAboutBerkeleyWiki）：http://blog.csdn.net/xubo245/article/details/51316151  
Spark组件之GraphX学习12--GraphX常见操作汇总SimpleGraphX：http://blog.csdn.net/xubo245/article/details/51316317  
Spark组件之GraphX学习13--ConnectedComponents操作：http://blog.csdn.net/xubo245/article/details/51316654  
Spark组件之GraphX学习14--TriangleCount实例和分析：http://blog.csdn.net/xubo245/article/details/51317245  
Spark组件之GraphX学习15--we-Google.txt大图分析：http://blog.csdn.net/xubo245/article/details/51317594  
Spark组件之GraphX学习16--最短路径ShortestPaths：http://blog.csdn.net/xubo245/article/details/51317892  
Spark组件之GraphX学习20--待学习部分：http://blog.csdn.net/xubo245/article/details/51317710  


**8.Spark-Avro学习篇**  
Spark-Avro学习1之使用SparkSQL读取AVRO文件：http://blog.csdn.net/xubo245/article/details/51295474  
Spark-Avro学习2之使用byDatabricksSparkAvroL读取AVRO文件:http://blog.csdn.net/xubo245/article/details/51295593  
Spark-Avro学习3之使用AvroCompression存储AVRO文件:http://blog.csdn.net/xubo245/article/details/51295604  
Spark-Avro学习4之使用AvroWritePartitioned存储AVRO文件时进行划分:http://blog.csdn.net/xubo245/article/details/51295627  
Spark-Avro学习5之使用AvroReadSpecifyName存储AVRO文件时指定name和namespace:http://blog.csdn.net/xubo245/article/details/51295642  
Spark-Avro学习6之Ubuntu下安装:http://blog.csdn.net/xubo245/article/details/51295674  
Spark-Avro学习7之Java Avro使用（生成code方式）:http://blog.csdn.net/xubo245/article/details/51295843  
Spark-Avro学习8之Java Avro使用（不生成code方式）:Spark-Avro学习8之Java Avro使用（不生成code方式） 
Spark-Avro学习9之SCALA环境下Avro使用（不生成code方式）:http://blog.csdn.net/xubo245/article/details/51296717  
 
**9.Spark生态之Tachyon学习篇**  
Spark生态之Tachyon学习1---单机版搭建和运行（Alluxio）：http://blog.csdn.net/xubo245/article/details/51318566  
Spark生态之Tachyon学习2---Spark从tachyon中读取文件（Alluxio）：http://blog.csdn.net/xubo245/article/details/51318863  
Spark生态之Tachyon学习3---机器重启后数据存储位置的变化：http://blog.csdn.net/xubo245/article/details/51322437  
Spark生态之Tachyon学习4---下载源码通过maven install安装失败记录：http://blog.csdn.net/xubo245/article/details/51322911  
Spark生态之Tachyon学习5--tachyon的几个问题（待解决）：http://blog.csdn.net/xubo245/article/details/51323101  
Spark生态之Tachyon学习6---集群版搭建和运行（Alluxio）：http://blog.csdn.net/xubo245/article/details/51324273  
Spark生态之Tachyon学习7--下载源码通过maven安装成功：http://blog.csdn.net/xubo245/article/details/51325776  
Spark生态之Tachyon学习6---集群版搭建问题之集群无法全部启动：http://blog.csdn.net/xubo245/article/details/51325834  
Spark生态之Tachyon学习7---Tachyon的优点：http://blog.csdn.net/xubo245/article/details/51326644  
  

**10.Spark生态之spark-csv篇：**  
Spark生态之Spark-csv学习1之安装和简单的examples：http://blog.csdn.net/xubo245/article/details/51184946  

**11.Spark疑问篇**  
Spark疑问1之如何查看sparkContext没有关闭的sc：http://blog.csdn.net/xubo245/article/details/51173463  
Spark疑问2之spark 丢了executor会恢复吗？：http://blog.csdn.net/xubo245/article/details/51173493  

**12.其他：**   
MLlib学习文档：https://github.com/xubo245/SparkLearning/tree/master/docs/Spark%20MLlib%E5%AD%A6%E4%B9%A0
