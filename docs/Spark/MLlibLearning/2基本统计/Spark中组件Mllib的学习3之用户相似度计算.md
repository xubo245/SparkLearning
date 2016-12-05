代码：	
	
	```
	/**
	  * @author xubo
	  *         time 2016.516
	  *         ref 《Spark MlLib 机器学习实战》P64
	  */
	package org.apache.spark.mllib.learning.recommend
	
	import org.apache.spark.{SparkConf, SparkContext}
	
	import scala.collection.mutable.Map
	
	object CollaborativeFilteringSpark {
	  val conf = new SparkConf().setMaster("local").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
	    println(this.getClass().getSimpleName().filter(!_.equals('$')))
	  //设置环境变量
	  val sc = new SparkContext(conf)
	  //实例化环境
	  val users = sc.parallelize(Array("aaa", "bbb", "ccc", "ddd", "eee"))
	  //设置用户
	  val films = sc.parallelize(Array("smzdm", "ylxb", "znh", "nhsc", "fcwr")) //设置电影名
	
	  val source = Map[String, Map[String, Int]]()
	  //使用一个source嵌套map作为姓名电影名和分值的存储
	  val filmSource = Map[String, Int]()
	
	  //设置一个用以存放电影分的map
	  def getSource(): Map[String, Map[String, Int]] = {
	    //设置电影评分
	    val user1FilmSource = Map("smzdm" -> 2, "ylxb" -> 3, "znh" -> 1, "nhsc" -> 0, "fcwr" -> 1)
	    val user2FilmSource = Map("smzdm" -> 1, "ylxb" -> 2, "znh" -> 2, "nhsc" -> 1, "fcwr" -> 4)
	    val user3FilmSource = Map("smzdm" -> 2, "ylxb" -> 1, "znh" -> 0, "nhsc" -> 1, "fcwr" -> 4)
	    val user4FilmSource = Map("smzdm" -> 3, "ylxb" -> 2, "znh" -> 0, "nhsc" -> 5, "fcwr" -> 3)
	    val user5FilmSource = Map("smzdm" -> 5, "ylxb" -> 3, "znh" -> 1, "nhsc" -> 1, "fcwr" -> 2)
	    source += ("aaa" -> user1FilmSource) //对人名进行存储
	    source += ("bbb" -> user2FilmSource) //对人名进行存储
	    source += ("ccc" -> user3FilmSource) //对人名进行存储
	    source += ("ddd" -> user4FilmSource) //对人名进行存储
	    source += ("eee" -> user5FilmSource) //对人名进行存储
	    source //返回嵌套map
	  }
	
	  //两两计算分值,采用余弦相似性
	  def getCollaborateSource(user1: String, user2: String): Double = {
	    val user1FilmSource = source.get(user1).get.values.toVector //获得第1个用户的评分
	    val user2FilmSource = source.get(user2).get.values.toVector //获得第2个用户的评分
	    val member = user1FilmSource.zip(user2FilmSource).map(d => d._1 * d._2).reduce(_ + _).toDouble //对公式分子部分进行计算
	    val temp1 = math.sqrt(user1FilmSource.map(num => {
	        //求出分母第1个变量值
	        math.pow(num, 2) //数学计算
	      }).reduce(_ + _)) //进行叠加
	    val temp2 = math.sqrt(user2FilmSource.map(num => {
	        ////求出分母第2个变量值
	        math.pow(num, 2) //数学计算
	      }).reduce(_ + _)) //进行叠加
	    val denominator = temp1 * temp2 //求出分母
	    member / denominator //进行计算
	  }
	
	  def main(args: Array[String]) {
	    getSource() //初始化分数
	    var name = "bbb" //设定目标对象
	    users.foreach(user => {
	      //迭代进行计算
	      println(name + " 相对于 " + user + "的相似性分数是：" + getCollaborateSource(name, user))
	    })
	    println()
	    name = "aaa"
	    users.foreach(user => {
	      //迭代进行计算
	      println(name + " 相对于 " + user + "的相似性分数是：" + getCollaborateSource(name, user))
	    })
	  }
	}
	
	```


