package org.apache.spark.ml.FeatureExtractors

import ch.epfl.lamp.compiler.msil.Attribute
import org.apache.log4j.{Level, Logger}
import org.apache.spark.ml.attribute.{AttributeGroup, NumericAttribute}
import org.apache.spark.ml.feature.VectorSlicer
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructType
import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xingyun.xb on 2016/7/24.
  */
class MoreSuite extends SparkLearningFunSuite {


  /**
    * 主成分的分析
    */
  test("PCASuite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.PCA
    import org.apache.spark.mllib.linalg.Vectors

    val data = Array(
      Vectors.sparse(5, Seq((1, 1.0), (3, 7.0))),
      Vectors.dense(2.0, 0.0, 3.0, 4.0, 5.0),
      Vectors.dense(4.0, 0.0, 0.0, 6.0, 7.0)
    )
    val df = sqlContext.createDataFrame(data.map(Tuple1.apply)).toDF("features")
    val pca = new PCA()
      .setInputCol("features")
      .setOutputCol("pcaFeatures")
      .setK(3)
      .fit(df)
    val pcaDF = pca.transform(df)
    val result = pcaDF.select("pcaFeatures")

    df.show()
    df.foreach(println)
    result.show()
    result.foreach(println)
  }

  /**
    * 多项式展开
    * Perform feature expansion in a polynomial space. As said in wikipedia of Polynomial Expansion, which is available at http://en.wikipedia.org/wiki/Polynomial_expansion, "In mathematics, an expansion of a product of sums expresses it as a sum of products by using the fact that multiplication distributes over addition". Take a 2-variable feature vector as an example: (x, y), if we want to expand it with degree 2, then we get (x, x * x, y, x * y, y * y).
    */
  test("PolynomialExpansionSuite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.PolynomialExpansion
    import org.apache.spark.mllib.linalg.Vectors

    val data = Array(
      Vectors.dense(-2.0, 2.3),
      Vectors.dense(0.0, 0.0),
      Vectors.dense(0.6, -1.1)
    )
    val df = sqlContext.createDataFrame(data.map(Tuple1.apply)).toDF("features")
    val polynomialExpansion = new PolynomialExpansion()
      .setInputCol("features")
      .setOutputCol("polyFeatures")
      .setDegree(2)
    val polyDF = polynomialExpansion.transform(df)

    df.show()
    df.foreach(println)
    polyDF.select("polyFeatures").take(3).foreach(println)
    //degree=2
    //[[0.0,0.0]]
    //[[-2.0,2.3]]
    //[[0.6,-1.1]]
    //[[-2.0,4.0,2.3,-4.6,5.289999999999999]]
    //[[0.0,0.0,0.0,0.0,0.0]]
    //[[0.6,0.36,-1.1,-0.66,1.2100000000000002]]

    //degree=3
    //[[0.6,-1.1]]
    //[[0.0,0.0]]
    //[[-2.0,2.3]]
    //[[-2.0,4.0,-8.0,2.3,-4.6,9.2,5.289999999999999,-10.579999999999998,12.166999999999996]]
    //[[0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0]]
    //[[0.6,0.36,0.216,-1.1,-0.66,-0.396,1.2100000000000002,0.7260000000000001,-1.3310000000000004]]
  }

  /**
    * 离散余弦变换
    * https://en.wikipedia.org/wiki/Discrete_cosine_transform#DCT-II
    */
  test("Discrete Cosine Transform (DCT) Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.DCT
    import org.apache.spark.mllib.linalg.Vectors

    val data = Seq(
      Vectors.dense(0.0, 1.0, -2.0, 3.0),
      Vectors.dense(-1.0, 2.0, 4.0, -7.0),
      Vectors.dense(14.0, -2.0, -5.0, 1.0))
    val df = sqlContext.createDataFrame(data.map(Tuple1.apply)).toDF("features")
    val dct = new DCT()
      .setInputCol("features")
      .setOutputCol("featuresDCT")
      .setInverse(false)
    val dctDf = dct.transform(df)
    df.show()
    df.foreach(println)
    dctDf.select("featuresDCT").show(3)
    dctDf.foreach(println)
  }

