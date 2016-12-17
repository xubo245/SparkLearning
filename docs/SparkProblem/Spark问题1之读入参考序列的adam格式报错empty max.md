原因：

读取方法不对

	//    val rdd = sc.loadParquetContigFragments(args(0))
   
解决办法：

    val rdd = sc.loadSequence(args(0))

运行记录：

	hadoop@Master:~/xubo/project/load/loadfastaFromHDFSAdamAndCount$ ./loadGRCH38chr14.sh 
	start:
	1                                                                               
	run time:25802 ms
	*************end*************
	Jun 8, 2016 2:08:11 PM INFO: org.apache.parquet.hadoop.ParquetInputFormat: Total input paths to process : 1
	hadoop@Master:~/xubo/project/load/loadfastaFromHDFSAdamAndCount$ ./loadGRCH38.sh 
	start:
	456                                                                             
	run time:40620 ms
	*************end*************
	Jun 8, 2016 2:08:56 PM INFO: org.apache.parquet.hadoop.ParquetInputFormat: Total input paths to process : 25


报错记录：

	
	hadoop@Master:~/xubo/project/load/loadfastaFromHDFSAdamAndCount$ ./loadGRCH38chr14.sh 
	start:
	[Stage 1:=============================>                             (2 + 2) / 4]16/06/08 14:05:52 ERROR TaskSetManager: Task 0 in stage 1.0 failed 4 times; aborting job
	Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 1.0 failed 4 times, most recent failure: Lost task 0.3 in stage 1.0 (TID 12, Mcnode3): java.lang.UnsupportedOperationException: empty.max
		at scala.collection.TraversableOnce$class.max(TraversableOnce.scala:216)
		at scala.collection.AbstractTraversable.max(Traversable.scala:105)
		at org.bdgenomics.adam.converters.FastaConverter$.findContigIndex(FastaConverter.scala:126)
		at org.bdgenomics.adam.converters.FastaConverter$$anonfun$7.apply(FastaConverter.scala:86)
		at org.bdgenomics.adam.converters.FastaConverter$$anonfun$7.apply(FastaConverter.scala:86)
		at org.apache.spark.rdd.RDD$$anonfun$keyBy$1$$anonfun$apply$52.apply(RDD.scala:1465)
		at org.apache.spark.rdd.RDD$$anonfun$keyBy$1$$anonfun$apply$52.apply(RDD.scala:1465)
		at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
		at org.apache.spark.shuffle.sort.BypassMergeSortShuffleWriter.insertAll(BypassMergeSortShuffleWriter.java:119)
		at org.apache.spark.shuffle.sort.SortShuffleWriter.write(SortShuffleWriter.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:41)
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
		at org.gcdss.cli.load.loadfastaFromHDFSAdamAndCount$.main(loadfastaFromHDFSAdamAndCount.scala:22)
		at org.gcdss.cli.load.loadfastaFromHDFSAdamAndCount.main(loadfastaFromHDFSAdamAndCount.scala)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:606)
		at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
		at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
		at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
		at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
		at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
	Caused by: java.lang.UnsupportedOperationException: empty.max
		at scala.collection.TraversableOnce$class.max(TraversableOnce.scala:216)
		at scala.collection.AbstractTraversable.max(Traversable.scala:105)
		at org.bdgenomics.adam.converters.FastaConverter$.findContigIndex(FastaConverter.scala:126)
		at org.bdgenomics.adam.converters.FastaConverter$$anonfun$7.apply(FastaConverter.scala:86)
		at org.bdgenomics.adam.converters.FastaConverter$$anonfun$7.apply(FastaConverter.scala:86)
		at org.apache.spark.rdd.RDD$$anonfun$keyBy$1$$anonfun$apply$52.apply(RDD.scala:1465)
		at org.apache.spark.rdd.RDD$$anonfun$keyBy$1$$anonfun$apply$52.apply(RDD.scala:1465)
		at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
		at org.apache.spark.shuffle.sort.BypassMergeSortShuffleWriter.insertAll(BypassMergeSortShuffleWriter.java:119)
		at org.apache.spark.shuffle.sort.SortShuffleWriter.write(SortShuffleWriter.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:73)
		at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:41)
		at org.apache.spark.scheduler.Task.run(Task.scala:88)
		at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
		at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
		at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
		at java.lang.Thread.run(Thread.java:745)
