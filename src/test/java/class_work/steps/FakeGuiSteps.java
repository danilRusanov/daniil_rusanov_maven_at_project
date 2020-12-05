package class_work.steps;

import drivers.ThreadsDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

import java.net.MalformedURLException;

public class FakeGuiSteps {

    private static final Logger LOGGER = Logger.getLogger(FakeGuiSteps.class);

    @Given("I go to Tut.by")
    public void goToUrlStep() throws MalformedURLException {
        LOGGER.info("I go to Tut.by");
//        ThreadsDriver.getWebDriver().get("https://tut.by");
    }


    @When("I start waitng")
    public void iWaitStep() throws InterruptedException {
        LOGGER.info("I start waitng");
        Thread.sleep(3000);
    }

    @Then("I just passed")
    public void justPassedStep() {
        LOGGER.info("I passed");
        Assert.assertTrue(true);
    }

    @Then("I just fail")
    public void justFailedStep() {
        LOGGER.info("I passed");
        Assert.assertTrue(false);
    }


}
