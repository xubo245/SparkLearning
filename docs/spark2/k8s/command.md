	./dev/make-distribution.sh --name custom-spark --pip --r --tgz -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes
	
	
	 mvn -DskipTests clean package


	[root@sparkonk8s-46929-p4jdl spark]# rpm -e --nodeps java-1.7.0-openjdk-headless-1.7.0.161-2.6.12.0.x86_64
	[root@sparkonk8s-46929-p4jdl spark]# rpm -e --nodeps java-1.8.0-openjdk-headless-1.8.0.161-0.b14.x86_64
	[root@sparkonk8s-46929-p4jdl spark]# rpm -e --nodeps jdk1.8.0_131-1.8.0_131-fcs.x86_64
	[root@sparkonk8s-46929-p4jdl spark]# rpm -qa | grep jdk
	copy-jdk-configs-2.2-3.noarch
	[root@sparkonk8s-46929-p4jdl spark]# rpm -e --nodeps copy-jdk-configs-2.2-3.noarch


##内网 生成临时docker login指令

	docker login -u cn-north-1@dKSqRGedkhBmKC5TwHbz -p df8123a66be96528dde2fcf9b783de13f48a87b9cee8b325bfb63bfad301831f 100.125.0.198:20202


docker pull 100.125.0.198:20202/kernel/spark-driver:v2.2.0-kubernetes-0.5.0
docker pull 100.125.0.198:20202/kernel/spark-init:v2.2.0-kubernetes-0.5.0

##外网 生成临时docker login指令

	docker login -u cn-north-1@dKSqRGedkhBmKC5TwHbz -p df8123a66be96528dde2fcf9b783de13f48a87b9cee8b325bfb63bfad301831f registry.cn-north-1.huaweicloud.com


build/mvn install -Pkubernetes -pl resource-managers/kubernetes/core -am -DskipTests

build/mvn compile -Pkubernetes -pl resource-managers/kubernetes/core -am -DskipTests

dev/make-distribution.sh --tgz -Phadoop-2.7 -Pkubernetes



kubectl delete pod spark-pi-1520479618530-driver  
kubectl delete pod spark-pi-1520479689885-driver  
kubectl delete pod spark-pi-1520480691176-driver  
kubectl delete pod spark-pi-1520481627245-driver  
kubectl delete pod spark-pi-1520481887583-driver  
kubectl delete pod spark-pi-1520481937405-driver 
kubectl delete pod spark-pi-1520482595434-driver   
kubectl delete pod spark-pi-1520482601076-driver 
kubectl delete pod spark-pi-1520482604251-driver  
kubectl delete pod spark-pi-1520486246550-driver  
kubectl delete pod spark-pi-1520489582310-driver  
kubectl delete pod sparkgetty2-4050180351-7f7r7 




