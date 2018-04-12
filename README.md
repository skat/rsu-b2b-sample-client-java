# RSU B2B Sample Web Service Client written in Java

[![Build Status](https://travis-ci.com/skat/rsu-b2b-sample-client-java.svg?token=pXpLRS1qCgHe3KVdbFyA&branch=master)](https://travis-ci.com/skat/rsu-b2b-sample-client-java)

Sample client for the RSU B2B Web Service Gateway developed in Java and using open source libraries
demonstrating how to submit **VAT returns** via SOAP/Webservices.

> **IMPORTANT NOTICE**: SKAT does not provide any kind of support for the code in this repository.
> This Java-client is just one example of how a B2B web service can be accessed. The client must not be 
> perceived as a piece of production code but more as an example one can take inspiration from and can use
> to quickly get started to test whether your company can implement a successful call to one of the B2B web 
> service using the company's digital signature. SKAT cannot be held responsible if a company uses this client
> or parts of it in their own systems. 

> **VIGTIG MEDDELELSE**: SKAT yder ikke support på kildekoden i nærværende kodebibliotek.
> Denne Java-klient er kun et eksempel på hvordan B2B webservicene kan tilgås. Klienten skal således ikke 
> opfattes som et stykke produktionskode men mere som en eksempel man kan lade sig inspirere af og kan bruge 
> til hurtigt at komme i gang og få afprøvet om ens virksomhed kan gennemføre et succesfuldt kald til en af 
> B2B webservicene ved at bruge virksomhedens digitale signatur. SKAT kan ikke stå til ansvar hvis en virksomhed
> anvender klienten eller dele af denne i deres egne systemer. 

## About the client

The sample clients are implemented based on the [Apache CXF](http://cxf.apache.org/) framework,
the Spring Framework, and Java 8. See `pom.xml` file in this repo for details regarding 
the current versions of the mentioned frameworks in use. 
 
This sample project implements calls to these services:
 
* **VirksomhedKalenderHent**
* **ModtagMomsangivelseForeloebig**
* **MomsangivelseKvitteringHent**

> **Looking for a .NET Sample Client?** SKAT provides a sample client Web Service Client written in .NET v4.6 using WCF for the
> [EMCS System](https://github.com/skat/emcs-b2b-ws-sample-client-dotnet-wcf). The EMCS System is another system
> than the VAT Returns system covered by the sample in this repository. However, the services of EMCS and VAT Returns
> differ by the services descriptions (WSDLs) only. Hence, the referenced repository (also on GitHub) may be used as basis
> for implementing calls to above services. The key changes required are: import WSDL files from this repository
> and change the endpoint in `App.config`.

These services are invoked and tested via a very simple web app that - to some degree looks - like a desktop SoapUI client,
but just in a browser. Using the browser a sample request (provided left hand side) can be sent and the response will
presented in the right hand side:

![gui](/assets/rsu_sample_gui_snapshot.png)

The client has by default a sample request for **VirksomhedKalenderHent** in the **Request** textarea (left hand side),
but not for the other two services.

Sample requests for all 3 service are found here:

* [VirksomhedKalenderHent_I](rsu-b2b-sample-client/src/test/resources/VirksomhedKalenderHent_I_Document.xml)
* [ModtagMomsangivelseForeloebig_I](rsu-b2b-sample-client/src/test/resources/ModtagMomsangivelseForeloebig_I_Document.xml)
* [MomsangivelseKvitteringHent_I](rsu-b2b-sample-client/src/test/resources/MomsangivelseKvitteringHent_I_Document.xml)

Use these as templates and copy content to the **Request** textarea (left hand side).

The user must ensure to:

* Select the **Service** (dropdown) to be tested.
* Select the **Environment** (dropdown) on the which the **Service** runs.
* Select the **Certificate** of the legal entity submitting the request/document.

A check in the **Override 'HovedOplysninger' (Transaction Id and Time)** checkbox results in the transaction id **and** 
transaction time in the provided XML request to be regenerated. This will likely be relevant as the service called will
not allow use of previously submitted transaction id.

Finally, press **Test**.

## The process in brief

The three services should be invoked in the following order:

**(1) VirksomhedKalenderHent**: The services is invoked with an date interval, e.g. from 2018-01-01 to 2018-12-31, and this
interval is used by the VirksomhedKalenderHent service to return the periods for which the legal entity must submit VAT returns. 

**(2) ModtagMomsangivelseForeloebig**: This is the service for submitting the VAT returns. As input (request) the legal
entity must provide the period (date interval, e.g. from 2018-01-01 to 2018-03-31) and the VAT return form values.
If the service call is successful the legal entity must then login on skat.dk and approve the submitted VAT returns. 
The service response provides a deep link to the approval page (requires login).

**IMPORTANT**: The ModtagMomsangivelseForeloebig service submits a draft only.

**(3) ModtagMomsangivelseForeloebig**: Once the legal entity has approved the VAT returns this service provides receipt
(a PDF document) and payment details. The **transaction id** generated for submitting the draft VAT Returns is the
**transaction id** to be used in the request of this service as the value in the field `TransaktionIdentifier` , e.g.:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<urn:MomsangivelseKvitteringHent_I 
        xmlns:urn="urn:oio:skat:nemvirksomhed:ws:1.0.0"
        xmlns:ns="http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/"
        xmlns:urn1="urn:oio:skat:nemvirksomhed:1.0.0"
        xmlns:ns1="http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/">
    <ns:HovedOplysninger>
        <ns:TransaktionIdentifikator>33593B0D-E7CF-40A2-AE76-530B72DE6AE3</ns:TransaktionIdentifikator>
        <ns:TransaktionTid>2017-04-24T12:00:00.146+02:00</ns:TransaktionTid>
    </ns:HovedOplysninger>
    <!-- Enter the transaction id from ModtagMomsangivelseForeloebig here: -->
    <urn1:TransaktionIdentifier>42C8FE92-0AE3-403E-AEFA-F3A0B4508E2E</urn1:TransaktionIdentifier>
    <urn:Angiver>
        <ns1:VirksomhedSENummerIdentifikator>12345678</ns1:VirksomhedSENummerIdentifikator>
    </urn:Angiver>
</urn:MomsangivelseKvitteringHent_I>
```

For all three services the **VAT number** of the legal entity, e.g. submitting the VAT returns, 
must by provided in service request in the field `VirksomhedSENummerIdentifikator`.

Example:

```xml
<ns1:VirksomhedSENummerIdentifikator>12345678</ns1:VirksomhedSENummerIdentifikator>
```

## The implementation

The three services are defined by these WSDL files:

* [VirksomhedKalenderHent.wsdl](rsu-b2b-sample-client/src/main/resources/VirksomhedKalenderHent/VirksomhedKalenderHent.wsdl)
* [ModtagMomsangivelseForeloebig.wsdl](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/ModtagMomsangivelseForeloebig.wsdl)
* [MomsangivelseKvitteringHent.wsdl](rsu-b2b-sample-client/src/main/resources/MomsangivelseKvitteringHent/MomsangivelseKvitteringHent.wsdl)

The WSDLs - and the XDSs imported - are compiled into JAX-WS Webservice Client classes by the CXF Plugin in the [pom.xml](rsu-b2b-sample-client/pom.xml)
and the generated client code is then invoked by these classes:

* [VirksomhedKalenderHentClient.java](rsu-b2b-sample-client/src/main/java/dk/skat/rsu/b2b/sample/VirksomhedKalenderHentClient.java)
* [ModtagMomsangivelseForeloebigClient.java](rsu-b2b-sample-client/src/main/java/dk/skat/rsu/b2b/sample/ModtagMomsangivelseForeloebigClient.java)
* [MomsangivelseKvitteringHentClient.java](rsu-b2b-sample-client/src/main/java/dk/skat/rsu/b2b/sample/MomsangivelseKvitteringHentClient.java)

Each of these classes attach the configuration that fulfills the WS Policy of RSU Web Services.

### Fulfillment of WS Policy of RSU Web Services

The fulfillment of policies required to invoke RSU B2B Web Services is configured in the file:

[rsu-policy.xml](rsu-b2b-sample-client/src/main/resources/rsu-policy.xml)

Fulfillment of WS Policy requirements is achieved using CXF's in and out interceptor framework and 
the `rsu-policy.xml` file details which parts are to be signed and encrypted, and how to present 
certificate for authentication on the server side. This configuration file also demonstrates how
secure transport (https) is enabled client side.

### The web based test client

The web based test client (`rsu-b2b-sample-client-gui`) is kept as simple as possible using a very simple 
MVC framework (Struts) and provides a simple SOAP test framework that invokes the above three webservices.
As the test client allows input of XML documents there is a process to convert the XML to Java objects that
are used as input in the generated Webservice Clients.

## Run clients

The sample clients must be configured with parameters that are necessary for the client to run and
call the test environment of RSU B2B Web Service Gateway. 

The parameters (provided as a file named `app.conf`) can be obtained by contacting SKAT Help Desk.

In the following sections we describe to methods for running the sample:

* **Build and Run** - Clone repo, build repo, and run locally.
* **Run on Tomcat** - Clone repo, build repo, and run on a Tomcat server.

### Prerequisites

For both methods the following tools are required:

* JDK 1.8
* Maven 3.3 (or above)

### Build and Run

Clone this repository. 

Copy the provided `app.conf` to the root of the local repository.

Then execute:

```sh
$ mvn clean install
$ ln -s rsu-b2b-sample-client/src/main/resources/keystore keystore
$ mvn jetty:run -f rsu-b2b-sample-client-gui/pom.xml
```

*Note*: The second command ensures that the `keystore` directory is available in the project root by creating a 
symbolic link to the actual location in `rsu-b2b-sample-client/src/main/resources/keystore`.

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
rsu-b2b-sample-client-gui-tomcat/target/rsu-b2b-sample-client-gui-tomcat-1.0-war-exec.jar
rsu-b2b-sample-client/src/main/resources/keystore/client-keystore.jks
rsu-b2b-sample-client/src/main/resources/keystore/server-keystore.jks
```

Organize the files as follows: 

```
rsu-b2b-sample-client-gui-tomcat/
  rsu-b2b-sample-client-gui-tomcat-1.0.war
  rsu-b2b-sample-client-gui-tomcat-1.0-war-exec.jar
  keystore/
    client-keystore.jks
    server-keystore.jks
  app.conf
```

Then inside `rsu-b2b-sample-client-gui-tomcat` run:

```sh
$ java -jar rsu-b2b-sample-client-gui-tomcat-1.0-war-exec.jar
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

### Add another OCES certificate

First complete the steps in section: **Installing other OCESII Certificates in the client keystore** (below)
The chosen **alias**, e.g. `myalias` from the import must be added to  `app.conf` as follows:

```
activeCertificates = [ "valid", ... , "myalias" ]
```

Then add the passphrase:

```
certificatePassphrases {
    valid = "secret"
    ...
    myalias = "verysecret"
}
```

Finally add the name:

```
certificateCommenNames {
    valid = "CVR:30808460-UID:25351738 - NETS DANID A/S - TU VOCES gyldig"
    ...
    myalias = "MyAlias Identity - This will be shown on the screen"
}
```

### Installing other OCESII Certificates in the client keystore

The keystore `rsu-b2b-sample-client/src/main/resources/keystore/client-keystore.jks` is already prepared with the
necessary test certificate that is authorized to access the test environment. However, in the
event that another test certificate has been issued this may be installed as follows:

```
$ export P12_PASSPHRASE=CHANGE_ME
$ export P12_CURRENT_ALIAS=CHANGE_ME
$ cd rsu-b2b-sample-client
$ keytool -delete -value valid -keystore src/main/resources/keystore/client-keystore.jks -storepass storepassword
$ keytool -changealias -keystore target/VOCES_yours.p12 -storepass $P12_PASSPHRASE -value $P12_CURRENT_ALIAS -destalias "newalias"
$ keytool -v -importkeystore -srckeystore target/VOCES_yours.p12 -srcstoretype PKCS12 -destkeystore src/main/resources/keystore/client-keystore.jks -deststoretype JKS -deststorepass storepassword -srcstorepass $P12_PASSPHRASE
```

Where `P12_PASSPHRASE` and `P12_CURRENT_ALIAS` are passphrase and value of the OCESII certificate,
respectively. The three keytool command removes the pre configured certificate, changes the the value
of the new certificate, and finally imports it into the keystore.

## References

* [Apache CXF](http://cxf.apache.org/)
* [Apache CXF Samples](https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples)
