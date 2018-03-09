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
	  Last login: Thu Mar  8 06:14:01 2018 from 119.145.15.121
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
	  [root@sparkonk8s-46929-p4jdl ~]# kubectl get pods
	  NAME            READY     STATUS     RESTARTS   AGE
	  icagent-2fhzc   0/0       Running    0          3d
	  icagent-d84d7   0/0       NodeLost   0          3d
	  icagent-dnfmw   0/0       Running    0          3d
	  icagent-f765n   0/0       Running    0          3d
	  icagent-wl12q   0/0       Running    0          3d
	  [root@sparkonk8s-46929-p4jdl ~]#
	  [root@sparkonk8s-46929-p4jdl ~]# kubectl get nodes
	  NAME            STATUS     ROLES     AGE       VERSION
	  192.168.0.120   Ready      <none>    6d        v1.7.3-CCE2.0.4-3.5.2
	  192.168.0.124   Ready      <none>    6d        v1.7.3-CCE2.0.4-3.5.2
	  192.168.0.174   Ready      <none>    6d        v1.7.3-CCE2.0.4-3.5.2
	  192.168.0.202   NotReady   <none>    6d        v1.7.3-CCE2.0.4-3.5.2
	  192.168.0.29    Ready      <none>    6d        v1.7.3-CCE2.0.4-3.5.2
	  [root@sparkonk8s-46929-p4jdl ~]# ifconfig
	  br_canal: flags=67<UP,BROADCAST,RUNNING>  mtu 1500
	          inet6 fe80::8c20:cdff:fe25:66da  prefixlen 64  scopeid 0x20<link>
	          ether 3e:39:77:ee:34:4a  txqueuelen 0  (Ethernet)
	          RX packets 24  bytes 1496 (1.4 KiB)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 8  bytes 648 (648.0 B)
	          TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
	
	  br_monitor: flags=67<UP,BROADCAST,RUNNING>  mtu 1500
	          inet6 fe80::c492:95ff:fee9:bf4b  prefixlen 64  scopeid 0x20<link>
	          ether 9a:1a:4b:ba:59:48  txqueuelen 0  (Ethernet)
	          RX packets 0  bytes 0 (0.0 B)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 8  bytes 648 (648.0 B)
	          TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
	
	  br_tun_b0345198: flags=67<UP,BROADCAST,RUNNING>  mtu 1500
	          inet6 fe80::8814:9cff:fe20:f8  prefixlen 64  scopeid 0x20<link>
	          ether 12:05:76:77:64:4d  txqueuelen 0  (Ethernet)
	          RX packets 0  bytes 0 (0.0 B)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 0  bytes 0 (0.0 B)
	          TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
	
	  canal_00bc543c: flags=67<UP,BROADCAST,RUNNING>  mtu 1450
	          inet 172.31.2.2  netmask 255.255.0.0  broadcast 0.0.0.0
	          inet6 fe80::20c6:bfff:fe4d:1d8d  prefixlen 64  scopeid 0x20<link>
	          ether 02:55:ac:1f:02:02  txqueuelen 0  (Ethernet)
	          RX packets 38  bytes 5042 (4.9 KiB)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 48  bytes 3668 (3.5 KiB)
	          TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
	
	  docker0: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
	          inet 172.17.0.1  netmask 255.255.0.0  broadcast 0.0.0.0
	          ether 02:42:b4:ee:09:9c  txqueuelen 0  (Ethernet)
	          RX packets 0  bytes 0 (0.0 B)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 0  bytes 0 (0.0 B)
	          TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
	
	  eth0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
	          inet 192.168.0.202  netmask 255.255.255.0  broadcast 192.168.0.255
	          inet6 fe80::f816:3eff:feee:ff1e  prefixlen 64  scopeid 0x20<link>
	          ether fa:16:3e:ee:ff:1e  txqueuelen 1000  (Ethernet)
	          RX packets 870  bytes 420444 (410.5 KiB)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 1024  bytes 132364 (129.2 KiB)
	          TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
	
	  gw_00bc543c: flags=67<UP,BROADCAST,RUNNING>  mtu 1450
	          inet 172.31.2.1  netmask 255.255.255.0  broadcast 0.0.0.0
	          inet6 fe80::b085:cfff:feec:35ea  prefixlen 64  scopeid 0x20<link>
	          ether 02:55:ac:1f:02:01  txqueuelen 0  (Ethernet)
	          RX packets 0  bytes 0 (0.0 B)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 10  bytes 732 (732.0 B)
	          TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
	
	  lo: flags=73<UP,LOOPBACK,RUNNING>  mtu 65536
	          inet 127.0.0.1  netmask 255.0.0.0
	          inet6 ::1  prefixlen 128  scopeid 0x10<host>
	          loop  txqueuelen 0  (Local Loopback)
	          RX packets 12072  bytes 2591176 (2.4 MiB)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 12072  bytes 2591176 (2.4 MiB)
	          TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
	
	  overlay_br_int: flags=67<UP,BROADCAST,RUNNING>  mtu 1500
	          inet6 fe80::6c57:2aff:fed5:8fca  prefixlen 64  scopeid 0x20<link>
	          ether 9a:7c:81:80:5b:4a  txqueuelen 0  (Ethernet)
	          RX packets 2  bytes 56 (56.0 B)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 8  bytes 648 (648.0 B)
	          TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
	
	  vxlan_sys_4789: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 65470
	          inet6 fe80::d00c:a7ff:fe6e:24ab  prefixlen 64  scopeid 0x20<link>
	          ether d2:0c:a7:6e:24:ab  txqueuelen 1000  (Ethernet)
	          RX packets 37  bytes 5014 (4.8 KiB)
	          RX errors 0  dropped 0  overruns 0  frame 0
	          TX packets 41  bytes 3718 (3.6 KiB)
	          TX errors 0  dropped 8 overruns 0  carrier 0  collisions 0
	
	  [root@sparkonk8s-46929-p4jdl ~]#
	  [root@sparkonk8s-46929-p4jdl ~]#
	  [root@sparkonk8s-46929-p4jdl ~]# su pass
	  su: user pass does not exist
	  [root@sparkonk8s-46929-p4jdl ~]# su paas
	  [paas@sparkonk8s-46929-p4jdl root]$ monitor summly
	  bash: monitor: command not found
	  [paas@sparkonk8s-46929-p4jdl root]$ monitor summary
	  bash: monitor: command not found
	  [paas@sparkonk8s-46929-p4jdl root]$ docker ps
	  Cannot connect to the Docker daemon. Is the docker daemon running on this host?
	  [paas@sparkonk8s-46929-p4jdl root]$ su
	  Password:
	  [paas@sparkonk8s-46929-p4jdl root]$ su root
	  Password:
	  [paas@sparkonk8s-46929-p4jdl root]$ exit
	  exit
	  [root@sparkonk8s-46929-p4jdl ~]# docker
	  docker                  docker-containerd       docker-containerd-ctr   docker-containerd-shim  docker-runc
	  [root@sparkonk8s-46929-p4jdl ~]# docker ps
	  CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS              PORTS               NAMES
	  23e50cd88d54        canal-agent:latest   "canal-agent -LogOutp"   3 minutes ago       Up 3 minutes                            canal_agent
	  [root@sparkonk8s-46929-p4jdl ~]# docker ps -a
	  CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS                      PORTS               NAMES
	  23e50cd88d54        canal-agent:latest   "canal-agent -LogOutp"   3 minutes ago       Up 3 minutes                                    canal_agent
	  85aae727eeb5        224765a6bdbe         "/bin/sh -c 'apk upgr"   5 hours ago         Exited (2) 5 hours ago                          romantic_euclid
	  2943f045fda5        a5396ad98229         "/bin/sh -c 'apt-get "   21 hours ago        Exited (1) 21 hours ago                         adoring_galileo
	  9f23569e68cf        db4e1d7bd253         "/bin/sh -c 'apt-get "   21 hours ago        Exited (100) 21 hours ago                       lonely_elion
	  c3995436647d        db4e1d7bd253         "/bin/sh -c 'apt-get "   21 hours ago        Exited (100) 21 hours ago                       clever_engelbart
	  271739ea3ea9        b7e0a60b4491         "/bin/sh -c 'set -ex "   22 hours ago        Exited (3) 22 hours ago                         elegant_kirch
	  a4fa97b8eaf8        b7e0a60b4491         "/bin/sh -c 'set -ex "   22 hours ago        Exited (3) 22 hours ago                         prickly_thompson
	  [root@sparkonk8s-46929-p4jdl ~]# docker restart 23e50cd88d54
	  23e50cd88d54
	  [root@sparkonk8s-46929-p4jdl ~]# service restart docker
	  The service command supports only basic LSB actions (start, stop, restart, try-restart, reload, force-reload, status). For other actions, please try to use systemctl.
	  [root@sparkonk8s-46929-p4jdl ~]# sys
	  sysctl                          systemd-cgls                    systemd-escape                  systemd-machine-id-setup        systemd-stdio-bridge
	  systemctl                       systemd-cgtop                   systemd-firstboot               systemd-notify                  systemd-sysv-convert
	  systemd-analyze                 systemd-coredumpctl             systemd-hwdb                    systemd-nspawn                  systemd-tmpfiles
	  systemd-ask-password            systemd-delta                   systemd-inhibit                 systemd-path                    systemd-tty-ask-password-agent
	  systemd-cat                     systemd-detect-virt             systemd-loginctl                systemd-run                     sys-unconfig
	  [root@sparkonk8s-46929-p4jdl ~]# sys
	  sysctl                          systemd-cgls                    systemd-escape                  systemd-machine-id-setup        systemd-stdio-bridge
	  systemctl                       systemd-cgtop                   systemd-firstboot               systemd-notify                  systemd-sysv-convert
	  systemd-analyze                 systemd-coredumpctl             systemd-hwdb                    systemd-nspawn                  systemd-tmpfiles
	  systemd-ask-password            systemd-delta                   systemd-inhibit                 systemd-path                    systemd-tty-ask-password-agent
	  systemd-cat                     systemd-detect-virt             systemd-loginctl                systemd-run                     sys-unconfig
	  [root@sparkonk8s-46929-p4jdl ~]# system
	  systemctl                       systemd-cgls                    systemd-detect-virt             systemd-inhibit                 systemd-nspawn                  systemd-sysv-convert
	  systemd-analyze                 systemd-cgtop                   systemd-escape                  systemd-loginctl                systemd-path                    systemd-tmpfiles
	  systemd-ask-password            systemd-coredumpctl             systemd-firstboot               systemd-machine-id-setup        systemd-run                     systemd-tty-ask-password-agent
	  systemd-cat                     systemd-delta                   systemd-hwdb                    systemd-notify                  systemd-stdio-bridge
	  [root@sparkonk8s-46929-p4jdl ~]# systemctl
	  .bash_history      .bashrc            .docker/           .IdeaIC2017.1/     .kube/             .mozilla/          .oracle_jre_usage/ scala-2.11.8.zip   spark2makesuccess/ xubo/
	  .bash_logout       common_shared.key  docker-spark/      images/            .m2/               myimage/           .pki/              spark/             .ssh/              .zinc/
	  .bash_profile      .cshrc             .history           k8s/               .minikube/         mynginx/           root.key           spark2/            .tcshrc
	  [root@sparkonk8s-46929-p4jdl ~]# systemctl restart docker
	  [root@sparkonk8s-46929-p4jdl ~]# docker ps
	  CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS              PORTS               NAMES
	  bad600b0a1a1        canal-agent:latest   "canal-agent -LogOutp"   40 seconds ago      Up 39 seconds                           canal_agent
	  [root@sparkonk8s-46929-p4jdl ~]# docker ps
	  CONTAINER ID        IMAGE                COMMAND                  CREATED             STATUS              PORTS               NAMES
	  bad600b0a1a1        canal-agent:latest   "canal-agent -LogOutp"   47 seconds ago      Up 45 seconds                           canal_agent
	  [root@sparkonk8s-46929-p4jdl ~]# kubectl get pods
	  NAME            READY     STATUS     RESTARTS   AGE
	  icagent-2fhzc   0/0       Running    0          3d
	  icagent-d84d7   0/0       NodeLost   0          3d
	  icagent-dnfmw   0/0       Running    0          3d
	  icagent-f765n   0/0       Running    0          3d
	  icagent-wl12q   0/0       Running    0          3d
	  [root@sparkonk8s-46929-p4jdl ~]# kubectl ps
	  Error: unknown command "ps" for "kubectl"
	
	  Did you mean this?
	          get
	          cp
	
	  Run 'kubectl --help' for usage.
	  error: unknown command "ps" for "kubectl"
	
	  Did you mean this?
	          get
	          cp
	
	  [root@sparkonk8s-46929-p4jdl ~]# ps -aux |grep kube*
	  root       453  5.5 11.6 11358124 438968 ?     Ssl  07:01   0:21 /usr/local/bin/localkube --dns-domain=cluster.local --node-ip=192.168.0.202 --generate-certs=false --logtostderr=true --enable-dns=false
	  root      2043  0.0  0.5  86336 19484 ?        Ssl  07:01   0:00 /var/paas/kubernetes/baseagent/bin/baseagent daemon --role=node --plugin-url=https://100.125.0.198:20202 --kube-master-url=https://192.168.0.188:5443 --tls-ca-file=/var/paas/srv/kubernetes/ca.crt --tls-cert-file=/var/paas/srv/kubernetes/kubecfg.crt --tls-private-key-file=/var/paas/srv/kubernetes/kubecfg_crypto.key --type=VirtualMachine --highway-interface= > /var/paas/sys/log/baseagent/baseagent.log 2>&1
	  root      4339  0.1  0.7  75604 29312 ?        Sl   07:02   0:00 /usr/local/bin/kube-proxy --master=https://192.168.0.188:5443 --kubeconfig=/var/paas/kubernetes/kube-proxy/kubeconfig --proxy-namespace=default --resource-container= --v=2 --masquerade-all=true --hostname-override=192.168.0.202
	  paas      5537  0.0  0.1  59052  4500 ?        Sl   07:03   0:00 /var/paas/kubernetes/psm-daemon/bin/psm-daemon --psm-server=192.168.0.188:9445 --ca-file=/var/paas/srv/kubernetes/ca.crt --project-name=default --material-path=/var/paas/srv/kubernetes
	  root     11632  1.2  0.6 111200 23428 ?        Ssl  07:06   0:01 canal-agent -LogOutput /var/log/canal/canal-agent.log -SelfStoreEndpoint 192.168.0.188:4003 --hostname-override=default-192.168.0.202 -etcd-cafile=/var/paas/ca.crt -etcd-certfile=/var/paas/kubecfg.crt -etcd-keyfile=/var/paas/kubecfg_crypto.key -storage-backend etcd3
	  root     14210  0.0  0.0 112652   980 pts/0    S+   07:07   0:00 grep --color=auto kube*
	  [root@sparkonk8s-46929-p4jdl ~]# kubelet
	  .bash_history      .bashrc            .docker/           .IdeaIC2017.1/     .kube/             .mozilla/          .oracle_jre_usage/ scala-2.11.8.zip   spark2makesuccess/ xubo/
	  .bash_logout       common_shared.key  docker-spark/      images/            .m2/               myimage/           .pki/              spark/             .ssh/              .zinc/
	  .bash_profile      .cshrc             .history           k8s/               .minikube/         mynginx/           root.key           spark2/            .tcshrc
	  [root@sparkonk8s-46929-p4jdl ~]# kubelet
	  I0308 07:09:56.312097   17687 feature_gate.go:144] feature gates: map[]
	  W0308 07:09:56.312201   17687 server.go:502] No API client: no api servers specified
	  I0308 07:09:56.312240   17687 client.go:72] Connecting to docker on unix:///var/run/docker.sock
	  I0308 07:09:56.312253   17687 client.go:92] Start docker client with request timeout=2m0s
	  I0308 07:09:56.313069   17687 cni.go:153] Loaded cni plugins successfully, all plugins: map[mgnt0:0xc420371f80]
	  I0308 07:09:57.039541   17687 manager.go:143] cAdvisor running in container: "/user.slice"
	  W0308 07:09:57.067757   17687 manager.go:151] unable to connect to Rkt api service: rkt: cannot tcp Dial rkt api service: dial tcp [::1]:15441: getsockopt: connection refused
	  I0308 07:09:57.096881   17687 fs.go:117] Filesystem partitions: map[/dev/vda1:{mountpoint:/boot major:253 minor:1 fsType:ext4 blockSize:0} /dev/mapper/vgpaas-kubernetes:{mountpoint:/mnt/paas/kubernetes major:252 minor:0 fsType:ext4 blockSize:0} vgpaas-thinpool:{mountpoint: major:252 minor:2 fsType:devicemapper blockSize:1024} /dev/vda2:{mountpoint:/ major:253 minor:2 fsType:ext4 blockSize:0}]
	  I0308 07:09:57.100807   17687 manager.go:198] Machine: {NumCores:2 CpuFrequency:2394428 MemoryCapacity:3858661376 MachineID:6f7a744cc4094fea9ed9558f18f59093 SystemUUID:3AF9E044-1F1C-4FE9-AD4D-D21D92EE2558 BootID:1bd59893-c07e-42aa-ba78-be1041d3fa30 Filesystems:[{Device:/dev/vda2 DeviceMajor:253 DeviceMinor:2 Capacity:42223763456 Type:vfs Inodes:2344960 HasInodes:true} {Device:/dev/vda1 DeviceMajor:253 DeviceMinor:1 Capacity:97335296 Type:vfs Inodes:25688 HasInodes:true} {Device:/dev/mapper/vgpaas-kubernetes DeviceMajor:252 DeviceMinor:0 Capacity:5146017792 Type:vfs Inodes:327680 HasInodes:true} {Device:vgpaas-thinpool DeviceMajor:252 DeviceMinor:2 Capacity:96632569856 Type:devicemapper Inodes:0 HasInodes:false}] DiskMap:map[252:3:{Name:dm-3 Major:252 Minor:3 Size:96632569856 Scheduler:none} 252:4:{Name:dm-4 Major:252 Minor:4 Size:10737418240 Scheduler:none} 253:0:{Name:vda Major:253 Minor:0 Size:42949672960 Scheduler:none} 253:16:{Name:vdb Major:253 Minor:16 Size:107374182400 Scheduler:none} 252:0:{Name:dm-0 Major:252 Minor:0 Size:5364514816 Scheduler:none} 252:1:{Name:dm-1 Major:252 Minor:1 Size:1069547520 Scheduler:none} 252:2:{Name:dm-2 Major:252 Minor:2 Size:96632569856 Scheduler:none}] NetworkDevices:[{Name:br_canal MacAddress:3e:39:77:ee:34:4a Speed:0 Mtu:1500} {Name:br_monitor MacAddress:9a:1a:4b:ba:59:48 Speed:0 Mtu:1500} {Name:br_tun_b0345198 MacAddress:12:05:76:77:64:4d Speed:0 Mtu:1500} {Name:canal_00bc543c MacAddress:02:55:ac:1f:02:02 Speed:0 Mtu:1450} {Name:eth0 MacAddress:fa:16:3e:ee:ff:1e Speed:0 Mtu:1500} {Name:gw_00bc543c MacAddress:02:55:ac:1f:02:01 Speed:0 Mtu:1450} {Name:overlay_br_int MacAddress:9a:7c:81:80:5b:4a Speed:0 Mtu:1500} {Name:ovs-system MacAddress:da:b8:76:3b:cb:4e Speed:0 Mtu:1500} {Name:vxlan_sys_4789 MacAddress:d2:0c:a7:6e:24:ab Speed:0 Mtu:65470}] Topology:[{Id:0 Memory:4277264384 Cores:[{Id:0 Threads:[0 1] Caches:[{Size:4194304 Type:Unified Level:2}]}] Caches:[{Size:16777216 Type:Unified Level:3}]}] CloudProvider:Unknown InstanceType:Unknown InstanceID:None}
	  I0308 07:09:57.101520   17687 manager.go:204] Version: {KernelVersion:3.10.0-327.44.58.35.x86_64 ContainerOsVersion:EulerOS 2.0 (SP2) DockerVersion:1.11.2 DockerAPIVersion:1.23 CadvisorVersion: CadvisorRevision:}
	  W0308 07:09:57.101962   17687 server.go:357] No api server defined - no events will be sent to API server.
	  I0308 07:09:57.102069   17687 server.go:559] --cgroups-per-qos enabled, but --cgroup-root was not specified.  defaulting to /
	  I0308 07:09:57.102082   17687 cadvisor_linux.go:149] Failed to register cAdvisor on port 4194, retrying. Error: listen tcp 127.0.0.1:4194: bind: address already in use
	  I0308 07:09:57.103444   17687 container_manager_linux.go:246] container manager verified user specified cgroup-root exists: /
	  I0308 07:09:57.103467   17687 container_manager_linux.go:251] Creating Container Manager object based on Node Config: {RuntimeCgroupsName: SystemCgroupsName: KubeletCgroupsName: ContainerRuntime:docker CgroupsPerQOS:true CgroupRoot:/ CgroupDriver:cgroupfs ProtectKernelDefaults:false NodeAllocatableConfig:{KubeReservedCgroupName: SystemReservedCgroupName: EnforceNodeAllocatable:map[pods:{}] KubeReserved:map[] SystemReserved:map[] HardEvictionThresholds:[{Signal:memory.available Operator:LessThan Value:{Quantity:100Mi Percentage:0} GracePeriod:0s MinReclaim:<nil>} {Signal:nodefs.available Operator:LessThan Value:{Quantity:<nil> Percentage:0.1} GracePeriod:0s MinReclaim:<nil>} {Signal:nodefs.inodesFree Operator:LessThan Value:{Quantity:<nil> Percentage:0.05} GracePeriod:0s MinReclaim:<nil>}]} ExperimentalQOSReserved:map[]}
	  W0308 07:09:57.106242   17687 kubelet_network.go:70] Hairpin mode set to "promiscuous-bridge" but kubenet is not enabled, falling back to "hairpin-veth"
	  I0308 07:09:57.106272   17687 kubelet.go:610] Hairpin mode set to "hairpin-veth"
	  I0308 07:09:57.108291   17687 cni.go:153] Loaded cni plugins successfully, all plugins: map[mgnt0:0xc420bfb350]
	  I0308 07:09:57.116242   17687 docker_service.go:208] Docker cri networking managed by kubernetes.io/no-op
	  I0308 07:09:57.145144   17687 docker_service.go:225] Setting cgroupDriver to cgroupfs
	  I0308 07:09:57.174949   17687 remote_runtime.go:42] Connecting to runtime service unix:///var/run/dockershim.sock
	  I0308 07:09:57.176031   17687 kuberuntime_manager.go:166] Container runtime docker initialized, version: 1.11.2, apiVersion: 1.23.0
	  I0308 07:09:57.896018   17687 server.go:973] Started kubelet v1.7.3-CCE2.0.4-3.5.2
	  E0308 07:09:57.896103   17687 server.go:635] Starting health server failed: listen tcp 127.0.0.1:10248: bind: address already in use
	  E0308 07:09:57.896136   17687 kubelet.go:1462] Image garbage collection failed once. Stats initialization may not have completed yet: unable to find data for container /
	  W0308 07:09:57.896291   17687 kubelet.go:1610] No api server defined - no node status update will be sent.
	  I0308 07:09:57.896776   17687 kubelet_node_status.go:267] Setting node annotation to enable volume controller attach/detach
	  I0308 07:09:57.896311   17687 server.go:138] Starting to listen on 0.0.0.0:10250
	  I0308 07:09:57.899919   17687 server.go:341] Adding debug handlers to kubelet server.
	  F0308 07:09:57.901002   17687 server.go:150] listen tcp 0.0.0.0:10250: bind: address already in use
	  [root@sparkonk8s-46929-p4jdl ~]# kubectl get pods
	  NAME            READY     STATUS     RESTARTS   AGE
	  icagent-2fhzc   0/0       Running    0          3d
	  icagent-d84d7   0/0       NodeLost   0          3d
	  icagent-dnfmw   0/0       Running    0          3d
	  icagent-f765n   0/0       Running    0          3d
	  icagent-wl12q   0/0       Running    0          3d
	  [root@sparkonk8s-46929-p4jdl ~]# su paass
	  su: user paass does not exist
	  [root@sparkonk8s-46929-p4jdl ~]# su paas
	  [paas@sparkonk8s-46929-p4jdl root]$ monit summary
	  Monit 5.20.0 uptime: 8m
	  ┌─────────────────────────────────┬────────────────────────────┬───────────────┐
	  │ Service Name                    │ Status                     │ Type          │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ sparkonk8s-46929-p4jdl.noval... │ Running                    │ System        │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ psm-daemon                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovsdb-server                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovs-vswitchd                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kubelet                         │ Does not exist             │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kube-proxy                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ docker                          │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ canal                           │ Running                    │ Process       │
	  └─────────────────────────────────┴────────────────────────────┴───────────────┘
	  [paas@sparkonk8s-46929-p4jdl root]$ monit restart kubelet
	  [paas@sparkonk8s-46929-p4jdl root]$ monit summary
	  Monit 5.20.0 uptime: 9m
	  ┌─────────────────────────────────┬────────────────────────────┬───────────────┐
	  │ Service Name                    │ Status                     │ Type          │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ sparkonk8s-46929-p4jdl.noval... │ Running                    │ System        │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ psm-daemon                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovsdb-server                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovs-vswitchd                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kubelet                         │ Initializing               │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kube-proxy                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ docker                          │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ canal                           │ Running                    │ Process       │
	  └─────────────────────────────────┴────────────────────────────┴───────────────┘
	  [paas@sparkonk8s-46929-p4jdl root]$ cd /var/paas/sys/log/kubernetes/
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ ll
	  total 82736
	  -rw-r----- 1 paas paas 84259165 Mar  8 07:11 kubelet.log
	  -rw-r----- 1 paas paas   431478 Mar  8 07:02 kube-proxy.log
	  drwxr-x--- 2 paas paas     4096 Mar  1 11:47 talcmon
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ vi kubelet.log
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ monit summary
	  Monit 5.20.0 uptime: 10m
	  ┌─────────────────────────────────┬────────────────────────────┬───────────────┐
	  │ Service Name                    │ Status                     │ Type          │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ sparkonk8s-46929-p4jdl.noval... │ Running                    │ System        │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ psm-daemon                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovsdb-server                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovs-vswitchd                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kubelet                         │ Does not exist             │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kube-proxy                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ docker                          │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ canal                           │ Running                    │ Process       │
	  └─────────────────────────────────┴────────────────────────────┴───────────────┘
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ netstat -apn | grep 10255
	  (Not all processes could be identified, non-owned process info
	   will not be shown, you would have to be root to see it all.)
	  tcp6       0      0 :::10255                :::*                    LISTEN      -
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ vi kubelet.log
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ netstat -apn | grep 10248
	  (Not all processes could be identified, non-owned process info
	   will not be shown, you would have to be root to see it all.)
	  tcp        0      0 127.0.0.1:10248         0.0.0.0:*               LISTEN      -
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ netstat -apn | grep 10248
	  (Not all processes could be identified, non-owned process info
	   will not be shown, you would have to be root to see it all.)
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ monit restart kubelet
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ monit summary
	  Monit 5.20.0 uptime: 13m
	  ┌─────────────────────────────────┬────────────────────────────┬───────────────┐
	  │ Service Name                    │ Status                     │ Type          │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ sparkonk8s-46929-p4jdl.noval... │ Running                    │ System        │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ psm-daemon                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovsdb-server                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovs-vswitchd                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kubelet                         │ Initializing               │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kube-proxy                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ docker                          │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ canal                           │ Running                    │ Process       │
	  └─────────────────────────────────┴────────────────────────────┴───────────────┘
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ monit summary
	  Monit 5.20.0 uptime: 13m
	  ┌─────────────────────────────────┬────────────────────────────┬───────────────┐
	  │ Service Name                    │ Status                     │ Type          │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ sparkonk8s-46929-p4jdl.noval... │ Running                    │ System        │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ psm-daemon                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovsdb-server                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovs-vswitchd                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kubelet                         │ Initializing               │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kube-proxy                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ docker                          │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ canal                           │ Running                    │ Process       │
	  └─────────────────────────────────┴────────────────────────────┴───────────────┘
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ vi
	  kubelet.log     kube-proxy.log  talcmon/
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ vi kubelet.log
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ monit summary
	  Monit 5.20.0 uptime: 13m
	  ┌─────────────────────────────────┬────────────────────────────┬───────────────┐
	  │ Service Name                    │ Status                     │ Type          │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ sparkonk8s-46929-p4jdl.noval... │ Running                    │ System        │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ psm-daemon                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovsdb-server                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ ovs-vswitchd                    │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kubelet                         │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ kube-proxy                      │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ docker                          │ Running                    │ Process       │
	  ├─────────────────────────────────┼────────────────────────────┼───────────────┤
	  │ canal                           │ Running                    │ Process       │
	  └─────────────────────────────────┴────────────────────────────┴───────────────┘
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$ vi kubelet.log
	  [paas@sparkonk8s-46929-p4jdl kubernetes]$
