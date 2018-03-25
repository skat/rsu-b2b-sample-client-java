package dk.skat.rsu.b2b.sample;

import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentIType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentOType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * MomsangivelseKvitteringHentMarshalling
 *
 * @author SKAT
 * @since 1.0
 */
public class MomsangivelseKvitteringHentMarshalling {

    public static MomsangivelseKvitteringHentIType toObject(InputStream inputStream) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(MomsangivelseKvitteringHentIType.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (MomsangivelseKvitteringHentIType) unmarshaller.unmarshal(inputStream);
    }

    public static String toString(MomsangivelseKvitteringHentOType document) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(MomsangivelseKvitteringHentOType.class);
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
