package runners.junit4;


import drivers.ThreadsDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.mail.VoidCreateTrashMailAccTest;

import java.net.MalformedURLException;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        VoidCreateTrashMailAccTest.class
})
public class JUnitRunner {

    @Before
    public void initDriver() throws MalformedURLException {
        ThreadsDriver.getWebDriver().get("");
    }

    @After
    public void closeDriver() throws MalformedURLException {
        ThreadsDriver.getWebDriver().close();
        ThreadsDriver.setThreadLocalWebDriver();
    }

}
