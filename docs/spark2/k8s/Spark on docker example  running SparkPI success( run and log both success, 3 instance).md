Running spark on kubernetes based on huaweicloud CCE cluster
##script：

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
	  local:///opt/spark/examples/jars/spark-examples_2.11-2.2.0-k8s-0.5.0.jar 1000
	  #--master k8s://https://192.168.0.188:5443 \
	  #--master k8s:// 127.0.0.1:8001 \
	  #--conf spark.kubernetes.driver.docker.image=kubespark/spark-driver:v2.2.0-kubernetes-0.5.0 \
	  #--conf spark.kubernetes.executor.docker.image=kubespark/spark-executor:v2.2.0-kubernetes-0.5.0 \
	~
	
## running
	
	[root@sparkonk8s-46929-p4jdl k8s]# ./sparkPI.sh
	Login Succeeded
	2018-03-09 04:09:03 WARN  Utils:66 - Your hostname, sparkonk8s-46929-p4jdl.novalocal resolves to a loopback address: 127.0.0.1; using 192.168.0.202 instead (on interface eth0)
	2018-03-09 04:09:03 WARN  Utils:66 - Set SPARK_LOCAL_IP if you need to bind to another address
	2018-03-09 04:09:04 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520568542694-driver
	         namespace: default
	         labels: spark-app-selector -> spark-1340ea6be86c491a8eb42a40baea4ae9, spark-role -> driver
	         pod uid: 9aa930b4-234f-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:09:03Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-65770c26-ae1f-42a2-a78a-9c6c1f07abf8, default-token-8blbc
	         node name: N/A
	         start time: N/A
	         container images: N/A
	         phase: Pending
	         status: []
	2018-03-09 04:09:04 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520568542694-driver
	         namespace: default
	         labels: spark-app-selector -> spark-1340ea6be86c491a8eb42a40baea4ae9, spark-role -> driver
	         pod uid: 9aa930b4-234f-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:09:03Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-65770c26-ae1f-42a2-a78a-9c6c1f07abf8, default-token-8blbc
	         node name: 192.168.0.174
	         start time: N/A
	         container images: N/A
	         phase: Pending
	         status: []
	2018-03-09 04:09:04 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520568542694-driver
	         namespace: default
	         labels: spark-app-selector -> spark-1340ea6be86c491a8eb42a40baea4ae9, spark-role -> driver
	         pod uid: 9aa930b4-234f-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:09:03Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-65770c26-ae1f-42a2-a78a-9c6c1f07abf8, default-token-8blbc
	         node name: 192.168.0.174
	         start time: 2018-03-09T04:09:03Z
	         container images: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	         phase: Pending
	         status: [ContainerStatus(containerID=null, image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0, imageID=, lastState=ContainerState(running=null, terminated=null, waiting=null, additionalProperties={}), name=spark-kubernetes-driver, ready=false, restartCount=0, state=ContainerState(running=null, terminated=null, waiting=ContainerStateWaiting(message=null, reason=ContainerCreating, additionalProperties={}), additionalProperties={}), additionalProperties={})]
	2018-03-09 04:09:04 INFO  Client:54 - Waiting for application spark-pi to finish...
	2018-03-09 04:09:06 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520568542694-driver
	         namespace: default
	         labels: spark-app-selector -> spark-1340ea6be86c491a8eb42a40baea4ae9, spark-role -> driver
	         pod uid: 9aa930b4-234f-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:09:03Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-65770c26-ae1f-42a2-a78a-9c6c1f07abf8, default-token-8blbc
	         node name: 192.168.0.174
	         start time: 2018-03-09T04:09:03Z
	         container images: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	         phase: Running
	         status: [ContainerStatus(containerID=docker://46c5797bbe16de0b250e06ea4149c67b01e4f243fc861932a7cce380b9f5b25f, image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0, imageID=docker://sha256:38c277999de5620cfaf071cd2677a2242d3997c833044a02164dba001681c48f, lastState=ContainerState(running=null, terminated=null, waiting=null, additionalProperties={}), name=spark-kubernetes-driver, ready=true, restartCount=0, state=ContainerState(running=ContainerStateRunning(startedAt=Time(time=2018-03-09T04:09:05Z, additionalProperties={}), additionalProperties={}), terminated=null, waiting=null, additionalProperties={}), additionalProperties={})]
	2018-03-09 04:09:28 INFO  LoggingPodStatusWatcherImpl:54 - State changed, new state:
	         pod name: spark-pi-1520568542694-driver
	         namespace: default
	         labels: spark-app-selector -> spark-1340ea6be86c491a8eb42a40baea4ae9, spark-role -> driver
	         pod uid: 9aa930b4-234f-11e8-89bc-fa163e44a675
	         creation time: 2018-03-09T04:09:03Z
	         service account name: default
	         volumes: spark-local-dir-0-spark-65770c26-ae1f-42a2-a78a-9c6c1f07abf8, default-token-8blbc
	         node name: 192.168.0.174
	         start time: 2018-03-09T04:09:03Z
	         container images: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	         phase: Succeeded
	         status: [ContainerStatus(containerID=docker://46c5797bbe16de0b250e06ea4149c67b01e4f243fc861932a7cce380b9f5b25f, image=100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0, imageID=docker://sha256:38c277999de5620cfaf071cd2677a2242d3997c833044a02164dba001681c48f, lastState=ContainerState(running=null, terminated=null, waiting=null, additionalProperties={}), name=spark-kubernetes-driver, ready=false, restartCount=0, state=ContainerState(running=null, terminated=ContainerStateTerminated(containerID=docker://46c5797bbe16de0b250e06ea4149c67b01e4f243fc861932a7cce380b9f5b25f, exitCode=0, finishedAt=Time(time=2018-03-09T04:09:27Z, additionalProperties={}), message=null, reason=Completed, signal=null, startedAt=Time(time=2018-03-09T04:09:05Z, additionalProperties={}), additionalProperties={}), waiting=null, additionalProperties={}), additionalProperties={})]
	2018-03-09 04:09:28 INFO  LoggingPodStatusWatcherImpl:54 - Container final statuses:
	
	
	         Container name: spark-kubernetes-driver
	         Container image: 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
	         Container state: Terminated
	         Exit code: 0
	2018-03-09 04:09:28 INFO  Client:54 - Application spark-pi finished.
	
	
	
##log
	
	{"log":"++ id -u\n","stream":"stderr","time":"2018-03-09T04:09:05.46446637Z"}
	{"log":"+ myuid=0\n","stream":"stderr","time":"2018-03-09T04:09:05.476955633Z"}
	{"log":"++ id -g\n","stream":"stderr","time":"2018-03-09T04:09:05.477517176Z"}
	{"log":"+ mygid=0\n","stream":"stderr","time":"2018-03-09T04:09:05.477940899Z"}
	{"log":"++ getent passwd 0\n","stream":"stderr","time":"2018-03-09T04:09:05.477955681Z"}
	{"log":"+ uidentry=root:x:0:0:root:/root:/bin/ash\n","stream":"stderr","time":"2018-03-09T04:09:05.479784924Z"}
	{"log":"+ '[' -z root:x:0:0:root:/root:/bin/ash ']'\n","stream":"stderr","time":"2018-03-09T04:09:05.479981923Z"}
	{"log":"+ /sbin/tini -s -- /bin/sh -c 'SPARK_CLASSPATH=\"${SPARK_HOME}/jars/*\" \u0026\u0026     env | grep SPARK_JAVA_OPT_ | sed '\\''s/[^=]*=\\(.*\\)/\\1/g'\\'' \u003e /tmp/java_opts.txt \u0026\u0026     readarray -t SPARK_DRIVER_JAVA_OPTS \u003c /tmp/java_opts.txt \u0026\u0026     if ! [ -z ${SPARK_MOUNTED_CLASSPATH+x} ]; then SPARK_CLASSPATH=\"$SPARK_MOUNTED_CLASSPATH:$SPARK_CLASSPATH\"; fi \u0026\u0026     if ! [ -z ${SPARK_SUBMIT_EXTRA_CLASSPATH+x} ]; then SPARK_CLASSPATH=\"$SPARK_SUBMIT_EXTRA_CLASSPATH:$SPARK_CLASSPATH\"; fi \u0026\u0026     if ! [ -z ${SPARK_EXTRA_CLASSPATH+x} ]; then SPARK_CLASSPATH=\"$SPARK_EXTRA_CLASSPATH:$SPARK_CLASSPATH\"; fi \u0026\u0026     if ! [ -z ${SPARK_MOUNTED_FILES_DIR+x} ]; then cp -R \"$SPARK_MOUNTED_FILES_DIR/.\" .; fi \u0026\u0026     if ! [ -z ${SPARK_MOUNTED_FILES_FROM_SECRET_DIR} ]; then cp -R \"$SPARK_MOUNTED_FILES_FROM_SECRET_DIR/.\" .; fi \u0026\u0026     ${JAVA_HOME}/bin/java \"${SPARK_DRIVER_JAVA_OPTS[@]}\" -cp $SPARK_CLASSPATH -Xms$SPARK_DRIVER_MEMORY -Xmx$SPARK_DRIVER_MEMORY -Dspark.driver.bindAddress=$SPARK_DRIVER_BIND_ADDRESS $SPARK_DRIVER_CLASS $SPARK_DRIVER_ARGS'\n","stream":"stderr","time":"2018-03-09T04:09:05.480165941Z"}
	{"log":"2018-03-09 04:09:07 INFO  SparkContext:54 - Running Spark version 2.2.0-k8s-0.5.0\n","stream":"stdout","time":"2018-03-09T04:09:07.637850373Z"}
	{"log":"2018-03-09 04:09:08 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable\n","stream":"stdout","time":"2018-03-09T04:09:08.207944674Z"}
	{"log":"2018-03-09 04:09:08 WARN  SparkConf:66 - In Spark 1.0 and later spark.local.dir will be overridden by the value set by the cluster manager (via SPARK_LOCAL_DIRS in mesos/standalone and LOCAL_DIRS in YARN).\n","stream":"stdout","time":"2018-03-09T04:09:08.334353416Z"}
	{"log":"2018-03-09 04:09:08 INFO  SparkContext:54 - Submitted application: Spark Pi\n","stream":"stdout","time":"2018-03-09T04:09:08.417711788Z"}
	{"log":"2018-03-09 04:09:08 INFO  SecurityManager:54 - Changing view acls to: root\n","stream":"stdout","time":"2018-03-09T04:09:08.451718277Z"}
	{"log":"2018-03-09 04:09:08 INFO  SecurityManager:54 - Changing modify acls to: root\n","stream":"stdout","time":"2018-03-09T04:09:08.452964107Z"}
	{"log":"2018-03-09 04:09:08 INFO  SecurityManager:54 - Changing view acls groups to: \n","stream":"stdout","time":"2018-03-09T04:09:08.454881162Z"}
	{"log":"2018-03-09 04:09:08 INFO  SecurityManager:54 - Changing modify acls groups to: \n","stream":"stdout","time":"2018-03-09T04:09:08.456020778Z"}
	{"log":"2018-03-09 04:09:08 INFO  SecurityManager:54 - SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(root); groups with view permissions: Set(); users  with modify permissions: Set(root); groups with modify permissions: Set()\n","stream":"stdout","time":"2018-03-09T04:09:08.460133663Z"}
	{"log":"2018-03-09 04:09:08 INFO  Utils:54 - Successfully started service 'sparkDriver' on port 7078.\n","stream":"stdout","time":"2018-03-09T04:09:08.934384682Z"}
	{"log":"2018-03-09 04:09:08 INFO  SparkEnv:54 - Registering MapOutputTracker\n","stream":"stdout","time":"2018-03-09T04:09:08.968365084Z"}
	{"log":"2018-03-09 04:09:09 INFO  SparkEnv:54 - Registering BlockManagerMaster\n","stream":"stdout","time":"2018-03-09T04:09:09.0283555Z"}
	{"log":"2018-03-09 04:09:09 INFO  BlockManagerMasterEndpoint:54 - Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information\n","stream":"stdout","time":"2018-03-09T04:09:09.032929392Z"}
	{"log":"2018-03-09 04:09:09 INFO  BlockManagerMasterEndpoint:54 - BlockManagerMasterEndpoint up\n","stream":"stdout","time":"2018-03-09T04:09:09.032962092Z"}
	{"log":"2018-03-09 04:09:09 INFO  DiskBlockManager:54 - Created local directory at /mnt/tmp/spark-local/spark-65770c26-ae1f-42a2-a78a-9c6c1f07abf8/blockmgr-36475abf-6039-4fe1-b1ed-70884897a953\n","stream":"stdout","time":"2018-03-09T04:09:09.044279282Z"}
	{"log":"2018-03-09 04:09:09 INFO  MemoryStore:54 - MemoryStore started with capacity 114.6 MB\n","stream":"stdout","time":"2018-03-09T04:09:09.080761537Z"}
	{"log":"2018-03-09 04:09:09 INFO  SparkEnv:54 - Registering OutputCommitCoordinator\n","stream":"stdout","time":"2018-03-09T04:09:09.130765718Z"}
	{"log":"2018-03-09 04:09:09 INFO  log:192 - Logging initialized @3646ms\n","stream":"stdout","time":"2018-03-09T04:09:09.25586916Z"}
	{"log":"2018-03-09 04:09:09 INFO  Server:345 - jetty-9.3.z-SNAPSHOT\n","stream":"stdout","time":"2018-03-09T04:09:09.342671172Z"}
	{"log":"2018-03-09 04:09:09 INFO  Server:403 - Started @3750ms\n","stream":"stdout","time":"2018-03-09T04:09:09.359215408Z"}
	{"log":"2018-03-09 04:09:09 INFO  AbstractConnector:270 - Started ServerConnector@5fcacc0{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}\n","stream":"stdout","time":"2018-03-09T04:09:09.380581563Z"}
	{"log":"2018-03-09 04:09:09 INFO  Utils:54 - Successfully started service 'SparkUI' on port 4040.\n","stream":"stdout","time":"2018-03-09T04:09:09.380826852Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@3af17be2{/jobs,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.426187744Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@40dd3977{/jobs/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.427836115Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6a1d204a{/jobs/job,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.427861865Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6fff253c{/jobs/job/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.428523848Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@591e58fa{/stages,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.429166262Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@2f94c4db{/stages/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.429725734Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@72ccd81a{/stages/stage,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.430293734Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@5d25e6bb{/stages/stage/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.431339216Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@9d157ff{/stages/pool,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.431914676Z"}
	"spark-pi-1520568542694-driver_default_spark-kubernetes-driver-46c5797bbe16de0b250e06ea4149c67b01e4f243fc861932a7cce380b9f5b25f.log" 2117L, 474596C
	{"log":"2018-03-09 04:09:09 INFO  Utils:54 - Successfully started service 'SparkUI' on port 4040.\n","stream":"stdout","time":"2018-03-09T04:09:09.380826852Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@3af17be2{/jobs,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.426187744Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@40dd3977{/jobs/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.427836115Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6a1d204a{/jobs/job,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.427861865Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6fff253c{/jobs/job/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.428523848Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@591e58fa{/stages,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.429166262Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@2f94c4db{/stages/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.429725734Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@72ccd81a{/stages/stage,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.430293734Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@5d25e6bb{/stages/stage/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.431339216Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@9d157ff{/stages/pool,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.431914676Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@5df417a7{/stages/pool/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.432513892Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@7f69d591{/storage,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.43307994Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@1cb3ec38{/storage/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.43364751Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@71c5b236{/storage/rdd,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.434268272Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@2f7a7219{/storage/rdd/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.434864886Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@3a1d593e{/environment,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.435414899Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@361c294e{/environment/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.436023001Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@285d851a{/executors,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.436648291Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@664a9613{/executors/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.437244854Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@15a902e7{/executors/threadDump,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.437942226Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@4a3e3e8b{/executors/threadDump/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.43857445Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@71104a4{/static,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.446604Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@47874b25{/,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.447427144Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@2c177f9e{/api,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.448425485Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6fefce9e{/jobs/job/kill,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.449066728Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@1bdf8190{/stages/stage/kill,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.449731056Z"}
	{"log":"2018-03-09 04:09:09 INFO  SparkUI:54 - Bound SparkUI to 0.0.0.0, and started at http://spark-pi-1520568542694-driver-svc.default.svc.cluster.local:4040\n","stream":"stdout","time":"2018-03-09T04:09:09.451367828Z"}
	{"log":"2018-03-09 04:09:09 INFO  SparkContext:54 - Added JAR /opt/spark/examples/jars/spark-examples_2.11-2.2.0-k8s-0.5.0.jar at spark://spark-pi-1520568542694-driver-svc.default.svc.cluster.local:7078/jars/spark-examples_2.11-2.2.0-k8s-0.5.0.jar with timestamp 1520568549468\n","stream":"stdout","time":"2018-03-09T04:09:09.468855872Z"}
	{"log":"2018-03-09 04:09:09 WARN  KubernetesClusterManager:66 - The executor's init-container config map was not specified. Executors will therefore not attempt to fetch remote or submitted dependencies.\n","stream":"stdout","time":"2018-03-09T04:09:09.563283627Z"}
	
	
	
	
	
	
	
	
	
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@2c177f9e{/api,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.448425485Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6fefce9e{/jobs/job/kill,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.449066728Z"}
	{"log":"2018-03-09 04:09:09 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@1bdf8190{/stages/stage/kill,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:09.449731056Z"}
	{"log":"2018-03-09 04:09:09 INFO  SparkUI:54 - Bound SparkUI to 0.0.0.0, and started at http://spark-pi-1520568542694-driver-svc.default.svc.cluster.local:4040\n","stream":"stdout","time":"2018-03-09T04:09:09.451367828Z"}
	{"log":"2018-03-09 04:09:09 INFO  SparkContext:54 - Added JAR /opt/spark/examples/jars/spark-examples_2.11-2.2.0-k8s-0.5.0.jar at spark://spark-pi-1520568542694-driver-svc.default.svc.cluster.local:7078/jars/spark-examples_2.11-2.2.0-k8s-0.5.0.jar with timestamp 1520568549468\n","stream":"stdout","time":"2018-03-09T04:09:09.468855872Z"}
	{"log":"2018-03-09 04:09:09 WARN  KubernetesClusterManager:66 - The executor's init-container config map was not specified. Executors will therefore not attempt to fetch remote or submitted dependencies.\n","stream":"stdout","time":"2018-03-09T04:09:09.563283627Z"}
	{"log":"2018-03-09 04:09:09 WARN  KubernetesClusterManager:66 - The executor's init-container config map key was not specified. Executors will therefore not attempt to fetch remote or submitted dependencies.\n","stream":"stdout","time":"2018-03-09T04:09:09.567113728Z"}
	{"log":"2018-03-09 04:09:11 INFO  Utils:54 - Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 7079.\n","stream":"stdout","time":"2018-03-09T04:09:11.231439807Z"}
	{"log":"2018-03-09 04:09:11 INFO  NettyBlockTransferService:54 - Server created on spark-pi-1520568542694-driver-svc.default.svc.cluster.local:7079\n","stream":"stdout","time":"2018-03-09T04:09:11.232526758Z"}
	{"log":"2018-03-09 04:09:11 INFO  BlockManager:54 - Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy\n","stream":"stdout","time":"2018-03-09T04:09:11.235136312Z"}
	{"log":"2018-03-09 04:09:11 INFO  BlockManagerMaster:54 - Registering BlockManager BlockManagerId(driver, spark-pi-1520568542694-driver-svc.default.svc.cluster.local, 7079, None)\n","stream":"stdout","time":"2018-03-09T04:09:11.246156827Z"}
	{"log":"2018-03-09 04:09:11 INFO  BlockManagerMasterEndpoint:54 - Registering block manager spark-pi-1520568542694-driver-svc.default.svc.cluster.local:7079 with 114.6 MB RAM, BlockManagerId(driver, spark-pi-1520568542694-driver-svc.default.svc.cluster.local, 7079, None)\n","stream":"stdout","time":"2018-03-09T04:09:11.250578513Z"}
	{"log":"2018-03-09 04:09:11 INFO  BlockManagerMaster:54 - Registered BlockManager BlockManagerId(driver, spark-pi-1520568542694-driver-svc.default.svc.cluster.local, 7079, None)\n","stream":"stdout","time":"2018-03-09T04:09:11.273365429Z"}
	{"log":"2018-03-09 04:09:11 INFO  BlockManager:54 - Initialized BlockManager: BlockManagerId(driver, spark-pi-1520568542694-driver-svc.default.svc.cluster.local, 7079, None)\n","stream":"stdout","time":"2018-03-09T04:09:11.27428196Z"}
	{"log":"2018-03-09 04:09:11 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@30c0d731{/metrics/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:11.337144593Z"}
	{"log":"2018-03-09 04:09:11 INFO  KubernetesClusterSchedulerBackend:54 - Requesting a new executor, total executors is now 1\n","stream":"stdout","time":"2018-03-09T04:09:11.520357573Z"}
	{"log":"2018-03-09 04:09:11 INFO  KubernetesClusterSchedulerBackend:54 - Requesting a new executor, total executors is now 2\n","stream":"stdout","time":"2018-03-09T04:09:11.542546918Z"}
	{"log":"2018-03-09 04:09:11 INFO  KubernetesClusterSchedulerBackend:54 - Requesting a new executor, total executors is now 3\n","stream":"stdout","time":"2018-03-09T04:09:11.566558637Z"}
	{"log":"2018-03-09 04:09:17 INFO  KubernetesClusterSchedulerBackend$KubernetesDriverEndpoint:54 - Registered executor NettyRpcEndpointRef(spark-client://Executor) (172.31.4.22:41876) with ID 3\n","stream":"stdout","time":"2018-03-09T04:09:17.43399436Z"}
	{"log":"2018-03-09 04:09:17 INFO  BlockManagerMasterEndpoint:54 - Registering block manager 172.31.4.22:39167 with 114.6 MB RAM, BlockManagerId(3, 172.31.4.22, 39167, None)\n","stream":"stdout","time":"2018-03-09T04:09:17.499698804Z"}
	{"log":"2018-03-09 04:09:18 INFO  KubernetesClusterSchedulerBackend$KubernetesDriverEndpoint:54 - Registered executor NettyRpcEndpointRef(spark-client://Executor) (172.31.2.7:54576) with ID 1\n","stream":"stdout","time":"2018-03-09T04:09:18.234650412Z"}
	{"log":"2018-03-09 04:09:18 INFO  BlockManagerMasterEndpoint:54 - Registering block manager 172.31.2.7:37756 with 114.6 MB RAM, BlockManagerId(1, 172.31.2.7, 37756, None)\n","stream":"stdout","time":"2018-03-09T04:09:18.297746576Z"}
	{"log":"2018-03-09 04:09:19 INFO  KubernetesClusterSchedulerBackend$KubernetesDriverEndpoint:54 - Registered executor NettyRpcEndpointRef(spark-client://Executor) (172.31.0.14:57528) with ID 2\n","stream":"stdout","time":"2018-03-09T04:09:19.237338324Z"}
	{"log":"2018-03-09 04:09:19 INFO  KubernetesClusterSchedulerBackend:54 - SchedulerBackend is ready for scheduling beginning after reached minRegisteredResourcesRatio: 0.8\n","stream":"stdout","time":"2018-03-09T04:09:19.300407564Z"}
	{"log":"2018-03-09 04:09:19 INFO  BlockManagerMasterEndpoint:54 - Registering block manager 172.31.0.14:33804 with 114.6 MB RAM, BlockManagerId(2, 172.31.0.14, 33804, None)\n","stream":"stdout","time":"2018-03-09T04:09:19.355590026Z"}
	{"log":"2018-03-09 04:09:19 INFO  SharedState:54 - Setting hive.metastore.warehouse.dir ('null') to the value of spark.sql.warehouse.dir ('file:/opt/spark/work-dir/spark-warehouse').\n","stream":"stdout","time":"2018-03-09T04:09:19.395007075Z"}
	{"log":"2018-03-09 04:09:19 INFO  SharedState:54 - Warehouse path is 'file:/opt/spark/work-dir/spark-warehouse'.\n","stream":"stdout","time":"2018-03-09T04:09:19.396405734Z"}
	{"log":"2018-03-09 04:09:19 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6ec65b5e{/SQL,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:19.409465449Z"}
	{"log":"2018-03-09 04:09:19 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@47447ccf{/SQL/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:19.409497976Z"}
	{"log":"2018-03-09 04:09:19 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@45bb2aa1{/SQL/execution,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:19.410225129Z"}
	
	
	{"log":"2018-03-09 04:09:19 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@6ec65b5e{/SQL,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:19.409465449Z"}
	{"log":"2018-03-09 04:09:19 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@47447ccf{/SQL/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:19.409497976Z"}
	{"log":"2018-03-09 04:09:19 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@45bb2aa1{/SQL/execution,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:19.410225129Z"}
	{"log":"2018-03-09 04:09:19 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@4b1a43d8{/SQL/execution/json,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:19.410724579Z"}
	{"log":"2018-03-09 04:09:19 INFO  ContextHandler:781 - Started o.s.j.s.ServletContextHandler@7ea899a9{/static/sql,null,AVAILABLE,@Spark}\n","stream":"stdout","time":"2018-03-09T04:09:19.412013681Z"}
	{"log":"2018-03-09 04:09:20 INFO  StateStoreCoordinatorRef:54 - Registered StateStoreCoordinator endpoint\n","stream":"stdout","time":"2018-03-09T04:09:20.293766476Z"}
	{"log":"2018-03-09 04:09:20 INFO  SparkContext:54 - Starting job: reduce at SparkPi.scala:38\n","stream":"stdout","time":"2018-03-09T04:09:20.481972908Z"}
	{"log":"2018-03-09 04:09:20 INFO  DAGScheduler:54 - Got job 0 (reduce at SparkPi.scala:38) with 1000 output partitions\n","stream":"stdout","time":"2018-03-09T04:09:20.500290343Z"}
	{"log":"2018-03-09 04:09:20 INFO  DAGScheduler:54 - Final stage: ResultStage 0 (reduce at SparkPi.scala:38)\n","stream":"stdout","time":"2018-03-09T04:09:20.500614149Z"}
	{"log":"2018-03-09 04:09:20 INFO  DAGScheduler:54 - Parents of final stage: List()\n","stream":"stdout","time":"2018-03-09T04:09:20.501039909Z"}
	{"log":"2018-03-09 04:09:20 INFO  DAGScheduler:54 - Missing parents: List()\n","stream":"stdout","time":"2018-03-09T04:09:20.502573889Z"}
	{"log":"2018-03-09 04:09:20 INFO  DAGScheduler:54 - Submitting ResultStage 0 (MapPartitionsRDD[1] at map at SparkPi.scala:34), which has no missing parents\n","stream":"stdout","time":"2018-03-09T04:09:20.51003213Z"}
	{"log":"2018-03-09 04:09:20 INFO  MemoryStore:54 - Block broadcast_0 stored as values in memory (estimated size 1832.0 B, free 114.6 MB)\n","stream":"stdout","time":"2018-03-09T04:09:20.697832968Z"}
	{"log":"2018-03-09 04:09:20 INFO  MemoryStore:54 - Block broadcast_0_piece0 stored as bytes in memory (estimated size 1172.0 B, free 114.6 MB)\n","stream":"stdout","time":"2018-03-09T04:09:20.73580629Z"}
	{"log":"2018-03-09 04:09:20 INFO  BlockManagerInfo:54 - Added broadcast_0_piece0 in memory on spark-pi-1520568542694-driver-svc.default.svc.cluster.local:7079 (size: 1172.0 B, free: 114.6 MB)\n","stream":"stdout","time":"2018-03-09T04:09:20.738098396Z"}
	{"log":"2018-03-09 04:09:20 INFO  SparkContext:54 - Created broadcast 0 from broadcast at DAGScheduler.scala:1006\n","stream":"stdout","time":"2018-03-09T04:09:20.741073398Z"}
	{"log":"2018-03-09 04:09:20 INFO  DAGScheduler:54 - Submitting 1000 missing tasks from ResultStage 0 (MapPartitionsRDD[1] at map at SparkPi.scala:34) (first 15 tasks are for partitions Vector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14))\n","stream":"stdout","time":"2018-03-09T04:09:20.764417338Z"}
	{"log":"2018-03-09 04:09:20 INFO  KubernetesTaskSchedulerImpl:54 - Adding task set 0.0 with 1000 tasks\n","stream":"stdout","time":"2018-03-09T04:09:20.765595368Z"}
	{"log":"2018-03-09 04:09:20 INFO  KubernetesTaskSetManager:54 - Starting task 0.0 in stage 0.0 (TID 0, 172.31.0.14, executor 2, partition 0, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:20.805141002Z"}
	{"log":"2018-03-09 04:09:20 INFO  KubernetesTaskSetManager:54 - Starting task 1.0 in stage 0.0 (TID 1, 172.31.4.22, executor 3, partition 1, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:20.808352554Z"}
	{"log":"2018-03-09 04:09:20 INFO  KubernetesTaskSetManager:54 - Starting task 2.0 in stage 0.0 (TID 2, 172.31.2.7, executor 1, partition 2, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:20.809068054Z"}
	{"log":"2018-03-09 04:09:21 INFO  BlockManagerInfo:54 - Added broadcast_0_piece0 in memory on 172.31.4.22:39167 (size: 1172.0 B, free: 114.6 MB)\n","stream":"stdout","time":"2018-03-09T04:09:21.174284331Z"}
	{"log":"2018-03-09 04:09:21 INFO  BlockManagerInfo:54 - Added broadcast_0_piece0 in memory on 172.31.2.7:37756 (size: 1172.0 B, free: 114.6 MB)\n","stream":"stdout","time":"2018-03-09T04:09:21.226572948Z"}
	{"log":"2018-03-09 04:09:21 INFO  BlockManagerInfo:54 - Added broadcast_0_piece0 in memory on 172.31.0.14:33804 (size: 1172.0 B, free: 114.6 MB)\n","stream":"stdout","time":"2018-03-09T04:09:21.386748214Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 3.0 in stage 0.0 (TID 3, 172.31.4.22, executor 3, partition 3, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.411898778Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 1.0 in stage 0.0 (TID 1) in 611 ms on 172.31.4.22 (executor 3) (1/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.423725979Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 4.0 in stage 0.0 (TID 4, 172.31.4.22, executor 3, partition 4, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.50051304Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 3.0 in stage 0.0 (TID 3) in 90 ms on 172.31.4.22 (executor 3) (2/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.501038636Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 5.0 in stage 0.0 (TID 5, 172.31.4.22, executor 3, partition 5, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.523469805Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 4.0 in stage 0.0 (TID 4) in 27 ms on 172.31.4.22 (executor 3) (3/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.528843056Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 6.0 in stage 0.0 (TID 6, 172.31.2.7, executor 1, partition 6, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.54066856Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 2.0 in stage 0.0 (TID 2) in 730 ms on 172.31.2.7 (executor 1) (4/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.544851652Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 7.0 in stage 0.0 (TID 7, 172.31.4.22, executor 3, partition 7, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.554785945Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 5.0 in stage 0.0 (TID 5) in 33 ms on 172.31.4.22 (executor 3) (5/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.55577442Z"}
	
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 7.0 in stage 0.0 (TID 7, 172.31.4.22, executor 3, partition 7, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.554785945Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 5.0 in stage 0.0 (TID 5) in 33 ms on 172.31.4.22 (executor 3) (5/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.55577442Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 8.0 in stage 0.0 (TID 8, 172.31.2.7, executor 1, partition 8, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.563480407Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 6.0 in stage 0.0 (TID 6) in 31 ms on 172.31.2.7 (executor 1) (6/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.565766859Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 9.0 in stage 0.0 (TID 9, 172.31.2.7, executor 1, partition 9, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.581970412Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 8.0 in stage 0.0 (TID 8) in 20 ms on 172.31.2.7 (executor 1) (7/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.582447252Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 10.0 in stage 0.0 (TID 10, 172.31.4.22, executor 3, partition 10, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.583503275Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 7.0 in stage 0.0 (TID 7) in 31 ms on 172.31.4.22 (executor 3) (8/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.584299489Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 11.0 in stage 0.0 (TID 11, 172.31.2.7, executor 1, partition 11, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.605813389Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 9.0 in stage 0.0 (TID 9) in 25 ms on 172.31.2.7 (executor 1) (9/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.606807712Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 12.0 in stage 0.0 (TID 12, 172.31.4.22, executor 3, partition 12, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.613339179Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 10.0 in stage 0.0 (TID 10) in 32 ms on 172.31.4.22 (executor 3) (10/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.614385339Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 13.0 in stage 0.0 (TID 13, 172.31.2.7, executor 1, partition 13, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.629562571Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 11.0 in stage 0.0 (TID 11) in 26 ms on 172.31.2.7 (executor 1) (11/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.631166568Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 14.0 in stage 0.0 (TID 14, 172.31.4.22, executor 3, partition 14, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.64140745Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 12.0 in stage 0.0 (TID 12) in 30 ms on 172.31.4.22 (executor 3) (12/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.642638884Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 15.0 in stage 0.0 (TID 15, 172.31.2.7, executor 1, partition 15, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.652379748Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 13.0 in stage 0.0 (TID 13) in 24 ms on 172.31.2.7 (executor 1) (13/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.655134892Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 16.0 in stage 0.0 (TID 16, 172.31.4.22, executor 3, partition 16, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.667337575Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 14.0 in stage 0.0 (TID 14) in 28 ms on 172.31.4.22 (executor 3) (14/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.668401915Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 17.0 in stage 0.0 (TID 17, 172.31.2.7, executor 1, partition 17, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.68187596Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 15.0 in stage 0.0 (TID 15) in 33 ms on 172.31.2.7 (executor 1) (15/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.683547473Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 18.0 in stage 0.0 (TID 18, 172.31.4.22, executor 3, partition 18, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.689068192Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 16.0 in stage 0.0 (TID 16) in 23 ms on 172.31.4.22 (executor 3) (16/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.690056106Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 19.0 in stage 0.0 (TID 19, 172.31.2.7, executor 1, partition 19, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.698528768Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 17.0 in stage 0.0 (TID 17) in 17 ms on 172.31.2.7 (executor 1) (17/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.699041345Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 20.0 in stage 0.0 (TID 20, 172.31.4.22, executor 3, partition 20, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.715830524Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Finished task 18.0 in stage 0.0 (TID 18) in 29 ms on 172.31.4.22 (executor 3) (18/1000)\n","stream":"stdout","time":"2018-03-09T04:09:21.716429052Z"}
	{"log":"2018-03-09 04:09:21 INFO  KubernetesTaskSetManager:54 - Starting task 21.0 in stage 0.0 (TID 21, 172.31.2.7, executor 1, partition 21, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:21.718477355Z"}
	***
	
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Finished task 993.0 in stage 0.0 (TID 993) in 11 ms on 172.31.4.22 (executor 3) (994/1000)\n","stream":"stdout","time":"2018-03-09T04:09:27.36785047Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Starting task 997.0 in stage 0.0 (TID 997, 172.31.0.14, executor 2, partition 997, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:27.373334762Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Finished task 994.0 in stage 0.0 (TID 994) in 16 ms on 172.31.0.14 (executor 2) (995/1000)\n","stream":"stdout","time":"2018-03-09T04:09:27.373611461Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Starting task 998.0 in stage 0.0 (TID 998, 172.31.2.7, executor 1, partition 998, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:27.380608621Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Finished task 995.0 in stage 0.0 (TID 995) in 14 ms on 172.31.2.7 (executor 1) (996/1000)\n","stream":"stdout","time":"2018-03-09T04:09:27.380644246Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Starting task 999.0 in stage 0.0 (TID 999, 172.31.4.22, executor 3, partition 999, PROCESS_LOCAL, 4844 bytes)\n","stream":"stdout","time":"2018-03-09T04:09:27.382471217Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Finished task 996.0 in stage 0.0 (TID 996) in 15 ms on 172.31.4.22 (executor 3) (997/1000)\n","stream":"stdout","time":"2018-03-09T04:09:27.38667817Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Finished task 997.0 in stage 0.0 (TID 997) in 16 ms on 172.31.0.14 (executor 2) (998/1000)\n","stream":"stdout","time":"2018-03-09T04:09:27.388543014Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Finished task 998.0 in stage 0.0 (TID 998) in 12 ms on 172.31.2.7 (executor 1) (999/1000)\n","stream":"stdout","time":"2018-03-09T04:09:27.391594804Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSetManager:54 - Finished task 999.0 in stage 0.0 (TID 999) in 13 ms on 172.31.4.22 (executor 3) (1000/1000)\n","stream":"stdout","time":"2018-03-09T04:09:27.39590345Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesTaskSchedulerImpl:54 - Removed TaskSet 0.0, whose tasks have all completed, from pool \n","stream":"stdout","time":"2018-03-09T04:09:27.397186169Z"}
	{"log":"2018-03-09 04:09:27 INFO  DAGScheduler:54 - ResultStage 0 (reduce at SparkPi.scala:38) finished in 6.611 s\n","stream":"stdout","time":"2018-03-09T04:09:27.397856795Z"}
	{"log":"2018-03-09 04:09:27 INFO  DAGScheduler:54 - Job 0 finished: reduce at SparkPi.scala:38, took 6.922124 s\n","stream":"stdout","time":"2018-03-09T04:09:27.405890097Z"}
	{"log":"Pi is roughly 3.1416432314164324\n","stream":"stdout","time":"2018-03-09T04:09:27.409104841Z"}
	{"log":"2018-03-09 04:09:27 INFO  AbstractConnector:310 - Stopped Spark@5fcacc0{HTTP/1.1,[http/1.1]}{0.0.0.0:4040}\n","stream":"stdout","time":"2018-03-09T04:09:27.41484854Z"}
	{"log":"2018-03-09 04:09:27 INFO  SparkUI:54 - Stopped Spark web UI at http://spark-pi-1520568542694-driver-svc.default.svc.cluster.local:4040\n","stream":"stdout","time":"2018-03-09T04:09:27.417622188Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesClusterSchedulerBackend:54 - Shutting down all executors\n","stream":"stdout","time":"2018-03-09T04:09:27.426361535Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesClusterSchedulerBackend$KubernetesDriverEndpoint:54 - Asking each executor to shut down\n","stream":"stdout","time":"2018-03-09T04:09:27.426389592Z"}
	{"log":"2018-03-09 04:09:27 INFO  KubernetesClusterSchedulerBackend:54 - Closing kubernetes client\n","stream":"stdout","time":"2018-03-09T04:09:27.465895663Z"}
	{"log":"2018-03-09 04:09:27 INFO  MapOutputTrackerMasterEndpoint:54 - MapOutputTrackerMasterEndpoint stopped!\n","stream":"stdout","time":"2018-03-09T04:09:27.478590287Z"}
	{"log":"2018-03-09 04:09:27 INFO  MemoryStore:54 - MemoryStore cleared\n","stream":"stdout","time":"2018-03-09T04:09:27.48297726Z"}
	{"log":"2018-03-09 04:09:27 INFO  BlockManager:54 - BlockManager stopped\n","stream":"stdout","time":"2018-03-09T04:09:27.483001325Z"}
	{"log":"2018-03-09 04:09:27 INFO  BlockManagerMaster:54 - BlockManagerMaster stopped\n","stream":"stdout","time":"2018-03-09T04:09:27.486493898Z"}
	{"log":"2018-03-09 04:09:27 INFO  OutputCommitCoordinator$OutputCommitCoordinatorEndpoint:54 - OutputCommitCoordinator stopped!\n","stream":"stdout","time":"2018-03-09T04:09:27.49475663Z"}
	{"log":"2018-03-09 04:09:27 INFO  SparkContext:54 - Successfully stopped SparkContext\n","stream":"stdout","time":"2018-03-09T04:09:27.49478011Z"}
	{"log":"2018-03-09 04:09:27 INFO  ShutdownHookManager:54 - Shutdown hook called\n","stream":"stdout","time":"2018-03-09T04:09:27.494783484Z"}
	{"log":"2018-03-09 04:09:27 INFO  ShutdownHookManager:54 - Deleting directory /mnt/tmp/spark-local/spark-65770c26-ae1f-42a2-a78a-9c6c1f07abf8/spark-de4f04c3-b2e6-465f-ab1f-39abd5a75c46\n","stream":"stdout","time":"2018-03-09T04:09:27.49497948Z"}
	
	
	
	
	
	
