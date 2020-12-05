package tests.testrail.demoqa;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.demoqa.ElementButtonsPage;

import java.net.MalformedURLException;

public class ElementButtonsTest {

    private ElementButtonsPage buttonsBlock = new ElementButtonsPage();

    @Given("Open buttons block")
    public void openButtonsBlockTest() throws MalformedURLException {
        buttonsBlock.openButtonsBlock();
    }

    @When("Make doubleClick")
    public void makeDoubleClickTest() throws MalformedURLException {
        buttonsBlock.makeDoubleClick();
    }

    @Then("Check doubleClick")
    public void checkDoubleClickTest() throws MalformedURLException {
        buttonsBlock.checkDoubleClick();
    }
}
