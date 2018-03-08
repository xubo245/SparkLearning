	[root@sparkonk8s-46929-p4jdl spark]#  docker build -t sparkk8s:v2.3.0.1 .
	Sending build context to Docker daemon 1.255 GB
	Step 1 : FROM openjdk:8-alpine
	 ---> 224765a6bdbe
	Step 2 : ARG spark_jars=assembly/target/scala-2.11/jars/
	 ---> Using cache
	 ---> a4f614e6587e
	Step 3 : ARG img_path=resource-managers/kubernetes/docker/src/main/dockerfiles
	 ---> Using cache
	 ---> b7e0a60b4491
	Step 4 : RUN set -ex &&     apk upgrade --no-cache &&     apk add --no-cache bash tini libc6-compat &&     mkdir -p /opt/spark &&     mkdir -p /opt/spark/work-dir     touch /opt/spark/RELEASE &&     rm /bin/sh &&     ln -sv /bin/bash /bin/sh &&     chgrp root /etc/passwd && chmod ug+rw /etc/passwd
	 ---> Running in 8ceccca2570e
	+ apk upgrade --no-cache
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/main/x86_64/APKINDEX.tar.gz
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/community/x86_64/APKINDEX.tar.gz
	Upgrading critical system libraries and apk-tools:
	(1/1) Upgrading apk-tools (2.8.2-r0 -> 2.9.1-r0)
	Executing busybox-1.27.2-r7.trigger
	Continuing the upgrade transaction with new apk-tools:
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/main/x86_64/APKINDEX.tar.gz
	WARNING: Ignoring http://dl-cdn.alpinelinux.org/alpine/v3.7/main/x86_64/APKINDEX.tar.gz: temporary error (try again later)
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/community/x86_64/APKINDEX.tar.gz
	WARNING: Ignoring http://dl-cdn.alpinelinux.org/alpine/v3.7/community/x86_64/APKINDEX.tar.gz: temporary error (try again later)
	OK: 100 MiB in 51 packages
	+ apk add --no-cache bash tini libc6-compat
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/main/x86_64/APKINDEX.tar.gz
	fetch http://dl-cdn.alpinelinux.org/alpine/v3.7/community/x86_64/APKINDEX.tar.gz
	(1/10) Upgrading musl (1.1.18-r2 -> 1.1.18-r3)
	(2/10) Installing pkgconf (1.3.10-r0)
	(3/10) Installing ncurses-terminfo-base (6.0_p20171125-r0)
	(4/10) Installing ncurses-terminfo (6.0_p20171125-r0)
	(5/10) Installing ncurses-libs (6.0_p20171125-r0)
	(6/10) Installing readline (7.0.003-r0)
	(7/10) Installing bash (4.4.19-r1)
	Executing bash-4.4.19-r1.post-install
	(8/10) Upgrading musl-utils (1.1.18-r2 -> 1.1.18-r3)
	(9/10) Installing libc6-compat (1.1.18-r3)
	(10/10) Installing tini (0.16.1-r0)
	Executing busybox-1.27.2-r7.trigger
	OK: 109 MiB in 59 packages
	+ mkdir -p /opt/spark
	+ mkdir -p /opt/spark/work-dir touch /opt/spark/RELEASE
	+ rm /bin/sh
	+ ln -sv /bin/bash /bin/sh
	'/bin/sh' -> '/bin/bash'
	+ chgrp root /etc/passwd
	+ chmod ug+rw /etc/passwd
	 ---> 7ca38b64144d
	Removing intermediate container 8ceccca2570e
	Step 5 : COPY ${spark_jars} /opt/spark/jars
	 ---> 16e905d2f7ef
	Removing intermediate container e55c6bb7a4fd
	Step 6 : COPY bin /opt/spark/bin
	 ---> b6ef141e97bd
	Removing intermediate container 19110ca87800
	Step 7 : COPY sbin /opt/spark/sbin
	 ---> b46c99f5d48e
	Removing intermediate container 727ada236744
	Step 8 : COPY conf /opt/spark/conf
	 ---> 58998a29eba4
	Removing intermediate container 329aab723c76
	Step 9 : COPY ${img_path}/spark/entrypoint.sh /opt/
	 ---> 900606bf1b09
	Removing intermediate container 8836061348c8
	Step 10 : COPY examples /opt/spark/examples
	 ---> af6af90df99d
	Removing intermediate container fd724159c59b
	Step 11 : COPY data /opt/spark/data
	 ---> d8f5c905675d
	Removing intermediate container e1bb722f2fca
	Step 12 : ENV SPARK_HOME /opt/spark
	 ---> Running in 7aae2c4e7e17
	 ---> 2f2beb816085
	Removing intermediate container 7aae2c4e7e17
	Step 13 : WORKDIR /opt/spark/work-dir
	 ---> Running in 8f2264252442
	 ---> ff662ba37626
	Removing intermediate container 8f2264252442
	Step 14 : ENTRYPOINT /opt/entrypoint.sh
	 ---> Running in 11dce48e7e07
	 ---> 3d3a6ae9f909
	Removing intermediate container 11dce48e7e07
	Successfully built 3d3a6ae9f909
	[root@sparkonk8s-46929-p4jdl spark]# docker images
	REPOSITORY                                     TAG                        IMAGE ID            CREATED             SIZE
	sparkk8s                                       v2.3.0.1                   3d3a6ae9f909        22 seconds ago      298.1 MB
	<none>                                         <none>                     98f1ce58c776        8 minutes ago       280.8 MB
	<none>                                         <none>                     91078140fd97        19 minutes ago      106.4 MB
	spark/spark                                    latest                     faeefe3e250c        About an hour ago   299.1 MB
	spark/spark                                    v2.3.0                     faeefe3e250c        About an hour ago   299.1 MB
	spark                                          testing2                   faeefe3e250c        About an hour ago   299.1 MB
	spark                                          testing                    acb30836cae3        3 hours ago         299.1 MB
	100.125.0.198:20202/kernel/nginxcarbondata     v3                         0fd47d3fd7d6        46 hours ago        57.67 MB
	nginxcarbondata                                v3                         0fd47d3fd7d6        46 hours ago        57.67 MB
	mesosphere/spark                               2.3.0-2.2.1-2-hadoop-2.7   db35b62b7478        4 days ago          1.432 GB
	nginx                                          v3                         b35b10efe9a0        5 days ago          57.67 MB
	100.125.0.198:20202/kernel/hello_world         1.01                       7c82a39b8332        5 days ago          12.22 MB
	hello_world                                    1.01                       7c82a39b8332        5 days ago          12.22 MB
	100.125.0.198:20202/kernel/spark               2.2.1-hadoop-2.7           bc7de2df0189        7 weeks ago         745.6 MB
	gettyimages/spark                              2.2.1-hadoop-2.7           bc7de2df0189        7 weeks ago         745.6 MB
	gettyimages/spark                              latest                     2b6eb58ac7d5        7 weeks ago         745.6 MB
	openjdk                                        8-alpine                   224765a6bdbe        8 weeks ago         101.5 MB
	nginx                                          1.12-alpine-perl           b6a456f1d7ae        8 weeks ago         57.67 MB
	nginx                                          alpine                     bb00c21b4edf        8 weeks ago         16.81 MB
	canal-agent                                    2.5.T3.B030                cd5a17dea20b        3 months ago        461.7 MB
	canal-agent                                    latest                     cd5a17dea20b        3 months ago        461.7 MB
	mesosphere/spark                               latest                     5c25c7985707        3 months ago        1.416 GB
	cfe-exechealthz-amd64                          3.5.2                      c348b35a448d        3 months ago        326.7 MB
	cfe-kubedns-amd64                              3.5.2                      97a2192d4432        3 months ago        334.9 MB
	cfe-kube-dnsmasq-amd64                         3.5.2                      700d6dbd1c3b        3 months ago        325.6 MB
	euleros                                        2.2.5                      b0f6bcd0a2a0        4 months ago        288.6 MB
	bash                                           latest                     36a0607f828e        4 months ago        12.22 MB
	kubespark/spark-init                           v2.2.0-kubernetes-0.5.0    c266f745ee85        4 months ago        327.5 MB
	kubespark/spark-executor                       v2.2.0-kubernetes-0.5.0    05ba60e298d2        4 months ago        330.9 MB
	kubespark/spark-driver                         v2.2.0-kubernetes-0.5.0    38c277999de5        4 months ago        330.9 MB
	registry.cn-hangzhou.aliyuncs.com/acs/ubuntu   latest                     96046107cbb9        16 months ago       127.1 MB
	sequenceiq/spark                               v1.6.0onHadoop2.6.0        22e0c645293f        2 years ago         2.876 GB
	cfe-pause                                      3.5.2                      2b58359142b0        2 years ago         350.2 kB
	[root@sparkonk8s-46929-p4jdl spark]#



