/**
  * @author xubo
  *         ref:http://spark.apache.org/docs/1.5.2/mllib-guide.html
  *         more code:https://github.com/xubo245/SparkLearning
  *         more blog:http://blog.csdn.net/xubo245
  */
package org.apache.spark.mllib.FeatureExtractionAndTransformation

import org.apache.spark.util.SparkLearningFunSuite

/**
  * Created by xubo on 2016/6/13.
  */
class TFIDFSuite extends SparkLearningFunSuite {
  test("testFunSuite") {
    import org.apache.spark.rdd.RDD
    import org.apache.spark.SparkContext
    import org.apache.spark.mllib.feature.HashingTF
    import org.apache.spark.mllib.linalg.Vector

    //    val sc: SparkContext = ...

    // Load documents (one per line).
    val documents: RDD[Seq[String]] = sc.textFile("file/data/mllib/input/FeatureExtractionAndTransformation/a.txt").map(_.split(" ").toSeq)

    val hashingTF = new HashingTF()
    val tf: RDD[Vector] = hashingTF.transform(documents)
    println("tf:" + tf)
    tf.foreach(println)
    import org.apache.spark.mllib.feature.IDF

    // ... continue from the previous example
    tf.cache()
    val idf = new IDF().fit(tf)
    val tfidf: RDD[Vector] = idf.transform(tf)
    println("idf:" + idf.idf.size)
    //    idf.idf
    println("tfidf:" + tfidf)
    tfidf.foreach(println)
    import org.apache.spark.mllib.feature.IDF

    // ... continue from the previous example
    //    tf.cache()
    val idf2 = new IDF(minDocFreq = 2).fit(tf)
    val tfidf2: RDD[Vector] = idf2.transform(tf)
    println("idf2:" + idf2.idf.size)

    //    tf.foreach(println)
    println("tfidf2:" + tfidf2)
    tfidf2.foreach(println)
  }