  /**
    * 給字符串序列建立索引，先对字符串按频度进行排序，然后依次打上label，出现次数最多的字符串index为0
    */
  test("StringIndexer Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.StringIndexer

    val df = sqlContext.createDataFrame(
      Seq((0, "a"), (1, "b"), (2, "c"), (3, "a"), (4, "a"), (5, "c"))
      //      Seq((0, "a"), (1, "b"), (2, "c"), (3, "a"), (4, "a"), (5, "c"), (6, "d"), (7, "d"), (8, "d"))
    ).toDF("id", "category")
    val indexer = new StringIndexer()
      .setInputCol("category")
      .setOutputCol("categoryIndex")
    val indexed = indexer.fit(df).transform(df)
    indexed.show()

  }

  /**
    * 独热编码
    * 自然状态码为：000,001,010,011,100,101
    * 独热编码为：000001,000010,000100,001000,010000,100000
    * 可以这样理解，对于每一个特征，如果它有m个可能值，那么经过独热编码后，就变成了m个二元特征。并且，这些特征互斥，每次只有一个激活。因此，数据会变成稀疏的。
    * 参考：http://blog.csdn.net/ariessurfer/article/details/42526673
    */
  test("OneHotEncoderSuite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.{OneHotEncoder, StringIndexer}

    val df = sqlContext.createDataFrame(Seq(
      (0, "a"),
      (1, "b"),
      (2, "c"),
      (3, "a"),
      (4, "a"),
      (5, "c"),
      (6, "d"),
      (7, "e"),
      (8, "f")
    )).toDF("id", "category")

    val indexer = new StringIndexer()
      .setInputCol("category")
      .setOutputCol("categoryIndex")
      .fit(df)
    val indexed = indexer.transform(df)

    indexed.show()

    val encoder = new OneHotEncoder().setInputCol("categoryIndex").
      setOutputCol("categoryVec")
    val encoded = encoder.transform(indexed)
    encoded.select("id", "categoryVec").foreach(println)
    encoded.show()
    encoded.foreach(println)
  }

  /**
    * 给向量的集合中的分类特征列建立索引
    * 步骤：
    * 1.输入向量类型列和参数maxCategories
    * 2.通过唯一的值确定类
    * 3.对每个类特征计算以0位基础的分类索引
    * 对分类特征建立索引，并将原始的值转换成索引号
    *
    */
  test("VectorIndexerSuite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.VectorIndexer

    val dataRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")
    val data = sqlContext.createDataFrame(dataRDD)
    val indexer = new VectorIndexer()
      .setInputCol("features")
      .setOutputCol("indexed")
      .setMaxCategories(10)
    val indexerModel = indexer.fit(data)
    val categoricalFeatures: Set[Int] = indexerModel.categoryMaps.keys.toSet
    println(s"Chose ${categoricalFeatures.size} categorical features: " +
      categoricalFeatures.mkString(", "))
    println("uid")
    println(indexerModel.uid.toSet)
    println("numFeatures:")
    println(indexerModel.numFeatures)
    println("data.count")
    println(data.count())

    // Create new column "indexed" with categorical values transformed to indices
    val indexedData = indexerModel.transform(data)
    data.show
    data.foreach(println)

    indexedData.show
    indexedData.foreach(println)

  }

  /**
    * 测试simple数据
    */
  test("VectorIndexerSuite simple") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.VectorIndexer

    val vs = Vectors.sparse(4, Array(0, 1, 2, 3), Array(9, 5, 2, 7))
    val neg = LabeledPoint(2, vs) //对稀疏向量建立标记点


    val dataRDD = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data_simple.txt")
    val data = sqlContext.createDataFrame(dataRDD)
    val indexer = new VectorIndexer()
      .setInputCol("features")
      .setOutputCol("indexed")
      .setMaxCategories(10)
    val indexerModel = indexer.fit(data)
    val categoricalFeatures: Set[Int] = indexerModel.categoryMaps.keys.toSet
    println(s"Chose ${categoricalFeatures.size} categorical features: " +
      categoricalFeatures.mkString(", "))
    println("uid")
    println(indexerModel.uid.toSet)
    println("numFeatures:")
    println(indexerModel.numFeatures)
    println("data.count")
    println(data.count())
    println("indexerModel.maxCategories：")
    println(indexerModel.maxCategories)

    // Create new column "indexed" with categorical values transformed to indices
    val indexedData = indexerModel.transform(data)
    data.show
    data.foreach(println)

