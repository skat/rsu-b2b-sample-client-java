package dk.skat.rsu.b2b.sample;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * BaseClient
 *
 * @author SKAT
 * @since 1.0
 */
public class BaseClient {

    private String configuration;

    /**
     * Constructor
     */
    public BaseClient() {
        this.configuration = null;
    }

    /**
     * Constructor
     */
    public BaseClient(String policy) {
        this.configuration = policy;
    }

    protected void configureBus(String cert) {
        Bus bus = new SpringBusFactory().createBus(configuration, false);
        for (Object outInterceptor : bus.getOutInterceptors()) {
            if (outInterceptor instanceof WSS4JOutInterceptor) {
                WSS4JOutInterceptor wss4JOutInterceptor = (WSS4JOutInterceptor) outInterceptor;
                wss4JOutInterceptor.getProperties().put("signatureUser", cert);
            }
        }
        BusFactory.setDefaultBus(bus);
    }

    protected XMLGregorianCalendar getTransactionTime() throws DatatypeConfigurationException {
        // Generate Transaction Time
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        XMLGregorianCalendar transactionTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        return transactionTime;
    }




}
