
更多代码请见：https://github.com/xubo245

Ubuntu学习

# 1.解释 #  

原来系统应为RAID机制启动不了，包 Non RAID disk错误，RAID之后启动不了，dhcp获取ip，但是tftp timeout，所以将磁盘放到好的主机可以恢复


# 2.代码： #
使用parted指令： parted为分区指令，参考【3】

	hadoop@Mcnode7:~$ sudo parted /dev/sdb
	GNU Parted 2.3
	Using /dev/sdb
	Welcome to GNU Parted! Type 'help' to view a list of commands.
	(parted) rm 1                                                             
	Error: Can't have a partition outside the disk!                           
	(parted) print                                                            
	Error: Can't have a partition outside the disk!                           
	(parted) mklabel gpt
	(parted) print                                                            
	Model: ATA Hitachi HDT72105 (scsi)
	Disk /dev/sdb: 500GB
	Sector size (logical/physical): 512B/512B
	Partition Table: gpt
	
	Number  Start  End  Size  File system  Name  Flags
	
	(parted) mkpart primary 0% 100%                                           
	(parted) print
	Model: ATA Hitachi HDT72105 (scsi)
	Disk /dev/sdb: 500GB
	Sector size (logical/physical): 512B/512B
	Partition Table: gpt
	
	Number  Start   End    Size   File system  Name     Flags
	 1      1049kB  500GB  500GB  ext4         primary


# 3.结果： #


查看：发下原来Mcnode5的数据都还在，而且还可以访问

	hadoop@Mcnode7:~$ sudo fdisk -lu
	[sudo] password for hadoop: 
	
	Disk /dev/sda: 500.1 GB, 500107862016 bytes
	255 heads, 63 sectors/track, 60801 cylinders, total 976773168 sectors
	Units = sectors of 1 * 512 = 512 bytes
	Sector size (logical/physical): 512 bytes / 512 bytes
	I/O size (minimum/optimal): 512 bytes / 512 bytes
	Disk identifier: 0x000db939
	
	   Device Boot      Start         End      Blocks   Id  System
	/dev/sda1   *        2048   951625727   475811840   83  Linux
	/dev/sda2       951627774   976771071    12571649    5  Extended
	/dev/sda5       951627776   976771071    12571648   82  Linux swap / Solaris
	
	WARNING: GPT (GUID Partition Table) detected on '/dev/sdb'! The util fdisk doesn't support GPT. Use GNU Parted.
	
	
	Disk /dev/sdb: 500.1 GB, 500107862016 bytes
	255 heads, 63 sectors/track, 60801 cylinders, total 976773168 sectors
	Units = sectors of 1 * 512 = 512 bytes
	Sector size (logical/physical): 512 bytes / 512 bytes
	I/O size (minimum/optimal): 512 bytes / 512 bytes
	Disk identifier: 0x00000000
	
	   Device Boot      Start         End      Blocks   Id  System
	/dev/sdb1               1   976773167   488386583+  ee  GPT
	hadoop@Mcnode7:~$ cd /media/hadoop/7c63f77d-11b0-4769-bf60-5380d8ae7b9e
	hadoop@Mcnode7:/media/hadoop/7c63f77d-11b0-4769-bf60-5380d8ae7b9e$ ls
	bin  boot  cdrom  dev  etc  home  initrd.img  lib  lib64  lost+found  media  mnt  opt  proc  root  run  sbin  srv  sys  tmp  usr  var  vmlinuz
	hadoop@Mcnode7:/media/hadoop/7c63f77d-11b0-4769-bf60-5380d8ae7b9e$ cd usr/
	hadoop@Mcnode7:/media/hadoop/7c63f77d-11b0-4769-bf60-5380d8ae7b9e/usr$ ls
	bin  games  include  lib  local  sbin  share  src
	hadoop@Mcnode7:/media/hadoop/7c63f77d-11b0-4769-bf60-5380d8ae7b9e/usr$ cd ../home/
	hadoop@Mcnode7:/media/hadoop/7c63f77d-11b0-4769-bf60-5380d8ae7b9e/home$ ls
	hadoop  uftp
	hadoop@Mcnode7:/media/hadoop/7c63f77d-11b0-4769-bf60-5380d8ae7b9e/home$ cd hadoop/
	hadoop@Mcnode7:/media/hadoop/7c63f77d-11b0-4769-bf60-5380d8ae7b9e/home/hadoop$ ls
	backup223  cloud    disk.txt   Downloads         logs        Music     Public     redis1492.sh  rmq_bk_gc.log  store      test     Videos  zookeeper.out
	Chng       Desktop  Documents  examples.desktop  middleware  Pictures  recommend  redis149.sh   site           Templates  test.sh  xubo


参考

	【1】https://github.com/xubo245
	【2]http://blog.csdn.net/xubo245/
	【3】http://www.cnblogs.com/net2012/archive/2013/02/01/2888453.html
