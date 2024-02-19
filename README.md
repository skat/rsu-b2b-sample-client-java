# RSU B2B Sample Web Service Client written in Java

[![Build Status](https://travis-ci.com/skat/rsu-b2b-sample-client-java.svg?token=pXpLRS1qCgHe3KVdbFyA&branch=master)](https://travis-ci.com/skat/rsu-b2b-sample-client-java)

> **IMPORTANT / NEW FEATURE**: **ModtagMomsangivelseForeloebig** is as of 2024 now capable of not only accepting the draft of the VAT returns for the current VAT period, but is also able to
> accept post declarations of previous VAT returns going three years back (as of current date). The service will return a notification code in the response telling if the submitted
> draft was handled as the initial VAT returns draft or if it was handled as a post declaration draft adjusting a previously approved VAT returns. See the section [Notification codes related to transactions](#notification-codes-related-to-transactions) for futher details on these notification codes.


This GitHub contains documentation and a sample client for the RSU B2B Web Service Gateway, that provides APIs (SOAP Web Services) to submit **VAT returns**. The [sample client](#about-the-client) is developed in Java and using open source libraries demonstrating how the APIs works.

> **IMPORTANT NOTICE**: Skatteforvaltningen does not provide any kind of support for the code in this repository.
> This Java-client is just one example of how a B2B web service can be accessed. The client must not be 
> perceived as a piece of production code but more as an example one can take inspiration from and can use
> to quickly get started to test whether your company can implement a successful call to one of the B2B web 
> service using the company's digital signature. Skatteforvaltningen cannot be held responsible if a company uses this client
> or parts of it in their own systems. 

> **VIGTIG MEDDELELSE**: Skatteforvaltningen yder ikke support på kildekoden i nærværende kodebibliotek.
> Denne Java-klient er kun et eksempel på hvordan B2B webservicene kan tilgås. Klienten skal således ikke 
> opfattes som et stykke produktionskode men mere som en eksempel man kan lade sig inspirere af og kan bruge 
> til hurtigt at komme i gang og få afprøvet om ens virksomhed kan gennemføre et succesfuldt kald til en af 
> B2B webservicene ved at bruge virksomhedens digitale signatur. Skatteforvaltningen kan ikke stå til ansvar hvis en virksomhed
> anvender klienten eller dele af denne i deres egne systemer. 

## Table of contents

   * [About RSU B2B Web Service Gateway](#about-rsu-b2b-web-service-gateway)
      * [Get access to the APIs](#get-access-to-the-APIs)
      * [Onboard Legal Entities](#onboard-legal-entities)
   * [About the web services](#about-the-web-services)
      * [Security](#security)
      * [Legal Entity Identification](#legal-entity-identification)
      * [Transaction Ids](#transaction-ids)
      * [The services](#the-services)
      * [VirksomhedKalenderHent](#virksomhedkalenderhent)
      * [ModtagMomsangivelseForeloebig](#modtagmomsangivelseforeloebig)
      * [MomsangivelseKvitteringHent](#momsangivelsekvitteringhent)
   * [Test cases and error codes](#test-cases-and-error-codes)
      * [Test cases](#test-cases)
      * [Errors](#errors)
   * [About the client](#about-the-client)
   * [The sample client implementation](#the-sample-client-implementation)
      * [Fulfillment of WS Policy of RSU Web Services](#fulfillment-of-ws-policy-of-rsu-web-services)
      * [The web based test client](#the-web-based-test-client)
   * [Run clients](#run-clients)
      * [Prerequisites](#prerequisites)
      * [Build and Run](#build-and-run)
      * [Run on Tomcat](#run-on-tomcat)
      * [Change endpoints](#change-endpoints)
      * [Add new environment and endpoints](#add-new-environment-and-endpoints)
      * [Add another OCES3 certificate](#add-another-oces3-certificate)
      * [Installing other OCES3 Certificates in the client key store](#installing-other-oces3-certificates-in-the-client-key-store)
      * [Changing certificate in the client trust store](#changing-certificate-in-the-client-trust-store)
      * [References](#references)

## About RSU B2B Web Service Gateway

The RSU B2B Web Service Gateway (also called NemVirksomhed APIs) contains 3 SOAP Web Services. The services provides functionality, that enable a legal entity (a company with a danish SE number) to do VAT Returns from a RSU (Regnskabssystemsudbyder / Accounting system provider). 

The 3 Web Services are:

* **VirksomhedKalenderHent**
* **ModtagMomsangivelseForeloebig**
* **MomsangivelseKvitteringHent**

The following diagram shows how the Web Services works.

![apiflow](/assets/rsu_b2b_web_service_gateway.png)

The first web service to use is **VirksomhedKalenderHent**. This Web Service returns dates for which the legal entity has to submit VAT Returns by. These dates are required, when submitting VAT Returns.

The second web service is **ModtagMomsangivelseForeloebig**. This Web Services submits a draft of the VAT Returns to skat.dk with all the fields you need to fill in. The Web Service returns a deep link to skat.dk, where the legal entity can access the submitted VAT Returns and approve it. 

The last web service is **MomsangivelseKvitteringHent**. This Web Service provide a receipt for the VAT Returns given that the legal entity has approved it. This service also includes payment information on how to pay any outstanding balance.

### Get access to the APIs

To get access to the API, you need to contact Skattestyrelsen at [momsapi@sktst.dk](mailto:momsapi@sktst.dk?subject=Adgang%20til%20NemVirksomhed%20APIs&body=) and provide your CVR number.

You can also see more here: [skat.dk/momsapi](https://skat.dk/skat.aspx?oid=2291926) (Danish)

From Skattestyrelsen you will get access the test environment (endpoints and certificates) and you will also get a short guide on what you need to do to get access to the production environment.

### Onboard Legal Entities

Before a legal entity can use an RSU for submitting VAT Returns, that legal entity has to delegate rights to that RSU. This is done on skat.dk. A guide on how to delegate rights to an RSU is here: [https://skat.dk/erhverv/moms/momsregnskab](https://skat.dk/erhverv/moms/momsregnskab)

## About the web services

The web services are implemented as SOAP Web Services. This GitHub contains WSDLs, XSDs and sample requests for each of the Web Services.

### Security

The Web Services are protected using both TLS over HTTPS and by WS-Security using a certificate to both encrypt and sign the requests.

**Transport Layer Security (TLS)**

To be able to use the services, you need to add the server certificate to your trust store. You can find the certificates for both test and production in [pem/README.md](/pem/README.md).

The sample client in this GitHub already has the server certificate for the test environment in the trust store.

**WS-Security Protocol**

To be able to use the Web Services you also need a company certificate (VOCES3) from MitID Erhverv (OCES3).
A company certificate for the test environment is provided by contacting Skattestyrelsen. 
To be able to use the services in production, you need to get an official company certificate. Information on how to get this is attached when you get access to the test environment.

The company certificate is used to sign (seal) the soap:body of the request and other additional security headers such a timestamp. The certificate is also used to validate the response. 

An example of a signed request can be found here: [rsu-b2b-sample-client/src/test/resources/VirksomhedKalenderHent_I_Document_Complete_With_SOAPENV.xml](rsu-b2b-sample-client/src/test/resources/VirksomhedKalenderHent_I_Document_Complete_With_SOAPENV.xml)

### Legal Entity Identification

In all 3 Web Services the SE number of the legal entity submitting the VAT returns must be provided in the request in the field VirksomhedSENummerIdentifikator.

**Example:**
```xml
<ns1:VirksomhedSENummerIdentifikator>12345678</ns1:VirksomhedSENummerIdentifikator>
```

### Transaction Ids
Each request must include a section named HovedOplysninger that must include the following values:

* Transaction id (`<TransaktionIdentifikator>`) which is a unique string for all transactions. The transaction id cannot be reused in other requests.

* Transaction time (`<TransaktionTid>`).

**Example:**
```xml
<ns:HovedOplysninger>
    <TransaktionIdentifikator>81ADB49B-8B65-411F-9C50-76BB6DEFCBEB</TransaktionIdentifikator>
    <TransaktionTid>2017-03-14T08:47:27Z</TransaktionTid>
</ns:HovedOplysninger>
```

### The services
The following describes the 3 Web Services in technical details.

* **VirksomhedKalenderHent**
* **ModtagMomsangivelseForeloebig**
* **MomsangivelseKvitteringHent**

#### VirksomhedKalenderHent

(Company Calendar Get)

This web service returns the periods for which the legal entity must submit VAT Returns.

The services is requested with an date interval, e.g. from 2018-01-01 to 2018-12-31. The interval is used by the VirksomhedKalenderHent service to return the periods and deadlines for which the legal entity must submit VAT returns during this interval.

The service also returns a frequency code for how often a legal entity needs to submit VAT Returns. This is provided in the XML-element `<AngivelseFrekvensTypeKode>`. The numbers in the element corresponds to the following frequencies:

AngivelseFrekvensTypeKode | Frequency | Frekvens (Danish)
---|---|---
00 | None | Ingen
01 | Immidiately | Straks
02 | Daily | Daglig
05 | Weekly | Ugentlig
06 | Every 14th day | 14 dage
07 | Monthly | Månedlig
08 | Quarterly | Kvartal
09 | Every 6 months | Halvårlig
10 | Yearly | Årlig
16 | Varies | Variabel
17 | Occasionally | Lejlighedsvis

**WSDL**

* [VirksomhedKalenderHent.wsdl](rsu-b2b-sample-client/src/main/resources/VirksomhedKalenderHent/VirksomhedKalenderHent.wsdl)

**XSD**
* Request: [VirksomhedKalenderHent_I.xsd](rsu-b2b-sample-client/src/main/resources/VirksomhedKalenderHent/urn/oio/skat/nemvirksomhed/ws/1_0_0/VirksomhedKalenderHent_I.xsd)

* Response: [VirksomhedKalenderHent_O.xsd](rsu-b2b-sample-client/src/main/resources/VirksomhedKalenderHent/urn/oio/skat/nemvirksomhed/ws/1_0_0/VirksomhedKalenderHent_O.xsd)

**Sample Request:**
* [VirksomhedKalenderHent_I](rsu-b2b-sample-client/src/test/resources/VirksomhedKalenderHent_I_Document.xml)

#### ModtagMomsangivelseForeloebig

(Recieve Draft VAT Returns)

This is the service for submitting a draft of the VAT returns for a given period.

The request must include the period (date interval, e.g. from 2018-01-01 to 2018-03-31) for the VAT Returns and the VAT Returns fields values.

**IMPORTANT**: The ModtagMomsangivelseForeloebig service submits a draft of the VAT Returns to skat.dk. It must be approved manually by the legal entity. The service returns a deep link to the VAT Returns, where it can be approved. The link requires the legal entity to log in to skat.dk.

**VAT Return Fields descriptions**

Below is a description of the VAT Returns form. It contains 17 fields. The description is ordered as you find it when manually submitting VAT Returns on skat.dk.

(The value in the `<>` is the XML-element name in the request. It links to the XSD definition of the field. The number in the () is the sequence of the fields in the request. It is mandatory to follow the sequence of fields in request, but not all fields are required.)

The fields are: 

**Salgsmoms:**
* Salgsmoms (Udgående moms) - [`<MomsAngivelseSalgsMomsBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseSalgsMomsBeloeb.xsd) (14)
* Moms af varekøb i udlandet (både EU og lande uden for EU) - [`<MomsAngivelseMomsEUKoebBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseMomsEUKoebBeloeb.xsd) (11)
* Moms af ydelseskøb i udlandet (byggeydelser og arbejdsudleje) (MOMS) - [`<MomsAngivelseMomsEUYdelserBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseMomsEUYdelserBeloeb.xsd) (12)

**Fradrag:**
* Indgående Afgift - [`<MomsAngivelseKoebsMomsBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseKoebsMomsBeloeb.xsd) (9)
* Olie- og flaskegasafgift - [`<MomsAngivelseOlieAfgiftBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseOlieAfgiftBeloeb.xsd) (13)
* El-afgift - [`<MomsAngivelseElAfgiftBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseElAfgiftBeloeb.xsd) (6)
* Naturgas- og bygasafgift - [`<MomsAngivelseGasAfgiftBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseGasAfgiftBeloeb.xsd) (8)
* Kulafgift - [`<MomsAngivelseKulAfgiftBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseKulAfgiftBeloeb.xsd) (10)
* CO2-afgift - [`<MomsAngivelseCO2AfgiftBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseCO2AfgiftBeloeb.xsd) (2)
* Vandafgift - [`<MomsAngivelseVandAfgiftBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseVandAfgiftBeloeb.xsd) (15)
* Moms i alt (Angivelsens afgiftstilsvar) - [`<MomsAngivelseAfgiftTilsvarBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseAfgiftTilsvarBeloeb.xsd) (1)

**Supplerende oplysninger:**
* Rubrik A - varer. Værdien uden moms af varekøb i andre EU-lande (EU-erhvervelser) - [`<MomsAngivelseEUKoebBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseEUKoebBeloeb.xsd) (3)
* Rubrik A - ydelser. Værdien uden moms af ydelseskøb i andre EU-lande - [`<MomsAngivelseEUKoebYdelseBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseEUKoebYdelseBeloeb.xsd) (16)
* Rubrik B - varer. Indberettes til "EU-salg uden moms". Værdien af varesalg uden moms til andre EU-lande. - [`<MomsAngivelseEUSalgBeloebVarerBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseEUSalgBeloebVarerBeloeb.xsd) (4)
* Rubrik B - varer. Indberettes til "EU-salg uden moms". Værdien af f.eks. installation og montage, fjernsalg og nye transportmidler til ikke momsregistrerede kunder uden moms til andre EU-lande. - [`<MomsAngivelseIkkeEUSalgBeloebVarerBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseIkkeEUSalgBeloebVarerBeloeb.xsd) (5)
* Rubrik B - ydelser. Værdien af visse ydelsessalg uden moms til andre EU-lande. Indberettes til EU-salg uden moms (Rubrik B) - [`<MomsAngivelseEUSalgYdelseBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseEUSalgYdelseBeloeb.xsd) (17)
* Rubrik C - Værdien af andre varer og ydelser, der leveres uden afgift her i landet, i andre EU-lande og i lande uden for EU (Momsbekendtgørelse § 79. stik 7, jf § 76, stk. 10)  - [`<MomsAngivelseEksportOmsaetningBeloeb>`](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/1_0_0/MomsAngivelseEksportOmsaetningBeloeb.xsd) (7)

**WSDL**
* [ModtagMomsangivelseForeloebig.wsdl](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/ModtagMomsangivelseForeloebig.wsdl)

**XSD**

* Request: [ModtagMomsangivelseForeloebig_I.xsd](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/ws/1_0_0/ModtagMomsangivelseForeloebig_I.xsd)

* Response: [ModtagMomsangivelseForeloebig_O.xsd](rsu-b2b-sample-client/src/main/resources/ModtagMomsangivelseForeloebig/urn/oio/skat/nemvirksomhed/ws/1_0_0/ModtagMomsangivelseForeloebig_O.xsd)

**Sample Request:**
* [ModtagMomsangivelseForeloebig_I](rsu-b2b-sample-client/src/test/resources/ModtagMomsangivelseForeloebig_I_Document.xml)

#### MomsangivelseKvitteringHent
(VAT Receipt Get)

This Web Service returns a receipts for the submitted VAT Returns once the legal entity has approved the VAT returns. This service returns a receipt (a PDF document) and payment details.

To use this service, you take the transaction id from the `ModtagMomsangivelseForeloebig_O` response and pass it on the `<urn1:TransaktionIdentifier>` field in the `MomsangivelseKvitteringHent_I` request
(and not in `<ns:HovedOplysninger>`).

A new unique transaction id is still required in `<ns:HovedOplysninger>`.

**Example:**

A call to the service `ModtagMomsangivelseForeloebig` returns this response:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ns3:ModtagMomsangivelseForeloebig_O
        xmlns:ns="http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/" 
        xmlns:ns2="urn:oio:skat:nemvirksomhed:1.0.0" 
        xmlns:ns3="urn:oio:skat:nemvirksomhed:ws:1.0.0">
    <ns:HovedOplysningerSvar>
        <ns:TransaktionIdentifikator>f1c5ca7a-532d-4d79-a419-f4cdc5660e13</ns:TransaktionIdentifikator>
        <ns:ServiceIdentifikator>ModtagMomsangivelseForelobig</ns:ServiceIdentifikator>
        <ns:TransaktionTid>2017-04-24T11:00:00.146+02:00</ns:TransaktionTid>
        <ns:SvarStruktur/>
    </ns:HovedOplysningerSvar>
    <ns2:TransaktionIdentifier>42C8FE92-0AE3-403E-AEFA-F3A0B4508E2E</ns2:TransaktionIdentifier>
    <ns3:Dybtlink>
        <ns2:UrlIndicator>https://...</ns2:UrlIndicator>
    </ns3:Dybtlink>
</ns3:ModtagMomsangivelseForeloebig_O>
```

Extract the value from the field `<ns2:TransaktionIdentifier>`:

```
42C8FE92-0AE3-403E-AEFA-F3A0B4508E2E
```

Insert the value in the `MomsangivelseKvitteringHent_I` request:

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
    <!-- Enter the TransaktionIdentifier id from ModtagMomsangivelseForeloebig here: -->
    <urn1:TransaktionIdentifier>42C8FE92-0AE3-403E-AEFA-F3A0B4508E2E</urn1:TransaktionIdentifier>
    <urn:Angiver>
        <ns1:VirksomhedSENummerIdentifikator>12345678</ns1:VirksomhedSENummerIdentifikator>
    </urn:Angiver>
</urn:MomsangivelseKvitteringHent_I>
```

**WSDL**
* [MomsangivelseKvitteringHent.wsdl](rsu-b2b-sample-client/src/main/resources/MomsangivelseKvitteringHent/MomsangivelseKvitteringHent.wsdl)

**XSD** 
* Request: [MomsangivelseKvitteringHent_I.xsd](rsu-b2b-sample-client/src/main/resources/MomsangivelseKvitteringHent/urn/oio/skat/nemvirksomhed/ws/1_0_0/MomsangivelseKvitteringHent_I.xsd)

* Response: [MomsangivelseKvitteringHent_O.xsd](rsu-b2b-sample-client/src/main/resources/MomsangivelseKvitteringHent/urn/oio/skat/nemvirksomhed/ws/1_0_0/MomsangivelseKvitteringHent_O.xsd)

**Sample Request**
* [MomsangivelseKvitteringHent_I](rsu-b2b-sample-client/src/test/resources/MomsangivelseKvitteringHent_I_Document.xml)


## Test cases and error codes

The following section describes example test cases and list common errors, which might help you build your solution.

### Test cases

The following shows a set of test cases for testing the APIs. For errors, see the next section.

**1. RSU is delegated**

The first thing to check is whether the RSU is delegated to handle VAT Returns for the legal entity. This can be checked by using the VirksomhedKalenderHent service. If this service returns the calendar, then the RSU has been delegated correctly. If the service returns an error 4801 (see table in next section), then the RSU has not been delegated. See [Onboard Legal Entities](#onboard-legal-entities).

**2. Get Company Calendar**

The second test case is to get the Company Calendar for VAT Returns deadlines. The is also done by using the VirksomhedKalenderHent service. The calendar shows what periods the Company have to submit VAT Returns for and what the deadlines are.

**3. Submit VAT Returns draft**

The third test case is to submit a draft of VAT Returns. This is done by using the ModtagMomsangivelseForeloebig service. If the request is successful, a deep link to approve the VAT Returns is returned.

When using the test environment, please be aware that Skattestyrelsen controls the test companies. To be able to view and approve the VAT Returns, you need to contact Skattestyrelsen and provide the deep link.

**4. Get VAT Returns Reciept**

The last test case is to get the VAT Returns Reciept. This Reciept is available after the VAT Returns have been approved by the legal entity.

When using the test environment, please be aware that Skattestyrelsen controls the test companies. To get VAT Returns approved, you need to contact Skattestyrelsen.

### Errors

The RSU B2B Gateway generates two types of error code.

1) XML error generated by either incorrect SOAP-requests or XML-structures. These error occours when the request is not correctly formed. The response will indicate what the issue is. Examples are missing SOAP headers or missing mandatory XML-elements.

2) Error codes generated by the RSU B2B Gateway System. The following table lists the error codes, that the system might respond with:

Error code | Error Description (EN) | Error Description (DA)
------------ | ------------- | -----------------------
4801 | RSU is not delegated by the legal entity (See [Onboard Legal Entities](#onboard-legal-entities)) | RSU er ikke delegeret af virksomheden
4802 | The VAT period is not open | Ikke åben periode 
4803 | The VAT period has not ended | Periode ikke afsluttet
4804 | The VAT period is more than 3 years old | Periode er mere end 3 år gammel
4810 | The VAT statement draft has not been approved | Foreløbig statement ikke godkendt
4813 | The VAT statement draft does not exist | Der findes ingen foreløbig momsindberetning
4816 | The value in `<AngivelsesTypeNavn>` does not exist. Should be "Moms". | Værdien i `<Angivelsestype>` findes ikke. Skal være "Moms".
4811 | Ingen kvittering, den foreløbige momsangivelse er afvist
4812 | Kvittering findes ikke
4817 | The search start date is later than the search end date | Søgedato start er efter søgedatoslut


### Notification codes related to transactions

The service **ModtagMomsangivelseForeloebig** will for every successful submition of a VAT declaration return a formal notice related to the transaction in the **Advis** section of the **HovedOplysningerSvar/SvarStruktur** structure. Example:

```xml
<ns:HovedOplysningerSvar>
        <ns:TransaktionIdentifikator>...</ns:TransaktionIdentifikator>
        <ns:ServiceIdentifikator>...</ns:ServiceIdentifikator>
        <ns:TransaktionTid>...</ns:TransaktionTid>
        <ns:SvarStruktur>
            <ns:AdvisStruktur>
                <ns:AdvisIdentifikator>5001</ns:AdvisIdentifikator>
                <ns:AdvisTekst>Dette er en foreløbig ordinær angivelse</ns:AdvisTekst>
            </ns:AdvisStruktur>
        </ns:SvarStruktur>
</ns:HovedOplysningerSvar>
``` 

Please observe that notification codes are NOT the same as error codes

The service will return either one of the two codes:

Error code | Error Description (EN) | Error Description (DA)
------------ | ------------- | -----------------------
5001 | This is a preliminary ordinary declaration pending user approval | Dette er en foreløbig ordinær angivelse
5002 | This is a preliminary post declaration pending user approval | Dette er en foreløbig efterangivelse  

The service **MomsangivelseKvitteringHent** will - similar to **ModtagMomsangivelseForeloebig** - return the following notice codes once the user has approved the declaration submitted via **ModtagMomsangivelseForeloebig** via skat.dk:

Error code | Error Description (EN) | Error Description (DA)
------------ | ------------- | -----------------------
5003 | The post declaration has now been approved, a receipt is available on skat.dk | Din efterangivelse er nu godkendt, en kvittering er tilgængelig på skat.dk 
5004 | The ordinary declaration has now been approved, a receipt is available on skat.dk | Din ordinær angivelse er nu godkendt, en kvittering er tilgængelig på skat.dk

## About the client

The following is documentation of a sample client for the RSU B2B Web Service Gateway. The sample client is implemented based on the [Apache CXF](http://cxf.apache.org/) framework, the Spring Framework, and Java 8. See `pom.xml` file in this repo for details regarding the current versions of the mentioned frameworks in use. 

> **Looking for a .NET Core sample?** Skatteforvaltningen provides a sample Web Service Client written in .NET Core
> [here](https://github.com/skat/rsu-b2b-sample-client-dotnet).

These services are invoked and tested via a very simple web app that looks like a desktop SoapUI client, but just in a browser. Using the browser a sample request (provided left hand side) can be sent and the response will presented in the right hand side:

![gui](/assets/rsu_sample_gui_snapshot.png)

The client has by default a sample request for **VirksomhedKalenderHent** in the **Request** textarea (left hand side),
but not for the other services.

Sample requests for all 3 service are found here:

* [VirksomhedKalenderHent_I](rsu-b2b-sample-client/src/test/resources/VirksomhedKalenderHent_I_Document.xml)
* [ModtagMomsangivelseForeloebig_I](rsu-b2b-sample-client/src/test/resources/ModtagMomsangivelseForeloebig_I_Document.xml)
* [MomsangivelseKvitteringHent_I](rsu-b2b-sample-client/src/test/resources/MomsangivelseKvitteringHent_I_Document.xml)

Use these as templates and copy content to the **Request** textarea (left hand side).

The user must ensure to:

* Select the **Service** (dropdown) to be tested.
* Select the **Environment** (dropdown) on the which the **Service** runs.
* Select the **Certificate** of the legal entity submitting the request/document.
UYpda* Select the **Policy** to be attached to the call.

A check in the **Override 'HovedOplysninger' (Transaction Id and Time)** checkbox results in the transaction id **and** 
transaction time in the provided XML request to be regenerated. This will likely be relevant as the service called will
not allow use of previously submitted transaction id.

Finally, press **Test**.

## The sample client implementation

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

The security policies required to call the RSU B2B Web Services are defined here:

[rsu-policy-sign.xml](rsu-b2b-sample-client/src/main/resources/rsu-policy-sign.xml)

Fulfillment of WS Policy requirements is achieved using CXF's in and out interceptor framework. 
The `rsu-policy-sign.xml` file details which parts are to be signed and how to present 
certificate for authentication on the server side. This configuration file also demonstrates how
secure transport (https) is enabled client side.

**NOTE:**: The RSU services are for a limited time also provided with this policy:

[rsu-policy.xml](rsu-b2b-sample-client/src/main/resources/rsu-policy.xml)

This policy configuration adds payload encryption in addition to the policies defined inside `rsu-policy-sign.xml` and
is only provided here for users that have not yet migrated to `rsu-policy-sign.xml`  (or equivalent).

### The web based test client

The web based test client (`rsu-b2b-sample-client-gui`) is kept as simple as possible using a very simple 
MVC framework (Struts) and provides a simple SOAP test framework that invokes the above three webservices.
As the test client allows input of XML documents there is a process to convert the XML to Java objects that
are used as input in the generated Webservice Clients.

#### Test certificates

The client comes with 3 x OCES3 certificates that may be used for testing as follows:

* **Luca_Pacioli**: Certificate identifying to an employee of our test RSU, but the employee is registered, but not authorized to invoke the RSU services.
* **LucaPacioli_ApS_System_Integrationstest_S1**: Certificate identifying the system of our test RSU. This certificate is registered and authorized to invoke the RSU services.
* **LucaPacioli_ApS_Organisation_Integrationstest_O1**: Certificate identifying our test RSU. The certificate is not registered and consequently not authorized to invoke the RSU services.

That is, for sunshine testing use **LucaPacioli_ApS_System_Integrationstest_S1**.

## Run clients

The sample clients must be configured with parameters that are necessary for the client to run and
call the test environment of RSU B2B Web Service Gateway. 

The parameters (provided as a file named `app.conf`) can be obtained by contacting Skattestyrelsen.

In the following sections we describe two methods for running the sample:

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

On your **server** create a directory named `rsu-b2b-sample-client-gui`.

Copy these files to the directory `rsu-b2b-sample-client-gui`:

```
rsu-b2b-sample-client-gui/target/rsu-b2b-sample-client-gui-<VERSION>-war-exec.jar
rsu-b2b-sample-client/src/main/resources/keystore/client-keystore.jks
rsu-b2b-sample-client/src/main/resources/keystore/server-keystore.jks
```

Organize the files as follows: 

```
rsu-b2b-sample-client-gui/
  rsu-b2b-sample-client-gui-<VERSION>-war-exec.jar
  keystore/
    client-keystore.jks
    server-keystore.jks
  app.conf
```

Then inside `rsu-b2b-sample-client-gui` run:

```sh
$ java -jar rsu-b2b-sample-client-gui-<VERSION>-war-exec.jar
```

Once Tomcat is running open URL:

```
http://localhost:8080/rsu-b2b-sample-client-gui
```

### Change endpoints

If you want to have the test client call the built-in Log Servlet modify `app.conf` and 
replace the `endpoints` section with this section:

```
endpoints {
    TFE {
        VirksomhedKalenderHent = "http://localhost:8080/rsu-b2b-sample-client-gui/log"
        ModtagMomsangivelseForeloebig = "http://localhost:8080/rsu-b2b-sample-client-gui/log"
        MomsangivelseKvitteringHent = "http://localhost:8080/rsu-b2b-sample-client-gui/log"
    }
}
```

### Add new environment and endpoints

> This section describes how the **app.conf** provided by Skattestyrelsen has been extended to allow
> integration to the actual test environment hosted by Skattestyrelsen.

New environments and endpoints of the services on these environments are added to the 
`app.conf` file as follows.

First add the ID of the environment, e.g. `NEWENV` :

```
environments = [ "TFE", "NEWENV" ]
```

Then add endpoints for each of the three services, e.g.:

```
endpoints {
    TFE {
        VirksomhedKalenderHent = "http://localhost:8080/rsu-b2b-sample-client-gui/log"
        ModtagMomsangivelseForeloebig = "http://localhost:8080/rsu-b2b-sample-client-gui/log"
        MomsangivelseKvitteringHent = "http://localhost:8080/rsu-b2b-sample-client-gui/log"
    }
    NEWENV {
        VirksomhedKalenderHent = "https://remotehost/VirksomhedKalenderHent"
        ModtagMomsangivelseForeloebig = "https://remotehost/ModtagMomsangivelseForeloebig"
        MomsangivelseKvitteringHent = "https://remotehost/MomsangivelseKvitteringHent"
    }
}

```

### Add another OCES3 certificate

First complete the steps in section: **Installing other OCES3 Certificates in the client keystore** (below)
The chosen **alias**, e.g. `myalias` from the import must be added to  `app.conf` as follows:

```
activeCertificates = [ "LucaPacioli_ApS_System_Integrationstest_S1", ... , "myalias" ]
```

Then add the passphrase:

```
certificatePassphrases {
    LucaPacioli_ApS_System_Integrationstest_S1 = "secret"
    ...
    myalias = "verysecret"
}
```

Finally add the name:

```
certificateCommenNames {
    LucaPacioli_ApS_System_Integrationstest_S1 = "LucaPacioli_ApS_System_Integrationstest_S1"
    ...
    myalias = "MyAlias Identity - This will be shown on the screen"
}
```

### Installing other OCES3 Certificates in the client key store

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

Where `P12_PASSPHRASE` and `P12_CURRENT_ALIAS` are passphrase and value of the OCES3 certificate,
respectively. The three keytool command removes the pre configured certificate, changes the value
of the new certificate, and finally imports it into the keystore.

### Changing certificate in the client trust store

The trust store `rsu-b2b-sample-client/src/main/resources/keystore/client-truststore.jks` is already prepared with the
certificate for the test environment server. However, in order to access another environment, e.g. production, the server certificate has to be changed to fit with the environment.

To change the certificate in the trust store, you first need to delete the old certificate. (Replace "storepassword" with your trust store password)

```sh
$ keytool -delete -alias skatserver -keystore client-truststore.jks -storepass storepassword
```

Then you can add the new certificate to the trust store.

```sh
$ keytool -import -alias skatserver -file newcert.crt -keystore client-truststore.jks -storepass storepassword
```

## References

* [Apache CXF](http://cxf.apache.org/)
* [Apache CXF Samples](https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples)
