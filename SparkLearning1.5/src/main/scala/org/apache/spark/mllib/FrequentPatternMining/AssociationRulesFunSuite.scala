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
class AssociationRulesFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    import org.apache.spark.rdd.RDD
    import org.apache.spark.mllib.fpm.AssociationRules
    import org.apache.spark.mllib.fpm.FPGrowth.FreqItemset

    val freqItemsets = sc.parallelize(Seq(
      new FreqItemset(Array("a"), 15L),
      new FreqItemset(Array("b"), 35L),
      new FreqItemset(Array("a", "b"), 12L)
    ));

    val ar = new AssociationRules()
      .setMinConfidence(0.8)
    val results = ar.run(freqItemsets)

    results.collect().foreach { rule =>
      println("[" + rule.antecedent.mkString(",")
        + "=>"
        + rule.consequent.mkString(",") + "]," + rule.confidence)
    }
  }
}
