import org.apache.spark.mllib.classification. SVMWithSGD
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkContext, SparkConf}

object GastriCcancer {
  def main(args: Array[String]) {
val conf = new SparkConf()                                     //创建环境变量
.setMaster("local")                                             //设置本地化处理
.setAppName("SVMTest ")                        		      //设定名称
    val sc = new SparkContext(conf)                                 //创建环境变量实例

    val data = MLUtils.loadLibSVMFile(sc, "c://wa.txt")				//获取数据集
    val splits = data.randomSplit(Array(0.7, 0.3), seed = 11L)			//对数据集切分
    val parsedData = splits(0)									//分割训练数据
    val parseTtest = splits(1)									//分割测试数据
    val model = SVMWithSGD.train(parsedData,50)					//训练模型
    val predictionAndLabels = parseTtest.map { 					//计算测试值
case LabeledPoint(label, features) =>						//计算测试值
 val prediction = model.predict(features)						//计算测试值
      (prediction, label)										//存储测试和预测值
}

    val metrics = new MulticlassMetrics(predictionAndLabels)			//创建验证类
    val precision = metrics.precision								//计算验证值
    println("Precision = " + precision)							//打印验证值

    val patient = Vectors.dense(Array(70,3,180.0,4,3))				//计算患者可能性
    if(patient == 1) println("患者的胃癌有几率转移。")				//做出判断
      else println("患者的胃癌没有几率转移。")					//做出判断
  }
}
