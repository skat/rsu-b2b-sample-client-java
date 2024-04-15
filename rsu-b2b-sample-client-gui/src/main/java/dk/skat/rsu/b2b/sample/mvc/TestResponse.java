package dk.skat.rsu.b2b.sample.mvc;

import java.io.Serializable;

public class TestResponse implements Serializable {
    private String serviceResponse;
    private String transactionId;
    private String deepLink;

    public String getDeepLink() {
        return deepLink;
    }

    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getServiceResponse() {
        return serviceResponse;
    }

    public void setServiceResponse(String serviceResponse) {
        this.serviceResponse = serviceResponse;
    }

}
