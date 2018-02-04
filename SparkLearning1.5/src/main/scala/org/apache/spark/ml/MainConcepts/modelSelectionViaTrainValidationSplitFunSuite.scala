/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.ml.MainConcepts

import org.apache.spark.util.SparkLearningFunSuite
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.tuning.{ParamGridBuilder, TrainValidationSplit}
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.sql.SQLContext._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.DataFrame

/**
  * Created by xubo on 2016/6/13.
  */
class modelSelectionViaTrainValidationSplitFunSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    println("RDD can not tranform to DR")
    println("Error:(28, 22) value toDF is not a member of org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint]\n      val data=data0.toDF()\n                     ^")
    //    // Prepare training and test data.
    //    val data0 = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/mllibFromSpark/sample_libsvm_data.txt")
    //    //      val data=data0.toDF()
    //    val Array(training, test) = data.randomSplit(Array(0.9, 0.1), seed = 12345)
    //
    //    val lr = new LinearRegression()
    //
    //    // We use a ParamGridBuilder to construct a grid of parameters to search over.
    //    // TrainValidationSplit will try all combinations of values and determine best model using
    //    // the evaluator.
    //    val paramGrid = new ParamGridBuilder()
    //      .addGrid(lr.regParam, Array(0.1, 0.01))
    //      .addGrid(lr.fitIntercept)
    //      .addGrid(lr.elasticNetParam, Array(0.0, 0.5, 1.0))
    //      .build()
    //
    //    // In this case the estimator is simply the linear regression.
    //    // A TrainValidationSplit requires an Estimator, a set of Estimator ParamMaps, and an Evaluator.
    //    val trainValidationSplit = new TrainValidationSplit()
    //      .setEstimator(lr)
    //      .setEvaluator(new RegressionEvaluator)
    //      .setEstimatorParamMaps(paramGrid)
    //      // 80% of the data will be used for training and the remaining 20% for validation.
    //      .setTrainRatio(0.8)
    //
    //    // Run train validation split, and choose the best set of parameters.
    //    val model = trainValidationSplit.fit(training)
    //
    //    // Make predictions on test data. model is the model with combination of parameters
    //    // that performed best.
    //    model.transform(test)
    //      .select("features", "label", "prediction")
    //      .show()


  }
}
