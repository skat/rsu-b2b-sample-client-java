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
}