    indexedData.show
    indexedData.foreach(println)

  }

  /**
    * NormalizerSuite,归一化
    * MLlib中有多种方式归一化：Spark中组件Mllib的学习58
    * 处理参数正常话，默认p为2
    * 本段为1，取值最大的数的绝对值做分母，将每个数除以这个分母
    * 比如：
    * [1.0,(187,[152,153,154,180,181,182],[51.0,63.0,197.0,20.0,254.0,-230.0]),(187,[152,153,154,180,181,182],[0.20078740157480315,0.24803149606299213,0.7755905511811023,0.07874015748031496,1.0,-0.905511811023622])]
    * [1.0,(187,[158,159,160,161,185,186],[124.0,253.0,-255.0,63.0,96.0,244.0]),(187,[158,159,160,161,185,186],[0.48627450980392156,0.9921568627450981,-1.0,0.24705882352941178,0.3764705882352941,0.9568627450980393])]
    */
  test("NormalizerSuite simple") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.Normalizer
    import org.apache.spark.mllib.util.MLUtils

    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data_simple.txt")
    val dataFrame = sqlContext.createDataFrame(data)

    // Normalize each Vector using $L^1$ norm.
    val normalizer = new Normalizer()
      .setInputCol("features")
      .setOutputCol("normFeatures")
      .setP(1.0)
    val l1NormData = normalizer.transform(dataFrame)

    // Normalize each Vector using $L^\infty$ norm.
    val lInfNormData = normalizer.transform(dataFrame, normalizer.p -> Double.PositiveInfinity)
    dataFrame.show
    dataFrame.foreach(println)
    lInfNormData.show
    lInfNormData.foreach(println)
  }

  test("NormalizerSuite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.Normalizer
    import org.apache.spark.mllib.util.MLUtils

    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data.txt")
    val dataFrame = sqlContext.createDataFrame(data)

    // Normalize each Vector using $L^1$ norm.
    val normalizer = new Normalizer()
      .setInputCol("features")
      .setOutputCol("normFeatures")
      .setP(1.0)
    val l1NormData = normalizer.transform(dataFrame)

    // Normalize each Vector using $L^\infty$ norm.
    val lInfNormData = normalizer.transform(dataFrame, normalizer.p -> Double.PositiveInfinity)
    dataFrame.show
    dataFrame.foreach(println)
    lInfNormData.show
    lInfNormData.foreach(println)
  }


  /**
    * Standardizes features by removing the mean and scaling to unit variance using column summary statistics on the samples in the training set.
    * MLlib中也有
    */
  test("StandardScaler Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.StandardScaler
    import org.apache.spark.mllib.util.MLUtils

    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data_simple.txt")
    val dataFrame = sqlContext.createDataFrame(data)
    val scaler = new StandardScaler()
      .setInputCol("features")
      .setOutputCol("scaledFeatures")
      .setWithStd(true)
      .setWithMean(false)

    // Compute summary statistics by fitting the StandardScaler
    val scalerModel = scaler.fit(dataFrame)

    // Normalize each feature to have unit standard deviation.
    val scaledData = scalerModel.transform(dataFrame)

    dataFrame.show
    dataFrame.foreach(println)
    scaledData.show
    scaledData.foreach(println)

  }


  /**
    * MinMaxScaler transforms a dataset of Vector rows, rescaling each feature to a specific range (often [0, 1]).
    * http://spark.apache.org/docs/1.5.2/api/scala/index.html#org.apache.spark.ml.feature.MinMaxScaler
    */
  test("MinMaxScaler Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.MinMaxScaler
    import org.apache.spark.mllib.util.MLUtils

    val data = MLUtils.loadLibSVMFile(sc, "file/data/mllib/input/basic/sample_libsvm_data_simple.txt")
    val dataFrame = sqlContext.createDataFrame(data)
    val scaler = new MinMaxScaler()
      .setInputCol("features")
      .setOutputCol("scaledFeatures")

    // Compute summary statistics and generate MinMaxScalerModel
    val scalerModel = scaler.fit(dataFrame)

    // rescale each feature to range [min, max].
    val scaledData = scalerModel.transform(dataFrame)
    dataFrame.show
    dataFrame.foreach(println)
    scaledData.show
    scaledData.foreach(println)
  }

  /**
    * 分桶操作
    */
  test("Bucketizer Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.Bucketizer
    import org.apache.spark.sql.DataFrame

    val splits = Array(Double.NegativeInfinity, -0.5, 0.0, 0.5, Double.PositiveInfinity)

    val data = Array(-0.5, -0.3, 0.0, 0.2)
    val dataFrame = sqlContext.createDataFrame(data.map(Tuple1.apply)).toDF("features")

    val bucketizer = new Bucketizer()
      .setInputCol("features")
      .setOutputCol("bucketedFeatures")
      .setSplits(splits)

    // Transform original data into its bucket index.
    val bucketedData = bucketizer.transform(dataFrame)

    dataFrame.show
    dataFrame.foreach(println)
    bucketedData.show
    bucketedData.foreach(println)
  }

  /**
    * Hadamard乘积(ElementwiseProduct) ElementwiseProduct对输入向量的每个元素乘以一个权重向量的每个元素，
    * 对输入向量每个元素逐个进行放缩。这个称为对输入向量v 和变换向量scalingVec 使用Hadamard product(阿达玛积)进行变换，
    * 最终产生一个新的向量。用向量 w 表示 scalingVec ，则Hadamard product可以表示为
    * reference http://blog.csdn.net/hopeatme/article/details/50945521
    * 个人理解:
    * 将行向量乘以转换向量，对应相乘
    * (1.0, 2.0, 3.0)*(0.0, 1.0, 2.0)=（0.0,2.0,6.0）
    */

  test(" ElementwiseProduct Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.ElementwiseProduct
    import org.apache.spark.mllib.linalg.Vectors

    // Create some vector data; also works for sparse vectors
    val dataFrame = sqlContext.createDataFrame(Seq(
      ("a", Vectors.dense(1.0, 2.0, 3.0)),
      ("b", Vectors.dense(4.0, 5.0, 6.0)))).toDF("id", "vector")

    val transformingVector = Vectors.dense(0.0, 1.0, 2.0)
    val transformer = new ElementwiseProduct()
      .setScalingVec(transformingVector)
      .setInputCol("vector")
      .setOutputCol("transformedVector")

    // Batch transform the vectors to create new column:
    val result = transformer.transform(dataFrame)

    dataFrame.show
    dataFrame.foreach(println)
    result.show
    result.foreach(println)
  }

  /**
    * 向量组装，从原来的数据中组装生成新的数据，然后放回原来的dataframe中
    */
  test("VectorAssembler Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.mllib.linalg.Vectors
    import org.apache.spark.ml.feature.VectorAssembler

    val dataset = sqlContext.createDataFrame(
      Seq((0, 18, 1.0, Vectors.dense(0.0, 10.0, 0.5), 1.0))
    ).toDF("id", "hour", "mobile", "userFeatures", "clicked")
    val assembler = new VectorAssembler()
      .setInputCols(Array("hour", "mobile", "userFeatures"))
      .setOutputCol("features")
    val output = assembler.transform(dataset)
    println(output.select("features", "clicked").first())

    dataset.show
    dataset.foreach(println)
    output.show
    output.foreach(println)

  }

  /**
    * VectorSlicer用于从原来的特征向量中切割一部分，形成新的特征向量，
    * 比如，原来的特征向量长度为10，我们希望切割其中的5~10作为新的特征向量，使用VectorSlicer可以快速实现。
    * http://blog.csdn.net/u012102306/article/details/51556754
    *
    *
    */
  test("VectorSlicer Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)

    //构造特征数组
    val data = Array(Row(Vectors.dense(-2.0, 2.3, 0.0)))

    //为特征数组设置属性名（字段名），分别为f1 f2 f3
    val defaultAttr = NumericAttribute.defaultAttr
    val attrs = Array("f1", "f2", "f3").map(defaultAttr.withName)

    import org.apache.spark.ml.attribute.{Attribute, AttributeGroup, NumericAttribute}

    val attrGroup = new AttributeGroup("userFeatures", attrs.asInstanceOf[Array[Attribute]])

    //构造DataFrame
    val dataRDD = sc.parallelize(data)
    val dataset = sqlContext.createDataFrame(dataRDD, StructType(Array(attrGroup.toStructField())))

    print("原始特征：")
    dataset.show()
    dataset.foreach(println)
    dataset.take(1).foreach(println)


    //构造切割器
    var slicer = new VectorSlicer().setInputCol("userFeatures").setOutputCol("features")

    //根据索引号，截取原始特征向量的第1列和第3列
    slicer.setIndices(Array(0, 2))
    println("output1: ")
    slicer.transform(dataset).show()
    slicer.transform(dataset).select("userFeatures", "features").first()

    //根据字段名，截取原始特征向量的f2和f3
    slicer = new VectorSlicer().setInputCol("userFeatures").setOutputCol("features")
    slicer.setNames(Array("f2", "f3"))
    println("output2: ")
    slicer.transform(dataset).show()
    slicer.transform(dataset).select("userFeatures", "features").first()

    //索引号和字段名也可以组合使用，截取原始特征向量的第1列和f2
    slicer = new VectorSlicer().setInputCol("userFeatures").setOutputCol("features")
    slicer.setIndices(Array(0)).setNames(Array("f2"))
    println("output3: ")
    slicer.transform(dataset).show()
    slicer.transform(dataset).select("userFeatures", "features").first()

  }

  test("VectorSlicer Suite from sparkweb") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.mllib.linalg.Vectors
    import org.apache.spark.ml.attribute.{Attribute, AttributeGroup, NumericAttribute}
    import org.apache.spark.ml.feature.VectorSlicer
    import org.apache.spark.sql.types.StructType
    import org.apache.spark.sql.{DataFrame, Row, SQLContext}

    val data = Array(
      Vectors.sparse(3, Seq((0, -2.0), (1, 2.3))),
      Vectors.dense(-2.0, 2.3, 0.0)
    )

    val defaultAttr = NumericAttribute.defaultAttr
    val attrs = Array("f1", "f2", "f3").map(defaultAttr.withName)
    val attrGroup = new AttributeGroup("userFeatures", attrs.asInstanceOf[Array[Attribute]])

    //            val dataRDD = sc.parallelize(data).map(Row.apply)
    //        val dataset = sqlContext.createDataFrame(dataRDD, StructType(attrGroup.toStructField()))

    //    val slicer = new VectorSlicer().setInputCol("userFeatures").setOutputCol("features")
    //
    //    slicer.setIndices(1).setNames("f3")
    //    // or slicer.setIndices(Array(1, 2)), or slicer.setNames(Array("f2", "f3"))
    //
    //    val output = slicer.transform(dataset)
    //    println(output.select("userFeatures", "features").first())
  }


  /**
    * RFormula用于将数据中的字段通过R语言的Model Formulae转换成特征值，输出结果为一个特征向量和Double类型的label。
    * 关于R语言Model Formulae的介绍可参考：https://stat.ethz.ch/R-manual/R-devel/library/stats/html/formula.html
    * http://blog.csdn.net/u012102306/article/details/51556754
    */
  test("RFormula Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.RFormula

    val dataset = sqlContext.createDataFrame(Seq(
      (7, "US", 18, 1.0),
      (8, "CA", 12, 0.0),
      (9, "NZ", 15, 0.0)
    )).toDF("id", "country", "hour", "clicked")
    val formula = new RFormula()
      .setFormula("clicked ~ country + hour")
      .setFeaturesCol("features")
      .setLabelCol("label")
    val output = formula.fit(dataset).transform(dataset)
    dataset.show()
    dataset.foreach(println)
    output.show()
    output.foreach(println)
    output.select("features", "label").show()
  }

  test("RFormula Suite2") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.RFormula

    //构造数据集
    val dataset = sqlContext.createDataFrame(Seq(
      (7, "US", 18, 1.0),
      (8, "CA", 12, 0.0),
      (9, "NZ", 15, 0.0)
    )).toDF("id", "country", "hour", "clicked")
    dataset.select("id", "country", "hour", "clicked").show()

    //当需要通过country和hour来预测clicked时候，
    //构造RFormula，指定Formula表达式为clicked ~ country + hour
    val formula = new RFormula().setFormula("clicked ~ country + hour").setFeaturesCol("features").setLabelCol("label")
    //生成特征向量及label
    val output = formula.fit(dataset).transform(dataset)
    output.select("id", "country", "hour", "clicked", "features", "label").show()

    dataset.show()
    dataset.foreach(println)
    output.show()
    output.foreach(println)
    output.select("features", "label").show()
  }

}



