
1.tachyon是否会占用额外的空间？
当tachyon将数据存储在内存中时，spark读取的时候是copy还是使用lineage？


2.在运行spark的时候persist可以制定off-heap，而这种默认使用tachyon，这种模式与使用saveAsFile等指令存储到tachyon有什么区别？

3.当tachyon内存存储到一定值时tachyon将文件存储到hdfs或者disk的具体实现机制是什么样的？

4.tachyon分布式如何实现？

5.tachyon域redis性能差别？