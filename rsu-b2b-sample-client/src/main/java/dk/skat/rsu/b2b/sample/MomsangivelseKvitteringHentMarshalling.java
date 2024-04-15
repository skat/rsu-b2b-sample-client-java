package dk.skat.rsu.b2b.sample;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentIType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentOType;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * MomsangivelseKvitteringHentMarshalling
 *
 * @author SKAT
 * @since 1.0
 */
public class MomsangivelseKvitteringHentMarshalling {

    public static MomsangivelseKvitteringHentIType toObject(String document) throws JAXBException, IOException {
        InputStream inputStream = IOUtils.toInputStream(document, "UTF-8");
        return toObject(inputStream);
    }

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
