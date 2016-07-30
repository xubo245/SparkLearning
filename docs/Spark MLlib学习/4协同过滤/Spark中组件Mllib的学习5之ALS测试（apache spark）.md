更多代码请见：https://github.com/xubo245/SparkLearning

1解释
按照spark官网使用ALS进行计算


2.代码：

```
package org.apache.spark.mllib.learning.recommend

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.mllib.recommendation.ALS
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel
import org.apache.spark.mllib.recommendation.Rating

/**
  * Created by xubo on 2016/5/16.
  */
object ALSFromSpark {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    //    println(this.getClass().getSimpleName().filter(!_.equals('$')))
    //设置环境变量
    val sc = new SparkContext(conf)

    // Load and parse the data
    //    val data = sc.textFile("data/mllib/als/test.data")
    val data = sc.textFile("file/data/mllib/input/test.data")

    val ratings = data.map(_.split(',') match { case Array(user, item, rate) =>
      Rating(user.toInt, item.toInt, rate.toDouble)
    })

    // Build the recommendation model using ALS
    val rank = 10
    val numIterations = 10
    val model = ALS.train(ratings, rank, numIterations, 0.01)

    // Evaluate the model on rating data
    val usersProducts = ratings.map { case Rating(user, product, rate) =>
      (user, product)
    }
    val predictions =
      model.predict(usersProducts).map { case Rating(user, product, rate) =>
        ((user, product), rate)
      }
    val ratesAndPreds = ratings.map { case Rating(user, product, rate) =>
      ((user, product), rate)
    }.join(predictions)
    val MSE = ratesAndPreds.map { case ((user, product), (r1, r2)) =>
      val err = (r1 - r2)
      err * err
    }.mean()
    println("Mean Squared Error = " + MSE)

    // Save and load model
    val iString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
    model.save(sc, "myModelPath"+iString)
    val sameModel = MatrixFactorizationModel.load(sc, "myModelPath")
  }
}

```

3.结果：

```
D:\1win7\java\jdk\bin\java -Didea.launcher.port=7532 "-Didea.launcher.bin.path=D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\bin" -Dfile.encoding=UTF-8 -classpath "D:\all\idea\SparkLearning\target\classes;D:\1win7\java\jdk\jre\lib\charsets.jar;D:\1win7\java\jdk\jre\lib\deploy.jar;D:\1win7\java\jdk\jre\lib\ext\access-bridge-64.jar;D:\1win7\java\jdk\jre\lib\ext\dnsns.jar;D:\1win7\java\jdk\jre\lib\ext\jaccess.jar;D:\1win7\java\jdk\jre\lib\ext\localedata.jar;D:\1win7\java\jdk\jre\lib\ext\sunec.jar;D:\1win7\java\jdk\jre\lib\ext\sunjce_provider.jar;D:\1win7\java\jdk\jre\lib\ext\sunmscapi.jar;D:\1win7\java\jdk\jre\lib\ext\zipfs.jar;D:\1win7\java\jdk\jre\lib\javaws.jar;D:\1win7\java\jdk\jre\lib\jce.jar;D:\1win7\java\jdk\jre\lib\jfr.jar;D:\1win7\java\jdk\jre\lib\jfxrt.jar;D:\1win7\java\jdk\jre\lib\jsse.jar;D:\1win7\java\jdk\jre\lib\management-agent.jar;D:\1win7\java\jdk\jre\lib\plugin.jar;D:\1win7\java\jdk\jre\lib\resources.jar;D:\1win7\java\jdk\jre\lib\rt.jar;D:\1win7\scala;D:\1win7\scala\lib;D:\1win7\java\otherJar\spark-assembly-1.5.2-hadoop2.6.0.jar;D:\1win7\java\otherJar\adam-apis_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\adam-cli_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\adam-core_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\SparkCSV\com.databricks_spark-csv_2.10-1.4.0.jar;D:\1win7\java\otherJar\SparkCSV\com.univocity_univocity-parsers-1.5.1.jar;D:\1win7\java\otherJar\SparkCSV\org.apache.commons_commons-csv-1.1.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1-javadoc.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1-sources.jar;D:\1win7\java\otherJar\avro\spark-avro_2.10-2.0.2-SNAPSHOT.jar;D:\1win7\java\otherJar\tachyon\tachyon-assemblies-0.7.1-jar-with-dependencies.jar;D:\1win7\scala\lib\scala-actors-migration.jar;D:\1win7\scala\lib\scala-actors.jar;D:\1win7\scala\lib\scala-library.jar;D:\1win7\scala\lib\scala-reflect.jar;D:\1win7\scala\lib\scala-swing.jar;C:\Users\xubo\.m2\repository\com\github\scopt\scopt_2.10\3.2.0\scopt_2.10-3.2.0.jar;C:\Users\xubo\.m2\repository\org\scala-lang\scala-library\2.10.3\scala-library-2.10.3.jar;D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain org.apache.spark.mllib.learning.recommend.ALSFromSpark
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/spark-assembly-1.5.2-hadoop2.6.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/adam-cli_2.10-0.18.3-SNAPSHOT.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/tachyon/tachyon-assemblies-0.7.1-jar-with-dependencies.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
2016-05-16 22:43:17 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
2016-05-16 22:43:19 WARN  MetricsSystem:71 - Using default name DAGScheduler for source because spark.app.id is not set.
2016-05-16 22:43:22 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:200:5efe:ca26:541d%20, but we couldn't find any external IP address!
2016-05-16 22:43:24 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
2016-05-16 22:43:24 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
2016-05-16 22:43:24 WARN  LAPACK:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemLAPACK
2016-05-16 22:43:24 WARN  LAPACK:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefLAPACK
Mean Squared Error = 7.663153468887253E-6
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
2016-05-16 22:43:32 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
2016-05-16 22:43:32 WARN  MatrixFactorizationModel:71 - User factor does not have a partitioner. Prediction on individual records could be slow.
2016-05-16 22:43:32 WARN  MatrixFactorizationModel:71 - User factor is not cached. Prediction could be slow.
2016-05-16 22:43:32 WARN  ParquetRecordReader:193 - Can not initialize counter due to context is not a instance of TaskInputOutputContext, but is org.apache.hadoop.mapreduce.task.TaskAttemptContextImpl
2016-05-16 22:43:32 WARN  MatrixFactorizationModel:71 - Product factor does not have a partitioner. Prediction on individual records could be slow.
2016-05-16 22:43:32 WARN  MatrixFactorizationModel:71 - Product factor is not cached. Prediction could be slow.

Process finished with exit code 0

```

参考
【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html
【2】http://spark.apache.org/docs/1.5.2/mllib-collaborative-filtering.html#collaborative-filtering
【3】https://github.com/xubo245/SparkLearning
