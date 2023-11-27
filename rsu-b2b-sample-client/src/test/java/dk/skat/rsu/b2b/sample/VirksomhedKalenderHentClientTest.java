package dk.skat.rsu.b2b.sample;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import jakarta.xml.bind.JAXBException;
import oio.skat.nemvirksomhed.ws._1_0.VirksomhedKalenderHentIType;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class VirksomhedKalenderHentClientTest {

    // IMPORTANT: Place 'app.conf' in root of 'rsu-b2b-sample-client' module before run
    @Ignore("Test manually in IDE")
    @Test
    public void testClient() throws JAXBException, DatatypeConfigurationException, IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("VirksomhedKalenderHent_I_Document.xml");
        VirksomhedKalenderHentIType doc = VirksomhedKalenderHentMarshalling.toObject(inputStream);
        String appConf = System.getProperty("user.dir") + File.separator + "app.conf";
        Config config = ConfigFactory.parseFile(new File(appConf)).withFallback(ConfigFactory.load());

        String endpoint = config.getString("endpoints.EMCSTEST_SIGNONLY.VirksomhedKalenderHent");
        String cerAlias = "LucaPacioli_ApS_System_Integrationstest_S1";
        VirksomhedKalenderHentClient client = new VirksomhedKalenderHentClient(endpoint, "rsu-policy-sign-classpath.xml");
        client.invoke(doc, cerAlias, true);

    }
}
