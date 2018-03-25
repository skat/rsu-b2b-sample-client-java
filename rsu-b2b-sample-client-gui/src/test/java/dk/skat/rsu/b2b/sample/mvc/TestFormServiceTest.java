package dk.skat.rsu.b2b.sample.mvc;

import junit.framework.TestCase;

public class TestFormServiceTest extends TestCase {

    public void testForm() {
        // Just basic test form creation is OK
        ServiceTestForm serviceTestForm = new ServiceTestForm();
        assertEquals("TFE", ((OptionModel) serviceTestForm.getEnvironments().get(0)).getValue());
    }

}