结果：
	
	```
	D:\1win7\java\jdk\bin\java -Didea.launcher.port=7534 "-Didea.launcher.bin.path=D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\bin" -Dfile.encoding=UTF-8 -classpath "D:\all\idea\SparkLearning\bin;D:\1win7\java\jdk\jre\lib\charsets.jar;D:\1win7\java\jdk\jre\lib\deploy.jar;D:\1win7\java\jdk\jre\lib\ext\access-bridge-64.jar;D:\1win7\java\jdk\jre\lib\ext\dnsns.jar;D:\1win7\java\jdk\jre\lib\ext\jaccess.jar;D:\1win7\java\jdk\jre\lib\ext\localedata.jar;D:\1win7\java\jdk\jre\lib\ext\sunec.jar;D:\1win7\java\jdk\jre\lib\ext\sunjce_provider.jar;D:\1win7\java\jdk\jre\lib\ext\sunmscapi.jar;D:\1win7\java\jdk\jre\lib\ext\zipfs.jar;D:\1win7\java\jdk\jre\lib\javaws.jar;D:\1win7\java\jdk\jre\lib\jce.jar;D:\1win7\java\jdk\jre\lib\jfr.jar;D:\1win7\java\jdk\jre\lib\jfxrt.jar;D:\1win7\java\jdk\jre\lib\jsse.jar;D:\1win7\java\jdk\jre\lib\management-agent.jar;D:\1win7\java\jdk\jre\lib\plugin.jar;D:\1win7\java\jdk\jre\lib\resources.jar;D:\1win7\java\jdk\jre\lib\rt.jar;D:\1win7\scala;D:\1win7\scala\lib;D:\1win7\java\otherJar\spark-assembly-1.5.2-hadoop2.6.0.jar;D:\1win7\java\otherJar\adam-apis_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\adam-cli_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\adam-core_2.10-0.18.3-SNAPSHOT.jar;D:\1win7\java\otherJar\SparkCSV\com.databricks_spark-csv_2.10-1.4.0.jar;D:\1win7\java\otherJar\SparkCSV\com.univocity_univocity-parsers-1.5.1.jar;D:\1win7\java\otherJar\SparkCSV\org.apache.commons_commons-csv-1.1.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1-javadoc.jar;D:\1win7\java\otherJar\SparkAvro\spark-avro_2.10-2.0.1-sources.jar;D:\1win7\java\otherJar\avro\spark-avro_2.10-2.0.2-SNAPSHOT.jar;D:\1win7\java\otherJar\tachyon\tachyon-assemblies-0.7.1-jar-with-dependencies.jar;D:\1win7\scala\lib\scala-actors-migration.jar;D:\1win7\scala\lib\scala-actors.jar;D:\1win7\scala\lib\scala-library.jar;D:\1win7\scala\lib\scala-reflect.jar;D:\1win7\scala\lib\scala-swing.jar;D:\1win7\idea\IntelliJ IDEA Community Edition 15.0.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain org.apache.spark.mllib.learning.recommend.CollaborativeFilteringSpark
	CollaborativeFilteringSpark
	SLF4J: Class path contains multiple SLF4J bindings.
	SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/spark-assembly-1.5.2-hadoop2.6.0.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/adam-cli_2.10-0.18.3-SNAPSHOT.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: Found binding in [jar:file:/D:/1win7/java/otherJar/tachyon/tachyon-assemblies-0.7.1-jar-with-dependencies.jar!/org/slf4j/impl/StaticLoggerBinder.class]
	SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
	SLF4J: Actual binding is of type [org.slf4j.impl.Log4jLoggerFactory]
	2016-05-16 20:57:50 WARN  NativeCodeLoader:62 - Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
	2016-05-16 20:57:52 WARN  MetricsSystem:71 - Using default name DAGScheduler for source because spark.app.id is not set.
	bbb 相对于 aaa的相似性分数是：0.7089175569585667
	bbb 相对于 bbb的相似性分数是：1.0000000000000002
	bbb 相对于 ccc的相似性分数是：0.8780541105074453
	bbb 相对于 ddd的相似性分数是：0.6865554812287477
	bbb 相对于 eee的相似性分数是：0.6821910402406466
	
	aaa 相对于 aaa的相似性分数是：0.9999999999999999
	aaa 相对于 bbb的相似性分数是：0.7089175569585667
	aaa 相对于 ccc的相似性分数是：0.6055300708194983
	aaa 相对于 ddd的相似性分数是：0.564932682866032
	aaa 相对于 eee的相似性分数是：0.8981462390204985
	
	Process finished with exit code 0
	
	```