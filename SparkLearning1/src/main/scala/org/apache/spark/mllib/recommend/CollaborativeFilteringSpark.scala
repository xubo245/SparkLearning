/**
  * @author xubo
  *         time 2016.516
  *         ref 《Spark MlLib 机器学习实战》P64
  */
package org.apache.spark.mllib.recommend

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.Map

object CollaborativeFilteringSpark {
  val conf = new SparkConf().setMaster("local").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
//    println(this.getClass().getSimpleName().filter(!_.equals('$')))
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
