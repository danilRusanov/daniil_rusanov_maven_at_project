package pages.demoqa;

import drivers.ThreadsDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;

public class ElementButtonsPage {
    private static final Logger LOGGER = Logger.getLogger(ElementButtonsPage.class);
    private Actions make;
    private WebElement doubleClickBtn;
    private WebElement rightClickBtn;
    private WebElement clickBtn;

    {
        try {
            make = new Actions(ThreadsDriver.getWebDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public void openButtonsBlock() throws MalformedURLException {
//        logger.debug(ThreadsDriver.getWebDriver().get("https://demoqa.com/elements"));
        LOGGER.info("openButtonsBlock");
        ThreadsDriver.getWebDriver().get("https://demoqa.com/buttons");
    }


    public void makeDoubleClick() throws MalformedURLException {

        doubleClickBtn = ThreadsDriver.getWebDriver().findElement(By.xpath("//button[@id= 'doubleClickBtn']"));
        make.doubleClick(doubleClickBtn).perform();

    }


    public void checkDoubleClick() throws MalformedURLException {

        Assert.assertTrue("Double click doesn't work",
                ThreadsDriver.getWebDriver()
                        .findElement(By.xpath("//p[@id='doubleClickMessage']"))
                        .getText()
                        .equals("You have done a double click"));

    }

    public void rightClickBtn() throws MalformedURLException {

        rightClickBtn = ThreadsDriver.getWebDriver().findElement(By.xpath("//button[@id= '']"));
        make.doubleClick(rightClickBtn).perform();

    }
}
