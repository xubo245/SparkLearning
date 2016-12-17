
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio（tachyon） 0.7.1，spark-1.5.2,hadoop-2.6.0

# 1.问题描述 #

## 1.1 第一次##

八个节点七个节点dead，worker都lost了，不知道为什么

没找到其他日志

【3】中也有类似的问题，猜测可能是history增加的原因


	hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ ./DSWSparkSWquery.sh  &> DSWSparkSWquerytime201612121233.txt 
记录

	hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ tail -f DSWSparkSWquerytime201612121233.txt 
	SparkSW:
	time:
	[Stage 1:====================>                                  (48 + 16) / 128]16/12/12 14:35:46 ERROR TaskSchedulerImpl: Lost executor 5 on Mcnode7: worker lost
	[Stage 1:=====================>                                  (48 + 8) / 128]16/12/12 14:37:10 ERROR TaskSchedulerImpl: Lost executor 7 on Mcnode1: worker lost
	16/12/12 14:37:10 ERROR TaskSchedulerImpl: Lost executor 6 on Mcnode5: worker lost
	16/12/12 14:37:10 ERROR TaskSchedulerImpl: Lost executor 4 on Mcnode4: worker lost
	16/12/12 14:37:10 ERROR TaskSchedulerImpl: Lost executor 2 on Mcnode3: worker lost
	16/12/12 14:37:10 ERROR TaskSchedulerImpl: Lost executor 1 on Mcnode6: worker lost
	16/12/12 14:37:10 ERROR TaskSchedulerImpl: Lost executor 0 on Mcnode2: worker lost
	[Stage 1:====================>                                 (48 + -40) / 128]Exception in thread "main" org.apache.spark.SparkException: Job cancelled because SparkContext was shut down
## 1.2 第二次##

	hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ tail -f DSWSparkSWquerytime201612121433.txt 
	SparkSW:
	time:
	[Stage 1:>                                                       (0 + 16) / 128]16/12/12 15:06:25 ERROR TaskSchedulerImpl: Lost executor 1 on Mcnode7: worker lost
	[Stage 1:>                                                       (0 + 14) / 128]16/12/12 15:06:58 ERROR TaskSchedulerImpl: Lost executor 7 on Mcnode6: worker lost
	16/12/12 15:06:58 ERROR TaskSchedulerImpl: Lost executor 6 on Mcnode1: worker lost
	16/12/12 15:06:58 ERROR TaskSchedulerImpl: Lost executor 5 on Mcnode3: worker lost
	16/12/12 15:06:58 ERROR TaskSchedulerImpl: Lost executor 4 on Mcnode2: worker lost
	16/12/12 15:06:58 ERROR TaskSchedulerImpl: Lost executor 3 on Mcnode4: worker lost
	16/12/12 15:06:58 ERROR TaskSchedulerImpl: Lost executor 2 on Mcnode5: worker lost
	[Stage 1:>                                                        (0 + 2) / 128]

![](http://i.imgur.com/j1i2FxX.png)

# 2.解决办法： #

## 2.1 进度
待解决

## 2.2 尝试1
按照【3】尝试：

	hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ tail -f DSWSparkSWquerytime201612121533.txt 
	SparkSW:
	time:
	/home/hadoop/cloud/spark-1.5.2/conf/spark-env.sh: line 50: spark.worker.ui.retainedExecutors: command not found
	/home/hadoop/cloud/spark-1.5.2/conf/spark-env.sh: line 51: spark.worker.ui.retainedDrivers: command not found
	[Stage 1:======>                                                (16 + 16) / 128]

## 2.3 尝试2
然后自己把spark下面的work的上个月的app移到disk2备份，其他节点也是。


## 2.4 学习

源代码阅读： 只有一处有 "worker lost"

    for (exec <- worker.executors.values) {
      logInfo("Telling app of lost executor: " + exec.id)
      exec.application.driver.send(ExecutorUpdated(
        exec.id, ExecutorState.LOST, Some("worker lost"), None))
      exec.application.removeExecutor(exec)
    }


# 3.运行记录： #

待解决

参考

	【1】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【2】https://github.com/xubo245/SparkLearning
	【3】http://blog.csdn.net/lsshlsw/article/details/49155087
