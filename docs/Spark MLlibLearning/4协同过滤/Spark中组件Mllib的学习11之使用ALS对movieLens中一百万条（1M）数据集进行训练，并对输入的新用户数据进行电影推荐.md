更多代码请见：https://github.com/xubo245/SparkLearning

1解释
spark-1.5.2
数据集：http://grouplens.org/datasets/movielens/
一百万条（1M）
数据划分：
将样本评分表以key值切分成3个部分，分别用于训练 (60%，并加入用户评分), 校验 (20%), and 测试 (20%)

用多个参数训练模型，取训练最好的模型，然后再来推荐


2.代码：

```
package apache.spark.mllib.learning.recommend

import java.io.File
import scala.io.Source
import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd._
import org.apache.spark.mllib.recommendation.{ALS, Rating, MatrixFactorizationModel}

object MovieLensALSFromDataGuru {

  def main(args: Array[String]) {
    //屏蔽不必要的日志显示在终端上
    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)

    //    if (args.length != 2) {
    //      println("Usage: /path/to/spark/bin/spark-submit --driver-memory 2g --class week6.MovieLensALS " +
    //        "target/scala-*/movielens-als-ssembly-*.jar movieLensHomeDir personalRatingsFile")
    //      sys.exit(1)
    //    }

    //设置运行环境
    val conf = new SparkConf().setAppName(this.getClass().getSimpleName().filter(!_.equals('$'))).setMaster("local[4]")
    val sc = new SparkContext(conf)

    //装载用户评分，该评分由评分器生成

    //    val myRatings = loadRatings(args(1))
    val myRatings = loadRatings("file/data/mllib/input/personalRatings.txt")
    val myRatingsRDD = sc.parallelize(myRatings, 1)


    //样本数据目录
    //    val movieLensHomeDir = args(0)
    val movieLensHomeDir = "file/data/mllib/input/movielens/medium/"

    //装载样本评分数据，其中最后一列Timestamp取除10的余数作为key，Rating为值,即(Int,Rating)
    val ratings = sc.textFile(new File(movieLensHomeDir, "ratings.dat").toString).map { line =>
      val fields = line.split("::")
      (fields(3).toLong % 10, Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble))
    }

    //装载电影目录对照表（电影ID->电影标题）
    val movies = sc.textFile(new File(movieLensHomeDir, "movies.dat").toString).map { line =>
      val fields = line.split("::")
      (fields(0).toInt, fields(1))
    }.collect().toMap

    val numRatings = ratings.count()
    val numUsers = ratings.map(_._2.user).distinct().count()
    val numMovies = ratings.map(_._2.product).distinct().count()

    println("Got " + numRatings + " ratings from " + numUsers + " users on " + numMovies + " movies.")

    //将样本评分表以key值切分成3个部分，分别用于训练 (60%，并加入用户评分), 校验 (20%), and 测试 (20%)
    //该数据在计算过程中要多次应用到，所以cache到内存
    val numPartitions = 4
    val training = ratings.filter(x => x._1 < 6)
      .values
      .union(myRatingsRDD) //注意ratings是(Int,Rating)，取value即可
      .repartition(numPartitions)
      .cache()
    val validation = ratings.filter(x => x._1 >= 6 && x._1 < 8)
      .values
      .repartition(numPartitions)
      .cache()
    val test = ratings.filter(x => x._1 >= 8).values.cache()

    val numTraining = training.count()
    val numValidation = validation.count()
    val numTest = test.count()

    println("Training: " + numTraining + ", validation: " + numValidation + ", test: " + numTest)


    //训练不同参数下的模型，并在校验集中验证，获取最佳参数下的模型
    val ranks = List(8, 12)
    val lambdas = List(0.1, 10.0)
    val numIters = List(10, 20)
    var bestModel: Option[MatrixFactorizationModel] = None
    var bestValidationRmse = Double.MaxValue
    var bestRank = 0
    var bestLambda = -1.0
    var bestNumIter = -1
    for (rank <- ranks; lambda <- lambdas; numIter <- numIters) {
      val model = ALS.train(training, rank, numIter, lambda)
      val validationRmse = computeRmse(model, validation, numValidation)
      println("RMSE (validation) = " + validationRmse + " for the model trained with rank = "
        + rank + ", lambda = " + lambda + ", and numIter = " + numIter + ".")
      if (validationRmse < bestValidationRmse) {
        bestModel = Some(model)
        bestValidationRmse = validationRmse
        bestRank = rank
        bestLambda = lambda
        bestNumIter = numIter
      }
    }

    //用最佳模型预测测试集的评分，并计算和实际评分之间的均方根误差
    val testRmse = computeRmse(bestModel.get, test, numTest)

    println("The best model was trained with rank = " + bestRank + " and lambda = " + bestLambda
      + ", and numIter = " + bestNumIter + ", and its RMSE on the test set is " + testRmse + ".")

    // create a naive baseline and compare it with the best model
    //
    val meanRating = training.union(validation).map(_.rating).mean
    val baselineRmse =
      math.sqrt(test.map(x => (meanRating - x.rating) * (meanRating - x.rating)).mean)
    val improvement = (baselineRmse - testRmse) / baselineRmse * 100
    println("The best model improves the baseline by " + "%1.2f".format(improvement) + "%.")

    // 推荐前十部最感兴趣的电影，注意要剔除用户已经评分的电影
    val myRatedMovieIds = myRatings.map(_.product).toSet
    val candidates = sc.parallelize(movies.keys.filter(!myRatedMovieIds.contains(_)).toSeq)
    val recommendations = bestModel.get
      .predict(candidates.map((0, _)))
      .collect()
      .sortBy(-_.rating)
      .take(10)

    var i = 1
    println("Movies recommended for you:")
    recommendations.foreach { r =>
      println("%2d".format(i) + ": " + movies(r.product))
      i += 1
    }
    println("end")
    //结束
    sc.stop()
  }

  /** 校验集预测数据和实际数据之间的均方根误差 **/
  def computeRmse(model: MatrixFactorizationModel, data: RDD[Rating], n: Long): Double = {
    val predictions: RDD[Rating] = model.predict(data.map(x => (x.user, x.product)))
    val predictionsAndRatings = predictions.map(x => ((x.user, x.product), x.rating))
      .join(data.map(x => ((x.user, x.product), x.rating)))
      .values
    math.sqrt(predictionsAndRatings.map(x => (x._1 - x._2) * (x._1 - x._2)).reduce(_ + _) / n)
  }

  /** 装载用户评分文件 **/
  def loadRatings(path: String): Seq[Rating] = {
    val lines = Source.fromFile(path).getLines()
    val ratings = lines.map { line =>
      val fields = line.split("::")
      fields(2)=2.toString
      Rating(fields(0).toInt, fields(1).toInt, fields(2).toDouble)
    }.filter(_.rating > 0.0)
    if (ratings.isEmpty) {
      sys.error("No ratings provided.")
    } else {
      ratings.toSeq
    }
  }
}
```
个人输入数据：

