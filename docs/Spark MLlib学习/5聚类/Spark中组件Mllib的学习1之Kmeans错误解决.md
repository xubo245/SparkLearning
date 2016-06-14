	更多代码请见：https://github.com/xubo245/SparkLearning
		
		
	解决办法：（中间比较多，为了方便看到，放在最开始）
		
	txt文件格式不对，用WPS转存的是UTF-16，spark跑的时候有问题
		
	代码和数据请参考【1】【2】
		
		
	问题：
		
		hadoop@Master:~/cloud/testByXubo/sh_spark_xubo/mllib/kmeans/KMeansTest3ByIBM$ ./submitJob.sh 
		[Stage 0:>                                                          (0 + 2) / 2]16/03/29 17:16:07 ERROR TaskSetManager: Task 1 in stage 0.0 failed 4 times; aborting job
		Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 1 in stage 0.0 failed 4 times, most recent failure: Lost task 1.3 in stage 0.0 (TID 6, 219.219.220.223): java.lang.NumberFormatException: For input string: "6373"
			at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1250)
			at java.lang.Double.parseDouble(Double.java:540)
			at scala.collection.immutable.StringLike$class.toDouble(StringLike.scala:232)
			at scala.collection.immutable.StringOps.toDouble(StringOps.scala:31)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.IndexedSeqOptimized$class.foreach(IndexedSeqOptimized.scala:33)
			at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:108)
			at scala.collection.TraversableLike$class.map(TraversableLike.scala:244)
			at scala.collection.mutable.ArrayOps$ofRef.map(ArrayOps.scala:108)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:26)
			at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
			at org.apache.spark.storage.MemoryStore.unrollSafely(MemoryStore.scala:278)
			at org.apache.spark.CacheManager.putInBlockManager(CacheManager.scala:171)
			at org.apache.spark.CacheManager.getOrCompute(CacheManager.scala:78)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:262)
			at org.apache.spark.rdd.ZippedPartitionsRDD2.compute(ZippedPartitionsRDD.scala:99)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
			at org.apache.spark.rdd.MapPartitionsRDD.compute(MapPartitionsRDD.scala:38)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
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
			at org.apache.spark.rdd.RDD.takeSample(RDD.scala:489)
			at org.apache.spark.mllib.clustering.KMeans.initKMeansParallel(KMeans.scala:376)
			at org.apache.spark.mllib.clustering.KMeans.runAlgorithm(KMeans.scala:249)
			at org.apache.spark.mllib.clustering.KMeans.run(KMeans.scala:213)
			at org.apache.spark.mllib.clustering.KMeans$.train(KMeans.scala:520)
			at org.apache.spark.mllib.clustering.KMeans$.train(KMeans.scala:543)
			at mllib.KMeansTest4ByIBm$.main(KMeansTest4ByIBM.scala:34)
			at mllib.KMeansTest4ByIBm.main(KMeansTest4ByIBM.scala)
			at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
			at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
			at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
			at java.lang.reflect.Method.invoke(Method.java:606)
			at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
			at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
			at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
			at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
			at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
		Caused by: java.lang.NumberFormatException: For input string: "6373"
			at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1250)
			at java.lang.Double.parseDouble(Double.java:540)
			at scala.collection.immutable.StringLike$class.toDouble(StringLike.scala:232)
			at scala.collection.immutable.StringOps.toDouble(StringOps.scala:31)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.IndexedSeqOptimized$class.foreach(IndexedSeqOptimized.scala:33)
			at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:108)
			at scala.collection.TraversableLike$class.map(TraversableLike.scala:244)
			at scala.collection.mutable.ArrayOps$ofRef.map(ArrayOps.scala:108)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:26)
			at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
			at org.apache.spark.storage.MemoryStore.unrollSafely(MemoryStore.scala:278)
			at org.apache.spark.CacheManager.putInBlockManager(CacheManager.scala:171)
			at org.apache.spark.CacheManager.getOrCompute(CacheManager.scala:78)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:262)
			at org.apache.spark.rdd.ZippedPartitionsRDD2.compute(ZippedPartitionsRDD.scala:99)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
			at org.apache.spark.rdd.MapPartitionsRDD.compute(MapPartitionsRDD.scala:38)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
			at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
			at org.apache.spark.scheduler.Task.run(Task.scala:88)
			at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
			at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
			at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
			at java.lang.Thread.run(Thread.java:745)
		hadoop@Master:~/cloud/testByXubo/sh_spark_xubo/mllib/kmeans/KMeansTest3ByIBM$ ^C
		hadoop@Master:~/cloud/testByXubo/sh_spark_xubo/mllib/kmeans/KMeansTest3ByIBM$ ./submitJob.sh 
		[Stage 0:>                                                          (0 + 2) / 2]16/03/29 17:17:15 ERROR TaskSetManager: Task 0 in stage 0.0 failed 4 times; aborting job
		Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 0.0 failed 4 times, most recent failure: Lost task 0.3 in stage 0.0 (TID 6, 219.219.220.223): java.lang.NumberFormatException: For input string: "??Channel"
			at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1250)
			at java.lang.Double.parseDouble(Double.java:540)
			at scala.collection.immutable.StringLike$class.toDouble(StringLike.scala:232)
			at scala.collection.immutable.StringOps.toDouble(StringOps.scala:31)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.IndexedSeqOptimized$class.foreach(IndexedSeqOptimized.scala:33)
			at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:108)
			at scala.collection.TraversableLike$class.map(TraversableLike.scala:244)
			at scala.collection.mutable.ArrayOps$ofRef.map(ArrayOps.scala:108)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:26)
			at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
			at org.apache.spark.storage.MemoryStore.unrollSafely(MemoryStore.scala:278)
			at org.apache.spark.CacheManager.putInBlockManager(CacheManager.scala:171)
			at org.apache.spark.CacheManager.getOrCompute(CacheManager.scala:78)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:262)
			at org.apache.spark.rdd.ZippedPartitionsRDD2.compute(ZippedPartitionsRDD.scala:99)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
			at org.apache.spark.rdd.MapPartitionsRDD.compute(MapPartitionsRDD.scala:38)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
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
			at org.apache.spark.rdd.RDD.takeSample(RDD.scala:489)
			at org.apache.spark.mllib.clustering.KMeans.initKMeansParallel(KMeans.scala:376)
			at org.apache.spark.mllib.clustering.KMeans.runAlgorithm(KMeans.scala:249)
			at org.apache.spark.mllib.clustering.KMeans.run(KMeans.scala:213)
			at org.apache.spark.mllib.clustering.KMeans$.train(KMeans.scala:520)
			at org.apache.spark.mllib.clustering.KMeans$.train(KMeans.scala:543)
			at mllib.KMeansTest4ByIBm$.main(KMeansTest4ByIBM.scala:34)
			at mllib.KMeansTest4ByIBm.main(KMeansTest4ByIBM.scala)
			at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
			at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
			at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
			at java.lang.reflect.Method.invoke(Method.java:606)
			at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
			at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
			at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
			at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
			at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
		Caused by: java.lang.NumberFormatException: For input string: "??Channel"
			at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1250)
			at java.lang.Double.parseDouble(Double.java:540)
			at scala.collection.immutable.StringLike$class.toDouble(StringLike.scala:232)
			at scala.collection.immutable.StringOps.toDouble(StringOps.scala:31)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.IndexedSeqOptimized$class.foreach(IndexedSeqOptimized.scala:33)
			at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:108)
			at scala.collection.TraversableLike$class.map(TraversableLike.scala:244)
			at scala.collection.mutable.ArrayOps$ofRef.map(ArrayOps.scala:108)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:26)
			at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
			at org.apache.spark.storage.MemoryStore.unrollSafely(MemoryStore.scala:278)
			at org.apache.spark.CacheManager.putInBlockManager(CacheManager.scala:171)
			at org.apache.spark.CacheManager.getOrCompute(CacheManager.scala:78)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:262)
			at org.apache.spark.rdd.ZippedPartitionsRDD2.compute(ZippedPartitionsRDD.scala:99)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
			at org.apache.spark.rdd.MapPartitionsRDD.compute(MapPartitionsRDD.scala:38)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
			at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
			at org.apache.spark.scheduler.Task.run(Task.scala:88)
			at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
			at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
			at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
			at java.lang.Thread.run(Thread.java:745)
		hadoop@Master:~/cloud/testByXubo/sh_spark_xubo/mllib/kmeans/KMeansTest3ByIBM$ rz
		rz waiting to receive.
		hadoop@Master:~/cloud/testByXubo/sh_spark_xubo/mllib/kmeans/KMeansTest3ByIBM$ hadoop fs -put Wholesale_customers_data_t.txt /xubo/spark/data/mllib/kmeans/
		Wholesale_customers_data_test2.txt   Wholesale_customers_data_test.txt    Wholesale_customers_data_train2.txt  Wholesale_customers_data_train.txt   
		hadoop@Master:~/cloud/testByXubo/sh_spark_xubo/mllib/kmeans/KMeansTest3ByIBM$ hadoop fs -put Wholesale_customers_data_t*2.txt /xubo/spark/data/mllib/kmeans/
		hadoop@Master:~/cloud/testByXubo/sh_spark_xubo/mllib/kmeans/KMeansTest3ByIBM$ vi submitJob.sh 
		hadoop@Master:~/cloud/testByXubo/sh_spark_xubo/mllib/kmeans/KMeansTest3ByIBM$ ./submitJob.sh 
		[Stage 0:>                                                          (0 + 1) / 2]16/03/29 17:19:53 ERROR TaskSetManager: Task 0 in stage 0.0 failed 4 times; aborting job
		Exception in thread "main" org.apache.spark.SparkException: Job aborted due to stage failure: Task 0 in stage 0.0 failed 4 times, most recent failure: Lost task 0.3 in stage 0.0 (TID 5, 219.219.220.248): java.lang.NumberFormatException: For input string: "??Channel"
			at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1250)
			at java.lang.Double.parseDouble(Double.java:540)
			at scala.collection.immutable.StringLike$class.toDouble(StringLike.scala:232)
			at scala.collection.immutable.StringOps.toDouble(StringOps.scala:31)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.IndexedSeqOptimized$class.foreach(IndexedSeqOptimized.scala:33)
			at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:108)
			at scala.collection.TraversableLike$class.map(TraversableLike.scala:244)
			at scala.collection.mutable.ArrayOps$ofRef.map(ArrayOps.scala:108)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:26)
			at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
			at org.apache.spark.storage.MemoryStore.unrollSafely(MemoryStore.scala:278)
			at org.apache.spark.CacheManager.putInBlockManager(CacheManager.scala:171)
			at org.apache.spark.CacheManager.getOrCompute(CacheManager.scala:78)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:262)
			at org.apache.spark.rdd.ZippedPartitionsRDD2.compute(ZippedPartitionsRDD.scala:99)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
			at org.apache.spark.rdd.MapPartitionsRDD.compute(MapPartitionsRDD.scala:38)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
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
			at org.apache.spark.rdd.RDD.takeSample(RDD.scala:489)
			at org.apache.spark.mllib.clustering.KMeans.initKMeansParallel(KMeans.scala:376)
			at org.apache.spark.mllib.clustering.KMeans.runAlgorithm(KMeans.scala:249)
			at org.apache.spark.mllib.clustering.KMeans.run(KMeans.scala:213)
			at org.apache.spark.mllib.clustering.KMeans$.train(KMeans.scala:520)
			at org.apache.spark.mllib.clustering.KMeans$.train(KMeans.scala:543)
			at mllib.KMeansTest4ByIBm$.main(KMeansTest4ByIBM.scala:34)
			at mllib.KMeansTest4ByIBm.main(KMeansTest4ByIBM.scala)
			at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
			at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
			at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
			at java.lang.reflect.Method.invoke(Method.java:606)
			at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:674)
			at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:180)
			at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:205)
			at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
			at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
		Caused by: java.lang.NumberFormatException: For input string: "??Channel"
			at sun.misc.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1250)
			at java.lang.Double.parseDouble(Double.java:540)
			at scala.collection.immutable.StringLike$class.toDouble(StringLike.scala:232)
			at scala.collection.immutable.StringOps.toDouble(StringOps.scala:31)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2$$anonfun$apply$3.apply(KMeansTest4ByIBM.scala:27)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:244)
			at scala.collection.IndexedSeqOptimized$class.foreach(IndexedSeqOptimized.scala:33)
			at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:108)
			at scala.collection.TraversableLike$class.map(TraversableLike.scala:244)
			at scala.collection.mutable.ArrayOps$ofRef.map(ArrayOps.scala:108)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:27)
			at mllib.KMeansTest4ByIBm$$anonfun$2.apply(KMeansTest4ByIBM.scala:26)
			at scala.collection.Iterator$$anon$11.next(Iterator.scala:328)
			at org.apache.spark.storage.MemoryStore.unrollSafely(MemoryStore.scala:278)
			at org.apache.spark.CacheManager.putInBlockManager(CacheManager.scala:171)
			at org.apache.spark.CacheManager.getOrCompute(CacheManager.scala:78)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:262)
			at org.apache.spark.rdd.ZippedPartitionsRDD2.compute(ZippedPartitionsRDD.scala:99)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
			at org.apache.spark.rdd.MapPartitionsRDD.compute(MapPartitionsRDD.scala:38)
			at org.apache.spark.rdd.RDD.computeOrReadCheckpoint(RDD.scala:300)
			at org.apache.spark.rdd.RDD.iterator(RDD.scala:264)
			at org.apache.spark.scheduler.ResultTask.runTask(ResultTask.scala:66)
			at org.apache.spark.scheduler.Task.run(Task.scala:88)
			at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:214)
			at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
			at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
			at java.lang.Thread.run(Thread.java:745)
		
		
		解决办法：
		
		txt文件格式不对，用WPS转存的是UTF-16，spark跑的时候有问题
		
		代码和数据请参考【1】【2】
		
		
		修改后输出结果：
		
		hadoop@Master:~/cloud/testByXubo/sh_spark_xubo/mllib/kmeans/KMeansTest3ByIBM$ ./submitJob.sh 
		Cluster Number:3
		Cluster Centers Information Overview:
		Center Point of Cluster 0:
		[1.4444444444444444,3.0,5865.666666666666,8412.555555555555,16215.22222222222,941.6666666666666,6087.222222222222,1186.7777777777776]
		Center Point of Cluster 1:
		[1.2142857142857142,3.0,24160.714285714283,5445.0,6098.214285714285,4655.571428571428,1180.857142857143,1076.4285714285713]
		Center Point of Cluster 2:
		[1.1111111111111112,3.0,6711.666666666666,3035.3888888888887,3721.8888888888887,4097.611111111111,1041.6666666666665,1636.2777777777776]
		The data [2.0,3.0,12669.0,9656.0,7561.0,214.0,2674.0,1338.0] belongs to cluster 2
		The data [2.0,3.0,7057.0,9810.0,9568.0,1762.0,3293.0,1776.0] belongs to cluster 0
		The data [2.0,3.0,6353.0,8808.0,7684.0,2405.0,3516.0,7844.0] belongs to cluster 2
		The data [1.0,3.0,13265.0,1196.0,4221.0,6404.0,507.0,1788.0] belongs to cluster 2
		The data [2.0,3.0,22615.0,5410.0,7198.0,3915.0,1777.0,5185.0] belongs to cluster 1
		The data [2.0,3.0,9413.0,8259.0,5126.0,666.0,1795.0,1451.0] belongs to cluster 2
		The data [2.0,3.0,12126.0,3199.0,6975.0,480.0,3140.0,545.0] belongs to cluster 2
		The data [2.0,3.0,7579.0,4956.0,9426.0,1669.0,3321.0,2566.0] belongs to cluster 2
		The data [1.0,3.0,5963.0,3648.0,6192.0,425.0,1716.0,750.0] belongs to cluster 2
		The data [2.0,3.0,6006.0,11093.0,18881.0,1159.0,7425.0,2098.0] belongs to cluster 0
		The data [2.0,3.0,3366.0,5403.0,12974.0,4400.0,5977.0,1744.0] belongs to cluster 0
		The data [2.0,3.0,13146.0,1124.0,4523.0,1420.0,549.0,497.0] belongs to cluster 2
		The data [2.0,3.0,31714.0,12319.0,11757.0,287.0,3881.0,2931.0] belongs to cluster 1
		The data [2.0,3.0,21217.0,6208.0,14982.0,3095.0,6707.0,602.0] belongs to cluster 1
		The data [2.0,3.0,24653.0,9465.0,12091.0,294.0,5058.0,2168.0] belongs to cluster 1
		The data [1.0,3.0,10253.0,1114.0,3821.0,397.0,964.0,412.0] belongs to cluster 2
		The data [2.0,3.0,1020.0,8816.0,12121.0,134.0,4508.0,1080.0] belongs to cluster 0
		The data [1.0,3.0,5876.0,6157.0,2933.0,839.0,370.0,4478.0] belongs to cluster 2
		The data [2.0,3.0,18601.0,6327.0,10099.0,2205.0,2767.0,3181.0] belongs to cluster 1
		The data [1.0,3.0,7780.0,2495.0,9464.0,669.0,2518.0,501.0] belongs to cluster 2
		The data [2.0,3.0,17546.0,4519.0,4602.0,1066.0,2259.0,2124.0] belongs to cluster 1
		The data [1.0,3.0,5567.0,871.0,2010.0,3383.0,375.0,569.0] belongs to cluster 2
		The data [1.0,3.0,31276.0,1917.0,4469.0,9408.0,2381.0,4334.0] belongs to cluster 1
		The data [2.0,3.0,26373.0,36423.0,22019.0,5154.0,4337.0,16523.0] belongs to cluster 1
		The data [2.0,3.0,22647.0,9776.0,13792.0,2915.0,4482.0,5778.0] belongs to cluster 1
		The data [2.0,3.0,16165.0,4230.0,7595.0,201.0,4003.0,57.0] belongs to cluster 1
		The data [1.0,3.0,9898.0,961.0,2861.0,3151.0,242.0,833.0] belongs to cluster 2
		The data [1.0,3.0,14276.0,803.0,3045.0,485.0,100.0,518.0] belongs to cluster 2
		The data [2.0,3.0,4113.0,20484.0,25957.0,1158.0,8604.0,5206.0] belongs to cluster 0
		The data [1.0,3.0,43088.0,2100.0,2609.0,1200.0,1107.0,823.0] belongs to cluster 1
		The data [1.0,3.0,18815.0,3610.0,11107.0,1148.0,2134.0,2963.0] belongs to cluster 1
		The data [1.0,3.0,2612.0,4339.0,3133.0,2088.0,820.0,985.0] belongs to cluster 2
		The data [1.0,3.0,21632.0,1318.0,2886.0,266.0,918.0,405.0] belongs to cluster 1
		The data [1.0,3.0,29729.0,4786.0,7326.0,6130.0,361.0,1083.0] belongs to cluster 1
		The data [1.0,3.0,1502.0,1979.0,2262.0,425.0,483.0,395.0] belongs to cluster 2
		The data [2.0,3.0,688.0,5491.0,11091.0,833.0,4239.0,436.0] belongs to cluster 0
		The data [1.0,3.0,29955.0,4362.0,5428.0,1729.0,862.0,4626.0] belongs to cluster 1
		The data [2.0,3.0,15168.0,10556.0,12477.0,1920.0,6506.0,714.0] belongs to cluster 0
		The data [2.0,3.0,4591.0,15729.0,16709.0,33.0,6956.0,433.0] belongs to cluster 0
		The data [1.0,3.0,56159.0,555.0,902.0,10002.0,212.0,2916.0] belongs to cluster 1
		The data [1.0,3.0,24025.0,4332.0,4757.0,9510.0,1145.0,5864.0] belongs to cluster 1
		The data [1.0,3.0,19176.0,3065.0,5956.0,2033.0,2575.0,2802.0] belongs to cluster 1
		The data [2.0,3.0,10850.0,7555.0,14961.0,188.0,6899.0,46.0] belongs to cluster 0
		The data [2.0,3.0,630.0,11095.0,23998.0,787.0,9529.0,72.0] belongs to cluster 0
		The data [2.0,3.0,9670.0,7027.0,10471.0,541.0,4618.0,65.0] belongs to cluster 0
		The data [2.0,3.0,5181.0,22044.0,21531.0,1740.0,7353.0,4985.0] belongs to cluster 0
		The data [2.0,3.0,3103.0,14069.0,21955.0,1668.0,6792.0,1452.0] belongs to cluster 0
		The data [2.0,3.0,44466.0,54259.0,55571.0,7782.0,24171.0,6465.0] belongs to cluster 0
		The data [2.0,3.0,11519.0,6152.0,10868.0,584.0,5121.0,1476.0] belongs to cluster 0
		The data [2.0,3.0,4967.0,21412.0,28921.0,1798.0,13583.0,1163.0] belongs to cluster 0
		The data [1.0,3.0,6269.0,1095.0,1980.0,3860.0,609.0,2162.0] belongs to cluster 2
		The data [1.0,3.0,3347.0,4051.0,6996.0,239.0,1538.0,301.0] belongs to cluster 2
		The data [2.0,3.0,40721.0,3916.0,5876.0,532.0,2587.0,1278.0] belongs to cluster 1
		The data [2.0,3.0,491.0,10473.0,11532.0,744.0,5611.0,224.0] belongs to cluster 0
		The data [1.0,3.0,27329.0,1449.0,1947.0,2436.0,204.0,1333.0] belongs to cluster 1
		The data [1.0,3.0,5264.0,3683.0,5005.0,1057.0,2024.0,1130.0] belongs to cluster 2
		The data [2.0,3.0,4098.0,29892.0,26866.0,2616.0,17740.0,1340.0] belongs to cluster 0
		The data [2.0,3.0,5417.0,9933.0,10487.0,38.0,7572.0,1282.0] belongs to cluster 0
		The data [1.0,3.0,13779.0,1970.0,1648.0,596.0,227.0,436.0] belongs to cluster 2
		The data [1.0,3.0,6137.0,5360.0,8040.0,129.0,3084.0,1603.0] belongs to cluster 2
		The data [2.0,3.0,8590.0,3045.0,7854.0,96.0,4095.0,225.0] belongs to cluster 2
		The data [2.0,3.0,35942.0,38369.0,59598.0,3254.0,26701.0,2017.0] belongs to cluster 0
		The data [2.0,3.0,7823.0,6245.0,6544.0,4154.0,4074.0,964.0] belongs to cluster 2
		The data [2.0,3.0,9396.0,11601.0,15775.0,2896.0,7677.0,1295.0] belongs to cluster 0
		The data [1.0,3.0,4760.0,1227.0,3250.0,3724.0,1247.0,1145.0] belongs to cluster 2
		The data [2.0,3.0,85.0,20959.0,45828.0,36.0,24231.0,1423.0] belongs to cluster 0
		The data [1.0,3.0,9.0,1534.0,7417.0,175.0,3468.0,27.0] belongs to cluster 2
		The data [2.0,3.0,19913.0,6759.0,13462.0,1256.0,5141.0,834.0] belongs to cluster 1
		The data [1.0,3.0,2446.0,7260.0,3993.0,5870.0,788.0,3095.0] belongs to cluster 2
		The data [1.0,3.0,8352.0,2820.0,1293.0,779.0,656.0,144.0] belongs to cluster 2
		The data [1.0,3.0,16705.0,2037.0,3202.0,10643.0,116.0,1365.0] belongs to cluster 1
		The data [1.0,3.0,18291.0,1266.0,21042.0,5373.0,4173.0,14472.0] belongs to cluster 0
		The data [1.0,3.0,4420.0,5139.0,2661.0,8872.0,1321.0,181.0] belongs to cluster 2
		The data [2.0,3.0,19899.0,5332.0,8713.0,8132.0,764.0,648.0] belongs to cluster 1
		The data [2.0,3.0,8190.0,6343.0,9794.0,1285.0,1901.0,1780.0] belongs to cluster 2
		The data [1.0,3.0,20398.0,1137.0,3.0,4407.0,3.0,975.0] belongs to cluster 1
		The data [1.0,3.0,717.0,3587.0,6532.0,7530.0,529.0,894.0] belongs to cluster 2
		The data [2.0,3.0,12205.0,12697.0,28540.0,869.0,12034.0,1009.0] belongs to cluster 0
		The data [1.0,3.0,10766.0,1175.0,2067.0,2096.0,301.0,167.0] belongs to cluster 2
		The data [1.0,3.0,1640.0,3259.0,3655.0,868.0,1202.0,1653.0] belongs to cluster 2
		The data [1.0,3.0,7005.0,829.0,3009.0,430.0,610.0,529.0] belongs to cluster 2
		The data [2.0,3.0,219.0,9540.0,14403.0,283.0,7818.0,156.0] belongs to cluster 0
		The data [2.0,3.0,10362.0,9232.0,11009.0,737.0,3537.0,2342.0] belongs to cluster 0
		The data [1.0,3.0,20874.0,1563.0,1783.0,2320.0,550.0,772.0] belongs to cluster 1
		The data [2.0,3.0,11867.0,3327.0,4814.0,1178.0,3837.0,120.0] belongs to cluster 2
		The data [2.0,3.0,16117.0,46197.0,92780.0,1026.0,40827.0,2944.0] belongs to cluster 0
		The data [2.0,3.0,22925.0,73498.0,32114.0,987.0,20070.0,903.0] belongs to cluster 0
		The data [1.0,3.0,43265.0,5025.0,8117.0,6312.0,1579.0,14351.0] belongs to cluster 1
		The data [1.0,3.0,7864.0,542.0,4042.0,9735.0,165.0,46.0] belongs to cluster 2
		The data [1.0,3.0,24904.0,3836.0,5330.0,3443.0,454.0,3178.0] belongs to cluster 1
		The data [1.0,3.0,11405.0,596.0,1638.0,3347.0,69.0,360.0] belongs to cluster 2
		The data [1.0,3.0,12754.0,2762.0,2530.0,8693.0,627.0,1117.0] belongs to cluster 2
		The data [2.0,3.0,9198.0,27472.0,32034.0,3232.0,18906.0,5130.0] belongs to cluster 0
		The data [1.0,3.0,11314.0,3090.0,2062.0,35009.0,71.0,2698.0] belongs to cluster 2
		The data [2.0,3.0,5626.0,12220.0,11323.0,206.0,5038.0,244.0] belongs to cluster 0
		The data [1.0,3.0,3.0,2920.0,6252.0,440.0,223.0,709.0] belongs to cluster 2
		The data [2.0,3.0,23.0,2616.0,8118.0,145.0,3874.0,217.0] belongs to cluster 2
		The data [1.0,3.0,403.0,254.0,610.0,774.0,54.0,63.0] belongs to cluster 2
		The data [1.0,3.0,503.0,112.0,778.0,895.0,56.0,132.0] belongs to cluster 2
		The data [1.0,3.0,9658.0,2182.0,1909.0,5639.0,215.0,323.0] belongs to cluster 2
		The data [2.0,3.0,11594.0,7779.0,12144.0,3252.0,8035.0,3029.0] belongs to cluster 0
		The data [2.0,3.0,1420.0,10810.0,16267.0,1593.0,6766.0,1838.0] belongs to cluster 0
		The data [2.0,3.0,2932.0,6459.0,7677.0,2561.0,4573.0,1386.0] belongs to cluster 2
		The data [1.0,3.0,56082.0,3504.0,8906.0,18028.0,1480.0,2498.0] belongs to cluster 1
		The data [1.0,3.0,14100.0,2132.0,3445.0,1336.0,1491.0,548.0] belongs to cluster 2
		The data [1.0,3.0,15587.0,1014.0,3970.0,910.0,139.0,1378.0] belongs to cluster 2
		The data [2.0,3.0,1454.0,6337.0,10704.0,133.0,6830.0,1831.0] belongs to cluster 0
		The data [2.0,3.0,8797.0,10646.0,14886.0,2471.0,8969.0,1438.0] belongs to cluster 0
		The data [2.0,3.0,1531.0,8397.0,6981.0,247.0,2505.0,1236.0] belongs to cluster 2
		The data [2.0,3.0,1406.0,16729.0,28986.0,673.0,836.0,3.0] belongs to cluster 0
		The data [1.0,3.0,11818.0,1648.0,1694.0,2276.0,169.0,1647.0] belongs to cluster 2
		The data [2.0,3.0,12579.0,11114.0,17569.0,805.0,6457.0,1519.0] belongs to cluster 0
		The data [1.0,3.0,19046.0,2770.0,2469.0,8853.0,483.0,2708.0] belongs to cluster 1
		The data [1.0,3.0,14438.0,2295.0,1733.0,3220.0,585.0,1561.0] belongs to cluster 2
		The data [1.0,3.0,18044.0,1080.0,2000.0,2555.0,118.0,1266.0] belongs to cluster 1
		The data [1.0,3.0,11134.0,793.0,2988.0,2715.0,276.0,610.0] belongs to cluster 2
		The data [1.0,3.0,11173.0,2521.0,3355.0,1517.0,310.0,222.0] belongs to cluster 2
		The data [1.0,3.0,6990.0,3880.0,5380.0,1647.0,319.0,1160.0] belongs to cluster 2
		The data [1.0,3.0,20049.0,1891.0,2362.0,5343.0,411.0,933.0] belongs to cluster 1
		The data [1.0,3.0,8258.0,2344.0,2147.0,3896.0,266.0,635.0] belongs to cluster 2
		The data [1.0,3.0,17160.0,1200.0,3412.0,2417.0,174.0,1136.0] belongs to cluster 1
		The data [1.0,3.0,4020.0,3234.0,1498.0,2395.0,264.0,255.0] belongs to cluster 2
		The data [1.0,3.0,12212.0,201.0,245.0,1991.0,25.0,860.0] belongs to cluster 2
		The data [2.0,3.0,11170.0,10769.0,8814.0,2194.0,1976.0,143.0] belongs to cluster 0
		The data [1.0,3.0,36050.0,1642.0,2961.0,4787.0,500.0,1621.0] belongs to cluster 1
		The data [1.0,3.0,76237.0,3473.0,7102.0,16538.0,778.0,918.0] belongs to cluster 1
		The data [1.0,3.0,19219.0,1840.0,1658.0,8195.0,349.0,483.0] belongs to cluster 1
		The data [2.0,3.0,21465.0,7243.0,10685.0,880.0,2386.0,2749.0] belongs to cluster 1
		The data [1.0,3.0,140.0,8847.0,3823.0,142.0,1062.0,3.0] belongs to cluster 2
		The data [1.0,3.0,42312.0,926.0,1510.0,1718.0,410.0,1819.0] belongs to cluster 1
		The data [1.0,3.0,7149.0,2428.0,699.0,6316.0,395.0,911.0] belongs to cluster 2
		The data [1.0,3.0,2101.0,589.0,314.0,346.0,70.0,310.0] belongs to cluster 2
		The data [1.0,3.0,14903.0,2032.0,2479.0,576.0,955.0,328.0] belongs to cluster 2
		The data [1.0,3.0,9434.0,1042.0,1235.0,436.0,256.0,396.0] belongs to cluster 2
		The data [1.0,3.0,7388.0,1882.0,2174.0,720.0,47.0,537.0] belongs to cluster 2
		The data [1.0,3.0,6300.0,1289.0,2591.0,1170.0,199.0,326.0] belongs to cluster 2
		The data [1.0,3.0,4625.0,8579.0,7030.0,4575.0,2447.0,1542.0] belongs to cluster 2
		The data [1.0,3.0,3087.0,8080.0,8282.0,661.0,721.0,36.0] belongs to cluster 2
		The data [1.0,3.0,13537.0,4257.0,5034.0,155.0,249.0,3271.0] belongs to cluster 2
		The data [1.0,3.0,5387.0,4979.0,3343.0,825.0,637.0,929.0] belongs to cluster 2
		The data [1.0,3.0,17623.0,4280.0,7305.0,2279.0,960.0,2616.0] belongs to cluster 1
		The data [1.0,3.0,30379.0,13252.0,5189.0,321.0,51.0,1450.0] belongs to cluster 1
		The data [1.0,3.0,37036.0,7152.0,8253.0,2995.0,20.0,3.0] belongs to cluster 1
		The data [1.0,3.0,10405.0,1596.0,1096.0,8425.0,399.0,318.0] belongs to cluster 2
		The data [1.0,3.0,18827.0,3677.0,1988.0,118.0,516.0,201.0] belongs to cluster 1
		The data [2.0,3.0,22039.0,8384.0,34792.0,42.0,12591.0,4430.0] belongs to cluster 0
		The data [1.0,3.0,7769.0,1936.0,2177.0,926.0,73.0,520.0] belongs to cluster 2
		The data [1.0,3.0,9203.0,3373.0,2707.0,1286.0,1082.0,526.0] belongs to cluster 2
		The data [1.0,3.0,5924.0,584.0,542.0,4052.0,283.0,434.0] belongs to cluster 2
		The data [1.0,3.0,31812.0,1433.0,1651.0,800.0,113.0,1440.0] belongs to cluster 1
		The data [1.0,3.0,16225.0,1825.0,1765.0,853.0,170.0,1067.0] belongs to cluster 2
		The data [1.0,3.0,1289.0,3328.0,2022.0,531.0,255.0,1774.0] belongs to cluster 2
		The data [1.0,3.0,18840.0,1371.0,3135.0,3001.0,352.0,184.0] belongs to cluster 1
		The data [1.0,3.0,3463.0,9250.0,2368.0,779.0,302.0,1627.0] belongs to cluster 2
		The data [1.0,3.0,622.0,55.0,137.0,75.0,7.0,8.0] belongs to cluster 2
		The data [2.0,3.0,1989.0,10690.0,19460.0,233.0,11577.0,2153.0] belongs to cluster 0
		The data [2.0,3.0,3830.0,5291.0,14855.0,317.0,6694.0,3182.0] belongs to cluster 0
		The data [1.0,3.0,17773.0,1366.0,2474.0,3378.0,811.0,418.0] belongs to cluster 1
		The data [2.0,3.0,2861.0,6570.0,9618.0,930.0,4004.0,1682.0] belongs to cluster 0
		The data [2.0,3.0,355.0,7704.0,14682.0,398.0,8077.0,303.0] belongs to cluster 0
		The data [2.0,3.0,1725.0,3651.0,12822.0,824.0,4424.0,2157.0] belongs to cluster 0
		The data [1.0,3.0,12434.0,540.0,283.0,1092.0,3.0,2233.0] belongs to cluster 2
		The data [1.0,3.0,15177.0,2024.0,3810.0,2665.0,232.0,610.0] belongs to cluster 2
		The data [2.0,3.0,5531.0,15726.0,26870.0,2367.0,13726.0,446.0] belongs to cluster 0
		The data [2.0,3.0,5224.0,7603.0,8584.0,2540.0,3674.0,238.0] belongs to cluster 2
		The data [2.0,3.0,15615.0,12653.0,19858.0,4425.0,7108.0,2379.0] belongs to cluster 0
		The data [2.0,3.0,4822.0,6721.0,9170.0,993.0,4973.0,3637.0] belongs to cluster 0
		The data [1.0,3.0,2926.0,3195.0,3268.0,405.0,1680.0,693.0] belongs to cluster 2
		The data [1.0,3.0,5809.0,735.0,803.0,1393.0,79.0,429.0] belongs to cluster 2
		The data [1.0,3.0,5414.0,717.0,2155.0,2399.0,69.0,750.0] belongs to cluster 2
		The data [2.0,3.0,260.0,8675.0,13430.0,1116.0,7015.0,323.0] belongs to cluster 0
		The data [2.0,3.0,200.0,25862.0,19816.0,651.0,8773.0,6250.0] belongs to cluster 0
		The data [1.0,3.0,955.0,5479.0,6536.0,333.0,2840.0,707.0] belongs to cluster 2
		The data [2.0,3.0,514.0,7677.0,19805.0,937.0,9836.0,716.0] belongs to cluster 0
		The data [1.0,3.0,286.0,1208.0,5241.0,2515.0,153.0,1442.0] belongs to cluster 2
		The data [2.0,3.0,2343.0,7845.0,11874.0,52.0,4196.0,1697.0] belongs to cluster 0
		The data [1.0,3.0,45640.0,6958.0,6536.0,7368.0,1532.0,230.0] belongs to cluster 1
		The data [1.0,3.0,12759.0,7330.0,4533.0,1752.0,20.0,2631.0] belongs to cluster 2
		The data [1.0,3.0,11002.0,7075.0,4945.0,1152.0,120.0,395.0] belongs to cluster 2
		The data [1.0,3.0,3157.0,4888.0,2500.0,4477.0,273.0,2165.0] belongs to cluster 2
		The data [1.0,3.0,12356.0,6036.0,8887.0,402.0,1382.0,2794.0] belongs to cluster 2
		The data [1.0,3.0,112151.0,29627.0,18148.0,16745.0,4948.0,8550.0] belongs to cluster 1
		The data [1.0,3.0,694.0,8533.0,10518.0,443.0,6907.0,156.0] belongs to cluster 0
		The data [1.0,3.0,36847.0,43950.0,20170.0,36534.0,239.0,47943.0] belongs to cluster 1
		The data [1.0,3.0,327.0,918.0,4710.0,74.0,334.0,11.0] belongs to cluster 2
		The data [1.0,3.0,8170.0,6448.0,1139.0,2181.0,58.0,247.0] belongs to cluster 2
		The data [1.0,3.0,3009.0,521.0,854.0,3470.0,949.0,727.0] belongs to cluster 2
		The data [1.0,3.0,2438.0,8002.0,9819.0,6269.0,3459.0,3.0] belongs to cluster 0
		The data [2.0,3.0,8040.0,7639.0,11687.0,2758.0,6839.0,404.0] belongs to cluster 0
		The data [2.0,3.0,834.0,11577.0,11522.0,275.0,4027.0,1856.0] belongs to cluster 0
		The data [1.0,3.0,16936.0,6250.0,1981.0,7332.0,118.0,64.0] belongs to cluster 1
		The data [1.0,3.0,13624.0,295.0,1381.0,890.0,43.0,84.0] belongs to cluster 2
		The data [1.0,3.0,5509.0,1461.0,2251.0,547.0,187.0,409.0] belongs to cluster 2
		The data [2.0,3.0,180.0,3485.0,20292.0,959.0,5618.0,666.0] belongs to cluster 0
		The data [1.0,3.0,7107.0,1012.0,2974.0,806.0,355.0,1142.0] belongs to cluster 2
		The data [1.0,3.0,17023.0,5139.0,5230.0,7888.0,330.0,1755.0] belongs to cluster 1
		The data [1.0,1.0,30624.0,7209.0,4897.0,18711.0,763.0,2876.0] belongs to cluster 1
		The data [2.0,1.0,2427.0,7097.0,10391.0,1127.0,4314.0,1468.0] belongs to cluster 0
		The data [1.0,1.0,11686.0,2154.0,6824.0,3527.0,592.0,697.0] belongs to cluster 2
		The data [1.0,1.0,9670.0,2280.0,2112.0,520.0,402.0,347.0] belongs to cluster 2
		The data [2.0,1.0,3067.0,13240.0,23127.0,3941.0,9959.0,731.0] belongs to cluster 0
		The data [2.0,1.0,4484.0,14399.0,24708.0,3549.0,14235.0,1681.0] belongs to cluster 0
		The data [1.0,1.0,25203.0,11487.0,9490.0,5065.0,284.0,6854.0] belongs to cluster 1
		The data [1.0,1.0,583.0,685.0,2216.0,469.0,954.0,18.0] belongs to cluster 2
		The data [1.0,1.0,1956.0,891.0,5226.0,1383.0,5.0,1328.0] belongs to cluster 2
		The data [2.0,1.0,1107.0,11711.0,23596.0,955.0,9265.0,710.0] belongs to cluster 0
		The data [1.0,1.0,6373.0,780.0,950.0,878.0,288.0,285.0] belongs to cluster 2
		The data [2.0,1.0,2541.0,4737.0,6089.0,2946.0,5316.0,120.0] belongs to cluster 2
		The data [1.0,1.0,1537.0,3748.0,5838.0,1859.0,3381.0,806.0] belongs to cluster 2
		The data [2.0,1.0,5550.0,12729.0,16767.0,864.0,12420.0,797.0] belongs to cluster 0
		The data [1.0,1.0,18567.0,1895.0,1393.0,1801.0,244.0,2100.0] belongs to cluster 1
		The data [2.0,1.0,12119.0,28326.0,39694.0,4736.0,19410.0,2870.0] belongs to cluster 0
		The data [1.0,1.0,7291.0,1012.0,2062.0,1291.0,240.0,1775.0] belongs to cluster 2
		The data [1.0,1.0,3317.0,6602.0,6861.0,1329.0,3961.0,1215.0] belongs to cluster 2
		The data [2.0,1.0,2362.0,6551.0,11364.0,913.0,5957.0,791.0] belongs to cluster 0
		The data [1.0,1.0,2806.0,10765.0,15538.0,1374.0,5828.0,2388.0] belongs to cluster 0
		The data [2.0,1.0,2532.0,16599.0,36486.0,179.0,13308.0,674.0] belongs to cluster 0
		The data [1.0,1.0,18044.0,1475.0,2046.0,2532.0,130.0,1158.0] belongs to cluster 1
		The data [2.0,1.0,18.0,7504.0,15205.0,1285.0,4797.0,6372.0] belongs to cluster 0
		The data [1.0,1.0,4155.0,367.0,1390.0,2306.0,86.0,130.0] belongs to cluster 2
		The data [1.0,1.0,14755.0,899.0,1382.0,1765.0,56.0,749.0] belongs to cluster 2
		The data [1.0,1.0,5396.0,7503.0,10646.0,91.0,4167.0,239.0] belongs to cluster 0
		The data [1.0,1.0,5041.0,1115.0,2856.0,7496.0,256.0,375.0] belongs to cluster 2
		The data [2.0,1.0,2790.0,2527.0,5265.0,5612.0,788.0,1360.0] belongs to cluster 2
		The data [1.0,1.0,7274.0,659.0,1499.0,784.0,70.0,659.0] belongs to cluster 2
		The data [1.0,1.0,12680.0,3243.0,4157.0,660.0,761.0,786.0] belongs to cluster 2
		The data [2.0,1.0,20782.0,5921.0,9212.0,1759.0,2568.0,1553.0] belongs to cluster 1
		The data [1.0,1.0,4042.0,2204.0,1563.0,2286.0,263.0,689.0] belongs to cluster 2
		The data [1.0,1.0,1869.0,577.0,572.0,950.0,4762.0,203.0] belongs to cluster 2
		The data [1.0,1.0,8656.0,2746.0,2501.0,6845.0,694.0,980.0] belongs to cluster 2
		The data [2.0,1.0,11072.0,5989.0,5615.0,8321.0,955.0,2137.0] belongs to cluster 2
		The data [1.0,1.0,2344.0,10678.0,3828.0,1439.0,1566.0,490.0] belongs to cluster 2
		The data [1.0,1.0,25962.0,1780.0,3838.0,638.0,284.0,834.0] belongs to cluster 1
		The data [1.0,1.0,964.0,4984.0,3316.0,937.0,409.0,7.0] belongs to cluster 2
		The data [1.0,1.0,15603.0,2703.0,3833.0,4260.0,325.0,2563.0] belongs to cluster 2
		The data [1.0,1.0,1838.0,6380.0,2824.0,1218.0,1216.0,295.0] belongs to cluster 2
		The data [1.0,1.0,8635.0,820.0,3047.0,2312.0,415.0,225.0] belongs to cluster 2
		The data [1.0,1.0,18692.0,3838.0,593.0,4634.0,28.0,1215.0] belongs to cluster 1
		The data [1.0,1.0,7363.0,475.0,585.0,1112.0,72.0,216.0] belongs to cluster 2
		The data [1.0,1.0,47493.0,2567.0,3779.0,5243.0,828.0,2253.0] belongs to cluster 1
		The data [1.0,1.0,22096.0,3575.0,7041.0,11422.0,343.0,2564.0] belongs to cluster 1
		The data [1.0,1.0,24929.0,1801.0,2475.0,2216.0,412.0,1047.0] belongs to cluster 1
		The data [1.0,1.0,18226.0,659.0,2914.0,3752.0,586.0,578.0] belongs to cluster 1
		The data [1.0,1.0,11210.0,3576.0,5119.0,561.0,1682.0,2398.0] belongs to cluster 2
		The data [1.0,1.0,6202.0,7775.0,10817.0,1183.0,3143.0,1970.0] belongs to cluster 0
		The data [2.0,1.0,3062.0,6154.0,13916.0,230.0,8933.0,2784.0] belongs to cluster 0
		The data [1.0,1.0,8885.0,2428.0,1777.0,1777.0,430.0,610.0] belongs to cluster 2
		The data [1.0,1.0,13569.0,346.0,489.0,2077.0,44.0,659.0] belongs to cluster 2
		The data [1.0,1.0,15671.0,5279.0,2406.0,559.0,562.0,572.0] belongs to cluster 2
		The data [1.0,1.0,8040.0,3795.0,2070.0,6340.0,918.0,291.0] belongs to cluster 2
		The data [1.0,1.0,3191.0,1993.0,1799.0,1730.0,234.0,710.0] belongs to cluster 2
		The data [2.0,1.0,6134.0,23133.0,33586.0,6746.0,18594.0,5121.0] belongs to cluster 0
		The data [1.0,1.0,6623.0,1860.0,4740.0,7683.0,205.0,1693.0] belongs to cluster 2
		The data [1.0,1.0,29526.0,7961.0,16966.0,432.0,363.0,1391.0] belongs to cluster 1
		The data [1.0,1.0,10379.0,17972.0,4748.0,4686.0,1547.0,3265.0] belongs to cluster 2
		The data [1.0,1.0,31614.0,489.0,1495.0,3242.0,111.0,615.0] belongs to cluster 1
		The data [1.0,1.0,11092.0,5008.0,5249.0,453.0,392.0,373.0] belongs to cluster 2
		The data [1.0,1.0,8475.0,1931.0,1883.0,5004.0,3593.0,987.0] belongs to cluster 2
		The data [1.0,1.0,56083.0,4563.0,2124.0,6422.0,730.0,3321.0] belongs to cluster 1
		The data [1.0,1.0,53205.0,4959.0,7336.0,3012.0,967.0,818.0] belongs to cluster 1
		The data [1.0,1.0,9193.0,4885.0,2157.0,327.0,780.0,548.0] belongs to cluster 2
		The data [1.0,1.0,7858.0,1110.0,1094.0,6818.0,49.0,287.0] belongs to cluster 2
		The data [1.0,1.0,23257.0,1372.0,1677.0,982.0,429.0,655.0] belongs to cluster 1
		The data [1.0,1.0,2153.0,1115.0,6684.0,4324.0,2894.0,411.0] belongs to cluster 2
		The data [2.0,1.0,1073.0,9679.0,15445.0,61.0,5980.0,1265.0] belongs to cluster 0
		The data [1.0,1.0,5909.0,23527.0,13699.0,10155.0,830.0,3636.0] belongs to cluster 0
		The data [2.0,1.0,572.0,9763.0,22182.0,2221.0,4882.0,2563.0] belongs to cluster 0
		The data [1.0,1.0,20893.0,1222.0,2576.0,3975.0,737.0,3628.0] belongs to cluster 1
		The data [2.0,1.0,11908.0,8053.0,19847.0,1069.0,6374.0,698.0] belongs to cluster 0
		The data [1.0,1.0,15218.0,258.0,1138.0,2516.0,333.0,204.0] belongs to cluster 2
		The data [1.0,1.0,4720.0,1032.0,975.0,5500.0,197.0,56.0] belongs to cluster 2
		The data [1.0,1.0,2083.0,5007.0,1563.0,1120.0,147.0,1550.0] belongs to cluster 2
		The data [1.0,1.0,514.0,8323.0,6869.0,529.0,93.0,1040.0] belongs to cluster 2
		The data [1.0,3.0,36817.0,3045.0,1493.0,4802.0,210.0,1824.0] belongs to cluster 1
		The data [1.0,3.0,894.0,1703.0,1841.0,744.0,759.0,1153.0] belongs to cluster 2
		The data [1.0,3.0,680.0,1610.0,223.0,862.0,96.0,379.0] belongs to cluster 2
		The data [1.0,3.0,27901.0,3749.0,6964.0,4479.0,603.0,2503.0] belongs to cluster 1
		The data [1.0,3.0,9061.0,829.0,683.0,16919.0,621.0,139.0] belongs to cluster 2
		The data [1.0,3.0,11693.0,2317.0,2543.0,5845.0,274.0,1409.0] belongs to cluster 2
		The data [2.0,3.0,17360.0,6200.0,9694.0,1293.0,3620.0,1721.0] belongs to cluster 1
		The data [1.0,3.0,3366.0,2884.0,2431.0,977.0,167.0,1104.0] belongs to cluster 2
		The data [2.0,3.0,12238.0,7108.0,6235.0,1093.0,2328.0,2079.0] belongs to cluster 2
		The data [1.0,3.0,49063.0,3965.0,4252.0,5970.0,1041.0,1404.0] belongs to cluster 1
		The data [1.0,3.0,25767.0,3613.0,2013.0,10303.0,314.0,1384.0] belongs to cluster 1
		The data [1.0,3.0,68951.0,4411.0,12609.0,8692.0,751.0,2406.0] belongs to cluster 1
		The data [1.0,3.0,40254.0,640.0,3600.0,1042.0,436.0,18.0] belongs to cluster 1
		The data [1.0,3.0,7149.0,2247.0,1242.0,1619.0,1226.0,128.0] belongs to cluster 2
		The data [1.0,3.0,15354.0,2102.0,2828.0,8366.0,386.0,1027.0] belongs to cluster 2
		The data [1.0,3.0,16260.0,594.0,1296.0,848.0,445.0,258.0] belongs to cluster 2
		The data [1.0,3.0,42786.0,286.0,471.0,1388.0,32.0,22.0] belongs to cluster 1
		The data [1.0,3.0,2708.0,2160.0,2642.0,502.0,965.0,1522.0] belongs to cluster 2
		The data [1.0,3.0,6022.0,3354.0,3261.0,2507.0,212.0,686.0] belongs to cluster 2
		The data [1.0,3.0,2838.0,3086.0,4329.0,3838.0,825.0,1060.0] belongs to cluster 2
		The data [2.0,2.0,3996.0,11103.0,12469.0,902.0,5952.0,741.0] belongs to cluster 0
		The data [1.0,2.0,21273.0,2013.0,6550.0,909.0,811.0,1854.0] belongs to cluster 1
		The data [2.0,2.0,7588.0,1897.0,5234.0,417.0,2208.0,254.0] belongs to cluster 2
		The data [1.0,2.0,19087.0,1304.0,3643.0,3045.0,710.0,898.0] belongs to cluster 1
		The data [2.0,2.0,8090.0,3199.0,6986.0,1455.0,3712.0,531.0] belongs to cluster 2
		The data [2.0,2.0,6758.0,4560.0,9965.0,934.0,4538.0,1037.0] belongs to cluster 0
		The data [1.0,2.0,444.0,879.0,2060.0,264.0,290.0,259.0] belongs to cluster 2
		The data [2.0,2.0,16448.0,6243.0,6360.0,824.0,2662.0,2005.0] belongs to cluster 1
		The data [2.0,2.0,5283.0,13316.0,20399.0,1809.0,8752.0,172.0] belongs to cluster 0
		The data [2.0,2.0,2886.0,5302.0,9785.0,364.0,6236.0,555.0] belongs to cluster 0
		The data [2.0,2.0,2599.0,3688.0,13829.0,492.0,10069.0,59.0] belongs to cluster 0
		The data [2.0,2.0,161.0,7460.0,24773.0,617.0,11783.0,2410.0] belongs to cluster 0
		The data [2.0,2.0,243.0,12939.0,8852.0,799.0,3909.0,211.0] belongs to cluster 0
		The data [2.0,2.0,6468.0,12867.0,21570.0,1840.0,7558.0,1543.0] belongs to cluster 0
		The data [1.0,2.0,17327.0,2374.0,2842.0,1149.0,351.0,925.0] belongs to cluster 1
		The data [1.0,2.0,6987.0,1020.0,3007.0,416.0,257.0,656.0] belongs to cluster 2
		The data [2.0,2.0,918.0,20655.0,13567.0,1465.0,6846.0,806.0] belongs to cluster 0
		The data [1.0,2.0,7034.0,1492.0,2405.0,12569.0,299.0,1117.0] belongs to cluster 2
		The data [1.0,2.0,29635.0,2335.0,8280.0,3046.0,371.0,117.0] belongs to cluster 1
		The data [2.0,2.0,2137.0,3737.0,19172.0,1274.0,17120.0,142.0] belongs to cluster 0
		The data [1.0,2.0,9784.0,925.0,2405.0,4447.0,183.0,297.0] belongs to cluster 2
		The data [1.0,2.0,10617.0,1795.0,7647.0,1483.0,857.0,1233.0] belongs to cluster 2
		The data [2.0,2.0,1479.0,14982.0,11924.0,662.0,3891.0,3508.0] belongs to cluster 0
		The data [1.0,2.0,7127.0,1375.0,2201.0,2679.0,83.0,1059.0] belongs to cluster 2
		The data [1.0,2.0,1182.0,3088.0,6114.0,978.0,821.0,1637.0] belongs to cluster 2
		The data [1.0,2.0,11800.0,2713.0,3558.0,2121.0,706.0,51.0] belongs to cluster 2
		The data [2.0,2.0,9759.0,25071.0,17645.0,1128.0,12408.0,1625.0] belongs to cluster 0
		The data [1.0,2.0,1774.0,3696.0,2280.0,514.0,275.0,834.0] belongs to cluster 2
		The data [1.0,2.0,9155.0,1897.0,5167.0,2714.0,228.0,1113.0] belongs to cluster 2
		The data [1.0,2.0,15881.0,713.0,3315.0,3703.0,1470.0,229.0] belongs to cluster 2
		The data [1.0,2.0,13360.0,944.0,11593.0,915.0,1679.0,573.0] belongs to cluster 2
		The data [1.0,2.0,25977.0,3587.0,2464.0,2369.0,140.0,1092.0] belongs to cluster 1
		The data [1.0,2.0,32717.0,16784.0,13626.0,60869.0,1272.0,5609.0] belongs to cluster 1
		The data [1.0,2.0,4414.0,1610.0,1431.0,3498.0,387.0,834.0] belongs to cluster 2
		The data [1.0,2.0,542.0,899.0,1664.0,414.0,88.0,522.0] belongs to cluster 2
		The data [1.0,2.0,16933.0,2209.0,3389.0,7849.0,210.0,1534.0] belongs to cluster 1
		The data [1.0,2.0,5113.0,1486.0,4583.0,5127.0,492.0,739.0] belongs to cluster 2
		The data [1.0,2.0,9790.0,1786.0,5109.0,3570.0,182.0,1043.0] belongs to cluster 2
		The data [2.0,2.0,11223.0,14881.0,26839.0,1234.0,9606.0,1102.0] belongs to cluster 0
		The data [1.0,2.0,22321.0,3216.0,1447.0,2208.0,178.0,2602.0] belongs to cluster 1
		The data [2.0,2.0,8565.0,4980.0,67298.0,131.0,38102.0,1215.0] belongs to cluster 0
		The data [2.0,2.0,16823.0,928.0,2743.0,11559.0,332.0,3486.0] belongs to cluster 1
		The data [2.0,2.0,27082.0,6817.0,10790.0,1365.0,4111.0,2139.0] belongs to cluster 1
		The data [1.0,2.0,13970.0,1511.0,1330.0,650.0,146.0,778.0] belongs to cluster 2
		The data [1.0,2.0,9351.0,1347.0,2611.0,8170.0,442.0,868.0] belongs to cluster 2
		The data [1.0,2.0,3.0,333.0,7021.0,15601.0,15.0,550.0] belongs to cluster 2
		The data [1.0,2.0,2617.0,1188.0,5332.0,9584.0,573.0,1942.0] belongs to cluster 2
		The data [2.0,3.0,381.0,4025.0,9670.0,388.0,7271.0,1371.0] belongs to cluster 0
		The data [2.0,3.0,2320.0,5763.0,11238.0,767.0,5162.0,2158.0] belongs to cluster 0
		The data [1.0,3.0,255.0,5758.0,5923.0,349.0,4595.0,1328.0] belongs to cluster 2
		The data [2.0,3.0,1689.0,6964.0,26316.0,1456.0,15469.0,37.0] belongs to cluster 0
		The data [1.0,3.0,3043.0,1172.0,1763.0,2234.0,217.0,379.0] belongs to cluster 2
		The data [1.0,3.0,1198.0,2602.0,8335.0,402.0,3843.0,303.0] belongs to cluster 2
		The data [2.0,3.0,2771.0,6939.0,15541.0,2693.0,6600.0,1115.0] belongs to cluster 0
		The data [2.0,3.0,27380.0,7184.0,12311.0,2809.0,4621.0,1022.0] belongs to cluster 1
		The data [1.0,3.0,3428.0,2380.0,2028.0,1341.0,1184.0,665.0] belongs to cluster 2
		The data [2.0,3.0,5981.0,14641.0,20521.0,2005.0,12218.0,445.0] belongs to cluster 0
		The data [1.0,3.0,3521.0,1099.0,1997.0,1796.0,173.0,995.0] belongs to cluster 2
		The data [2.0,3.0,1210.0,10044.0,22294.0,1741.0,12638.0,3137.0] belongs to cluster 0
		The data [1.0,3.0,608.0,1106.0,1533.0,830.0,90.0,195.0] belongs to cluster 2
		The data [2.0,3.0,117.0,6264.0,21203.0,228.0,8682.0,1111.0] belongs to cluster 0
		The data [1.0,3.0,14039.0,7393.0,2548.0,6386.0,1333.0,2341.0] belongs to cluster 2
		The data [1.0,3.0,190.0,727.0,2012.0,245.0,184.0,127.0] belongs to cluster 2
		The data [1.0,3.0,22686.0,134.0,218.0,3157.0,9.0,548.0] belongs to cluster 1
		The data [2.0,3.0,37.0,1275.0,22272.0,137.0,6747.0,110.0] belongs to cluster 0
		The data [1.0,3.0,759.0,18664.0,1660.0,6114.0,536.0,4100.0] belongs to cluster 2
		The data [1.0,3.0,796.0,5878.0,2109.0,340.0,232.0,776.0] belongs to cluster 2
		The data [1.0,3.0,19746.0,2872.0,2006.0,2601.0,468.0,503.0] belongs to cluster 1
		The data [1.0,3.0,4734.0,607.0,864.0,1206.0,159.0,405.0] belongs to cluster 2
		The data [1.0,3.0,2121.0,1601.0,2453.0,560.0,179.0,712.0] belongs to cluster 2
		The data [1.0,3.0,4627.0,997.0,4438.0,191.0,1335.0,314.0] belongs to cluster 2
		The data [1.0,3.0,2615.0,873.0,1524.0,1103.0,514.0,468.0] belongs to cluster 2
		The data [2.0,3.0,4692.0,6128.0,8025.0,1619.0,4515.0,3105.0] belongs to cluster 2
		The data [1.0,3.0,9561.0,2217.0,1664.0,1173.0,222.0,447.0] belongs to cluster 2
		The data [1.0,3.0,3477.0,894.0,534.0,1457.0,252.0,342.0] belongs to cluster 2
		The data [1.0,3.0,22335.0,1196.0,2406.0,2046.0,101.0,558.0] belongs to cluster 1
		The data [1.0,3.0,6211.0,337.0,683.0,1089.0,41.0,296.0] belongs to cluster 2
		The data [2.0,3.0,39679.0,3944.0,4955.0,1364.0,523.0,2235.0] belongs to cluster 1
		The data [1.0,3.0,20105.0,1887.0,1939.0,8164.0,716.0,790.0] belongs to cluster 1
		The data [1.0,3.0,3884.0,3801.0,1641.0,876.0,397.0,4829.0] belongs to cluster 2
		The data [2.0,3.0,15076.0,6257.0,7398.0,1504.0,1916.0,3113.0] belongs to cluster 1
		The data [1.0,3.0,6338.0,2256.0,1668.0,1492.0,311.0,686.0] belongs to cluster 2
		The data [1.0,3.0,5841.0,1450.0,1162.0,597.0,476.0,70.0] belongs to cluster 2
		The data [2.0,3.0,3136.0,8630.0,13586.0,5641.0,4666.0,1426.0] belongs to cluster 0
		The data [1.0,3.0,38793.0,3154.0,2648.0,1034.0,96.0,1242.0] belongs to cluster 1
		The data [1.0,3.0,3225.0,3294.0,1902.0,282.0,68.0,1114.0] belongs to cluster 2
		The data [2.0,3.0,4048.0,5164.0,10391.0,130.0,813.0,179.0] belongs to cluster 2
		The data [1.0,3.0,28257.0,944.0,2146.0,3881.0,600.0,270.0] belongs to cluster 1
		The data [1.0,3.0,17770.0,4591.0,1617.0,9927.0,246.0,532.0] belongs to cluster 1
		The data [1.0,3.0,34454.0,7435.0,8469.0,2540.0,1711.0,2893.0] belongs to cluster 1
		The data [1.0,3.0,1821.0,1364.0,3450.0,4006.0,397.0,361.0] belongs to cluster 2
		The data [1.0,3.0,10683.0,21858.0,15400.0,3635.0,282.0,5120.0] belongs to cluster 0
		The data [1.0,3.0,11635.0,922.0,1614.0,2583.0,192.0,1068.0] belongs to cluster 2
		The data [1.0,3.0,1206.0,3620.0,2857.0,1945.0,353.0,967.0] belongs to cluster 2
		The data [1.0,3.0,20918.0,1916.0,1573.0,1960.0,231.0,961.0] belongs to cluster 1
		The data [1.0,3.0,9785.0,848.0,1172.0,1677.0,200.0,406.0] belongs to cluster 2
		The data [1.0,3.0,9385.0,1530.0,1422.0,3019.0,227.0,684.0] belongs to cluster 2
		The data [1.0,3.0,3352.0,1181.0,1328.0,5502.0,311.0,1000.0] belongs to cluster 2
		The data [1.0,3.0,2647.0,2761.0,2313.0,907.0,95.0,1827.0] belongs to cluster 2
		The data [1.0,3.0,518.0,4180.0,3600.0,659.0,122.0,654.0] belongs to cluster 2
		The data [1.0,3.0,23632.0,6730.0,3842.0,8620.0,385.0,819.0] belongs to cluster 1
		The data [1.0,3.0,12377.0,865.0,3204.0,1398.0,149.0,452.0] belongs to cluster 2
		The data [1.0,3.0,9602.0,1316.0,1263.0,2921.0,841.0,290.0] belongs to cluster 2
		The data [2.0,3.0,4515.0,11991.0,9345.0,2644.0,3378.0,2213.0] belongs to cluster 0
		The data [1.0,3.0,11535.0,1666.0,1428.0,6838.0,64.0,743.0] belongs to cluster 2
		The data [1.0,3.0,11442.0,1032.0,582.0,5390.0,74.0,247.0] belongs to cluster 2
		Spark MLlib K-means clustering test finished.
		
		
		
		参考：
		
		 【1】 http://www.ibm.com/developerworks/cn/opensource/os-cn-spark-practice4/
		 【2】http://archive.ics.uci.edu/ml/datasets/Wholesale+customers#