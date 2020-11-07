package runners.junit4;


import drivers.ThreadsDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.mail.VoidCreateTrashMailAccTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        VoidCreateTrashMailAccTest.class
})
public class JUnitRunner {

    @Before
    public void initDriver() {
        ThreadsDriver.getWebDriver().get("");
    }

    @After
    public void closeDriver() {
        ThreadsDriver.getWebDriver().close();
        ThreadsDriver.setThreadLocalWebDriver();
    }

}
