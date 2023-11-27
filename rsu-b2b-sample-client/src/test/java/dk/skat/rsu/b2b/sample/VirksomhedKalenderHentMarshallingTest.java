package dk.skat.rsu.b2b.sample;

import java.io.InputStream;
import jakarta.xml.bind.JAXBException;
import oio.skat.nemvirksomhed.ws._1_0.VirksomhedKalenderHentIType;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;

public class VirksomhedKalenderHentMarshallingTest {

    @Test
    public void toVirksomhedKalenderHentIType() throws JAXBException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("VirksomhedKalenderHent_I_Document.xml");
        VirksomhedKalenderHentIType document = VirksomhedKalenderHentMarshalling.toObject(inputStream);
        assertEquals("12345678", document.getVirksomhedSENummerIdentifikator());
    }

    /*
    @Test
    public void virksomheKalenderHentTest() throws DatatypeConfigurationException, JAXBException, IOException {
        VirksomhedKalenderHentClient client = new VirksomhedKalenderHentClient("https://emcstest.skat.dk/B2BVirksomhedKalenderHentWSSProxyWEB/VirksomhedKalenderHentService", "rsu-policy-sign.xml");
        System.out.println("client = " + client);
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("TestRequest.xml");
        VirksomhedKalenderHentIType document = VirksomhedKalenderHentMarshalling.toObject(inputStream);

        //String serviceResponse = client.invoke(document.,"LucaPacioli_ApS_System_Integrationstest_S1", false);

        String serviceResponse = client.invoke("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<urn:VirksomhedKalenderHent_I xmlns:urn=\"urn:oio:skat:nemvirksomhed:ws:1.0.0\"\n" +
            "                              xmlns:ns=\"http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/\"\n" +
            "                              xmlns:ns1=\"http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/\"\n" +
            "                              xmlns:urn1=\"urn:oio:skat:nemvirksomhed:1.0.0\">\n" +
            "    <ns:HovedOplysninger>\n" +
            "        <ns:TransaktionIdentifikator>33593B0D-E7CF-40A2-AE76-530B72DE6AE3</ns:TransaktionIdentifikator>\n" +
            "        <ns:TransaktionTid>2017-04-24T12:00:00.146+02:00</ns:TransaktionTid>\n" +
            "    </ns:HovedOplysninger>\n" +
            "    <ns1:VirksomhedSENummerIdentifikator>12345678</ns1:VirksomhedSENummerIdentifikator>\n" +
            "    <urn1:AngivelseTypeNavn>qwerty</urn1:AngivelseTypeNavn>\n" +
            "    <urn:AngivelseBetalingFristHentFra>\n" +
            "        <urn1:SoegeDatoFraDate>2017-01-01</urn1:SoegeDatoFraDate>\n" +
            "        <urn1:SoegeDatoTilDate>2017-03-31</urn1:SoegeDatoTilDate>\n" +
            "    </urn:AngivelseBetalingFristHentFra>\n" +
            "</urn:VirksomhedKalenderHent_I>", "LucaPacioli_ApS_System_Integrationstest_S1", false);

        System.out.println("response = " + serviceResponse);

        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<ns4:VirksomhedKalenderHent_O xmlns=\"http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/\" xmlns:ns2=\"http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/\" xmlns:ns4=\"urn:oio:skat:nemvirksomhed:ws:1.0.0\" xmlns:ns3=\"urn:oio:skat:nemvirksomhed:1.0.0\">\n" +
            "    <HovedOplysningerSvar>\n" +
            "        <TransaktionIdentifikator>33593B0D-E7CF-40A2-AE76-530B72DE6AE3</TransaktionIdentifikator>\n" +
            "        <ServiceIdentifikator>VirksomhedKalenderHentService</ServiceIdentifikator>\n" +
            "        <TransaktionTid>2017-04-24T12:00:00.146+02:00</TransaktionTid>\n" +
            "        <SvarStruktur>\n" +
            "            <FejlStruktur>\n" +
            "                <FejlIdentifikator>4801</FejlIdentifikator>\n" +
            "                <FejlTekst>RSU er ikke delegeret</FejlTekst>\n" +
            "            </FejlStruktur>\n" +
            "        </SvarStruktur>\n" +
            "    </HovedOplysningerSvar>\n" +
            "</ns4:VirksomhedKalenderHent_O>", serviceResponse);



    }
*/

/*this.getClass().getClassLoader().getResourceAsStream("TestRequest.xml").toString()*/

}
