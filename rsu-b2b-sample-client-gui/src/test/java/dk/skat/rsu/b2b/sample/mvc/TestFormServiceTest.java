package dk.skat.rsu.b2b.sample.mvc;

import junit.framework.TestCase;

import java.util.HashMap;

public class TestFormServiceTest extends TestCase {

    public void testForm() {
        // Just basic test form creation is OK
        ServiceTestForm serviceTestForm = new ServiceTestForm();
        assertEquals("TFE", ((HashMap<String,String>) serviceTestForm.getEnvironments()).get("TFE"));
    }

}
