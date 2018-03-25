package dk.skat.rsu.b2b.sample;

import oio.skat.nemvirksomhed.ws._1_0.ModtagMomsangivelseForeloebigIType;
import oio.skat.nemvirksomhed.ws._1_0.ModtagMomsangivelseForeloebigOType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * ModtagMomsangivelseForeloebigMarshalling
 *
 * @author SKAT
 * @since 1.0
 */
public class ModtagMomsangivelseForeloebigMarshalling {

    public static ModtagMomsangivelseForeloebigIType toObject(InputStream inputStream) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(ModtagMomsangivelseForeloebigIType.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (ModtagMomsangivelseForeloebigIType) unmarshaller.unmarshal(inputStream);
    }

    public static String toString(ModtagMomsangivelseForeloebigOType document) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(ModtagMomsangivelseForeloebigOType.class);
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
