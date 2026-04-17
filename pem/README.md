# Certificates

## Transport Layer Security (TLS)

The following certificates are for **Transport Layer Security** only.

* [TEST System](/pem/tls/ssl-chain-0.pem) with the following details:

```
Owner: CN=*.skat.dk, O=Skatteforvaltningen, L=Herning, ST=Herning, C=DK
Issuer: CN=GlobalSign RSA OV SSL CA 2018, O=GlobalSign nv-sa, C=BE
Serial number: 4c50bf969b9d9687ec752a20
Valid from: Thu Dec 07 14:06:14 CET 2023 until: Tue Jan 07 14:06:13 CET 2025
Certificate fingerprints:
	 SHA1: 1B:06:01:45:E4:6B:4E:27:8E:D8:59:59:FB:7E:C0:75:F6:6F:8B:7C
	 SHA256: 19:C0:53:48:5B:CC:60:3F:4F:E6:32:43:6F:B8:EC:3E:08:EC:C9:06:D2:84:CF:21:19:56:CF:61:2D:19:07:F0
```


Issuer certificates for both **TEST** and **PRODUCTION**:

* [GlobalSign RSA OV SSL CA 2018](/pem/tls/ssl-chain-1.pem)
* [GlobalSign Root CA](/pem/tls/ssl-chain-2.pem)

### Do I have to install or update these certificates in my system?

It depends on your system and/or your strategy:

|   | Trust by installing                  | Update when                     |
|---|--------------------------------------|---------------------------------|
| A | Server TLS certificate only/directly | Certificate is renewed          |
| B | Issuer certificates                  | Issuer certificates are renewed |
| C | Full chain                           | Do both (A) and (B)             |

## WS-Security

**IMPORTANT**: Certificates in this section **CANNOT** be used for **Transport Layer Security**

The following certificates are for **Web Service Security** to ensure **non-repudiation** (signing) when exchanging
messages.

### Test Environment

* OCES3 certificate for the [TEST Environment](/pem/ws-security/b2b-test-system.pem) (**Note**: Expires on March 24, 2029)

```
Owner: C=DK, OID.2.5.4.97=NTRDK-19552101, O=Skatteforvaltningen, SERIALNUMBER=UI:DK-O:G:5e50b9bb-22fd-483d-baf7-fd077ed975f5, CN=Skatteministeriet - B2B gateway TSE TEST
Issuer: C=DK, O=Den Danske Stat, OU=Test - cti, CN=Den Danske Stat OCES udstedende-CA 1
Serial number: 4c5f96b2ff8bfde1e126d13a348d4270481d1545
Valid from: Wed Mar 25 15:11:30 CET 2026 until: Sat Mar 24 15:11:29 CET 2029
Certificate fingerprints:
	 SHA1: 81:07:4E:0B:CE:63:9C:EE:AD:ED:05:78:C0:58:51:54:38:21:4F:81
	 SHA256: D8:11:FE:0D:1C:73:23:A3:9D:E1:4E:8B:35:DB:06:22:FD:FD:56:44:C8:F9:8D:28:DE:34:D8:A6:69:46:4D:E1
Signature algorithm name: RSASSA-PSS
Subject Public Key Algorithm: 3072-bit RSA key
Version: 3
```

Issued by [intermediate CA](/pem/ws-security/Den_Danske_Stat_OCES_udstedende_CA_1_Test_cti.pem):

```
Owner: C=DK, O=Den Danske Stat, OU=Test - cti, CN=Den Danske Stat OCES udstedende-CA 1
Issuer: C=DK, O=Den Danske Stat, OU=Test - cti, CN=Den Danske Stat OCES rod-CA
Serial number: 734d70a62e521cd17c644c99a0900e1d59e061ae
Valid from: Fri Mar 12 08:42:59 CET 2021 until: Mon Mar 10 08:42:58 CET 2031
Certificate fingerprints:
	 MD5:  4F:60:24:4C:A3:81:E7:F6:6B:BA:77:97:0F:18:03:C9
	 SHA1: 72:34:7B:AE:17:45:68:89:42:D4:9D:FF:5F:2C:80:53:8B:5B:02:3B
	 SHA256: 57:C7:85:23:6A:D7:C9:C9:86:B9:4D:49:AB:DA:FD:1B:95:5C:55:09:33:8F:A4:3A:7C:E0:D6:60:88:C8:AF:9B
Signature algorithm name: 1.2.840.113549.1.1.10
Subject Public Key Algorithm: 3072-bit RSA key
Version: 3

```

Issued by [root CA](/pem/ws-security/Den_Danske_Stat_OCES_rod_CA_Test_cti.pem):

```
Owner: C=DK, O=Den Danske Stat, OU=Test - cti, CN=Den Danske Stat OCES rod-CA
Issuer: C=DK, O=Den Danske Stat, OU=Test - cti, CN=Den Danske Stat OCES rod-CA
Serial number: 573f57e67530f1a0777dfbc69f090438d3360256
Valid from: Thu Jan 28 10:49:25 CET 2021 until: Mon Jan 22 10:49:24 CET 2046
Certificate fingerprints:
MD5:  48:AC:59:94:E7:62:BE:EA:23:41:31:0B:47:A1:7B:51
SHA1: 0E:99:4B:E0:FA:C7:E8:59:85:4C:39:49:95:59:99:F4:E3:03:7D:22
SHA256: D1:BC:EC:41:D7:AC:AE:93:2B:7D:FE:66:A8:B7:34:1C:A7:59:52:C8:66:4F:CC:EF:4C:4A:E2:15:0F:95:C5:EC
Signature algorithm name: 1.2.840.113549.1.1.10
Subject Public Key Algorithm: 4096-bit RSA key
Version: 3
```

### PROD Environment 

* OCES3 certificate for the [PROD Environment](/pem/ws-security/b2b-prod-system.pem) (**Note**: Expires on March 24, 2029)

```
Owner: C=DK, OID.2.5.4.97=NTRDK-19552101, O=Skatteforvaltningen, SERIALNUMBER=UI:DK-O:G:bf204036-6f12-4d62-bcc7-5930618355c6, CN=Skatteforvaltningen - B2B gateway TSE
Issuer: C=DK, O=Den Danske Stat, CN=Den Danske Stat OCES udstedende-CA 1
Serial number: ef2e26471149e107205d29c809eff29dc6a6e36
Valid from: Wed Mar 25 15:04:28 CET 2026 until: Sat Mar 24 15:04:27 CET 2029
Certificate fingerprints:
	 SHA1: B5:F8:78:8F:38:F9:09:80:DB:36:EE:B4:5B:C8:7D:84:95:08:DF:68
	 SHA256: 07:BE:69:65:E0:FA:A5:EB:F7:A4:8D:DF:F6:12:D4:9B:C8:CD:62:AF:0B:CC:C9:4E:0E:FF:C7:D2:50:5E:8B:7F
Signature algorithm name: RSASSA-PSS
Subject Public Key Algorithm: 3072-bit RSA key
Version: 3
```

* Issued by [intermediate CA](https://cms.nemlog-in.dk/media/fgqokbqr/oces-intermediate-ca-pem-cer.txt)
* Issued by [root CA](https://cms.nemlog-in.dk/media/fdalnwib/ocesrootca-cacert-pem-cer.txt)

