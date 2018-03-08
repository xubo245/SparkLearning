##Fix OOM problem when compile spark in linux

	export MAVEN_OPTS="-Xmx2g -XX:MaxPermSize=3812M -XX:ReservedCodeCacheSize=2048m"


##command:

 	mvn -DskipTests package -e

##make-distribetion:

	./dev/make-distribution.sh --name custom-spark --pip --r --tgz -Phadoop-2.7 -Phive -Phive-thriftserver -Pmesos -Pyarn -Pkubernetes 