
1.Spark的不同Job之间，两个不用的application需要从HDFS中加载两次同样的数据，而使用tachyon就不用了：
     当两个Spark作业需要共享数据时，必须通过写磁盘操作。比如：作业1要先把生成的数据写入HDFS，然后作业2再从HDFS把数据读出来。在此，磁盘的读写可能造成性能瓶颈。
    另外不同的应用框架也可以利用tachyon在内存中共享数据，比如Spark和Hadoop

2. 由于Spark会利用自身的JVM对数据进行缓存，当Spark程序崩溃时，JVM进程退出，所缓存数据也随之丢失，因此在工作重启时又需要从HDFS把数据再次读出。
    如果利用Tachyon，相当于在disk和任务间加一层，就算JVM或者及其crash掉了，重启时可以在tachyon读取
   不同进程间数据的共享
    
3. 当两个Spark作业需操作相同的数据时，每个作业的JVM都需要缓存一份数据，不但造成资源浪费，也极易引发频繁的垃圾收集，造成性能的降低。
  =》不同job缓存同一份数据会增加内存开销，而是用tachyon就可以节省资源


参考：
【1】http://www.wtoutiao.com/p/hf6YDg.html
