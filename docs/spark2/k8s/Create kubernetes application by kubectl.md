		
##create config file

	[root@sparkonk8s-46929-p4jdl k8s]# vi nginx.yaml
		
###file:		
		apiVersion: extensions/v1beta1
		kind: Deployment
		metadata:
		  name: nginxv3
		spec:
		  replicas: 1
		  selector:
		    matchLabels:
		      app: nginxv3
		  strategy:
		    type: RollingUpdate
		  template:
		    metadata:
		      labels:
		        app: nginxv3
		    spec:
		      containers:
		      - image:  kernel/nginxcarbondata:v3
		        imagePullPolicy: Always
		        name: nginxv3
		      imagePullSecrets:
		      - name: default-secret
##create application
		
		kubectl create -f nginx.yaml
		
		
		[root@sparkonk8s-46929-p4jdl k8s]# kubectl get pods
		NAME                             READY     STATUS              RESTARTS   AGE
		icagent-2fhzc                    0/0       Running             0          1d
		icagent-d84d7                    0/0       Running             0          1d
		icagent-dnfmw                    0/0       Running             0          1d
		icagent-f765n                    0/0       Running             0          1d
		icagent-wl12q                    0/0       Running             0          1d
		nginxcarbonda-1937514235-3mlw9   1/1       Running             0          16h
		nginxcarbonda-1937514235-f8p3p   1/1       Running             0          16h
		nginxcarbonda-1937514235-rd3jz   1/1       Running             0          16h
		nginxeuler-3188622173-5g52q      1/1       Running             0          3d
		nginxeuler-3188622173-dxcqs      1/1       Running             0          3d
		nginxv3-2622272071-z4k88         0/1       ContainerCreating   0          9s
		sparkgetting-2685462660-44q66    1/1       Running             0          18h
		sparkgetting-2685462660-5q50t    1/1       Running             0          18h
		sparkgetting-2685462660-p4xk2    1/1       Running             0          18h
		sparkgettyimages-0               1/1       Running             0          13h
		sparkgettyimages-1               1/1       Running             0          13h
		sparkgettyimages-2               1/1       Running             0          13h
		sparkgettyimages-3               1/1       Running             0          13h
		sparkgettyimages-4               1/1       Running             0          13h
		[root@sparkonk8s-46929-p4jdl k8s]# kubectl run nginxv3
		error: --image is required
		[root@sparkonk8s-46929-p4jdl k8s]# kubectl expose deployment nginxv3 --type=NodePort
		error: couldn't find port via --port flag or introspection
		See 'kubectl expose -h' for help and examples.
		[root@sparkonk8s-46929-p4jdl k8s]# kubectl get pods
		NAME                             READY     STATUS             RESTARTS   AGE
		icagent-2fhzc                    0/0       Running            0          1d
		icagent-d84d7                    0/0       Running            0          1d
		icagent-dnfmw                    0/0       Running            0          1d
		icagent-f765n                    0/0       Running            0          1d
		icagent-wl12q                    0/0       Running            0          1d
		nginxcarbonda-1937514235-3mlw9   1/1       Running            0          17h
		nginxcarbonda-1937514235-f8p3p   1/1       Running            0          17h
		nginxcarbonda-1937514235-rd3jz   1/1       Running            0          17h
		nginxeuler-3188622173-5g52q      1/1       Running            0          3d
		nginxeuler-3188622173-dxcqs      1/1       Running            0          3d
		nginxv3-2622272071-z4k88         0/1       ImagePullBackOff   0          10m
		sparkgetting-2685462660-44q66    1/1       Running            0          18h
		sparkgetting-2685462660-5q50t    1/1       Running            0          18h
		sparkgetting-2685462660-p4xk2    1/1       Running            0          18h
		sparkgettyimages-0               1/1       Running            0          14h
		sparkgettyimages-1               1/1       Running            0          14h
		sparkgettyimages-2               1/1       Running            0          14h
		sparkgettyimages-3               1/1       Running            0          14h
		sparkgettyimages-4               1/1       Running            0          14h
		[root@sparkonk8s-46929-p4jdl k8s]#

##nginxv4

	[root@sparkonk8s-46929-p4jdl k8s]# vi nginxv4.yaml
	
		apiVersion: extensions/v1beta1
		kind: Deployment
		metadata:
		  name: nginxv4
		spec:
		  replicas: 1
		  selector:
		    matchLabels:
		      app: nginxv4
		  strategy:
		    type: RollingUpdate
		  template:
		    metadata:
		      labels:
		        app: nginxv4
		    spec:
		      containers:
		      - image:  nginx
		        imagePullPolicy: Always
		        name: nginxv4
		      imagePullSecrets:
		      - name: default-secret
		
	
	
	[root@sparkonk8s-46929-p4jdl k8s]# kubectl create -f nginxv4.yaml
	deployment "nginxv4" created
	[root@sparkonk8s-46929-p4jdl k8s]# ls
	kubeconfig  nginxv4.yaml  nginx.yaml
	[root@sparkonk8s-46929-p4jdl k8s]# kubectl get pods
	NAME                             READY     STATUS             RESTARTS   AGE
	icagent-2fhzc                    0/0       Running            0          1d
	icagent-d84d7                    0/0       Running            0          1d
	icagent-dnfmw                    0/0       Running            0          1d
	icagent-f765n                    0/0       Running            0          1d
	icagent-wl12q                    0/0       Running            0          1d
	nginxcarbonda-1937514235-3mlw9   1/1       Running            0          17h
	nginxcarbonda-1937514235-f8p3p   1/1       Running            0          17h
	nginxcarbonda-1937514235-rd3jz   1/1       Running            0          17h
	nginxeuler-3188622173-5g52q      1/1       Running            0          3d
	nginxeuler-3188622173-dxcqs      1/1       Running            0          3d
	nginxv3-2622272071-z4k88         0/1       ImagePullBackOff   0          15m
	nginxv4-4176425979-qqncd         1/1       Running            0          8s
	sparkgetting-2685462660-44q66    1/1       Running            0          18h
	sparkgetting-2685462660-5q50t    1/1       Running            0          18h
	sparkgetting-2685462660-p4xk2    1/1       Running            0          18h
	sparkgettyimages-0               1/1       Running            0          14h
	sparkgettyimages-1               1/1       Running            0          14h
	sparkgettyimages-2               1/1       Running            0          14h
	sparkgettyimages-3               1/1       Running            0          14h
	sparkgettyimages-4               1/1       Running            0         


And then bind the outside ip port, so last we can access the new website 