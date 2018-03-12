java.lang.OutOfMemoryError: GC overhead limit exceeded

##script：

	[root@sparkonk8s-46929-p4jdl k8s]# vi sparkPI.sh
	./auth.sh
	spark-submit \
	  --deploy-mode cluster \
	  --class org.apache.spark.examples.SparkPi \
	  --master k8s://https://192.168.0.188:5443 \
	  --kubernetes-namespace default \
	  --conf spark.executor.instances=3 \
	  --conf spark.executor.memory=512m \
	  --conf spark.driver.memory=512m \
	  --conf spark.executor.cores=1 \
	  --conf spark.app.name=spark-pi \
	  --conf spark.kubernetes.initcontainer.docker.image=100.125.0.198:20202/kernel/spark-init:v2.2.0-kubernetes-0.5.0 \
	  --conf spark.kubernetes.driver.docker.image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0 \
	  --conf spark.kubernetes.executor.docker.image=100.125.0.198:20202/kernel/spark-executor:v2.2.0-kubernetes-0.5.0 \
	  local:///opt/spark/examples/jars/spark-examples_2.11-2.2.0-k8s-0.5.0.jar 1000000000
	  #--master k8s://https://192.168.0.188:5443 \
	  #--master k8s:// 127.0.0.1:8001 \
	  #--conf spark.kubernetes.driver.docker.image=kubespark/spark-driver:v2.2.0-kubernetes-0.5.0 \
	  #--conf spark.kubernetes.executor.docker.image=kubespark/spark-executor:v2.2.0-kubernetes-0.5.0 \

