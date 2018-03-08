	[root@sparkonk8s-46929-p4jdl spark]# kubectl config get-contexts
	CURRENT   NAME       CLUSTER           AUTHINFO   NAMESPACE
	          internal   internalCluster   user
	*         minikube   minikube          minikube
	          spark      internalCluster   user       spark-cluster
	[root@sparkonk8s-46929-p4jdl spark]# kubectl config use-context internal
	Switched to context "internal".
	[root@sparkonk8s-46929-p4jdl spark]# kubectl get all
	NAME                   DESIRED   CURRENT   UP-TO-DATE   AVAILABLE   AGE
	deploy/helloworld      2         0         0            0           4d
	deploy/nginx           2         0         0            0           4d
	deploy/nginxcarbonda   3         3         3            3           23h
	deploy/nginxeuler      2         2         2            2           4d
	deploy/nginxv3         1         1         1            0           6h
	deploy/nginxv4         1         1         1            1           5h
	deploy/nginxv5         1         1         1            0           5h
	deploy/nginxv6         1         1         1            1           5h
	deploy/sparkgetting    3         3         3            3           1d
	
	NAME                          DESIRED   CURRENT   READY     AGE
	rs/helloworld-4244629238      0         0         0         4d
	rs/nginx-1945946105           0         0         0         4d
	rs/nginxcarbonda-1937514235   3         3         3         23h
	rs/nginxeuler-3188622173      2         2         2         4d
	rs/nginxv3-2622272071         1         1         0         6h
	rs/nginxv4-4176425979         1         1         1         5h
	rs/nginxv5-592882569          1         1         0         5h
	rs/nginxv6-30840885           1         1         1         5h
	rs/sparkgetting-2685462660    3         3         3         1d
	
	NAME                   DESIRED   CURRENT   UP-TO-DATE   AVAILABLE   AGE
	deploy/helloworld      2         0         0            0           4d
	deploy/nginx           2         0         0            0           4d
	deploy/nginxcarbonda   3         3         3            3           23h
	deploy/nginxeuler      2         2         2            2           4d
	deploy/nginxv3         1         1         1            0           6h
	deploy/nginxv4         1         1         1            1           5h
	deploy/nginxv5         1         1         1            0           5h
	deploy/nginxv6         1         1         1            1           5h
	deploy/sparkgetting    3         3         3            3           1d
	
	NAME                            DESIRED   CURRENT   AGE
	statefulsets/sparkgettyimages   5         5         20h
	
	NAME                                READY     STATUS             RESTARTS   AGE
	po/icagent-2fhzc                    0/0       Running            0          1d
	po/icagent-d84d7                    0/0       Running            0          1d
	po/icagent-dnfmw                    0/0       Running            0          1d
	po/icagent-f765n                    0/0       Running            0          1d
	po/icagent-wl12q                    0/0       Running            0          1d
	po/nginxcarbonda-1937514235-3mlw9   1/1       Running            0          23h
	po/nginxcarbonda-1937514235-f8p3p   1/1       Running            0          23h
	po/nginxcarbonda-1937514235-rd3jz   1/1       Running            0          23h
	po/nginxeuler-3188622173-5g52q      1/1       Running            0          4d
	po/nginxeuler-3188622173-dxcqs      1/1       Running            0          4d
	po/nginxv3-2622272071-l07wt         0/1       ErrImagePull       0          5h
	po/nginxv4-4176425979-qqncd         1/1       Running            0          5h
	po/nginxv5-592882569-gtdx4          0/1       ImagePullBackOff   0          5h
	po/nginxv6-30840885-rm7dk           1/1       Running            0          5h
	po/sparkgetting-2685462660-44q66    1/1       Running            0          1d
	po/sparkgetting-2685462660-5q50t    1/1       Running            0          1d
	po/sparkgetting-2685462660-p4xk2    1/1       Running            0          1d
	po/sparkgettyimages-0               1/1       Running            0          20h
	po/sparkgettyimages-1               1/1       Running            0          4h
	po/sparkgettyimages-2               1/1       Running            0          20h
	po/sparkgettyimages-3               1/1       Running            0          20h
	po/sparkgettyimages-4               1/1       Running            0          20h
