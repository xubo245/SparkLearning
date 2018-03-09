	
##script：
	
	  [root@sparkonk8s-46929-p4jdl k8s]# vi k8s2.sh
	  ./auth.sh
	  spark-submit \
	    --deploy-mode cluster \
	    --class org.apache.spark.examples.SparkPi \
	    --master k8s://https://192.168.0.188:5443 \
	    --kubernetes-namespace default \
	    --conf spark.executor.instances=1 \
	    --conf spark.executor.memory=512m \
	    --conf spark.driver.memory=512m \
	    --conf spark.executor.cores=1 \
	    --conf spark.app.name=spark-pi \
	    --conf spark.kubernetes.initcontainer.docker.image=100.125.0.198:20202/kernel/spark-init:v2.2.0-kubernetes-0.5.0 \
	    --conf spark.kubernetes.driver.docker.image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0 \
	    --conf spark.kubernetes.executor.docker.image=100.125.0.198:20202/kernel/spark-executor:v2.2.0-kubernetes-0.5.0 \
	    local:///opt/spark/examples/jars/spark-examples_2.11-2.2.0-k8s-0.5.0.jar 100
	    #--master k8s://https://192.168.0.188:5443 \
	    #--master k8s:// 127.0.0.1:8001 \
	    #--conf spark.kubernetes.driver.docker.image=kubespark/spark-driver:v2.2.0-kubernetes-0.5.0 \
	    #--conf spark.kubernetes.executor.docker.image=kubespark/spark-executor:v2.2.0-kubernetes-0.5.0 \
	