##running：


	[root@sparkonk8s-46929-p4jdl k8s]# ./sparkPI.sh
	Login Succeeded
	2018-03-09 04:16:53 WARN  Utils:66 - Your hostname, sparkonk8s-46929-p4jdl.novalocal resolves to a loopback address: 127.0.0.1; using 192.168.0.202 instead (on interface eth0)
	2018-03-09 04:16:53 WARN  Utils:66 - Set SPARK_LOCAL_IP if you need to bind to another address
	2018-03-09 04:16:54 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520569013257-driver
	         namespace: default
	         labels: spark-app-selector -> spark-add48a23ebc04d5dad98b831eaf6e8a2, spark-role -> driver
	         pod uid: b31b70c5-2350-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:16:54Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-5992f5d6-5ca0-484f-85f0-8da80b6af6e6, default-token-8blbc
	         node name: N/A
	         start time: N/A
	         container images: N/A
	         phase: Pending
	         status: []
	2018-03-09 04:16:54 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520569013257-driver
	         namespace: default
	         labels: spark-app-selector -> spark-add48a23ebc04d5dad98b831eaf6e8a2, spark-role -> driver
	         pod uid: b31b70c5-2350-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:16:54Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-5992f5d6-5ca0-484f-85f0-8da80b6af6e6, default-token-8blbc
	         node name: 192.168.0.174
	         start time: N/A
	         container images: N/A
	         phase: Pending
	         status: []
	2018-03-09 04:16:54 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520569013257-driver
	         namespace: default
	         labels: spark-app-selector -> spark-add48a23ebc04d5dad98b831eaf6e8a2, spark-role -> driver
	         pod uid: b31b70c5-2350-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:16:54Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-5992f5d6-5ca0-484f-85f0-8da80b6af6e6, default-token-8blbc
	         node name: 192.168.0.174
	         start time: 2018-03-09T04:16:54Z
	         container images: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	         phase: Pending
	         status: [ContainerStatus(containerID=null, image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0, imageID=, lastState=ContainerState(running=null, terminated       =null, waiting=null, additionalProperties={}), name=spark-kubernetes-driver, ready=false, restartCount=0, state=ContainerState(running=null, terminated=null, waiting=ContainerStateWa       iting(message=null, reason=ContainerCreating, additionalProperties={}), additionalProperties={}), additionalProperties={})]
	2018-03-09 04:16:54 INFO  Client:54 - Waiting for application spark-pi to finish...
	2018-03-09 04:16:56 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520569013257-driver
	         namespace: default
	         labels: spark-app-selector -> spark-add48a23ebc04d5dad98b831eaf6e8a2, spark-role -> driver
	         pod uid: b31b70c5-2350-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:16:54Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-5992f5d6-5ca0-484f-85f0-8da80b6af6e6, default-token-8blbc
	         node name: 192.168.0.174
	         start time: 2018-03-09T04:16:54Z
	         container images: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	         phase: Running
	         status: [ContainerStatus(containerID=docker://aef9b4e413af033e2ff3e7d19d788025a8a38bb77faff8371b1c44e0e723b30f, image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernet       es-0.5.0, imageID=docker://sha256:38c277999de5620cfaf071cd2677a2242d3997c833044a02164dba001681c48f, lastState=ContainerState(running=null, terminated=null, waiting=null, additionalPr       operties={}), name=spark-kubernetes-driver, ready=true, restartCount=0, state=ContainerState(running=ContainerStateRunning(startedAt=Time(time=2018-03-09T04:16:55Z, additionalPropert       ies={}), additionalProperties={}), terminated=null, waiting=null, additionalProperties={}), additionalProperties={})]
	2018-03-09 04:18:04 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520569013257-driver
	         namespace: default
	         labels: spark-app-selector -> spark-add48a23ebc04d5dad98b831eaf6e8a2, spark-role -> driver
	         pod uid: b31b70c5-2350-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:16:54Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-5992f5d6-5ca0-484f-85f0-8da80b6af6e6, default-token-8blbc
	         node name: 192.168.0.174
	         start time: 2018-03-09T04:16:54Z
	         container images: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	         phase: Failed
	         status: [ContainerStatus(containerID=docker://aef9b4e413af033e2ff3e7d19d788025a8a38bb77faff8371b1c44e0e723b30f, image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernet       es-0.5.0, imageID=docker://sha256:38c277999de5620cfaf071cd2677a2242d3997c833044a02164dba001681c48f, lastState=ContainerState(running=null, terminated=null, waiting=null, additionalPr       operties={}), name=spark-kubernetes-driver, ready=false, restartCount=0, state=ContainerState(running=null, terminated=ContainerStateTerminated(containerID=docker://aef9b4e413af033e2       ff3e7d19d788025a8a38bb77faff8371b1c44e0e723b30f, exitCode=1, finishedAt=Time(time=2018-03-09T04:18:04Z, additionalProperties={}), message=null, reason=Error, signal=null, startedAt=T       ime(time=2018-03-09T04:16:55Z, additionalProperties={}), additionalProperties={}), waiting=null, additionalProperties={}), additionalProperties={})]
	2018-03-09 04:18:04 INFO  LoggingPodStatusWatcherImpl:54 - Container final statuses:
	
	
	         Container name: spark-kubernetes-driver
	         Container image: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	         Container state: Terminated
	         Exit code: 1
	2018-03-09 04:18:04 INFO  Client:54 - Application spark-pi finished.



##log：	
	
	
	{"log":"2018-03-09 04:17:10 INFO  StateStoreCoordinatorRef:54 - Registered StateStoreCoordinator endpoint\n","stream":"stdout","time":"2018-03-09T04:17:10.764450646Z"}
	{"log":"Exception in thread \"main\" java.lang.OutOfMemoryError: GC overhead limit exceeded\n","stream":"stderr","time":"2018-03-09T04:18:03.989653398Z"}
	{"log":"\u0009at scala.collection.Iterator$$anon$21.next(Iterator.scala:838)\n","stream":"stderr","time":"2018-03-09T04:18:03.990210038Z"}
	{"log":"\u0009at scala.collection.Iterator$$anon$21.next(Iterator.scala:834)\n","stream":"stderr","time":"2018-03-09T04:18:03.990368344Z"}
	{"log":"\u0009at scala.collection.Iterator$$anon$11.next(Iterator.scala:409)\n","stream":"stderr","time":"2018-03-09T04:18:03.990445709Z"}
	{"log":"\u0009at scala.collection.Iterator$class.toStream(Iterator.scala:1322)\n","stream":"stderr","time":"2018-03-09T04:18:03.990605384Z"}
	{"log":"\u0009at scala.collection.AbstractIterator.toStream(Iterator.scala:1336)\n","stream":"stderr","time":"2018-03-09T04:18:03.990810206Z"}
	{"log":"\u0009at scala.collection.Iterator$$anonfun$toStream$1.apply(Iterator.scala:1322)\n","stream":"stderr","time":"2018-03-09T04:18:03.990894196Z"}
	{"log":"\u0009at scala.collection.Iterator$$anonfun$toStream$1.apply(Iterator.scala:1322)\n","stream":"stderr","time":"2018-03-09T04:18:03.991053985Z"}
	{"log":"\u0009at scala.collection.immutable.Stream$Cons.tail(Stream.scala:1233)\n","stream":"stderr","time":"2018-03-09T04:18:03.991065217Z"}
	{"log":"\u0009at scala.collection.immutable.Stream$Cons.tail(Stream.scala:1223)\n","stream":"stderr","time":"2018-03-09T04:18:03.9912142Z"}
	{"log":"\u0009at scala.collection.immutable.Stream.length(Stream.scala:312)\n","stream":"stderr","time":"2018-03-09T04:18:03.991295414Z"}
	{"log":"\u0009at scala.collection.SeqLike$class.size(SeqLike.scala:106)\n","stream":"stderr","time":"2018-03-09T04:18:03.991454999Z"}
	{"log":"\u0009at scala.collection.AbstractSeq.size(Seq.scala:41)\n","stream":"stderr","time":"2018-03-09T04:18:03.991533593Z"}
	{"log":"\u0009at scala.collection.TraversableOnce$class.toArray(TraversableOnce.scala:285)\n","stream":"stderr","time":"2018-03-09T04:18:03.991729015Z"}
	{"log":"\u0009at scala.collection.AbstractTraversable.toArray(Traversable.scala:104)\n","stream":"stderr","time":"2018-03-09T04:18:03.991809617Z"}
	{"log":"\u0009at org.apache.spark.rdd.ParallelCollectionRDD.getPartitions(ParallelCollectionRDD.scala:97)\n","stream":"stderr","time":"2018-03-09T04:18:03.991970575Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDD$$anonfun$partitions$2.apply(RDD.scala:252)\n","stream":"stderr","time":"2018-03-09T04:18:03.993731007Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDD$$anonfun$partitions$2.apply(RDD.scala:250)\n","stream":"stderr","time":"2018-03-09T04:18:03.993756281Z"}
	{"log":"\u0009at scala.Option.getOrElse(Option.scala:121)\n","stream":"stderr","time":"2018-03-09T04:18:03.993760682Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDD.partitions(RDD.scala:250)\n","stream":"stderr","time":"2018-03-09T04:18:03.993846641Z"}
	{"log":"\u0009at org.apache.spark.rdd.MapPartitionsRDD.getPartitions(MapPartitionsRDD.scala:35)\n","stream":"stderr","time":"2018-03-09T04:18:03.993862915Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDD$$anonfun$partitions$2.apply(RDD.scala:252)\n","stream":"stderr","time":"2018-03-09T04:18:03.993983802Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDD$$anonfun$partitions$2.apply(RDD.scala:250)\n","stream":"stderr","time":"2018-03-09T04:18:03.994075862Z"}
	{"log":"\u0009at scala.Option.getOrElse(Option.scala:121)\n","stream":"stderr","time":"2018-03-09T04:18:03.994082129Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDD.partitions(RDD.scala:250)\n","stream":"stderr","time":"2018-03-09T04:18:03.994186609Z"}
	{"log":"\u0009at org.apache.spark.SparkContext.runJob(SparkContext.scala:2119)\n","stream":"stderr","time":"2018-03-09T04:18:03.994293291Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDD$$anonfun$reduce$1.apply(RDD.scala:1026)\n","stream":"stderr","time":"2018-03-09T04:18:03.99465051Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:151)\n","stream":"stderr","time":"2018-03-09T04:18:03.994754796Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:112)\n","stream":"stderr","time":"2018-03-09T04:18:03.9947616Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDD.withScope(RDD.scala:362)\n","stream":"stderr","time":"2018-03-09T04:18:03.994858851Z"}
	{"log":"\u0009at org.apache.spark.rdd.RDD.reduce(RDD.scala:1008)\n","stream":"stderr","time":"2018-03-09T04:18:03.99486774Z"}
	{"log":"\u0009at org.apache.spark.examples.SparkPi$.main(SparkPi.scala:38)\n","stream":"stderr","time":"2018-03-09T04:18:03.994979749Z"}
	{"log":"\u0009at org.apache.spark.examples.SparkPi.main(SparkPi.scala)\n","stream":"stderr","time":"2018-03-09T04:18:03.995078764Z"}
	{"log":"2018-03-09 04:18:04 INFO  SparkContext:54 - Invoking stop() from shutdown hook\n","stream":"stdout","time":"2018-03-09T04:18:04.115008478Z"}
	{"log":"2018-03-09 04:18:04 INFO  AbstractConnector:310 - Stopped Spark@5fcacc0{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}\n","stream":"stdout","time":"2018-03-09T04:18:04.127871284Z"}
	{"log":"2018-03-09 04:18:04 INFO  SparkUI:54 - Stopped Spark web UI at http://spark-pi-1520569013257-driver-svc.default.svc.cluster.local:4040\n","stream":"stdout","time":"2018-03-09T04:18:04.131834246Z"}
	{"log":"2018-03-09 04:18:04 INFO  KubernetesClusterSchedulerBackend:54 - Shutting down all executors\n","stream":"stdout","time":"2018-03-09T04:18:04.142393066Z"}
	{"log":"2018-03-09 04:18:04 INFO  KubernetesClusterSchedulerBackend$KubernetesDriverEndpoint:54 - Asking each executor to shut down\n","stream":"stdout","time":"2018-03-09T04:18:04.142950925Z"}
	{"log":"2018-03-09 04:18:04 INFO  KubernetesClusterSchedulerBackend:54 - Closing kubernetes client\n","stream":"stdout","time":"2018-03-09T04:18:04.204639159Z"}
	{"log":"2018-03-09 04:18:04 INFO  MapOutputTrackerMasterEndpoint:54 - MapOutputTrackerMasterEndpoint stopped!\n","stream":"stdout","time":"2018-03-09T04:18:04.216964475Z"}
	{"log":"2018-03-09 04:18:04 INFO  MemoryStore:54 - MemoryStore cleared\n","stream":"stdout","time":"2018-03-09T04:18:04.233439512Z"}
	{"log":"2018-03-09 04:18:04 INFO  BlockManager:54 - BlockManager stopped\n","stream":"stdout","time":"2018-03-09T04:18:04.23405367Z"}
	{"log":"2018-03-09 04:18:04 INFO  BlockManagerMaster:54 - BlockManagerMaster stopped\n","stream":"stdout","time":"2018-03-09T04:18:04.235015872Z"}
	{"log":"2018-03-09 04:18:04 INFO  OutputCommitCoordinator$OutputCommitCoordinatorEndpoint:54 - OutputCommitCoordinator stopped!\n","stream":"stdout","time":"2018-03-09T04:18:04.237036518Z"}
	{"log":"2018-03-09 04:18:04 INFO  SparkContext:54 - Successfully stopped SparkContext\n","stream":"stdout","time":"2018-03-09T04:18:04.247983236Z"}
	{"log":"2018-03-09 04:18:04 INFO  ShutdownHookManager:54 - Shutdown hook called\n","stream":"stdout","time":"2018-03-09T04:18:04.248966451Z"}
	{"log":"2018-03-09 04:18:04 INFO  ShutdownHookManager:54 - Deleting directory /mnt/tmp/spark-local/spark-5992f5d6-5ca0-484f-85f0-8da80b6af6e6/spark-2de436db-3186-45f5-962e-363bc0795281\n","stream":"stdout","time":"2018-03-09T04:18:04.252039935Z"}
	~
