	Authenticating with public key "imported-openssh-key"
	     ┌────────────────────────────────────────────────────────────────────┐
	     │                        • MobaXterm 10.5 •                          │
	     │            (SSH client, X-server and networking tools)             │
	     │                                                                    │
	     │ ➤ SSH session to root@49.4.69.6                                    │
	     │   • SSH compression : ✔                                            │
	     │   • SSH-browser     : ✔                                            │
	     │   • X11-forwarding  : ✘  (disabled or not supported by server)     │
	     │   • DISPLAY         : 10.229.32.110:0.0                            │
	     │                                                                    │
	     │ ➤ For more info, ctrl+click on help or visit our website           │
	     └────────────────────────────────────────────────────────────────────┘
	
	
	Authorized users only. All activities may be monitored and reported.
	Last login: Wed Mar  7 03:30:34 2018 from 119.145.15.121
	  ######################################################################
	  #                              Notice                                #
	  #                                                                    #
	  #  1. Please DO NOT upgrade the kernel, as the kernel upgrade would  #
	  #   damage the original operating system.                            #
	  #                                                                    #
	  #  2. Please create unique passwords that use a combination of words,#
	  #   numbers, symbols, and both upper-case and lower-case letters.    #
	  #   Avoid using simple adjacent keyboard combinations such as        #
	  #   "Qwert!234","Qaz2wsx",etc.                                       #
	  #                                                                    #
	  #  3. Unless necessary, please DO NOT open or use high-risk ports,   #
	  #   such as Telnet-23, FTP-20/21, NTP-123(UDP), RDP-3389,            #
	  #   SSH/SFTP-22, Mysql-3306, SQL-1433,etc.                           #
	  #                                                                    #
	  #                                                                    #
	  #                     Any questions please contact 4000-955-988      #
	  ######################################################################
	[root@sparkonk8s-46929-p4jdl ~]# minikube status
	ku      status
	minikube: Running
	cluster: Running
	kubectl: Correctly Configured: pointing to minikube-vm at 192.168.0.202
	[root@sparkonk8s-46929-p4jdl ~]# kubestatus
	-bash: kubestatus: command not found
	[root@sparkonk8s-46929-p4jdl ~]# minikube status
	ku       get pods
	minikube: Running
	cluster: Running
	kubectl: Correctly Configured: pointing to minikube-vm at 192.168.0.202
	[root@sparkonk8s-46929-p4jdl ~]# kube get pods
	-bash: kube: command not found
	[root@sparkonk8s-46929-p4jdl ~]# kubectl get pods
	NAME                             READY     STATUS             RESTARTS   AGE
	icagent-2fhzc                    0/0       Running            0          2d
	icagent-d84d7                    0/0       NodeLost           0          2d
	icagent-dnfmw                    0/0       Running            0          2d
	icagent-f765n                    0/0       Running            0          2d
	icagent-wl12q                    0/0       Running            0          2d
	nginxcarbonda-1937514235-3mlw9   1/1       Running            0          1d
	nginxcarbonda-1937514235-f8p3p   1/1       Running            0          1d
	nginxcarbonda-1937514235-rd3jz   1/1       Running            0          1d
	nginxeuler-3188622173-5g52q      1/1       Running            0          4d
	nginxeuler-3188622173-dxcqs      1/1       Running            0          4d
	nginxv3-2622272071-l07wt         0/1       ImagePullBackOff   0          1d
	nginxv4-4176425979-qqncd         1/1       Running            0          1d
	nginxv5-592882569-gtdx4          0/1       ImagePullBackOff   0          1d
	nginxv6-30840885-rm7dk           1/1       Running            0          1d
	spark7077-0                      1/1       Running            0          18h
	spark7077-1                      1/1       Running            0          18h
	spark7077-2                      1/1       Running            0          18h
	sparkgetting-2685462660-44q66    1/1       Running            0          1d
	sparkgetting-2685462660-5q50t    1/1       Running            0          1d
	sparkgetting-2685462660-p4xk2    1/1       Running            0          1d
	sparkgettyimages-0               1/1       Running            0          1d
	sparkgettyimages-1               1/1       Running            0          23h
	sparkgettyimages-2               1/1       Running            0          1d
	sparkgettyimages-3               1/1       Running            0          1d
	sparkgettyimages-4               1/1       Running            0          1d
	[root@sparkonk8s-46929-p4jdl ~]# ls
	common_shared.key  images  k8s  myimage  mynginx  root.key  scala-2.11.8.zip  spark  xubo
	[root@sparkonk8s-46929-p4jdl ~]# cd xubo/
	git/   tools/
	[root@sparkonk8s-46929-p4jdl ~]# cd xubo/git/
	[root@sparkonk8s-46929-p4jdl git]# ls
	[root@sparkonk8s-46929-p4jdl git]# cd ../../
	[root@sparkonk8s-46929-p4jdl ~]# ls
	common_shared.key  images  k8s  myimage  mynginx  root.key  scala-2.11.8.zip  spark  xubo
	[root@sparkonk8s-46929-p4jdl ~]# ls
	common_shared.key  images  k8s  myimage  mynginx  root.key  scala-2.11.8.zip  spark  xubo
	[root@sparkonk8s-46929-p4jdl ~]# cd k8s/
	[root@sparkonk8s-46929-p4jdl k8s]# ls
	backup  build201803061753.txt  count.py  kubeconfig  namespace  nginxv4.yaml  nginxv5.yaml  nginxv6.yaml  nginx.yaml  run.sh
	[root@sparkonk8s-46929-p4jdl k8s]# cd ../
	[root@sparkonk8s-46929-p4jdl ~]# cd spark/
	[root@sparkonk8s-46929-p4jdl spark]# ls
	appveyor.yml  build                  build201803061753.txt  conf             data  examples  hadoop-cloud  licenses     NOTICE   project  README.md          sbin                   streaming
	assembly      build201803061456.txt  build201803061902.txt  CONTRIBUTING.md  dev   external  launcher      mllib        pods     python   repl               scalastyle-config.xml  target
	bin           build201803061528.txt  common                 core             docs  graphx    LICENSE       mllib-local  pom.xml  R        resource-managers  sql                    tools
	[root@sparkonk8s-46929-p4jdl spark]# find / -name Dock*
	/usr/share/nano/Dockerfile.nanorc
	/usr/share/man/man5/Dockerfile.5.gz
	/root/myimage/Dockerfile
	/root/spark/external/docker-integration-tests/src/test/scala/org/apache/spark/sql/jdbc/DockerJDBCIntegrationSuite.scala
	/root/spark/external/docker-integration-tests/src/test/scala/org/apache/spark/util/DockerUtils.scala
	/root/spark/external/docker/spark-mesos/Dockerfile
	/root/spark/external/docker/spark-test/worker/Dockerfile
	/root/spark/external/docker/spark-test/base/Dockerfile
	/root/spark/external/docker/spark-test/master/Dockerfile
	/root/spark/resource-managers/kubernetes/docker/src/main/dockerfiles/spark/Dockerfile
	/root/spark/common/tags/target/scala-2.11/test-classes/org/apache/spark/tags/DockerTest.class
	/root/spark/common/tags/src/test/java/org/apache/spark/tags/DockerTest.java
	/root/spark/core/target/scala-2.11/classes/org/apache/spark/deploy/Docker$$anonfun$getLastProcessId$1.class
	/root/spark/core/target/scala-2.11/classes/org/apache/spark/deploy/Docker$.class
	/root/spark/core/target/scala-2.11/classes/org/apache/spark/deploy/Docker$$anonfun$makeRunCmd$1.class
	/root/spark/core/target/scala-2.11/classes/org/apache/spark/deploy/Docker.class
	/root/spark/core/target/scala-2.11/classes/org/apache/spark/deploy/DockerId.class
	/root/mynginx/Dockerfile
	[root@sparkonk8s-46929-p4jdl spark]# ^C
	[root@sparkonk8s-46929-p4jdl spark]# find ./ -name Dock*
	./external/docker-integration-tests/src/test/scala/org/apache/spark/sql/jdbc/DockerJDBCIntegrationSuite.scala
	./external/docker-integration-tests/src/test/scala/org/apache/spark/util/DockerUtils.scala
	./external/docker/spark-mesos/Dockerfile
	./external/docker/spark-test/worker/Dockerfile
	./external/docker/spark-test/base/Dockerfile
	./external/docker/spark-test/master/Dockerfile
	./resource-managers/kubernetes/docker/src/main/dockerfiles/spark/Dockerfile
	./common/tags/target/scala-2.11/test-classes/org/apache/spark/tags/DockerTest.class
	./common/tags/src/test/java/org/apache/spark/tags/DockerTest.java
	./core/target/scala-2.11/classes/org/apache/spark/deploy/Docker$$anonfun$getLastProcessId$1.class
	./core/target/scala-2.11/classes/org/apache/spark/deploy/Docker$.class
	./core/target/scala-2.11/classes/org/apache/spark/deploy/Docker$$anonfun$makeRunCmd$1.class
	./core/target/scala-2.11/classes/org/apache/spark/deploy/Docker.class
	./core/target/scala-2.11/classes/org/apache/spark/deploy/DockerId.class
	[root@sparkonk8s-46929-p4jdl spark]#
	[root@sparkonk8s-46929-p4jdl spark]#
	[root@sparkonk8s-46929-p4jdl spark]#
	[root@sparkonk8s-46929-p4jdl spark]# find ./ -name Dock*
	./external/docker-integration-tests/src/test/scala/org/apache/spark/sql/jdbc/DockerJDBCIntegrationSuite.scala
	./external/docker-integration-tests/src/test/scala/org/apache/spark/util/DockerUtils.scala
	./external/docker/spark-mesos/Dockerfile
	./external/docker/spark-test/worker/Dockerfile
	./external/docker/spark-test/base/Dockerfile
	./external/docker/spark-test/master/Dockerfile
	./resource-managers/kubernetes/docker/src/main/dockerfiles/spark/Dockerfile
	./common/tags/target/scala-2.11/test-classes/org/apache/spark/tags/DockerTest.class
	./common/tags/src/test/java/org/apache/spark/tags/DockerTest.java
	./core/target/scala-2.11/classes/org/apache/spark/deploy/Docker$$anonfun$getLastProcessId$1.class
	./core/target/scala-2.11/classes/org/apache/spark/deploy/Docker$.class
	./core/target/scala-2.11/classes/org/apache/spark/deploy/Docker$$anonfun$makeRunCmd$1.class
	./core/target/scala-2.11/classes/org/apache/spark/deploy/Docker.class
	./core/target/scala-2.11/classes/org/apache/spark/deploy/DockerId.class
	[root@sparkonk8s-46929-p4jdl spark]# vi ./resource-managers/kubernetes/docker/src/main/dockerfiles/spark/Dockerfile
	[root@sparkonk8s-46929-p4jdl spark]# kubectl create -f  ./resource-managers/kubernetes/docker/src/main/dockerfiles/spark/Dockerfile
	error: error converting YAML to JSON: yaml: line 29: did not find expected <document start>
	[root@sparkonk8s-46929-p4jdl spark]# kubectl create -f  ./resource-managers/kubernetes/docker/src/main/dockerfiles/spark/Dockerfile
	error: error converting YAML to JSON: yaml: line 29: did not find expected <document start>
	[root@sparkonk8s-46929-p4jdl spark]# ./bin/docker-image-tool.sh
	Usage: ./bin/docker-image-tool.sh [options] [command]
	Builds or pushes the built-in Spark Docker image.
	
	Commands:
	  build       Build image. Requires a repository address to be provided if the image will be
	              pushed to a different registry.
	  push        Push a pre-built image to a registry. Requires a repository address to be provided.
	
	Options:
	  -r repo     Repository address.
	  -t tag      Tag to apply to the built image, or to identify the image to be pushed.
	  -m          Use minikube's Docker daemon.
	
	Using minikube when building images will do so directly into minikube's Docker daemon.
	There is no need to push the images into minikube in that case, they'll be automatically
	available when running applications inside the minikube cluster.
	
	Check the following documentation for more information on using the minikube Docker daemon:
	
	  https://kubernetes.io/docs/getting-started-guides/minikube/#reusing-the-docker-daemon
	
	Examples:
	  - Build image in minikube with tag "testing"
	    ./bin/docker-image-tool.sh -m -t testing build
	
	  - Build and push image with tag "v2.3.0" to docker.io/myrepo
	    ./bin/docker-image-tool.sh -r docker.io/myrepo -t v2.3.0 build
	    ./bin/docker-image-tool.sh -r docker.io/myrepo -t v2.3.0 push
	[root@sparkonk8s-46929-p4jdl spark]# ./bin/docker-image-tool.sh -m -t testing build
	./bin/docker-image-tool.sh: line 125: none: command not found
	Sending build context to Docker daemon 1.229 GB
	Step 1 : FROM openjdk:8-alpine
	8-alpine: Pulling from library/openjdk
	ff3a5c916c92: Pull complete
	5de5f69f42d7: Pull complete
	fd869c8b9b59: Pull complete
	Digest: sha256:4cd17a64b67df1a929a9c6dedf513afcdc48f3ca0b7fddee6489d0246a14390b
	Status: Downloaded newer image for openjdk:8-alpine
	 ---> 224765a6bdbe
	Step 2 : ARG spark_jars=jars
	 ---> Running in f0f267747802
	 ---> ffc13fa3b9ab
	Removing intermediate container f0f267747802
	Step 3 : ARG img_path=kubernetes/dockerfiles
	 ---> Running in 389a404b6599
	 ---> 3271720ac950
	Removing intermediate container 389a404b6599
	Step 4 : RUN set -ex &&     apk upgrade --no-cache &&     apk add --no-cache bash tini libc6-compat &&     mkdir -p /opt/spark &&     mkdir -p /opt/spark/work-dir     touch /opt/spark/RELEASE &&     rm /bin/sh &&     ln -sv /bin/bash /bin/sh &&     chgrp root /etc/passwd && chmod ug+rw /etc/passwd
	 ---> Running in c8ae352f7400
	+ apk upgrade --no-cache
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/main/x86_64/APKINDEX.tar.gz
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/community/x86_64/APKINDEX.tar.gz
	Upgrading critical system libraries and apk-tools:
	(1/1) Upgrading apk-tools (2.8.2-r0 -> 2.9.1-r0)
	Executing busybox-1.27.2-r7.trigger
	Continuing the upgrade transaction with new apk-tools:
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/main/x86_64/APKINDEX.tar.gz
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/community/x86_64/APKINDEX.tar.gz
	(1/4) Upgrading musl (1.1.18-r2 -> 1.1.18-r3)
	(2/4) Upgrading busybox (1.27.2-r7 -> 1.27.2-r8)
	Executing busybox-1.27.2-r8.post-upgrade
	(3/4) Upgrading musl-utils (1.1.18-r2 -> 1.1.18-r3)
	(4/4) Upgrading libtasn1 (4.12-r2 -> 4.12-r3)
	+ apk add --no-cache bash tini libc6-compat
	Executing busybox-1.27.2-r8.trigger
	OK: 100 MiB in 51 packages
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/main/x86_64/APKINDEX.tar.gz
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/community/x86_64/APKINDEX.tar.gz
	(1/8) Installing pkgconf (1.3.10-r0)
	(2/8) Installing ncurses-terminfo-base (6.0_p20171125-r0)
	(3/8) Installing ncurses-terminfo (6.0_p20171125-r0)
	(4/8) Installing ncurses-libs (6.0_p20171125-r0)
	(5/8) Installing readline (7.0.003-r0)
	(6/8) Installing bash (4.4.19-r1)
	Executing bash-4.4.19-r1.post-install
	(7/8) Installing libc6-compat (1.1.18-r3)
	(8/8) Installing tini (0.16.1-r0)
	Executing busybox-1.27.2-r8.trigger
	OK: 109 MiB in 59 packages
	'/bin/sh' -> '/bin/bash'
	+ mkdir -p /opt/spark
	+ mkdir -p /opt/spark/work-dir touch /opt/spark/RELEASE
	+ rm /bin/sh
	+ ln -sv /bin/bash /bin/sh
	+ chgrp root /etc/passwd
	+ chmod ug+rw /etc/passwd
	 ---> 736b51f84afe
	Removing intermediate container c8ae352f7400
	Step 5 : COPY ${spark_jars} /opt/spark/jars
	 ---> c20efacf1ee6
	Removing intermediate container b27326b567ce
	Step 6 : COPY bin /opt/spark/bin
	 ---> ef534a4ec9e6
	Removing intermediate container 07dc7f400c71
	Step 7 : COPY sbin /opt/spark/sbin
	 ---> 7d366ea80470
	Removing intermediate container ef313882f7e2
	Step 8 : COPY conf /opt/spark/conf
	 ---> cf06b8a4c047
	Removing intermediate container 7edfea905959
	Step 9 : COPY ${img_path}/spark/entrypoint.sh /opt/
	 ---> d9e652659c38
	Removing intermediate container e88a98f88d1e
	Step 10 : COPY examples /opt/spark/examples
	 ---> 08f008fdb7c4
	Removing intermediate container 0e3a569740dc
	Step 11 : COPY data /opt/spark/data
	 ---> c1f19d7a2cfd
	Removing intermediate container b36926b34826
	Step 12 : ENV SPARK_HOME /opt/spark
	 ---> Running in b0d95a0332b4
	 ---> 49554403e776
	Removing intermediate container b0d95a0332b4
	Step 13 : WORKDIR /opt/spark/work-dir
	 ---> Running in 4a578cefc4d9
	 ---> fc13968319ba
	Removing intermediate container 4a578cefc4d9
	Step 14 : ENTRYPOINT /opt/entrypoint.sh
	 ---> Running in 026f24093956
	 ---> acb30836cae3
	Removing intermediate container 026f24093956
	Successfully built acb30836cae3
	You have new mail in /var/spool/mail/root
	[root@sparkonk8s-46929-p4jdl spark]#
	───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	
	Session stopped
	    - Press <return> to exit tab
	    - Press R to restart session
	    - Press S to save terminal output to file
	
	Server unexpectedly closed network connection
