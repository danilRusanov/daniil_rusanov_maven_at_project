package tests.testrail.demoqa;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pages.demoqa.ElementCheckBoxPage;

import java.net.MalformedURLException;

public class ElementCheckBoxTest {
    private static final Logger LOGGER = Logger.getLogger(ElementCheckBoxTest.class);
    private ElementCheckBoxPage checkBoxBlock = new ElementCheckBoxPage();

    @Given("Open checkBox form")
    public void openCheckBoxBlockTest() throws MalformedURLException {
        checkBoxBlock.openCheckBoxBlock();
    }


    @When("Open Home structure")
    public void openHomeStructureTest() throws MalformedURLException {
        checkBoxBlock.openHomeStructure();
    }

    @When("Select Home check-box")
    public void selectHomeCheckBoxTest() throws MalformedURLException {
        checkBoxBlock.selectHomeCheckBox();
    }

    @Then("All check-boxes are selected")
    public void allCheckBoxesAreSelectedTest() throws MalformedURLException {
        checkBoxBlock.allCheckBoxesAreSelected();
    }


    @Then("Selected check-boxes are in result message")
    public void resultMessage() throws MalformedURLException {
        checkBoxBlock.resultMessage();
    }
}
