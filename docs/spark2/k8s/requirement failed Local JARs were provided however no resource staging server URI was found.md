
##error:

	[root@sparkonk8s-46929-p4jdl k8s]# ./concurrency.sh
	Login Succeeded
	2018-03-09 09:34:33 WARN  Utils:66 - Your hostname, sparkonk8s-46929-p4jdl.novalocal resolves to a loopback address: 127.0.0.1; using 192.168.0.202 instead (on interface eth0)
	2018-03-09 09:34:33 WARN  Utils:66 - Set SPARK_LOCAL_IP if you need to bind to another address
	Exception in thread "main" java.lang.IllegalArgumentException: requirement failed: Local JARs were provided, however no resource staging server URI was found.
	        at scala.Predef$.require(Predef.scala:224)
	        at org.apache.spark.deploy.k8s.OptionRequirements$$anonfun$requireSecondIfFirstIsDefined$1.apply(OptionRequirements.scala:33)
	        at org.apache.spark.deploy.k8s.OptionRequirements$$anonfun$requireSecondIfFirstIsDefined$1.apply(OptionRequirements.scala:32)
	        at scala.Option.foreach(Option.scala:257)
	        at org.apache.spark.deploy.k8s.OptionRequirements$.requireSecondIfFirstIsDefined(OptionRequirements.scala:32)
	        at org.apache.spark.deploy.k8s.submit.submitsteps.initcontainer.InitContainerConfigurationStepsOrchestrator.<init>(InitContainerConfigurationStepsOrchestrator.scala:66)
	        at org.apache.spark.deploy.k8s.submit.DriverConfigurationStepsOrchestrator.getAllConfigurationSteps(DriverConfigurationStepsOrchestrator.scala:154)
	        at org.apache.spark.deploy.k8s.submit.Client$$anonfun$run$5.apply(Client.scala:186)
	        at org.apache.spark.deploy.k8s.submit.Client$$anonfun$run$5.apply(Client.scala:184)
	        at org.apache.spark.util.Utils$.tryWithResource(Utils.scala:2551)
	        at org.apache.spark.deploy.k8s.submit.Client$.run(Client.scala:184)
	        at org.apache.spark.deploy.k8s.submit.Client$.main(Client.scala:204)
	        at org.apache.spark.deploy.k8s.submit.Client.main(Client.scala)
	        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	        at java.lang.reflect.Method.invoke(Method.java:498)
	        at org.apache.spark.deploy.SparkSubmit$.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:786)
	        at org.apache.spark.deploy.SparkSubmit$.doRunMain$1(SparkSubmit.scala:181)
	        at org.apache.spark.deploy.SparkSubmit$.submit(SparkSubmit.scala:206)
	        at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:120)
	        at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)

##log

	[root@sparkonk8s-46929-iyll4 containers]# vi concurrentquerybenchmark-1520587982903-driver_default_spark-kubernetes-driver-8ddc0f9fbea49a7cfe2a333c46d74840d1ddbc02189468272eed6d940cf6f331.log
	{"log":"++ id -u\n","stream":"stderr","time":"2018-03-09T09:33:06.095146792Z"}
	{"log":"+ myuid=0\n","stream":"stderr","time":"2018-03-09T09:33:06.108765133Z"}
	{"log":"++ id -g\n","stream":"stderr","time":"2018-03-09T09:33:06.109349807Z"}
	{"log":"+ mygid=0\n","stream":"stderr","time":"2018-03-09T09:33:06.110079904Z"}
	{"log":"++ getent passwd 0\n","stream":"stderr","time":"2018-03-09T09:33:06.110585521Z"}
	{"log":"+ uidentry=root:x:0:0:root:/root:/bin/ash\n","stream":"stderr","time":"2018-03-09T09:33:06.113616252Z"}
	{"log":"+ '[' -z root:x:0:0:root:/root:/bin/ash ']'\n","stream":"stderr","time":"2018-03-09T09:33:06.113665638Z"}
	{"log":"+ /sbin/tini -s -- /bin/sh -c 'SPARK_CLASSPATH=\"${SPARK_HOME}/jars/*\" \u0026\u0026     env | grep SPARK_JAVA_OPT_ | sed '\\''s/[^=]*=\\(.*\\)/\\1/g'\\'' \u003e /tmp/java_opts.txt \u0026\u0026     readarray -t SPARK_DRIVER_JAVA_OPTS \u003c /tmp/java_opts.txt \u0026\u0026     if ! [ -z ${SPARK_MOUNTED_CLASSPATH+x} ]; then SPARK_CLASSPATH=\"$SPARK_MOUNTED_CLASSPATH:$SPARK_CLASSPATH\"; fi \u0026\u0026     if ! [ -z ${SPARK_SUBMIT_EXTRA_CLASSPATH+x} ]; then SPARK_CLASSPATH=\"$SPARK_SUBMIT_EXTRA_CLASSPATH:$SPARK_CLASSPATH\"; fi \u0026\u0026     if ! [ -z ${SPARK_EXTRA_CLASSPATH+x} ]; then SPARK_CLASSPATH=\"$SPARK_EXTRA_CLASSPATH:$SPARK_CLASSPATH\"; fi \u0026\u0026     if ! [ -z ${SPARK_MOUNTED_FILES_DIR+x} ]; then cp -R \"$SPARK_MOUNTED_FILES_DIR/.\" .; fi \u0026\u0026     if ! [ -z ${SPARK_MOUNTED_FILES_FROM_SECRET_DIR} ]; then cp -R \"$SPARK_MOUNTED_FILES_FROM_SECRET_DIR/.\" .; fi \u0026\u0026     ${JAVA_HOME}/bin/java \"${SPARK_DRIVER_JAVA_OPTS[@]}\" -cp $SPARK_CLASSPATH -Xms$SPARK_DRIVER_MEMORY -Xmx$SPARK_DRIVER_MEMORY -Dspark.driver.bindAddress=$SPARK_DRIVER_BIND_ADDRESS $SPARK_DRIVER_CLASS $SPARK_DRIVER_ARGS'\n","stream":"stderr","time":"2018-03-09T09:33:06.113670516Z"}
	{"log":"Error: Could not find or load main class org.apache.carbondata.benchmark.ConcurrentQueryBenchmark\n","stream":"stderr","time":"2018-03-09T09:33:08.02036683Z"}
	~
	
##solution

[root@sparkonk8s-46929-p4jdl ~]# git clone https://github.com/rootsongjc/kubernetes-handbook.git


[root@sparkonk8s-46929-p4jdl spark-with-kubernetes-native-scheduler]# kubectl create -f kubernetes-resource-staging-server.yaml
deployment "spark-resource-staging-server" created
configmap "spark-resource-staging-server-config" created
service "spark-resource-staging-service" created

and then add conf

--conf spark.kubernetes.resourceStagingServer.uri=http://172.20.0.114:31000 \



reference:

	[1] https://zhuanlan.zhihu.com/p/29349351