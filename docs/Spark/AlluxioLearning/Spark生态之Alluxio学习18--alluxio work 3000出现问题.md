
更多代码请见：https://github.com/xubo245/SparkLearning

Spark生态之Alluxio学习 版本：alluxio-1.3.0（tachyon），spark-1.5.2,hadoop-2.6.0

# 1.解释 #

待解决

## 1.1 问题##
访问http://mcnode6:30000/home时出现的

	Problem accessing /home. Reason:
	
	    Server Error
	Caused by:
	
	org.apache.jasper.JasperException: PWC6345: There is an error in invoking javac.  A full JDK (not just JRE) is required
		at org.apache.jasper.compiler.DefaultErrorHandler.jspError(DefaultErrorHandler.java:92)
		at org.apache.jasper.compiler.ErrorDispatcher.dispatch(ErrorDispatcher.java:378)
		at org.apache.jasper.compiler.ErrorDispatcher.jspError(ErrorDispatcher.java:119)
		at org.apache.jasper.compiler.Jsr199JavaCompiler.compile(Jsr199JavaCompiler.java:208)
		at org.apache.jasper.compiler.Compiler.generateClass(Compiler.java:384)
		at org.apache.jasper.compiler.Compiler.compile(Compiler.java:453)
		at org.apache.jasper.JspCompilationContext.compile(JspCompilationContext.java:625)
		at org.apache.jasper.servlet.JspServletWrapper.service(JspServletWrapper.java:375)
		at org.apache.jasper.servlet.JspServlet.serviceJspFile(JspServlet.java:473)
		at org.apache.jasper.servlet.JspServlet.service(JspServlet.java:377)
		at org.eclipse.jetty.jsp.JettyJspServlet.service(JettyJspServlet.java:103)
		at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
		at org.eclipse.jetty.servlet.ServletHolder.handle(ServletHolder.java:812)
		at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:587)
		at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:143)
		at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:595)
		at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:223)
		at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1127)
		at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:515)
		at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:185)
		at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1061)
		at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
		at org.eclipse.jetty.server.Dispatcher.forward(Dispatcher.java:191)
		at org.eclipse.jetty.server.Dispatcher.forward(Dispatcher.java:72)
		at alluxio.web.WebInterfaceWorkerGeneralServlet.doGet(WebInterfaceWorkerGeneralServlet.java:200)
		at javax.servlet.http.HttpServlet.service(HttpServlet.java:687)
		at javax.servlet.http.HttpServlet.service(HttpServlet.java:790)
		at org.eclipse.jetty.servlet.ServletHolder.handle(ServletHolder.java:812)
		at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:587)
		at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:143)
		at org.eclipse.jetty.security.SecurityHandler.handle(SecurityHandler.java:577)
		at org.eclipse.jetty.server.session.SessionHandler.doHandle(SessionHandler.java:223)
		at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1127)
		at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:515)
		at org.eclipse.jetty.server.session.SessionHandler.doScope(SessionHandler.java:185)
		at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1061)
		at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
		at org.eclipse.jetty.server.handler.HandlerList.handle(HandlerList.java:52)
		at org.eclipse.jetty.server.handler.HandlerList.handle(HandlerList.java:52)
		at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:97)
		at org.eclipse.jetty.server.Server.handle(Server.java:499)
		at org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:311)
		at org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:257)
		at org.eclipse.jetty.io.AbstractConnection$2.run(AbstractConnection.java:544)
		at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:635)
		at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:555)
		at java.lang.Thread.run(Thread.java:745)
	Powered by Jetty://


参考

	【1】https://github.com/Alluxio/alluxio
	【2】http://www.alluxio.org/
	【3】http://spark.apache.org/docs/1.5.2/programming-guide.html
	【4】https://github.com/xubo245/SparkLearning
