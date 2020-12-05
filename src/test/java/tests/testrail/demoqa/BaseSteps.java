package tests.testrail.demoqa;

import drivers.ThreadsDriver;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.After;

import java.net.MalformedURLException;

public class BaseSteps {
    private static final Logger LOGGER = Logger.getLogger(BaseSteps.class);

//    @Before
//    public void doBefore(){
//        LOGGER.info("Test started");
//        ThreadLocalDriver.getWebDriver().get("https://demoqa.com/");
//
//        WebDriverWait wait = new WebDriverWait(ThreadLocalDriver.getWebDriver(), 3);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='category-cards']/div[1]")));
//        LOGGER.debug("Click on Elements section");
//        ThreadLocalDriver.getWebDriver().findElement(By.xpath("//div[@class='category-cards']/div[1]")).click();
//    }

    @Then("Close browser")
    public void doAfter() throws MalformedURLException {
        LOGGER.info("Test finished");
        ThreadsDriver.setThreadLocalWebDriver();
    }
}