```
0::1::?::1400000000::Toy Story (1995)
0::780::?::1400000000::Independence Day (a.k.a. ID4) (1996)
0::590::?::1400000000::Dances with Wolves (1990)
0::1210::?::1400000000::Star Wars: Episode VI - Return of the Jedi (1983)
0::648::?::1400000000::Mission: Impossible (1996)
0::344::?::1400000000::Ace Ventura: Pet Detective (1994)
0::165::?::1400000000::Die Hard: With a Vengeance (1995)
0::153::?::1400000000::Batman Forever (1995)
0::597::?::1400000000::Pretty Woman (1990)
0::1580::?::1400000000::Men in Black (1997)
0::231::?::1400000000::Dumb & Dumber (1994)
```


3.结果：

```
D:\1win7\java\jdk\bin\java -Didea.launcher.port=7532 "-Didea.launcher.bin.path=D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\bin" -Dfile.encoding=UTF-8 -classpath "D:\all\idea\SparkLearning\target\classes;D:\1win7\java\jdk\jre\lib\charsets.jar;D:\1win7\java\jdk\jre\lib\deploy.jar;D:\1win7\java\jdk\jre\lib\ext\access-bridge-64.jar;D:\1win7\java\jdk\jre\lib\ext\dnsns.jar;D:\1win7\java\jdk\jre\lib\ext\jaccess.jar;D:\1win7\java\jdk\jre\lib\ext\localedata.jar;D:\1win7\java\jdk\jre\lib\ext\sunec.jar;D:\1win7\java\jdk\jre\lib\ext\sunjce_provider.jar;D:\1win7\java\jdk\jre\lib\ext\sunmscapi.jar;D:\1win7\java\jdk\jre\lib\ext\zipfs.jar;D:\1win7\java\jdk\jre\lib\javaws.jar;D:\1win7\java\jdk\jre\lib\jce.jar;D:\1win7\java\jdk\jre\lib\jfr.jar;D:\1win7\java\jdk\jre\lib\jfxrt.jar;D:\1win7\java\jdk\jre\lib\jsse.jar;D:\1win7\java\jdk\jre\lib\management-agent.jar;D:\1win7\java\jdk\jre\lib\plugin.jar;D:\1win7\java\jdk\jre\lib\resources.jar;D:\1win7\java\jdk\jre\lib\rt.jar;D:\1win7\scala;D:\1win7\scala\lib;D:\1win7\java\otherJar\spark-assembly-1.5.2-hadoop2.6.0.jar;D:\1win7\java\otherJar\adam-apis_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\adam-cli_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\adam-core_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\SparkCSV\com.databricks_spark-csv_2.10-1.4.0.jar;D:\1win7\java\otherJar\SparkCSV\com.univocity_univocity-parsers-1.5.1.jar;D:\1win7\java\otherJar\SparkCSV\org.apache.commons_commons-csv-1.1.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1-javadoc.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1-sources.jar;D:\1win7\java\otherJar\avro\spark-avro_2.10-2.0.2-SNAPSHOT.jar;D:\1win7\java\otherJar\tachyon\tachyon-assemblies-0.7.1-jar-with-dependencies.jar;D:\1win7\scala\lib\scala-actors-migration.jar;D:\1win7\scala\lib\scala-actors.jar;D:\1win7\scala\lib\scala-library.jar;D:\1win7\scala\lib\scala-reflect.jar;D:\1win7\scala\lib\scala-swing.jar;C:\Users\xubo\.m2\repository\com\github\scopt\scopt_2.10\3.2.0\scopt_2.10-3.2.0.jar;C:\Users\xubo\.m2\repository\org\scala-lang\scala-library\2.10.3\scala-library-2.10.3.jar;D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain apache.spark.mllib.learning.recommend.MovieLensALSFromDataGuru
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/spark-assembly-1.5.2-hadoop2.6.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/adam-cli_2.10-0.18.3-SNAPSHOT.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/tachyon/tachyon-assemblies-0.7.1-jar-with-dependencies.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
2016-05-17 21:57:32 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
2016-05-17 21:57:34 WARN  MetricsSystem:71 - Using default name DAGScheduler for source because spark.app.id is not set.
2016-05-17 21:57:36 WARN  :139 - Your hostname, xubo-PC resolves to a loopback/non-reachable address: fe80:0:0:0:200:5efe:d356:9f8e%20, but we couldn't find any external IP address!
Got 1000209 ratings from 6040 users on 3706 movies.
[Stage 10:=============================>                            (1 + 1) / 2]Training: 602252, validation: 198919, test: 199049
2016-05-17 21:57:51 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
2016-05-17 21:57:51 WARN  BLAS:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
2016-05-17 21:57:51 WARN  LAPACK:61 - Failed to load implementation from: com.github.fommil.netlib.NativeSystemLAPACK
2016-05-17 21:57:51 WARN  LAPACK:61 - Failed to load implementation from: com.github.fommil.netlib.NativeRefLAPACK
RMSE (validation) = 0.8781453642109673 for the model trained with rank = 8, lambda = 0.1, and numIter = 10.
RMSE (validation) = 0.8726907141829461 for the model trained with rank = 8, lambda = 0.1, and numIter = 20.
RMSE (validation) = 3.7558695311242833 for the model trained with rank = 8, lambda = 10.0, and numIter = 10.
RMSE (validation) = 3.7558695311242833 for the model trained with rank = 8, lambda = 10.0, and numIter = 20.
RMSE (validation) = 0.8782579367891573 for the model trained with rank = 12, lambda = 0.1, and numIter = 10.
[Stage 1228:==========================================>             (3 + 1) / 4]RMSE (validation) = 0.8708994704769754 for the model trained with rank = 12, lambda = 0.1, and numIter = 20.
RMSE (validation) = 3.7558695311242833 for the model trained with rank = 12, lambda = 10.0, and numIter = 10.
[Stage 1634:==============>                                         (1 + 3) / 4]RMSE (validation) = 3.7558695311242833 for the model trained with rank = 12, lambda = 10.0, and numIter = 20.
[Stage 1687:==========================================>             (3 + 1) / 4]The best model was trained with rank = 12 and lambda = 0.1, and numIter = 20, and its RMSE on the test set is 0.868840371932273.
The best model improves the baseline by 21.97%.
Movies recommended for you:
 1: Bandits (1997)
 2: Very Thought of You, The (1998)
 3: Ayn Rand: A Sense of Life (1997)
 4: Shawshank Redemption, The (1994)
 5: First Love, Last Rites (1997)
 6: Matrix, The (1999)
 7: Bewegte Mann, Der (1994)
 8: Raiders of the Lost Ark (1981)
 9: Big Trees, The (1952)
10: Die Hard (1988)
end

Process finished with exit code 0

```

参考
【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
【2】http://spark.apache.org/docs/1.5.2/mllib-collaborative-filtering.html#collaborative-filtering 
【3】https://github.com/xubo245/SparkLearning
