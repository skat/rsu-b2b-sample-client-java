#!/bin/sh

rm -f rsu-b2b-sample-client-gui-tomcat-dist.zip
rm -rf target
PACKAGE_DIR=target/rsu-b2b-sample-client-gui-tomcat
mkdir -p $PACKAGE_DIR


cp -r rsu-b2b-sample-client/src/main/resources/keystore $PACKAGE_DIR/
cp rsu-b2b-sample-client-gui-tomcat/target/rsu-b2b-sample-client-gui-tomcat-*.war $PACKAGE_DIR/
cp rsu-b2b-sample-client-gui-tomcat/target/rsu-b2b-sample-client-gui-tomcat-*-war-exec.jar $PACKAGE_DIR/
cp rsu-b2b-sample-client-gui/src/main/resources/reference.conf $PACKAGE_DIR/app.conf
cp start-tomcat.sh $PACKAGE_DIR/

cd target
zip -r rsu-b2b-sample-client-gui-tomcat-dist.zip rsu-b2b-sample-client-gui-tomcat
cd ../
unzip -t target/rsu-b2b-sample-client-gui-tomcat-dist.zip
