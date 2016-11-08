
更多代码请见：https://github.com/xubo245/SparkLearning

spark源码解读系列环境：spark-1.5.2、hadoop-2.6.0、scala-2.10.4

# 1.理解 #

不知道怎么返回RDD[(String, Int)



# 2.代码： #

	package util
	
	import org.apache.spark.rdd.RDD
	import org.apache.spark.{SparkConf, SparkContext}
	
	/**
	  * Created by xubo on 2016/10/31.
	  */
	object ReduceTest {
	  def main(args: Array[String]) {
	    val conf = new SparkConf().setAppName("ReduceTest Application").setMaster("local[4]")
	    val sc = new SparkContext(conf)
	    val rdd = sc.parallelize(Array(("hello", 1), ("hello", 2), ("world", 5)))
	    val result=reduceByKeyTest(sc, rdd)
	    println(result)
	    sc.stop()
	  }
	
	  /**
	    * 
	    * @param sc
	    * @param rdd
	    * @return
	    */
	  def reduceByKeyTest(sc: SparkContext, rdd: RDD[(String, Int)]):(String, Int) = {
	    val rdd2=rdd.reduce { (a, b) =>
	      if (a._1 == b._1) {
	        (a._1, a._2 + b._2)
	      } else {
	        a
	      }
	    }
	    rdd2
	  }
	}




# 3.结果： #



参考

	【1】http://spark.apache.org/
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:《深入理解spark核心思想与源码分析》
    【5】book:《spark核心源码分析和开发实战》
