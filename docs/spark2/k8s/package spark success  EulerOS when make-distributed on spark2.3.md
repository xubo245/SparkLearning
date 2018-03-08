	
	[root@sparkonk8s-46929-p4jdl spark2]# ./bin/docker-image-tool.sh -m -t spark2v1 build
	./bin/docker-image-tool.sh: line 125: none: command not found
	Sending build context to Docker daemon 1.448 GB
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
	 ---> 40b31f776dea
	Step 5 : COPY ${spark_jars} /opt/spark/jars
	 ---> 8374a5302467
	Removing intermediate container 2d671f27e4cb
	Step 6 : COPY bin /opt/spark/bin
	 ---> a6d514f5739b
	Removing intermediate container 6300c7b19968
	Step 7 : COPY sbin /opt/spark/sbin
	 ---> be637c406e9d
	Removing intermediate container fc17cacb29eb
	Step 8 : COPY conf /opt/spark/conf
	 ---> 9e44a214405e
	Removing intermediate container d90b62fec23e
	Step 9 : COPY ${img_path}/spark/entrypoint.sh /opt/
	 ---> 346ac402c634
	Removing intermediate container 2152d397700a
	Step 10 : COPY examples /opt/spark/examples
	 ---> 1fda85336874
	Removing intermediate container 428ca41853c8
	Step 11 : COPY data /opt/spark/data
	 ---> 911cc9b443e2
	Removing intermediate container b849d44b513d
	Step 12 : ENV SPARK_HOME /opt/spark
	 ---> Running in c7ba35009bbf
	 ---> 442aad96e1dc
	Removing intermediate container c7ba35009bbf
	Step 13 : WORKDIR /opt/spark/work-dir
	 ---> Running in 1edb18022882
	 ---> a087b5200dd9
	Removing intermediate container 1edb18022882
	Step 14 : ENTRYPOINT /opt/entrypoint.sh
	 ---> Running in 0afc3986878b
	 ---> c462fc18ef30
	Removing intermediate container 0afc3986878b
	Successfully built c462fc18ef30
	[root@sparkonk8s-46929-p4jdl spark2]# docker images
	REPOSITORY                                     TAG                        IMAGE ID            CREATED              SIZE
	spark                                          spark2v1                   c462fc18ef30        About a minute ago   307.1 MB
	<none>                                         <none>                     6fde6a970b42        2 hours ago          351.1 MB
	sparkk8s                                       v2.3.0.2                   e10ede257df3        3 hours ago          298.1 MB
	sparkk8s                                       v2.3.0.1                   3d3a6ae9f909        3 hours ago          298.1 MB
	<none>                                         <none>                     98f1ce58c776        4 hours ago          280.8 MB
	<none>                                         <none>                     91078140fd97        4 hours ago          106.4 MB
	spark/spark                                    latest                     faeefe3e250c        5 hours ago          299.1 MB
	spark/spark                                    v2.3.0                     faeefe3e250c        5 hours ago          299.1 MB
	spark                                          testing2                   faeefe3e250c        5 hours ago          299.1 MB
	spark                                          testing                    acb30836cae3        7 hours ago          299.1 MB
	100.125.0.198:20202/kernel/nginxcarbondata     v3                         0fd47d3fd7d6        2 days ago           57.67 MB
	nginxcarbondata                                v3                         0fd47d3fd7d6        2 days ago           57.67 MB
	mesosphere/spark                               2.3.0-2.2.1-2-hadoop-2.7   db35b62b7478        4 days ago           1.432 GB
	nginx                                          v3                         b35b10efe9a0        5 days ago           57.67 MB
	100.125.0.198:20202/kernel/hello_world         1.01                       7c82a39b8332        5 days ago           12.22 MB
	hello_world                                    1.01                       7c82a39b8332        5 days ago           12.22 MB
	debian                                         jessie                     ce40fb3adcc6        2 weeks ago          123.4 MB
	100.125.0.198:20202/kernel/spark               2.2.1-hadoop-2.7           bc7de2df0189        7 weeks ago          745.6 MB
	gettyimages/spark                              2.2.1-hadoop-2.7           bc7de2df0189        7 weeks ago          745.6 MB
	gettyimages/spark                              latest                     2b6eb58ac7d5        7 weeks ago          745.6 MB
	openjdk                                        8-alpine                   224765a6bdbe        8 weeks ago          101.5 MB
	nginx                                          1.12-alpine-perl           b6a456f1d7ae        8 weeks ago          57.67 MB
	nginx                                          alpine                     bb00c21b4edf        8 weeks ago          16.81 MB
	canal-agent                                    2.5.T3.B030                cd5a17dea20b        3 months ago         461.7 MB
	canal-agent                                    latest                     cd5a17dea20b        3 months ago         461.7 MB
	mesosphere/spark                               latest                     5c25c7985707        3 months ago         1.416 GB
	cfe-exechealthz-amd64                          3.5.2                      c348b35a448d        3 months ago         326.7 MB
	cfe-kubedns-amd64                              3.5.2                      97a2192d4432        3 months ago         334.9 MB
	cfe-kube-dnsmasq-amd64                         3.5.2                      700d6dbd1c3b        3 months ago         325.6 MB
	euleros                                        2.2.5                      b0f6bcd0a2a0        4 months ago         288.6 MB
	bash                                           latest                     36a0607f828e        4 months ago         12.22 MB
	kubespark/spark-init                           v2.2.0-kubernetes-0.5.0    c266f745ee85        4 months ago         327.5 MB
	kubespark/spark-executor                       v2.2.0-kubernetes-0.5.0    05ba60e298d2        4 months ago         330.9 MB
	kubespark/spark-driver                         v2.2.0-kubernetes-0.5.0    38c277999de5        4 months ago         330.9 MB
	registry.cn-hangzhou.aliyuncs.com/acs/ubuntu   latest                     96046107cbb9        16 months ago        127.1 MB
	sequenceiq/spark                               v1.6.0onHadoop2.6.0        22e0c645293f        2 years ago          2.876 GB
	cfe-pause                                      3.5.2                      2b58359142b0        2 years ago          350.2 kB
