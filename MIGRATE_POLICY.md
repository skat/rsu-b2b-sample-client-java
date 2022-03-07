### Migrate to policy with signing only

Existing integrations with the security policy that timestamps, signs, and encrypts the payload should migrate the new
endpoints that only require timestamp and signature.

Contact Skattestyrelsen at [momsapi@sktst.dk](mailto:momsapi@sktst.dk?subject=Nye%20endepunkter&body=)
for obtaining the new endpoints.

This document briefly describes how to for a select number of technologies.

## Apache CXF

If the solution is based on Apache CXF *and* the sample code in this repository the migration is as follows:

In the `inInterceptors` section *remove*:

* `Encrypt` string from the `action` key
* `decryptionPropFile` key
* `encryptionKeyIdentifier` key
* `encryptionKeyTransportAlgorithm` key

In the `outInterceptors` section *remove*:

* `Encrypt` string from the `action` key
* `encryptionUser` key
* `encryptionPropFile` key
* `encryptionKeyIdentifier` key
* `encryptionParts` key
* `encryptionKeyTransportAlgorithm` key
* `encryptionSymAlgorithm` key

Or simply look at [rsu-policy-sign.xml](rsu-b2b-sample-client/src/main/resources/rsu-policy-sign.xml)
