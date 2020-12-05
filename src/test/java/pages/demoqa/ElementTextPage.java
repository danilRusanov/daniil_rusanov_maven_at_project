package pages.demoqa;

import class_work.steps.FakeGuiSteps;
import drivers.ThreadsDriver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class ElementTextPage {

    private static final Logger LOGGER = Logger.getLogger(ElementTextPage.class);


    public void refresh() throws MalformedURLException {
//        logger.debug(ThreadsDriver.getWebDriver().get("https://demoqa.com/elements"));
        LOGGER.info("Do Refresh");
        ThreadsDriver.getWebDriver().get("https://demoqa.com/elements");
        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[contains(@class, 'element-list collapse show')]//ul//li[@id='item-0']")).click();
    }

    public void inputFullName(String fullName) throws MalformedURLException {

        LOGGER.info("FullName is visible");

        try {
            ThreadsDriver.getWebDriver().findElement(By.xpath("//input[contains(@id, 'userName')]")).sendKeys(fullName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public void submitButton() {

        LOGGER.info("Sumbit button method started");
        try {
            ThreadsDriver.getWebDriver().findElement(By.xpath("//button[contains(@id, 'submit')]")).click();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void resultForm(String filledValue) throws MalformedURLException {

        LOGGER.info("Result Form block starts");

        WebDriverWait wait = new WebDriverWait(ThreadsDriver.getWebDriver(), 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='output']//p[@id='name']")));

        //div[@id='output']//p[@id='name']
        Assert.assertTrue("Is it True? ",
                ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@id='output']//p[@id='name']")).getText().contains(filledValue));

    }

}
