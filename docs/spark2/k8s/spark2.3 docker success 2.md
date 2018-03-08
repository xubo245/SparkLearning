	[root@sparkonk8s-46929-p4jdl spark]# ./bin/docker-image-tool.sh -r spark -t v2.3.0 build
	Sending build context to Docker daemon 1.255 GB
	Step 1 : FROM openjdk:8-alpine
	 ---> 224765a6bdbe
	Step 2 : ARG spark_jars=jars
	 ---> Using cache
	 ---> ffc13fa3b9ab
	Step 3 : ARG img_path=kubernetes/dockerfiles
	 ---> Using cache
	 ---> 3271720ac950
	Step 4 : RUN set -ex &&     apk upgrade --no-cache &&     apk add --no-cache bash tini libc6-compat &&     mkdir -p /opt/spark &&     mkdir -p /opt/spark/work-dir     touch /opt/spark/RELEASE &&     rm /bin/sh &&     ln -sv /bin/bash /bin/sh &&     chgrp root /etc/passwd && chmod ug+rw /etc/passwd
	 ---> Using cache
	 ---> 736b51f84afe
	Step 5 : COPY ${spark_jars} /opt/spark/jars
	 ---> Using cache
	 ---> 84acdb0d4595
	Step 6 : COPY bin /opt/spark/bin
	 ---> Using cache
	 ---> 764afbfc252f
	Step 7 : COPY sbin /opt/spark/sbin
	 ---> Using cache
	 ---> 345402dd9380
	Step 8 : COPY conf /opt/spark/conf
	 ---> Using cache
	 ---> 488c37888812
	Step 9 : COPY ${img_path}/spark/entrypoint.sh /opt/
	 ---> Using cache
	 ---> d4c1b47786d1
	Step 10 : COPY examples /opt/spark/examples
	 ---> Using cache
	 ---> 9723af90ddee
	Step 11 : COPY data /opt/spark/data
	 ---> Using cache
	 ---> 2262666b3505
	Step 12 : ENV SPARK_HOME /opt/spark
	 ---> Using cache
	 ---> 0de45565ea27
	Step 13 : WORKDIR /opt/spark/work-dir
	 ---> Using cache
	 ---> 7e6fbeb3df99
	Step 14 : ENTRYPOINT /opt/entrypoint.sh
	 ---> Using cache
	 ---> faeefe3e250c
	Successfully built faeefe3e250c
	[root@sparkonk8s-46929-p4jdl spark]# docker images
	REPOSITORY                                     TAG                        IMAGE ID            CREATED             SIZE
	spark/spark                                    v2.3.0                     faeefe3e250c        6 minutes ago       299.1 MB
	spark                                          testing2                   faeefe3e250c        6 minutes ago       299.1 MB
	spark                                          testing                    acb30836cae3        2 hours ago         299.1 MB
	100.125.0.198:20202/kernel/nginxcarbondata     v3                         0fd47d3fd7d6        45 hours ago        57.67 MB
	nginxcarbondata                                v3                         0fd47d3fd7d6        45 hours ago        57.67 MB
	mesosphere/spark                               2.3.0-2.2.1-2-hadoop-2.7   db35b62b7478        4 days ago          1.432 GB
	nginx                                          v3                         b35b10efe9a0        4 days ago          57.67 MB
	100.125.0.198:20202/kernel/hello_world         1.01                       7c82a39b8332        4 days ago          12.22 MB
	hello_world                                    1.01                       7c82a39b8332        4 days ago          12.22 MB
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
