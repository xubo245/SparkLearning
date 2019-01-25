
## Prepare
  install java,scala,maven，spark
  compile spark（编译最新spark，也可以下编译好的包）
  参考[1]配置好相关项
## Run
run下配置configuration：

	PYTHONPATH=/Users/xubo/Desktop/xubo/git/spark/python;
	SPARK_HOME=/Users/xubo/Desktop/xubo/git/spark/
通用配置，其他类也可以用：
   在pycharm=》perference=〉搜索python console=》配置environment configuration

### code

	import sys

	try:
	    from pyspark import SparkContext
	    from pyspark import SparkConf
	
	    print ("Successfully imported Spark Modules")
	except ImportError as e:
	    print ("Can not import Spark Modules", e)
	    sys.exit(1)
	def f(x): print(x)
	sc = SparkContext("local","apple")
	words = sc.parallelize(["scala", "java", "hadoop", "spark", "akka"])
	print(words.count())
	words.foreach(f)

### result

	import sys; print('Python %s on %s' % (sys.version, sys.platform))
	sys.path.extend(['/Users/xubo/Desktop/xubo/git/spark/python', '/Users/xubo/Desktop/xubo/git/spark/python/lib/py4j-0.10.8.1-src.zip', '/Users/xubo/Desktop/xubo/git/spark/python/lib/pyspark.zip'])
	PyDev console: starting.
	Python 2.7.15 (default, May  1 2018, 16:44:08) 
	[GCC 4.2.1 Compatible Apple LLVM 9.1.0 (clang-902.0.39.1)] on darwin
	import os
	os.environ['PYTHONPATH'] = '/Users/xubo/Desktop/xubo/git/spark/python'
	os.environ['SPARK_HOME'] = '/Users/xubo/Desktop/xubo/git/spark/'
	runfile('/Users/xubo/Desktop/xubo/git/spark/python/pyspark/ml/tests/spark_test.py', wdir='/Users/xubo/Desktop/xubo/git/spark/python/pyspark/ml/tests')
	Successfully imported Spark Modules
	19/01/25 11:19:12 WARN Utils: Your hostname, localhost resolves to a loopback address: 127.0.0.1; using 192.168.43.77 instead (on interface en0)
	19/01/25 11:19:12 WARN Utils: Set SPARK_LOCAL_IP if you need to bind to another address
	19/01/25 11:19:12 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
	Setting default log level to "WARN".
	To adjust logging level use sc.setLogLevel(newLevel). For SparkR, use setLogLevel(newLevel).
	19/01/25 11:19:13 WARN Utils: Service 'SparkUI' could not bind on port 4040. Attempting port 4041.
	19/01/25 11:19:14 WARN DAGScheduler: Broadcasting large task binary with size 5.6 KiB
	5
	19/01/25 11:26:36 WARN DAGScheduler: Broadcasting large task binary with size 6.2 KiB
	scala
	java
	hadoop
	spark
	akka



## Problem

### problem 1

	Will test the following Python modules: ['pyspark-core', 'pyspark-ml', 'pyspark-mllib', 'pyspark-sql', 'pyspark-streaming']
	Starting test(python2.7): pyspark.ml.tests.test_base
	Starting test(python2.7): pyspark.ml.tests.test_evaluation
	Starting test(python2.7): pyspark.ml.tests.test_feature
	Starting test(python2.7): pyspark.ml.tests.test_algorithms
	/usr/local/opt/python@2/bin/python2.7: No module named py4j.protocol
	
	Had test failures in pyspark.ml.tests.test_algorithms with python2.7; see logs.
   
#### solution
   refer to [1]
	 
### problem 2
	Will test the following Python modules: ['pyspark-core', 'pyspark-ml', 'pyspark-mllib', 'pyspark-sql', 'pyspark-streaming']
	Starting test(python2.7): pyspark.ml.tests.test_algorithms
	Starting test(python2.7): pyspark.ml.tests.test_base
	Starting test(python2.7): pyspark.ml.tests.test_evaluation
	Starting test(python2.7): pyspark.ml.tests.test_feature
	/Users/xubo/Desktop/xubo/git/spark/python/venv/bin/python2.7: No module named numpy
	
	Had test failures in pyspark.ml.tests.test_algorithms with python2.7; see logs.
   
   在perference=》project=〉python interpreter中install numpy
### problem 3

	tput: No value for $TERM and no -T specified
	Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
	SLF4J: Class path contains multiple SLF4J bindings.
	SLF4J: Found binding in [jar:file:/Users/xubo/Desktop/xubo/git/spark1.3.1/assembly/target/scala-2.10/spark-assembly-1.3.1-hadoop1.0.4.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/Users/xubo/Desktop/xubo/soft/alluxio-1.8.1/client/alluxio-1.8.1-client.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
	SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
	19/01/25 11:00:29 ERROR SparkUncaughtExceptionHandler: Uncaught exception in thread Thread[main,5,main]
	java.util.NoSuchElementException: key not found: _PYSPARK_DRIVER_CALLBACK_HOST
		at scala.collection.MapLike$class.default(MapLike.scala:228)
		at scala.collection.AbstractMap.default(Map.scala:58)
		at scala.collection.MapLike$class.apply(MapLike.scala:141)
		at scala.collection.AbstractMap.apply(Map.scala:58)
		at org.apache.spark.api.python.PythonGatewayServer$$anonfun$main$1.apply$mcV$sp(PythonGatewayServer.scala:48)
		at org.apache.spark.util.Utils$.tryOrExit(Utils.scala:1123)

#### solution
改用配套的spark和pyspark，需要一一对应
## reference
 - [1] https://www.jianshu.com/p/65aec07dea32
 