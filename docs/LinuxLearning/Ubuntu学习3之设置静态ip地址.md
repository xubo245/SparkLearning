
更多代码请见：https://github.com/xubo245

Ubuntu学习

# 1.解释 #

搭集群的时候，需要设置静态ip，防止ip变化带来的集群连接问题

# 2.代码： #

（1）interfaces文件修改：

	hadoop@Master:~$ sudo  vi /etc/network/interfaces
	[sudo] password for hadoop: 
	
	# interfaces(5) file used by ifup(8) and ifdown(8)
	auto eth0
	iface eth0 inet static
	address 192.168.1.149
	gateway 192.168.1.1
	netmask 255.255.255.0

（2）设置dns

	hadoop@Master:~$ vi /etc/resolvconf/resolv.conf.d/base
	
	nameserver 192.168.223.10

（3）生效

	sudo ifdown eth0
	sudo ifup eth0
或者sudo reboot重启

# 3.结果： #
    
    静态ip设置成功


参考

	【1】https://github.com/xubo245
	【2]http://blog.csdn.net/xubo245/
