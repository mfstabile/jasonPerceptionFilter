#!/bin/bash
ant clean
ant jar
ant plugin
ant apidoc
bash bin/jason.sh