##running	
	  [root@sparkonk8s-46929-p4jdl k8s]# ./k8s2.sh
	  Login Succeeded
	  2018-03-09 03:29:38 WARN  Utils:66 - Your hostname, sparkonk8s-46929-p4jdl.novalocal resolves to a loopback address: 127.0.0.1; using 192.168.0.202 instead (on interface eth0)
	  2018-03-09 03:29:38 WARN  Utils:66 - Set SPARK_LOCAL_IP if you need to bind to another address
	  2018-03-09 03:29:38 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	           pod name: spark-pi-1520566177619-driver
	           namespace: default
	           labels: spark-app-selector -> spark-9e18e2761c20473ea9e09068cbb9b02a, spark-role -> driver
	           pod uid: 19001bc8-234a-11e8-89bc-fa163e44a675
	           creation time: 2018-03-09T03:29:38Z
	           service account name: default
	           volumes: spark-local-dir-0-spark-915053d6-0bbc-4156-8553-b0b26f51f4fa, default-token-8blbc
	           node name: N/A
	           start time: N/A
	           container images: N/A
	           phase: Pending
	           status: []
	  2018-03-09 03:29:38 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	           pod name: spark-pi-1520566177619-driver
	           namespace: default
	           labels: spark-app-selector -> spark-9e18e2761c20473ea9e09068cbb9b02a, spark-role -> driver
	           pod uid: 19001bc8-234a-11e8-89bc-fa163e44a675
	           creation time: 2018-03-09T03:29:38Z
	           service account name: default
	           volumes: spark-local-dir-0-spark-915053d6-0bbc-4156-8553-b0b26f51f4fa, default-token-8blbc
	           node name: 192.168.0.29
	           start time: N/A
	           container images: N/A
	           phase: Pending
	           status: []
	  2018-03-09 03:29:38 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	           pod name: spark-pi-1520566177619-driver
	           namespace: default
	           labels: spark-app-selector -> spark-9e18e2761c20473ea9e09068cbb9b02a, spark-role -> driver
	           pod uid: 19001bc8-234a-11e8-89bc-fa163e44a675
	           creation time: 2018-03-09T03:29:38Z
	           service account name: default
	           volumes: spark-local-dir-0-spark-915053d6-0bbc-4156-8553-b0b26f51f4fa, default-token-8blbc
	           node name: 192.168.0.29
	           start time: 2018-03-09T03:29:38Z
	           container images: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	           phase: Pending
	           status: [ContainerStatus(containerID=null, image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0, imageID=, lastState=ContainerState(running=null, terminated=null, waiting=null, additionalProperties={}), name=spark-kubernetes-driver, ready=false, restartCount=0, state=ContainerState(running=null, terminated=null, waiting=ContainerStateWaiting(message=null, reason=ContainerCreating, additionalProperties={}), additionalProperties={}), additionalProperties={})]
	  2018-03-09 03:29:39 INFO  Client:54 - Waiting for application spark-pi to finish...
	  2018-03-09 03:29:41 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	           pod name: spark-pi-1520566177619-driver
	           namespace: default
	           labels: spark-app-selector -> spark-9e18e2761c20473ea9e09068cbb9b02a, spark-role -> driver
	           pod uid: 19001bc8-234a-11e8-89bc-fa163e44a675
	           creation time: 2018-03-09T03:29:38Z
	           service account name: default
	           volumes: spark-local-dir-0-spark-915053d6-0bbc-4156-8553-b0b26f51f4fa, default-token-8blbc
	           node name: 192.168.0.29
	           start time: 2018-03-09T03:29:38Z
	           container images: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	           phase: Running
	           status: [ContainerStatus(containerID=docker://a18d122ecc059b5412c6ad2d6446325a643cf7fe7c98874c44b8af7dad5b6b11, image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0, imageID=docker://sha256:38c277999de5620cfaf071cd2677a2242d3997c833044a02164dba001681c48f, lastState=ContainerState(running=null, terminated=null, waiting=null, additionalProperties={}), name=spark-kubernetes-driver, ready=true, restartCount=0, state=ContainerState(running=ContainerStateRunning(startedAt=Time(time=2018-03-09T03:29:40Z, additionalProperties={}), additionalProperties={}), terminated=null, waiting=null, additionalProperties={}), additionalProperties={})]
	  2018-03-09 03:30:01 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	           pod name: spark-pi-1520566177619-driver
	           namespace: default
	           labels: spark-app-selector -> spark-9e18e2761c20473ea9e09068cbb9b02a, spark-role -> driver
	           pod uid: 19001bc8-234a-11e8-89bc-fa163e44a675
	           creation time: 2018-03-09T03:29:38Z
	           service account name: default
	           volumes: spark-local-dir-0-spark-915053d6-0bbc-4156-8553-b0b26f51f4fa, default-token-8blbc
	           node name: 192.168.0.29
	           start time: 2018-03-09T03:29:38Z
	           container images: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	           phase: Succeeded
	           status: [ContainerStatus(containerID=docker://a18d122ecc059b5412c6ad2d6446325a643cf7fe7c98874c44b8af7dad5b6b11, image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0, imageID=docker://sha256:38c277999de5620cfaf071cd2677a2242d3997c833044a02164dba001681c48f, lastState=ContainerState(running=null, terminated=null, waiting=null, additionalProperties={}), name=spark-kubernetes-driver, ready=false, restartCount=0, state=ContainerState(running=null, terminated=ContainerStateTerminated(containerID=docker://a18d122ecc059b5412c6ad2d6446325a643cf7fe7c98874c44b8af7dad5b6b11, exitCode=0, finishedAt=Time(time=2018-03-09T03:30:00Z, additionalProperties={}), message=null, reason=Completed, signal=null, startedAt=Time(time=2018-03-09T03:29:40Z, additionalProperties={}), additionalProperties={}), waiting=null, additionalProperties={}), additionalProperties={})]
	  2018-03-09 03:30:01 INFO  LoggingPodStatusWatcherImpl:54 - Container final statuses:
	
	
	           Container name: spark-kubernetes-driver
	           Container image: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	           Container state: Terminated
	           Exit code: 0
	  2018-03-09 03:30:01 INFO  Client:54 - Application spark-pi finished.
	
	
	
	
##log:
	
	  {"log":"++ id -u\n","stream":"stderr","time":"2018-03-09T03:17:06.739189441Z"}
	  {"log":"+ myuid=0\n","stream":"stderr","time":"2018-03-09T03:17:06.758879415Z"}
	  {"log":"++ id -g\n","stream":"stderr","time":"2018-03-09T03:17:06.759201423Z"}
	  {"log":"+ mygid=0\n","stream":"stderr","time":"2018-03-09T03:17:06.759694569Z"}
	  {"log":"++ getent passwd 0\n","stream":"stderr","time":"2018-03-09T03:17:06.75984516Z"}
	  {"log":"+ uidentry=root:x:0:0:root:/root:/bin/ash\n","stream":"stderr","time":"2018-03-09T03:17:06.761605765Z"}
	  {"log":"+ '[' -z root:x:0:0:root:/root:/bin/ash ']'\n","stream":"stderr","time":"2018-03-09T03:17:06.761621405Z"}
	  {"log":"+ /sbin/tini -s -- /bin/sh -c 'SPARK_CLASSPATH=\"${SPARK_HOME}/jars/*\" \u0026\u0026     env | grep SPARK_JAVA_OPT_ | sed '\\''s/[^=]*=\\(.*\\)/\\1/g'\\'' \u003e /tmp/java_opts.txt \u0026\u0026     readarray -t SPARK_DRIVER_JAVA_OPTS \u003c /tmp/java_opts.txt \u0026\u0026     if ! [ -z ${SPARK_MOUNTED_CLASSPATH+x} ]; then SPARK_CLASSPATH=\"$SPARK_MOUNTED_CLASSPATH:$SPARK_CLASSPATH\"; fi \u0026\u0026     if ! [ -z ${SPARK_SUBMIT_EXTRA_CLASSPATH+x} ]; then SPARK_CLASSPATH=\"$SPARK_SUBMIT_EXTRA_CLASSPATH:$SPARK_CLASSPATH\"; fi \u0026\u0026     if ! [ -z ${SPARK_EXTRA_CLASSPATH+x} ]; then SPARK_CLASSPATH=\"$SPARK_EXTRA_CLASSPATH:$SPARK_CLASSPATH\"; fi \u0026\u0026     if ! [ -z ${SPARK_MOUNTED_FILES_DIR+x} ]; then cp -R \"$SPARK_MOUNTED_FILES_DIR/.\" .; fi \u0026\u0026     if ! [ -z ${SPARK_MOUNTED_FILES_FROM_SECRET_DIR} ]; then cp -R \"$SPARK_MOUNTED_FILES_FROM_SECRET_DIR/.\" .; fi \u0026\u0026     ${JAVA_HOME}/bin/java \"${SPARK_DRIVER_JAVA_OPTS[@]}\" -cp $SPARK_CLASSPATH -Xms$SPARK_DRIVER_MEMORY -Xmx$SPARK_DRIVER_MEMORY -Dspark.driver.bindAddress=$SPARK_DRIVER_BIND_ADDRESS $SPARK_DRIVER_CLASS $SPARK_DRIVER_ARGS'\n","stream":"stderr","time":"2018-03-09T03:17:06.761761411Z"}
	  {"log":"2018-03-09 03:17:09 INFO  SparkContext:54 - Running Spark version 2.2.0-k8s-0.5.0\n","stream":"stdout","time":"2018-03-09T03:17:09.384639705Z"}
	  {"log":"2018-03-09 03:17:10 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable\n","stream":"stdout","time":"2018-03-09T03:17:10.029074988Z"}
	  {"log":"2018-03-09 03:17:10 WARN  SparkConf:66 - In Spark 1.0 and later spark.local.dir will be overridden by the value set by the cluster manager (via SPARK_LOCAL_DIRS in mesos/standalone and LOCAL_DIRS in YARN).\n","stream":"stdout","time":"2018-03-09T03:17:10.237283052Z"}
	  {"log":"2018-03-09 03:17:10 INFO  SparkContext:54 - Submitted application: Spark Pi\n","stream":"stdout","time":"2018-03-09T03:17:10.324187101Z"}
	  {"log":"2018-03-09 03:17:10 INFO  SecurityManager:54 - Changing view acls to: root\n","stream":"stdout","time":"2018-03-09T03:17:10.3547724Z"}
	  {"log":"2018-03-09 03:17:10 INFO  SecurityManager:54 - Changing modify acls to: root\n","stream":"stdout","time":"2018-03-09T03:17:10.355824196Z"}
	  {"log":"2018-03-09 03:17:10 INFO  SecurityManager:54 - Changing view acls groups to: \n","stream":"stdout","time":"2018-03-09T03:17:10.356827399Z"}
	  {"log":"2018-03-09 03:17:10 INFO  SecurityManager:54 - Changing modify acls groups to: \n","stream":"stdout","time":"2018-03-09T03:17:10.357791077Z"}
	  {"log":"2018-03-09 03:17:10 INFO  SecurityManager:54 - SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(root); groups with view permissions: Set(); users  with modify permissions: Set(root); groups with modify permissions: Set()\n","stream":"stdout","time":"2018-03-09T03:17:10.358758447Z"}
	  {"log":"2018-03-09 03:17:10 INFO  Utils:54 - Successfully started service 'sparkDriver' on port 7078.\n","stream":"stdout","time":"2018-03-09T03:17:10.924759845Z"}
	  {"log":"2018-03-09 03:17:10 INFO  SparkEnv:54 - Registering MapOutputTracker\n","stream":"stdout","time":"2018-03-09T03:17:10.957249296Z"}
	  {"log":"2018-03-09 03:17:11 INFO  SparkEnv:54 - Registering BlockManagerMaster\n","stream":"stdout","time":"2018-03-09T03:17:11.015955629Z"}
	  {"log":"2018-03-09 03:17:11 INFO  BlockManagerMasterEndpoint:54 - Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information\n","stream":"stdout","time":"2018-03-09T03:17:11.018485065Z"}
	  {"log":"2018-03-09 03:17:11 INFO  BlockManagerMasterEndpoint:54 - BlockManagerMasterEndpoint up\n","stream":"stdout","time":"2018-03-09T03:17:11.018873371Z"}
	  {"log":"2018-03-09 03:17:11 INFO  DiskBlockManager:54 - Created local directory at /mnt/tmp/spark-local/spark-077908c2-da26-4135-aef6-e64a2e0c4e3b/blockmgr-45cd27d4-133c-4784-b907-6576035983cb\n","stream":"stdout","time":"2018-03-09T03:17:11.033436236Z"}
	  {"log":"2018-03-09 03:17:11 INFO  MemoryStore:54 - MemoryStore started with capacity 114.6 MB\n","stream":"stdout","time":"2018-03-09T03:17:11.066890696Z"}
	  {"log":"2018-03-09 03:17:11 INFO  SparkEnv:54 - Registering OutputCommitCoordinator\n","stream":"stdout","time":"2018-03-09T03:17:11.121961187Z"}
	  {"log":"2018-03-09 03:17:11 INFO  log:192 - Logging initialized @4347ms\n","stream":"stdout","time":"2018-03-09T03:17:11.234708986Z"}
	  {"log":"2018-03-09 03:17:11 INFO  Server:345 - jetty-9.3.z-SNAPSHOT\n","stream":"stdout","time":"2018-03-09T03:17:11.307319027Z"}
	  {"log":"2018-03-09 03:17:11 INFO  Server:403 - Started @4436ms\n","stream":"stdout","time":"2018-03-09T03:17:11.322420413Z"}
	  {"log":"2018-03-09 03:17:11 INFO  AbstractConnector:270 - Started ServerConnector@42ba69e9{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}\n","stream":"stdout","time":"2018-03-09T03:17:11.341665228Z"}
	  {"log":"2018-03-09 03:17:11 INFO  Utils:54 - Successfully started service 'SparkUI' on port 4040.\n","stream":"stdout","time":"2018-03-09T03:17:11.341908268Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6e521c1e{/jobs,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.380709635Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@4b6579e8{/jobs/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.381751751Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6c6357f9{/jobs/job,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.382451548Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@2f94c4db{/jobs/job/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.38283603Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@72ccd81a{/stages,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.38336953Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@64bc21ac{/stages/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.383976361Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@5d25e6bb{/stages/stage,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.384489035Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@5df417a7{/stages/stage/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.385550037Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@7f69d591{/stages/pool,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.386087316Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@1cb3ec38{/stages/pool/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.386685976Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@71c5b236{/storage,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.38723663Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@2f7a7219{/storage/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.39138981Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@3a1d593e{/storage/rdd,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.391415124Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@361c294e{/storage/rdd/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.391434449Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@285d851a{/environment,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.391439408Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@664a9613{/environment/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.391443506Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@15a902e7{/executors,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.391447481Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@4a3e3e8b{/executors/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.391666348Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@71104a4{/executors/threadDump,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.392320119Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@72f46e16{/executors/threadDump/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.392957693Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@332a7fce{/static,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.404399264Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@209775a9{/,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.404432097Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@f9b7332{/api,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.404438833Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@8a589a2{/jobs/job/kill,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.404442764Z"}
	  {"log":"2018-03-09 03:17:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6b5176f2{/stages/stage/kill,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:11.40444718Z"}
	  {"log":"2018-03-09 03:17:11 INFO  SparkUI:54 - Bound SparkUI to 0.0.0.0, and started at http://spark-pi-1520565424049-driver-svc.default.svc.cluster.local:4040\n","stream":"stdout","time":"2018-03-09T03:17:11.405163804Z"}
	  {"log":"2018-03-09 03:17:11 INFO  SparkContext:54 - Added JAR /opt/spark/examples/jars/spark-examples_2.11-2.2.0-k8s-0.5.0.jar at spark://spark-pi-1520565424049-driver-svc.default.svc.cluster.local:7078/jars/spark-examples_2.11-2.2.0-k8s-0.5.0.jar with timestamp 1520565431421\n","stream":"stdout","time":"2018-03-09T03:17:11.422534652Z"}
	  {"log":"2018-03-09 03:17:11 WARN  KubernetesClusterManager:66 - The executor's init-container config map was not specified. Executors will therefore not attempt to fetch remote or submitted dependencies.\n","stream":"stdout","time":"2018-03-09T03:17:11.524129122Z"}
	  {"log":"2018-03-09 03:17:11 WARN  KubernetesClusterManager:66 - The executor's init-container config map key was not specified. Executors will therefore not attempt to fetch remote or submitted dependencies.\n","stream":"stdout","time":"2018-03-09T03:17:11.530450456Z"}
	  {"log":"2018-03-09 03:17:13 INFO  Utils:54 - Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 7079.\n","stream":"stdout","time":"2018-03-09T03:17:13.0492646Z"}
	  {"log":"2018-03-09 03:17:13 INFO  NettyBlockTransferService:54 - Server created on spark-pi-1520565424049-driver-svc.default.svc.cluster.local:7079\n","stream":"stdout","time":"2018-03-09T03:17:13.053670398Z"}
	  {"log":"2018-03-09 03:17:13 INFO  BlockManager:54 - Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy\n","stream":"stdout","time":"2018-03-09T03:17:13.053698634Z"}
	  {"log":"2018-03-09 03:17:13 INFO  BlockManagerMaster:54 - Registering BlockManager BlockManagerId(driver, spark-pi-1520565424049-driver-svc.default.svc.cluster.local, 7079, None)\n","stream":"stdout","time":"2018-03-09T03:17:13.057255657Z"}
	  {"log":"2018-03-09 03:17:13 INFO  BlockManagerMasterEndpoint:54 - Registering block manager spark-pi-1520565424049-driver-svc.default.svc.cluster.local:7079 with 114.6 MB RAM, BlockManagerId(driver, spark-pi-1520565424049-driver-svc.default.svc.cluster.local, 7079, None)\n","stream":"stdout","time":"2018-03-09T03:17:13.063319461Z"}
	  {"log":"2018-03-09 03:17:13 INFO  BlockManagerMaster:54 - Registered BlockManager BlockManagerId(driver, spark-pi-1520565424049-driver-svc.default.svc.cluster.local, 7079, None)\n","stream":"stdout","time":"2018-03-09T03:17:13.069886695Z"}
	  {"log":"2018-03-09 03:17:13 INFO  BlockManager:54 - Initialized BlockManager: BlockManagerId(driver, spark-pi-1520565424049-driver-svc.default.svc.cluster.local, 7079, None)\n","stream":"stdout","time":"2018-03-09T03:17:13.070557847Z"}
	  {"log":"2018-03-09 03:17:13 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@629adce{/metrics/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:13.106207733Z"}
	  {"log":"2018-03-09 03:17:14 INFO  KubernetesClusterSchedulerBackend:54 - Requesting a new executor, total executors is now 1\n","stream":"stdout","time":"2018-03-09T03:17:14.194680724Z"}
	  {"log":"2018-03-09 03:17:42 INFO  KubernetesClusterSchedulerBackend:54 - SchedulerBackend is ready for scheduling beginning after waiting maxRegisteredResourcesWaitingTime: 30000(ms)\n","stream":"stdout","time":"2018-03-09T03:17:42.287193021Z"}
	  {"log":"2018-03-09 03:17:42 INFO  SharedState:54 - Setting hive.metastore.warehouse.dir ('null') to the value of spark.sql.warehouse.dir ('file:/opt/spark/work-dir/spark-warehouse').\n","stream":"stdout","time":"2018-03-09T03:17:42.380242034Z"}
	  {"log":"2018-03-09 03:17:42 INFO  SharedState:54 - Warehouse path is 'file:/opt/spark/work-dir/spark-warehouse'.\n","stream":"stdout","time":"2018-03-09T03:17:42.381391768Z"}
	  {"log":"2018-03-09 03:17:42 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@47447ccf{/SQL,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:42.397012083Z"}
	  {"log":"2018-03-09 03:17:42 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@263bbfeb{/SQL/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:42.397044054Z"}
	  {"log":"2018-03-09 03:17:42 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@4b1a43d8{/SQL/execution,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:42.397048571Z"}
	  {"log":"2018-03-09 03:17:42 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@73545b80{/SQL/execution/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:42.397052408Z"}
	  {"log":"2018-03-09 03:17:42 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@b174a73{/static/sql,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T03:17:42.397055483Z"}
	  {"log":"2018-03-09 03:17:43 INFO  StateStoreCoordinatorRef:54 - Registered StateStoreCoordinator endpoint\n","stream":"stdout","time":"2018-03-09T03:17:43.42580359Z"}
	  {"log":"2018-03-09 03:17:43 INFO  SparkContext:54 - Starting job: reduce at SparkPi.scala:38\n","stream":"stdout","time":"2018-03-09T03:17:43.608382789Z"}
	  {"log":"2018-03-09 03:17:43 INFO  DAGScheduler:54 - Got job 0 (reduce at SparkPi.scala:38) with 100 output partitions\n","stream":"stdout","time":"2018-03-09T03:17:43.632529395Z"}
	  {"log":"2018-03-09 03:17:43 INFO  DAGScheduler:54 - Final stage: ResultStage 0 (reduce at SparkPi.scala:38)\n","stream":"stdout","time":"2018-03-09T03:17:43.63293501Z"}
	  {"log":"2018-03-09 03:17:43 INFO  DAGScheduler:54 - Parents of final stage: List()\n","stream":"stdout","time":"2018-03-09T03:17:43.633863961Z"}
	  {"log":"2018-03-09 03:17:43 INFO  DAGScheduler:54 - Missing parents: List()\n","stream":"stdout","time":"2018-03-09T03:17:43.635428744Z"}
	  {"log":"2018-03-09 03:17:43 INFO  DAGScheduler:54 - Submitting ResultStage 0 (MapPartitionsRDD[1] at map at SparkPi.scala:34), which has no missing parents\n","stream":"stdout","time":"2018-03-09T03:17:43.642472071Z"}
	  {"log":"2018-03-09 03:17:43 INFO  MemoryStore:54 - Block broadcast_0 stored as values in memory (estimated size 1832.0 B, free 114.6 MB)\n","stream":"stdout","time":"2018-03-09T03:17:43.821404381Z"}
	  {"log":"2018-03-09 03:17:43 INFO  MemoryStore:54 - Block broadcast_0_piece0 stored as bytes in memory (estimated size 1172.0 B, free 114.6 MB)\n","stream":"stdout","time":"2018-03-09T03:17:43.865332493Z"}
	  {"log":"2018-03-09 03:17:43 INFO  BlockManagerInfo:54 - Added broadcast_0_piece0 in memory on spark-pi-1520565424049-driver-svc.default.svc.cluster.local:7079 (size: 1172.0 B, free: 114.6 MB)\n","stream":"stdout","time":"2018-03-09T03:17:43.867860761Z"}
	  {"log":"2018-03-09 03:17:43 INFO  SparkContext:54 - Created broadcast 0 from broadcast at DAGScheduler.scala:1006\n","stream":"stdout","time":"2018-03-09T03:17:43.871632718Z"}
	  {"log":"2018-03-09 03:17:43 INFO  DAGScheduler:54 - Submitting 100 missing tasks from ResultStage 0 (MapPartitionsRDD[1] at map at SparkPi.scala:34) (first 15 tasks are for partitions Vector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14))\n","stream":"stdout","time":"2018-03-09T03:17:43.88832628Z"}
	  {"log":"2018-03-09 03:17:43 INFO  KubernetesTaskSchedulerImpl:54 - Adding task set 0.0 with 100 tasks\n","stream":"stdout","time":"2018-03-09T03:17:43.889182963Z"}
	  {"log":"2018-03-09 03:17:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:17:58.905478364Z"}
	  {"log":"2018-03-09 03:18:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:18:13.90484608Z"}
	  {"log":"2018-03-09 03:18:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:18:28.905084801Z"}
	  {"log":"2018-03-09 03:18:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:18:43.904621353Z"}
	  {"log":"2018-03-09 03:18:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:18:58.905010641Z"}
	  {"log":"2018-03-09 03:19:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:19:13.905384026Z"}
	  {"log":"2018-03-09 03:19:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:19:28.904801722Z"}
	  {"log":"2018-03-09 03:19:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:19:43.905158172Z"}
	  {"log":"2018-03-09 03:19:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:19:58.904521591Z"}
	  {"log":"2018-03-09 03:20:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:20:13.904886909Z"}
	  {"log":"2018-03-09 03:20:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:20:28.90523748Z"}
	  {"log":"2018-03-09 03:20:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:20:43.904693822Z"}
	  {"log":"2018-03-09 03:20:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:20:58.905034171Z"}
	  {"log":"2018-03-09 03:21:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:21:13.905433976Z"}
	  {"log":"2018-03-09 03:21:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:21:28.904816406Z"}
	  {"log":"2018-03-09 03:21:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:21:43.905137923Z"}
	  {"log":"2018-03-09 03:21:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:21:58.904580742Z"}
	  {"log":"2018-03-09 03:22:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:22:13.904927387Z"}
	  {"log":"2018-03-09 03:22:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:22:28.9053222Z"}
	  {"log":"2018-03-09 03:22:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:22:43.904739013Z"}
	  {"log":"2018-03-09 03:22:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:22:58.905749251Z"}
	  {"log":"2018-03-09 03:23:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:23:13.90541808Z"}
	  {"log":"2018-03-09 03:23:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:23:28.904798826Z"}
	  {"log":"2018-03-09 03:23:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:23:43.90518642Z"}
	  {"log":"2018-03-09 03:23:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:23:58.904534252Z"}
	  {"log":"2018-03-09 03:24:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:24:13.904886552Z"}
	  {"log":"2018-03-09 03:24:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:24:28.905318837Z"}
	  {"log":"2018-03-09 03:24:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:24:43.904726559Z"}
	  {"log":"2018-03-09 03:24:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:24:58.905166719Z"}
	  {"log":"2018-03-09 03:25:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:25:13.90550084Z"}
	  {"log":"2018-03-09 03:25:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:25:28.904914591Z"}
	  {"log":"2018-03-09 03:25:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:25:43.905255131Z"}
	  {"log":"2018-03-09 03:25:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:25:58.904681283Z"}
	  {"log":"2018-03-09 03:26:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:26:13.905066508Z"}
	  {"log":"2018-03-09 03:26:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:26:28.905413446Z"}
	  {"log":"2018-03-09 03:26:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:26:43.904804647Z"}
	  {"log":"2018-03-09 03:26:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:26:58.905123293Z"}
	  {"log":"2018-03-09 03:27:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:27:13.905534858Z"}
	  {"log":"2018-03-09 03:27:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:27:28.904905223Z"}
	  {"log":"2018-03-09 03:27:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:27:43.905242702Z"}
	  {"log":"2018-03-09 03:27:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:27:58.904580243Z"}
	  {"log":"2018-03-09 03:28:13 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:28:13.904939528Z"}
	  {"log":"2018-03-09 03:28:28 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:28:28.905310559Z"}
	  {"log":"2018-03-09 03:28:43 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:28:43.904660054Z"}
	  {"log":"2018-03-09 03:28:58 WARN  KubernetesTaskSchedulerImpl:66 - Initial job has not accepted any resources; check your cluster UI to ensure that workers are registered and have sufficient resources\n","stream":"stdout","time":"2018-03-09T03:28:58.905077392Z"}
	  {"log":"2018-03-09 03:29:08 INFO  KubernetesClusterSchedulerBackend$KubernetesDriverEndpoint:54 - Registered executor NettyRpcEndpointRef(spark-client://Executor) (172.31.0.5:49532) with ID 1\n","stream":"stdout","time":"2018-03-09T03:29:08.246739451Z"}
	  {"log":"2018-03-09 03:29:08 INFO  KubernetesTaskSetManager:54 - Starting task 0.0 in stage 0.0 (TID 0, 172.31.0.5, executor 1, partition 0, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:08.269993081Z"}
	  {"log":"2018-03-09 03:29:08 INFO  BlockManagerMasterEndpoint:54 - Registering block manager 172.31.0.5:40857 with 114.6 MB RAM, BlockManagerId(1, 172.31.0.5, 40857, None)\n","stream":"stdout","time":"2018-03-09T03:29:08.363474872Z"}
	  {"log":"2018-03-09 03:29:09 INFO  BlockManagerInfo:54 - Added broadcast_0_piece0 in memory on 172.31.0.5:40857 (size: 1172.0 B, free: 114.6 MB)\n","stream":"stdout","time":"2018-03-09T03:29:09.005053596Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 1.0 in stage 0.0 (TID 1, 172.31.0.5, executor 1, partition 1, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.365894286Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 0.0 in stage 0.0 (TID 0) in 1120 ms on 172.31.0.5 (executor 1) (1/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.372673264Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 2.0 in stage 0.0 (TID 2, 172.31.0.5, executor 1, partition 2, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.409385266Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 1.0 in stage 0.0 (TID 1) in 44 ms on 172.31.0.5 (executor 1) (2/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.409424333Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 3.0 in stage 0.0 (TID 3, 172.31.0.5, executor 1, partition 3, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.449559665Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 2.0 in stage 0.0 (TID 2) in 43 ms on 172.31.0.5 (executor 1) (3/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.450891172Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 4.0 in stage 0.0 (TID 4, 172.31.0.5, executor 1, partition 4, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.474396435Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 3.0 in stage 0.0 (TID 3) in 26 ms on 172.31.0.5 (executor 1) (4/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.474424237Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 5.0 in stage 0.0 (TID 5, 172.31.0.5, executor 1, partition 5, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.50096621Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 4.0 in stage 0.0 (TID 4) in 27 ms on 172.31.0.5 (executor 1) (5/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.501001415Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 6.0 in stage 0.0 (TID 6, 172.31.0.5, executor 1, partition 6, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.53156612Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 5.0 in stage 0.0 (TID 5) in 32 ms on 172.31.0.5 (executor 1) (6/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.532087117Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 7.0 in stage 0.0 (TID 7, 172.31.0.5, executor 1, partition 7, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.556740316Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 6.0 in stage 0.0 (TID 6) in 27 ms on 172.31.0.5 (executor 1) (7/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.557718103Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 8.0 in stage 0.0 (TID 8, 172.31.0.5, executor 1, partition 8, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.58627794Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 7.0 in stage 0.0 (TID 7) in 30 ms on 172.31.0.5 (executor 1) (8/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.58633467Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 9.0 in stage 0.0 (TID 9, 172.31.0.5, executor 1, partition 9, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.612250276Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 8.0 in stage 0.0 (TID 8) in 28 ms on 172.31.0.5 (executor 1) (9/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.613726433Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 10.0 in stage 0.0 (TID 10, 172.31.0.5, executor 1, partition 10, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.639384339Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 9.0 in stage 0.0 (TID 9) in 28 ms on 172.31.0.5 (executor 1) (10/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.639957545Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 11.0 in stage 0.0 (TID 11, 172.31.0.5, executor 1, partition 11, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.6674881Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 10.0 in stage 0.0 (TID 10) in 28 ms on 172.31.0.5 (executor 1) (11/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.66751846Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 12.0 in stage 0.0 (TID 12, 172.31.0.5, executor 1, partition 12, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.692802004Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 11.0 in stage 0.0 (TID 11) in 27 ms on 172.31.0.5 (executor 1) (12/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.693143796Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 13.0 in stage 0.0 (TID 13, 172.31.0.5, executor 1, partition 13, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.730885464Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 12.0 in stage 0.0 (TID 12) in 40 ms on 172.31.0.5 (executor 1) (13/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.731454173Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 14.0 in stage 0.0 (TID 14, 172.31.0.5, executor 1, partition 14, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.752804059Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 13.0 in stage 0.0 (TID 13) in 24 ms on 172.31.0.5 (executor 1) (14/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.753689258Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 15.0 in stage 0.0 (TID 15, 172.31.0.5, executor 1, partition 15, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.774459743Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 14.0 in stage 0.0 (TID 14) in 22 ms on 172.31.0.5 (executor 1) (15/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.774495407Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 16.0 in stage 0.0 (TID 16, 172.31.0.5, executor 1, partition 16, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.796728115Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 15.0 in stage 0.0 (TID 15) in 24 ms on 172.31.0.5 (executor 1) (16/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.796756042Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 17.0 in stage 0.0 (TID 17, 172.31.0.5, executor 1, partition 17, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.815979109Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 16.0 in stage 0.0 (TID 16) in 21 ms on 172.31.0.5 (executor 1) (17/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.816875761Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 18.0 in stage 0.0 (TID 18, 172.31.0.5, executor 1, partition 18, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.838586656Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 17.0 in stage 0.0 (TID 17) in 22 ms on 172.31.0.5 (executor 1) (18/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.838613904Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 19.0 in stage 0.0 (TID 19, 172.31.0.5, executor 1, partition 19, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.858893635Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 18.0 in stage 0.0 (TID 18) in 23 ms on 172.31.0.5 (executor 1) (19/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.859607857Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 20.0 in stage 0.0 (TID 20, 172.31.0.5, executor 1, partition 20, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.882459957Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 19.0 in stage 0.0 (TID 19) in 24 ms on 172.31.0.5 (executor 1) (20/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.882488655Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 21.0 in stage 0.0 (TID 21, 172.31.0.5, executor 1, partition 21, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.901857675Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 20.0 in stage 0.0 (TID 20) in 21 ms on 172.31.0.5 (executor 1) (21/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.903392129Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 22.0 in stage 0.0 (TID 22, 172.31.0.5, executor 1, partition 22, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.930258304Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 21.0 in stage 0.0 (TID 21) in 29 ms on 172.31.0.5 (executor 1) (22/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.930287476Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 23.0 in stage 0.0 (TID 23, 172.31.0.5, executor 1, partition 23, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.949515914Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 22.0 in stage 0.0 (TID 22) in 21 ms on 172.31.0.5 (executor 1) (23/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.950116792Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 24.0 in stage 0.0 (TID 24, 172.31.0.5, executor 1, partition 24, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.971832729Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 23.0 in stage 0.0 (TID 23) in 23 ms on 172.31.0.5 (executor 1) (24/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.972192268Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Starting task 25.0 in stage 0.0 (TID 25, 172.31.0.5, executor 1, partition 25, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:09.992969453Z"}
	  {"log":"2018-03-09 03:29:09 INFO  KubernetesTaskSetManager:54 - Finished task 24.0 in stage 0.0 (TID 24) in 22 ms on 172.31.0.5 (executor 1) (25/100)\n","stream":"stdout","time":"2018-03-09T03:29:09.993950684Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 26.0 in stage 0.0 (TID 26, 172.31.0.5, executor 1, partition 26, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.013320232Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 25.0 in stage 0.0 (TID 25) in 20 ms on 172.31.0.5 (executor 1) (26/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.013351092Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 27.0 in stage 0.0 (TID 27, 172.31.0.5, executor 1, partition 27, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.031576196Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 26.0 in stage 0.0 (TID 26) in 20 ms on 172.31.0.5 (executor 1) (27/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.03160932Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 28.0 in stage 0.0 (TID 28, 172.31.0.5, executor 1, partition 28, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.074407362Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 27.0 in stage 0.0 (TID 27) in 44 ms on 172.31.0.5 (executor 1) (28/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.075012674Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 29.0 in stage 0.0 (TID 29, 172.31.0.5, executor 1, partition 29, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.09464389Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 28.0 in stage 0.0 (TID 28) in 20 ms on 172.31.0.5 (executor 1) (29/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.094674854Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 30.0 in stage 0.0 (TID 30, 172.31.0.5, executor 1, partition 30, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.116982568Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 29.0 in stage 0.0 (TID 29) in 23 ms on 172.31.0.5 (executor 1) (30/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.117868339Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 31.0 in stage 0.0 (TID 31, 172.31.0.5, executor 1, partition 31, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.137111781Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 30.0 in stage 0.0 (TID 30) in 21 ms on 172.31.0.5 (executor 1) (31/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.137515394Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 32.0 in stage 0.0 (TID 32, 172.31.0.5, executor 1, partition 32, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.159180015Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 31.0 in stage 0.0 (TID 31) in 22 ms on 172.31.0.5 (executor 1) (32/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.159208363Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 33.0 in stage 0.0 (TID 33, 172.31.0.5, executor 1, partition 33, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.183174558Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 32.0 in stage 0.0 (TID 32) in 25 ms on 172.31.0.5 (executor 1) (33/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.183659689Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 34.0 in stage 0.0 (TID 34, 172.31.0.5, executor 1, partition 34, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.207098279Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 33.0 in stage 0.0 (TID 33) in 25 ms on 172.31.0.5 (executor 1) (34/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.207751273Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 35.0 in stage 0.0 (TID 35, 172.31.0.5, executor 1, partition 35, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.224483118Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 34.0 in stage 0.0 (TID 34) in 18 ms on 172.31.0.5 (executor 1) (35/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.224626481Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 36.0 in stage 0.0 (TID 36, 172.31.0.5, executor 1, partition 36, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.246857638Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 35.0 in stage 0.0 (TID 35) in 23 ms on 172.31.0.5 (executor 1) (36/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.247277428Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 37.0 in stage 0.0 (TID 37, 172.31.0.5, executor 1, partition 37, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.267482776Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 36.0 in stage 0.0 (TID 36) in 21 ms on 172.31.0.5 (executor 1) (37/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.267698533Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 38.0 in stage 0.0 (TID 38, 172.31.0.5, executor 1, partition 38, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.285785549Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 37.0 in stage 0.0 (TID 37) in 19 ms on 172.31.0.5 (executor 1) (38/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.286416534Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 39.0 in stage 0.0 (TID 39, 172.31.0.5, executor 1, partition 39, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.314912067Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 38.0 in stage 0.0 (TID 38) in 30 ms on 172.31.0.5 (executor 1) (39/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.315393995Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 40.0 in stage 0.0 (TID 40, 172.31.0.5, executor 1, partition 40, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.334065018Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 39.0 in stage 0.0 (TID 39) in 21 ms on 172.31.0.5 (executor 1) (40/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.334468385Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 41.0 in stage 0.0 (TID 41, 172.31.0.5, executor 1, partition 41, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.356393317Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 40.0 in stage 0.0 (TID 40) in 23 ms on 172.31.0.5 (executor 1) (41/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.356758859Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 42.0 in stage 0.0 (TID 42, 172.31.0.5, executor 1, partition 42, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.374938311Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 41.0 in stage 0.0 (TID 41) in 20 ms on 172.31.0.5 (executor 1) (42/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.376095374Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 43.0 in stage 0.0 (TID 43, 172.31.0.5, executor 1, partition 43, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.397475545Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 42.0 in stage 0.0 (TID 42) in 23 ms on 172.31.0.5 (executor 1) (43/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.397836004Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 44.0 in stage 0.0 (TID 44, 172.31.0.5, executor 1, partition 44, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.418414914Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 43.0 in stage 0.0 (TID 43) in 22 ms on 172.31.0.5 (executor 1) (44/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.41871987Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 45.0 in stage 0.0 (TID 45, 172.31.0.5, executor 1, partition 45, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.440569179Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 44.0 in stage 0.0 (TID 44) in 23 ms on 172.31.0.5 (executor 1) (45/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.441410393Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 46.0 in stage 0.0 (TID 46, 172.31.0.5, executor 1, partition 46, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.469322338Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 45.0 in stage 0.0 (TID 45) in 30 ms on 172.31.0.5 (executor 1) (46/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.469354567Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 47.0 in stage 0.0 (TID 47, 172.31.0.5, executor 1, partition 47, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.493666011Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 46.0 in stage 0.0 (TID 46) in 24 ms on 172.31.0.5 (executor 1) (47/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.49369635Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 48.0 in stage 0.0 (TID 48, 172.31.0.5, executor 1, partition 48, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.512513889Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 47.0 in stage 0.0 (TID 47) in 20 ms on 172.31.0.5 (executor 1) (48/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.512543251Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 49.0 in stage 0.0 (TID 49, 172.31.0.5, executor 1, partition 49, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.533441985Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 48.0 in stage 0.0 (TID 48) in 23 ms on 172.31.0.5 (executor 1) (49/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.534824871Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 50.0 in stage 0.0 (TID 50, 172.31.0.5, executor 1, partition 50, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.557429122Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 49.0 in stage 0.0 (TID 49) in 25 ms on 172.31.0.5 (executor 1) (50/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.557812528Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 51.0 in stage 0.0 (TID 51, 172.31.0.5, executor 1, partition 51, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.577460711Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 50.0 in stage 0.0 (TID 50) in 21 ms on 172.31.0.5 (executor 1) (51/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.577488328Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 52.0 in stage 0.0 (TID 52, 172.31.0.5, executor 1, partition 52, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.599660592Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 51.0 in stage 0.0 (TID 51) in 23 ms on 172.31.0.5 (executor 1) (52/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.599691374Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 53.0 in stage 0.0 (TID 53, 172.31.0.5, executor 1, partition 53, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.62164174Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 52.0 in stage 0.0 (TID 52) in 23 ms on 172.31.0.5 (executor 1) (53/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.621670391Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 54.0 in stage 0.0 (TID 54, 172.31.0.5, executor 1, partition 54, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.643571346Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 53.0 in stage 0.0 (TID 53) in 22 ms on 172.31.0.5 (executor 1) (54/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.643601097Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 55.0 in stage 0.0 (TID 55, 172.31.0.5, executor 1, partition 55, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.663946712Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 54.0 in stage 0.0 (TID 54) in 22 ms on 172.31.0.5 (executor 1) (55/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.663975635Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 56.0 in stage 0.0 (TID 56, 172.31.0.5, executor 1, partition 56, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.686901441Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 55.0 in stage 0.0 (TID 55) in 23 ms on 172.31.0.5 (executor 1) (56/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.686933537Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 57.0 in stage 0.0 (TID 57, 172.31.0.5, executor 1, partition 57, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.710601656Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 56.0 in stage 0.0 (TID 56) in 26 ms on 172.31.0.5 (executor 1) (57/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.711056115Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 58.0 in stage 0.0 (TID 58, 172.31.0.5, executor 1, partition 58, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.731363802Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 57.0 in stage 0.0 (TID 57) in 22 ms on 172.31.0.5 (executor 1) (58/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.732106478Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 59.0 in stage 0.0 (TID 59, 172.31.0.5, executor 1, partition 59, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.753092208Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 58.0 in stage 0.0 (TID 58) in 21 ms on 172.31.0.5 (executor 1) (59/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.753120909Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 60.0 in stage 0.0 (TID 60, 172.31.0.5, executor 1, partition 60, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.773487998Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 59.0 in stage 0.0 (TID 59) in 24 ms on 172.31.0.5 (executor 1) (60/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.774788165Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 61.0 in stage 0.0 (TID 61, 172.31.0.5, executor 1, partition 61, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.794193987Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 60.0 in stage 0.0 (TID 60) in 22 ms on 172.31.0.5 (executor 1) (61/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.794777915Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 62.0 in stage 0.0 (TID 62, 172.31.0.5, executor 1, partition 62, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.817762909Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 61.0 in stage 0.0 (TID 61) in 24 ms on 172.31.0.5 (executor 1) (62/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.817788704Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 63.0 in stage 0.0 (TID 63, 172.31.0.5, executor 1, partition 63, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.838248144Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 62.0 in stage 0.0 (TID 62) in 22 ms on 172.31.0.5 (executor 1) (63/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.838992761Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 64.0 in stage 0.0 (TID 64, 172.31.0.5, executor 1, partition 64, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.859684634Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 63.0 in stage 0.0 (TID 63) in 21 ms on 172.31.0.5 (executor 1) (64/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.859714264Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 65.0 in stage 0.0 (TID 65, 172.31.0.5, executor 1, partition 65, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.880265792Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 64.0 in stage 0.0 (TID 64) in 22 ms on 172.31.0.5 (executor 1) (65/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.880729205Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 66.0 in stage 0.0 (TID 66, 172.31.0.5, executor 1, partition 66, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.935411242Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 65.0 in stage 0.0 (TID 65) in 55 ms on 172.31.0.5 (executor 1) (66/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.935443256Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 67.0 in stage 0.0 (TID 67, 172.31.0.5, executor 1, partition 67, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.95606583Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 66.0 in stage 0.0 (TID 66) in 21 ms on 172.31.0.5 (executor 1) (67/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.956102712Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Starting task 68.0 in stage 0.0 (TID 68, 172.31.0.5, executor 1, partition 68, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:10.97608257Z"}
	  {"log":"2018-03-09 03:29:10 INFO  KubernetesTaskSetManager:54 - Finished task 67.0 in stage 0.0 (TID 67) in 21 ms on 172.31.0.5 (executor 1) (68/100)\n","stream":"stdout","time":"2018-03-09T03:29:10.97611306Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 69.0 in stage 0.0 (TID 69, 172.31.0.5, executor 1, partition 69, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.007737457Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 68.0 in stage 0.0 (TID 68) in 35 ms on 172.31.0.5 (executor 1) (69/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.008568262Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 70.0 in stage 0.0 (TID 70, 172.31.0.5, executor 1, partition 70, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.029015705Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 69.0 in stage 0.0 (TID 69) in 21 ms on 172.31.0.5 (executor 1) (70/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.029214539Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 71.0 in stage 0.0 (TID 71, 172.31.0.5, executor 1, partition 71, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.048705862Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 70.0 in stage 0.0 (TID 70) in 21 ms on 172.31.0.5 (executor 1) (71/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.049028969Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 72.0 in stage 0.0 (TID 72, 172.31.0.5, executor 1, partition 72, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.073317562Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 71.0 in stage 0.0 (TID 71) in 24 ms on 172.31.0.5 (executor 1) (72/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.073356672Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 73.0 in stage 0.0 (TID 73, 172.31.0.5, executor 1, partition 73, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.099014905Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 72.0 in stage 0.0 (TID 72) in 23 ms on 172.31.0.5 (executor 1) (73/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.099041058Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 74.0 in stage 0.0 (TID 74, 172.31.0.5, executor 1, partition 74, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.125457388Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 73.0 in stage 0.0 (TID 73) in 32 ms on 172.31.0.5 (executor 1) (74/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.127462685Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 75.0 in stage 0.0 (TID 75, 172.31.0.5, executor 1, partition 75, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.146450872Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 74.0 in stage 0.0 (TID 74) in 21 ms on 172.31.0.5 (executor 1) (75/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.146481981Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 76.0 in stage 0.0 (TID 76, 172.31.0.5, executor 1, partition 76, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.163910831Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 75.0 in stage 0.0 (TID 75) in 20 ms on 172.31.0.5 (executor 1) (76/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.164999015Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 77.0 in stage 0.0 (TID 77, 172.31.0.5, executor 1, partition 77, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.186767179Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 76.0 in stage 0.0 (TID 76) in 24 ms on 172.31.0.5 (executor 1) (77/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.187643028Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 78.0 in stage 0.0 (TID 78, 172.31.0.5, executor 1, partition 78, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.207657019Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 77.0 in stage 0.0 (TID 77) in 20 ms on 172.31.0.5 (executor 1) (78/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.207699376Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 79.0 in stage 0.0 (TID 79, 172.31.0.5, executor 1, partition 79, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.22658838Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 78.0 in stage 0.0 (TID 78) in 21 ms on 172.31.0.5 (executor 1) (79/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.228829034Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 80.0 in stage 0.0 (TID 80, 172.31.0.5, executor 1, partition 80, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.252512401Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 79.0 in stage 0.0 (TID 79) in 20 ms on 172.31.0.5 (executor 1) (80/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.252549698Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 81.0 in stage 0.0 (TID 81, 172.31.0.5, executor 1, partition 81, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.267096437Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 80.0 in stage 0.0 (TID 80) in 21 ms on 172.31.0.5 (executor 1) (81/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.267134747Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 81.0 in stage 0.0 (TID 81) in 18 ms on 172.31.0.5 (executor 1) (82/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.282572613Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 82.0 in stage 0.0 (TID 82, 172.31.0.5, executor 1, partition 82, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.28393605Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 83.0 in stage 0.0 (TID 83, 172.31.0.5, executor 1, partition 83, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.302259188Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 82.0 in stage 0.0 (TID 82) in 18 ms on 172.31.0.5 (executor 1) (83/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.302283954Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 84.0 in stage 0.0 (TID 84, 172.31.0.5, executor 1, partition 84, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.321234327Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 83.0 in stage 0.0 (TID 83) in 20 ms on 172.31.0.5 (executor 1) (84/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.321259178Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 85.0 in stage 0.0 (TID 85, 172.31.0.5, executor 1, partition 85, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.336058109Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 84.0 in stage 0.0 (TID 84) in 17 ms on 172.31.0.5 (executor 1) (85/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.336566673Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 86.0 in stage 0.0 (TID 86, 172.31.0.5, executor 1, partition 86, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.358313581Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 85.0 in stage 0.0 (TID 85) in 23 ms on 172.31.0.5 (executor 1) (86/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.358770303Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 87.0 in stage 0.0 (TID 87, 172.31.0.5, executor 1, partition 87, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.376488037Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 86.0 in stage 0.0 (TID 86) in 18 ms on 172.31.0.5 (executor 1) (87/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.376515726Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 88.0 in stage 0.0 (TID 88, 172.31.0.5, executor 1, partition 88, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.399152011Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 87.0 in stage 0.0 (TID 87) in 23 ms on 172.31.0.5 (executor 1) (88/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.399179248Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 89.0 in stage 0.0 (TID 89, 172.31.0.5, executor 1, partition 89, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.418334053Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 88.0 in stage 0.0 (TID 88) in 20 ms on 172.31.0.5 (executor 1) (89/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.419585336Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 90.0 in stage 0.0 (TID 90, 172.31.0.5, executor 1, partition 90, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.434882181Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 89.0 in stage 0.0 (TID 89) in 17 ms on 172.31.0.5 (executor 1) (90/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.435217253Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 91.0 in stage 0.0 (TID 91, 172.31.0.5, executor 1, partition 91, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.458337925Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 90.0 in stage 0.0 (TID 90) in 23 ms on 172.31.0.5 (executor 1) (91/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.458378359Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 92.0 in stage 0.0 (TID 92, 172.31.0.5, executor 1, partition 92, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.477392568Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 91.0 in stage 0.0 (TID 91) in 21 ms on 172.31.0.5 (executor 1) (92/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.477896084Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 93.0 in stage 0.0 (TID 93, 172.31.0.5, executor 1, partition 93, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.495812463Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 92.0 in stage 0.0 (TID 92) in 19 ms on 172.31.0.5 (executor 1) (93/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.496592791Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 94.0 in stage 0.0 (TID 94, 172.31.0.5, executor 1, partition 94, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.514378907Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 93.0 in stage 0.0 (TID 93) in 17 ms on 172.31.0.5 (executor 1) (94/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.514409884Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 95.0 in stage 0.0 (TID 95, 172.31.0.5, executor 1, partition 95, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.531346823Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 94.0 in stage 0.0 (TID 94) in 19 ms on 172.31.0.5 (executor 1) (95/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.532662717Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 96.0 in stage 0.0 (TID 96, 172.31.0.5, executor 1, partition 96, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.555594435Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 95.0 in stage 0.0 (TID 95) in 25 ms on 172.31.0.5 (executor 1) (96/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.555621281Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 97.0 in stage 0.0 (TID 97, 172.31.0.5, executor 1, partition 97, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.575980457Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 96.0 in stage 0.0 (TID 96) in 22 ms on 172.31.0.5 (executor 1) (97/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.576665956Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 98.0 in stage 0.0 (TID 98, 172.31.0.5, executor 1, partition 98, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.595810993Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 97.0 in stage 0.0 (TID 97) in 20 ms on 172.31.0.5 (executor 1) (98/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.595854571Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Starting task 99.0 in stage 0.0 (TID 99, 172.31.0.5, executor 1, partition 99, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T03:29:11.622858855Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 98.0 in stage 0.0 (TID 98) in 28 ms on 172.31.0.5 (executor 1) (99/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.62305819Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSetManager:54 - Finished task 99.0 in stage 0.0 (TID 99) in 31 ms on 172.31.0.5 (executor 1) (100/100)\n","stream":"stdout","time":"2018-03-09T03:29:11.653980181Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesTaskSchedulerImpl:54 - Removed TaskSet 0.0, whose tasks have all completed, from pool \n","stream":"stdout","time":"2018-03-09T03:29:11.655609631Z"}
	  {"log":"2018-03-09 03:29:11 INFO  DAGScheduler:54 - ResultStage 0 (reduce at SparkPi.scala:38) finished in 687.751 s\n","stream":"stdout","time":"2018-03-09T03:29:11.660588963Z"}
	  {"log":"2018-03-09 03:29:11 INFO  DAGScheduler:54 - Job 0 finished: reduce at SparkPi.scala:38, took 688.054632 s\n","stream":"stdout","time":"2018-03-09T03:29:11.665530102Z"}
	  {"log":"Pi is roughly 3.1411879141187913\n","stream":"stdout","time":"2018-03-09T03:29:11.670951397Z"}
	  {"log":"2018-03-09 03:29:11 INFO  AbstractConnector:310 - Stopped Spark@42ba69e9{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}\n","stream":"stdout","time":"2018-03-09T03:29:11.67358616Z"}
	  {"log":"2018-03-09 03:29:11 INFO  SparkUI:54 - Stopped Spark web UI at http://spark-pi-1520565424049-driver-svc.default.svc.cluster.local:4040\n","stream":"stdout","time":"2018-03-09T03:29:11.675003908Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesClusterSchedulerBackend:54 - Shutting down all executors\n","stream":"stdout","time":"2018-03-09T03:29:11.679264375Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesClusterSchedulerBackend$KubernetesDriverEndpoint:54 - Asking each executor to shut down\n","stream":"stdout","time":"2018-03-09T03:29:11.679889574Z"}
	  {"log":"2018-03-09 03:29:11 INFO  KubernetesClusterSchedulerBackend:54 - Closing kubernetes client\n","stream":"stdout","time":"2018-03-09T03:29:11.751497167Z"}
	  {"log":"2018-03-09 03:29:11 INFO  MapOutputTrackerMasterEndpoint:54 - MapOutputTrackerMasterEndpoint stopped!\n","stream":"stdout","time":"2018-03-09T03:29:11.75888128Z"}
	  {"log":"2018-03-09 03:29:11 INFO  MemoryStore:54 - MemoryStore cleared\n","stream":"stdout","time":"2018-03-09T03:29:11.765157148Z"}
	  {"log":"2018-03-09 03:29:11 INFO  BlockManager:54 - BlockManager stopped\n","stream":"stdout","time":"2018-03-09T03:29:11.765513523Z"}
	  {"log":"2018-03-09 03:29:11 INFO  BlockManagerMaster:54 - BlockManagerMaster stopped\n","stream":"stdout","time":"2018-03-09T03:29:11.768999351Z"}
	  {"log":"2018-03-09 03:29:11 INFO  OutputCommitCoordinator$OutputCommitCoordinatorEndpoint:54 - OutputCommitCoordinator stopped!\n","stream":"stdout","time":"2018-03-09T03:29:11.770888012Z"}
	  {"log":"2018-03-09 03:29:11 INFO  SparkContext:54 - Successfully stopped SparkContext\n","stream":"stdout","time":"2018-03-09T03:29:11.777704227Z"}
	  {"log":"2018-03-09 03:29:11 INFO  ShutdownHookManager:54 - Shutdown hook called\n","stream":"stdout","time":"2018-03-09T03:29:11.77961987Z"}
	  {"log":"2018-03-09 03:29:11 INFO  ShutdownHookManager:54 - Deleting directory /mnt/tmp/spark-local/spark-077908c2-da26-4135-aef6-e64a2e0c4e3b/spark-5c192343-5494-4bdf-a3d4-7bb049c3f984\n","stream":"stdout","time":"2018-03-09T03:29:11.780574423Z"}
