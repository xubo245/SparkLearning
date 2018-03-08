	./dev/make-distribution.sh --name custom-spark --pip --r --tgz -Psparkr -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes
	
	
	yum install git
	
	yum install java


export JAVA_OPTS='-Dfile.encoding=UTF-8 -Djava.awt.headless=true -Xmx3500m -Xms3500m -XX:MaxNewSize=1280m -XX:MaxPermSize=1280m'
