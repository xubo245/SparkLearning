版本：v0.7.1.tar.gz
记录 

（2）制定版本

 	mvn clean package -Djava.version=1.7 -Dhadoop.version=2.6.0 -Dspark.version=1.5.2 -DskipTests


（1）
	
	xubo@xubo:~/cloud/tachyon-0.7.1$ mvn install
	[INFO] Scanning for projects...
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Build Order:
	[INFO] 
	[INFO] Tachyon Parent
	[INFO] Tachyon Common
	[INFO] Tachyon Under File System
	[INFO] Tachyon Under File System - Local FS
	[INFO] Tachyon Under File System - HDFS
	[INFO] Tachyon Under File System - Gluster FS
	[INFO] Tachyon Under File System - Swift
	[INFO] Tachyon Under File System - S3
	[INFO] Tachyon Clients
	[INFO] Tachyon Clients - Implementation
	[INFO] Tachyon Clients - Distribution
	[INFO] Tachyon Servers
	[INFO] Mock Tachyon Cluster
	[INFO] Tachyon Integration Tests
	[INFO] Tachyon Shell
	[INFO] Tachyon Examples
	[INFO] Tachyon Assemblies
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Parent 0.7.1
	[INFO] ------------------------------------------------------------------------
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-source-plugin/2.3/maven-source-plugin-2.3.pom
	May 05, 2016 2:10:48 PM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: I/O exception (java.net.SocketException) caught when processing request to {s}->https://repo.maven.apache.org:443: Connection reset
	May 05, 2016 2:10:48 PM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: Retrying request to {s}->https://repo.maven.apache.org:443
	May 05, 2016 2:10:51 PM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: I/O exception (java.net.SocketException) caught when processing request to {s}->https://repo.maven.apache.org:443: Connection reset
	May 05, 2016 2:10:51 PM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: Retrying request to {s}->https://repo.maven.apache.org:443
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-source-plugin/2.3/maven-source-plugin-2.3.pom (7 KB at 0.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-source-plugin/2.3/maven-source-plugin-2.3.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-source-plugin/2.3/maven-source-plugin-2.3.jar (31 KB at 18.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-javadoc-plugin/2.9/maven-javadoc-plugin-2.9.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-javadoc-plugin/2.9/maven-javadoc-plugin-2.9.pom (16 KB at 22.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-javadoc-plugin/2.9/maven-javadoc-plugin-2.9.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-javadoc-plugin/2.9/maven-javadoc-plugin-2.9.jar (354 KB at 52.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-checkstyle-plugin/2.13/maven-checkstyle-plugin-2.13.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-checkstyle-plugin/2.13/maven-checkstyle-plugin-2.13.pom (13 KB at 18.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-checkstyle-plugin/2.13/maven-checkstyle-plugin-2.13.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-checkstyle-plugin/2.13/maven-checkstyle-plugin-2.13.jar (112 KB at 34.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/com/mycila/license-maven-plugin/2.9/license-maven-plugin-2.9.pom
	Downloaded: https://repo.maven.apache.org/maven2/com/mycila/license-maven-plugin/2.9/license-maven-plugin-2.9.pom (5 KB at 5.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/com/mycila/license-maven-plugin-parent/2.9/license-maven-plugin-parent-2.9.pom
	Downloaded: https://repo.maven.apache.org/maven2/com/mycila/license-maven-plugin-parent/2.9/license-maven-plugin-parent-2.9.pom (4 KB at 5.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/com/mycila/mycila-pom/3/mycila-pom-3.pom
	Downloaded: https://repo.maven.apache.org/maven2/com/mycila/mycila-pom/3/mycila-pom-3.pom (20 KB at 18.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/com/mycila/license-maven-plugin/2.9/license-maven-plugin-2.9.jar
	Downloaded: https://repo.maven.apache.org/maven2/com/mycila/license-maven-plugin/2.9/license-maven-plugin-2.9.jar (79 KB at 20.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/2.4/maven-install-plugin-2.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/2.4/maven-install-plugin-2.4.pom (7 KB at 9.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/2.4/maven-install-plugin-2.4.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-install-plugin/2.4/maven-install-plugin-2.4.jar (27 KB at 26.8 KB/sec)
	[INFO] 
	[INFO] --- maven-enforcer-plugin:1.0:enforce (enforce-maven) @ tachyon-parent ---
	[INFO] 
	[INFO] --- maven-checkstyle-plugin:2.13:check (checkstyle) @ tachyon-parent ---
	Downloading: https://repo.maven.apache.org/maven2/com/puppycrawl/tools/checkstyle/5.9/checkstyle-5.9.pom
	Downloaded: https://repo.maven.apache.org/maven2/com/puppycrawl/tools/checkstyle/5.9/checkstyle-5.9.pom (26 KB at 24.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils-core/1.8.3/commons-beanutils-core-1.8.3.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils-core/1.8.3/commons-beanutils-core-1.8.3.pom (2 KB at 2.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/com/google/guava/guava-jdk5/14.0.1/guava-jdk5-14.0.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/com/google/guava/guava-jdk5/14.0.1/guava-jdk5-14.0.1.pom (7 KB at 9.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/com/google/guava/guava-parent-jdk5/14.0.1/guava-parent-jdk5-14.0.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/com/google/guava/guava-parent-jdk5/14.0.1/guava-parent-jdk5-14.0.1.pom (3 KB at 4.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/reporting/maven-reporting-impl/2.3/maven-reporting-impl-2.3.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/reporting/maven-reporting-impl/2.3/maven-reporting-impl-2.3.pom (5 KB at 7.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.6/maven-shared-utils-0.6.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.6/maven-shared-utils-0.6.pom (5 KB at 7.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sink-api/1.2/doxia-sink-api-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sink-api/1.2/doxia-sink-api-1.2.pom (2 KB at 2.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia/1.2/doxia-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia/1.2/doxia-1.2.pom (19 KB at 27.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/19/maven-parent-19.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/19/maven-parent-19.pom (25 KB at 36.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.2/doxia-logging-api-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.2/doxia-logging-api-1.2.pom (2 KB at 2.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-core/1.2/doxia-core-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-core/1.2/doxia-core-1.2.pom (4 KB at 5.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpclient/4.0.2/httpclient-4.0.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpclient/4.0.2/httpclient-4.0.2.pom (8 KB at 11.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-client/4.0.2/httpcomponents-client-4.0.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-client/4.0.2/httpcomponents-client-4.0.2.pom (9 KB at 13.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/project/4.1/project-4.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/project/4.1/project-4.1.pom (16 KB at 24.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcore/4.0.1/httpcore-4.0.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcore/4.0.1/httpcore-4.0.1.pom (5 KB at 7.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-core/4.0.1/httpcomponents-core-4.0.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-core/4.0.1/httpcomponents-core-4.0.1.pom (10 KB at 14.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/project/4.0/project-4.0.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/project/4.0/project-4.0.pom (13 KB at 19.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-site-renderer/1.2/doxia-site-renderer-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-site-renderer/1.2/doxia-site-renderer-1.2.pom (7 KB at 9.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sitetools/1.2/doxia-sitetools-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sitetools/1.2/doxia-sitetools-1.2.pom (16 KB at 24.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.2/doxia-decoration-model-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.2/doxia-decoration-model-1.2.pom (3 KB at 4.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-xhtml/1.2/doxia-module-xhtml-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-xhtml/1.2/doxia-module-xhtml-1.2.pom (2 KB at 2.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-modules/1.2/doxia-modules-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-modules/1.2/doxia-modules-1.2.pom (3 KB at 3.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-fml/1.2/doxia-module-fml-1.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-fml/1.2/doxia-module-fml-1.2.pom (6 KB at 8.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-validator/commons-validator/1.3.1/commons-validator-1.3.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-validator/commons-validator/1.3.1/commons-validator-1.3.1.pom (9 KB at 13.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-digester/commons-digester/1.6/commons-digester-1.6.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-digester/commons-digester/1.6/commons-digester-1.6.pom (974 B at 1.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils/1.6/commons-beanutils-1.6.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils/1.6/commons-beanutils-1.6.pom (3 KB at 3.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-logging/commons-logging/1.0/commons-logging-1.0.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-logging/commons-logging/1.0/commons-logging-1.0.pom (163 B at 0.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/2.0/commons-collections-2.0.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/2.0/commons-collections-2.0.pom (171 B at 0.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/2.1/commons-collections-2.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/2.1/commons-collections-2.1.pom (4 KB at 5.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sink-api/1.4/doxia-sink-api-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sink-api/1.4/doxia-sink-api-1.4.pom (2 KB at 2.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia/1.4/doxia-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia/1.4/doxia-1.4.pom (18 KB at 26.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.4/doxia-logging-api-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.4/doxia-logging-api-1.4.pom (2 KB at 2.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.4/doxia-decoration-model-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.4/doxia-decoration-model-1.4.pom (3 KB at 4.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sitetools/1.4/doxia-sitetools-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sitetools/1.4/doxia-sitetools-1.4.pom (17 KB at 25.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-site-renderer/1.4/doxia-site-renderer-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-site-renderer/1.4/doxia-site-renderer-1.4.pom (6 KB at 8.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-core/1.4/doxia-core-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-core/1.4/doxia-core-1.4.pom (4 KB at 6.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-xhtml/1.4/doxia-module-xhtml-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-xhtml/1.4/doxia-module-xhtml-1.4.pom (2 KB at 1.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-modules/1.4/doxia-modules-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-modules/1.4/doxia-modules-1.4.pom (3 KB at 3.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-fml/1.4/doxia-module-fml-1.4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-fml/1.4/doxia-module-fml-1.4.pom (5 KB at 7.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-tools/2.0/velocity-tools-2.0.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-tools/2.0/velocity-tools-2.0.pom (18 KB at 27.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/javax/servlet/servlet-api/2.3/servlet-api-2.3.pom
	Downloaded: https://repo.maven.apache.org/maven2/javax/servlet/servlet-api/2.3/servlet-api-2.3.pom (156 B at 0.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-chain/commons-chain/1.1/commons-chain-1.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/commons-chain/commons-chain/1.1/commons-chain-1.1.pom (6 KB at 9.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/dom4j/dom4j/1.1/dom4j-1.1.pom
	Downloaded: https://repo.maven.apache.org/maven2/dom4j/dom4j/1.1/dom4j-1.1.pom (142 B at 0.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/sslext/sslext/1.2-0/sslext-1.2-0.pom
	Downloaded: https://repo.maven.apache.org/maven2/sslext/sslext/1.2-0/sslext-1.2-0.pom (653 B at 1.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/struts/struts-core/1.3.8/struts-core-1.3.8.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/struts/struts-core/1.3.8/struts-core-1.3.8.pom (5 KB at 6.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/struts/struts-parent/1.3.8/struts-parent-1.3.8.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/struts/struts-parent/1.3.8/struts-parent-1.3.8.pom (10 KB at 14.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/struts/struts-master/4/struts-master-4.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/struts/struts-master/4/struts-master-4.pom (12 KB at 17.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/apache/2/apache-2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/apache/2/apache-2.pom (4 KB at 5.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/antlr/antlr/2.7.2/antlr-2.7.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/antlr/antlr/2.7.2/antlr-2.7.2.pom (145 B at 0.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/struts/struts-taglib/1.3.8/struts-taglib-1.3.8.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/struts/struts-taglib/1.3.8/struts-taglib-1.3.8.pom (4 KB at 4.6 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/struts/struts-tiles/1.3.8/struts-tiles-1.3.8.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/struts/struts-tiles/1.3.8/struts-tiles-1.3.8.pom (3 KB at 1.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity/1.6.2/velocity-1.6.2.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity/1.6.2/velocity-1.6.2.pom (11 KB at 10.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-integration-tools/1.6/doxia-integration-tools-1.6.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-integration-tools/1.6/doxia-integration-tools-1.6.pom (7 KB at 10.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-tools/3/doxia-tools-3.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-tools/3/doxia-tools-3.pom (10 KB at 14.8 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.6/doxia-logging-api-1.6.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.6/doxia-logging-api-1.6.pom (2 KB at 2.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia/1.6/doxia-1.6.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia/1.6/doxia-1.6.pom (19 KB at 19.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.6/doxia-decoration-model-1.6.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.6/doxia-decoration-model-1.6.pom (3 KB at 4.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sitetools/1.6/doxia-sitetools-1.6.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sitetools/1.6/doxia-sitetools-1.6.pom (18 KB at 17.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-resources/1.0-alpha-7/plexus-resources-1.0-alpha-7.pom
	Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-resources/1.0-alpha-7/plexus-resources-1.0-alpha-7.pom (2 KB at 2.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/com/puppycrawl/tools/checkstyle/5.9/checkstyle-5.9.jar
	Downloading: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils-core/1.8.3/commons-beanutils-core-1.8.3.jar
	Downloading: https://repo.maven.apache.org/maven2/com/google/guava/guava-jdk5/14.0.1/guava-jdk5-14.0.1.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/reporting/maven-reporting-impl/2.3/maven-reporting-impl-2.3.jar
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.6/maven-shared-utils-0.6.jar
	Downloaded: https://repo.maven.apache.org/maven2/com/puppycrawl/tools/checkstyle/5.9/checkstyle-5.9.jar (705 KB at 47.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-core/1.2/doxia-core-1.2.jar
	May 05, 2016 2:12:19 PM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: I/O exception (java.net.SocketException) caught when processing request to {s}->https://repo.maven.apache.org:443: Connection reset
	May 05, 2016 2:12:19 PM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: Retrying request to {s}->https://repo.maven.apache.org:443
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-core/1.2/doxia-core-1.2.jar (151 KB at 7.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpclient/4.0.2/httpclient-4.0.2.jar
	May 05, 2016 2:12:23 PM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: I/O exception (java.net.SocketException) caught when processing request to {s}->https://repo.maven.apache.org:443: Connection reset
	May 05, 2016 2:12:23 PM org.apache.maven.wagon.providers.http.httpclient.impl.execchain.RetryExec execute
	INFO: Retrying request to {s}->https://repo.maven.apache.org:443
	Downloaded: https://repo.maven.apache.org/maven2/commons-beanutils/commons-beanutils-core/1.8.3/commons-beanutils-core-1.8.3.jar (202 KB at 7.2 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcore/4.0.1/httpcore-4.0.1.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpclient/4.0.2/httpclient-4.0.2.jar (287 KB at 10.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-validator/commons-validator/1.3.1/commons-validator-1.3.1.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.6/maven-shared-utils-0.6.jar (161 KB at 5.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-digester/commons-digester/1.6/commons-digester-1.6.jar
	Downloaded: https://repo.maven.apache.org/maven2/com/google/guava/guava-jdk5/14.0.1/guava-jdk5-14.0.1.jar (1957 KB at 59.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sink-api/1.4/doxia-sink-api-1.4.jar
	Downloaded: https://repo.maven.apache.org/maven2/commons-digester/commons-digester/1.6/commons-digester-1.6.jar (165 KB at 5.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.4/doxia-logging-api-1.4.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcore/4.0.1/httpcore-4.0.1.jar (169 KB at 5.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.4/doxia-decoration-model-1.4.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sink-api/1.4/doxia-sink-api-1.4.jar (11 KB at 0.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-site-renderer/1.4/doxia-site-renderer-1.4.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.4/doxia-logging-api-1.4.jar (12 KB at 0.3 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-xhtml/1.4/doxia-module-xhtml-1.4.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-xhtml/1.4/doxia-module-xhtml-1.4.jar (16 KB at 0.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-fml/1.4/doxia-module-fml-1.4.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-site-renderer/1.4/doxia-site-renderer-1.4.jar (52 KB at 1.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-tools/2.0/velocity-tools-2.0.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-fml/1.4/doxia-module-fml-1.4.jar (37 KB at 1.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/commons-chain/commons-chain/1.1/commons-chain-1.1.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.4/doxia-decoration-model-1.4.jar (60 KB at 1.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/dom4j/dom4j/1.1/dom4j-1.1.jar
	Downloaded: https://repo.maven.apache.org/maven2/commons-chain/commons-chain/1.1/commons-chain-1.1.jar (88 KB at 2.4 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/sslext/sslext/1.2-0/sslext-1.2-0.jar
	Downloaded: https://repo.maven.apache.org/maven2/sslext/sslext/1.2-0/sslext-1.2-0.jar (26 KB at 0.7 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/struts/struts-core/1.3.8/struts-core-1.3.8.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/velocity/velocity-tools/2.0/velocity-tools-2.0.jar (339 KB at 8.9 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/struts/struts-taglib/1.3.8/struts-taglib-1.3.8.jar
	Downloaded: https://repo.maven.apache.org/maven2/commons-validator/commons-validator/1.3.1/commons-validator-1.3.1.jar (136 KB at 3.5 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/struts/struts-tiles/1.3.8/struts-tiles-1.3.8.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/struts/struts-core/1.3.8/struts-core-1.3.8.jar (322 KB at 8.0 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-integration-tools/1.6/doxia-integration-tools-1.6.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/struts/struts-taglib/1.3.8/struts-taglib-1.3.8.jar (246 KB at 6.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-9/plexus-container-default-1.0-alpha-9.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-integration-tools/1.6/doxia-integration-tools-1.6.jar (44 KB at 1.1 KB/sec)
	Downloading: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-resources/1.0-alpha-7/plexus-resources-1.0-alpha-7.jar
	Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-resources/1.0-alpha-7/plexus-resources-1.0-alpha-7.jar (23 KB at 0.5 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-9/plexus-container-default-1.0-alpha-9.jar (191 KB at 4.5 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/org/apache/struts/struts-tiles/1.3.8/struts-tiles-1.3.8.jar (117 KB at 2.5 KB/sec)
	Downloaded: https://repo.maven.apache.org/maven2/dom4j/dom4j/1.1/dom4j-1.1.jar (447 KB at 8.5 KB/sec)
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Summary:
	[INFO] 
	[INFO] Tachyon Parent ..................................... FAILURE [31:36 min]
	[INFO] Tachyon Common ..................................... SKIPPED
	[INFO] Tachyon Under File System .......................... SKIPPED
	[INFO] Tachyon Under File System - Local FS ............... SKIPPED
	[INFO] Tachyon Under File System - HDFS ................... SKIPPED
	[INFO] Tachyon Under File System - Gluster FS ............. SKIPPED
	[INFO] Tachyon Under File System - Swift .................. SKIPPED
	[INFO] Tachyon Under File System - S3 ..................... SKIPPED
	[INFO] Tachyon Clients .................................... SKIPPED
	[INFO] Tachyon Clients - Implementation ................... SKIPPED
	[INFO] Tachyon Clients - Distribution ..................... SKIPPED
	[INFO] Tachyon Servers .................................... SKIPPED
	[INFO] Mock Tachyon Cluster ............................... SKIPPED
	[INFO] Tachyon Integration Tests .......................... SKIPPED
	[INFO] Tachyon Shell ...................................... SKIPPED
	[INFO] Tachyon Examples ................................... SKIPPED
	[INFO] Tachyon Assemblies ................................. SKIPPED
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD FAILURE
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 31:36 min
	[INFO] Finished at: 2016-05-05T14:42:18+08:00
	[INFO] Final Memory: 16M/170M
	[INFO] ------------------------------------------------------------------------
	[ERROR] Failed to execute goal org.apache.maven.plugins:maven-checkstyle-plugin:2.13:check (checkstyle) on project tachyon-parent: Execution checkstyle of goal org.apache.maven.plugins:maven-checkstyle-plugin:2.13:check failed: Plugin org.apache.maven.plugins:maven-checkstyle-plugin:2.13 or one of its dependencies could not be resolved: Could not transfer artifact org.apache.maven.reporting:maven-reporting-impl:jar:2.3 from/to central (https://repo.maven.apache.org/maven2): Read timed out -> [Help 1]
	[ERROR] 
	[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
	[ERROR] Re-run Maven using the -X switch to enable full debug logging.
	[ERROR] 
	[ERROR] For more information about the errors and possible solutions, please read the following articles:
	[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/PluginResolutionException
	xubo@xubo:~/cloud/tachyon-0.7.1$ mvn clean
	[INFO] Scanning for projects...
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Build Order:
	[INFO] 
	[INFO] Tachyon Parent
	[INFO] Tachyon Common
	[INFO] Tachyon Under File System
	[INFO] Tachyon Under File System - Local FS
	[INFO] Tachyon Under File System - HDFS
	[INFO] Tachyon Under File System - Gluster FS
	[INFO] Tachyon Under File System - Swift
	[INFO] Tachyon Under File System - S3
	[INFO] Tachyon Clients
	[INFO] Tachyon Clients - Implementation
	[INFO] Tachyon Clients - Distribution
	[INFO] Tachyon Servers
	[INFO] Mock Tachyon Cluster
	[INFO] Tachyon Integration Tests
	[INFO] Tachyon Shell
	[INFO] Tachyon Examples
	[INFO] Tachyon Assemblies
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Parent 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-parent ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Common 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-common ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Under File System 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-underfs ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Under File System - Local FS 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-underfs-local ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Under File System - HDFS 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-underfs-hdfs ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Under File System - Gluster FS 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-underfs-glusterfs ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Under File System - Swift 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-underfs-swift ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Under File System - S3 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-underfs-s3 ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Clients 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-clients ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Clients - Implementation 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-client-unshaded ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Clients - Distribution 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-client ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Servers 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-servers ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Mock Tachyon Cluster 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-minicluster ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Integration Tests 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-integration-tests ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Shell 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-shell ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Examples 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-examples ---
	[INFO]                                                                         
	[INFO] ------------------------------------------------------------------------
	[INFO] Building Tachyon Assemblies 0.7.1
	[INFO] ------------------------------------------------------------------------
	[INFO] 
	[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ tachyon-assemblies ---
	[INFO] ------------------------------------------------------------------------
	[INFO] Reactor Summary:
	[INFO] 
	[INFO] Tachyon Parent ..................................... SUCCESS [  0.564 s]
	[INFO] Tachyon Common ..................................... SUCCESS [  0.004 s]
	[INFO] Tachyon Under File System .......................... SUCCESS [  0.003 s]
	[INFO] Tachyon Under File System - Local FS ............... SUCCESS [  0.003 s]
	[INFO] Tachyon Under File System - HDFS ................... SUCCESS [  0.003 s]
	[INFO] Tachyon Under File System - Gluster FS ............. SUCCESS [  0.004 s]
	[INFO] Tachyon Under File System - Swift .................. SUCCESS [  0.003 s]
	[INFO] Tachyon Under File System - S3 ..................... SUCCESS [  0.003 s]
	[INFO] Tachyon Clients .................................... SUCCESS [  0.003 s]
	[INFO] Tachyon Clients - Implementation ................... SUCCESS [  0.003 s]
	[INFO] Tachyon Clients - Distribution ..................... SUCCESS [  0.004 s]
	[INFO] Tachyon Servers .................................... SUCCESS [  0.059 s]
	[INFO] Mock Tachyon Cluster ............................... SUCCESS [  0.012 s]
	[INFO] Tachyon Integration Tests .......................... SUCCESS [  0.004 s]
	[INFO] Tachyon Shell ...................................... SUCCESS [  0.004 s]
	[INFO] Tachyon Examples ................................... SUCCESS [  0.013 s]
	[INFO] Tachyon Assemblies ................................. SUCCESS [  0.004 s]
	[INFO] ------------------------------------------------------------------------
	[INFO] BUILD SUCCESS
	[INFO] ------------------------------------------------------------------------
	[INFO] Total time: 1.234 s
	[INFO] Finished at: 2016-05-05T14:45:57+08:00
	[INFO] Final Memory: 11M/104M
	[INFO] ------------------------------------------------------------------------


参考：
【1】http://blog.csdn.net/stark_summer/article/details/48321605

