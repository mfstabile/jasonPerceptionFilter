#!/bin/bash
#export JAVA_HOME='/Library/Java/JavaVirtualMachines/jdk1.7.0_71.jdk/Contents/Home'
#cd jason-svn
ant clean
ant jar
ant plugin
ant apidoc
bash bin/jason.sh
