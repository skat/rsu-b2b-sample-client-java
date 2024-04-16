package dk.skat.rsu.b2b.sample.mvc;

import com.typesafe.config.Config;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ServiceTestForm
 *
 * @author SKAT
 * @since 1.0
 */

public class ServiceTestForm implements Serializable {

    private String environment;

    private String service;

    private String certificateAlias;

    private String policy;

    private String request;

    private String requestMMF;

    private String requestMKH;

    private String requestVKH;

    private String requestMSH;

    private boolean overrideTxInfo;

    private Map<String,String> services;

    private Map<String,String> environments;

    private Map<String,String> certificates;

    private Map<String,String> policiesList;

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

    public Map<String, String> getServices() {
        return services;
    }

    public void setServices(HashMap<String, String> services) {
        this.services = services;
    }

    public Map<String, String> getEnvironments() {
        return environments;
    }

    public void setEnvironments(HashMap<String, String> environments) {
        this.environments = environments;
    }

    public Map<String, String> getCertificates() {
        return certificates;
    }

    public void setCertificates(HashMap<String, String> certificates) {
        this.certificates = certificates;
    }

    public Map<String, String> getPoliciesList() {
        return policiesList;
    }

    public void setPoliciesList(HashMap<String, String> policiesList) {
        this.policiesList = policiesList;
    }

    public String getRequestMMF() { return requestMMF; }

    public void setRequestMMF(String requestMMF) { this.requestMMF = requestMMF; }

    public String getRequestMKH() { return requestMKH; }

    public void setRequestMKH(String requestMKH) { this.requestMKH = requestMKH; }

    public String getRequestVKH() { return requestVKH; }

    public void setRequestVKH(String requestVKH) { this.requestVKH = requestVKH; }

    public String getRequestMSH() {
        return requestMSH;
    }

    public void setRequestMSH(String requestMSH) {
        this.requestMSH = requestMSH;
    }

    public ServiceTestForm() {
        try {
            services = new HashMap<String,String>();
            certificates = new HashMap<String,String>();
            environments = new HashMap<String,String>();
            policiesList = new HashMap<String,String>();
            Config config = ConfigHelper.getConfiguration();
            for (String service : config.getStringList("services")) {
                services.put(service,service);
            }
            for (String environment : config.getStringList("environments")) {
                environments.put(environment,environment);
            }
            List<String> activeAliases = config.getStringList("activeCertificates");
            for (String alias : activeAliases) {
                certificates.put(alias,config.getString("certificateCommenNames." + alias));
            }
            policiesList.put("rsu-policy-sign.xml","Timestamp-Sign");
            policiesList.put("rsu-policy.xml","Timestamp-Sign-Encrypt");

            // set default values
            this.service = config.getString("default.service");
            this.environment = config.getString("default.environment");
            this.policy = config.getString("default.policy");
            this.certificateAlias = config.getString("default.certificateAlias");
            // Just a sample request to get started!
            requestMMF = getDocument("ModtagMomsangivelseForeloebig_I_Sample.xml");
            requestMKH = getDocument("MomsangivelseKvitteringHent_I_Sample.xml");
            requestVKH = getDocument("VirksomhedKalenderHent_I_Sample.xml");
            requestMSH = getDocument("MomsangivelseStatusHent_I_Sample.xml");
            request = requestVKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getDocument(String filename) throws IOException {
        String document = "";
        InputStream resource = new ClassPathResource(
                filename).getInputStream();
        try ( BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource)) ) {
            document = reader.lines()
                    .collect(Collectors.joining("\n"));
        }
        return document;
    }
}
