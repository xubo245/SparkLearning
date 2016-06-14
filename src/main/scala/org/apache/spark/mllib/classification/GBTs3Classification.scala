/**
  * @author xubo
  *         ref:Spark MlLib机器学习实战
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.classification

import java.text.SimpleDateFormat
import java.util.Date

import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.tree.GradientBoostedTrees
import org.apache.spark.mllib.tree.configuration.BoostingStrategy
import org.apache.spark.mllib.tree.model.{DecisionTreeModel, GradientBoostedTreesModel}
import org.apache.spark.mllib.util.MLUtils
import java.util.Map

/**
  * Created by xubo on 2016/5/23.
  */
object GBTs3Classification {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[4]").setAppName(this.getClass().getSimpleName().filter(!_.equals('$')))
    val sc = new SparkContext(conf)

    // Load and parse the data file.
    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/classification/dt.txt")

    var boostingStrategy = BoostingStrategy.defaultParams("Classification") //创建算法类型
    boostingStrategy.setNumIterations(3)
    boostingStrategy.treeStrategy.setNumClasses(2)
    boostingStrategy.treeStrategy.setMaxDepth(5)

    //    boostingStrategy.numIterations = 3 //迭代次数
    //    boostingStrategy.treeStrategy.numClasses = 2 //分类数目
    //    boostingStrategy.treeStrategy.maxDepth = 5 //决策树最高层数
    //    boostingStrategy.treeStrategy.categoricalFeaturesInfo = Map[Int, Int]() //数据格式

    val model = GradientBoostedTrees.train(data, boostingStrategy) //训练模型
    println("model.algo:" + model.algo)
    println("model.trees:" + model.trees)
    println("model.treeWeights:" + model.treeWeights)
    //    model
    println("Learned classification GBT model:\n" + model.toDebugString)

    sc.stop
  }
}
