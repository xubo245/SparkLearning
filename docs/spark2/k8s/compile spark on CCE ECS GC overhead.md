	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Summary:
	[INFO]
	[INFO] Spark Project Parent POM ........................... SUCCESS [  8.086 s]
	[INFO] Spark Project Tags ................................. SUCCESS [ 14.547 s]
	[INFO] Spark Project Sketch ............................... SUCCESS [ 18.613 s]
	[INFO] Spark Project Local DB ............................. SUCCESS [  7.437 s]
	[INFO] Spark Project Networking ........................... SUCCESS [ 14.346 s]
	[INFO] Spark Project Shuffle Streaming Service ............ SUCCESS [  4.181 s]
	[INFO] Spark Project Unsafe ............................... SUCCESS [ 11.568 s]
	[INFO] Spark Project Launcher ............................. SUCCESS [  7.328 s]
	[INFO] Spark Project Core ................................. SUCCESS [03:04 min]
	[INFO] Spark Project ML Local Library ..................... SUCCESS [ 31.000 s]
	[INFO] Spark Project GraphX ............................... SUCCESS [ 42.193 s]
	[INFO] Spark Project Streaming ............................ SUCCESS [01:10 min]
	[INFO] Spark Project Catalyst ............................. SUCCESS [02:26 min]
	[INFO] Spark Project SQL .................................. FAILURE [05:04 min]
	[INFO] Spark Project ML Library ........................... SKIPPED
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
	[INFO] Total time: 14:27 min
	[INFO] Finished at: 2018-03-05T09:49:51+00:00
	[INFO] Final Memory: 57M/657M
	[INFO] ------------------------------------------------------------------------
	[ERROR] GC overhead limit exceeded -> [Help 1]
	[ERROR]
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR]
	[ERROR] For more information about the errors and possible solutions, please read the following articles:
	[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/OutOfMemoryError




第二次：

	[WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/ProcessingTimeSuite.scala:30: class ProcessingTime in package streaming is deprecated: use Trigger.ProcessingTime(intervalMs)
	[WARNING]     def getIntervalMs(trigger: Trigger): Long = trigger.asInstanceOf[ProcessingTime].intervalMs
	[WARNING]                                                                      ^
	[WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/execution/streaming/ProcessingTimeExecutorSuite.scala:55: method apply in object ProcessingTime is deprecated: use Trigger.ProcessingTime(interval)
	[WARNING]     val executor = ProcessingTimeExecutor(ProcessingTime("1000 milliseconds"), clock)
	[WARNING]                                           ^
	[WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/streaming/StreamSuite.scala:312: method apply in object ProcessingTime is deprecated: use Trigger.ProcessingTime(interval)
	[WARNING]       StartStream(ProcessingTime("10 seconds"), new StreamManualClock),
	[WARNING]                   ^
	[WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/streaming/StreamSuite.scala:353: method apply in object ProcessingTime is deprecated: use Trigger.ProcessingTime(interval)
	[WARNING]       StartStream(ProcessingTime("10 seconds"), new StreamManualClock(60 * 1000)),
	[WARNING]                   ^
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Summary:
	[INFO]
	[INFO] Spark Project Parent POM ........................... SUCCESS [  3.112 s]
	[INFO] Spark Project Tags ................................. SUCCESS [  5.423 s]
	[INFO] Spark Project Sketch ............................... SUCCESS [  8.027 s]
	[INFO] Spark Project Local DB ............................. SUCCESS [  3.452 s]
	[INFO] Spark Project Networking ........................... SUCCESS [  7.710 s]
	[INFO] Spark Project Shuffle Streaming Service ............ SUCCESS [  3.565 s]
	[INFO] Spark Project Unsafe ............................... SUCCESS [ 11.252 s]
	[INFO] Spark Project Launcher ............................. SUCCESS [  5.882 s]
	[INFO] Spark Project Core ................................. SUCCESS [03:01 min]
	[INFO] Spark Project ML Local Library ..................... SUCCESS [ 29.246 s]
	[INFO] Spark Project GraphX ............................... SUCCESS [ 42.688 s]
	[INFO] Spark Project Streaming ............................ SUCCESS [01:13 min]
	[INFO] Spark Project Catalyst ............................. SUCCESS [02:26 min]
	[INFO] Spark Project SQL .................................. FAILURE [22:03 min]
	[INFO] Spark Project ML Library ........................... SKIPPED
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
	[INFO] Total time: 30:46 min
	[INFO] Finished at: 2018-03-05T10:43:08+00:00
	[INFO] Final Memory: 57M/713M
	[INFO] ------------------------------------------------------------------------
	[ERROR] Java heap space -> [Help 1]
	[ERROR]
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR]
	[ERROR] For more information about the errors and possible solutions, please read the following articles:
	[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/OutOfMemoryError
	You have new mail in /var/spool/mail/root
	[root@sparkonk8s-46929-p4jdl spark]#
	[root@sparkonk8s-46929-p4jdl spark]#
