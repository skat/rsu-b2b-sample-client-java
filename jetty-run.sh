#!/bin/sh

# remove symbolic link
# rm -f keystore
# create symbolic link
# ln -s rsu-b2b-sample-client/src/main/resources/keystore keystore

mvn jetty:run -f rsu-b2b-sample-client-gui/pom.xml