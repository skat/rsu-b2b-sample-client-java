package dk.skat.rsu.b2b.sample.mvc;

import com.opensymphony.xwork2.ActionSupport;
import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.AdvisStrukturType;
import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.FejlStrukturType;
import dk.skat.rsu.b2b.sample.ModtagMomsangivelseForeloebigClient;
import dk.skat.rsu.b2b.sample.MomsangivelseKvitteringHentClient;
import dk.skat.rsu.b2b.sample.MomsangivelseKvitteringHentMarshalling;
import dk.skat.rsu.b2b.sample.VirksomhedKalenderHentClient;
import oio.skat.nemvirksomhed.ws._1_0.ModtagMomsangivelseForeloebigOType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentIType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentOType;
import org.apache.commons.io.IOUtils;
import org.springframework.util.StringUtils;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

/**
 * ServiceTestAction
 *
 * @author SKAT
 * @since 1.0
 */
public class ServiceTestAction extends ActionSupport {

    private static final Logger LOGGER = Logger.getLogger(ServiceTestAction.class.getName());
    private ServiceTestForm serviceTestForm;
    private String serviceResponse;

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
        return SUCCESS;
    }


    @Override
    public String execute()
            throws Exception {

        if (serviceTestForm == null){
            this.serviceTestForm = new ServiceTestForm();
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
                System.out.println("enpoint = " + endpoint);
                System.out.println("policy = " + policy);
                System.out.println("requestAsString = " + requestAsString);
                System.out.println("cert = " + cert);
                System.out.println("this.serviceTestForm.isOverrideTxInfo() = " + this.serviceTestForm.isOverrideTxInfo());
                System.out.println("serviceResponse = " + serviceResponse);
            }
            if ("ModtagMomsangivelseForeloebig".equals(service)) {
                ModtagMomsangivelseForeloebigClient client = new ModtagMomsangivelseForeloebigClient(endpoint, policy);
                serviceResponse = client.invoke(requestAsString, cert, this.serviceTestForm.isOverrideTxInfo());
                // Get receipt and store PDF in memory for later download
                InputStream inputStream = IOUtils.toInputStream(serviceResponse, "UTF-8");
                JAXBContext jc = JAXBContext.newInstance(ModtagMomsangivelseForeloebigOType.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                ModtagMomsangivelseForeloebigOType asObject = (ModtagMomsangivelseForeloebigOType) unmarshaller.unmarshal(inputStream);
                if (asObject.getDybtlink() != null) {
                    addActionMessage("confirmUrl" + asObject.getDybtlink().getUrlIndicator());
                }
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
                        String message = "[" + advisStrukturType.getAdvisIdentifikator().toString() + "]" + advisStrukturType.getAdvisTekst();
                        String advisId = advisStrukturType.getAdvisIdentifikator().toString();
                        if ("4810".equals(advisId) || "4812".equals(advisId)) {
                            // 4810 = VAT return has yet to be approved in self service app.
                            addActionMessage("error.test.response.failed" + message);
                            failed = true;
                        }
                    }
                    if (o instanceof FejlStrukturType) {
                        FejlStrukturType fejlStrukturType = (FejlStrukturType) o;
                        String message = fejlStrukturType.getFejlIdentifikator().toString() + fejlStrukturType.getFejlTekst();
                        addActionMessage("error.test.response.failed" + message);
                        failed = true;
                    }
                }
                if (!failed && asObject.getPDFkvittering() != null) {
                    Receipt receipt = new Receipt();
                    receipt.setTransactionId(receiptTransactionId);
                    receipt.setReceipt(asObject.getPDFkvittering().getDokumentFilIndholdData());
                    ReceiptsStorage.put(receipt);
                    addActionMessage("downloadReceipt" + receipt.getTransactionId());
                }
            }
            addActionMessage("lastResponse"+serviceResponse);
        } catch (Exception e) {
            e.printStackTrace();
            serviceResponse = e.getMessage();
            addActionMessage("error.test.request.failed" + serviceResponse);
        }

        this.serviceResponse = serviceResponse;
        LOGGER.info("response = " + serviceResponse);
        return "success";
    }


}
