JASON_JAR=$JASON_HOME/lib/jason.jar

OWL2MAS_JAR=$OWL2MAS_HOME/lib/owl2mas.jar

if [ ! -f $JASON_JAR ] ; then
	echo "JASON_HOME is not properly set! (currently $JASON_HOME)"
	exit 0
fi

if [ ! -f $OWL2MAS_JAR ] ; then
	echo "OWL2MAS_HOME is not properly set! (currently $OWL2MAS_HOME)"
	exit 0
fi

CP=$OWL2MAS_HOME/lib/commons-logging-1.1.jar:$OWL2MAS_HOME/lib/owlapi-bin.jar:$OWL2MAS_HOME/lib/pellet.jar:$OWL2MAS_HOME/lib/relaxngDatatype.jar:$OWL2MAS_HOME/lib/xsdlib.jar:$OWL2MAS_JAR:$JASON_JAR:$CLASSPATH;

echo "Using classpath $CP"

java -cp $CP owl2mas.OWL2MAS $1 $2 $3 $4 $5;