Docker file:

[root@sparkonk8s-46929-p4jdl spark]# vi Dockerfile


	# Licensed to the Apache Software Foundation (ASF) under one or more
	# contributor license agreements.  See the NOTICE file distributed with
	# this work for additional information regarding copyright ownership.
	# The ASF licenses this file to You under the Apache License, Version 2.0
	# (the "License"); you may not use this file except in compliance with
	# the License.  You may obtain a copy of the License at
	#
	#    http://www.apache.org/licenses/LICENSE-2.0
	#
	# Unless required by applicable law or agreed to in writing, software
	# distributed under the License is distributed on an "AS IS" BASIS,
	# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	# See the License for the specific language governing permissions and
	# limitations under the License.
	#
	
	FROM openjdk:8-alpine
	
	#ARG spark_jars=jars
	ARG spark_jars=assembly/target/scala-2.11/jars/
	#ARG img_path=kubernetes/dockerfiles
	ARG img_path=resource-managers/kubernetes/docker/src/main/dockerfiles
	
	# Before building the docker image, first build and make a Spark distribution following
	# the instructions in http://spark.apache.org/docs/latest/building-spark.html.
	# If this docker file is being used in the context of building your images from a Spark
	# distribution, the docker build command should be invoked from the top level directory
	# of the Spark distribution. E.g.:
	# docker build -t spark:latest -f kubernetes/dockerfiles/spark/Dockerfile .
	
	RUN set -ex && \
	    apk upgrade --no-cache && \
	    apk add --no-cache bash tini libc6-compat && \
	    mkdir -p /opt/spark && \
	    mkdir -p /opt/spark/work-dir \
	    touch /opt/spark/RELEASE && \
	    rm /bin/sh && \
	    ln -sv /bin/bash /bin/sh && \
	    chgrp root /etc/passwd && chmod ug+rw /etc/passwd
	
	COPY ${spark_jars} /opt/spark/jars
	COPY bin /opt/spark/bin
	COPY sbin /opt/spark/sbin
	COPY conf /opt/spark/conf
	COPY ${img_path}/spark/entrypoint.sh /opt/
	COPY examples /opt/spark/examples
	COPY data /opt/spark/data
	
	ENV SPARK_HOME /opt/spark
	
	WORKDIR /opt/spark/work-dir
	
	ENTRYPOINT [ "/opt/entrypoint.sh" ]
