
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

HashingTF将文档的每行转换成（hash值（2^20），（词的id，单个字符时同ascii码一样），（词频））形式


2.代码：
	
	  test("hashing tf on an RDD") {
	    val hashingTF = new HashingTF
	    val localDocs: Seq[Seq[String]] = Seq(
	      "a a b b b c d".split(" "),
	      "a b c d a b c".split(" "),
	      "c b a c b a a".split(" "))
	    val docs = sc.parallelize(localDocs, 2)
	    assert(hashingTF.transform(docs).collect().toSet === localDocs.map(hashingTF.transform).toSet)
	
	    println("docs:")
	    docs.foreach(println)
	    println("hashingTF.transform(docs).collect():")
	    hashingTF.transform(docs).collect().foreach(println)
	    println(" localDocs.map(hashingTF.transform):")
	    localDocs.map(hashingTF.transform).foreach(println)
	
	  }


3.结果：
	
	docs:
	WrappedArray(a, a, b, b, b, c, d)
	WrappedArray(a, b, c, d, a, b, c)
	WrappedArray(c, b, a, c, b, a, a)
	hashingTF.transform(docs).collect():
	(1048576,[97,98,99,100],[2.0,3.0,1.0,1.0])
	(1048576,[97,98,99,100],[2.0,2.0,2.0,1.0])
	(1048576,[97,98,99],[3.0,2.0,2.0])
	 localDocs.map(hashingTF.transform):
	(1048576,[97,98,99,100],[2.0,3.0,1.0,1.0])
	(1048576,[97,98,99,100],[2.0,2.0,2.0,1.0])
	(1048576,[97,98,99],[3.0,2.0,2.0])


aa的id为3104



参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
