#!/bin/sh

sudo apt -y install openjdk-8-jre-headless
sudo apt -y install openjdk-8-jdk
java -version

sudo apt -y install maven
mvn -version

git clone https://github.com/skat/rsu-b2b-sample-client-java

cd rsu-b2b-sample-client-java
mvn clean install

nohup java -jar rsu-b2b-sample-client-gui-tomcat/target/rsu-b2b-sample-client-gui-tomcat-1.1-war-exec.jar > nohup.out &
# nohup.out is usually stored as /var/lib/waagent/custom-script/download/0/nohup.out

echo "Sample client started..."

