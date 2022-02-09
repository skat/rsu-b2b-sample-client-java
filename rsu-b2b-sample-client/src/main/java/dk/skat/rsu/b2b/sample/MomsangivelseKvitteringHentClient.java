package dk.skat.rsu.b2b.sample;

import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentIType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentOType;
import oio.skat.nemvirksomhed.ws._1_0.VirksomhedKalenderHentIType;
import oio.skat.nemvirksomhed.ws._1_0.VirksomhedKalenderHentOType;
import oio.skat.nemvirksomhed.ws._1_0_0.MomsangivelseKvitteringHentServiceBindingQSService;
import oio.skat.nemvirksomhed.ws._1_0_0.MomsangivelseKvitteringHentServicePortType;
import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * MomsangivelseKvitteringHentClient
 *
 * @author SKAT
 * @since 1.0
 */
public class MomsangivelseKvitteringHentClient extends BaseClient {

    private static final Logger LOGGER = Logger.getLogger(MomsangivelseKvitteringHentClient.class.getName());

    private String endpointURL;

    /**
     * Private constructor
     */
    private MomsangivelseKvitteringHentClient() {
    }

    /**
     * Constructor
     *
     * @param endpointURL Endpoint of ModtagMomsangivelseForeloebig service
     */
    public MomsangivelseKvitteringHentClient(String endpointURL, String policy) {
        super(policy);
        this.endpointURL = endpointURL;
    }

    /**
     * Call ModtagMomsangivelseForeloebig service
     *
     * @param document                 Request document as String
     * @param certicateAlias           Alias of certificate to use in call
     * @param overrideHovedoplysninger If transaction Id and Time should be regenerated
     * @throws IOException                    N/A
     * @throws JAXBException                  N/A
     * @throws DatatypeConfigurationException N/A
     */
    public String invoke(String document, String certicateAlias, boolean overrideHovedoplysninger)
            throws IOException, DatatypeConfigurationException, JAXBException {

        configureBus(certicateAlias);

        MomsangivelseKvitteringHentServiceBindingQSService service = new MomsangivelseKvitteringHentServiceBindingQSService();
        MomsangivelseKvitteringHentServicePortType port = service.getMomsangivelseKvitteringHentServiceBindingQSPort();

        // Set endpoint of service.
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpointURL);

        InputStream inputStream = IOUtils.toInputStream(document, "UTF-8");
        MomsangivelseKvitteringHentIType momsangivelseKvitteringHentIType = MomsangivelseKvitteringHentMarshalling.toObject(inputStream);

        if (overrideHovedoplysninger) {
            momsangivelseKvitteringHentIType.getHovedOplysninger().setTransaktionIdentifikator(TransactionIdGenerator.getTransactionId());
            momsangivelseKvitteringHentIType.getHovedOplysninger().setTransaktionTid(getTransactionTime());
            LOGGER.info("HovedOplysninger populated with new Transaction Id and Time");
        }

        MomsangivelseKvitteringHentOType out = port.getMomsangivelseKvitteringHent(momsangivelseKvitteringHentIType);
        return MomsangivelseKvitteringHentMarshalling.toString(out);
    }

}
