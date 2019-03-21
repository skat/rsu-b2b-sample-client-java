#!/bin/sh

echo "Starting Tomcat. Once it's running open:"
echo "---"
echo "http://localhost:8080/rsu-b2b-sample-client-gui-tomcat"
echo "---"

java -jar rsu-b2b-sample-client-gui-tomcat-1.1-war-exec.jar
