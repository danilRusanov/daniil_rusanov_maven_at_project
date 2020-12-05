package tests.testrail.demoqa;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pages.demoqa.ElementTextPage;

import java.net.MalformedURLException;

public class ElementTextTest {

    private ElementTextPage elementText = new ElementTextPage();
    private Logger logger = Logger.getLogger(ElementTextTest.class);


    @Given("Open Text Box form")
    public void openTextBox() {

        try {
            elementText.refresh();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @Given("Input {string} in Full name field")
    public void fillFullName(String fullName) {

        try {
            elementText.inputFullName(fullName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    @When("Click Submit button")
    public void clickSubmitButton() {
        elementText.submitButton();
    }


    @Then("Check {string} in Result block")
    public void checkResultBlock(String value) {

        try {
            elementText.resultForm(value);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


//    @Test
//    public void submitButtonTest() throws MalformedURLException {
//        elementText.inputFullName("Daniil Ru");
//        elementText.submitButton();
//        elementText.resultForm("Daniil Ru");
//    }

}
