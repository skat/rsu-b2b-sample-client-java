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
messages:

* [TEST System](/pem/ws-security/b2b-test-system.pem) (**Note**: Expires on April 10, 2026)

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



