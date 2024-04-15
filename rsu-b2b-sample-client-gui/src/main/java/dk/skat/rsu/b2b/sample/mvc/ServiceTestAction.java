package dk.skat.rsu.b2b.sample.mvc;

import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.AdvisStrukturType;
import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.FejlStrukturType;
import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.HovedOplysningerSvarType;
import dk.skat.rsu.b2b.sample.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import oio.skat.nemvirksomhed.ws._1_0.ModtagMomsangivelseForeloebigOType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentIType;
import oio.skat.nemvirksomhed.ws._1_0.MomsangivelseKvitteringHentOType;
import oio.skat.nemvirksomhed.ws._1_0.VirksomhedKalenderHentOType;
import org.apache.commons.io.IOUtils;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import java.util.logging.Logger;
import java.io.Serializable;
/**
 * ServiceTestAction
 *
 * @author SKAT
 * @since 1.0
 */

public class ServiceTestAction implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(ServiceTestAction.class.getName());
    private ServiceTestForm serviceTestForm;

    public void setServiceTestForm(ServiceTestForm serviceTestForm) {
        this.serviceTestForm = serviceTestForm;
    }

    public TestResponse execute(ServiceTestForm serviceTestForm1, MessageContext context)
            throws Exception {

        TestResponse testResponse = new TestResponse();

        testResponse.setDeepLink("");
        testResponse.setTransactionId("");

        if (this.serviceTestForm == null) {
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
                VirksomhedKalenderHentOType out = client.invoke(requestAsString, cert, this.serviceTestForm.isOverrideTxInfo());
                serviceResponse = VirksomhedKalenderHentMarshalling.toString(out);
                if (out != null && out.getHovedOplysningerSvar() != null) {
                    addMessages(out.getHovedOplysningerSvar(), context);
                }
            }
            if ("ModtagMomsangivelseForeloebig".equals(service)) {
                ModtagMomsangivelseForeloebigClient client = new ModtagMomsangivelseForeloebigClient(endpoint, policy);
                ModtagMomsangivelseForeloebigOType out = client.invoke(requestAsString, cert, this.serviceTestForm.isOverrideTxInfo());
                serviceResponse = ModtagMomsangivelseForeloebigMarshalling.toString(out);
                if (out != null && out.getHovedOplysningerSvar() != null) {
                    addMessages(out.getHovedOplysningerSvar(), context);
                }

                // Get receipt and store PDF in memory for later download
                InputStream inputStream = IOUtils.toInputStream(serviceResponse, "UTF-8");
                JAXBContext jc = JAXBContext.newInstance(ModtagMomsangivelseForeloebigOType.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                ModtagMomsangivelseForeloebigOType asObject = (ModtagMomsangivelseForeloebigOType) unmarshaller.unmarshal(inputStream);
                if (asObject.getDybtlink() != null) {
                    testResponse.setDeepLink("Confirm Link: <a href=\"" + asObject.getDybtlink().getUrlIndicator() + "\" target=\"_blank\">" + asObject.getDybtlink().getUrlIndicator() + "</a>");
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

                MomsangivelseKvitteringHentOType asObject = client.invoke(requestAsString, cert, this.serviceTestForm.isOverrideTxInfo());
                serviceResponse = MomsangivelseKvitteringHentMarshalling.toString(asObject);
                // Get receipt and store PDF in memory for later download
                boolean failed = false;
                if (asObject != null && asObject.getHovedOplysningerSvar() != null) {
                    addMessages(asObject.getHovedOplysningerSvar(), context);
                    List<Object> advisStrukturOrFejlStruktur = asObject.getHovedOplysningerSvar().getSvarStruktur().getAdvisStrukturOrFejlStruktur();
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
                }
                if (!failed && asObject.getPDFkvittering() != null) {
                    Receipt receipt = new Receipt();
                    receipt.setTransactionId(receiptTransactionId);
                    receipt.setReceipt(asObject.getPDFkvittering().getDokumentFilIndholdData());
                    ReceiptsStorage.put(receipt);
                    testResponse.setTransactionId(receiptTransactionId);
                }
            }
        } catch (Exception e) {
            context.addMessage(new MessageBuilder().info().source("ERROR")
                    .defaultText("Error occurred - see below").build());
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            serviceResponse = sw.toString();
            pw.close();
            sw.close();
        }

        testResponse.setServiceResponse(serviceResponse);
        LOGGER.info("response = " + serviceResponse);
        return testResponse;
    }

    private void addMessages(HovedOplysningerSvarType hovedOplysningerSvarType, MessageContext context) {
        List<Object> advisStrukturOrFejlStruktur = hovedOplysningerSvarType.getSvarStruktur().getAdvisStrukturOrFejlStruktur();
        for (Object o : advisStrukturOrFejlStruktur) {
            if (o instanceof AdvisStrukturType) {
                AdvisStrukturType advisStrukturType = (AdvisStrukturType) o;
                String advisId = advisStrukturType.getAdvisIdentifikator().toString();
                String advisText = advisStrukturType.getAdvisTekst();
                context.addMessage(new MessageBuilder().info().source("INFO")
                        .defaultText(advisId + " - " + advisText).build());
            }
            if (o instanceof FejlStrukturType) {
                FejlStrukturType fejlStrukturType = (FejlStrukturType) o;
                String fejlId = fejlStrukturType.getFejlIdentifikator().toString();
                String fejlText = fejlStrukturType.getFejlTekst();
                context.addMessage(new MessageBuilder().info().source("ERROR")
                        .defaultText(fejlId + " - " + fejlText).build());
            }
        }
    }
}
