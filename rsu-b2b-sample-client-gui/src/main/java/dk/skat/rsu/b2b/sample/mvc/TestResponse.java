package dk.skat.rsu.b2b.sample.mvc;

import java.io.Serializable;

public class TestResponse implements Serializable {
    private String serviceResponse;
    private String tID;
    private String deepLink;

    public String getDeepLink() {
        return deepLink;
    }

    public void setDeepLink(String deepLink) {
        this.deepLink = deepLink;
    }

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

    public TestResponse(){
        this.settID("");
        this.setDeepLink("");
    }
}
