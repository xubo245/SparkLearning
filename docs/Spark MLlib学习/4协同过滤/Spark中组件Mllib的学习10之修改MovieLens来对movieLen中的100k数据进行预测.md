更多代码请见：https://github.com/xubo245/SparkLearning

1解释
数据下载：http://files.grouplens.org/datasets/movielens/


2.代码：

```
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/** *
  *
  * @author xubo
  *         time 20160516
  *         args:file/data/mllib/input/sample_movielens_data.txt
  *         args:--rank 5 --numIterations 20 --lambda 1.0 --kryo file/data/mllib/input/sample_movielens_data.txt
  *         ref http://spark.apache.org/docs/1.5.2/mllib-collaborative-filtering.html#collaborative-filtering
  */
// scalastyle:off println
package apache.spark.mllib.learning.recommend

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.recommendation.{ALS, MatrixFactorizationModel, Rating}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import scopt.OptionParser

import scala.collection.mutable

/**
  * An example app for ALS on MovieLens data (http://grouplens.org/datasets/movielens/).
  * Run with
  * {{{
  * bin/run-example org.apache.spark.examples.mllib.MovieLensALS
  * }}}
  * A synthetic dataset in MovieLens format can be found at `data/mllib/sample_movielens_data.txt`.
  * If you use it as a template to create your own app, please use `spark-submit` to submit your app.
  */
object MovieLensALS100k {

  case class Params(
                     input: String = null,
                     kryo: Boolean = false,
                     numIterations: Int = 20,
                     lambda: Double = 1.0,
                     rank: Int = 10,
                     numUserBlocks: Int = -1,
                     numProductBlocks: Int = -1,
                     implicitPrefs: Boolean = false) extends AbstractParams[Params]

  def main(args: Array[String]) {
    val defaultParams = Params()

    val parser = new OptionParser[Params]("MovieLensALS") {
      head("MovieLensALS: an example app for ALS on MovieLens data.")
      opt[Int]("rank")
        .text(s"rank, default: ${defaultParams.rank}")
        .action((x, c) => c.copy(rank = x))
      opt[Int]("numIterations")
        .text(s"number of iterations, default: ${defaultParams.numIterations}")
        .action((x, c) => c.copy(numIterations = x))
      opt[Double]("lambda")
        .text(s"lambda (smoothing constant), default: ${defaultParams.lambda}")
        .action((x, c) => c.copy(lambda = x))
      opt[Unit]("kryo")
        .text("use Kryo serialization")
        .action((_, c) => c.copy(kryo = true))
      opt[Int]("numUserBlocks")
        .text(s"number of user blocks, default: ${defaultParams.numUserBlocks} (auto)")
        .action((x, c) => c.copy(numUserBlocks = x))
      opt[Int]("numProductBlocks")
        .text(s"number of product blocks, default: ${defaultParams.numProductBlocks} (auto)")
        .action((x, c) => c.copy(numProductBlocks = x))
      opt[Unit]("implicitPrefs")
        .text("use implicit preference")
        .action((_, c) => c.copy(implicitPrefs = true))
      arg[String]("<input>")
        .required()
        .text("input paths to a MovieLens dataset of ratings")
        .action((x, c) => c.copy(input = x))
      note(
        """
          |For example, the following command runs this app on a synthetic dataset:
          |
          | bin/spark-submit --class org.apache.spark.examples.mllib.MovieLensALS \
          |  examples/target/scala-*/spark-examples-*.jar \
          |  --rank 5 --numIterations 20 --lambda 1.0 --kryo \
          |  data/mllib/sample_movielens_data.txt
        """.stripMargin)
    }

    parser.parse(args, defaultParams).map { params =>
      run(params)
    } getOrElse {
      System.exit(1)
    }
  }

  def run(params: Params) {
    val conf = new SparkConf().setAppName(s"MovieLensALS with $params").setMaster("local[4]")
    if (params.kryo) {
      conf.registerKryoClasses(Array(classOf[mutable.BitSet], classOf[Rating]))
        .set("spark.kryoserializer.buffer", "8m")
    }
    val sc = new SparkContext(conf)

    Logger.getRootLogger.setLevel(Level.WARN)

    val implicitPrefs = params.implicitPrefs

    val ratings = sc.textFile(params.input).map { line =>
      val fields = line.split("\\s+")
      if (implicitPrefs) {
        /*
         * MovieLens ratings are on a scale of 1-5:
         * 5: Must see
         * 4: Will enjoy
         * 3: It's okay
         * 2: Fairly bad
         * 1: Awful
         * So we should not recommend a movie if the predicted rating is less than 3.
         * To map ratings to confidence scores, we use
         * 5 -> 2.5, 4 -> 1.5, 3 -> 0.5, 2 -> -0.5, 1 -> -1.5. This mappings means unobserved
         * entries are generally between It's okay and Fairly bad.
         * The semantics of 0 in this expanded world of non-positive weights
         * are "the same as never having interacted at all".
         */
        Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble - 2.5)
      } else {
        Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble)
      }
    }.cache()

    val numRatings = ratings.count()
    val numUsers = ratings.map(_.user).distinct().count()
    val numMovies = ratings.map(_.product).distinct().count()

    println(s"Got $numRatings ratings from $numUsers users on $numMovies movies.")

    val splits = ratings.randomSplit(Array(0.8, 0.2))
    val training = splits(0).cache()
    val test = if (params.implicitPrefs) {
      /*
       * 0 means "don't know" and positive values mean "confident that the prediction should be 1".
       * Negative values means "confident that the prediction should be 0".
       * We have in this case used some kind of weighted RMSE. The weight is the absolute value of
       * the confidence. The error is the difference between prediction and either 1 or 0,
       * depending on whether r is positive or negative.
       */
      splits(1).map(x => Rating(x.user, x.product, if (x.rating > 0) 1.0 else 0.0))
    } else {
      splits(1)
    }.cache()

    val numTraining = training.count()
    val numTest = test.count()
    println(s"Training: $numTraining, test: $numTest.")

    ratings.unpersist(blocking = false)

    val model = new ALS()
      .setRank(params.rank)
      .setIterations(params.numIterations)
      .setLambda(params.lambda)
      .setImplicitPrefs(params.implicitPrefs)
      .setUserBlocks(params.numUserBlocks)
      .setProductBlocks(params.numProductBlocks)
      .run(training)

    val rmse = computeRmse(model, test, params.implicitPrefs)

    println(s"Test RMSE = $rmse.")
    println(model.predict(196, 242))
    println(model.predict(186, 302))
    println(model.predict(22, 377))
    println(model.predict(244, 51))
    println(model.predict(166, 346))
    println(model.predict(298, 474))

    //    196	242	3	881250949
    //    186	302	3	891717742
    //    22	377	1	878887116
    //    244	51	2	880606923
    //    166	346	1	886397596
    //    298	474	4	884182806

    //    predict
    //    2.90972069181384
    //    2.9659688329909253
    //    1.6347869848052985
    //    2.5944938058703233
    //    2.7894103509399906
    //    3.362232859053514

    sc.stop()

  }

  /** Compute RMSE (Root Mean Squared Error). */
  def computeRmse(model: MatrixFactorizationModel, data: RDD[Rating], implicitPrefs: Boolean)
  : Double = {

    def mapPredictedRating(r: Double): Double = {
      if (implicitPrefs) math.max(math.min(r, 1.0), 0.0) else r
    }

    val predictions: RDD[Rating] = model.predict(data.map(x => (x.user, x.product)))
    val predictionsAndRatings = predictions.map { x =>
      ((x.user, x.product), mapPredictedRating(x.rating))
    }.join(data.map(x => ((x.user, x.product), x.rating))).values
    math.sqrt(predictionsAndRatings.map(x => (x._1 - x._2) * (x._1 - x._2)).mean())
  }
}

// scalastyle:on println

```

