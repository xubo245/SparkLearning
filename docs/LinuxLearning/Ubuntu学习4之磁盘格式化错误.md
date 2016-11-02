
更多代码请见：https://github.com/xubo245

Ubuntu学习

# 1.解释 #

错误：

 	error "Error synchronizing after initial wipe: Timed out waiting for object (udisks-error-quark, 0)

解决：使用parted分区

# 2.代码： #



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



参考

	【1】https://github.com/xubo245
	【2]http://blog.csdn.net/xubo245/
