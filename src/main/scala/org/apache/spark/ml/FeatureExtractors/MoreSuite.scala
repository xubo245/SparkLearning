package org.apache.spark.ml.FeatureExtractors

import org.apache.log4j.{Level, Logger}
import org.apache.spark.mllib.util.MLUtils
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

  test("VectorIndexerSuite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    import org.apache.spark.ml.feature.VectorIndexer

//    val data = MLUtils.loadLibSVMFile(sc, "data/mllib/sample_libsvm_data.txt").toDF()
//    val indexer = new VectorIndexer()
//      .setInputCol("features")
//      .setOutputCol("indexed")
//      .setMaxCategories(10)
//    val indexerModel = indexer.fit(data)
//    val categoricalFeatures: Set[Int] = indexerModel.categoryMaps.keys.toSet
//    println(s"Chose ${categoricalFeatures.size} categorical features: " +
//      categoricalFeatures.mkString(", "))
//
//    // Create new column "indexed" with categorical values transformed to indices
//    val indexedData = indexerModel.transform(data)


  }


  test("Suite") {
    Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
    Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.ERROR)
    println("hello")
  }
}