3.结果：

```
D:\1win7\java\jdk\bin\java -Didea.launcher.port=7532 "-Didea.launcher.bin.path=D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\bin" -Dfile.encoding=UTF-8 -classpath "D:\all\idea\SparkLearning\target\classes;D:\1win7\java\jdk\jre\lib\charsets.jar;D:\1win7\java\jdk\jre\lib\deploy.jar;D:\1win7\java\jdk\jre\lib\ext\access-bridge-64.jar;D:\1win7\java\jdk\jre\lib\ext\dnsns.jar;D:\1win7\java\jdk\jre\lib\ext\jaccess.jar;D:\1win7\java\jdk\jre\lib\ext\localedata.jar;D:\1win7\java\jdk\jre\lib\ext\sunec.jar;D:\1win7\java\jdk\jre\lib\ext\sunjce_provider.jar;D:\1win7\java\jdk\jre\lib\ext\sunmscapi.jar;D:\1win7\java\jdk\jre\lib\ext\zipfs.jar;D:\1win7\java\jdk\jre\lib\javaws.jar;D:\1win7\java\jdk\jre\lib\jce.jar;D:\1win7\java\jdk\jre\lib\jfr.jar;D:\1win7\java\jdk\jre\lib\jfxrt.jar;D:\1win7\java\jdk\jre\lib\jsse.jar;D:\1win7\java\jdk\jre\lib\management-agent.jar;D:\1win7\java\jdk\jre\lib\plugin.jar;D:\1win7\java\jdk\jre\lib\resources.jar;D:\1win7\java\jdk\jre\lib\rt.jar;D:\1win7\scala;D:\1win7\scala\lib;D:\1win7\java\otherJar\spark-assembly-1.5.2-hadoop2.6.0.jar;D:\1win7\java\otherJar\adam-apis_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\adam-cli_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\adam-core_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\SparkCSV\com.databricks_spark-csv_2.10-1.4.0.jar;D:\1win7\java\otherJar\SparkCSV\com.univocity_univocity-parsers-1.5.1.jar;D:\1win7\java\otherJar\SparkCSV\org.apache.commons_commons-csv-1.1.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1-javadoc.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1-sources.jar;D:\1win7\java\otherJar\avro\spark-avro_2.10-2.0.2-SNAPSHOT.jar;D:\1win7\java\otherJar\tachyon\tachyon-assemblies-0.7.1-jar-with-dependencies.jar;D:\1win7\scala\lib\scala-actors-migration.jar;D:\1win7\scala\lib\scala-actors.jar;D:\1win7\scala\lib\scala-library.jar;D:\1win7\scala\lib\scala-reflect.jar;D:\1win7\scala\lib\scala-swing.jar;C:\Users\xubo\.m2\repository\com\github\scopt\scopt_2.10\3.2.0\scopt_2.10-3.2.0.jar;C:\Users\xubo\.m2\repository\org\scala-lang\scala-library\2.10.3\scala-library-2.10.3.jar;D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain apache.spark.mllib.learning.recommend.MovieLensALS100k D:\all\idea\SparkLearning\file\data\mllib\input\movielens\ml-100k\u.data
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/spark-assembly-1.5.2-hadoop2.6.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/adam-cli_2.10-0.18.3-SNAPSHOT.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/tachyon/tachyon-assemblies-0.7.1-jar-with-dependencies.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
2016-05-17 21:09:21 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
2016-05-17 21:09:24 WARN  MetricsSystem:71 - Using default name DAGScheduler for source because spark.app.id is not set.
2016-05-17 21:09:26 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:200:5efe:d356:9f8e%20, but we couldn't find any external IP address!
Got 100000 ratings from 943 users on 1682 movies.
Training: 79936, test: 20064.
2016-05-17 21:09:42 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
2016-05-17 21:09:42 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
2016-05-17 21:09:43 WARN  LAPACK:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemLAPACK
2016-05-17 21:09:43 WARN  LAPACK:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefLAPACK
Test RMSE = 1.381439230726954.
2.7669578494275573
2.8469469555029345
1.5082034472386099
2.597366713905704
2.6186014383179406
3.366311990686616

Process finished with exit code 0

```

结果分析：由于每次运行时train和testdata按照8：2随机划分，所以每次训练结果不一样，如果数据在train中，predict会很接近，如果在test中，数据就不一定了。


参考
【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
【2】http://spark.apache.org/docs/1.5.2/mllib-collaborative-filtering.html#collaborative-filtering 
【3】https://github.com/xubo245/SparkLearning
