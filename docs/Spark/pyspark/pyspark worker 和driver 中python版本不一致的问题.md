	
## Problem:
	
	Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
	Setting default log level to "WARN".
	To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
	19/01/25 11:52:11 WARN DAGScheduler: Broadcasting large task binary with size 6.0 KiB
	19/01/25 11:52:12 ERROR Executor: Exception in task 0.0 in stage 0.0 (TID 0)
	org.apache.spark.api.python.PythonException: Traceback (most recent call last):
	  File "/Users/xubo/Desktop/xubo/git/spark/python/lib/pyspark.zip/pyspark/worker.py", line 315, in main
	    ("%d.%d" % sys.version_info[:2], version))
	Exception: Python in worker has different version 2.7 than that in driver 3.6, PySpark cannot run with different minor versions.Please check environment variables PYSPARK_PYTHON and PYSPARK_DRIVER_PYTHON are correctly set.
		at org.apache.spark.api.python.BasePythonRunner$ReaderIterator.handlePythonException(PythonRunner.scala:453)
		at org.apache.spark.api.python.PythonRunner$$anon$3.read(PythonRunner.scala:588)
		at org.apache.spark.api.python.PythonRunner$$anon$3.read(PythonRunner.scala:571)
		at org.apache.spark.api.python.BasePythonRunner$ReaderIterator.hasNext(PythonRunner.scala:406)
		at org.apache.spark.InterruptibleIterator.hasNext(InterruptibleIterator.scala:37)
		at scala.collection.Iterator.foreach(Iterator.scala:941)
		at scala.collection.Iterator.foreach$(Iterator.scala:941)
		at org.apache.spark.InterruptibleIterator.foreach(InterruptibleIterator.scala:28)
		at scala.collection.generic.Growable.$plus$plus$eq(Growable.scala:62)
		at scala.collection.generic.Growable.$plus$plus$eq$(Growable.scala:53)
		
## Solution
把python的版本都设置为2.7即可运行