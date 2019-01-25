## Problem
	Error
	Traceback (most recent call last):
	  File "/usr/local/Cellar/python@2/2.7.15/Frameworks/Python.framework/Versions/2.7/lib/python2.7/unittest/case.py", line 329, in run
	    testMethod()
	  File "/Users/xubo/Desktop/xubo/git/spark/python/pyspark/ml/tests/test_image.py", line 32, in test_read_images
	    self.assertEqual(df.count(), 4)
	  File "/Users/xubo/Desktop/xubo/git/spark/python/pyspark/sql/dataframe.py", line 505, in count
	    return int(self._jdf.count())
	  File "/Users/xubo/Desktop/xubo/git/spark/python/lib/py4j-0.10.8.1-src.zip/py4j/java_gateway.py", line 1286, in __call__
	    answer, self.gateway_client, self.target_id, self.name)
	  File "/Users/xubo/Desktop/xubo/git/spark/python/pyspark/sql/utils.py", line 63, in deco
	    return f(*a, **kw)
	  File "/Users/xubo/Desktop/xubo/git/spark/python/lib/py4j-0.10.8.1-src.zip/py4j/protocol.py", line 328, in get_return_value
	    format(target_id, ".", name), value)
	Py4JJavaError: An error occurred while calling o25.count.
	: org.apache.spark.sql.catalyst.errors.package$TreeNodeException: execute, tree:
	Exchange SinglePartition
	+- *(1) HashAggregate(keys=[], functions=[partial_count(1)], output=[count#8L])
	   +- *(1) Project
	      +- *(1) Scan ExistingRDD[image#1]
	
		at org.apache.spark.sql.catalyst.errors.package$.attachTree(package.scala:56)
		at org.apache.spark.sql.execution.exchange.ShuffleExchangeExec.doExecute(ShuffleExchangeExec.scala:129)
		at org.apache.spark.sql.execution.SparkPlan.$anonfun$execute$1(SparkPlan.scala:131)
		at org.apache.spark.sql.execution.SparkPlan.$anonfun$executeQuery$1(SparkPlan.scala:155)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:151)
		at org.apache.spark.sql.execution.SparkPlan.executeQuery(SparkPlan.scala:152)
		at org.apache.spark.sql.execution.SparkPlan.execute(SparkPlan.scala:127)
		at org.apache.spark.sql.execution.InputAdapter.inputRDD(WholeStageCodegenExec.scala:488)
		at org.apache.spark.sql.execution.InputRDDCodegen.inputRDDs(WholeStageCodegenExec.scala:429)
		at org.apache.spark.sql.execution.InputRDDCodegen.inputRDDs$(WholeStageCodegenExec.scala:428)
		at org.apache.spark.sql.execution.InputAdapter.inputRDDs(WholeStageCodegenExec.scala:472)
		at org.apache.spark.sql.execution.aggregate.HashAggregateExec.inputRDDs(HashAggregateExec.scala:154)
		at org.apache.spark.sql.execution.WholeStageCodegenExec.doExecute(WholeStageCodegenExec.scala:719)
		at org.apache.spark.sql.execution.SparkPlan.$anonfun$execute$1(SparkPlan.scala:131)
		at org.apache.spark.sql.execution.SparkPlan.$anonfun$executeQuery$1(SparkPlan.scala:155)
		at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:151)
		at org.apache.spark.sql.execution.SparkPlan.executeQuery(SparkPlan.scala:152)
		at org.apache.spark.sql.execution.SparkPlan.execute(SparkPlan.scala:127)
		at org.apache.spark.sql.execution.SparkPlan.getByteArrayRdd(SparkPlan.scala:247)
		at org.apache.spark.sql.execution.SparkPlan.executeCollect(SparkPlan.scala:296)
		at org.apache.spark.sql.Dataset.$anonfun$count$1(Dataset.scala:2756)
		at org.apache.spark.sql.Dataset.$anonfun$count$1$adapted(Dataset.scala:2755)
		at org.apache.spark.sql.Dataset.$anonfun$withAction$1(Dataset.scala:3291)
		at org.apache.spark.sql.execution.SQLExecution$.$anonfun$withNewExecutionId$1(SQLExecution.scala:87)
		at org.apache.spark.sql.execution.SQLExecution$.withSQLConfPropagated(SQLExecution.scala:147)
		at org.apache.spark.sql.execution.SQLExecution$.withNewExecutionId(SQLExecution.scala:74)
		at org.apache.spark.sql.Dataset.withAction(Dataset.scala:3287)
		at org.apache.spark.sql.Dataset.count(Dataset.scala:2755)
		at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
		at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
		at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
		at java.lang.reflect.Method.invoke(Method.java:498)
		at py4j.reflection.MethodInvoker.invoke(MethodInvoker.java:244)
		at py4j.reflection.ReflectionEngine.invoke(ReflectionEngine.java:357)
		at py4j.Gateway.invoke(Gateway.java:282)
		at py4j.commands.AbstractCommand.invokeMethod(AbstractCommand.java:132)
		at py4j.commands.CallCommand.execute(CallCommand.java:79)
		at py4j.GatewayConnection.run(GatewayConnection.java:238)
		at java.lang.Thread.run(Thread.java:748)
	Caused by: org.apache.hadoop.mapreduce.lib.input.InvalidInputException: Input path does not exist: file:/Users/xubo/Desktop/xubo/git/spark/python/pyspark/ml/tests/data/mllib/images/origin/kittens
		at org.apache.hadoop.mapreduce.lib.input.FileInputFormat.singleThreadedListStatus(FileInputFormat.java:323)
		at org.apache.hadoop.mapreduce.lib.input.FileInputFormat.listStatus(FileInputFormat.java:265)
		at org.apache.spark.input.StreamFileInputFormat.setMinPartitions(PortableDataStream.scala:51)
		at org.apache.spark.rdd.BinaryFileRDD.getPartitions(BinaryFileRDD.scala:51)
		at org.apache.spark.rdd.RDD.$anonfun$partitions$2(RDD.scala:256)
		at scala.Option.getOrElse(Option.scala:138)
		at org.apache.spark.rdd.RDD.partitions(RDD.scala:254)
		at org.apache.spark.rdd.MapPartitionsRDD.getPartitions(MapPartitionsRDD.scala:49)
		at org.apache.spark.rdd.RDD.$anonfun$partitions$2(RDD.scala:256)
		at scala.Option.getOrElse(Option.scala:138)
		at org.apache.spark.rdd.RDD.partitions(RDD.scala:254)
		at org.apache.spark.rdd.MapPartitionsRDD.getPartitions(MapPartitionsRDD.scala:49)
		at org.apache.spark.rdd.RDD.$anonfun$partitions$2(RDD.scala:256)
		at scala.Option.getOrElse(Option.scala:138)
		at org.apache.spark.rdd.RDD.partitions(RDD.scala:254)
		at org.apache.spark.rdd.MapPartitionsRDD.getPartitions(MapPartitionsRDD.scala:49)
		at org.apache.spark.rdd.RDD.$anonfun$partitions$2(RDD.scala:256)
		at scala.Option.getOrElse(Option.scala:138)
		at org.apache.spark.rdd.RDD.partitions(RDD.scala:254)
		at org.apache.spark.rdd.MapPartitionsRDD.getPartitions(MapPartitionsRDD.scala:49)
		at org.apache.spark.rdd.RDD.$anonfun$partitions$2(RDD.scala:256)
		at scala.Option.getOrElse(Option.scala:138)
		at org.apache.spark.rdd.RDD.partitions(RDD.scala:254)
		at org.apache.spark.ShuffleDependency.<init>(Dependency.scala:96)
		at org.apache.spark.sql.execution.exchange.ShuffleExchangeExec$.prepareShuffleDependency(ShuffleExchangeExec.scala:344)
		at org.apache.spark.sql.execution.exchange.ShuffleExchangeExec.prepareShuffleDependency(ShuffleExchangeExec.scala:102)
		at org.apache.spark.sql.execution.exchange.ShuffleExchangeExec.$anonfun$doExecute$1(ShuffleExchangeExec.scala:138)
		at org.apache.spark.sql.catalyst.errors.package$.attachTree(package.scala:52)
		... 38 more
		
## Solution：
 相对路径不对，需要把
 
		 data_path = 'data/mllib/images/origin/kittens'
 改成：

         data_path = '../../../../data/mllib/images/origin/kittens'
         
## Result

	19/01/25 12:08:06 WARN Utils: Your hostname, localhost resolves to a loopback address: 127.0.0.1; using 192.168.43.77 instead (on interface en0)
	19/01/25 12:08:06 WARN Utils: Set SPARK_LOCAL_IP if you need to bind to another address
	19/01/25 12:08:07 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
	Setting default log level to "WARN".
	To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
	19/01/25 12:08:08 WARN Utils: Service 'SparkUI' could not bind on port 4040. Attempting port 4041.
	19/01/25 12:08:08 WARN Utils: Service 'SparkUI' could not bind on port 4041. Attempting port 4042.
	
	
	Ran 1 test in 9.845s
	
	OK
	19/01/25 12:08:13 WARN DAGScheduler: Broadcasting large task binary with size 24.9 KiB
	19/01/25 12:08:14 WARN DAGScheduler: Broadcasting large task binary with size 10.0 KiB
	19/01/25 12:08:14 WARN DAGScheduler: Broadcasting large task binary with size 23.0 KiB