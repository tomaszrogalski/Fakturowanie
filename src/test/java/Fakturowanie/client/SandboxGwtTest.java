package Fakturowanie.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "Fakturowanie.Project";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
