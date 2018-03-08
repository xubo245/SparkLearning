
使用docker构建nginx镜像
	
##EulerOS：

###1.Hello,CCE!

	[root@sparkonk8s-46929-p4jdl mynginx]#  docker build -t nginx:v3 .
	Sending build context to Docker daemon 2.048 kB
	Step 1 : FROM nginx:1.12-alpine-perl
	 ---> b6a456f1d7ae
	Step 2 : RUN echo '<h1>Hello,CCE!</h1>' > /usr/share/nginx/html/index.html
	 ---> Running in de44c9f5d5f8
	 ---> b35b10efe9a0
	Removing intermediate container de44c9f5d5f8
	Successfully built b35b10efe9a0.

查看：

	[root@sparkonk8s-46929-p4jdl mynginx]# docker images
	REPOSITORY                                     TAG                 IMAGE ID            CREATED             SIZE
	nginx                                          v3                  b35b10efe9a0        6 seconds ago       57.67 MB
	100.125.0.198:20202/kernel/hello_world         1.01                7c82a39b8332        19 minutes ago      12.22 MB
	hello_world                                    1.01                7c82a39b8332        19 minutes ago      12.22 MB
	nginx                                          1.12-alpine-perl    b6a456f1d7ae        7 weeks ago         57.67 MB
	nginx                                          alpine              bb00c21b4edf        7 weeks ago         16.81 MB
	canal-agent                                    2.5.T3.B030         cd5a17dea20b        3 months ago        461.7 MB
	canal-agent                                    latest              cd5a17dea20b        3 months ago        461.7 MB
	cfe-exechealthz-amd64                          3.5.2               c348b35a448d        3 months ago        326.7 MB
	cfe-kubedns-amd64                              3.5.2               97a2192d4432        3 months ago        334.9 MB
	cfe-kube-dnsmasq-amd64                         3.5.2               700d6dbd1c3b        3 months ago        325.6 MB
	euleros                                        2.2.5               b0f6bcd0a2a0        3 months ago        288.6 MB
	bash                                           latest              36a0607f828e        3 months ago        12.22 MB
	registry.cn-hangzhou.aliyuncs.com/acs/ubuntu   latest              96046107cbb9        15 months ago       127.1 MB
	cfe-pause                                      3.5.2               2b58359142b0        2 years ago         350.2 kB
	[root@sparkonk8s-46929-p4jdl mynginx]# cd /

制作镜像：

     docker save -o nginxv3EulerOS.tar.gz nginx:v3


上传华为云，并在kubernetes集群上创建应用，选择自己制作的nginx镜像，不久后就可以访问了：

![](https://i.imgur.com/AgRFnUo.png)

###2.Hello,CCE!Hello,CarbonData!


	[root@sparkonk8s-46929-p4jdl mynginx]# docker build -t nginxCarbondata:v3 .
	invalid value "nginxCarbondata:v3" for flag -t: Error parsing reference: "nginxCarbondata:v3" is not a valid repository/tag
	See 'docker build --help'.
	[root@sparkonk8s-46929-p4jdl mynginx]# docker build -t nginxcarbondata:v3 .
	Sending build context to Docker daemon 2.048 kB
	Step 1 : FROM nginx:1.12-alpine-perl
	 ---> b6a456f1d7ae
	Step 2 : RUN echo '<h1>Hello,CCE!Hello,CarbonData!</h1>' > /usr/share/nginx/html/index.html
	 ---> Running in d3a0522b4523
	 ---> 0fd47d3fd7d6
	Removing intermediate container d3a0522b4523
	Successfully built 0fd47d3fd7d6
	[root@sparkonk8s-46929-p4jdl mynginx]#
	[root@sparkonk8s-46929-p4jdl mynginx]#
	[root@sparkonk8s-46929-p4jdl mynginx]# cd -
	/root/images
	[root@sparkonk8s-46929-p4jdl images]# docker save -o nginxv3Carbondata.tar.gz nginxcarbondata:v3
	[root@sparkonk8s-46929-p4jdl images]# ll
	total 869524
	-rw------- 1 root root 757123584 Mar  5 07:24 gettyimages_spark_2.2.1-hadoop-2.7.tar.gz
	-rw------- 1 root root  14510592 Mar  2 07:26 helloworld.tar.gz
	-rw------- 1 root root  59375104 Mar  5 10:11 nginxv3Carbondata.tar.gz
	-rw------- 1 root root  59374592 Mar  2 07:46 nginxv3EulerOS.tar.gz

###result

![](https://i.imgur.com/JjtyKRm.png)
##
##Ubuntu14.04

	root@keep:~/mynginx# docker build -t nginx:v3 .
	Sending build context to Docker daemon 2.048 kB
	Sending build context to Docker daemon
	Step 0 : FROM registry.cn-hangzhou.aliyuncs.com/cytong/nginx
	 ---> f21169ef0ebe
	Step 1 : RUN echo '<h1>Hello,CCE!</h1>' > /usr/share/nginx/html/index.html
	 ---> Running in cacdfee1f8b4
	 ---> 962e167aa3e8
	Removing intermediate container cacdfee1f8b4
	Successfully built 962e167aa3e8




	root@keep:~/mynginx# docker save nginx:v3 > nginxv3.tar.gz
	root@keep:~/mynginx# ll
	total 49392
	drwxr-xr-x  2 root root     4096 Mar  2 11:44 ./
	drwx------ 14 root root     4096 Mar  2 11:40 ../
	-rw-r--r--  1 root root      118 Mar  2 11:40 Dockerfile
	-rw-r--r--  1 root root 50563072 Mar  2 11:44 nginxv3.tar.gz

制作镜像成功，但是导入huaweicloud失败，报错：镜像格式不对





		