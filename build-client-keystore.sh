#!/bin/sh

CLIENT_KEYSTORE=src/main/resources/keystore/client-keystore.jks

P12_PASSPHRASE=$1

echo "Provided p12 passphrase: $P12_PASSPHRASE"

echo "Before import ..."
keytool -list -keystore $CLIENT_KEYSTORE -storepass storepassword

echo "Importing ..."

# Build target for processing p12 files before import
mkdir -p target
cp -r p12/*.p12 target

# Import valid test certificate: VOCES_gyldig.p12
# -----------------------------------------------
# Change value (not required by client)
keytool -changealias -keystore target/VOCES_gyldig.p12 -storepass $P12_PASSPHRASE -value "nets danid a/s - tu voces gyldig" -destalias "valid"
keytool -v -importkeystore -srckeystore target/VOCES_gyldig.p12 -srcstoretype PKCS12 -destkeystore $CLIENT_KEYSTORE -deststoretype JKS -deststorepass storepassword -srcstorepass $P12_PASSPHRASE

# Import revoked test certificate: VOCES_spaerret.p12
# --------------------------------------------------
# Change value (required by client)
keytool -changealias -keystore target/VOCES_spaerret.p12 -storepass $P12_PASSPHRASE -value "nets danid a/s - tu voces spærret" -destalias "revoked"
keytool -v -importkeystore -srckeystore target/VOCES_spaerret.p12 -srcstoretype PKCS12 -destkeystore $CLIENT_KEYSTORE -deststoretype JKS -deststorepass storepassword -srcstorepass $P12_PASSPHRASE

# Import expired test certificate: VOCES_udloebet.p12
# --------------------------------------------------
# Change value (required by client)
keytool -changealias -keystore target/VOCES_udloebet.p12 -storepass $P12_PASSPHRASE -value "nets danid a/s - udløbet premexp1d1h" -destalias "expired"
keytool -v -importkeystore -srckeystore target/VOCES_udloebet.p12 -srcstoretype PKCS12 -destkeystore $CLIENT_KEYSTORE -deststoretype JKS -deststorepass storepassword -srcstorepass $P12_PASSPHRASE

echo "After import ..."
keytool -list -keystore $CLIENT_KEYSTORE -storepass storepassword

### Reverse imports
### NOT ACTIVE
# keytool -delete -value valid -keystore src/main/resources/keystore/client-keystore.jks -storepass storepassword
# keytool -delete -value revoked -keystore src/main/resources/keystore/client-keystore.jks -storepass storepassword
# keytool -delete -value expired -keystore src/main/resources/keystore/client-keystore.jks -storepass storepassword

