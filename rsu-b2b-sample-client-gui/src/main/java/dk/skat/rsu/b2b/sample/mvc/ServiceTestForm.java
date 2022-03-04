package dk.skat.rsu.b2b.sample.mvc;

import com.typesafe.config.Config;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedList;
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

    private String policy;

    private String request;
    private String requestMMF;
    private String requestMKH;
    private String requestVKH;

    private boolean overrideTxInfo;

    private List services;

    private List environments;

    private List certificates;

    private List policiesList;

    public ServiceTestForm() {
        try {
            services = new ArrayList();
            certificates = new ArrayList();
            environments = new ArrayList();
            policiesList = new LinkedList();
            Config config = ConfigHelper.getConfiguration();
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

            policiesList.add(new OptionModel("rsu-policy-sign.xml", "Timestamp-Sign"));
            policiesList.add(new OptionModel("rsu-policy.xml", "Timestamp-Sign-Encrypt"));

            String virksomhedSENummerIdentifikator = "12345678";

            // Just a sample request to get started!
            requestMMF = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<ModtagMomsangivelseForeloebig_I 	xmlns=\"urn:oio:skat:nemvirksomhed:ws:1.0.0\"\n" +
                    "									xmlns:ns=\"http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/\"\n" +
                    "									xmlns:ns1=\"http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/\"\n" +
                    "									xmlns:urn=\"urn:oio:skat:nemvirksomhed:1.0.0\">\n" +
                    "  <ns:HovedOplysninger>\n" +
                    "    <ns:TransaktionIdentifikator>62c55920-e4d6-4b1f-a482-5bf201bfbd7e</ns:TransaktionIdentifikator>\n" +
                    "    <ns:TransaktionTid>2022-02-21T14:41:26.478+01:00</ns:TransaktionTid>\n" +
                    "  </ns:HovedOplysninger>\n" +
                    "  <Angivelse>\n" +
                    "    <AngiverVirksomhedSENummer>\n" +
                    "      <ns1:VirksomhedSENummerIdentifikator>" + virksomhedSENummerIdentifikator + "</ns1:VirksomhedSENummerIdentifikator>\n" +
                    "    </AngiverVirksomhedSENummer>\n" +
                    "    <Angivelsesoplysninger>\n" +
                    "      <urn:AngivelsePeriodeFraDato>2017-07-01+02:00</urn:AngivelsePeriodeFraDato>\n" +
                    "      <urn:AngivelsePeriodeTilDato>2017-09-30+02:00</urn:AngivelsePeriodeTilDato>\n" +
                    "    </Angivelsesoplysninger>\n" +
                    "    <Angivelsesafgifter>\n" +
                    "      <urn:MomsAngivelseAfgiftTilsvarBeloeb>1500</urn:MomsAngivelseAfgiftTilsvarBeloeb>\n" +
                    "      <urn:MomsAngivelseKoebsMomsBeloeb>500</urn:MomsAngivelseKoebsMomsBeloeb>\n" +
                    "      <urn:MomsAngivelseSalgsMomsBeloeb>2000</urn:MomsAngivelseSalgsMomsBeloeb>\n" +
                    "    </Angivelsesafgifter>\n" +
                    "  </Angivelse>\n" +
                    "</ModtagMomsangivelseForeloebig_I>";

            requestMKH = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<MomsangivelseKvitteringHent_I 	xmlns=\"urn:oio:skat:nemvirksomhed:ws:1.0.0\"\n" +
                    "								xmlns:ns=\"http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/\"\n" +
                    "								xmlns:urn=\"urn:oio:skat:nemvirksomhed:1.0.0\"\n" +
                    "								xmlns:ns1=\"http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/\">\n" +
                    "  <ns:HovedOplysninger>\n" +
                    "    <ns:TransaktionIdentifikator>53919099-3b28-45d5-81f3-d7fc371e0c25</ns:TransaktionIdentifikator>\n" +
                    "    <ns:TransaktionTid>2022-02-21T14:18:03.431+01:00</ns:TransaktionTid>\n" +
                    "  </ns:HovedOplysninger>\n" +
                    "  <urn:TransaktionIdentifier>f3f772b0-dc02-4af3-bfde-16f1fa04804f</urn:TransaktionIdentifier>\n" +
                    "  <Angiver>\n" +
                    "    <ns1:VirksomhedSENummerIdentifikator>" + virksomhedSENummerIdentifikator + "</ns1:VirksomhedSENummerIdentifikator>\n" +
                    "  </Angiver>\n" +
                    "</MomsangivelseKvitteringHent_I>\n";

            requestVKH = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<urn:VirksomhedKalenderHent_I xmlns:urn=\"urn:oio:skat:nemvirksomhed:ws:1.0.0\"\n" +
                    "                              xmlns:ns=\"http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/\"\n" +
                    "                              xmlns:ns1=\"http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/\"\n" +
                    "                              xmlns:urn1=\"urn:oio:skat:nemvirksomhed:1.0.0\">\n" +
                    "    <ns:HovedOplysninger>\n" +
                    "        <ns:TransaktionIdentifikator>33593B0D-E7CF-40A2-AE76-530B72DE6AE3</ns:TransaktionIdentifikator>\n" +
                    "        <ns:TransaktionTid>2017-04-24T12:00:00.146+02:00</ns:TransaktionTid>\n" +
                    "    </ns:HovedOplysninger>\n" +
                    "    <ns1:VirksomhedSENummerIdentifikator>" + virksomhedSENummerIdentifikator + "</ns1:VirksomhedSENummerIdentifikator>\n" +
                    "    <urn1:AngivelseTypeNavn>qwerty</urn1:AngivelseTypeNavn>\n" +
                    "    <urn:AngivelseBetalingFristHentFra>\n" +
                    "        <urn1:SoegeDatoFraDate>2017-01-01</urn1:SoegeDatoFraDate>\n" +
                    "        <urn1:SoegeDatoTilDate>2017-03-31</urn1:SoegeDatoTilDate>\n" +
                    "    </urn:AngivelseBetalingFristHentFra>\n" +
                    "</urn:VirksomhedKalenderHent_I>";

            request = requestVKH;
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

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
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

    public List getPoliciesList() {
        return policiesList;
    }

    public void setPoliciesList(List policiesList) {
        this.policiesList = policiesList;
    }

    public String getRequestMMF() { return requestMMF; }

    public void setRequestMMF(String requestMMF) { this.requestMMF = requestMMF; }

    public String getRequestMKH() { return requestMKH; }

    public void setRequestMKH(String requestMKH) { this.requestMKH = requestMKH; }

    public String getRequestVKH() { return requestVKH; }

    public void setRequestVKH(String requestVKH) { this.requestVKH = requestVKH; }

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
