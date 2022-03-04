package dk.skat.rsu.b2b.sample.mvc;

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
import org.apache.struts.action.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Logger;

/**
 * ServiceTestAction
 *
 * @author SKAT
 * @since 1.0
 */
public class ServiceTestAction extends Action {

    private static final Logger LOGGER = Logger.getLogger(ServiceTestAction.class.getName());

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ServiceTestForm serviceTestForm = (ServiceTestForm)form;

        LOGGER.info("Testing service : " + serviceTestForm.getService());
        LOGGER.info("Testing environment : " + serviceTestForm.getEnvironment());
        LOGGER.info("Testing certificate : " + serviceTestForm.getCertificateAlias());
        LOGGER.info("Testing overrideTxInfo : " + serviceTestForm.isOverrideTxInfo());
        LOGGER.info("Testing request : " + serviceTestForm.getRequest());

        ActionMessages messages = new ActionMessages();
        String service =  serviceTestForm.getService();
        String environment =  serviceTestForm.getEnvironment();
        String cert =  serviceTestForm.getCertificateAlias();
        String requestAsString = serviceTestForm.getRequest();
        String configurationPrefix = "endpoints." + environment + "." + service;

        String serviceResponse = "";
        try {
            String endpoint = ConfigHelper.getConfiguration().getString(configurationPrefix);

            String policy = serviceTestForm.getPolicy();
            if (StringUtils.hasText(policy)) {
                // Go for default defined in config
                policy = ConfigHelper.getConfiguration().getString("policy");
            }

            if ("VirksomhedKalenderHent".equals(service)) {
                VirksomhedKalenderHentClient client = new VirksomhedKalenderHentClient(endpoint, policy);
                serviceResponse = client.invoke(requestAsString, cert, serviceTestForm.isOverrideTxInfo());
            }
            if ("ModtagMomsangivelseForeloebig".equals(service)) {
                ModtagMomsangivelseForeloebigClient client = new ModtagMomsangivelseForeloebigClient(endpoint, policy);
                serviceResponse = client.invoke(requestAsString, cert, serviceTestForm.isOverrideTxInfo());
                // Get receipt and store PDF in memory for later download
                InputStream inputStream = IOUtils.toInputStream(serviceResponse, "UTF-8");
                JAXBContext jc = JAXBContext.newInstance(ModtagMomsangivelseForeloebigOType.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                ModtagMomsangivelseForeloebigOType asObject = (ModtagMomsangivelseForeloebigOType) unmarshaller.unmarshal(inputStream);
                if (asObject.getDybtlink() != null) {
                    messages.add("confirmUrl",
                            new ActionMessage("confirmUrl", asObject.getDybtlink().getUrlIndicator()));
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

                serviceResponse =  client.invoke(requestAsString, cert, serviceTestForm.isOverrideTxInfo());

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
                            messages.add("common.test.resp.err",
                                    new ActionMessage("error.test.response.failed", message));
                            failed = true;
                        }
                    }
                    if (o instanceof FejlStrukturType) {
                        FejlStrukturType fejlStrukturType = (FejlStrukturType) o;
                        String message = fejlStrukturType.getFejlIdentifikator().toString() + fejlStrukturType.getFejlTekst();
                        messages.add("common.test.resp.err",
                                new ActionMessage("error.test.response.failed", message));
                        failed = true;
                    }
                }
                if (!failed && asObject.getPDFkvittering() != null) {
                    Receipt receipt = new Receipt();
                    receipt.setTransactionId(receiptTransactionId);
                    receipt.setReceipt(asObject.getPDFkvittering().getDokumentFilIndholdData());
                    ReceiptsStorage.put(receipt);
                    messages.add("downloadReceipt",
                            new ActionMessage("downloadReceipt", receipt.getTransactionId()));
                }
            }
            messages.add("lastResponse",
                    new ActionMessage("lastResponse", serviceResponse));
        } catch (Exception e) {
            e.printStackTrace();
            serviceResponse = e.getMessage();
            messages.add("common.test.resp.err",
                    new ActionMessage("error.test.request.failed", serviceResponse));
        }
        saveErrors(request.getSession(), messages);
        ActionForward forward = mapping.findForward("success");
        return forward;
    }


}
