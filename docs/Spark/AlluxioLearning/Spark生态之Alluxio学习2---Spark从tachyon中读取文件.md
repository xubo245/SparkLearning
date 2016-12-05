

1.启动spark-shell

2.上传文件到tachyon：

	xubo@xubo:~/cloud/test/tachyon$ ../../tachyon-0.7.1/bin/tachyon tfs copyFromLocal 1.txt /
	Copied 1.txt to /
	xubo@xubo:~/cloud/test/tachyon$ ../../tachyon-0.7.1/bin/tachyon tfs cat /1.txt
	hello tachyon
	1
	2
	3

3.读取：


	scala> val text1= sc.textFile("tachyon://localhost:19998/1.txt")
	text1: org.apache.spark.rdd.RDD[String] = MapPartitionsRDD[1] at textFile at <console>:21
	
	scala> text
	text1   text    
	
	scala> text1.foreach
	foreach            foreachPartition   foreachWith        
	
	scala> text1.foreach
	                                  def foreach(f: T => Unit): Unit   
	
	scala> text1.foreach(println)
	1
	hello tachyon
	2
	3

