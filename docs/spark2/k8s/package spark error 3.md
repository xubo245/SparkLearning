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
  Last login: Mon Mar  5 13:15:13 2018 from 119.145.15.121
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
  [root@sparkonk8s-46929-p4jdl spark]# mvn -DskipTests clean package
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
  [INFO] Spark Project Assembly
  [INFO] Spark Integration for Kafka 0.10
  [INFO] Kafka 0.10 Source for Structured Streaming
  [INFO] Spark Project Examples
  [INFO] Spark Integration for Kafka 0.10 Assembly
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Parent POM 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-parent_2.11 ---
  [INFO] Deleting /root/spark/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-parent_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-parent_2.11 ---
  [INFO] Add Source directory: /root/spark/src/main/scala
  [INFO] Add Test Source directory: /root/spark/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-parent_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-parent_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-parent_2.11 ---
  [INFO] No sources to compile
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-parent_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-parent_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-parent_2.11 ---
  [INFO] No sources to compile
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-parent_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-parent_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-parent_2.11 ---
  [INFO] Building jar: /root/spark/target/spark-parent_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-parent_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-parent_2.11 ---
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-parent_2.11 ---
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-parent_2.11 ---
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Tags 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-tags_2.11 ---
  [INFO] Deleting /root/spark/common/tags/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-tags_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-tags_2.11 ---
  [INFO] Add Source directory: /root/spark/common/tags/src/main/scala
  [INFO] Add Test Source directory: /root/spark/common/tags/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-tags_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-tags_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-tags_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/common/tags/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-tags_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-tags_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 2 Scala sources and 6 Java sources to /root/spark/common/tags/target/scala-2.11/classes...
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-tags_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/common/tags/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-tags_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/common/tags/src/test/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-tags_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-tags_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-tags_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 3 Java sources to /root/spark/common/tags/target/scala-2.11/test-classes...
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-tags_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-tags_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-tags_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-tags_2.11 ---
  [INFO] Building jar: /root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-tags_2.11 ---
  [INFO] Building jar: /root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-tags_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-tags_2.11 ---
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar with /root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/common/tags/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-tags_2.11 ---
  [INFO] Building jar: /root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-tags_2.11 ---
  [INFO] Building jar: /root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Sketch 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-sketch_2.11 ---
  [INFO] Deleting /root/spark/common/sketch/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-sketch_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-sketch_2.11 ---
  [INFO] Add Source directory: /root/spark/common/sketch/src/main/scala
  [INFO] Add Test Source directory: /root/spark/common/sketch/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-sketch_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-sketch_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-sketch_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/common/sketch/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-sketch_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-sketch_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 9 Java sources to /root/spark/common/sketch/target/scala-2.11/classes...
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-sketch_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/common/sketch/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-sketch_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/common/sketch/src/test/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-sketch_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-sketch_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-sketch_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 3 Scala sources to /root/spark/common/sketch/target/scala-2.11/test-classes...
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-sketch_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-sketch_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-sketch_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-sketch_2.11 ---
  [INFO] Building jar: /root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-sketch_2.11 ---
  [INFO] Building jar: /root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-sketch_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-sketch_2.11 ---
  [INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT.jar with /root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/common/sketch/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-sketch_2.11 ---
  [INFO] Building jar: /root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-sketch_2.11 ---
  [INFO] Building jar: /root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Local DB 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-kvstore_2.11 ---
  [INFO] Deleting /root/spark/common/kvstore/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-kvstore_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-kvstore_2.11 ---
  [INFO] Add Source directory: /root/spark/common/kvstore/src/main/scala
  [INFO] Add Test Source directory: /root/spark/common/kvstore/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-kvstore_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-kvstore_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-kvstore_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/common/kvstore/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-kvstore_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-kvstore_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 12 Java sources to /root/spark/common/kvstore/target/scala-2.11/classes...
  [WARNING] /root/spark/common/kvstore/src/main/java/org/apache/spark/util/kvstore/LevelDB.java:237: warning: [rawtypes] found raw type: LevelDBIterator
  [WARNING]   void closeIterator(LevelDBIterator it) throws IOException {
  [WARNING]                      ^
  [WARNING]   missing type arguments for generic class LevelDBIterator<T>
  [WARNING]   where T is a type-variable:
  [WARNING]     T extends Object declared in class LevelDBIterator
  [WARNING] 1 warning
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-kvstore_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/common/kvstore/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-kvstore_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 1 resource
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-kvstore_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-kvstore_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-kvstore_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 10 Java sources to /root/spark/common/kvstore/target/scala-2.11/test-classes...
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-kvstore_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-kvstore_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-kvstore_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-kvstore_2.11 ---
  [INFO] Building jar: /root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-kvstore_2.11 ---
  [INFO] Building jar: /root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-kvstore_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-kvstore_2.11 ---
  [INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.fusesource.leveldbjni:leveldbjni-all:jar:1.8 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-core:jar:2.6.7 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-databind:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-annotations:jar:2.6.7 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar with /root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/common/kvstore/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-kvstore_2.11 ---
  [INFO] Building jar: /root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-kvstore_2.11 ---
  [INFO] Building jar: /root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Networking 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-network-common_2.11 ---
  [INFO] Deleting /root/spark/common/network-common/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-network-common_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-network-common_2.11 ---
  [INFO] Add Source directory: /root/spark/common/network-common/src/main/scala
  [INFO] Add Test Source directory: /root/spark/common/network-common/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-network-common_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-network-common_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-network-common_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/common/network-common/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-network-common_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-network-common_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 75 Java sources to /root/spark/common/network-common/target/scala-2.11/classes...
  [WARNING] /root/spark/common/network-common/src/main/java/org/apache/spark/network/server/TransportServer.java:149: warning: [deprecation] group() in AbstractBootstrap has been deprecated
  [WARNING]     if (bootstrap != null && bootstrap.group() != null) {
  [WARNING]                                       ^
  [WARNING] /root/spark/common/network-common/src/main/java/org/apache/spark/network/server/TransportServer.java:150: warning: [deprecation] group() in AbstractBootstrap has been deprecated
  [WARNING]       bootstrap.group().shutdownGracefully();
  [WARNING]                ^
  [WARNING] /root/spark/common/network-common/src/main/java/org/apache/spark/network/server/TransportServer.java:152: warning: [deprecation] childGroup() in ServerBootstrap has been deprecated
  [WARNING]     if (bootstrap != null && bootstrap.childGroup() != null) {
  [WARNING]                                       ^
  [WARNING] /root/spark/common/network-common/src/main/java/org/apache/spark/network/server/TransportServer.java:153: warning: [deprecation] childGroup() in ServerBootstrap has been deprecated
  [WARNING]       bootstrap.childGroup().shutdownGracefully();
  [WARNING]                ^
  [WARNING] /root/spark/common/network-common/src/main/java/org/apache/spark/network/util/NettyUtils.java:112: warning: [deprecation] PooledByteBufAllocator(boolean,int,int,int,int,int,int,int) in PooledByteBufAllocator has been deprecated
  [WARNING]     return new PooledByteBufAllocator(
  [WARNING]            ^
  [WARNING] /root/spark/common/network-common/src/main/java/org/apache/spark/network/crypto/TransportCipher.java:270: warning: [deprecation] transfered() in FileRegion has been deprecated
  [WARNING]         region.transferTo(byteRawChannel, region.transfered());
  [WARNING]                                                 ^
  [WARNING] /root/spark/common/network-common/src/main/java/org/apache/spark/network/sasl/SaslEncryption.java:300: warning: [deprecation] transfered() in FileRegion has been deprecated
  [WARNING]         region.transferTo(byteChannel, region.transfered());
  [WARNING]                                              ^
  [WARNING] 7 warnings
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-network-common_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/common/network-common/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-network-common_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 1 resource
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-network-common_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-network-common_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/org/mockito/mockito-core/1.10.19/mockito-core-1.10.19.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-network-common_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 19 Java sources to /root/spark/common/network-common/target/scala-2.11/test-classes...
  [WARNING] /root/spark/common/network-common/src/test/java/org/apache/spark/network/ProtocolSuite.java:119: warning: [deprecation] transfered() in FileRegion has been deprecated
  [WARNING]       while (in.transfered() < in.count()) {
  [WARNING]                ^
  [WARNING] /root/spark/common/network-common/src/test/java/org/apache/spark/network/ProtocolSuite.java:120: warning: [deprecation] transfered() in FileRegion has been deprecated
  [WARNING]         in.transferTo(channel, in.transfered());
  [WARNING]                                  ^
  [WARNING] 2 warnings
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-network-common_2.11 ---
  [INFO] Building jar: /root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-network-common_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-network-common_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-network-common_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-network-common_2.11 ---
  [INFO] Building jar: /root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-network-common_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-network-common_2.11 ---
  [INFO] Excluding io.netty:netty-all:jar:4.1.17.Final from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-lang3:jar:3.5 from the shaded jar.
  [INFO] Excluding org.fusesource.leveldbjni:leveldbjni-all:jar:1.8 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-databind:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-core:jar:2.6.7 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-annotations:jar:2.6.7 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-core:jar:3.1.5 from the shaded jar.
  [INFO] Excluding com.google.code.findbugs:jsr305:jar:1.3.9 from the shaded jar.
  [INFO] Including com.google.guava:guava:jar:14.0.1 in the shaded jar.
  [INFO] Excluding org.apache.commons:commons-crypto:jar:1.0.0 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar with /root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/common/network-common/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-network-common_2.11 ---
  [INFO] Building jar: /root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-network-common_2.11 ---
  [INFO] Building jar: /root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Shuffle Streaming Service 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-network-shuffle_2.11 ---
  [INFO] Deleting /root/spark/common/network-shuffle/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-network-shuffle_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-network-shuffle_2.11 ---
  [INFO] Add Source directory: /root/spark/common/network-shuffle/src/main/scala
  [INFO] Add Test Source directory: /root/spark/common/network-shuffle/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-network-shuffle_2.11 ---
  [INFO] Dependencies classpath:
  /root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-network-shuffle_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-network-shuffle_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/common/network-shuffle/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-network-shuffle_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-network-shuffle_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 20 Java sources to /root/spark/common/network-shuffle/target/scala-2.11/classes...
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-network-shuffle_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/common/network-shuffle/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-network-shuffle_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 1 resource
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-network-shuffle_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-network-shuffle_2.11 ---
  [INFO] Dependencies classpath:
  /root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/org/mockito/mockito-core/1.10.19/mockito-core-1.10.19.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-network-shuffle_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 11 Java sources to /root/spark/common/network-shuffle/target/scala-2.11/test-classes...
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-network-shuffle_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-network-shuffle_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-network-shuffle_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-network-shuffle_2.11 ---
  [INFO] Building jar: /root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-network-shuffle_2.11 ---
  [INFO] Building jar: /root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-network-shuffle_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-network-shuffle_2.11 ---
  [INFO] Excluding org.apache.spark:spark-network-common_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding io.netty:netty-all:jar:4.1.17.Final from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-lang3:jar:3.5 from the shaded jar.
  [INFO] Excluding org.fusesource.leveldbjni:leveldbjni-all:jar:1.8 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-databind:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-core:jar:2.6.7 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-annotations:jar:2.6.7 from the shaded jar.
  [INFO] Excluding com.google.code.findbugs:jsr305:jar:1.3.9 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-crypto:jar:1.0.0 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-core:jar:3.1.5 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar with /root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/common/network-shuffle/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-network-shuffle_2.11 ---
  [INFO] Building jar: /root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-network-shuffle_2.11 ---
  [INFO] Building jar: /root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Unsafe 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-unsafe_2.11 ---
  [INFO] Deleting /root/spark/common/unsafe/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-unsafe_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-unsafe_2.11 ---
  [INFO] Add Source directory: /root/spark/common/unsafe/src/main/scala
  [INFO] Add Test Source directory: /root/spark/common/unsafe/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-unsafe_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-unsafe_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-unsafe_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/common/unsafe/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-unsafe_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-unsafe_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 16 Java sources to /root/spark/common/unsafe/target/scala-2.11/classes...
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-unsafe_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/common/unsafe/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-unsafe_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/common/unsafe/src/test/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-unsafe_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-unsafe_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/mockito/mockito-core/1.10.19/mockito-core-1.10.19.jar:/root/.m2/repository/org/scalacheck/scalacheck_2.11/1.13.5/scalacheck_2.11-1.13.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-unsafe_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 1 Scala source and 5 Java sources to /root/spark/common/unsafe/target/scala-2.11/test-classes...
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-unsafe_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-unsafe_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-unsafe_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-unsafe_2.11 ---
  [INFO] Building jar: /root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-unsafe_2.11 ---
  [INFO] Building jar: /root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-unsafe_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-unsafe_2.11 ---
  [INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Excluding com.twitter:chill_2.11:jar:0.8.4 from the shaded jar.
  [INFO] Excluding com.twitter:chill-java:jar:0.8.4 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:kryo-shaded:jar:3.0.3 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:minlog:jar:1.3.0 from the shaded jar.
  [INFO] Excluding com.google.code.findbugs:jsr305:jar:1.3.9 from the shaded jar.
  [INFO] Excluding org.objenesis:objenesis:jar:2.1 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar with /root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/common/unsafe/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-unsafe_2.11 ---
  [INFO] Building jar: /root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-unsafe_2.11 ---
  [INFO] Building jar: /root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Launcher 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-launcher_2.11 ---
  [INFO] Deleting /root/spark/launcher/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-launcher_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-launcher_2.11 ---
  [INFO] Add Source directory: /root/spark/launcher/src/main/scala
  [INFO] Add Test Source directory: /root/spark/launcher/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-launcher_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/javax/activation/activation/1.1/activation-1.1.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-launcher_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-launcher_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/launcher/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-launcher_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-launcher_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 20 Java sources to /root/spark/launcher/target/scala-2.11/classes...
  [WARNING] /root/spark/launcher/src/main/java/org/apache/spark/launcher/AbstractLauncher.java:31: warning: [rawtypes] found raw type: AbstractLauncher
  [WARNING] public abstract class AbstractLauncher<T extends AbstractLauncher> {
  [WARNING]                                                  ^
  [WARNING]   missing type arguments for generic class AbstractLauncher<T>
  [WARNING]   where T is a type-variable:
  [WARNING]     T extends AbstractLauncher declared in class AbstractLauncher
  [WARNING] 1 warning
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-launcher_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/launcher/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-launcher_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 2 resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-launcher_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-launcher_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/org/mockito/mockito-core/1.10.19/mockito-core-1.10.19.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/xml-apis/xml-apis/1.4.01/xml-apis-1.4.01.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/javax/activation/activation/1.1/activation-1.1.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/root/.m2/repository/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-launcher_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 7 Java sources to /root/spark/launcher/target/scala-2.11/test-classes...
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-launcher_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-launcher_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-launcher_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-launcher_2.11 ---
  [INFO] Building jar: /root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-launcher_2.11 ---
  [INFO] Building jar: /root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-launcher_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-launcher_2.11 ---
  [INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Excluding commons-cli:commons-cli:jar:1.2 from the shaded jar.
  [INFO] Excluding commons-codec:commons-codec:jar:1.10 from the shaded jar.
  [INFO] Excluding commons-io:commons-io:jar:2.4 from the shaded jar.
  [INFO] Excluding commons-lang:commons-lang:jar:2.6 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-core-asl:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.apache.avro:avro:jar:1.7.7 from the shaded jar.
  [INFO] Excluding com.thoughtworks.paranamer:paranamer:jar:2.8 from the shaded jar.
  [INFO] Excluding org.xerial.snappy:snappy-java:jar:1.1.2.6 from the shaded jar.
  [INFO] Excluding com.google.protobuf:protobuf-java:jar:2.5.0 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-framework:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-client:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-recipes:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.zookeeper:zookeeper:jar:3.4.6 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-compress:jar:1.4.1 from the shaded jar.
  [INFO] Excluding org.tukaani:xz:jar:1.0 from the shaded jar.
  [INFO] Excluding org.mortbay.jetty:jetty-util:jar:6.1.26 from the shaded jar.
  [INFO] Excluding io.netty:netty:jar:3.9.9.Final from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-client:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-api:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding javax.xml.bind:jaxb-api:jar:2.2.2 from the shaded jar.
  [INFO] Excluding javax.xml.stream:stax-api:jar:1.0-2 from the shaded jar.
  [INFO] Excluding javax.activation:activation:jar:1.1 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-jaxrs:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-xc:jar:1.9.13 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar with /root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/launcher/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-launcher_2.11 ---
  [INFO] Building jar: /root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-launcher_2.11 ---
  [INFO] Building jar: /root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Core 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-core_2.11 ---
  [INFO] Deleting /root/spark/core/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-core_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-core_2.11 ---
  [INFO] Add Source directory: /root/spark/core/src/main/scala
  [INFO] Add Test Source directory: /root/spark/core/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-core_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/eclipse/jetty/jetty-continuation/9.3.20.v20170531/jetty-continuation-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlets/9.3.20.v20170531/jetty-servlets-9.3.20.v20170531.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/org/eclipse/jetty/jetty-xml/9.3.20.v20170531/jetty-xml-9.3.20.v20170531.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/eclipse/jetty/jetty-server/9.3.20.v20170531/jetty-server-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/.m2/repository/org/eclipse/jetty/jetty-client/9.3.20.v20170531/jetty-client-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-util/9.3.20.v20170531/jetty-util-9.3.20.v20170531.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/com/twitter/parquet-hadoop-bundle/1.6.0/parquet-hadoop-bundle-1.6.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-proxy/9.3.20.v20170531/jetty-proxy-9.3.20.v20170531.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/eclipse/jetty/jetty-webapp/9.3.20.v20170531/jetty-webapp-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-http/9.3.20.v20170531/jetty-http-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-security/9.3.20.v20170531/jetty-security-9.3.20.v20170531.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-io/9.3.20.v20170531/jetty-io-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-plus/9.3.20.v20170531/jetty-plus-9.3.20.v20170531.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/org/eclipse/jetty/jetty-jndi/9.3.20.v20170531/jetty-jndi-9.3.20.v20170531.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlet/9.3.20.v20170531/jetty-servlet-9.3.20.v20170531.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-core_2.11 ---
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (default) @ spark-core_2.11 ---
  [INFO] Executing tasks

  main:
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-core_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 37 resources
  [INFO] Copying 1 resource
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-core_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-core_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 487 Scala sources and 77 Java sources to /root/spark/core/target/scala-2.11/classes...
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/SparkContext.scala:1725: method getExecutorStorageStatus in class SparkContext is deprecated: This method may change or be removed in a future release.
  [WARNING]     StorageUtils.updateRddInfo(rddInfos, getExecutorStorageStatus)
  [WARNING]                                          ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/api/r/RBackend.scala:93: method group in class AbstractBootstrap is deprecated: see corresponding Javadoc for more information.
  [WARNING]     if (bootstrap != null && bootstrap.group() != null) {
  [WARNING]                                        ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/api/r/RBackend.scala:94: method group in class AbstractBootstrap is deprecated: see corresponding Javadoc for more information.
  [WARNING]       bootstrap.group().shutdownGracefully()
  [WARNING]                 ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/api/r/RBackend.scala:96: method childGroup in class ServerBootstrap is deprecated: see corresponding Javadoc for more information.
  [WARNING]     if (bootstrap != null && bootstrap.childGroup() != null) {
  [WARNING]                                        ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/api/r/RBackend.scala:97: method childGroup in class ServerBootstrap is deprecated: see corresponding Javadoc for more information.
  [WARNING]       bootstrap.childGroup().shutdownGracefully()
  [WARNING]                 ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/scheduler/StageInfo.scala:59: value attemptId in class StageInfo is deprecated: Use attemptNumber instead
  [WARNING]   def attemptNumber(): Int = attemptId
  [WARNING]                              ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/storage/BlockManagerMaster.scala:169: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]   def getStorageStatus: Array[StorageStatus] = {
  [WARNING]                         ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/storage/BlockManagerMaster.scala:170: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]     driverEndpoint.askSync[Array[StorageStatus]](GetStorageStatus)
  [WARNING]                            ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/storage/BlockManagerMasterEndpoint.scala:286: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]   private def storageStatus: Array[StorageStatus] = {
  [WARNING]                              ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/storage/BlockManagerMasterEndpoint.scala:288: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]       new StorageStatus(blockManagerId, info.maxMem, Some(info.maxOnHeapMem),
  [WARNING]           ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/storage/StorageUtils.scala:303: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]   def updateRddInfo(rddInfos: Seq[RDDInfo], statuses: Seq[StorageStatus]): Unit = {
  [WARNING]                                                       ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/storage/StorageUtils.scala:323: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]   def getRddBlockLocations(rddId: Int, statuses: Seq[StorageStatus]): Map[BlockId, Seq[String]] = {
  [WARNING]                                                  ^
  [WARNING] /root/spark/core/src/main/scala/org/apache/spark/util/AccumulatorV2.scala:479: trait AccumulableParam in package spark is deprecated: use AccumulatorV2
  [WARNING]     param: org.apache.spark.AccumulableParam[R, T]) extends AccumulatorV2[T, R] {
  [WARNING]                             ^
  [WARNING] 13 warnings found
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-core_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/core/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-core_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 64 resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-core_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-core_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/org/eclipse/jetty/jetty-continuation/9.3.20.v20170531/jetty-continuation-9.3.20.v20170531.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-leg-rc/2.52.0/selenium-leg-rc-2.52.0.jar:/root/.m2/repository/org/antlr/stringtemplate/3.2.1/stringtemplate-3.2.1.jar:/root/.m2/repository/org/apache/commons/commons-math/2.2/commons-math-2.2.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/net/sourceforge/htmlunit/htmlunit-core-js/2.17/htmlunit-core-js-2.17.jar:/root/.m2/repository/commons-dbcp/commons-dbcp/1.4/commons-dbcp-1.4.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-firefox-driver/2.52.0/selenium-firefox-driver-2.52.0.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/org/antlr/ST4/4.0.4/ST4-4.0.4.jar:/root/.m2/repository/org/scalacheck/scalacheck_2.11/1.13.5/scalacheck_2.11-1.13.5.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/.m2/repository/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/eclipse/jetty/jetty-server/9.3.20.v20170531/jetty-server-9.3.20.v20170531.jar:/root/.m2/repository/org/eclipse/jetty/websocket/websocket-common/9.2.12.v20150709/websocket-common-9.2.12.v20150709.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/org/apache/commons/commons-exec/1.3/commons-exec-1.3.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/javolution/javolution/5.5.1/javolution-5.5.1.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-util/9.3.20.v20170531/jetty-util-9.3.20.v20170531.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/calcite/calcite-avatica/1.2.0-incubating/calcite-avatica-1.2.0-incubating.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/net/java/dev/jna/jna-platform/4.1.0/jna-platform-4.1.0.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/com/twitter/parquet-hadoop-bundle/1.6.0/parquet-hadoop-bundle-1.6.0.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-api/2.52.0/selenium-api-2.52.0.jar:/root/.m2/repository/org/datanucleus/datanucleus-core/3.2.10/datanucleus-core-3.2.10.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/antlr/antlr/2.7.7/antlr-2.7.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-edge-driver/2.52.0/selenium-edge-driver-2.52.0.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/.m2/repository/org/jodd/jodd-core/3.5.2/jodd-core-3.5.2.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-htmlunit-driver/2.52.0/selenium-htmlunit-driver-2.52.0.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7-tests.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/eclipse/jetty/jetty-webapp/9.3.20.v20170531/jetty-webapp-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/derby/derby/10.12.1.1/derby-10.12.1.1.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/eclipse/jetty/jetty-security/9.3.20.v20170531/jetty-security-9.3.20.v20170531.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-chrome-driver/2.52.0/selenium-chrome-driver-2.52.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpmime/4.5.4/httpmime-4.5.4.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-support/2.52.0/selenium-support-2.52.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-io/9.3.20.v20170531/jetty-io-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-safari-driver/2.52.0/selenium-safari-driver-2.52.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/eclipse/jetty/jetty-plus/9.3.20.v20170531/jetty-plus-9.3.20.v20170531.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-java/2.52.0/selenium-java-2.52.0.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/webbitserver/webbit/0.4.14/webbit-0.4.14.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/org/datanucleus/datanucleus-api-jdo/3.2.6/datanucleus-api-jdo-3.2.6.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/net/sourceforge/nekohtml/nekohtml/1.9.22/nekohtml-1.9.22.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlet/9.3.20.v20170531/jetty-servlet-9.3.20.v20170531.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar:/root/.m2/repository/org/eclipse/jetty/websocket/websocket-api/9.2.12.v20150709/websocket-api-9.2.12.v20150709.jar:/root/.m2/repository/org/w3c/css/sac/1.3/sac-1.3.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/mockito/mockito-core/1.10.19/mockito-core-1.10.19.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlets/9.3.20.v20170531/jetty-servlets-9.3.20.v20170531.jar:/root/.m2/repository/com/googlecode/javaewah/JavaEWAH/0.3.2/JavaEWAH-0.3.2.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/xml-apis/xml-apis/1.4.01/xml-apis-1.4.01.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/xalan/serializer/2.7.2/serializer-2.7.2.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/xalan/xalan/2.7.2/xalan-2.7.2.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/org/eclipse/jetty/jetty-xml/9.3.20.v20170531/jetty-xml-9.3.20.v20170531.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT-tests.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/iq80/snappy/snappy/0.2/snappy-0.2.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/org/apache/curator/curator-test/2.6.0/curator-test-2.6.0.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/apache/thrift/libthrift/0.9.3/libthrift-0.9.3.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/org/spark-project/hive/hive-exec/1.2.1.spark2/hive-exec-1.2.1.spark2.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/com/jolbox/bonecp/0.8.0.RELEASE/bonecp-0.8.0.RELEASE.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/root/.m2/repository/org/eclipse/jetty/jetty-client/9.3.20.v20170531/jetty-client-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/javax/transaction/jta/1.1/jta-1.1.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/net/sourceforge/htmlunit/htmlunit/2.18/htmlunit-2.18.jar:/root/.m2/repository/log4j/apache-log4j-extras/1.2.17/apache-log4j-extras-1.2.17.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/javax/jdo/jdo-api/3.0.1/jdo-api-3.0.1.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/.m2/repository/org/antlr/antlr-runtime/3.4/antlr-runtime-3.4.jar:/root/.m2/repository/stax/stax-api/1.0.1/stax-api-1.0.1.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/org/eclipse/jetty/websocket/websocket-client/9.2.12.v20150709/websocket-client-9.2.12.v20150709.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/eclipse/jetty/jetty-proxy/9.3.20.v20170531/jetty-proxy-9.3.20.v20170531.jar:/root/.m2/repository/org/hamcrest/hamcrest-library/1.3/hamcrest-library-1.3.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-ie-driver/2.52.0/selenium-ie-driver-2.52.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/commons-pool/commons-pool/1.5.4/commons-pool-1.5.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/cglib/cglib-nodep/2.1_3/cglib-nodep-2.1_3.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/net/sourceforge/cssparser/cssparser/0.9.16/cssparser-0.9.16.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/org/spark-project/hive/hive-metastore/1.2.1.spark2/hive-metastore-1.2.1.spark2.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-http/9.3.20.v20170531/jetty-http-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/org/apache/thrift/libfb303/0.9.3/libfb303-0.9.3.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/org/eclipse/jetty/jetty-jndi/9.3.20.v20170531/jetty-jndi-9.3.20.v20170531.jar:/root/.m2/repository/org/datanucleus/datanucleus-rdbms/3.2.9/datanucleus-rdbms-3.2.9.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/commons-logging/commons-logging/1.1.3/commons-logging-1.1.3.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-remote-driver/2.52.0/selenium-remote-driver-2.52.0.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/net/java/dev/jna/jna/4.1.0/jna-4.1.0.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-core_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 230 Scala sources and 25 Java sources to /root/spark/core/target/scala-2.11/test-classes...
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/util/ClosureCleanerSuite.scala:151: reflective access of structural type member method getData should be enabled
  by making the implicit value scala.language.reflectiveCalls visible.
  This can be achieved by adding the import clause 'import scala.language.reflectiveCalls'
  or by setting the compiler option -language:reflectiveCalls.
  See the Scaladoc for value scala.language.reflectiveCalls for a discussion
  why the feature should be explicitly enabled.
  [WARNING]       val rdd = sc.parallelize(1 to 1).map(concreteObject.getData)
  [WARNING]                                                           ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/util/ClosureCleanerSuite.scala:175: reflective access of structural type member value innerObject2 should be enabled
  by making the implicit value scala.language.reflectiveCalls visible.
  [WARNING]       val rdd = sc.parallelize(1 to 1).map(concreteObject.innerObject2.getData)
  [WARNING]                                                           ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/util/ClosureCleanerSuite.scala:175: reflective access of structural type member method getData should be enabled
  by making the implicit value scala.language.reflectiveCalls visible.
  [WARNING]       val rdd = sc.parallelize(1 to 1).map(concreteObject.innerObject2.getData)
  [WARNING]                                                                        ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:48: trait AccumulableParam in package spark is deprecated: use AccumulatorV2
  [WARNING]   implicit def setAccum[A]: AccumulableParam[mutable.Set[A], A] =
  [WARNING]                             ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:49: trait AccumulableParam in package spark is deprecated: use AccumulatorV2
  [WARNING]     new AccumulableParam[mutable.Set[A], A] {
  [WARNING]         ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:86: class Accumulator in package spark is deprecated: use AccumulatorV2
  [WARNING]     val acc: Accumulator[Int] = sc.accumulator(0)
  [WARNING]              ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:86: method accumulator in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]     val acc: Accumulator[Int] = sc.accumulator(0)
  [WARNING]                                    ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:86: object IntAccumulatorParam in object AccumulatorParam is deprecated: use AccumulatorV2
  [WARNING]     val acc: Accumulator[Int] = sc.accumulator(0)
  [WARNING]                                               ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:92: method accumulator in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]     val longAcc = sc.accumulator(0L)
  [WARNING]                      ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:92: object LongAccumulatorParam in object AccumulatorParam is deprecated: use AccumulatorV2
  [WARNING]     val longAcc = sc.accumulator(0L)
  [WARNING]                                 ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:100: class Accumulator in package spark is deprecated: use AccumulatorV2
  [WARNING]     val acc: Accumulator[Int] = sc.accumulator(0)
  [WARNING]              ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:100: method accumulator in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]     val acc: Accumulator[Int] = sc.accumulator(0)
  [WARNING]                                    ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:100: object IntAccumulatorParam in object AccumulatorParam is deprecated: use AccumulatorV2
  [WARNING]     val acc: Accumulator[Int] = sc.accumulator(0)
  [WARNING]                                               ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:112: class Accumulable in package spark is deprecated: use AccumulatorV2
  [WARNING]       val acc: Accumulable[mutable.Set[Any], Any] = sc.accumulable(new mutable.HashSet[Any]())
  [WARNING]                ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:112: method accumulable in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]       val acc: Accumulable[mutable.Set[Any], Any] = sc.accumulable(new mutable.HashSet[Any]())
  [WARNING]                                                        ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:129: class Accumulable in package spark is deprecated: use AccumulatorV2
  [WARNING]       val acc: Accumulable[mutable.Set[Any], Any] = sc.accumulable(new mutable.HashSet[Any]())
  [WARNING]                ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:129: method accumulable in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]       val acc: Accumulable[mutable.Set[Any], Any] = sc.accumulable(new mutable.HashSet[Any]())
  [WARNING]                                                        ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:145: method accumulableCollection in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]       val setAcc = sc.accumulableCollection(mutable.HashSet[Int]())
  [WARNING]                       ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:146: method accumulableCollection in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]       val bufferAcc = sc.accumulableCollection(mutable.ArrayBuffer[Int]())
  [WARNING]                          ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:147: method accumulableCollection in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]       val mapAcc = sc.accumulableCollection(mutable.HashMap[Int, String]())
  [WARNING]                       ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:170: class Accumulable in package spark is deprecated: use AccumulatorV2
  [WARNING]       val acc: Accumulable[mutable.Set[Any], Any] = sc.accumulable(new mutable.HashSet[Any]())
  [WARNING]                ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:170: method accumulable in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]       val acc: Accumulable[mutable.Set[Any], Any] = sc.accumulable(new mutable.HashSet[Any]())
  [WARNING]                                                        ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:184: class Accumulable in package spark is deprecated: use AccumulatorV2
  [WARNING]     var acc: Accumulable[mutable.Set[Any], Any] = sc.accumulable(new mutable.HashSet[Any]())
  [WARNING]              ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:184: method accumulable in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]     var acc: Accumulable[mutable.Set[Any], Any] = sc.accumulable(new mutable.HashSet[Any]())
  [WARNING]                                                      ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:227: class Accumulator in package spark is deprecated: use AccumulatorV2
  [WARNING]     val acc = new Accumulator("", StringAccumulatorParam, Some("darkness"))
  [WARNING]                   ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/AccumulatorSuite.scala:227: object StringAccumulatorParam in object AccumulatorParam is deprecated: use AccumulatorV2
  [WARNING]     val acc = new Accumulator("", StringAccumulatorParam, Some("darkness"))
  [WARNING]                                   ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/DistributedSuite.scala:163: method getExecutorStorageStatus in class SparkContext is deprecated: This method may change or be removed in a future release.
  [WARNING]     assert(sc.getExecutorStorageStatus.map(_.rddBlocksById(cachedData.id).size).sum ===
  [WARNING]               ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/LocalSparkContext.scala:32: constructor Slf4JLoggerFactory in class Slf4JLoggerFactory is deprecated: see corresponding Javadoc for more information.
  [WARNING]     InternalLoggerFactory.setDefaultFactory(new Slf4JLoggerFactory())
  [WARNING]                                             ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/deploy/StandaloneDynamicAllocationSuite.scala:614: method getExecutorStorageStatus in class SparkContext is deprecated: This method may change or be removed in a future release.
  [WARNING]     val driverExecutors = sc.getExecutorStorageStatus
  [WARNING]                              ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/status/AppStatusListenerSuite.scala:218: value attemptId in class StageInfo is deprecated: Use attemptNumber instead
  [WARNING]         assert(wrapper.stageAttemptId === stages.head.attemptId)
  [WARNING]                                                       ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/status/AppStatusListenerSuite.scala:902: value attemptId in class StageInfo is deprecated: Use attemptNumber instead
  [WARNING]     listener.onTaskStart(SparkListenerTaskStart(dropped.stageId, dropped.attemptId, task))
  [WARNING]                                                                          ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/status/AppStatusListenerSuite.scala:908: value attemptId in class StageInfo is deprecated: Use attemptNumber instead
  [WARNING]     listener.onTaskEnd(SparkListenerTaskEnd(dropped.stageId, dropped.attemptId,
  [WARNING]                                                                      ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/status/AppStatusListenerSuite.scala:912: value attemptId in class StageInfo is deprecated: Use attemptNumber instead
  [WARNING]       .taskSummary(dropped.stageId, dropped.attemptId, Array(0.25d, 0.50d, 0.75d))
  [WARNING]                                             ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/status/AppStatusListenerSuite.scala:1082: value attemptId in class StageInfo is deprecated: Use attemptNumber instead
  [WARNING]       SparkListenerTaskEnd(stage1.stageId, stage1.attemptId, "taskType", Success, tasks(1), null))
  [WARNING]                                                   ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/status/AppStatusListenerSuite.scala:1086: value attemptId in class StageInfo is deprecated: Use attemptNumber instead
  [WARNING]       SparkListenerTaskEnd(stage1.stageId, stage1.attemptId, "taskType", Success, tasks(0), null))
  [WARNING]                                                   ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/DiskStoreSuite.scala:197: method transfered in trait FileRegion is deprecated: see corresponding Javadoc for more information.
  [WARNING]     while (region.transfered() < region.count()) {
  [WARNING]                   ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/DiskStoreSuite.scala:198: method transfered in trait FileRegion is deprecated: see corresponding Javadoc for more information.
  [WARNING]       region.transferTo(byteChannel, region.transfered())
  [WARNING]                                             ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:29: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]   private def storageStatus1: StorageStatus = {
  [WARNING]                               ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:30: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]     val status = new StorageStatus(BlockManagerId("big", "dog", 1), 1000L, Some(1000L), Some(0L))
  [WARNING]                      ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:76: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]   private def storageStatus2: StorageStatus = {
  [WARNING]                               ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:77: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]     val status = new StorageStatus(BlockManagerId("big", "dog", 1), 1000L, Some(1000L), Some(0L))
  [WARNING]                      ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:254: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]   private def stockStorageStatuses: Seq[StorageStatus] = {
  [WARNING]                                     ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:255: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]     val status1 = new StorageStatus(BlockManagerId("big", "dog", 1), 1000L, Some(1000L), Some(0L))
  [WARNING]                       ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:256: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]     val status2 = new StorageStatus(BlockManagerId("fat", "duck", 2), 2000L, Some(2000L), Some(0L))
  [WARNING]                       ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:257: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]     val status3 = new StorageStatus(BlockManagerId("fat", "cat", 3), 3000L, Some(3000L), Some(0L))
  [WARNING]                       ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:338: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]   private def storageStatus3: StorageStatus = {
  [WARNING]                               ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:339: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]     val status = new StorageStatus(BlockManagerId("big", "dog", 1), 2000L, Some(1000L), Some(1000L))
  [WARNING]                      ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:393: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]   private def storageStatus4: StorageStatus = {
  [WARNING]                               ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/storage/StorageSuite.scala:394: class StorageStatus in package storage is deprecated: This class may be removed or made private in a future release.
  [WARNING]     val status = new StorageStatus(BlockManagerId("big", "dog", 1), 2000L, None, None)
  [WARNING]                      ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/util/AccumulatorV2Suite.scala:131: object StringAccumulatorParam in object AccumulatorParam is deprecated: use AccumulatorV2
  [WARNING]     val acc = new LegacyAccumulatorWrapper("default", AccumulatorParam.StringAccumulatorParam)
  [WARNING]                                                                        ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/spark/util/AccumulatorV2Suite.scala:131: object AccumulatorParam in package spark is deprecated: use AccumulatorV2
  [WARNING]     val acc = new LegacyAccumulatorWrapper("default", AccumulatorParam.StringAccumulatorParam)
  [WARNING]                                                       ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/sparktest/ImplicitSuite.scala:79: method accumulator in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]     sc.accumulator(123.4)
  [WARNING]        ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/sparktest/ImplicitSuite.scala:79: object DoubleAccumulatorParam in object AccumulatorParam is deprecated: use AccumulatorV2
  [WARNING]     sc.accumulator(123.4)
  [WARNING]                   ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/sparktest/ImplicitSuite.scala:84: method accumulator in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]     sc.accumulator(123)
  [WARNING]        ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/sparktest/ImplicitSuite.scala:84: object IntAccumulatorParam in object AccumulatorParam is deprecated: use AccumulatorV2
  [WARNING]     sc.accumulator(123)
  [WARNING]                   ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/sparktest/ImplicitSuite.scala:89: method accumulator in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]     sc.accumulator(123L)
  [WARNING]        ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/sparktest/ImplicitSuite.scala:89: object LongAccumulatorParam in object AccumulatorParam is deprecated: use AccumulatorV2
  [WARNING]     sc.accumulator(123L)
  [WARNING]                   ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/sparktest/ImplicitSuite.scala:94: method accumulator in class SparkContext is deprecated: use AccumulatorV2
  [WARNING]     sc.accumulator(123F)
  [WARNING]        ^
  [WARNING] /root/spark/core/src/test/scala/org/apache/sparktest/ImplicitSuite.scala:94: object FloatAccumulatorParam in object AccumulatorParam is deprecated: use AccumulatorV2
  [WARNING]     sc.accumulator(123F)
  [WARNING]                   ^
  [WARNING] 59 warnings found
  [WARNING] /root/spark/core/src/test/java/test/org/apache/spark/JavaAPISuite.java:36: warning: [deprecation] Accumulator in org.apache.spark has been deprecated
  [WARNING] import org.apache.spark.Accumulator;
  [WARNING]                        ^
  [WARNING] /root/spark/core/src/test/java/test/org/apache/spark/JavaAPISuite.java:37: warning: [deprecation] AccumulatorParam in org.apache.spark has been deprecated
  [WARNING] import org.apache.spark.AccumulatorParam;
  [WARNING]                        ^
  [WARNING] 2 warnings
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-core_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-core_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-core_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-core_2.11 ---
  [INFO] Building jar: /root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-core_2.11 ---
  [INFO] Building jar: /root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-core_2.11 ---
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:copy-dependencies (copy-dependencies) @ spark-core_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-core_2.11 ---
  [INFO] Excluding org.apache.avro:avro:jar:1.7.7 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-core-asl:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-mapper-asl:jar:1.9.13 from the shaded jar.
  [INFO] Excluding com.thoughtworks.paranamer:paranamer:jar:2.8 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-compress:jar:1.4.1 from the shaded jar.
  [INFO] Excluding org.tukaani:xz:jar:1.0 from the shaded jar.
  [INFO] Excluding org.apache.avro:avro-mapred:jar:hadoop2:1.7.7 from the shaded jar.
  [INFO] Excluding org.apache.avro:avro-ipc:jar:1.7.7 from the shaded jar.
  [INFO] Excluding com.twitter:chill_2.11:jar:0.8.4 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:kryo-shaded:jar:3.0.3 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:minlog:jar:1.3.0 from the shaded jar.
  [INFO] Excluding com.twitter:chill-java:jar:0.8.4 from the shaded jar.
  [INFO] Excluding org.apache.xbean:xbean-asm5-shaded:jar:4.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-client:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding xmlenc:xmlenc:jar:0.52 from the shaded jar.
  [INFO] Excluding commons-httpclient:commons-httpclient:jar:3.1 from the shaded jar.
  [INFO] Excluding commons-configuration:commons-configuration:jar:1.6 from the shaded jar.
  [INFO] Excluding commons-digester:commons-digester:jar:1.8 from the shaded jar.
  [INFO] Excluding commons-beanutils:commons-beanutils:jar:1.7.0 from the shaded jar.
  [INFO] Excluding commons-beanutils:commons-beanutils-core:jar:1.8.0 from the shaded jar.
  [INFO] Excluding com.google.protobuf:protobuf-java:jar:2.5.0 from the shaded jar.
  [INFO] Excluding com.google.code.gson:gson:jar:2.2.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-auth:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.directory.server:apacheds-kerberos-codec:jar:2.0.0-M15 from the shaded jar.
  [INFO] Excluding org.apache.directory.server:apacheds-i18n:jar:2.0.0-M15 from the shaded jar.
  [INFO] Excluding org.apache.directory.api:api-asn1-api:jar:1.0.0-M20 from the shaded jar.
  [INFO] Excluding org.apache.directory.api:api-util:jar:1.0.0-M20 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-client:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.htrace:htrace-core:jar:3.0.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-hdfs:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.mortbay.jetty:jetty-util:jar:6.1.26 from the shaded jar.
  [INFO] Excluding xerces:xercesImpl:jar:2.9.1 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-app:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-client:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-server-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-shuffle:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-api:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-core:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding javax.xml.bind:jaxb-api:jar:2.2.2 from the shaded jar.
  [INFO] Excluding javax.xml.stream:stax-api:jar:1.0-2 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-jaxrs:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-xc:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-jobclient:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-annotations:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-launcher_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-kvstore_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.fusesource.leveldbjni:leveldbjni-all:jar:1.8 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-core:jar:2.6.7 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-annotations:jar:2.6.7 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-network-common_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-network-shuffle_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-unsafe_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding net.java.dev.jets3t:jets3t:jar:0.9.4 from the shaded jar.
  [INFO] Excluding org.apache.httpcomponents:httpcore:jar:4.4.8 from the shaded jar.
  [INFO] Excluding org.apache.httpcomponents:httpclient:jar:4.5.4 from the shaded jar.
  [INFO] Excluding commons-codec:commons-codec:jar:1.10 from the shaded jar.
  [INFO] Excluding javax.activation:activation:jar:1.1.1 from the shaded jar.
  [INFO] Excluding org.bouncycastle:bcprov-jdk15on:jar:1.58 from the shaded jar.
  [INFO] Excluding com.jamesmurty.utils:java-xmlbuilder:jar:1.1 from the shaded jar.
  [INFO] Excluding net.iharder:base64:jar:2.3.8 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-recipes:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-framework:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.zookeeper:zookeeper:jar:3.4.6 from the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-plus:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Excluding org.eclipse.jetty:jetty-webapp:jar:9.3.20.v20170531 from the shaded jar.
  [INFO] Excluding org.eclipse.jetty:jetty-xml:jar:9.3.20.v20170531 from the shaded jar.
  [INFO] Excluding org.eclipse.jetty:jetty-jndi:jar:9.3.20.v20170531 from the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-security:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-util:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-server:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-io:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-http:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-continuation:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-servlet:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-proxy:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-client:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Including org.eclipse.jetty:jetty-servlets:jar:9.3.20.v20170531 in the shaded jar.
  [INFO] Excluding javax.servlet:javax.servlet-api:jar:3.1.0 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-lang3:jar:3.5 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-math3:jar:3.4.1 from the shaded jar.
  [INFO] Excluding com.google.code.findbugs:jsr305:jar:1.3.9 from the shaded jar.
  [INFO] Excluding org.slf4j:slf4j-api:jar:1.7.16 from the shaded jar.
  [INFO] Excluding org.slf4j:jul-to-slf4j:jar:1.7.16 from the shaded jar.
  [INFO] Excluding org.slf4j:jcl-over-slf4j:jar:1.7.16 from the shaded jar.
  [INFO] Excluding log4j:log4j:jar:1.2.17 from the shaded jar.
  [INFO] Excluding org.slf4j:slf4j-log4j12:jar:1.7.16 from the shaded jar.
  [INFO] Excluding com.ning:compress-lzf:jar:1.0.3 from the shaded jar.
  [INFO] Excluding org.xerial.snappy:snappy-java:jar:1.1.2.6 from the shaded jar.
  [INFO] Excluding org.lz4:lz4-java:jar:1.4.0 from the shaded jar.
  [INFO] Excluding com.github.luben:zstd-jni:jar:1.3.2-2 from the shaded jar.
  [INFO] Excluding org.roaringbitmap:RoaringBitmap:jar:0.5.11 from the shaded jar.
  [INFO] Excluding commons-net:commons-net:jar:2.2 from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-jackson_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-core_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-ast_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.scala-lang:scalap:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-compiler:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-client:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.ws.rs:javax.ws.rs-api:jar:2.0.1 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-api:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-utils:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2.external:aopalliance-repackaged:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2.external:javax.inject:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-locator:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-common:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.annotation:javax.annotation-api:jar:1.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.bundles.repackaged:jersey-guava:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:osgi-resource-locator:jar:1.0.1 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-server:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.media:jersey-media-jaxb:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.validation:validation-api:jar:1.1.0.Final from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.22.2 from the shaded jar.
  [INFO] Excluding io.netty:netty-all:jar:4.1.17.Final from the shaded jar.
  [INFO] Excluding io.netty:netty:jar:3.9.9.Final from the shaded jar.
  [INFO] Excluding com.clearspring.analytics:stream:jar:2.7.0 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-core:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-jvm:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-json:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-graphite:jar:3.1.5 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-databind:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.module:jackson-module-scala_2.11:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-reflect:jar:2.11.8 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.module:jackson-module-paranamer:jar:2.7.9 from the shaded jar.
  [INFO] Excluding org.apache.ivy:ivy:jar:2.4.0 from the shaded jar.
  [INFO] Excluding oro:oro:jar:2.0.8 from the shaded jar.
  [INFO] Excluding commons-collections:commons-collections:jar:3.2.2 from the shaded jar.
  [INFO] Excluding org.objenesis:objenesis:jar:2.1 from the shaded jar.
  [INFO] Excluding org.javassist:javassist:jar:3.18.1-GA from the shaded jar.
  [INFO] Excluding net.razorvine:pyrolite:jar:4.13 from the shaded jar.
  [INFO] Excluding net.sf.py4j:py4j:jar:0.10.6 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-crypto:jar:1.0.0 from the shaded jar.
  [INFO] Excluding com.twitter:parquet-hadoop-bundle:jar:1.6.0 from the shaded jar.
  [INFO] Excluding commons-io:commons-io:jar:2.4 from the shaded jar.
  [INFO] Excluding commons-lang:commons-lang:jar:2.6 from the shaded jar.
  [INFO] Excluding commons-cli:commons-cli:jar:1.2 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Excluding org.scala-lang.modules:scala-xml_2.11:jar:1.0.5 from the shaded jar.
  [INFO] Excluding org.scala-lang.modules:scala-parser-combinators_2.11:jar:1.0.4 from the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar with /root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/core/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-core_2.11 ---
  [INFO] Building jar: /root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-core_2.11 ---
  [INFO] Building jar: /root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project ML Local Library 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-mllib-local_2.11 ---
  [INFO] Deleting /root/spark/mllib-local/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-mllib-local_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-mllib-local_2.11 ---
  [INFO] Add Source directory: /root/spark/mllib-local/src/main/scala
  [INFO] Add Test Source directory: /root/spark/mllib-local/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-mllib-local_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scalanlp/breeze_2.11/0.13.2/breeze_2.11-0.13.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/scalanlp/breeze-macros_2.11/0.13.2/breeze-macros_2.11-0.13.2.jar:/root/.m2/repository/org/typelevel/macro-compat_2.11/1.1.1/macro-compat_2.11-1.1.1.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/net/sourceforge/f2j/arpack_combined_all/0.1/arpack_combined_all-0.1.jar:/root/.m2/repository/com/chuusai/shapeless_2.11/2.3.2/shapeless_2.11-2.3.2.jar:/root/.m2/repository/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/typelevel/machinist_2.11/0.6.1/machinist_2.11-0.6.1.jar:/root/.m2/repository/org/spire-math/spire_2.11/0.13.0/spire_2.11-0.13.0.jar:/root/.m2/repository/org/spire-math/spire-macros_2.11/0.13.0/spire-macros_2.11-0.13.0.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/com/github/rwl/jtransforms/2.4.0/jtransforms-2.4.0.jar:/root/.m2/repository/com/github/fommil/netlib/core/1.1.2/core-1.1.2.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-mllib-local_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-mllib-local_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/mllib-local/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-mllib-local_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-mllib-local_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 5 Scala sources to /root/spark/mllib-local/target/scala-2.11/classes...
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-mllib-local_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/mllib-local/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-mllib-local_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/mllib-local/src/test/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-mllib-local_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-mllib-local_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/org/scalanlp/breeze_2.11/0.13.2/breeze_2.11-0.13.2.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/typelevel/macro-compat_2.11/1.1.1/macro-compat_2.11-1.1.1.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar:/root/.m2/repository/org/typelevel/machinist_2.11/0.6.1/machinist_2.11-0.6.1.jar:/root/.m2/repository/org/mockito/mockito-core/1.10.19/mockito-core-1.10.19.jar:/root/.m2/repository/org/spire-math/spire_2.11/0.13.0/spire_2.11-0.13.0.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/com/github/fommil/netlib/core/1.1.2/core-1.1.2.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/org/scalanlp/breeze-macros_2.11/0.13.2/breeze-macros_2.11-0.13.2.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/net/sourceforge/f2j/arpack_combined_all/0.1/arpack_combined_all-0.1.jar:/root/.m2/repository/com/chuusai/shapeless_2.11/2.3.2/shapeless_2.11-2.3.2.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/spire-math/spire-macros_2.11/0.13.0/spire-macros_2.11-0.13.0.jar:/root/.m2/repository/org/scalacheck/scalacheck_2.11/1.13.5/scalacheck_2.11-1.13.5.jar:/root/.m2/repository/com/github/rwl/jtransforms/2.4.0/jtransforms-2.4.0.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-mllib-local_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 10 Scala sources to /root/spark/mllib-local/target/scala-2.11/test-classes...
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-mllib-local_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-mllib-local_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-mllib-local_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-mllib-local_2.11 ---
  [INFO] Building jar: /root/spark/mllib-local/target/spark-mllib-local_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-mllib-local_2.11 ---
  [INFO] Building jar: /root/spark/mllib-local/target/spark-mllib-local_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-mllib-local_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-mllib-local_2.11 ---
  [INFO] Excluding org.scalanlp:breeze_2.11:jar:0.13.2 from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.scalanlp:breeze-macros_2.11:jar:0.13.2 from the shaded jar.
  [INFO] Excluding com.github.fommil.netlib:core:jar:1.1.2 from the shaded jar.
  [INFO] Excluding net.sourceforge.f2j:arpack_combined_all:jar:0.1 from the shaded jar.
  [INFO] Excluding net.sf.opencsv:opencsv:jar:2.3 from the shaded jar.
  [INFO] Excluding com.github.rwl:jtransforms:jar:2.4.0 from the shaded jar.
  [INFO] Excluding org.spire-math:spire_2.11:jar:0.13.0 from the shaded jar.
  [INFO] Excluding org.spire-math:spire-macros_2.11:jar:0.13.0 from the shaded jar.
  [INFO] Excluding org.typelevel:machinist_2.11:jar:0.6.1 from the shaded jar.
  [INFO] Excluding com.chuusai:shapeless_2.11:jar:2.3.2 from the shaded jar.
  [INFO] Excluding org.typelevel:macro-compat_2.11:jar:1.1.1 from the shaded jar.
  [INFO] Excluding org.slf4j:slf4j-api:jar:1.7.16 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-math3:jar:3.4.1 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Excluding org.scala-lang:scala-reflect:jar:2.11.8 from the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/mllib-local/target/spark-mllib-local_2.11-2.3.1-SNAPSHOT.jar with /root/spark/mllib-local/target/spark-mllib-local_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/mllib-local/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-mllib-local_2.11 ---
  [INFO] Building jar: /root/spark/mllib-local/target/spark-mllib-local_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-mllib-local_2.11 ---
  [INFO] Building jar: /root/spark/mllib-local/target/spark-mllib-local_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project GraphX 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-graphx_2.11 ---
  [INFO] Deleting /root/spark/graphx/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-graphx_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-graphx_2.11 ---
  [INFO] Add Source directory: /root/spark/graphx/src/main/scala
  [INFO] Add Test Source directory: /root/spark/graphx/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-graphx_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scalanlp/breeze_2.11/0.13.2/breeze_2.11-0.13.2.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/typelevel/machinist_2.11/0.6.1/machinist_2.11-0.6.1.jar:/root/.m2/repository/org/spire-math/spire_2.11/0.13.0/spire_2.11-0.13.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/scalanlp/breeze-macros_2.11/0.13.2/breeze-macros_2.11-0.13.2.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/net/sourceforge/f2j/arpack_combined_all/0.1/arpack_combined_all-0.1.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/spire-math/spire-macros_2.11/0.13.0/spire-macros_2.11-0.13.0.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/.m2/repository/com/github/rwl/jtransforms/2.4.0/jtransforms-2.4.0.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/spark/mllib-local/target/spark-mllib-local_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/typelevel/macro-compat_2.11/1.1.1/macro-compat_2.11-1.1.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/.m2/repository/com/github/fommil/netlib/core/1.1.2/core-1.1.2.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/com/chuusai/shapeless_2.11/2.3.2/shapeless_2.11-2.3.2.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-graphx_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-graphx_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/graphx/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-graphx_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-graphx_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 38 Scala sources and 5 Java sources to /root/spark/graphx/target/scala-2.11/classes...
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-graphx_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/graphx/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-graphx_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 2 resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-graphx_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-graphx_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/scalanlp/breeze_2.11/0.13.2/breeze_2.11-0.13.2.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/eclipse/jetty/jetty-continuation/9.3.20.v20170531/jetty-continuation-9.3.20.v20170531.jar:/root/.m2/repository/org/typelevel/machinist_2.11/0.6.1/machinist_2.11-0.6.1.jar:/root/.m2/repository/org/spire-math/spire_2.11/0.13.0/spire_2.11-0.13.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlets/9.3.20.v20170531/jetty-servlets-9.3.20.v20170531.jar:/root/.m2/repository/xml-apis/xml-apis/1.4.01/xml-apis-1.4.01.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/scalanlp/breeze-macros_2.11/0.13.2/breeze-macros_2.11-0.13.2.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/net/sourceforge/f2j/arpack_combined_all/0.1/arpack_combined_all-0.1.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/org/eclipse/jetty/jetty-xml/9.3.20.v20170531/jetty-xml-9.3.20.v20170531.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/spire-math/spire-macros_2.11/0.13.0/spire-macros_2.11-0.13.0.jar:/root/.m2/repository/org/scalacheck/scalacheck_2.11/1.13.5/scalacheck_2.11-1.13.5.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/.m2/repository/com/github/rwl/jtransforms/2.4.0/jtransforms-2.4.0.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/net/sf/opencsv/opencsv/2.3/opencsv-2.3.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/eclipse/jetty/jetty-server/9.3.20.v20170531/jetty-server-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/root/.m2/repository/org/eclipse/jetty/jetty-client/9.3.20.v20170531/jetty-client-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-util/9.3.20.v20170531/jetty-util-9.3.20.v20170531.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/spark/mllib-local/target/spark-mllib-local_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/eclipse/jetty/jetty-proxy/9.3.20.v20170531/jetty-proxy-9.3.20.v20170531.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/typelevel/macro-compat_2.11/1.1.1/macro-compat_2.11-1.1.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/.m2/repository/com/github/fommil/netlib/core/1.1.2/core-1.1.2.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/com/chuusai/shapeless_2.11/2.3.2/shapeless_2.11-2.3.2.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7-tests.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/eclipse/jetty/jetty-webapp/9.3.20.v20170531/jetty-webapp-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-http/9.3.20.v20170531/jetty-http-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-security/9.3.20.v20170531/jetty-security-9.3.20.v20170531.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-io/9.3.20.v20170531/jetty-io-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-plus/9.3.20.v20170531/jetty-plus-9.3.20.v20170531.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/org/eclipse/jetty/jetty-jndi/9.3.20.v20170531/jetty-jndi-9.3.20.v20170531.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlet/9.3.20.v20170531/jetty-servlet-9.3.20.v20170531.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-graphx_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 20 Scala sources to /root/spark/graphx/target/scala-2.11/test-classes...
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-graphx_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-graphx_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-graphx_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-graphx_2.11 ---
  [INFO] Building jar: /root/spark/graphx/target/spark-graphx_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-graphx_2.11 ---
  [INFO] Building jar: /root/spark/graphx/target/spark-graphx_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-graphx_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-graphx_2.11 ---
  [INFO] Excluding org.apache.spark:spark-core_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.avro:avro:jar:1.7.7 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-core-asl:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-mapper-asl:jar:1.9.13 from the shaded jar.
  [INFO] Excluding com.thoughtworks.paranamer:paranamer:jar:2.8 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-compress:jar:1.4.1 from the shaded jar.
  [INFO] Excluding org.tukaani:xz:jar:1.0 from the shaded jar.
  [INFO] Excluding org.apache.avro:avro-mapred:jar:hadoop2:1.7.7 from the shaded jar.
  [INFO] Excluding org.apache.avro:avro-ipc:jar:1.7.7 from the shaded jar.
  [INFO] Excluding com.twitter:chill_2.11:jar:0.8.4 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:kryo-shaded:jar:3.0.3 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:minlog:jar:1.3.0 from the shaded jar.
  [INFO] Excluding org.objenesis:objenesis:jar:2.1 from the shaded jar.
  [INFO] Excluding com.twitter:chill-java:jar:0.8.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-client:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding commons-cli:commons-cli:jar:1.2 from the shaded jar.
  [INFO] Excluding xmlenc:xmlenc:jar:0.52 from the shaded jar.
  [INFO] Excluding commons-httpclient:commons-httpclient:jar:3.1 from the shaded jar.
  [INFO] Excluding commons-io:commons-io:jar:2.4 from the shaded jar.
  [INFO] Excluding commons-collections:commons-collections:jar:3.2.2 from the shaded jar.
  [INFO] Excluding commons-lang:commons-lang:jar:2.6 from the shaded jar.
  [INFO] Excluding commons-configuration:commons-configuration:jar:1.6 from the shaded jar.
  [INFO] Excluding commons-digester:commons-digester:jar:1.8 from the shaded jar.
  [INFO] Excluding commons-beanutils:commons-beanutils:jar:1.7.0 from the shaded jar.
  [INFO] Excluding commons-beanutils:commons-beanutils-core:jar:1.8.0 from the shaded jar.
  [INFO] Excluding com.google.protobuf:protobuf-java:jar:2.5.0 from the shaded jar.
  [INFO] Excluding com.google.code.gson:gson:jar:2.2.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-auth:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.directory.server:apacheds-kerberos-codec:jar:2.0.0-M15 from the shaded jar.
  [INFO] Excluding org.apache.directory.server:apacheds-i18n:jar:2.0.0-M15 from the shaded jar.
  [INFO] Excluding org.apache.directory.api:api-asn1-api:jar:1.0.0-M20 from the shaded jar.
  [INFO] Excluding org.apache.directory.api:api-util:jar:1.0.0-M20 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-client:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.htrace:htrace-core:jar:3.0.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-hdfs:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.mortbay.jetty:jetty-util:jar:6.1.26 from the shaded jar.
  [INFO] Excluding xerces:xercesImpl:jar:2.9.1 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-app:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-client:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-server-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-shuffle:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-api:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-core:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding javax.xml.bind:jaxb-api:jar:2.2.2 from the shaded jar.
  [INFO] Excluding javax.xml.stream:stax-api:jar:1.0-2 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-jaxrs:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-xc:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-jobclient:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-annotations:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-launcher_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-kvstore_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.fusesource.leveldbjni:leveldbjni-all:jar:1.8 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-core:jar:2.6.7 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-annotations:jar:2.6.7 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-network-common_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-network-shuffle_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-unsafe_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding net.java.dev.jets3t:jets3t:jar:0.9.4 from the shaded jar.
  [INFO] Excluding org.apache.httpcomponents:httpcore:jar:4.4.8 from the shaded jar.
  [INFO] Excluding org.apache.httpcomponents:httpclient:jar:4.5.4 from the shaded jar.
  [INFO] Excluding commons-codec:commons-codec:jar:1.10 from the shaded jar.
  [INFO] Excluding javax.activation:activation:jar:1.1.1 from the shaded jar.
  [INFO] Excluding org.bouncycastle:bcprov-jdk15on:jar:1.58 from the shaded jar.
  [INFO] Excluding com.jamesmurty.utils:java-xmlbuilder:jar:1.1 from the shaded jar.
  [INFO] Excluding net.iharder:base64:jar:2.3.8 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-recipes:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-framework:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.zookeeper:zookeeper:jar:3.4.6 from the shaded jar.
  [INFO] Excluding javax.servlet:javax.servlet-api:jar:3.1.0 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-lang3:jar:3.5 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-math3:jar:3.4.1 from the shaded jar.
  [INFO] Excluding com.google.code.findbugs:jsr305:jar:1.3.9 from the shaded jar.
  [INFO] Excluding org.slf4j:slf4j-api:jar:1.7.16 from the shaded jar.
  [INFO] Excluding org.slf4j:jul-to-slf4j:jar:1.7.16 from the shaded jar.
  [INFO] Excluding org.slf4j:jcl-over-slf4j:jar:1.7.16 from the shaded jar.
  [INFO] Excluding log4j:log4j:jar:1.2.17 from the shaded jar.
  [INFO] Excluding org.slf4j:slf4j-log4j12:jar:1.7.16 from the shaded jar.
  [INFO] Excluding com.ning:compress-lzf:jar:1.0.3 from the shaded jar.
  [INFO] Excluding org.xerial.snappy:snappy-java:jar:1.1.2.6 from the shaded jar.
  [INFO] Excluding org.lz4:lz4-java:jar:1.4.0 from the shaded jar.
  [INFO] Excluding com.github.luben:zstd-jni:jar:1.3.2-2 from the shaded jar.
  [INFO] Excluding org.roaringbitmap:RoaringBitmap:jar:0.5.11 from the shaded jar.
  [INFO] Excluding commons-net:commons-net:jar:2.2 from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-jackson_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-core_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-ast_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.scala-lang:scalap:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-compiler:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-client:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.ws.rs:javax.ws.rs-api:jar:2.0.1 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-api:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-utils:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2.external:aopalliance-repackaged:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2.external:javax.inject:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-locator:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.javassist:javassist:jar:3.18.1-GA from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-common:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.annotation:javax.annotation-api:jar:1.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.bundles.repackaged:jersey-guava:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:osgi-resource-locator:jar:1.0.1 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-server:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.media:jersey-media-jaxb:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.validation:validation-api:jar:1.1.0.Final from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.22.2 from the shaded jar.
  [INFO] Excluding io.netty:netty-all:jar:4.1.17.Final from the shaded jar.
  [INFO] Excluding io.netty:netty:jar:3.9.9.Final from the shaded jar.
  [INFO] Excluding com.clearspring.analytics:stream:jar:2.7.0 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-core:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-jvm:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-json:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-graphite:jar:3.1.5 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-databind:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.module:jackson-module-scala_2.11:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.module:jackson-module-paranamer:jar:2.7.9 from the shaded jar.
  [INFO] Excluding org.apache.ivy:ivy:jar:2.4.0 from the shaded jar.
  [INFO] Excluding oro:oro:jar:2.0.8 from the shaded jar.
  [INFO] Excluding net.razorvine:pyrolite:jar:4.13 from the shaded jar.
  [INFO] Excluding net.sf.py4j:py4j:jar:0.10.6 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-crypto:jar:1.0.0 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-mllib-local_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.scalanlp:breeze_2.11:jar:0.13.2 from the shaded jar.
  [INFO] Excluding org.scalanlp:breeze-macros_2.11:jar:0.13.2 from the shaded jar.
  [INFO] Excluding net.sf.opencsv:opencsv:jar:2.3 from the shaded jar.
  [INFO] Excluding com.github.rwl:jtransforms:jar:2.4.0 from the shaded jar.
  [INFO] Excluding org.spire-math:spire_2.11:jar:0.13.0 from the shaded jar.
  [INFO] Excluding org.spire-math:spire-macros_2.11:jar:0.13.0 from the shaded jar.
  [INFO] Excluding org.typelevel:machinist_2.11:jar:0.6.1 from the shaded jar.
  [INFO] Excluding com.chuusai:shapeless_2.11:jar:2.3.2 from the shaded jar.
  [INFO] Excluding org.typelevel:macro-compat_2.11:jar:1.1.1 from the shaded jar.
  [INFO] Excluding org.apache.xbean:xbean-asm5-shaded:jar:4.4 from the shaded jar.
  [INFO] Excluding com.github.fommil.netlib:core:jar:1.1.2 from the shaded jar.
  [INFO] Excluding net.sourceforge.f2j:arpack_combined_all:jar:0.1 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Excluding org.scala-lang:scala-reflect:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.scala-lang.modules:scala-xml_2.11:jar:1.0.5 from the shaded jar.
  [INFO] Excluding org.scala-lang.modules:scala-parser-combinators_2.11:jar:1.0.4 from the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/graphx/target/spark-graphx_2.11-2.3.1-SNAPSHOT.jar with /root/spark/graphx/target/spark-graphx_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/graphx/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-graphx_2.11 ---
  [INFO] Building jar: /root/spark/graphx/target/spark-graphx_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-graphx_2.11 ---
  [INFO] Building jar: /root/spark/graphx/target/spark-graphx_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Streaming 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-streaming_2.11 ---
  [INFO] Deleting /root/spark/streaming/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-streaming_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-streaming_2.11 ---
  [INFO] Add Source directory: /root/spark/streaming/src/main/scala
  [INFO] Add Test Source directory: /root/spark/streaming/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-streaming_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/xerces/xercesImpl/2.11.0/xercesImpl-2.11.0.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-streaming_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-streaming_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 2 resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-streaming_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-streaming_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 103 Scala sources and 6 Java sources to /root/spark/streaming/target/scala-2.11/classes...
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-streaming_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/streaming/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-streaming_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 1 resource
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-streaming_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-streaming_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/org/w3c/css/sac/1.3/sac-1.3.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/eclipse/jetty/jetty-continuation/9.3.20.v20170531/jetty-continuation-9.3.20.v20170531.jar:/root/.m2/repository/org/mockito/mockito-core/1.10.19/mockito-core-1.10.19.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlets/9.3.20.v20170531/jetty-servlets-9.3.20.v20170531.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-leg-rc/2.52.0/selenium-leg-rc-2.52.0.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/xml-apis/xml-apis/1.4.01/xml-apis-1.4.01.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/net/sourceforge/htmlunit/htmlunit-core-js/2.17/htmlunit-core-js-2.17.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-firefox-driver/2.52.0/selenium-firefox-driver-2.52.0.jar:/root/.m2/repository/xalan/serializer/2.7.2/serializer-2.7.2.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/xalan/xalan/2.7.2/xalan-2.7.2.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/org/eclipse/jetty/jetty-xml/9.3.20.v20170531/jetty-xml-9.3.20.v20170531.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/scalacheck/scalacheck_2.11/1.13.5/scalacheck_2.11-1.13.5.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/eclipse/jetty/jetty-server/9.3.20.v20170531/jetty-server-9.3.20.v20170531.jar:/root/.m2/repository/org/eclipse/jetty/websocket/websocket-common/9.2.12.v20150709/websocket-common-9.2.12.v20150709.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/org/apache/commons/commons-exec/1.3/commons-exec-1.3.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/xerces/xercesImpl/2.11.0/xercesImpl-2.11.0.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/root/.m2/repository/org/eclipse/jetty/jetty-client/9.3.20.v20170531/jetty-client-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/.m2/repository/org/eclipse/jetty/jetty-util/9.3.20.v20170531/jetty-util-9.3.20.v20170531.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/net/sourceforge/htmlunit/htmlunit/2.18/htmlunit-2.18.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/net/java/dev/jna/jna-platform/4.1.0/jna-platform-4.1.0.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/org/eclipse/jetty/websocket/websocket-client/9.2.12.v20150709/websocket-client-9.2.12.v20150709.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-api/2.52.0/selenium-api-2.52.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-proxy/9.3.20.v20170531/jetty-proxy-9.3.20.v20170531.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-ie-driver/2.52.0/selenium-ie-driver-2.52.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-edge-driver/2.52.0/selenium-edge-driver-2.52.0.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/.m2/repository/cglib/cglib-nodep/2.1_3/cglib-nodep-2.1_3.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/net/sourceforge/cssparser/cssparser/0.9.16/cssparser-0.9.16.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-htmlunit-driver/2.52.0/selenium-htmlunit-driver-2.52.0.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7-tests.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/eclipse/jetty/jetty-webapp/9.3.20.v20170531/jetty-webapp-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-http/9.3.20.v20170531/jetty-http-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-security/9.3.20.v20170531/jetty-security-9.3.20.v20170531.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-chrome-driver/2.52.0/selenium-chrome-driver-2.52.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpmime/4.5.4/httpmime-4.5.4.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-support/2.52.0/selenium-support-2.52.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-io/9.3.20.v20170531/jetty-io-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-safari-driver/2.52.0/selenium-safari-driver-2.52.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-plus/9.3.20.v20170531/jetty-plus-9.3.20.v20170531.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-java/2.52.0/selenium-java-2.52.0.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/org/eclipse/jetty/jetty-jndi/9.3.20.v20170531/jetty-jndi-9.3.20.v20170531.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/org/webbitserver/webbit/0.4.14/webbit-0.4.14.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/org/seleniumhq/selenium/selenium-remote-driver/2.52.0/selenium-remote-driver-2.52.0.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/net/sourceforge/nekohtml/nekohtml/1.9.22/nekohtml-1.9.22.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlet/9.3.20.v20170531/jetty-servlet-9.3.20.v20170531.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/net/java/dev/jna/jna/4.1.0/jna-4.1.0.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar:/root/.m2/repository/org/eclipse/jetty/websocket/websocket-api/9.2.12.v20150709/websocket-api-9.2.12.v20150709.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-streaming_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 40 Scala sources and 9 Java sources to /root/spark/streaming/target/scala-2.11/test-classes...
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-streaming_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-streaming_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-streaming_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-streaming_2.11 ---
  [INFO] Building jar: /root/spark/streaming/target/spark-streaming_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-streaming_2.11 ---
  [INFO] Building jar: /root/spark/streaming/target/spark-streaming_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-streaming_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-streaming_2.11 ---
  [INFO] Excluding org.apache.spark:spark-core_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.avro:avro:jar:1.7.7 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-core-asl:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-mapper-asl:jar:1.9.13 from the shaded jar.
  [INFO] Excluding com.thoughtworks.paranamer:paranamer:jar:2.8 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-compress:jar:1.4.1 from the shaded jar.
  [INFO] Excluding org.tukaani:xz:jar:1.0 from the shaded jar.
  [INFO] Excluding org.apache.avro:avro-mapred:jar:hadoop2:1.7.7 from the shaded jar.
  [INFO] Excluding org.apache.avro:avro-ipc:jar:1.7.7 from the shaded jar.
  [INFO] Excluding com.twitter:chill_2.11:jar:0.8.4 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:kryo-shaded:jar:3.0.3 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:minlog:jar:1.3.0 from the shaded jar.
  [INFO] Excluding com.twitter:chill-java:jar:0.8.4 from the shaded jar.
  [INFO] Excluding org.apache.xbean:xbean-asm5-shaded:jar:4.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-client:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding commons-cli:commons-cli:jar:1.2 from the shaded jar.
  [INFO] Excluding xmlenc:xmlenc:jar:0.52 from the shaded jar.
  [INFO] Excluding commons-httpclient:commons-httpclient:jar:3.1 from the shaded jar.
  [INFO] Excluding commons-lang:commons-lang:jar:2.6 from the shaded jar.
  [INFO] Excluding commons-configuration:commons-configuration:jar:1.6 from the shaded jar.
  [INFO] Excluding commons-digester:commons-digester:jar:1.8 from the shaded jar.
  [INFO] Excluding commons-beanutils:commons-beanutils:jar:1.7.0 from the shaded jar.
  [INFO] Excluding commons-beanutils:commons-beanutils-core:jar:1.8.0 from the shaded jar.
  [INFO] Excluding com.google.protobuf:protobuf-java:jar:2.5.0 from the shaded jar.
  [INFO] Excluding com.google.code.gson:gson:jar:2.2.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-auth:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.directory.server:apacheds-kerberos-codec:jar:2.0.0-M15 from the shaded jar.
  [INFO] Excluding org.apache.directory.server:apacheds-i18n:jar:2.0.0-M15 from the shaded jar.
  [INFO] Excluding org.apache.directory.api:api-asn1-api:jar:1.0.0-M20 from the shaded jar.
  [INFO] Excluding org.apache.directory.api:api-util:jar:1.0.0-M20 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-client:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.htrace:htrace-core:jar:3.0.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-hdfs:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.mortbay.jetty:jetty-util:jar:6.1.26 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-app:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-client:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-server-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-shuffle:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-api:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-core:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding javax.xml.bind:jaxb-api:jar:2.2.2 from the shaded jar.
  [INFO] Excluding javax.xml.stream:stax-api:jar:1.0-2 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-jaxrs:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-xc:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-jobclient:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-annotations:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-launcher_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-kvstore_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.fusesource.leveldbjni:leveldbjni-all:jar:1.8 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-core:jar:2.6.7 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-annotations:jar:2.6.7 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-network-common_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-network-shuffle_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-unsafe_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding net.java.dev.jets3t:jets3t:jar:0.9.4 from the shaded jar.
  [INFO] Excluding org.apache.httpcomponents:httpcore:jar:4.4.8 from the shaded jar.
  [INFO] Excluding commons-codec:commons-codec:jar:1.10 from the shaded jar.
  [INFO] Excluding javax.activation:activation:jar:1.1.1 from the shaded jar.
  [INFO] Excluding org.bouncycastle:bcprov-jdk15on:jar:1.58 from the shaded jar.
  [INFO] Excluding com.jamesmurty.utils:java-xmlbuilder:jar:1.1 from the shaded jar.
  [INFO] Excluding net.iharder:base64:jar:2.3.8 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-recipes:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-framework:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.zookeeper:zookeeper:jar:3.4.6 from the shaded jar.
  [INFO] Excluding javax.servlet:javax.servlet-api:jar:3.1.0 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-lang3:jar:3.5 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-math3:jar:3.4.1 from the shaded jar.
  [INFO] Excluding com.google.code.findbugs:jsr305:jar:1.3.9 from the shaded jar.
  [INFO] Excluding org.slf4j:slf4j-api:jar:1.7.16 from the shaded jar.
  [INFO] Excluding org.slf4j:jul-to-slf4j:jar:1.7.16 from the shaded jar.
  [INFO] Excluding org.slf4j:jcl-over-slf4j:jar:1.7.16 from the shaded jar.
  [INFO] Excluding log4j:log4j:jar:1.2.17 from the shaded jar.
  [INFO] Excluding org.slf4j:slf4j-log4j12:jar:1.7.16 from the shaded jar.
  [INFO] Excluding com.ning:compress-lzf:jar:1.0.3 from the shaded jar.
  [INFO] Excluding org.xerial.snappy:snappy-java:jar:1.1.2.6 from the shaded jar.
  [INFO] Excluding org.lz4:lz4-java:jar:1.4.0 from the shaded jar.
  [INFO] Excluding com.github.luben:zstd-jni:jar:1.3.2-2 from the shaded jar.
  [INFO] Excluding org.roaringbitmap:RoaringBitmap:jar:0.5.11 from the shaded jar.
  [INFO] Excluding commons-net:commons-net:jar:2.2 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-jackson_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-core_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-ast_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.scala-lang:scalap:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-compiler:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-client:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.ws.rs:javax.ws.rs-api:jar:2.0.1 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-api:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-utils:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2.external:aopalliance-repackaged:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2.external:javax.inject:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-locator:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.javassist:javassist:jar:3.18.1-GA from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-common:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.annotation:javax.annotation-api:jar:1.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.bundles.repackaged:jersey-guava:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:osgi-resource-locator:jar:1.0.1 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-server:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.media:jersey-media-jaxb:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.validation:validation-api:jar:1.1.0.Final from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.22.2 from the shaded jar.
  [INFO] Excluding io.netty:netty-all:jar:4.1.17.Final from the shaded jar.
  [INFO] Excluding io.netty:netty:jar:3.9.9.Final from the shaded jar.
  [INFO] Excluding com.clearspring.analytics:stream:jar:2.7.0 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-core:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-jvm:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-json:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-graphite:jar:3.1.5 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-databind:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.module:jackson-module-scala_2.11:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.module:jackson-module-paranamer:jar:2.7.9 from the shaded jar.
  [INFO] Excluding org.apache.ivy:ivy:jar:2.4.0 from the shaded jar.
  [INFO] Excluding oro:oro:jar:2.0.8 from the shaded jar.
  [INFO] Excluding net.razorvine:pyrolite:jar:4.13 from the shaded jar.
  [INFO] Excluding net.sf.py4j:py4j:jar:0.10.6 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-crypto:jar:1.0.0 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Excluding commons-io:commons-io:jar:2.4 from the shaded jar.
  [INFO] Excluding xerces:xercesImpl:jar:2.11.0 from the shaded jar.
  [INFO] Excluding commons-logging:commons-logging:jar:1.2 from the shaded jar.
  [INFO] Excluding commons-collections:commons-collections:jar:3.2.2 from the shaded jar.
  [INFO] Excluding org.apache.httpcomponents:httpclient:jar:4.5.4 from the shaded jar.
  [INFO] Excluding org.objenesis:objenesis:jar:2.1 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Excluding org.scala-lang:scala-reflect:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.scala-lang.modules:scala-xml_2.11:jar:1.0.5 from the shaded jar.
  [INFO] Excluding org.scala-lang.modules:scala-parser-combinators_2.11:jar:1.0.4 from the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/streaming/target/spark-streaming_2.11-2.3.1-SNAPSHOT.jar with /root/spark/streaming/target/spark-streaming_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Replacing original test artifact with shaded test artifact.
  [INFO] Replacing /root/spark/streaming/target/spark-streaming_2.11-2.3.1-SNAPSHOT-tests.jar with /root/spark/streaming/target/spark-streaming_2.11-2.3.1-SNAPSHOT-shaded-tests.jar
  [INFO] Dependency-reduced POM written at: /root/spark/streaming/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-streaming_2.11 ---
  [INFO] Building jar: /root/spark/streaming/target/spark-streaming_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-streaming_2.11 ---
  [INFO] Building jar: /root/spark/streaming/target/spark-streaming_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project Catalyst 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-catalyst_2.11 ---
  [INFO] Deleting /root/spark/sql/catalyst/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-catalyst_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-catalyst_2.11 ---
  [INFO] Add Source directory: /root/spark/sql/catalyst/src/main/scala
  [INFO] Add Test Source directory: /root/spark/sql/catalyst/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-catalyst_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/org/antlr/antlr4-runtime/4.7/antlr4-runtime-4.7.jar:/root/.m2/repository/org/codehaus/janino/commons-compiler/3.0.8/commons-compiler-3.0.8.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/org/codehaus/janino/janino/3.0.8/janino-3.0.8.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar
  [INFO]
  [INFO] --- antlr4-maven-plugin:4.7:antlr4 (default) @ spark-catalyst_2.11 ---
  [INFO] ANTLR 4: Processing source directory /root/spark/sql/catalyst/src/main/antlr4
  [INFO] Processing grammar: org/apache/spark/sql/catalyst/parser/SqlBase.g4
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-catalyst_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-catalyst_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] skip non existing resourceDirectory /root/spark/sql/catalyst/src/main/resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-catalyst_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-catalyst_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 222 Scala sources and 29 Java sources to /root/spark/sql/catalyst/target/scala-2.11/classes...


  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-catalyst_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/sql/catalyst/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-catalyst_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 1 resource
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-catalyst_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-catalyst_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/eclipse/jetty/jetty-continuation/9.3.20.v20170531/jetty-continuation-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlets/9.3.20.v20170531/jetty-servlets-9.3.20.v20170531.jar:/root/.m2/repository/xml-apis/xml-apis/1.4.01/xml-apis-1.4.01.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/org/antlr/antlr4-runtime/4.7/antlr4-runtime-4.7.jar:/root/.m2/repository/org/codehaus/janino/commons-compiler/3.0.8/commons-compiler-3.0.8.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/org/eclipse/jetty/jetty-xml/9.3.20.v20170531/jetty-xml-9.3.20.v20170531.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/scalacheck/scalacheck_2.11/1.13.5/scalacheck_2.11-1.13.5.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/eclipse/jetty/jetty-server/9.3.20.v20170531/jetty-server-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/org/tukaani/xz/1.0/xz-1.0.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/.m2/repository/org/eclipse/jetty/jetty-client/9.3.20.v20170531/jetty-client-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-util/9.3.20.v20170531/jetty-util-9.3.20.v20170531.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/apache/avro/avro/1.7.7/avro-1.7.7.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/eclipse/jetty/jetty-proxy/9.3.20.v20170531/jetty-proxy-9.3.20.v20170531.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.4.1/commons-compress-1.4.1.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7-tests.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/eclipse/jetty/jetty-webapp/9.3.20.v20170531/jetty-webapp-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-http/9.3.20.v20170531/jetty-http-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-security/9.3.20.v20170531/jetty-security-9.3.20.v20170531.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-io/9.3.20.v20170531/jetty-io-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-plus/9.3.20.v20170531/jetty-plus-9.3.20.v20170531.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/org/eclipse/jetty/jetty-jndi/9.3.20.v20170531/jetty-jndi-9.3.20.v20170531.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlet/9.3.20.v20170531/jetty-servlet-9.3.20.v20170531.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/org/codehaus/janino/janino/3.0.8/janino-3.0.8.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-catalyst_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 170 Scala sources and 5 Java sources to /root/spark/sql/catalyst/target/scala-2.11/test-classes...
  [WARNING] /root/spark/sql/catalyst/src/test/scala/org/apache/spark/sql/catalyst/analysis/AnalysisSuite.scala:523: abstract type T is unchecked since it is eliminated by erasure
  [WARNING]       assert(partitioning.isInstanceOf[T])
  [WARNING]                                       ^
  [WARNING] /root/spark/sql/catalyst/src/test/scala/org/apache/spark/sql/catalyst/analysis/AnalysisSuite.scala:523: abstract type T is unchecked since it is eliminated by erasure
  [WARNING]       assert(partitioning.isInstanceOf[T])
  [WARNING]             ^
  [WARNING] two warnings found
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:test-jar (prepare-test-jar) @ spark-catalyst_2.11 ---
  [INFO] Building jar: /root/spark/sql/catalyst/target/spark-catalyst_2.11-2.3.1-SNAPSHOT-tests.jar
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (default-test) @ spark-catalyst_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-surefire-plugin:2.20.1:test (test) @ spark-catalyst_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- scalatest-maven-plugin:1.0:test (test) @ spark-catalyst_2.11 ---
  [INFO] Tests are skipped.
  [INFO]
  [INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ spark-catalyst_2.11 ---
  [INFO] Building jar: /root/spark/sql/catalyst/target/spark-catalyst_2.11-2.3.1-SNAPSHOT.jar
  [INFO]
  [INFO] --- maven-site-plugin:3.5.1:attach-descriptor (attach-descriptor) @ spark-catalyst_2.11 ---
  [INFO]
  [INFO] --- maven-shade-plugin:3.1.0:shade (default) @ spark-catalyst_2.11 ---
  [INFO] Excluding org.scala-lang:scala-reflect:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-library:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.scala-lang.modules:scala-parser-combinators_2.11:jar:1.0.4 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-core_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.avro:avro:jar:1.7.7 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-core-asl:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-mapper-asl:jar:1.9.13 from the shaded jar.
  [INFO] Excluding com.thoughtworks.paranamer:paranamer:jar:2.8 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-compress:jar:1.4.1 from the shaded jar.
  [INFO] Excluding org.tukaani:xz:jar:1.0 from the shaded jar.
  [INFO] Excluding org.apache.avro:avro-mapred:jar:hadoop2:1.7.7 from the shaded jar.
  [INFO] Excluding org.apache.avro:avro-ipc:jar:1.7.7 from the shaded jar.
  [INFO] Excluding com.twitter:chill_2.11:jar:0.8.4 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:kryo-shaded:jar:3.0.3 from the shaded jar.
  [INFO] Excluding com.esotericsoftware:minlog:jar:1.3.0 from the shaded jar.
  [INFO] Excluding org.objenesis:objenesis:jar:2.1 from the shaded jar.
  [INFO] Excluding com.twitter:chill-java:jar:0.8.4 from the shaded jar.
  [INFO] Excluding org.apache.xbean:xbean-asm5-shaded:jar:4.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-client:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding commons-cli:commons-cli:jar:1.2 from the shaded jar.
  [INFO] Excluding xmlenc:xmlenc:jar:0.52 from the shaded jar.
  [INFO] Excluding commons-httpclient:commons-httpclient:jar:3.1 from the shaded jar.
  [INFO] Excluding commons-io:commons-io:jar:2.4 from the shaded jar.
  [INFO] Excluding commons-collections:commons-collections:jar:3.2.2 from the shaded jar.
  [INFO] Excluding commons-lang:commons-lang:jar:2.6 from the shaded jar.
  [INFO] Excluding commons-configuration:commons-configuration:jar:1.6 from the shaded jar.
  [INFO] Excluding commons-digester:commons-digester:jar:1.8 from the shaded jar.
  [INFO] Excluding commons-beanutils:commons-beanutils:jar:1.7.0 from the shaded jar.
  [INFO] Excluding commons-beanutils:commons-beanutils-core:jar:1.8.0 from the shaded jar.
  [INFO] Excluding com.google.protobuf:protobuf-java:jar:2.5.0 from the shaded jar.
  [INFO] Excluding com.google.code.gson:gson:jar:2.2.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-auth:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.directory.server:apacheds-kerberos-codec:jar:2.0.0-M15 from the shaded jar.
  [INFO] Excluding org.apache.directory.server:apacheds-i18n:jar:2.0.0-M15 from the shaded jar.
  [INFO] Excluding org.apache.directory.api:api-asn1-api:jar:1.0.0-M20 from the shaded jar.
  [INFO] Excluding org.apache.directory.api:api-util:jar:1.0.0-M20 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-client:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.htrace:htrace-core:jar:3.0.4 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-hdfs:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.mortbay.jetty:jetty-util:jar:6.1.26 from the shaded jar.
  [INFO] Excluding xerces:xercesImpl:jar:2.9.1 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-app:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-client:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-server-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-shuffle:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-api:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-core:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-yarn-common:jar:2.6.5 from the shaded jar.
  [INFO] Excluding javax.xml.bind:jaxb-api:jar:2.2.2 from the shaded jar.
  [INFO] Excluding javax.xml.stream:stax-api:jar:1.0-2 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-jaxrs:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.codehaus.jackson:jackson-xc:jar:1.9.13 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-mapreduce-client-jobclient:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.hadoop:hadoop-annotations:jar:2.6.5 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-launcher_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-kvstore_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.fusesource.leveldbjni:leveldbjni-all:jar:1.8 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-core:jar:2.6.7 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-annotations:jar:2.6.7 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-network-common_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-network-shuffle_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding net.java.dev.jets3t:jets3t:jar:0.9.4 from the shaded jar.
  [INFO] Excluding org.apache.httpcomponents:httpcore:jar:4.4.8 from the shaded jar.
  [INFO] Excluding org.apache.httpcomponents:httpclient:jar:4.5.4 from the shaded jar.
  [INFO] Excluding javax.activation:activation:jar:1.1.1 from the shaded jar.
  [INFO] Excluding org.bouncycastle:bcprov-jdk15on:jar:1.58 from the shaded jar.
  [INFO] Excluding com.jamesmurty.utils:java-xmlbuilder:jar:1.1 from the shaded jar.
  [INFO] Excluding net.iharder:base64:jar:2.3.8 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-recipes:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.curator:curator-framework:jar:2.6.0 from the shaded jar.
  [INFO] Excluding org.apache.zookeeper:zookeeper:jar:3.4.6 from the shaded jar.
  [INFO] Excluding javax.servlet:javax.servlet-api:jar:3.1.0 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-lang3:jar:3.5 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-math3:jar:3.4.1 from the shaded jar.
  [INFO] Excluding com.google.code.findbugs:jsr305:jar:1.3.9 from the shaded jar.
  [INFO] Excluding org.slf4j:slf4j-api:jar:1.7.16 from the shaded jar.
  [INFO] Excluding org.slf4j:jul-to-slf4j:jar:1.7.16 from the shaded jar.
  [INFO] Excluding org.slf4j:jcl-over-slf4j:jar:1.7.16 from the shaded jar.
  [INFO] Excluding log4j:log4j:jar:1.2.17 from the shaded jar.
  [INFO] Excluding org.slf4j:slf4j-log4j12:jar:1.7.16 from the shaded jar.
  [INFO] Excluding com.ning:compress-lzf:jar:1.0.3 from the shaded jar.
  [INFO] Excluding org.xerial.snappy:snappy-java:jar:1.1.2.6 from the shaded jar.
  [INFO] Excluding org.lz4:lz4-java:jar:1.4.0 from the shaded jar.
  [INFO] Excluding com.github.luben:zstd-jni:jar:1.3.2-2 from the shaded jar.
  [INFO] Excluding org.roaringbitmap:RoaringBitmap:jar:0.5.11 from the shaded jar.
  [INFO] Excluding commons-net:commons-net:jar:2.2 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-jackson_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-core_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.json4s:json4s-ast_2.11:jar:3.2.11 from the shaded jar.
  [INFO] Excluding org.scala-lang:scalap:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.scala-lang:scala-compiler:jar:2.11.8 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-client:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.ws.rs:javax.ws.rs-api:jar:2.0.1 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-api:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-utils:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2.external:aopalliance-repackaged:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2.external:javax.inject:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:hk2-locator:jar:2.4.0-b34 from the shaded jar.
  [INFO] Excluding org.javassist:javassist:jar:3.18.1-GA from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-common:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.annotation:javax.annotation-api:jar:1.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.bundles.repackaged:jersey-guava:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.hk2:osgi-resource-locator:jar:1.0.1 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.core:jersey-server:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.media:jersey-media-jaxb:jar:2.22.2 from the shaded jar.
  [INFO] Excluding javax.validation:validation-api:jar:1.1.0.Final from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet:jar:2.22.2 from the shaded jar.
  [INFO] Excluding org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.22.2 from the shaded jar.
  [INFO] Excluding io.netty:netty-all:jar:4.1.17.Final from the shaded jar.
  [INFO] Excluding io.netty:netty:jar:3.9.9.Final from the shaded jar.
  [INFO] Excluding com.clearspring.analytics:stream:jar:2.7.0 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-core:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-jvm:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-json:jar:3.1.5 from the shaded jar.
  [INFO] Excluding io.dropwizard.metrics:metrics-graphite:jar:3.1.5 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.core:jackson-databind:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.module:jackson-module-scala_2.11:jar:2.6.7.1 from the shaded jar.
  [INFO] Excluding com.fasterxml.jackson.module:jackson-module-paranamer:jar:2.7.9 from the shaded jar.
  [INFO] Excluding org.apache.ivy:ivy:jar:2.4.0 from the shaded jar.
  [INFO] Excluding oro:oro:jar:2.0.8 from the shaded jar.
  [INFO] Excluding net.razorvine:pyrolite:jar:4.13 from the shaded jar.
  [INFO] Excluding net.sf.py4j:py4j:jar:0.10.6 from the shaded jar.
  [INFO] Excluding org.apache.commons:commons-crypto:jar:1.0.0 from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-tags_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-unsafe_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.apache.spark:spark-sketch_2.11:jar:2.3.1-SNAPSHOT from the shaded jar.
  [INFO] Excluding org.codehaus.janino:janino:jar:3.0.8 from the shaded jar.
  [INFO] Excluding org.codehaus.janino:commons-compiler:jar:3.0.8 from the shaded jar.
  [INFO] Excluding org.antlr:antlr4-runtime:jar:4.7 from the shaded jar.
  [INFO] Excluding commons-codec:commons-codec:jar:1.10 from the shaded jar.
  [INFO] Including org.spark-project.spark:unused:jar:1.0.0 in the shaded jar.
  [INFO] Excluding org.scala-lang.modules:scala-xml_2.11:jar:1.0.5 from the shaded jar.
  [INFO] Replacing original artifact with shaded artifact.
  [INFO] Replacing /root/spark/sql/catalyst/target/spark-catalyst_2.11-2.3.1-SNAPSHOT.jar with /root/spark/sql/catalyst/target/spark-catalyst_2.11-2.3.1-SNAPSHOT-shaded.jar
  [INFO] Dependency-reduced POM written at: /root/spark/sql/catalyst/dependency-reduced-pom.xml
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:jar-no-fork (create-source-jar) @ spark-catalyst_2.11 ---
  [INFO] Building jar: /root/spark/sql/catalyst/target/spark-catalyst_2.11-2.3.1-SNAPSHOT-sources.jar
  [INFO]
  [INFO] --- maven-source-plugin:3.0.1:test-jar-no-fork (create-source-jar) @ spark-catalyst_2.11 ---
  [INFO] Building jar: /root/spark/sql/catalyst/target/spark-catalyst_2.11-2.3.1-SNAPSHOT-test-sources.jar
  [INFO]
  [INFO] ------------------------------------------------------------------------
  [INFO] Building Spark Project SQL 2.3.1-SNAPSHOT
  [INFO] ------------------------------------------------------------------------
  [INFO]
  [INFO] --- maven-clean-plugin:3.0.0:clean (default-clean) @ spark-sql_2.11 ---
  [INFO] Deleting /root/spark/sql/core/target
  [INFO]
  [INFO] --- maven-enforcer-plugin:3.0.0-M1:enforce (enforce-versions) @ spark-sql_2.11 ---
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:add-source (eclipse-add-source) @ spark-sql_2.11 ---
  [INFO] Add Source directory: /root/spark/sql/core/src/main/scala
  [INFO] Add Test Source directory: /root/spark/sql/core/src/test/scala
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (default-cli) @ spark-sql_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/org/apache/parquet/parquet-format/2.3.1/parquet-format-2.3.1.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.8.1/commons-compress-1.8.1.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/org/antlr/antlr4-runtime/4.7/antlr4-runtime-4.7.jar:/root/.m2/repository/org/codehaus/janino/commons-compiler/3.0.8/commons-compiler-3.0.8.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/com/univocity/univocity-parsers/2.5.9/univocity-parsers-2.5.9.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/org/apache/orc/orc-core/1.4.1/orc-core-1.4.1-nohive.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/.m2/repository/org/apache/parquet/parquet-jackson/1.8.2/parquet-jackson-1.8.2.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/joda-time/joda-time/2.9.3/joda-time-2.9.3.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/org/apache/arrow/arrow-format/0.8.0/arrow-format-0.8.0.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/spark/sql/catalyst/target/spark-catalyst_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/parquet/parquet-column/1.8.2/parquet-column-1.8.2.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/.m2/repository/org/apache/parquet/parquet-common/1.8.2/parquet-common-1.8.2.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/apache/arrow/arrow-memory/0.8.0/arrow-memory-0.8.0.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/.m2/repository/io/airlift/aircompressor/0.8/aircompressor-0.8.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/vlkan/flatbuffers/1.2.0-3f79e055/flatbuffers-1.2.0-3f79e055.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/apache/parquet/parquet-encoding/1.8.2/parquet-encoding-1.8.2.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/org/apache/arrow/arrow-vector/0.8.0/arrow-vector-0.8.0.jar:/root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/apache/parquet/parquet-hadoop/1.8.2/parquet-hadoop-1.8.2.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/com/carrotsearch/hppc/0.7.2/hppc-0.7.2.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/org/codehaus/janino/janino/3.0.8/janino-3.0.8.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/org/apache/orc/orc-mapreduce/1.4.1/orc-mapreduce-1.4.1-nohive.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar
  [INFO]
  [INFO] --- maven-remote-resources-plugin:1.5:process (process-resource-bundles) @ spark-sql_2.11 ---
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:resources (default-resources) @ spark-sql_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 4 resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:compile (default-compile) @ spark-sql_2.11 ---
  [INFO] Not compiling main sources
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:compile (scala-compile-first) @ spark-sql_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 319 Scala sources and 94 Java sources to /root/spark/sql/core/target/scala-2.11/classes...
  [WARNING] Class org.apache.avro.reflect.Stringable not found - continuing with a stub.
  [WARNING] Class org.apache.avro.reflect.Stringable not found - continuing with a stub.
  [WARNING] /root/spark/sql/core/src/main/scala/org/apache/spark/sql/execution/streaming/TriggerExecutor.scala:46: class ProcessingTime in package streaming is deprecated: use Trigger.ProcessingTime(intervalMs)
  [WARNING] case class ProcessingTimeExecutor(processingTime: ProcessingTime, clock: Clock = new SystemClock())
  [WARNING]                                                   ^
  [WARNING] /root/spark/sql/core/src/main/scala/org/apache/spark/sql/execution/streaming/TriggerExecutor.scala:46: class ProcessingTime in package streaming is deprecated: use Trigger.ProcessingTime(intervalMs)
  [WARNING] case class ProcessingTimeExecutor(processingTime: ProcessingTime, clock: Clock = new SystemClock())
  [WARNING]            ^
  [WARNING] four warnings found
  [WARNING] /root/spark/sql/core/src/main/java/org/apache/spark/sql/execution/datasources/parquet/SpecificParquetRecordReaderBase.java:148: warning: [deprecation] ParquetFileReader(Configuration,FileMetaData,Path,List<BlockMetaData>,List<ColumnDescriptor>) in ParquetFileReader has been deprecated
  [WARNING]     this.reader = new ParquetFileReader(
  [WARNING]                   ^
  [WARNING] /root/spark/sql/core/src/main/java/org/apache/spark/sql/execution/datasources/parquet/SpecificParquetRecordReaderBase.java:226: warning: [deprecation] ParquetFileReader(Configuration,FileMetaData,Path,List<BlockMetaData>,List<ColumnDescriptor>) in ParquetFileReader has been deprecated
  [WARNING]     this.reader = new ParquetFileReader(
  [WARNING]                   ^
  [WARNING] /root/spark/sql/core/src/main/java/org/apache/spark/sql/streaming/Trigger.java:43: warning: [deprecation] ProcessingTime in org.apache.spark.sql.streaming has been deprecated
  [WARNING]       return ProcessingTime.create(intervalMs, TimeUnit.MILLISECONDS);
  [WARNING]              ^
  [WARNING] /root/spark/sql/core/src/main/java/org/apache/spark/sql/streaming/Trigger.java:59: warning: [deprecation] ProcessingTime in org.apache.spark.sql.streaming has been deprecated
  [WARNING]       return ProcessingTime.create(interval, timeUnit);
  [WARNING]              ^
  [WARNING] /root/spark/sql/core/src/main/java/org/apache/spark/sql/streaming/Trigger.java:74: warning: [deprecation] ProcessingTime in org.apache.spark.sql.streaming has been deprecated
  [WARNING]       return ProcessingTime.apply(interval);
  [WARNING]              ^
  [WARNING] /root/spark/sql/core/src/main/java/org/apache/spark/sql/streaming/Trigger.java:87: warning: [deprecation] ProcessingTime in org.apache.spark.sql.streaming has been deprecated
  [WARNING]       return ProcessingTime.apply(interval);
  [WARNING]              ^
  [WARNING] /root/spark/sql/core/src/main/java/org/apache/spark/sql/vectorized/ArrowColumnVector.java:456: warning: [static] static variable should be qualified by type name, BaseRepeatedValueVector, instead of by an expression
  [WARNING]       int index = rowId * accessor.OFFSET_WIDTH;
  [WARNING]                                   ^
  [WARNING] /root/spark/sql/core/src/main/java/org/apache/spark/sql/vectorized/ArrowColumnVector.java:458: warning: [static] static variable should be qualified by type name, BaseRepeatedValueVector, instead of by an expression
  [WARNING]       int end = offsets.getInt(index + accessor.OFFSET_WIDTH);
  [WARNING]                                                ^
  [WARNING] 8 warnings
  [INFO]
  [INFO] --- build-helper-maven-plugin:3.0.0:add-test-source (add-scala-test-sources) @ spark-sql_2.11 ---
  [INFO] Test Source directory: /root/spark/sql/core/src/test/gen-java added.
  [INFO]
  [INFO] --- maven-antrun-plugin:1.8:run (create-tmp-dir) @ spark-sql_2.11 ---
  [INFO] Executing tasks

  main:
      [mkdir] Created dir: /root/spark/sql/core/target/tmp
  [INFO] Executed tasks
  [INFO]
  [INFO] --- maven-resources-plugin:2.7:testResources (default-testResources) @ spark-sql_2.11 ---
  [INFO] Using 'UTF-8' encoding to copy filtered resources.
  [INFO] Copying 408 resources
  [INFO] Copying 3 resources
  [INFO]
  [INFO] --- maven-compiler-plugin:3.7.0:testCompile (default-testCompile) @ spark-sql_2.11 ---
  [INFO] Not compiling test sources
  [INFO]
  [INFO] --- maven-dependency-plugin:3.0.2:build-classpath (generate-test-classpath) @ spark-sql_2.11 ---
  [INFO] Dependencies classpath:
  /root/.m2/repository/com/fasterxml/jackson/module/jackson-module-scala_2.11/2.6.7.1/jackson-module-scala_2.11-2.6.7.1.jar:/root/.m2/repository/org/apache/parquet/parquet-format/2.3.1/parquet-format-2.3.1.jar:/root/.m2/repository/org/lz4/lz4-java/1.4.0/lz4-java-1.4.0.jar:/root/.m2/repository/com/google/protobuf/protobuf-java/2.5.0/protobuf-java-2.5.0.jar:/root/.m2/repository/com/h2database/h2/1.4.195/h2-1.4.195.jar:/root/.m2/repository/org/scalactic/scalactic_2.11/3.0.3/scalactic_2.11-3.0.3.jar:/root/.m2/repository/com/fasterxml/jackson/module/jackson-module-paranamer/2.7.9/jackson-module-paranamer-2.7.9.jar:/root/.m2/repository/org/apache/commons/commons-compress/1.8.1/commons-compress-1.8.1.jar:/root/.m2/repository/com/thoughtworks/paranamer/paranamer/2.8/paranamer-2.8.jar:/root/.m2/repository/com/twitter/chill_2.11/0.8.4/chill_2.11-0.8.4.jar:/root/.m2/repository/org/eclipse/jetty/jetty-continuation/9.3.20.v20170531/jetty-continuation-9.3.20.v20170531.jar:/root/.m2/repository/org/mockito/mockito-core/1.10.19/mockito-core-1.10.19.jar:/root/.m2/repository/org/apache/hadoop/hadoop-hdfs/2.6.5/hadoop-hdfs-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlets/9.3.20.v20170531/jetty-servlets-9.3.20.v20170531.jar:/root/.m2/repository/xml-apis/xml-apis/1.4.01/xml-apis-1.4.01.jar:/root/.m2/repository/org/fusesource/leveldbjni/leveldbjni-all/1.8/leveldbjni-all-1.8.jar:/root/.m2/repository/org/glassfish/jersey/bundles/repackaged/jersey-guava/2.22.2/jersey-guava-2.22.2.jar:/root/.m2/repository/org/tukaani/xz/1.5/xz-1.5.jar:/root/.m2/repository/org/apache/commons/commons-crypto/1.0.0/commons-crypto-1.0.0.jar:/root/.m2/repository/org/antlr/antlr4-runtime/4.7/antlr4-runtime-4.7.jar:/root/.m2/repository/org/codehaus/janino/commons-compiler/3.0.8/commons-compiler-3.0.8.jar:/root/.m2/repository/com/twitter/chill-java/0.8.4/chill-java-0.8.4.jar:/root/.m2/repository/commons-io/commons-io/2.4/commons-io-2.4.jar:/root/.m2/repository/org/apache/httpcomponents/httpclient/4.5.4/httpclient-4.5.4.jar:/root/.m2/repository/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar:/root/.m2/repository/org/codehaus/jackson/jackson-jaxrs/1.9.13/jackson-jaxrs-1.9.13.jar:/root/.m2/repository/com/univocity/univocity-parsers/2.5.9/univocity-parsers-2.5.9.jar:/root/.m2/repository/org/scala-lang/scala-reflect/2.11.8/scala-reflect-2.11.8.jar:/root/.m2/repository/org/apache/orc/orc-core/1.4.1/orc-core-1.4.1-nohive.jar:/root/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar:/root/.m2/repository/com/esotericsoftware/minlog/1.3.0/minlog-1.3.0.jar:/root/.m2/repository/org/codehaus/jackson/jackson-core-asl/1.9.13/jackson-core-asl-1.9.13.jar:/root/.m2/repository/org/eclipse/jetty/jetty-xml/9.3.20.v20170531/jetty-xml-9.3.20.v20170531.jar:/root/.m2/repository/javax/validation/validation-api/1.1.0.Final/validation-api-1.1.0.Final.jar:/root/.m2/repository/org/scalacheck/scalacheck_2.11/1.13.5/scalacheck_2.11-1.13.5.jar:/root/.m2/repository/org/bouncycastle/bcprov-jdk15on/1.58/bcprov-jdk15on-1.58.jar:/root/.m2/repository/org/apache/parquet/parquet-jackson/1.8.2/parquet-jackson-1.8.2.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-common/2.22.2/jersey-common-2.22.2.jar:/root/spark/common/network-shuffle/target/spark-network-shuffle_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/joda-time/joda-time/2.9.3/joda-time-2.9.3.jar:/root/.m2/repository/org/scala-lang/modules/scala-xml_2.11/1.0.5/scala-xml_2.11-1.0.5.jar:/root/.m2/repository/com/google/code/findbugs/jsr305/1.3.9/jsr305-1.3.9.jar:/root/.m2/repository/org/apache/arrow/arrow-format/0.8.0/arrow-format-0.8.0.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/javax/xml/bind/jaxb-api/2.2.2/jaxb-api-2.2.2.jar:/root/.m2/repository/org/glassfish/hk2/hk2-api/2.4.0-b34/hk2-api-2.4.0-b34.jar:/root/.m2/repository/it/unimi/dsi/fastutil/6.5.7/fastutil-6.5.7.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-server/2.22.2/jersey-server-2.22.2.jar:/root/.m2/repository/commons-lang/commons-lang/2.6/commons-lang-2.6.jar:/root/.m2/repository/org/eclipse/jetty/jetty-server/9.3.20.v20170531/jetty-server-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/zookeeper/zookeeper/3.4.6/zookeeper-3.4.6.jar:/root/.m2/repository/javax/activation/activation/1.1.1/activation-1.1.1.jar:/root/.m2/repository/commons-codec/commons-codec/1.10/commons-codec-1.10.jar:/root/.m2/repository/org/javassist/javassist/3.18.1-GA/javassist-3.18.1-GA.jar:/root/.m2/repository/com/google/guava/guava/14.0.1/guava-14.0.1.jar:/root/spark/sql/catalyst/target/spark-catalyst_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/parquet/parquet-column/1.8.2/parquet-column-1.8.2.jar:/root/.m2/repository/org/eclipse/jetty/jetty-client/9.3.20.v20170531/jetty-client-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-api/2.6.5/hadoop-yarn-api-2.6.5.jar:/root/.m2/repository/org/apache/httpcomponents/httpcore/4.4.8/httpcore-4.4.8.jar:/root/.m2/repository/org/apache/ivy/ivy/2.4.0/ivy-2.4.0.jar:/root/.m2/repository/org/apache/hadoop/hadoop-common/2.6.5/hadoop-common-2.6.5.jar:/root/.m2/repository/org/apache/parquet/parquet-avro/1.8.2/parquet-avro-1.8.2.jar:/root/.m2/repository/commons-beanutils/commons-beanutils-core/1.8.0/commons-beanutils-core-1.8.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-util/9.3.20.v20170531/jetty-util-9.3.20.v20170531.jar:/root/.m2/repository/javax/servlet/javax.servlet-api/3.1.0/javax.servlet-api-3.1.0.jar:/root/.m2/repository/org/glassfish/hk2/osgi-resource-locator/1.0.1/osgi-resource-locator-1.0.1.jar:/root/spark/common/kvstore/target/spark-kvstore_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.6.7/jackson-core-2.6.7.jar:/root/.m2/repository/org/apache/commons/commons-math3/3.4.1/commons-math3-3.4.1.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-graphite/3.1.5/metrics-graphite-3.1.5.jar:/root/.m2/repository/javax/xml/stream/stax-api/1.0-2/stax-api-1.0-2.jar:/root/.m2/repository/org/codehaus/jackson/jackson-xc/1.9.13/jackson-xc-1.9.13.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-app/2.6.5/hadoop-mapreduce-client-app-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-server-common/2.6.5/hadoop-yarn-server-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/hk2-utils/2.4.0-b34/hk2-utils-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/hk2/external/aopalliance-repackaged/2.4.0-b34/aopalliance-repackaged-2.4.0-b34.jar:/root/.m2/repository/org/apache/avro/avro/1.8.1/avro-1.8.1.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-common/2.6.5/hadoop-yarn-common-2.6.5.jar:/root/.m2/repository/org/glassfish/hk2/external/javax.inject/2.4.0-b34/javax.inject-2.4.0-b34.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet-core/2.22.2/jersey-container-servlet-core-2.22.2.jar:/root/.m2/repository/oro/oro/2.0.8/oro-2.0.8.jar:/root/.m2/repository/org/scala-lang/scala-compiler/2.11.8/scala-compiler-2.11.8.jar:/root/.m2/repository/org/apache/hadoop/hadoop-annotations/2.6.5/hadoop-annotations-2.6.5.jar:/root/.m2/repository/org/apache/curator/curator-framework/2.6.0/curator-framework-2.6.0.jar:/root/.m2/repository/org/scalatest/scalatest_2.11/3.0.3/scalatest_2.11-3.0.3.jar:/root/.m2/repository/org/apache/parquet/parquet-common/1.8.2/parquet-common-1.8.2.jar:/root/.m2/repository/org/roaringbitmap/RoaringBitmap/0.5.11/RoaringBitmap-0.5.11.jar:/root/.m2/repository/log4j/log4j/1.2.17/log4j-1.2.17.jar:/root/.m2/repository/com/novocode/junit-interface/0.11/junit-interface-0.11.jar:/root/.m2/repository/org/scala-lang/scala-library/2.11.8/scala-library-2.11.8.jar:/root/.m2/repository/org/eclipse/jetty/jetty-proxy/9.3.20.v20170531/jetty-proxy-9.3.20.v20170531.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-json/3.1.5/metrics-json-3.1.5.jar:/root/.m2/repository/org/apache/directory/server/apacheds-kerberos-codec/2.0.0-M15/apacheds-kerberos-codec-2.0.0-M15.jar:/root/.m2/repository/org/apache/curator/curator-recipes/2.6.0/curator-recipes-2.6.0.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-core/3.1.5/metrics-core-3.1.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-auth/2.6.5/hadoop-auth-2.6.5.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-shuffle/2.6.5/hadoop-mapreduce-client-shuffle-2.6.5.jar:/root/.m2/repository/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar:/root/.m2/repository/org/apache/arrow/arrow-memory/0.8.0/arrow-memory-0.8.0.jar:/root/.m2/repository/org/apache/xbean/xbean-asm5-shaded/4.4/xbean-asm5-shaded-4.4.jar:/root/spark/common/unsafe/target/spark-unsafe_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar:/root/.m2/repository/org/mortbay/jetty/jetty-util/6.1.26/jetty-util-6.1.26.jar:/root/.m2/repository/io/airlift/aircompressor/0.8/aircompressor-0.8.jar:/root/spark/common/network-common/target/spark-network-common_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/com/vlkan/flatbuffers/1.2.0-3f79e055/flatbuffers-1.2.0-3f79e055.jar:/root/.m2/repository/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar:/root/.m2/repository/mysql/mysql-connector-java/5.1.38/mysql-connector-java-5.1.38.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-core/2.6.5/hadoop-mapreduce-client-core-2.6.5.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.6.7.1/jackson-databind-2.6.7.1.jar:/root/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/root/.m2/repository/net/sf/py4j/py4j/0.10.6/py4j-0.10.6.jar:/root/.m2/repository/org/codehaus/jackson/jackson-mapper-asl/1.9.13/jackson-mapper-asl-1.9.13.jar:/root/spark/core/target/spark-core_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/javax/ws/rs/javax.ws.rs-api/2.0.1/javax.ws.rs-api-2.0.1.jar:/root/.m2/repository/com/esotericsoftware/kryo-shaded/3.0.3/kryo-shaded-3.0.3.jar:/root/.m2/repository/org/glassfish/jersey/core/jersey-client/2.22.2/jersey-client-2.22.2.jar:/root/.m2/repository/io/netty/netty/3.9.9.Final/netty-3.9.9.Final.jar:/root/.m2/repository/org/apache/avro/avro-mapred/1.7.7/avro-mapred-1.7.7-hadoop2.jar:/root/spark/common/tags/target/spark-tags_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7-tests.jar:/root/.m2/repository/org/postgresql/postgresql/9.4.1207.jre7/postgresql-9.4.1207.jre7.jar:/root/.m2/repository/xmlenc/xmlenc/0.52/xmlenc-0.52.jar:/root/.m2/repository/com/ning/compress-lzf/1.0.3/compress-lzf-1.0.3.jar:/root/.m2/repository/org/apache/parquet/parquet-encoding/1.8.2/parquet-encoding-1.8.2.jar:/root/.m2/repository/org/eclipse/jetty/jetty-webapp/9.3.20.v20170531/jetty-webapp-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/api/api-util/1.0.0-M20/api-util-1.0.0-M20.jar:/root/.m2/repository/org/apache/arrow/arrow-vector/0.8.0/arrow-vector-0.8.0.jar:/root/spark/common/sketch/target/spark-sketch_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/commons-net/commons-net/2.2/commons-net-2.2.jar:/root/spark/sql/catalyst/target/spark-catalyst_2.11-2.3.1-SNAPSHOT-tests.jar:/root/.m2/repository/com/google/code/gson/gson/2.2.4/gson-2.2.4.jar:/root/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar:/root/.m2/repository/org/apache/directory/api/api-asn1-api/1.0.0-M20/api-asn1-api-1.0.0-M20.jar:/root/.m2/repository/org/scala-lang/scalap/2.11.8/scalap-2.11.8.jar:/root/.m2/repository/com/clearspring/analytics/stream/2.7.0/stream-2.7.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-http/9.3.20.v20170531/jetty-http-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/curator/curator-client/2.6.0/curator-client-2.6.0.jar:/root/.m2/repository/org/eclipse/jetty/jetty-security/9.3.20.v20170531/jetty-security-9.3.20.v20170531.jar:/root/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.6.7/jackson-annotations-2.6.7.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-common/2.6.5/hadoop-mapreduce-client-common-2.6.5.jar:/root/.m2/repository/commons-configuration/commons-configuration/1.6/commons-configuration-1.6.jar:/root/.m2/repository/org/glassfish/jersey/containers/jersey-container-servlet/2.22.2/jersey-container-servlet-2.22.2.jar:/root/.m2/repository/commons-digester/commons-digester/1.8/commons-digester-1.8.jar:/root/.m2/repository/org/slf4j/jul-to-slf4j/1.7.16/jul-to-slf4j-1.7.16.jar:/root/.m2/repository/org/apache/hadoop/hadoop-mapreduce-client-jobclient/2.6.5/hadoop-mapreduce-client-jobclient-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-io/9.3.20.v20170531/jetty-io-9.3.20.v20170531.jar:/root/.m2/repository/org/apache/directory/server/apacheds-i18n/2.0.0-M15/apacheds-i18n-2.0.0-M15.jar:/root/.m2/repository/commons-beanutils/commons-beanutils/1.7.0/commons-beanutils-1.7.0.jar:/root/.m2/repository/org/htrace/htrace-core/3.0.4/htrace-core-3.0.4.jar:/root/.m2/repository/org/apache/parquet/parquet-hadoop/1.8.2/parquet-hadoop-1.8.2.jar:/root/.m2/repository/org/apache/hadoop/hadoop-client/2.6.5/hadoop-client-2.6.5.jar:/root/.m2/repository/org/eclipse/jetty/jetty-plus/9.3.20.v20170531/jetty-plus-9.3.20.v20170531.jar:/root/.m2/repository/org/scala-lang/modules/scala-parser-combinators_2.11/1.0.4/scala-parser-combinators_2.11-1.0.4.jar:/root/.m2/repository/commons-cli/commons-cli/1.2/commons-cli-1.2.jar:/root/.m2/repository/xerces/xercesImpl/2.9.1/xercesImpl-2.9.1.jar:/root/.m2/repository/net/iharder/base64/2.3.8/base64-2.3.8.jar:/root/.m2/repository/javax/annotation/javax.annotation-api/1.2/javax.annotation-api-1.2.jar:/root/.m2/repository/org/objenesis/objenesis/2.1/objenesis-2.1.jar:/root/.m2/repository/org/slf4j/slf4j-log4j12/1.7.16/slf4j-log4j12-1.7.16.jar:/root/.m2/repository/org/xerial/snappy/snappy-java/1.1.2.6/snappy-java-1.1.2.6.jar:/root/.m2/repository/org/glassfish/jersey/media/jersey-media-jaxb/2.22.2/jersey-media-jaxb-2.22.2.jar:/root/.m2/repository/org/spark-project/spark/unused/1.0.0/unused-1.0.0.jar:/root/.m2/repository/net/java/dev/jets3t/jets3t/0.9.4/jets3t-0.9.4.jar:/root/.m2/repository/io/dropwizard/metrics/metrics-jvm/3.1.5/metrics-jvm-3.1.5.jar:/root/.m2/repository/org/apache/avro/avro-ipc/1.7.7/avro-ipc-1.7.7.jar:/root/.m2/repository/com/github/luben/zstd-jni/1.3.2-2/zstd-jni-1.3.2-2.jar:/root/.m2/repository/org/eclipse/jetty/jetty-jndi/9.3.20.v20170531/jetty-jndi-9.3.20.v20170531.jar:/root/.m2/repository/commons-collections/commons-collections/3.2.2/commons-collections-3.2.2.jar:/root/spark/launcher/target/spark-launcher_2.11-2.3.1-SNAPSHOT.jar:/root/.m2/repository/junit/junit/4.12/junit-4.12.jar:/root/.m2/repository/org/glassfish/hk2/hk2-locator/2.4.0-b34/hk2-locator-2.4.0-b34.jar:/root/.m2/repository/com/carrotsearch/hppc/0.7.2/hppc-0.7.2.jar:/root/.m2/repository/org/apache/hadoop/hadoop-yarn-client/2.6.5/hadoop-yarn-client-2.6.5.jar:/root/.m2/repository/net/razorvine/pyrolite/4.13/pyrolite-4.13.jar:/root/.m2/repository/com/jamesmurty/utils/java-xmlbuilder/1.1/java-xmlbuilder-1.1.jar:/root/.m2/repository/org/eclipse/jetty/jetty-servlet/9.3.20.v20170531/jetty-servlet-9.3.20.v20170531.jar:/root/.m2/repository/org/slf4j/jcl-over-slf4j/1.7.16/jcl-over-slf4j-1.7.16.jar:/root/.m2/repository/org/codehaus/janino/janino/3.0.8/janino-3.0.8.jar:/root/.m2/repository/io/netty/netty-all/4.1.17.Final/netty-all-4.1.17.Final.jar:/root/.m2/repository/org/apache/orc/orc-mapreduce/1.4.1/orc-mapreduce-1.4.1-nohive.jar:/root/.m2/repository/commons-httpclient/commons-httpclient/3.1/commons-httpclient-3.1.jar
  [INFO]
  [INFO] --- scala-maven-plugin:3.2.2:testCompile (scala-test-compile-first) @ spark-sql_2.11 ---
  [INFO] Using incremental compilation
  [INFO] Compiling 261 Scala sources and 30 Java sources to /root/spark/sql/core/target/scala-2.11/test-classes...
  [WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/BenchmarkQueryTest.scala:57: a pure expression does nothing in statement position; you may be omitting necessary parentheses
  [WARNING]       case s => s
  [WARNING]                 ^




  [WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/execution/datasources/parquet/ParquetInteroperabilitySuite.scala:182: inferred existential type org.apache.parquet.column.statistics.Statistics[?0]( forSome { type ?0 <: Comparable[?0] }), which cannot be expressed by wildcards,  should be enabled
  by making the implicit value scala.language.existentials visible.
  This can be achieved by adding the import clause 'import scala.language.existentials'
  or by setting the compiler option -language:existentials.
  See the Scaladoc for value scala.language.existentials for a discussion
  why the feature should be explicitly enabled.
  [WARNING]                 val columnStats = oneBlockColumnMeta.getStatistics
  [WARNING]                                                      ^
  [WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/streaming/StatefulOperatorTest.scala:45: abstract type pattern T is unchecked since it is eliminated by erasure
  [WARNING]       .executedPlan.collect { case p: T => p }
  [WARNING]                                       ^
  [WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/streaming/StreamingQueryStatusAndProgressSuite.scala:199: postfix operator minute should be enabled
  by making the implicit value scala.language.postfixOps visible.
  This can be achieved by adding the import clause 'import scala.language.postfixOps'
  or by setting the compiler option -language:postfixOps.
  See the Scaladoc for value scala.language.postfixOps for a discussion
  why the feature should be explicitly enabled.
  [WARNING]         eventually(timeout(1 minute)) {
  [WARNING]                              ^
  [WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/streaming/StreamingQuerySuite.scala:540: a pure expression does nothing in statement position; you may be omitting necessary parentheses
  [WARNING]       q1
  [WARNING]       ^
  [WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/DataFrameSuite.scala:223: method explode in class Dataset is deprecated: use flatMap() or select() with functions.explode() instead
  [WARNING]       df.explode("words", "word") { word: String => word.split(" ").toSeq }.select('word),
  [WARNING]          ^
  [WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/DataFrameSuite.scala:231: method explode in class Dataset is deprecated: use flatMap() or select() with functions.explode() instead
  [WARNING]       df.explode('letters) {
  [WARNING]          ^
  [WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/DataFrameSuite.scala:281: method explode in class Dataset is deprecated: use flatMap() or select() with functions.explode() instead
  [WARNING]       df.explode($"*") { case Row(prefix: String, csv: String) =>
  [WARNING]          ^
  [WARNING] /root/spark/sql/core/src/test/scala/org/apache/spark/sql/DataFrameSuite.scala:288: method explode in class Dataset is deprecated: use flatMap() or select() with functions.explode() instead
  [WARNING]       df.explode('prefix, 'csv) { case Row(prefix: String, csv: String) =>
  [WARNING]          ^
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
  [INFO] Spark Project Parent POM ........................... SUCCESS [  5.076 s]
  [INFO] Spark Project Tags ................................. SUCCESS [  5.812 s]
  [INFO] Spark Project Sketch ............................... SUCCESS [ 11.231 s]
  [INFO] Spark Project Local DB ............................. SUCCESS [  3.998 s]
  [INFO] Spark Project Networking ........................... SUCCESS [  8.884 s]
  [INFO] Spark Project Shuffle Streaming Service ............ SUCCESS [  4.004 s]
  [INFO] Spark Project Unsafe ............................... SUCCESS [ 13.120 s]
  [INFO] Spark Project Launcher ............................. SUCCESS [  9.348 s]
  [INFO] Spark Project Core ................................. SUCCESS [03:57 min]
  [INFO] Spark Project ML Local Library ..................... SUCCESS [ 35.670 s]
  [INFO] Spark Project GraphX ............................... SUCCESS [ 51.563 s]
  [INFO] Spark Project Streaming ............................ SUCCESS [01:27 min]
  [INFO] Spark Project Catalyst ............................. SUCCESS [03:07 min]
  [INFO] Spark Project SQL .................................. FAILURE [09:15 min]
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
  [INFO] Total time: 20:18 min
  [INFO] Finished at: 2018-03-06T01:30:34+00:00
  [INFO] Final Memory: 58M/593M
  [INFO] ------------------------------------------------------------------------
  [ERROR] Java heap space -> [Help 1]
  [ERROR]
  [ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
  [ERROR] Re-run Maven using the -X switch to enable full debug logging.
  [ERROR]
  [ERROR] For more information about the errors and possible solutions, please read the following articles:
  [ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/OutOfMemoryError
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]#
  [root@sparkonk8s-46929-p4jdl spark]# mvn -DskipTests clean package -e
