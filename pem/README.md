# Certificates

## Transport Layer Security (TLS)

The following certificates are for **Transport Layer Security** only.

* [TEST System](/pem/tls/ssl-chain-0.pem) with the following details:

```
Owner: CN=*.skat.dk, O=Skatteforvaltningen, L=Herning, ST=Herning, C=DK
Issuer: CN=GlobalSign RSA OV SSL CA 2018, O=GlobalSign nv-sa, C=BE
Serial number: 520918b4e8e48842ca30f22b
Valid from: Thu Dec 01 21:21:02 CET 2022 until: Tue Jan 02 21:21:01 CET 2024
Certificate fingerprints:
	 MD5:  1C:0C:D8:FC:8C:AF:54:D4:9B:90:BE:6E:00:96:10:7C
	 SHA1: 12:E6:4C:02:A5:AB:FB:BD:6D:A8:EC:2F:D4:8D:BF:E7:02:DC:0A:40
	 SHA256: 22:52:90:32:C0:E7:B0:AC:FF:70:AD:19:A4:99:04:7B:59:5B:12:BC:95:D8:E3:69:1E:CC:52:66:A5:15:30:D2
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

* OCES3 certificate for the [TEST Environment](/pem/ws-security/b2b-test-system.pem) (**Note**: Expires on April 10, 2026)

```
Owner: C=DK, OID.2.5.4.97=NTRDK-19552101, O=Skatteforvaltningen, SERIALNUMBER=UI:DK-O:G:5e50b9bb-22fd-483d-baf7-fd077ed975f5, CN=Skatteministeriet - B2B gateway TSE TEST
Issuer: C=DK, O=Den Danske Stat, OU=Test - cti, CN=Den Danske Stat OCES udstedende-CA 1
Serial number: 47748500ccf123e1d3a4798462540f4619f5269
Valid from: Tue Apr 11 10:38:58 CEST 2023 until: Fri Apr 10 10:38:57 CEST 2026
Certificate fingerprints:
MD5:  BC:92:99:10:25:84:5A:EA:3C:40:33:3F:E3:45:D7:8D
SHA1: 6B:7F:D1:DD:CD:0B:98:A1:CC:66:55:CD:69:79:1E:74:77:87:50:D3
SHA256: E2:BD:10:46:21:B5:07:D7:11:B3:C1:CB:6B:24:0B:6C:00:A5:B2:FB:3C:51:0A:80:E9:2B:57:24:70:3F:8E:DD
Signature algorithm name: 1.2.840.113549.1.1.10
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

**Important**: This certificate is scheduled to be active from 2023-05-25 0800 hours CET. Please
follow this page to check changes in the schedule.

* OCES3 certificate for the [PROD Environment](/pem/ws-security/b2b-prod-system.pem) (**Note**: Expires on April 27, 2026)

```
Owner: C=DK, OID.2.5.4.97=NTRDK-19552101, O=Skatteforvaltningen, SERIALNUMBER=UI:DK-O:G:bf204036-6f12-4d62-bcc7-5930618355c6, CN=Skatteforvaltningen - B2B gateway TSE
Issuer: C=DK, O=Den Danske Stat, CN=Den Danske Stat OCES udstedende-CA 1
Serial number: 77460c604bc7b989f36c6c856a5d28304ce06704
Valid from: Fri Apr 28 10:09:37 CEST 2023 until: Mon Apr 27 10:09:36 CEST 2026
Certificate fingerprints:
	 SHA1: EE:02:32:28:C9:9F:2D:0E:98:A7:D3:8B:B4:B2:37:F1:1F:63:BC:E1
	 SHA256: 35:BD:E8:B4:CC:11:7F:02:1F:8B:72:AF:0B:43:E7:D8:27:B5:81:30:E8:EA:9F:B4:76:2B:A1:96:44:FC:28:A9
Signature algorithm name: RSASSA-PSS
Subject Public Key Algorithm: 3072-bit RSA key
Version: 3
```

* Issued by [intermediate CA](https://cms.nemlog-in.dk/media/fgqokbqr/oces-intermediate-ca-pem-cer.txt)
* Issued by [root CA](https://cms.nemlog-in.dk/media/fdalnwib/ocesrootca-cacert-pem-cer.txt)

