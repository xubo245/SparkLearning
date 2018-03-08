	[INFO]
	[INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-sql_2.11 ---
	[INFO] Building jar: /root/spark/sql/core/target/spark-sql_2.11-2.3.1-SNAPSHOT-sources.jar
	[INFO]
	[INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-sql_2.11 ---
	[INFO] Building jar: /root/spark/sql/core/target/spark-sql_2.11-2.3.1-SNAPSHOT-test-sources.jar
	[INFO]
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Spark Project ML Library 2.3.1-SNAPSHOT
	[INFO] ------------------------------------------------------------------------
	Downloading: https://repo.maven.apache.org/maven2/org/jpmml/pmml-model/1.2.15/pmml-model-1.2.15.pom
	Mar 05, 2018 8:45:14 AM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: I/O exception (java.net.SocketException) caught when processing request to {s}->https://repo.maven.apache.org:443: Connection reset
	Mar 05, 2018 8:45:14 AM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: Retrying request to {s}->https://repo.maven.apache.org:443
	Mar 05, 2018 8:45:14 AM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: I/O exception (java.net.SocketException) caught when processing request to {s}->https://repo.maven.apache.org:443: Connection reset
	Mar 05, 2018 8:45:14 AM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: Retrying request to {s}->https://repo.maven.apache.org:443
	Mar 05, 2018 8:45:14 AM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: I/O exception (java.net.SocketException) caught when processing request to {s}->https://repo.maven.apache.org:443: Connection reset
	Mar 05, 2018 8:45:14 AM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: Retrying request to {s}->https://repo.maven.apache.org:443
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Summary:
	[INFO]
	[INFO] Spark Project Parent POM ........................... SUCCESS [  5.043 s]
	[INFO] Spark Project Tags ................................. SUCCESS [  9.247 s]
	[INFO] Spark Project Sketch ............................... SUCCESS [  9.984 s]
	[INFO] Spark Project Local DB ............................. SUCCESS [  5.125 s]
	[INFO] Spark Project Networking ........................... SUCCESS [  8.443 s]
	[INFO] Spark Project Shuffle Streaming Service ............ SUCCESS [  5.226 s]
	[INFO] Spark Project Unsafe ............................... SUCCESS [ 14.856 s]
	[INFO] Spark Project Launcher ............................. SUCCESS [  7.361 s]
	[INFO] Spark Project Core ................................. SUCCESS [04:43 min]
	[INFO] Spark Project ML Local Library ..................... SUCCESS [ 41.398 s]
	[INFO] Spark Project GraphX ............................... SUCCESS [ 54.497 s]
	[INFO] Spark Project Streaming ............................ SUCCESS [01:39 min]
	[INFO] Spark Project Catalyst ............................. SUCCESS [03:31 min]
	[INFO] Spark Project SQL .................................. SUCCESS [  01:03 h]
	[INFO] Spark Project ML Library ........................... FAILURE [  0.964 s]
	[INFO] Spark Project Tools ................................ SKIPPED
	[INFO] Spark Project Hive ................................. SKIPPED
	[INFO] Spark Project REPL ................................. SKIPPED
	[INFO] Spark Project Assembly ............................. SKIPPED
	[INFO] Spark Integration for Kafka 0.10 ................... SKIPPED
	[INFO] Kafka 0.10 Source for Structured Streaming ......... SKIPPED
	[INFO] Spark Project Examples ............................. SKIPPED
	[INFO] Spark Integration for Kafka 0.10 Assembly .......... SKIPPED
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD FAILURE
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 01:16 h
	[INFO] Finished at: 2018-03-05T08:45:15+00:00
	[INFO] Final Memory: 81M/738M
	[INFO] ------------------------------------------------------------------------
	[ERROR] Failed to execute goal on project spark-mllib_2.11: Could not resolve dependencies for project org.apache.spark:spark-mllib_2.11:jar:2.3.1-SNAPSHOT: Failed to collect dependencies at org.jpmml:pmml-model:jar:1.2.15: Failed to read artifact descriptor for org.jpmml:pmml-model:jar:1.2.15: Could not transfer artifact org.jpmml:pmml-model:pom:1.2.15 from/to central (https://repo.maven.apache.org/maven2): Connection reset -> [Help 1]
	[ERROR]
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR]
	[ERROR] For more information about the errors and possible solutions, please read the following articles:
	[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/DependencyResolutionException
	[ERROR]
	[ERROR] After correcting the problems, you can resume the build with the command
	[ERROR]   mvn <goals> -rf :spark-mllib_2.11
