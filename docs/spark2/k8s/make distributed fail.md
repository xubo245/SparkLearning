	Authenticating with public key "imported-openssh-key"
	     ┌────────────────────────────────────────────────────────────────────┐
	     │                        • MobaXterm 10.5 •                          │
	     │            (SSH client, X-server and networking tools)             │
	     │                                                                    │
	     │ ➤ SSH session to root@49.4.69.6                                    │
	     │   • SSH compression : ✔                                            │
	     │   • SSH-browser     : ✔                                            │
	     │   • X11-forwarding  : ✘  (disabled or not supported by server)     │
	     │   • DISPLAY         : 10.229.32.110:0.0                            │
	     │                                                                    │
	     │ ➤ For more info, ctrl+click on help or visit our website           │
	     └────────────────────────────────────────────────────────────────────┘
	
	
	Authorized users only. All activities may be monitored and reported.
	Last login: Sat Mar  3 09:50:05 2018 from 119.145.15.121
	  ######################################################################
	  #                              Notice                                #
	  #                                                                    #
	  #  1. Please DO NOT upgrade the kernel, as the kernel upgrade would  #
	  #   damage the original operating system.                            #
	  #                                                                    #
	  #  2. Please create unique passwords that use a combination of words,#
	  #   numbers, symbols, and both upper-case and lower-case letters.    #
	  #   Avoid using simple adjacent keyboard combinations such as        #
	  #   "Qwert!234","Qaz2wsx",etc.                                       #
	  #                                                                    #
	  #  3. Unless necessary, please DO NOT open or use high-risk ports,   #
	  #   such as Telnet-23, FTP-20/21, NTP-123(UDP), RDP-3389,            #
	  #   SSH/SFTP-22, Mysql-3306, SQL-1433,etc.                           #
	  #                                                                    #
	  #                                                                    #
	  #                     Any questions please contact 4000-955-988      #
	  ######################################################################
	[root@sparkonk8s-46929-p4jdl ~]# cd spark/
	[root@sparkonk8s-46929-p4jdl spark]# ls
	appveyor.yml  bin    common  CONTRIBUTING.md  data  docs      external  hadoop-cloud  LICENSE   mllib        NOTICE   project  R          repl               sbin                   sql        tools
	assembly      build  conf    core             dev   examples  graphx    launcher      licenses  mllib-local  pom.xml  python   README.md  resource-managers  scalastyle-config.xml  streaming
	[root@sparkonk8s-46929-p4jdl spark]# ./dev/make-distribution.sh --name custom-spark --pip --r --tgz -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes
	+++ dirname ./dev/make-distribution.sh
	++ cd ./dev/..
	++ pwd
	+ SPARK_HOME=/root/spark
	+ DISTDIR=/root/spark/dist
	+ MAKE_TGZ=false
	+ MAKE_PIP=false
	+ MAKE_R=false
	+ NAME=none
	+ MVN=/root/spark/build/mvn
	+ ((  12  ))
	+ case $1 in
	+ NAME=custom-spark
	+ shift
	+ shift
	+ ((  10  ))
	+ case $1 in
	+ MAKE_PIP=true
	+ shift
	+ ((  9  ))
	+ case $1 in
	+ MAKE_R=true
	+ shift
	+ ((  8  ))
	+ case $1 in
	+ MAKE_TGZ=true
	+ shift
	+ ((  7  ))
	+ case $1 in
	+ break
	+ '[' -z /usr/lib/jvm/java-openjdk ']'
	+ '[' -z /usr/lib/jvm/java-openjdk ']'
	++ command -v git
	+ '[' /usr/bin/git ']'
	++ git rev-parse --short HEAD
	+ GITREV=56cfbd9
	+ '[' '!' -z 56cfbd9 ']'
	+ GITREVSTRING=' (git revision 56cfbd9)'
	+ unset GITREV
	++ command -v /root/spark/build/mvn
	+ '[' '!' /root/spark/build/mvn ']'
	++ tail -n 1
	++ grep -v INFO
	++ /root/spark/build/mvn help:evaluate -Dexpression=project.version -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes
	+ VERSION=2.3.1-SNAPSHOT
	++ /root/spark/build/mvn help:evaluate -Dexpression=scala.binary.version -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes
	++ grep -v INFO
	++ tail -n 1
	+ SCALA_VERSION=2.11
	++ /root/spark/build/mvn help:evaluate -Dexpression=hadoop.version -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes
	++ tail -n 1
	++ grep -v INFO
	+ SPARK_HADOOP_VERSION=2.7.3
	++ /root/spark/build/mvn help:evaluate -Dexpression=project.activeProfiles -pl sql/hive -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes
	++ grep -v INFO
	++ fgrep --count '<id>hive</id>'
	++ echo -n
	+ SPARK_HIVE=1
	+ '[' custom-spark == none ']'
	+ echo 'Spark version is 2.3.1-SNAPSHOT'
	Spark version is 2.3.1-SNAPSHOT
	+ '[' true == true ']'
	+ echo 'Making spark-2.3.1-SNAPSHOT-bin-custom-spark.tgz'
	Making spark-2.3.1-SNAPSHOT-bin-custom-spark.tgz
	+ cd /root/spark
	+ export 'MAVEN_OPTS=-Xmx2g -XX:ReservedCodeCacheSize=512m'
	+ MAVEN_OPTS='-Xmx2g -XX:ReservedCodeCacheSize=512m'
	+ BUILD_COMMAND=("$MVN" -T 1C clean package -DskipTests $@)
	+ echo -e '\nBuilding with...'
	
	Building with...
	+ echo -e '$ /root/spark/build/mvn' -T 1C clean package -DskipTests -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn '-Pkubernetes\n'
	$ /root/spark/build/mvn -T 1C clean package -DskipTests -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes
	
	+ /root/spark/build/mvn -T 1C clean package -DskipTests -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes
	Using `mvn` from path: /root/xubo/tools/apache-maven-3.3.9/bin/mvn
	[INFO] Scanning for projects...
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Build Order:
	[INFO]
	[INFO] Spark Project Parent POM
	[INFO] Spark Project Tags
	[INFO] Spark Project Sketch
	[INFO] Spark Project Local DB
	[INFO] Spark Project Networking
	[INFO] Spark Project Shuffle Streaming Service
	[INFO] Spark Project Unsafe
	[INFO] Spark Project Launcher
	[INFO] Spark Project Core
	[INFO] Spark Project ML Local Library
	[INFO] Spark Project GraphX
	[INFO] Spark Project Streaming
	[INFO] Spark Project Catalyst
	[INFO] Spark Project SQL
	[INFO] Spark Project ML Library
	[INFO] Spark Project Tools
	[INFO] Spark Project Hive
	[INFO] Spark Project REPL
	[INFO] Spark Project YARN Shuffle Service
	[INFO] Spark Project YARN
	[INFO] Spark Project Mesos
	[INFO] Spark Project Kubernetes
	[INFO] Spark Project Hive Thrift Server
	[INFO] Spark Project Assembly
	[INFO] Spark Integration for Kafka 0.10
	[INFO] Kafka 0.10 Source for Structured Streaming
	[INFO] Spark Project Examples
	[INFO] Spark Integration for Kafka 0.10 Assembly
	[INFO]
	[INFO] Using the MultiThreadedBuilder implementation with a thread count of 2
	[INFO]
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Spark Project Parent POM 2.3.1-SNAPSHOT
	[INFO] ------------------------------------------------------------------------
	[INFO]
	[INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-parent_2.11 ---
	[INFO]
	[INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-parent_2.11 ---
	[WARNING] Rule 1: org.apache.maven.plugins.enforcer.RequireJavaVersion failed with message:
	Detected JDK Version: 1.7.0-161 is not in the allowed range 1.8.
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Summary:
	[INFO]
	[INFO] Spark Project Parent POM ........................... FAILURE [  1.996 s]
	[INFO] Spark Project Tags ................................. SKIPPED
	[INFO] Spark Project Sketch ............................... SKIPPED
	[INFO] Spark Project Local DB ............................. SKIPPED
	[INFO] Spark Project Networking ........................... SKIPPED
	[INFO] Spark Project Shuffle Streaming Service ............ SKIPPED
	[INFO] Spark Project Unsafe ............................... SKIPPED
	[INFO] Spark Project Launcher ............................. SKIPPED
	[INFO] Spark Project Core ................................. SKIPPED
	[INFO] Spark Project ML Local Library ..................... SKIPPED
	[INFO] Spark Project GraphX ............................... SKIPPED
	[INFO] Spark Project Streaming ............................ SKIPPED
	[INFO] Spark Project Catalyst ............................. SKIPPED
	[INFO] Spark Project SQL .................................. SKIPPED
	[INFO] Spark Project ML Library ........................... SKIPPED
	[INFO] Spark Project Tools ................................ SKIPPED
	[INFO] Spark Project Hive ................................. SKIPPED
	[INFO] Spark Project REPL ................................. SKIPPED
	[INFO] Spark Project YARN Shuffle Service ................. SKIPPED
	[INFO] Spark Project YARN ................................. SKIPPED
	[INFO] Spark Project Mesos ................................ SKIPPED
	[INFO] Spark Project Kubernetes ........................... SKIPPED
	[INFO] Spark Project Hive Thrift Server ................... SKIPPED
	[INFO] Spark Project Assembly ............................. SKIPPED
	[INFO] Spark Integration for Kafka 0.10 ................... SKIPPED
	[INFO] Kafka 0.10 Source for Structured Streaming ......... SKIPPED
	[INFO] Spark Project Examples ............................. SKIPPED
	[INFO] Spark Integration for Kafka 0.10 Assembly .......... SKIPPED
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD FAILURE
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 4.216 s (Wall Clock)
	[INFO] Finished at: 2018-03-03T12:22:49+00:00
	[INFO] Final Memory: 29M/143M
	[INFO] ------------------------------------------------------------------------
	[ERROR] Failed to execute goal org.apache.maven.plugins:maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) on project spark-parent_2.11: Some Enforcer rules have failed. Look above for specific messages explaining why the rule failed. -> [Help 1]
	[ERROR]
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR]
	[ERROR] For more information about the errors and possible solutions, please read the following articles:
	[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
	[root@sparkonk8s-46929-p4jdl spark]#
