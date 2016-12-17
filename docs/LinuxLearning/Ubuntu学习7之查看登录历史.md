
更多代码请见：https://github.com/xubo245

Ubuntu学习

# 1.解释 #

1.1 last 指令

	last命令可用于显示特定用户登录系统的历史记录。如果没有指定任何参数，则显示所有用户的历史信息。在默认情况下，这些信息（所显示的信息）将来源于/var/log/wtmp文件。该命令的输出结果包含以下几列信息：
	用户名称
	tty设备号
	历史登录时间日期
	登出时间日期
	总工作时间

使用方法

	hadoop@Mcnode6:~$ last --help
	last: invalid option -- '-'
	Usage: last [-num | -n num] [-f file] [-t YYYYMMDDHHMMSS] [-R] [-adioxFw] [username..] [tty..]

1.2.使用who命令查看（登录）用户名称及所启动的进程  
who命令用于列举出当前已登录系统的用户名称。其输出为：用户名、tty号、时间日期、主机地址。

1.3 使用w命令查看登录用户正在使用的进程信息   
w命令用于显示已经登录系统的用户的名称，以及他们正在做的事。该命令所使用的信息来源于/var/run/utmp文件。w命令输出的信息包括：


# 2.代码： #

2.1 last 执行

	hadoop@Mcnode6:~$ last
	hadoop   pts/30       :1               Sat Nov  5 20:26   still logged in   
	hadoop   :1           :1               Sat Nov  5 20:26   still logged in   
	hadoop   pts/14       host-e-202.ustcs Sat Nov  5 20:25   still logged in   
	guest-2R pts/5        :0               Sat Nov  5 20:23   still logged in   
	hadoop   pts/4        mcnodex1         Thu Nov  3 19:17   still logged in   
	guest-2R :0           :0               Thu Nov  3 15:36   still logged in   
	hadoop   pts/4        host-e-150.ustcs Thu Nov  3 15:10 - 15:56  (00:45)    
	hadoop   pts/1        host-e-150.ustcs Wed Nov  2 21:54 - 21:54  (00:00)    
	hadoop   pts/1        host-e-150.ustcs Wed Nov  2 21:45 - 21:45  (00:00)    
	hadoop   pts/18       mcnodex1         Wed Nov  2 19:59 - 14:15  (18:16)    
	hadoop   pts/17       host-e-150.ustcs Wed Nov  2 19:23 - 21:11  (01:48)    
	hadoop   pts/16       host-e-150.ustcs Wed Nov  2 19:12 - 21:54  (02:41)    
	hadoop   pts/10       host-e-150.ustcs Wed Nov  2 19:01 - 21:53  (02:52)    
	hadoop   pts/8        host-e-150.ustcs Wed Nov  2 19:01 - 21:53  (02:52)    
	hadoop   pts/1        host-e-150.ustcs Wed Nov  2 18:56 - 20:53  (01:56)    
	reboot   system boot  3.16.0-30-generi Wed Nov  2 18:56 - 20:36 (3+01:40)   
	hadoop   pts/5        202.38.84.12     Wed Nov  2 18:47 - down   (00:07)    
	reboot   system boot  3.16.0-30-generi Wed Nov  2 18:47 - 18:54  (00:07)    
	hadoop   pts/1        host-e-150.ustcs Wed Nov  2 18:45 - down   (00:00)    
	hadoop   pts/7        host-e-150.ustcs Wed Nov  2 18:44 - down   (00:01)    
	guest-nz :0           :0               Wed Nov  2 18:44 - 18:45  (00:01)    
	reboot   system boot  3.16.0-30-generi Wed Nov  2 18:43 - 18:46  (00:02)    
	reboot   system boot  3.16.0-30-generi Wed Nov  2 18:37 - 18:37  (00:00)    
	reboot   system boot  3.16.0-30-generi Wed Nov  2 18:35 - 18:36  (00:01)    
	reboot   system boot  3.16.0-30-generi Wed Nov  2 18:27 - 18:28  (00:00)    
	hadoop   pts/8        host-e-150.ustcs Wed Nov  2 16:45 - down   (01:41)    
	hadoop   pts/17       host-e-150.ustcs Wed Nov  2 15:51 - 16:14  (00:23)    
	hadoop   pts/16       host-e-150.ustcs Wed Nov  2 15:35 - 16:14  (00:38)    
	hadoop   pts/10       host-e-150.ustcs Wed Nov  2 15:34 - 16:14  (00:40)    
	hadoop   pts/8        host-e-150.ustcs Wed Nov  2 15:33 - 16:15  (00:42)    
	hadoop   pts/8        host-e-150.ustcs Wed Nov  2 13:04 - 15:21  (02:16)    
	hadoop   pts/5        mcnodex1         Tue Nov  1 23:42 - down   (18:44)    
	hadoop   pts/5        master           Tue Nov  1 22:07 - 22:07  (00:00)    
	hadoop   pts/8        host-e-150.ustcs Tue Nov  1 19:53 - 20:54  (01:00)    
	hadoop   pts/5        host-e-150.ustcs Tue Nov  1 17:37 - 20:59  (03:22)    
	reboot   system boot  3.16.0-30-generi Tue Nov  1 17:32 - 18:26 (1+00:53) 

2.2 who 查看当前有哪些用户

	hadoop@Mcnode6:~$ who
	hadoop   pts/4        2016-11-03 19:17 (mcnodex1)
	guest-2RZAIN :0           2016-11-03 15:36 (:0)
	guest-2RZAIN pts/5        2016-11-05 20:23 (:0)
	hadoop   pts/14       2016-11-05 20:25 (host-e-202.ustcsz.edu.cn)
	hadoop   :1           2016-11-05 20:26 (:1)
	hadoop   pts/30       2016-11-05 20:26 (:1)
	hadoop   pts/26       2016-11-05 20:37 (:1)


2.3 w 查看用户正在使用哪些进程

	hadoop@Mcnode6:~$ w
	 20:40:53 up 3 days,  1:45,  7 users,  load average: 2.06, 2.10, 2.13
	USER     TTY      FROM             LOGIN@   IDLE   JCPU   PCPU WHAT
	hadoop   pts/4    mcnodex1         四19    2days  3:45   3:45  top
	guest-2R :0       :0               四15   ?xdm?   2:08m  0.19s init --user
	guest-2R pts/5    :0               20:23   15:33   0.13s  0.12s bash
	hadoop   pts/14   host-e-202.ustcs 20:25    5.00s  0.11s  0.00s w
	hadoop   :1       :1               20:26   ?xdm?   2:08m  0.15s init --user
	hadoop   pts/30   :1               20:26    3:17   0.28s  0.00s scp -rf tmp/ hadoop@master:~/Chng/
	hadoop   pts/26   :1               20:37    5.00s  0.12s  0.04s vim read26.py



# 3.结果： #

更详细请见【3】

参考

	【1】https://github.com/xubo245
	【2]http://blog.csdn.net/xubo245/
	【3】http://blog.csdn.net/wudiyi815/article/details/8061459
