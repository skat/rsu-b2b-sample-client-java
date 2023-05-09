package dk.skat.rsu.b2b.sample;

import oio.skat.nemvirksomhed.ws._1_0.ModtagMomsangivelseForeloebigIType;
import oio.skat.nemvirksomhed.ws._1_0.ModtagMomsangivelseForeloebigOType;
import oio.skat.nemvirksomhed.ws._1_0_0.ModtagMomsangivelseForeloebigServiceBindingQSService;
import oio.skat.nemvirksomhed.ws._1_0_0.ModtagMomsangivelseForeloebigServicePortType;
import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.BindingProvider;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * ModtagMomsangivelseForeloebigClient
 *
 * @author SKAT
 * @since 1.0
 */
public class ModtagMomsangivelseForeloebigClient extends BaseClient {

    private static final Logger LOGGER = Logger.getLogger(ModtagMomsangivelseForeloebigClient.class.getName());

    private String endpointURL;

    /**
     * Private constructor
     */
    private ModtagMomsangivelseForeloebigClient() {
    }

    /**
     * Constructor
     *
     * @param endpointURL Endpoint of ModtagMomsangivelseForeloebig service
     */
    public ModtagMomsangivelseForeloebigClient(String endpointURL, String policy) {
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
            throws IOException, JAXBException, DatatypeConfigurationException {

        configureBus(certicateAlias);

        ModtagMomsangivelseForeloebigServiceBindingQSService service = new ModtagMomsangivelseForeloebigServiceBindingQSService();
        ModtagMomsangivelseForeloebigServicePortType port = service.getModtagMomsangivelseForeloebigServiceBindingQSPort();

        // Set endpoint of service.
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpointURL);

        InputStream inputStream = IOUtils.toInputStream(document, "UTF-8");
        ModtagMomsangivelseForeloebigIType modtagMomsangivelseForeloebigIType = ModtagMomsangivelseForeloebigMarshalling.toObject(inputStream);

        if (overrideHovedoplysninger) {
            modtagMomsangivelseForeloebigIType.getHovedOplysninger().setTransaktionIdentifikator(TransactionIdGenerator.getTransactionId());
            modtagMomsangivelseForeloebigIType.getHovedOplysninger().setTransaktionTid(getTransactionTime());
            LOGGER.info("HovedOplysninger populated with new Transaction Id and Time");
        }

        ModtagMomsangivelseForeloebigOType out = port.getModtagMomsangivelseForeloebig(modtagMomsangivelseForeloebigIType);
        return ModtagMomsangivelseForeloebigMarshalling.toString(out);
    }
}
