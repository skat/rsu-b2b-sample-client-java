package dk.skat.rsu.b2b.sample.mvc;

import dk.skat.rsu.b2b.sample.ModtagMomsangivelseForeloebigClient;
import dk.skat.rsu.b2b.sample.MomsangivelseKvitteringHentClient;
import dk.skat.rsu.b2b.sample.VirksomhedKalenderHentClient;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            if ("VirksomhedKalenderHent".equals(service)) {
                VirksomhedKalenderHentClient client = new VirksomhedKalenderHentClient(endpoint);
                serviceResponse = client.invoke(requestAsString, cert, serviceTestForm.isOverrideTxInfo());
            }
            if ("ModtagMomsangivelseForeloebig".equals(service)) {
                ModtagMomsangivelseForeloebigClient client = new ModtagMomsangivelseForeloebigClient(endpoint);
                serviceResponse = client.invoke(requestAsString, cert, serviceTestForm.isOverrideTxInfo());
            }
            if ("MomsangivelseKvitteringHent".equals(service)) {
                MomsangivelseKvitteringHentClient client = new MomsangivelseKvitteringHentClient(endpoint);
                serviceResponse =  client.invoke(requestAsString, cert, serviceTestForm.isOverrideTxInfo());
            }
            messages.add("lastResponse",
                    new ActionMessage("lastResponse", serviceResponse));
        } catch (Exception e) {
            e.printStackTrace();
            serviceResponse = e.getMessage();
            messages.add("common.call.err",
                    new ActionMessage("error.test.request.failed", serviceResponse));
        }
        saveErrors(request.getSession(), messages);
        ActionForward forward = mapping.findForward("success");
        return forward;
    }


}
