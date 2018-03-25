# RSU B2B Sample Web Service Client written in Java

Sample clients for the RSU B2B Web Service Gateway developed in Java and using open source libraries.

**IMPORTANT NOTICE**: SKAT does not provide any kind of support for the code in this repository.
This Java-client is just one example of how a B2B web service can be accessed. The client must not be 
perceived as a piece of production code but more as an example one can take inspiration from and can use
to quickly get started to test whether your company can implement a successful call to one of the B2B web 
service using the company's digital signature. SKAT can not be held responsible if a company uses this client
or parts of it in their own systems. 

**VIGTIG MEDDELELSE**: SKAT yder ikke support på kildekoden i nærværende kodebibliotek.
Denne Java-klient er kun et eksempel på hvordan B2B webservicene kan tilgås. Klienten skal således ikke 
opfattes som et stykke produktionskode men mere som en eksempel man kan lade sig inspirere af og kan bruge 
til hurtigt at komme i gang og få afprøvet om ens virksomhed kan gennemføre et succesfuldt kald til en af 
B2B webservicene ved at bruge virksomhedens digitale signatur. SKAT kan ikke stå til ansvar hvis en virksomhed
anvender klienten eller dele af denne i deres egne systemer. 

## About the client

The sample clients are implemented based on the [Apache CXF](http://cxf.apache.org/) framework,
the Spring Framework, and Java 8. See `pom.xml` file in this repo for details regarding 
the current versions of the mentioned frameworks in use.
 
This sample project implements calls to these services:
 
* **VirksomhedKalenderHent**
* **ModtagMomsangivelseForeloebig**
* **MomsangivelseKvitteringHent**

These services are invoked and tested via a very simple web app that - to some degree looks - like a local SoapUI client,
but just in a browser. Using the browser a sample request (provided left hand side) can be sent and the response will
presented in the right hand side:

![gui](/assets/rsu_sample_gui_snapshot.png)

The main entry point into the source code of the implementation is these classes:

* [VirksomhedKalenderHentClient.java](rsu-b2b-sample-client/src/main/java/dk/skat/rsu/b2b/sample/VirksomhedKalenderHentClient.java)
* [ModtagMomsangivelseForeloebigClient.java](rsu-b2b-sample-client/src/main/java/dk/skat/rsu/b2b/sample/ModtagMomsangivelseForeloebigClient.java)
* [MomsangivelseKvitteringHentClient.java](rsu-b2b-sample-client/src/main/java/dk/skat/rsu/b2b/sample/MomsangivelseKvitteringHentClient.java)

## Fulfillment of WS Policy of RSU Web Services

The fulfillment of policies required to invoke RSU B2B Web Services is configured in the file:

[rsu-policy.xml](rsu-b2b-sample-client/src/main/resources/rsu-policy.xml)

Fulfillment of WS Policy requirements is achieved using CXF's in and out interceptor framework and 
the `rsu-policy.xml` file details which parts are to be signed and encrypted, and how to present 
certificate for authentication on the server side. This configuration file also demonstrates how
secure transport (https) is enabled client side.
 
## Run clients

The sample clients must be configured with parameters that are necessary for the client to run and
call the test environment of RSU B2B Web Service Gateway. The parameters ( `app.conf`) can be obtained by contacting 
SKAT Help Desk.

In the following sections we describe to methods for running the sample:

* **Build and Run** - Clone repo, build repo, and run locally.
* **Run on Tomcat** - Clone repo, build repo, and run on a Tomcat server.

### Build and Run

Clone this repository. Copy the provided `app.conf` to the root of the local repository.
Then execute:

```sh
$ mvn clean install
$ ln -s rsu-b2b-sample-client/src/main/resources/keystore keystore
$ mvn jetty:run -f rsu-b2b-sample-client-gui/pom.xml
```

Once Jetty is running open URL:

```
http://localhost:8080/rsu-b2b-sample-client-gui
```

### Run on Tomcat

Clone this repository. Then execute:

```sh
$ mvn clean install
```

On your server create a directory named `rsu-b2b-sample-client-gui-tomcat`.

Copy these these files to the directory `rsu-b2b-sample-client-gui-tomcat`:

```
rsu-b2b-sample-client-gui-tomcat/target/rsu-b2b-sample-client-gui-tomcat-1.0.war
rsu-b2b-sample-client-gui-tomcat/target/rsu-b2b-sample-client-gui-tomcat-1.0-exec-war.jar
rsu-b2b-sample-client/src/main/resources/keystore/client-keystore.jks
rsu-b2b-sample-client/src/main/resources/keystore/server-keystore.jks
```

Organize the files as follows: 

```
rsu-b2b-sample-client-gui-tomcat/
  rsu-b2b-sample-client-gui-tomcat-1.0.war
  rsu-b2b-sample-client-gui-tomcat-1.0-exec-war.jar
  keystore/
    client-keystore.jks
    server-keystore.jks
  app.conf
```

Then inside `rsu-b2b-sample-client-gui-tomcat` run:

```sh
$ java -jar rsu-b2b-sample-client-gui-tomcat-1.0-exec-war.jar
```

Once Tomcat is running open URL:

```
http://localhost:8080/rsu-b2b-sample-client-gui-tomcat
```

If you want to have the test client call the built-in Log Servlet modify `app.conf` and 
replace the `endpoints` section with this section:

```
endpoints {
    TFE {
        VirksomhedKalenderHent = "http://localhost:8080/rsu-b2b-sample-client-gui-tomcat/log"
        ModtagMomsangivelseForeloebig = "http://localhost:8080/rsu-b2b-sample-client-gui-tomcat/log"
        MomsangivelseKvitteringHent = "http://localhost:8080/rsu-b2b-sample-client-gui-tomcat/log"
    }
}
```

This is due the Tomcat installation is using context path: `rsu-b2b-sample-client-gui-tomcat`

### Installing other OCESII Certificates in the client keystore

The keystore `rsu-b2b-sample-client/src/main/resources/keystore/client-keystore.jks` is already prepared with the
necessary test certificate that is authorized to access the test environment. However, in the
event that another test certificate has been issued this may be installed as follows:

```
$ export P12_PASSPHRASE=CHANGE_ME
$ export P12_CURRENT_ALIAS=CHANGE_ME
$ cd rsu-b2b-sample-client
$ keytool -delete -value valid -keystore src/main/resources/keystore/client-keystore.jks -storepass storepassword
$ keytool -changealias -keystore target/VOCES_yours.p12 -storepass $P12_PASSPHRASE -value $P12_CURRENT_ALIAS -destalias "valid"
$ keytool -v -importkeystore -srckeystore target/VOCES_yours.p12 -srcstoretype PKCS12 -destkeystore src/main/resources/keystore/client-keystore.jks -deststoretype JKS -deststorepass storepassword -srcstorepass $P12_PASSPHRASE
```

Where `P12_PASSPHRASE` and `P12_CURRENT_ALIAS` are passphrase and value of the OCESII certificate,
respectively. The three keytool command removes the pre configured certificate, changes the the value
of the new certificate, and finally imports it into the keystore.

## References

* [Apache CXF](http://cxf.apache.org/)
* [Apache CXF Samples](https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples)
