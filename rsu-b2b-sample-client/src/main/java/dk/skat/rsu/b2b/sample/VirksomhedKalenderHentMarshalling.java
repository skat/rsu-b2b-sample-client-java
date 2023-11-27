package dk.skat.rsu.b2b.sample;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import oio.skat.nemvirksomhed.ws._1_0.VirksomhedKalenderHentIType;
import oio.skat.nemvirksomhed.ws._1_0.VirksomhedKalenderHentOType;

import java.io.InputStream;
import java.io.StringWriter;

/**
 * VirksomhedKalenderHentMarshalling
 *
 * @author SKAT
 * @since 1.0
 */
public class VirksomhedKalenderHentMarshalling {

    public static VirksomhedKalenderHentIType toObject(InputStream inputStream) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(VirksomhedKalenderHentIType.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (VirksomhedKalenderHentIType) unmarshaller.unmarshal(inputStream);
    }

    public static String toString(VirksomhedKalenderHentOType document) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(VirksomhedKalenderHentOType.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            final StringWriter w = new StringWriter();
            marshaller.marshal(document, w);
            return w.toString();
        } catch (JAXBException e) {
            throw e;
        }
    }
}
