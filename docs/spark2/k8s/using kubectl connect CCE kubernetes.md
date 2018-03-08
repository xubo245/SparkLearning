	
	[root@sparkonk8s-46929-p4jdl .kube]# cp ../k8s/kubeconfig config
	[root@sparkonk8s-46929-p4jdl .kube]# ls
	cache  config  config_native  http-cache
	[root@sparkonk8s-46929-p4jdl .kube]# vi config
	[root@sparkonk8s-46929-p4jdl .kube]#
	[root@sparkonk8s-46929-p4jdl .kube]#
	[root@sparkonk8s-46929-p4jdl .kube]# kubectl config use-context internal
	Switched to context "internal".
	
	
	
	[root@sparkonk8s-46929-p4jdl .kube]# kubectl cluster-info
	Kubernetes master is running at https://192.168.0.188:5443
	KubeDNS is running at https://192.168.0.188:5443/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy
	
	To further debug and diagnose cluster problems, use 'kubectl cluster-info dump'.
	[root@sparkonk8s-46929-p4jdl .kube]# kubectl get pods
	NAME                             READY     STATUS    RESTARTS   AGE
	icagent-2fhzc                    0/0       Running   0          1d
	icagent-d84d7                    0/0       Running   0          1d
	icagent-dnfmw                    0/0       Running   0          1d
	icagent-f765n                    0/0       Running   0          1d
	icagent-wl12q                    0/0       Running   0          1d
	nginxcarbonda-1937514235-3mlw9   1/1       Running   0          16h
	nginxcarbonda-1937514235-f8p3p   1/1       Running   0          16h
	nginxcarbonda-1937514235-rd3jz   1/1       Running   0          16h
	nginxeuler-3188622173-5g52q      1/1       Running   0          3d
	nginxeuler-3188622173-dxcqs      1/1       Running   0          3d
	sparkgetting-2685462660-44q66    1/1       Running   0          18h
	sparkgetting-2685462660-5q50t    1/1       Running   0          18h
	sparkgetting-2685462660-p4xk2    1/1       Running   0          18h
	sparkgettyimages-0               1/1       Running   0          13h
	sparkgettyimages-1               1/1       Running   0          13h
	sparkgettyimages-2               1/1       Running   0          13h
	sparkgettyimages-3               1/1       Running   0          13h
	sparkgettyimages-4               1/1       Running   0          13h


reference：

	【1】https://console.huaweicloud.com/cce2.0/?region=cn-north-1#/app/resource/cluster/detail/accessAPI?clusterName=sparkonk8s&clusterId=50039cdd-1d45-11e8-ae53-0255ac101e1c