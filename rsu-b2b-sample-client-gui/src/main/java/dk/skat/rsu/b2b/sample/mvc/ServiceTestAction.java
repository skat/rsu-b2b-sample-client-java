package dk.skat.rsu.b2b.sample.mvc;

import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.AdvisStrukturType;
import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.FejlStrukturType;
import dk.skat.rsu.b2b.sample.ModtagMomsangivelseForeloebigClient;
import dk.skat.rsu.b2b.sample.MomsangivelseKvitteringHentClient;
import dk.skat.rsu.b2b.sample.MomsangivelseKvitteringHentMarshalling;
import dk.skat.rsu.b2b.sample.VirksomhedKalenderHentClient;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentIType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentOType;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;

import java.util.logging.Logger;
import java.io.Serializable;
/**
 * ServiceTestAction
 *
 * @author SKAT
 * @since 1.0
 */

public class ServiceTestAction implements Serializable{

    private static final Logger LOGGER = Logger.getLogger(ServiceTestAction.class.getName());
    private ServiceTestForm serviceTestForm;
    private String serviceResponse;
    private String tID;

    public String gettID() {
        return tID;
    }

    public void settID(String tID) {
        this.tID = tID;
    }

    public String getServiceResponse() {
        return serviceResponse;
    }

    public void setServiceResponse(String serviceResponse) {
        this.serviceResponse = serviceResponse;
    }

    public ServiceTestForm getServiceTestForm() {
        return serviceTestForm;
    }

    public void setServiceTestForm(ServiceTestForm serviceTestForm) {
        this.serviceTestForm = serviceTestForm;
    }

    public String init()
            throws Exception {
        this.serviceTestForm = new ServiceTestForm();
        return "success";
    }


    public String execute(ServiceTestForm serviceTestForm1)
            throws Exception {

        this.tID = "";

        if (this.serviceTestForm == null){
            this.setServiceTestForm(serviceTestForm1);
        }

        LOGGER.info("Testing service : " + this.serviceTestForm.getService());
        LOGGER.info("Testing environment : " + this.serviceTestForm.getEnvironment());
        LOGGER.info("Testing certificate : " + this.serviceTestForm.getCertificateAlias());
        LOGGER.info("Testing overrideTxInfo : " + this.serviceTestForm.isOverrideTxInfo());
        LOGGER.info("Testing request : " + this.serviceTestForm.getRequest());
        LOGGER.info("Testing services : " + this.serviceTestForm.getServices().toString());
        LOGGER.info("Testing environments : " + this.serviceTestForm.getEnvironments().toString());
        LOGGER.info("Testing certificates : " + this.serviceTestForm.getCertificates().toString());
        LOGGER.info("Testing policies : " + this.serviceTestForm.getPoliciesList().toString());


        String service =  this.serviceTestForm.getService();
        String environment =  this.serviceTestForm.getEnvironment();
        String cert =  this.serviceTestForm.getCertificateAlias();
        String requestAsString = this.serviceTestForm.getRequest();
        String configurationPrefix = "endpoints." + environment + "." + service;


        String serviceResponse = "";
        try {
            String endpoint = ConfigHelper.getConfiguration().getString(configurationPrefix);
            String policy = this.serviceTestForm.getPolicy();
            if (!StringUtils.hasText(policy)) {
                // Go for default defined in config
                policy = ConfigHelper.getConfiguration().getString("policy");
            }

            if ("VirksomhedKalenderHent".equals(service)) {
                VirksomhedKalenderHentClient client = new VirksomhedKalenderHentClient(endpoint, policy);
                serviceResponse = client.invoke(requestAsString, cert, this.serviceTestForm.isOverrideTxInfo());
            }
            if ("ModtagMomsangivelseForeloebig".equals(service)) {
                ModtagMomsangivelseForeloebigClient client = new ModtagMomsangivelseForeloebigClient(endpoint, policy);
                serviceResponse = client.invoke(requestAsString, cert, this.serviceTestForm.isOverrideTxInfo());

            }
            if ("MomsangivelseKvitteringHent".equals(service)) {
                MomsangivelseKvitteringHentClient client = new MomsangivelseKvitteringHentClient(endpoint, policy);

                // The following code is more elaborate than the two above service calls.
                //
                // We extract the requested Transaction Id (was returned by ModtagMomsangivelseForeloebig) and
                // then store the PDF receipt - if returned - by this id for download buy the user.
                // This is primarily done to avoid the tester Base64 decode the PDF in another system.
                MomsangivelseKvitteringHentIType requestAsObject = MomsangivelseKvitteringHentMarshalling.toObject(requestAsString);
                String receiptTransactionId = requestAsObject.getTransaktionIdentifier();

                serviceResponse =  client.invoke(requestAsString, cert, this.serviceTestForm.isOverrideTxInfo());

                // Get receipt and store PDF in memory for later download
                InputStream inputStream = IOUtils.toInputStream(serviceResponse, "UTF-8");
                JAXBContext jc = JAXBContext.newInstance(MomsangivelseKvitteringHentOType.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                MomsangivelseKvitteringHentOType asObject = (MomsangivelseKvitteringHentOType) unmarshaller.unmarshal(inputStream);

                List<Object> advisStrukturOrFejlStruktur = asObject.getHovedOplysningerSvar().getSvarStruktur().getAdvisStrukturOrFejlStruktur();
                boolean failed = false;
                for (Object o : advisStrukturOrFejlStruktur) {
                    if (o instanceof AdvisStrukturType) {
                        AdvisStrukturType advisStrukturType = (AdvisStrukturType) o;
                        String advisId = advisStrukturType.getAdvisIdentifikator().toString();
                        if ("4810".equals(advisId) || "4812".equals(advisId)) {
                            // 4810 = VAT return has yet to be approved in self service app.
                            failed = true;
                        }
                    }
                    if (o instanceof FejlStrukturType) {
                        failed = true;
                    }
                }
                if (!failed && asObject.getPDFkvittering() != null) {
                    Receipt receipt = new Receipt();
                    receipt.setTransactionId(receiptTransactionId);
                    receipt.setReceipt(asObject.getPDFkvittering().getDokumentFilIndholdData());
                    ReceiptsStorage.put(receipt);
                    this.tID = receiptTransactionId;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            serviceResponse = e.getMessage();
        }

        this.serviceResponse = serviceResponse;
        LOGGER.info("response = " + serviceResponse);
        return "success";
    }
}
