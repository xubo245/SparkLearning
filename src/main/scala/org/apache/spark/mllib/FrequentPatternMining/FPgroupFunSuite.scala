/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.FrequentPatternMining

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class FPgroupFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    import org.apache.spark.rdd.RDD
    import org.apache.spark.mllib.fpm.FPGrowth

    val data = sc.textFile("file/data/mllib/input/mllibFromSpark/sample_fpgrowth.txt")

    val transactions: RDD[Array[String]] = data.map(s => s.trim.split(' '))

    val fpg = new FPGrowth()
      .setMinSupport(0.2)
      .setNumPartitions(10)
    val model = fpg.run(transactions)

    model.freqItemsets.collect().foreach { itemset =>
      println(itemset.items.mkString("[", ",", "]") + ", " + itemset.freq)
    }

    val minConfidence = 0.8
    model.generateAssociationRules(minConfidence).collect().foreach { rule =>
      println(
        rule.antecedent.mkString("[", ",", "]")
          + " => " + rule.consequent.mkString("[", ",", "]")
          + ", " + rule.confidence)
    }
  }
}
