package dk.skat.rsu.b2b.sample.mvc;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * ServiceTestForm
 *
 * @author SKAT
 * @since 1.0
 */
public class ServiceTestForm extends ActionForm {

    private String environment;

    private String service;

    private String certificateAlias;

    private String request;

    private boolean overrideTxInfo;

    private List services;

    private List environments;

    private List certificates;

    public ServiceTestForm() {
        try {
            services = new ArrayList();
            certificates = new ArrayList();
            environments = new ArrayList();
            Config config = ConfigFactory.load();
            for (String service : config.getStringList("services")) {
                services.add(new OptionModel(service, service));
            }
            for (String environment : config.getStringList("environments")) {
                environments.add(new OptionModel(environment, environment));
            }
            List<String> activeAliases = config.getStringList("activeCertificates");
            for (String alias : activeAliases) {
                certificates.add(new OptionModel(alias, config.getString("certificateCommenNames." + alias)));
            }

            // Just a sample request to get started!
            request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<urn:VirksomhedKalenderHent_I xmlns:urn=\"urn:oio:skat:nemvirksomhed:ws:1.0.0\"\n" +
                    "                              xmlns:ns=\"http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/\"\n" +
                    "                              xmlns:ns1=\"http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/\"\n" +
                    "                              xmlns:urn1=\"urn:oio:skat:nemvirksomhed:1.0.0\">\n" +
                    "    <ns:HovedOplysninger>\n" +
                    "        <ns:TransaktionIdentifikator>33593B0D-E7CF-40A2-AE76-530B72DE6AE3</ns:TransaktionIdentifikator>\n" +
                    "        <ns:TransaktionTid>2017-04-24T12:00:00.146+02:00</ns:TransaktionTid>\n" +
                    "    </ns:HovedOplysninger>\n" +
                    "    <ns1:VirksomhedSENummerIdentifikator>12345678</ns1:VirksomhedSENummerIdentifikator>\n" +
                    "    <urn1:AngivelseTypeNavn>qwerty</urn1:AngivelseTypeNavn>\n" +
                    "    <urn:AngivelseBetalingFristHentFra>\n" +
                    "        <urn1:SoegeDatoFraDate>2017-01-01</urn1:SoegeDatoFraDate>\n" +
                    "        <urn1:SoegeDatoTilDate>2017-03-31</urn1:SoegeDatoTilDate>\n" +
                    "    </urn:AngivelseBetalingFristHentFra>\n" +
                    "</urn:VirksomhedKalenderHent_I>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCertificateAlias() {
        return certificateAlias;
    }

    public void setCertificateAlias(String certificateAlias) {
        this.certificateAlias = certificateAlias;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public boolean isOverrideTxInfo() {
        return overrideTxInfo;
    }

    public void setOverrideTxInfo(boolean overrideTxInfo) {
        this.overrideTxInfo = overrideTxInfo;
    }

    public List getServices() {
        return services;
    }

    public void setServices(List services) {
        this.services = services;
    }

    public List getEnvironments() {
        return environments;
    }

    public void setEnvironments(List environments) {
        this.environments = environments;
    }

    public List getCertificates() {
        return certificates;
    }

    public void setCertificates(List certificates) {
        this.certificates = certificates;
    }


    @Override
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        if(getRequest() != null && "".equals(getRequest())) {
            errors.add("common.test.err",
                    new ActionMessage("error.test.request.required"));
            return errors;
        }

        return errors;
    }

}
