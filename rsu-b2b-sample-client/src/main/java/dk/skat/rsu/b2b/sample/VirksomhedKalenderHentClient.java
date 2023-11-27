package dk.skat.rsu.b2b.sample;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.ws.BindingProvider;
import oio.skat.nemvirksomhed.ws._1_0.VirksomhedKalenderHentIType;
import oio.skat.nemvirksomhed.ws._1_0.VirksomhedKalenderHentOType;
import oio.skat.nemvirksomhed.ws._1_0_0.VirksomhedKalenderHentServiceBindingQSService;
import oio.skat.nemvirksomhed.ws._1_0_0.VirksomhedKalenderHentServicePortType;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import  org.apache.commons.io.IOUtils;

/**
 * VirksomhedKalenderHentClient
 *
 * @author SKAT
 * @since 1.0
 */
public class VirksomhedKalenderHentClient extends BaseClient {

    private static final Logger LOGGER = Logger.getLogger(VirksomhedKalenderHentClient.class.getName());

    private String endpointURL;

    /**
     * Private constructor
     */
    private VirksomhedKalenderHentClient() {
    }

    /**
     * Constructor
     *
     * @param endpointURL Endpoint of VirksomhedKalenderHent service
     */
    public VirksomhedKalenderHentClient(String endpointURL, String policy) {
        super(policy);
        this.endpointURL = endpointURL;
    }

    /**
     * Call VirksomhedKalenderHent service
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

        VirksomhedKalenderHentServiceBindingQSService service = new VirksomhedKalenderHentServiceBindingQSService();
        VirksomhedKalenderHentServicePortType port = service.getVirksomhedKalenderHentServiceBindingQSPort();
        // Set endpoint of service.
        BindingProvider bp = (BindingProvider)port;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpointURL);

        InputStream inputStream = IOUtils.toInputStream(document, "UTF-8");
        VirksomhedKalenderHentIType virksomhedKalenderHentIType = VirksomhedKalenderHentMarshalling.toObject(inputStream);

        if (overrideHovedoplysninger) {
            virksomhedKalenderHentIType.getHovedOplysninger().setTransaktionIdentifikator(TransactionIdGenerator.getTransactionId());
            virksomhedKalenderHentIType.getHovedOplysninger().setTransaktionTid(getTransactionTime());
            LOGGER.info("HovedOplysninger populated with new Transaction Id and Time");
        }
        VirksomhedKalenderHentOType out = port.getVirksomhedKalenderHent(virksomhedKalenderHentIType);
        return VirksomhedKalenderHentMarshalling.toString(out);
    }



}
