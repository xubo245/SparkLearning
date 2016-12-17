
系统环境：  
Spark-1.5.2  
hadoop2.6.0
scala-2.10.4
idea 15.0.4

Spark mllib学习目录：

**1.数据类型**

	Spark中组件Mllib的学习12之密集向量和稀疏向量的生成
	Spark中组件Mllib的学习13之给向量打标签
	Spark中组件Mllib的学习14之从文本中读取带标签的数据，生成带label的向量
	Spark中组件Mllib的学习15之创建分布式矩阵
	Spark中组件Mllib的学习16之分布式行矩阵的四种形式
	Spark中组件Mllib的学习43之BlockMatrix

**2.基本统计**

	Spark中组件Mllib的学习3之用户相似度计算
	Spark中组件Mllib的学习17之colStats_以列为基础计算统计量的基本数据
	Spark中组件Mllib的学习18之corr_两组数据相关关系计算（Pearson、Spearman）
	Spark中组件Mllib的学习19之分层抽样
	Spark中组件Mllib的学习20之假设检验-卡方检验
	Spark中组件Mllib的学习21之随机数-RandomRDD产生
	Spark中组件Mllib的学习22之假设检验-卡方检验概念理解
	Spark中组件Mllib的学习42之rowMatrix的QR分解

**3.分类和回归**

	Spark中组件Mllib的学习23之随机梯度下降（SGD）
	Spark中组件Mllib的学习24之线性回归1-小数据集
	Spark中组件Mllib的学习25之线性回归2-较大数据集（多元）
	Spark中组件Mllib的学习26之逻辑回归-简单数据集，带预测
	Spark中组件Mllib的学习27之逻辑回归-多元逻辑回归，较大数据集，带预测准确度计算
	Spark中组件Mllib的学习28之支持向量机SVM-方法1
	Spark中组件Mllib的学习29之支持向量机SVM-方法2
	Spark中组件Mllib的学习30之逻辑回归LogisticRegressionWithLBFGS
	Spark中组件Mllib的学习31之朴素贝叶斯分类器（多项式朴素贝叶斯）
	Spark中组件Mllib的学习32之朴素贝叶斯分类器（伯努利朴素贝叶斯）
	Spark中组件Mllib的学习33之决策树（使用Gini）
	Spark中组件Mllib的学习34之决策树（使用entropy）
	Spark中组件Mllib的学习35之随机森林（entropy）进行分类
	Spark中组件Mllib的学习36之决策树（使用variance）进行回归
	Spark中组件Mllib的学习37之随机森林（Gini）进行分类
	Spark中组件Mllib的学习38之随机森林（使用variance）进行回归
	Spark中组件Mllib的学习39之梯度提升树（GBT）用于分类
	Spark中组件Mllib的学习40之梯度提升树（GBT）用于回归
	Spark中组件Mllib的学习41之保序回归（Isotonic regression）


**4.协同过滤**

	Spark中组件Mllib的学习2之MovieLensALS学习（集群run-eaxmples运行）
	Spark中组件Mllib的学习4之examples中的MovieLensALS修改本地运行
	Spark中组件Mllib的学习5之ALS测试（apache spark）
	Spark中组件Mllib的学习6之ALS测试（apache spark 含隐式转换）
	Spark中组件Mllib的学习7之ALS隐式转换训练的model来预测数据
	Spark中组件Mllib的学习8之ALS训练的model来预测数据
	Spark中组件Mllib的学习9之ALS训练的model来预测数据的准确率研究
	Spark中组件Mllib的学习10之修改MovieLens来对movieLen中的100k数据进行预测
	Spark中组件Mllib的学习11之使用ALS对movieLens中一百万条（1M）数据集进行训练，并对输入的新用户数据进行电影推荐

**5.聚类**

	Spark中组件Mllib的学习1之Kmeans错误解决
	Spark中组件Mllib的学习44之高斯混合聚类GaussianMixture
	Spark中组件Mllib的学习45之用高斯混合模型来预测
	Spark中组件Mllib的学习46之Power iteration clustering
	Spark中组件Mllib的学习47之隐含狄利克雷分布(Latent Dirichlet allocation (LDA)学习
	Spark中组件Mllib的学习48之流式k均值（Streaming kmeans）

**6.降维**

	Spark中组件Mllib的学习49之奇异值分解SVD(Singular value decomposition)
	Spark中组件Mllib的学习50之主成份分析PCA
	Spark中组件Mllib的学习51之使用PCA从数据集中得到主向量

**7.特征提取和转换**

	Spark中组件Mllib的学习52之TF-IDF学习
	Spark中组件Mllib的学习53之HashingTF理解和使用
	Spark中组件Mllib的学习53之Word2Vec简单实例
	Spark中组件Mllib的学习54之word2Vec实例分析（text8数据集）
	Spark中组件Mllib的学习55之使用TfIdf来分析20news数据集
	Spark中组件Mllib的学习56之标准化（StandardScaler，来自SparkWeb）
	Spark中组件Mllib的学习57之标准化参数和公式理解（StandardScaler，来自SparkCode)
	Spark中组件Mllib的学习58之归一化(Normalizer)Normalization using L1 distance
	Spark中组件Mllib的学习59之归一化(Normalizer)Normalization using L2 distance
	Spark中组件Mllib的学习60之归一化(Normalizer)Normalization using L^Inf distance
	Spark中组件Mllib的学习61之归一化(Normalizer)SparkWeb实例分析
	Spark中组件Mllib的学习62之特征选择中的卡方选择器
	Spark中组件Mllib的学习63之特征选择中的卡方选择器实例（libsvm数据集）
	Spark中组件Mllib的学习64之元素智能乘积ElementwiseProduct
	Spark中组件Mllib的学习65之使用PCA进行特征转换

**8.频繁项挖掘**

	Spark中组件Mllib的学习66之FP-growth
	Spark中组件Mllib的学习67之关联规则AssociationRules
	Spark中组件Mllib的学习68之PrefixSpan

**9.评估度量**

	Spark中组件Mllib的学习69之对二分类进行评估Binary classification
	Spark中组件Mllib的学习70之对多类分类结果进行评估Multiclass classification
	Spark中组件Mllib的学习71之对多标签分类进行评估
	Spark中组件Mllib的学习72之RankingSystem进行评估
	Spark中组件Mllib的学习73之回归问题的评估

**10.PMML模型输出**

	Spark中组件Mllib的学习74之预言模型标记语言PMML

**11优化**

	Spark中组件Mllib的学习75之L-BFGS	