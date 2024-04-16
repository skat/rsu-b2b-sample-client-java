package dk.skat.rsu.b2b.sample;

import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseStatusHentIType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseStatusHentOType;
import org.apache.commons.io.IOUtils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * MomsangivelseStatusHentMarshalling
 *
 * @author SKAT
 * @since 1.0
 */
public class MomsangivelseStatusHentMarshalling {

    public static MomsangivelseStatusHentIType toObject(String document) throws JAXBException, IOException {
        InputStream inputStream = IOUtils.toInputStream(document, "UTF-8");
        return toObject(inputStream);
    }

    public static MomsangivelseStatusHentIType toObject(InputStream inputStream) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(MomsangivelseStatusHentIType.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return (MomsangivelseStatusHentIType) unmarshaller.unmarshal(inputStream);
    }

    public static String toString(MomsangivelseStatusHentOType document) throws JAXBException {
        try {
            JAXBContext jc = JAXBContext.newInstance(MomsangivelseStatusHentOType.class);
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
