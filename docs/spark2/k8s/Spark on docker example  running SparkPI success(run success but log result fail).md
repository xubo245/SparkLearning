##command

	docker run --rm -it -p 4040:4040 gettyimages/spark bin/run-example SparkPi 10

##record:

	[root@sparkonk8s-46929-p4jdl mynginx]# docker run --rm -it -p 4040:4040 gettyimages/spark bin/run-example SparkPi 10
	18/03/05 09:21:29 INFO spark.SparkContext: Running Spark version 2.2.1
	18/03/05 09:21:30 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	18/03/05 09:21:30 INFO spark.SparkContext: Submitted application: Spark Pi
	18/03/05 09:21:31 INFO spark.SecurityManager: Changing view acls to: root
	18/03/05 09:21:31 INFO spark.SecurityManager: Changing modify acls to: root
	18/03/05 09:21:31 INFO spark.SecurityManager: Changing view acls groups to:
	18/03/05 09:21:31 INFO spark.SecurityManager: Changing modify acls groups to:
	18/03/05 09:21:31 INFO spark.SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(root); groups with view permissions: Set(); users  with modify permissions: Set(root); groups with modify permissions: Set()
	18/03/05 09:21:57 INFO util.Utils: Successfully started service 'sparkDriver' on port 39624.
	18/03/05 09:21:57 INFO spark.SparkEnv: Registering MapOutputTracker
	18/03/05 09:21:57 INFO spark.SparkEnv: Registering BlockManagerMaster
	18/03/05 09:21:58 INFO storage.BlockManagerMasterEndpoint: Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information
	18/03/05 09:21:58 INFO storage.BlockManagerMasterEndpoint: BlockManagerMasterEndpoint up
	18/03/05 09:23:18 INFO storage.DiskBlockManager: Created local directory at /tmp/blockmgr-a7eb53cc-fb0f-4d98-9116-2f9f38524d66
	18/03/05 09:23:18 INFO memory.MemoryStore: MemoryStore started with capacity 366.3 MB
	18/03/05 09:23:19 INFO spark.SparkEnv: Registering OutputCommitCoordinator
	18/03/05 09:23:19 INFO util.log: Logging initialized @114703ms
	18/03/05 09:23:19 INFO server.Server: jetty-9.3.z-SNAPSHOT
	18/03/05 09:23:19 INFO server.Server: Started @114883ms
	18/03/05 09:23:19 INFO server.AbstractConnector: Started ServerConnector@d0497b4{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}
	18/03/05 09:23:19 INFO util.Utils: Successfully started service 'SparkUI' on port 4040.
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@3d526ad9{/jobs,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@5cad8b7d{/jobs/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@25243bc1{/jobs/job,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@4201a617{/jobs/job/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@1bb9aa43{/stages,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@df5f5c0{/stages/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@66b72664{/stages/stage,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@64b31700{/stages/stage/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@bae47a0{/stages/pool,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@85ec632{/stages/pool/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@65ef722a{/storage,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@214894fc{/storage/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@e362c57{/storage/rdd,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@79c4715d{/storage/rdd/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@6548bb7d{/environment,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@54336c81{/environment/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@35e52059{/executors,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@49bd54f7{/executors/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@772485dd{/executors/threadDump,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@79ab3a71{/executors/threadDump/json,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@3d829787{/static,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@3ee39da0{/,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@7cc9ce8{/api,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@6d2260db{/jobs/job/kill,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@49bf29c6{/stages/stage/kill,null,AVAILABLE,@Spark}
	18/03/05 09:23:19 INFO ui.SparkUI: Bound SparkUI to 0.0.0.0, and started at http://172.17.0.2:4040
	18/03/05 09:23:19 INFO spark.SparkContext: Added JAR file:/usr/spark-2.2.1/examples/jars/spark-examples_2.11-2.2.1.jar at spark://172.17.0.2:39624/jars/spark-examples_2.11-2.2.1.jar with timestamp 1520241799676
	18/03/05 09:23:19 INFO spark.SparkContext: Added JAR file:/usr/spark-2.2.1/examples/jars/scopt_2.11-3.3.0.jar at spark://172.17.0.2:39624/jars/scopt_2.11-3.3.0.jar with timestamp 1520241799677
	
	18/03/05 09:26:05 INFO executor.Executor: Starting executor ID driver on host localhost
	18/03/05 09:26:05 INFO util.Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 42195.
	18/03/05 09:26:05 INFO netty.NettyBlockTransferService: Server created on 172.17.0.2:42195
	18/03/05 09:26:05 INFO storage.BlockManager: Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy
	18/03/05 09:26:05 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:26:05 INFO storage.BlockManagerMasterEndpoint: Registering block manager 172.17.0.2:42195 with 366.3 MB RAM, BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:26:05 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:26:05 INFO storage.BlockManager: Initialized BlockManager: BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO executor.Executor: Told to re-register on heartbeat
	18/03/05 09:28:23 INFO storage.BlockManager: BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None) re-registering with master
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registering BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManagerMaster: Registered BlockManager BlockManagerId(driver, 172.17.0.2, 42195, None)
	18/03/05 09:28:23 INFO storage.BlockManager: Reporting 0 blocks to the master.
	18/03/05 09:28:23 INFO handler.ContextHandler: Started o.s.j.s.ServletContextHandler@777c350f{/metrics/json,null,AVAILABLE,@Spark}
	18/03/05 09:28:24 INFO spark.SparkContext: Starting job: reduce at SparkPi.scala:38
	18/03/05 09:28:24 INFO scheduler.DAGScheduler: Got job 0 (reduce at SparkPi.scala:38) with 10 output partitions
	18/03/05 09:28:24 INFO scheduler.DAGScheduler: Final stage: ResultStage 0 (reduce at SparkPi.scala:38)
	18/03/05 09:28:24 INFO scheduler.DAGScheduler: Parents of final stage: List()
	18/03/05 09:28:24 INFO scheduler.DAGScheduler: Missing parents: List()
	18/03/05 09:28:24 INFO scheduler.DAGScheduler: Submitting ResultStage 0 (MapPartitionsRDD[1] at map at SparkPi.scala:34), which has no missing parents
	18/03/05 09:28:25 INFO memory.MemoryStore: Block broadcast_0 stored as values in memory (estimated size 1832.0 B, free 366.3 MB)
	18/03/05 09:28:25 INFO memory.MemoryStore: Block broadcast_0_piece0 stored as bytes in memory (estimated size 1172.0 B, free 366.3 MB)
	18/03/05 09:28:25 INFO storage.BlockManagerInfo: Added broadcast_0_piece0 in memory on 172.17.0.2:42195 (size: 1172.0 B, free: 366.3 MB)
	18/03/05 09:28:25 INFO spark.SparkContext: Created broadcast 0 from broadcast at DAGScheduler.scala:1006
	18/03/05 09:28:25 INFO scheduler.DAGScheduler: Submitting 10 missing tasks from ResultStage 0 (MapPartitionsRDD[1] at map at SparkPi.scala:34) (first 15 tasks are for partitions Vector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
	18/03/05 09:28:25 INFO scheduler.TaskSchedulerImpl: Adding task set 0.0 with 10 tasks
	18/03/05 09:28:25 INFO scheduler.TaskSetManager: Starting task 0.0 in stage 0.0 (TID 0, localhost, executor driver, partition 0, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:25 INFO scheduler.TaskSetManager: Starting task 1.0 in stage 0.0 (TID 1, localhost, executor driver, partition 1, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:25 INFO executor.Executor: Running task 0.0 in stage 0.0 (TID 0)
	18/03/05 09:28:25 INFO executor.Executor: Running task 1.0 in stage 0.0 (TID 1)
	18/03/05 09:28:25 INFO executor.Executor: Fetching spark://172.17.0.2:39624/jars/spark-examples_2.11-2.2.1.jar with timestamp 1520241799676
	18/03/05 09:28:25 INFO client.TransportClientFactory: Successfully created connection to /172.17.0.2:39624 after 66 ms (0 ms spent in bootstraps)
	18/03/05 09:28:25 INFO util.Utils: Fetching spark://172.17.0.2:39624/jars/spark-examples_2.11-2.2.1.jar to /tmp/spark-6d7696f2-b314-40c4-9bd6-82c7e1d7f085/userFiles-b541cca1-7343-4094-b9c1-26cbd58deffa/fetchFileTemp4745626250679542071.tmp
	18/03/05 09:28:25 INFO executor.Executor: Adding file:/tmp/spark-6d7696f2-b314-40c4-9bd6-82c7e1d7f085/userFiles-b541cca1-7343-4094-b9c1-26cbd58deffa/spark-examples_2.11-2.2.1.jar to class loader
	18/03/05 09:28:25 INFO executor.Executor: Fetching spark://172.17.0.2:39624/jars/scopt_2.11-3.3.0.jar with timestamp 1520241799677
	18/03/05 09:28:25 INFO util.Utils: Fetching spark://172.17.0.2:39624/jars/scopt_2.11-3.3.0.jar to /tmp/spark-6d7696f2-b314-40c4-9bd6-82c7e1d7f085/userFiles-b541cca1-7343-4094-b9c1-26cbd58deffa/fetchFileTemp9128790563614962400.tmp
	18/03/05 09:28:25 INFO executor.Executor: Adding file:/tmp/spark-6d7696f2-b314-40c4-9bd6-82c7e1d7f085/userFiles-b541cca1-7343-4094-b9c1-26cbd58deffa/scopt_2.11-3.3.0.jar to class loader
	18/03/05 09:28:26 INFO executor.Executor: Finished task 1.0 in stage 0.0 (TID 1). 910 bytes result sent to driver
	18/03/05 09:28:26 INFO executor.Executor: Finished task 0.0 in stage 0.0 (TID 0). 867 bytes result sent to driver
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Starting task 2.0 in stage 0.0 (TID 2, localhost, executor driver, partition 2, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:26 INFO executor.Executor: Running task 2.0 in stage 0.0 (TID 2)
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Starting task 3.0 in stage 0.0 (TID 3, localhost, executor driver, partition 3, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:26 INFO executor.Executor: Running task 3.0 in stage 0.0 (TID 3)
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 1.0 in stage 0.0 (TID 1) in 626 ms on localhost (executor driver) (1/10)
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 0.0 in stage 0.0 (TID 0) in 692 ms on localhost (executor driver) (2/10)
	18/03/05 09:28:26 INFO executor.Executor: Finished task 3.0 in stage 0.0 (TID 3). 824 bytes result sent to driver
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Starting task 4.0 in stage 0.0 (TID 4, localhost, executor driver, partition 4, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:26 INFO executor.Executor: Running task 4.0 in stage 0.0 (TID 4)
	18/03/05 09:28:26 INFO executor.Executor: Finished task 2.0 in stage 0.0 (TID 2). 867 bytes result sent to driver
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Starting task 5.0 in stage 0.0 (TID 5, localhost, executor driver, partition 5, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:26 INFO executor.Executor: Running task 5.0 in stage 0.0 (TID 5)
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 3.0 in stage 0.0 (TID 3) in 54 ms on localhost (executor driver) (3/10)
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 2.0 in stage 0.0 (TID 2) in 64 ms on localhost (executor driver) (4/10)
	18/03/05 09:28:26 INFO executor.Executor: Finished task 5.0 in stage 0.0 (TID 5). 824 bytes result sent to driver
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Starting task 6.0 in stage 0.0 (TID 6, localhost, executor driver, partition 6, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 5.0 in stage 0.0 (TID 5) in 15 ms on localhost (executor driver) (5/10)
	18/03/05 09:28:26 INFO executor.Executor: Running task 6.0 in stage 0.0 (TID 6)
	18/03/05 09:28:26 INFO executor.Executor: Finished task 4.0 in stage 0.0 (TID 4). 824 bytes result sent to driver
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Starting task 7.0 in stage 0.0 (TID 7, localhost, executor driver, partition 7, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 4.0 in stage 0.0 (TID 4) in 46 ms on localhost (executor driver) (6/10)
	18/03/05 09:28:26 INFO executor.Executor: Running task 7.0 in stage 0.0 (TID 7)
	18/03/05 09:28:26 INFO executor.Executor: Finished task 6.0 in stage 0.0 (TID 6). 824 bytes result sent to driver
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Starting task 8.0 in stage 0.0 (TID 8, localhost, executor driver, partition 8, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:26 INFO executor.Executor: Running task 8.0 in stage 0.0 (TID 8)
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 6.0 in stage 0.0 (TID 6) in 33 ms on localhost (executor driver) (7/10)
	18/03/05 09:28:26 INFO executor.Executor: Finished task 8.0 in stage 0.0 (TID 8). 824 bytes result sent to driver
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Starting task 9.0 in stage 0.0 (TID 9, localhost, executor driver, partition 9, PROCESS_LOCAL, 4825 bytes)
	18/03/05 09:28:26 INFO executor.Executor: Running task 9.0 in stage 0.0 (TID 9)
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 8.0 in stage 0.0 (TID 8) in 26 ms on localhost (executor driver) (8/10)
	18/03/05 09:28:26 INFO executor.Executor: Finished task 9.0 in stage 0.0 (TID 9). 824 bytes result sent to driver
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 9.0 in stage 0.0 (TID 9) in 24 ms on localhost (executor driver) (9/10)
	18/03/05 09:28:26 INFO executor.Executor: Finished task 7.0 in stage 0.0 (TID 7). 824 bytes result sent to driver
	18/03/05 09:28:26 INFO scheduler.TaskSetManager: Finished task 7.0 in stage 0.0 (TID 7) in 68 ms on localhost (executor driver) (10/10)
	18/03/05 09:28:26 INFO scheduler.TaskSchedulerImpl: Removed TaskSet 0.0, whose tasks have all completed, from pool
	18/03/05 09:28:26 INFO scheduler.DAGScheduler: ResultStage 0 (reduce at SparkPi.scala:38) finished in 0.852 s
	18/03/05 09:28:26 INFO scheduler.DAGScheduler: Job 0 finished: reduce at SparkPi.scala:38, took 1.629179 s
	Pi is roughly 3.1395631395631396
	18/03/05 09:28:26 INFO server.AbstractConnector: Stopped Spark@d0497b4{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}
	18/03/05 09:28:26 INFO ui.SparkUI: Stopped Spark web UI at http://172.17.0.2:4040
	18/03/05 09:28:26 INFO spark.MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
	18/03/05 09:28:26 INFO memory.MemoryStore: MemoryStore cleared
	18/03/05 09:28:26 INFO storage.BlockManager: BlockManager stopped
	18/03/05 09:28:26 INFO storage.BlockManagerMaster: BlockManagerMaster stopped
	18/03/05 09:28:26 INFO scheduler.OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
	18/03/05 09:28:26 INFO spark.SparkContext: Successfully stopped SparkContext
	18/03/05 09:28:26 INFO util.ShutdownHookManager: Shutdown hook called
	18/03/05 09:28:26 INFO util.ShutdownHookManager: Deleting directory /tmp/spark-6d7696f2-b314-40c4-9bd6-82c7e1d7f085
	[root@sparkonk8s-46929-p4jdl mynginx]#


###
 command:

	  docker run --rm -it -p 4040:4040 gettyimages/spark bin/run-example SparkPi 100000

part Record:


	18/03/05 09:36:27 INFO executor.Executor: Running task 99999.0 in stage 0.0 (TID 99999)
	18/03/05 09:36:27 INFO executor.Executor: Finished task 99999.0 in stage 0.0 (TID 99999). 824 bytes result sent to driver
	18/03/05 09:36:27 INFO scheduler.TaskSetManager: Finished task 99998.0 in stage 0.0 (TID 99998) in 40 ms on localhost (executor driver) (99999/100000)
	18/03/05 09:36:27 INFO scheduler.TaskSetManager: Finished task 99999.0 in stage 0.0 (TID 99999) in 38 ms on localhost (executor driver) (100000/100000)
	18/03/05 09:36:27 INFO scheduler.TaskSchedulerImpl: Removed TaskSet 0.0, whose tasks have all completed, from pool
	18/03/05 09:36:27 INFO scheduler.DAGScheduler: ResultStage 0 (reduce at SparkPi.scala:38) finished in 354.966 s
	18/03/05 09:36:27 INFO scheduler.DAGScheduler: Job 0 finished: reduce at SparkPi.scala:38, took 355.920201 s
	Pi is roughly 3.1415756541691495
	18/03/05 09:36:27 INFO server.AbstractConnector: Stopped Spark@727bbd09{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}
	18/03/05 09:36:27 INFO ui.SparkUI: Stopped Spark web UI at http://172.17.0.2:4040
	18/03/05 09:36:27 INFO spark.MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
	18/03/05 09:36:27 INFO memory.MemoryStore: MemoryStore cleared
	18/03/05 09:36:27 INFO storage.BlockManager: BlockManager stopped
	18/03/05 09:36:27 INFO storage.BlockManagerMaster: BlockManagerMaster stopped
	18/03/05 09:36:27 INFO scheduler.OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
	18/03/05 09:36:27 INFO spark.SparkContext: Successfully stopped SparkContext
	18/03/05 09:36:27 INFO util.ShutdownHookManager: Shutdown hook called
	18/03/05 09:36:27 INFO util.ShutdownHookManager: Deleting directory /tmp/spark-9d9bd9cb-c905-4bc8-b8d5-da3127ab4014
	
	   
reference:

	[1] https://github.com/gettyimages/docker-spark