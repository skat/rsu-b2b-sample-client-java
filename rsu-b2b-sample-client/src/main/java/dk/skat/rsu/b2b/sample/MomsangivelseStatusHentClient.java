package dk.skat.rsu.b2b.sample;

import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseStatusHentIType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseStatusHentOType;
import oio.skat.nemvirksomhed.ws._1_0_0.MomsangivelseStatusHentServiceBindingQSService;
import oio.skat.nemvirksomhed.ws._1_0_0.MomsangivelseStatusHentServicePortType;
import org.apache.commons.io.IOUtils;

import jakarta.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import jakarta.xml.ws.BindingProvider;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * MomsangivelseStatusHentClient
 *
 * @author SKAT
 * @since 1.0
 */
public class MomsangivelseStatusHentClient extends BaseClient {

    private static final Logger LOGGER = Logger.getLogger(MomsangivelseStatusHentClient.class.getName());

    private String endpointURL;

    /**
     * Private constructor
     */
    private MomsangivelseStatusHentClient() {
    }

    /**
     * Constructor
     *
     * @param endpointURL Endpoint of ModtagMomsangivelseForeloebig service
     */
    public MomsangivelseStatusHentClient(String endpointURL, String policy) {
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
    public MomsangivelseStatusHentOType invoke(String document, String certicateAlias, boolean overrideHovedoplysninger)
            throws IOException, DatatypeConfigurationException, JAXBException {

        configureBus(certicateAlias);

        MomsangivelseStatusHentServiceBindingQSService service = new MomsangivelseStatusHentServiceBindingQSService();
        MomsangivelseStatusHentServicePortType port = service.getMomsangivelseStatusHentServiceBindingQSPort();

        // Set endpoint of service.
        BindingProvider bp = (BindingProvider) port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpointURL);

        InputStream inputStream = IOUtils.toInputStream(document, "UTF-8");
        MomsangivelseStatusHentIType momsangivelseStatusHentIType = MomsangivelseStatusHentMarshalling.toObject(inputStream);

        if (overrideHovedoplysninger) {
            momsangivelseStatusHentIType.getHovedOplysninger().setTransaktionIdentifikator(TransactionIdGenerator.getTransactionId());
            momsangivelseStatusHentIType.getHovedOplysninger().setTransaktionTid(getTransactionTime());
            LOGGER.info("HovedOplysninger populated with new Transaction Id and Time");
        }

        MomsangivelseStatusHentOType out = port.getMomsangivelseStatusHent(momsangivelseStatusHentIType);
        return out;
    }

}
