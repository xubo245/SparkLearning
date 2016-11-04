
更多代码请见：https://github.com/xubo245/SparkLearning

Spark中组件Mllib的学习

1.解释

text8数据集下载：http://mattmahoney.net/dc/text8.zip，没有上传到github，主要是由于大于50M，上传不了。

需要解压上传到hdfs

对text8数据集进行训练，然后查找与china相关的40个单词和相似度

使用的是余弦相似度


2.代码：
	
	package org.apache.spark.mllib.FeatureExtractionAndTransformation
	
	/**
	  * Created by xubo on 2016/6/13.
	  */
	object Word2VecSparkWeb {
	  def main(args: Array[String]) {
	    import org.apache.spark._
	    import org.apache.spark.rdd._
	    import org.apache.spark.SparkContext._
	    import org.apache.spark.mllib.feature.{Word2Vec, Word2VecModel}
	    val conf = new SparkConf()
	      .setAppName("Word2VecSparkWeb")
	    //    println("start sc")
	    val sc = new SparkContext(conf)
	//    "file/data/mllib/input/FeatureExtractionAndTransformation/text8"
	    val input = sc.textFile(args(0)).map(line => line.split(" ").toSeq)
	    //java.lang.OutOfMemoryError: Java heap space
	
	
	    //    val input = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/a.txt").map(line => line.split(" ").toSeq)
	
	    val word2vec = new Word2Vec()
	
	    val model = word2vec.fit(input)
	
	    val synonyms = model.findSynonyms("china", 40)
	    //    val synonyms = model.findSynonyms("hello", 2)
	    //    val synonyms = model.findSynonyms("hell", 2)
	    println("synonyms:" + synonyms.length)
	    for ((synonym, cosineSimilarity) <- synonyms) {
	      println(s"$synonym $cosineSimilarity")
	    }
	  }
	}

脚本：

	hadoop@Master:~/xubo/project/sparkLearning/Word2VecSparkWeb$ cat run.sh 
	    #!/usr/bin/env bash  
	    spark-submit   \
	--class  org.apache.spark.mllib.FeatureExtractionAndTransformation.Word2VecSparkWeb \
	--master spark://219.219.220.149:7077 \
	--executor-memory 4096M \
	--total-executor-cores 20 SparkLearning.jar /xubo/project/sparkLearning/text8



3.结果：
第一次运行

	synonyms:40
	taiwan 2.0250848910722588
	korea 1.8783838604188001
	japan 1.8418373325670603
	mongolia 1.6881217861875888
	thailand 1.6622166551684234
	republic 1.6286308610644606
	manchuria 1.6185821262551892
	kyrgyzstan 1.6155559907230572
	taiwan 2.0250848910722588
	korea 1.8783838604188001
	japan 1.8418373325670603
	mongolia 1.6881217861875888
	thailand 1.6622166551684234
	republic 1.6286308610644606
	manchuria 1.6185821262551892
	kyrgyzstan 1.6155559907230572
	laos 1.6103165736195577
	tibet 1.5989105922525122
	kazakhstan 1.5744151601314242
	singapore 1.5616986094026124
	macau 1.5499675794102241
	mainland 1.5375663678873703
	malaysia 1.5285559184299211
	tajikistan 1.5243343371990146
	india 1.5165506076453936
	nepal 1.5119063076061532
	pakistan 1.5024014083777038
	macedonia 1.5019503598037696
	russia 1.4935935877285467
	manchukuo 1.4881581055559592
	myanmar 1.4821476909912992
	indonesia 1.4793831566122821
	liberia 1.463797338924459
	xinjiang 1.4609436920718337
	philippines 1.4547708371463373
	shanghai 1.4503251746969463
	latvia 1.4386811130949109
	shenzhen 1.4199746865615956
	vietnam 1.418931441623602
	changsha 1.418418516788373

第二次运行：

	hadoop@Master:~/xubo/project/sparkLearning/Word2VecSparkWeb$ ./run.sh
	synonyms:40
	taiwan 1.9833786891085838
	korea 1.8726567347414271
	japan 1.7783736448331358
	republic 1.7004898528298036
	thailand 1.6917626667336083
	tibet 1.6878122461434133
	mongolia 1.652209839095614
	kyrgyzstan 1.645476213591011
	manchuria 1.6096494198211908
	nepal 1.6029630877195205
	singapore 1.5831389923108918
	xinjiang 1.5792116676867995
	guangdong 1.578964448792793
	laos 1.5787364724446695
	macau 1.5749300509413349
	indonesia 1.5711485054771392
	india 1.5706135472342697
	malaysia 1.5674786938684857
	shanghai 1.5370738084879059
	malaya 1.5315005636344519
	philippines 1.5288921196216254
	yuan 1.5130452356753659
	pakistan 1.498783617851528
	mainland 1.4975791691563867
	kazakhstan 1.4828377324602193
	guangzhou 1.479015936080569
	cambodia 1.4727652499197696
	tajikistan 1.469555846355169
	russia 1.4676529059005547
	uzbekistan 1.4619275437713692
	
第三次运行：
	
	hadoop@Master:~/xubo/project/sparkLearning/Word2VecSparkWeb$ ./run.sh
	synonyms:40
	taiwan 1.9153186898933967
	japan 1.79181381373875
	korea 1.775808989075448
	mongolia 1.7218100800986855
	thailand 1.7082852803611082
	indonesia 1.679178757980267
	malaysia 1.6728186293077718
	pakistan 1.6419833973021383
	india 1.6394439184980092
	laos 1.632823427649131
	kazakhstan 1.6233583074612854
	manchuria 1.6154866307442364
	republic 1.605084908540867
	nepal 1.5889757766337764
	tibet 1.5553698521689054
	mainland 1.5422192430156836
	cambodia 1.5393252900985754
	myanmar 1.5363584360594595
	kyrgyzstan 1.531264076283158
	singapore 1.5305132940994244
	philippines 1.523034664556905
	macau 1.5160013609117333
	xinjiang 1.4825373292002604
	latvia 1.471622519733523
	kenya 1.4696299318908457
	changsha 1.4664040946553276
	shanghai 1.455466110605061
	malaya 1.4548293900077052
	burma 1.4509943221704922
	ingushetia 1.4487999900318091


参考

	【1】http://spark.apache.org/docs/1.5.2/mllib-guide.html 
	【2】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【3】https://github.com/xubo245/SparkLearning
	【4】book:Machine Learning with Spark ,Nick Pertreach
    【5】book:Spark MlLib机器学习实战
