#!/bin/sh

CLIENT_TUSTSTORE=src/main/resources/keystore/client-truststore.jks

echo "Before import ..."
keytool -list -keystore $CLIENT_TUSTSTORE -storepass storepassword

echo "Importing ..."

keytool -noprompt -import -value skatserver -file pem/b2b-test-system.pem -keystore $CLIENT_TUSTSTORE -storepass storepassword

# Import SSL cert for secure transport (https://..)
# The full cert. chain is viewable with openssl command: openssl s_client -connect host:port -showcerts
#
keytool -noprompt -import -value ssl_chain_0 -file pem/ssl-chain-0.pem -keystore $CLIENT_TUSTSTORE -storepass storepassword
# Level 0 is sufficient for completeness we import the full chain (level 1,2,3..)
keytool -noprompt -import -value ssl_chain_1 -file pem/ssl-chain-1.pem -keystore $CLIENT_TUSTSTORE -storepass storepassword
keytool -noprompt -import -value ssl_chain_2 -file pem/ssl-chain-2.pem -keystore $CLIENT_TUSTSTORE -storepass storepassword

echo "After import ..."
keytool -list -keystore $CLIENT_TUSTSTORE -storepass storepassword

### Reverse imports
### NOT ACTIVE
# keytool -delete -value skatserver -keystore src/main/resources/keystore/client-truststore.jks -storepass storepassword
# keytool -delete -value ssl_chain_0 -keystore src/main/resources/keystore/client-truststore.jks -storepass storepassword
# keytool -delete -value ssl_chain_1 -keystore src/main/resources/keystore/client-truststore.jks -storepass storepassword
# keytool -delete -value ssl_chain_2 -keystore src/main/resources/keystore/client-truststore.jks -storepass storepassword