  test("tf idf in 20 news") {

    /* Replace 'PATH' with the path to the 20 Newsgroups Data */
    val path = "file/data/mllib/input/FeatureExtractionAndTransformation/20news-bydate/20news-bydate-train/*"
    val rdd = sc.wholeTextFiles(path)
    // count the number of records in the dataset
    println(rdd.count)
    /*
    ...
    14/10/12 14:27:54 INFO FileInputFormat: Total input paths to process : 11314
    ...
    11314
    */
    val newsgroups = rdd.map { case (file, text) => file.split("/").takeRight(2).head }
    val countByGroup = newsgroups.map(n => (n, 1)).reduceByKey(_ + _).collect.sortBy(-_._2).mkString("\n")
    println(countByGroup)

    /*
(rec.sport.hockey,600)
(soc.religion.christian,599)
(rec.motorcycles,598)
(rec.sport.baseball,597)
(sci.crypt,595)
(rec.autos,594)
(sci.med,594)
(comp.windows.x,593)
(sci.space,593)
(sci.electronics,591)
(comp.os.ms-windows.misc,591)
(comp.sys.ibm.pc.hardware,590)
(misc.forsale,585)
(comp.graphics,584)
(comp.sys.mac.hardware,578)
(talk.politics.mideast,564)
(talk.politics.guns,546)
(alt.atheism,480)
(talk.politics.misc,465)
(talk.religion.misc,377)
*/

    // Tokenizing the text data
    val text = rdd.map { case (file, text) => text }
    val whiteSpaceSplit = text.flatMap(t => t.split(" ").map(_.toLowerCase))
    println(whiteSpaceSplit.distinct.count)
    // 402978
    // inspect a look at a sample of tokens - note we set the random seed to get the same results each time
    println(whiteSpaceSplit.sample(true, 0.3, 42).take(100).mkString(","))
    /*
    atheist,resources
    summary:,addresses,,to,atheism
    keywords:,music,,thu,,11:57:19,11:57:19,gmt
    distribution:,cambridge.,290

    archive-name:,atheism/resources
    alt-atheism-archive-name:,december,,,,,,,,,,,,,,,,,,,,,,addresses,addresses,,,,,,,religion,to:,to:,,p.o.,53701.
    telephone:,sell,the,,fish,on,their,cars,,with,and,written
    inside.,3d,plastic,plastic,,evolution,evolution,7119,,,,,san,san,san,mailing,net,who,to,atheist,press

    aap,various,bible,,and,on.,,,one,book,is:

    "the,w.p.,american,pp.,,1986.,bible,contains,ball,,based,based,james,of
    */

    // split text on any non-word tokens
    val nonWordSplit = text.flatMap(t => t.split("""\W+""").map(_.toLowerCase))
    println(nonWordSplit.distinct.count)
    // 130126
    // inspect a look at a sample of tokens
    println(nonWordSplit.distinct.sample(true, 0.3, 42).take(100).mkString(","))
    /*
    bone,k29p,w1w3s1,odwyer,dnj33n,bruns,_congressional,mmejv5,mmejv5,artur,125215,entitlements,beleive,1pqd9hinnbmi,
    jxicaijp,b0vp,underscored,believiing,qsins,1472,urtfi,nauseam,tohc4,kielbasa,ao,wargame,seetex,museum,typeset,pgva4,
    dcbq,ja_jp,ww4ewa4g,animating,animating,10011100b,10011100b,413,wp3d,wp3d,cannibal,searflame,ets,1qjfnv,6jx,6jx,
    detergent,yan,aanp,unaskable,9mf,bowdoin,chov,16mb,createwindow,kjznkh,df,classifieds,hour,cfsmo,santiago,santiago,
    1r1d62,almanac_,almanac_,chq,nowadays,formac,formac,bacteriophage,barking,barking,barking,ipmgocj7b,monger,projector,
    hama,65e90h8y,homewriter,cl5,1496,zysec,homerific,00ecgillespie,00ecgillespie,mqh0,suspects,steve_mullins,io21087,
    funded,liberated,canonical,throng,0hnz,exxon,xtappcontext,mcdcup,mcdcup,5seg,biscuits
    */

    // filter out numbers
    val regex = """[^0-9]*""".r
    val filterNumbers = nonWordSplit.filter(token => regex.pattern.matcher(token).matches)
    println(filterNumbers.distinct.count)
    // 84912
    println(filterNumbers.distinct.sample(true, 0.3, 42).take(100).mkString(","))
    /*
    reunion,wuair,schwabam,eer,silikian,fuller,sloppiness,crying,crying,beckmans,leymarie,fowl,husky,rlhzrlhz,ignore,
    loyalists,goofed,arius,isgal,dfuller,neurologists,robin,jxicaijp,majorly,nondiscriminatory,akl,sively,adultery,
    urtfi,kielbasa,ao,instantaneous,subscriptions,collins,collins,za_,za_,jmckinney,nonmeasurable,nonmeasurable,
    seetex,kjvar,dcbq,randall_clark,theoreticians,theoreticians,congresswoman,sparcstaton,diccon,nonnemacher,
    arresed,ets,sganet,internship,bombay,keysym,newsserver,connecters,igpp,aichi,impute,impute,raffle,nixdorf,
    nixdorf,amazement,butterfield,geosync,geosync,scoliosis,eng,eng,eng,kjznkh,explorers,antisemites,bombardments,
    abba,caramate,tully,mishandles,wgtn,springer,nkm,nkm,alchoholic,chq,shutdown,bruncati,nowadays,mtearle,eastre,
    discernible,bacteriophage,paradijs,systematically,rluap,rluap,blown,moderates
    */

    // examine potential stopwords
    val tokenCounts = filterNumbers.map(t => (t, 1)).reduceByKey(_ + _)
    val oreringDesc = Ordering.by[(String, Int), Int](_._2)
    println(tokenCounts.top(20)(oreringDesc).mkString("\n"))
    /*
    (the,146532)
    (to,75064)
    (of,69034)
    (a,64195)
    (ax,62406)
    (and,57957)
    (i,53036)
    (in,49402)
    (is,43480)
    (that,39264)
    (it,33638)
    (for,28600)
    (you,26682)
    (from,22670)
    (s,22337)
    (edu,21321)
    (on,20493)
    (this,20121)
    (be,19285)
    (t,18728)
    */

    // filter out stopwords
    val stopwords = Set(
      "the","a","an","of","or","in","for","by","on","but", "is", "not", "with", "as", "was", "if",
      "they", "are", "this", "and", "it", "have", "from", "at", "my", "be", "that", "to"
    )
    val tokenCountsFilteredStopwords = tokenCounts.filter { case (k, v) => !stopwords.contains(k) }
    println(tokenCountsFilteredStopwords.top(20)(oreringDesc).mkString("\n"))
    /*
    (ax,62406)
    (i,53036)
    (you,26682)
    (s,22337)
    (edu,21321)
    (t,18728)
    (m,12756)
    (subject,12264)
    (com,12133)
    (lines,11835)
    (can,11355)
    (organization,11233)
    (re,10534)
    (what,9861)
    (there,9689)
    (x,9332)
    (all,9310)
    (will,9279)
    (we,9227)
    (one,9008)
    */

    // filter out tokens less than 2 characters
    val tokenCountsFilteredSize = tokenCountsFilteredStopwords.filter { case (k, v) => k.size >= 2 }
    println(tokenCountsFilteredSize.top(20)(oreringDesc).mkString("\n"))
    /*
    (ax,62406)
    (you,26682)
    (edu,21321)
    (subject,12264)
    (com,12133)
    (lines,11835)
    (can,11355)
    (organization,11233)
    (re,10534)
    (what,9861)
    (there,9689)
    (all,9310)
    (will,9279)
    (we,9227)
    (one,9008)
    (would,8905)
    (do,8674)
    (he,8441)
    (about,8336)
    (writes,7844)
    */

    // examine tokens with least occurrence
    val oreringAsc = Ordering.by[(String, Int), Int](-_._2)
    println(tokenCountsFilteredSize.top(20)(oreringAsc).mkString("\n"))
    /*
    (lennips,1)
    (bluffing,1)
    (preload,1)
    (altina,1)
    (dan_jacobson,1)
    (vno,1)
    (actu,1)
    (donnalyn,1)
    (ydag,1)
    (mirosoft,1)
    (xiconfiywindow,1)
    (harger,1)
    (feh,1)
    (bankruptcies,1)
    (uncompression,1)
    (d_nibby,1)
    (bunuel,1)
    (odf,1)
    (swith,1)
    (lantastic,1)
    */

    // filter out rare tokens with total occurence < 2
    val rareTokens = tokenCounts.filter{ case (k, v) => v < 2 }.map { case (k, v) => k }.collect.toSet
    val tokenCountsFilteredAll = tokenCountsFilteredSize.filter { case (k, v) => !rareTokens.contains(k) }
    println(tokenCountsFilteredAll.top(20)(oreringAsc).mkString("\n"))
    /*
    (sina,2)
    (akachhy,2)
    (mvd,2)
    (hizbolah,2)
    (wendel_clark,2)
    (sarkis,2)
    (purposeful,2)
    (feagans,2)
    (wout,2)
    (uneven,2)
    (senna,2)
    (multimeters,2)
    (bushy,2)
    (subdivided,2)
    (coretest,2)
    (oww,2)
    (historicity,2)
    (mmg,2)
    (margitan,2)
    (defiance,2)
    */
    println(tokenCountsFilteredAll.count)
    // 51801

    // create a function to tokenize each document
    def tokenize(line: String): Seq[String] = {
      line.split("""\W+""")
        .map(_.toLowerCase)
        .filter(token => regex.pattern.matcher(token).matches)
        .filterNot(token => stopwords.contains(token))
        .filterNot(token => rareTokens.contains(token))
        .filter(token => token.size >= 2)
        .toSeq
    }

    // check that our tokenizer achieves the same result as all the steps above
    println(text.flatMap(doc => tokenize(doc)).distinct.count)
    // 51801
    // tokenize each document
    val tokens = text.map(doc => tokenize(doc))
    println(tokens.first.take(20))
    /*
    WrappedArray(mathew, mathew, mantis, co, uk, subject, alt, atheism, faq, atheist, resources,
      summary, books, addresses, music, anything, related, atheism, keywords, faq)
    */

    // === train TF-IDF model === //

    import org.apache.spark.mllib.linalg.{ SparseVector => SV }
    import org.apache.spark.mllib.feature.HashingTF
    import org.apache.spark.mllib.feature.IDF
    // set the dimensionality of TF-IDF vectors to 2^18
    val dim = math.pow(2, 18).toInt
    val hashingTF = new HashingTF(dim)

    val tf = hashingTF.transform(tokens)
    // cache data in memory
    tf.cache
    val v = tf.first.asInstanceOf[SV]
    println(v.size)
    // 262144
    println(v.values.size)
    // 706
    println(v.values.take(10).toSeq)
    // WrappedArray(1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 1.0)
    println(v.indices.take(10).toSeq)
    // WrappedArray(313, 713, 871, 1202, 1203, 1209, 1795, 1862, 3115, 3166)

    val idf = new IDF().fit(tf)
    val tfidf = idf.transform(tf)
    val v2 = tfidf.first.asInstanceOf[SV]
    println(v2.values.size)
    // 706
    println(v2.values.take(10).toSeq)
    // WrappedArray(2.3869085659322193, 4.670445463955571, 6.561295835827856, 4.597686109673142,  ...
    println(v2.indices.take(10).toSeq)
    // WrappedArray(313, 713, 871, 1202, 1203, 1209, 1795, 1862, 3115, 3166)

    // min and max tf-idf scores
    val minMaxVals = tfidf.map { v =>
      val sv = v.asInstanceOf[SV]
      (sv.values.min, sv.values.max)
    }
    val globalMinMax = minMaxVals.reduce { case ((min1, max1), (min2, max2)) =>
      (math.min(min1, min2), math.max(max1, max2))
    }
    println(globalMinMax)
    // (0.0,66155.39470409753)

    // test out a few common words
    val common = sc.parallelize(Seq(Seq("you", "do", "we")))
    val tfCommon = hashingTF.transform(common)
    val tfidfCommon = idf.transform(tfCommon)
    val commonVector = tfidfCommon.first.asInstanceOf[SV]
    println(commonVector.values.toSeq)
    // WrappedArray(0.9965359935704624, 1.3348773448236835, 0.5457486182039175)

    // test out a few uncommon words
    val uncommon = sc.parallelize(Seq(Seq("telescope", "legislation", "investment")))
    val tfUncommon = hashingTF.transform(uncommon)
    val tfidfUncommon = idf.transform(tfUncommon)
    val uncommonVector = tfidfUncommon.first.asInstanceOf[SV]
    println(uncommonVector.values.toSeq)
    // WrappedArray(5.3265513728351666, 5.308532867332488, 5.483736956357579)

    // === document similarity === //

    val hockeyText = rdd.filter { case (file, text) => file.contains("hockey") }
    // note that the 'transform' method used below is the one which works on a single document
    // in the form of a Seq[String], rather than the version which works on an RDD of documents
    val hockeyTF = hockeyText.mapValues(doc => hashingTF.transform(tokenize(doc)))
    val hockeyTfIdf = idf.transform(hockeyTF.map(_._2))

    // compute cosine similarity using Breeze
    import breeze.linalg._
    val hockey1 = hockeyTfIdf.sample(true, 0.1, 42).first.asInstanceOf[SV]
    val breeze1 = new SparseVector(hockey1.indices, hockey1.values, hockey1.size)
    val hockey2 = hockeyTfIdf.sample(true, 0.1, 43).first.asInstanceOf[SV]
    val breeze2 = new SparseVector(hockey2.indices, hockey2.values, hockey2.size)
    val cosineSim = breeze1.dot(breeze2) / (norm(breeze1) * norm(breeze2))
    println(cosineSim)
    // 0.060250114361164626

    // compare to comp.graphics topic
    val graphicsText = rdd.filter { case (file, text) => file.contains("comp.graphics") }
    val graphicsTF = graphicsText.mapValues(doc => hashingTF.transform(tokenize(doc)))
    val graphicsTfIdf = idf.transform(graphicsTF.map(_._2))
    val graphics = graphicsTfIdf.sample(true, 0.1, 42).first.asInstanceOf[SV]
    val breezeGraphics = new SparseVector(graphics.indices, graphics.values, graphics.size)
    val cosineSim2 = breeze1.dot(breezeGraphics) / (norm(breeze1) * norm(breezeGraphics))
    println(cosineSim2)
    // 0.004664850323792852

    // compare to sport.baseball topic
    val baseballText = rdd.filter { case (file, text) => file.contains("baseball") }
    val baseballTF = baseballText.mapValues(doc => hashingTF.transform(tokenize(doc)))
    val baseballTfIdf = idf.transform(baseballTF.map(_._2))
    val baseball = baseballTfIdf.sample(true, 0.1, 42).first.asInstanceOf[SV]
    val breezeBaseball = new SparseVector(baseball.indices, baseball.values, baseball.size)
    val cosineSim3 = breeze1.dot(breezeBaseball) / (norm(breeze1) * norm(breezeBaseball))
    println(cosineSim3)
    // 0.05047395039466008

    // === document classification === //

    import org.apache.spark.mllib.regression.LabeledPoint
    import org.apache.spark.mllib.classification.NaiveBayes
    import org.apache.spark.mllib.evaluation.MulticlassMetrics

    val newsgroupsMap = newsgroups.distinct.collect().zipWithIndex.toMap
    val zipped = newsgroups.zip(tfidf)
    val train = zipped.map { case (topic, vector) => LabeledPoint(newsgroupsMap(topic), vector) }
    train.cache
    val model = NaiveBayes.train(train, lambda = 0.1)

    val testPath = "/PATH/20news-bydate-test/*"
    val testRDD = sc.wholeTextFiles(testPath)
    val testLabels = testRDD.map { case (file, text) =>
      val topic = file.split("/").takeRight(2).head
      newsgroupsMap(topic)
    }
    val testTf = testRDD.map { case (file, text) => hashingTF.transform(tokenize(text)) }
    val testTfIdf = idf.transform(testTf)
    val zippedTest = testLabels.zip(testTfIdf)
    val test = zippedTest.map { case (topic, vector) => LabeledPoint(topic, vector) }

    val predictionAndLabel = test.map(p => (model.predict(p.features), p.label))
    val accuracy = 1.0 * predictionAndLabel.filter(x => x._1 == x._2).count() / test.count()
    println(accuracy)
    // 0.7915560276155071
    val metrics = new MulticlassMetrics(predictionAndLabel)
    println(metrics.weightedFMeasure)
    // 0.7810675969031116

    // test on raw token features
    val rawTokens = rdd.map { case (file, text) => text.split(" ") }
    val rawTF = rawTokens.map(doc => hashingTF.transform(doc))
    val rawTrain = newsgroups.zip(rawTF).map { case (topic, vector) => LabeledPoint(newsgroupsMap(topic), vector) }
    val rawModel = NaiveBayes.train(rawTrain, lambda = 0.1)
    val rawTestTF = testRDD.map { case (file, text) => hashingTF.transform(text.split(" ")) }
    val rawZippedTest = testLabels.zip(rawTestTF)
    val rawTest = rawZippedTest.map { case (topic, vector) => LabeledPoint(topic, vector) }
    val rawPredictionAndLabel = rawTest.map(p => (rawModel.predict(p.features), p.label))
    val rawAccuracy = 1.0 * rawPredictionAndLabel.filter(x => x._1 == x._2).count() / rawTest.count()
    println(rawAccuracy)
    // 0.7661975570897503
    val rawMetrics = new MulticlassMetrics(rawPredictionAndLabel)
    println(rawMetrics.weightedFMeasure)
    // 0.7628947184990661

    // === Word2Vec === /

    import org.apache.spark.mllib.feature.Word2Vec
    val word2vec = new Word2Vec()
    word2vec.setSeed(42) // we do this to generate the same results each time
    val word2vecModel = word2vec.fit(tokens)
    /*
    ...
    14/10/25 14:21:59 INFO Word2Vec: wordCount = 2133172, alpha = 0.0011868763094487506
    14/10/25 14:21:59 INFO Word2Vec: wordCount = 2144172, alpha = 0.0010640806039941193
    14/10/25 14:21:59 INFO Word2Vec: wordCount = 2155172, alpha = 9.412848985394907E-4
    14/10/25 14:21:59 INFO Word2Vec: wordCount = 2166172, alpha = 8.184891930848592E-4
    14/10/25 14:22:00 INFO Word2Vec: wordCount = 2177172, alpha = 6.956934876302307E-4
    14/10/25 14:22:00 INFO Word2Vec: wordCount = 2188172, alpha = 5.728977821755993E-4
    14/10/25 14:22:00 INFO Word2Vec: wordCount = 2199172, alpha = 4.501020767209707E-4
    14/10/25 14:22:00 INFO Word2Vec: wordCount = 2210172, alpha = 3.2730637126634213E-4
    14/10/25 14:22:01 INFO Word2Vec: wordCount = 2221172, alpha = 2.0451066581171076E-4
    14/10/25 14:22:01 INFO Word2Vec: wordCount = 2232172, alpha = 8.171496035708214E-5
    ...
    14/10/25 14:22:02 INFO SparkContext: Job finished: collect at Word2Vec.scala:368, took 56.585983 s
    14/10/25 14:22:02 INFO MappedRDD: Removing RDD 200 from persistence list
    14/10/25 14:22:02 INFO BlockManager: Removing RDD 200
    14/10/25 14:22:02 INFO BlockManager: Removing block rdd_200_0
    14/10/25 14:22:02 INFO MemoryStore: Block rdd_200_0 of size 9008840 dropped from memory (free 1755596828)
    word2vecModel: org.apache.spark.mllib.feature.Word2VecModel = org.apache.spark.mllib.feature.Word2VecModel@2b94e480
    */
    // evaluate a few words
    word2vecModel.findSynonyms("hockey", 20).foreach(println)
    /*
    (sport,0.6828256249427795)
    (ecac,0.6718048453330994)
    (hispanic,0.6519884467124939)
    (glens,0.6447514891624451)
    (woofers,0.6351765394210815)
    (boxscores,0.6009076237678528)
    (tournament,0.6006366014480591)
    (champs,0.5957855582237244)
    (aargh,0.584071934223175)
    (playoff,0.5834275484085083)
    (ahl,0.5784651637077332)
    (ncaa,0.5680188536643982)
    (pool,0.5612311959266663)
    (olympic,0.5552600026130676)
    (champion,0.5549421310424805)
    (filinuk,0.5528956651687622)
    (yankees,0.5502706170082092)
    (motorcycles,0.5484763979911804)
    (calder,0.5481109023094177)
    (rec,0.5432182550430298)
    */
    word2vecModel.findSynonyms("legislation", 20).foreach(println)
    /*
    (accommodates,0.8149217963218689)
    (briefed,0.7582570314407349)
    (amended,0.7310371994972229)
    (telephony,0.7139414548873901)
    (aclu,0.7080780863761902)
    (pitted,0.7062571048736572)
    (licensee,0.6981208324432373)
    (agency,0.6880651712417603)
    (policies,0.6828961372375488)
    (senate,0.6821110844612122)
    (businesses,0.6814320087432861)
    (permit,0.6797110438346863)
    (cpsr,0.6764014959335327)
    (cooperation,0.6733141541481018)
    (surveillance,0.6670728325843811)
    (restricted,0.6666574478149414)
    (congress,0.6661365628242493)
    (procure,0.6655452251434326)
    (industry,0.6650314927101135)
    (inquiry,0.6644254922866821)
    */
  }
}
