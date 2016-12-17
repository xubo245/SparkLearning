
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio（tachyon） 0.7.1，spark-1.5.2,hadoop-2.6.0

# 1.问题描述 #
# 1.1 
运行alluxioHDFS.sh的时候出现错误：

	hadoop@Master:~/disk2/xubo/project/alignment/SparkSW/SparkSW20161114/alluxio-1.3.0$ ./alluxioHDFS.sh &> alluxioHDFStime201611232044.txt

错误概要：

	SparkException：Error notifying standalone scheduler's driver endpoint

#1.2 问题查看
按照时间点查，没有看到什么具体的问题：

	http://Master:18080/history/app-20161123210139-3796/stages/stage/?id=1&attempt=0

	http://Master:18080/history/app-20161123210214-3797/stages/stage/?id=0&attempt=0
# 2.解决办法： #

待解决



# 3.运行记录： #

	time:6
	(67,UniRef100_P18691)                                                           
	(58,UniRef100_P51640)
	(55,UniRef100_Q05025)
	(55,UniRef100_E9DFH0)
	(54,UniRef100_P04406)
	16/11/23 21:02:08 WARN QueuedThreadPool: 1 threads could not be stopped
	16/11/23 21:02:14 ERROR AkkaRpcEnv: Ignore error: Error notifying standalone scheduler's driver endpoint
	org.apache.spark.SparkException: Error notifying standalone scheduler's driver endpoint
		at org.apache.spark.scheduler.cluster.CoarseGrainedSchedulerBackend.removeExecutor(CoarseGrainedSchedulerBackend.scala:312)
		at org.apache.spark.scheduler.cluster.SparkDeploySchedulerBackend.executorRemoved(SparkDeploySchedulerBackend.scala:142)
		at org.apache.spark.deploy.client.AppClient$ClientEndpoint$$anonfun$receive$1.applyOrElse(AppClient.scala:184)
		at org.apache.spark.rpc.akka.AkkaRpcEnv.org$apache$spark$rpc$akka$AkkaRpcEnv$$processMessage(AkkaRpcEnv.scala:177)
		at org.apache.spark.rpc.akka.AkkaRpcEnv$$anonfun$actorRef$lzycompute$1$1$$anon$1$$anonfun$receiveWithLogging$1$$anonfun$applyOrElse$4.apply$mcV$sp(AkkaRpcEnv.scala:126)
		at org.apache.spark.rpc.akka.AkkaRpcEnv.org$apache$spark$rpc$akka$AkkaRpcEnv$$safelyCall(AkkaRpcEnv.scala:197)
		at org.apache.spark.rpc.akka.AkkaRpcEnv$$anonfun$actorRef$lzycompute$1$1$$anon$1$$anonfun$receiveWithLogging$1.applyOrElse(AkkaRpcEnv.scala:125)
		at scala.runtime.AbstractPartialFunction$mcVL$sp.apply$mcVL$sp(AbstractPartialFunction.scala:33)
		at scala.runtime.AbstractPartialFunction$mcVL$sp.apply(AbstractPartialFunction.scala:33)
		at scala.runtime.AbstractPartialFunction$mcVL$sp.apply(AbstractPartialFunction.scala:25)
		at org.apache.spark.util.ActorLogReceive$$anon$1.apply(ActorLogReceive.scala:59)
		at org.apache.spark.util.ActorLogReceive$$anon$1.apply(ActorLogReceive.scala:42)
		at scala.PartialFunction$class.applyOrElse(PartialFunction.scala:118)
		at org.apache.spark.util.ActorLogReceive$$anon$1.applyOrElse(ActorLogReceive.scala:42)
		at akka.actor.Actor$class.aroundReceive(Actor.scala:467)
		at org.apache.spark.rpc.akka.AkkaRpcEnv$$anonfun$actorRef$lzycompute$1$1$$anon$1.aroundReceive(AkkaRpcEnv.scala:92)
		at akka.actor.ActorCell.receiveMessage(ActorCell.scala:516)
		at akka.actor.ActorCell.invoke(ActorCell.scala:487)
		at akka.dispatch.Mailbox.processMailbox(Mailbox.scala:238)
		at akka.dispatch.Mailbox.run(Mailbox.scala:220)
		at akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinTask.exec(AbstractDispatcher.scala:397)
		at scala.concurrent.forkjoin.ForkJoinTask.doExec(ForkJoinTask.java:260)
		at scala.concurrent.forkjoin.ForkJoinPool$WorkQueue.runTask(ForkJoinPool.java:1339)
		at scala.concurrent.forkjoin.ForkJoinPool.runWorker(ForkJoinPool.java:1979)
		at scala.concurrent.forkjoin.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:107)
	Caused by: org.apache.spark.SparkException: Error sending message [message = RemoveExecutor(4,Unknown executor exit code (0))]
		at org.apache.spark.rpc.RpcEndpointRef.askWithRetry(RpcEndpointRef.scala:118)
		at org.apache.spark.rpc.RpcEndpointRef.askWithRetry(RpcEndpointRef.scala:77)
		at org.apache.spark.scheduler.cluster.CoarseGrainedSchedulerBackend.removeExecutor(CoarseGrainedSchedulerBackend.scala:309)
		... 24 more
	Caused by: org.apache.spark.rpc.RpcTimeoutException: Recipient[Actor[akka://sparkDriver/user/CoarseGrainedScheduler#-679832735]] had already been terminated.. This timeout is controlled by spark.rpc.askTimeout
		at org.apache.spark.rpc.RpcTimeout.org$apache$spark$rpc$RpcTimeout$$createRpcTimeoutException(RpcEnv.scala:214)
		at org.apache.spark.rpc.RpcTimeout$$anonfun$addMessageIfTimeout$1.applyOrElse(RpcEnv.scala:229)
		at org.apache.spark.rpc.RpcTimeout$$anonfun$addMessageIfTimeout$1.applyOrElse(RpcEnv.scala:225)
		at scala.runtime.AbstractPartialFunction.apply(AbstractPartialFunction.scala:33)
		at scala.util.Failure$$anonfun$recover$1.apply(Try.scala:185)
		at scala.util.Try$.apply(Try.scala:161)
		at scala.util.Failure.recover(Try.scala:185)
		at scala.concurrent.Future$$anonfun$recover$1.apply(Future.scala:324)
		at scala.concurrent.Future$$anonfun$recover$1.apply(Future.scala:324)
		at scala.concurrent.impl.CallbackRunnable.run(Promise.scala:32)
		at org.spark-project.guava.util.concurrent.MoreExecutors$SameThreadExecutorService.execute(MoreExecutors.java:293)
		at scala.concurrent.impl.ExecutionContextImpl$$anon$1.execute(ExecutionContextImpl.scala:133)
		at scala.concurrent.impl.CallbackRunnable.executeWithValue(Promise.scala:40)
		at scala.concurrent.impl.Promise$DefaultPromise.scala$concurrent$impl$Promise$DefaultPromise$$dispatchOrAddCallback(Promise.scala:280)
		at scala.concurrent.impl.Promise$DefaultPromise.onComplete(Promise.scala:270)
		at scala.concurrent.Future$class.recover(Future.scala:324)
		at scala.concurrent.impl.Promise$DefaultPromise.recover(Promise.scala:153)
		at org.apache.spark.rpc.akka.AkkaRpcEndpointRef.ask(AkkaRpcEnv.scala:319)
		at org.apache.spark.rpc.RpcEndpointRef.askWithRetry(RpcEndpointRef.scala:100)
		... 26 more
	Caused by: akka.pattern.AskTimeoutException: Recipient[Actor[akka://sparkDriver/user/CoarseGrainedScheduler#-679832735]] had already been terminated.
		at akka.pattern.AskableActorRef$.ask$extension(AskSupport.scala:132)
		at org.apache.spark.rpc.akka.AkkaRpcEndpointRef.ask(AkkaRpcEnv.scala:307)
		... 27 more
	time:7
	(67,UniRef100_P18691)                                                           
	(58,UniRef100_P51640)
	(55,UniRef100_Q05025)
	(55,UniRef100_E9DFH0)
	(54,UniRef100_P04406)


参考

	【1】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【2】https://github.com/xubo245/SparkLearning
