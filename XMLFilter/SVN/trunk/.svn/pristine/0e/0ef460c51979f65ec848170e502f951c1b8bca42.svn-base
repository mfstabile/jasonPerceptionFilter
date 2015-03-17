OWL2MAS_JAR=$OWL2MAS_HOME/lib/owl2mas.jar

if [ ! -f $OWL2MAS_JAR ] ; then
	echo "OWL2MAS_HOME is not properly set! (currently $OWL2MAS_HOME)"
	exit 0
fi

export CLASSPATH=$CLASSPATH:$PWD/../../lib/jasdl.jar:$PWD/../../../jmca/lib/jmca.jar

bash $OWL2MAS_HOME/owl2mas.sh . soc ./onts/society.owl false $1


