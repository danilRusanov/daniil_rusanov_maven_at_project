package pages.demoqa;

import drivers.ThreadsDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.List;

public class ElementCheckBoxPage {
    private static final Logger LOGGER = Logger.getLogger(ElementCheckBoxPage.class);
    private List<WebElement> checkboxes;

    {
        try {
            checkboxes = ThreadsDriver.getWebDriver()
                    .findElements(By.xpath("//span[@class='rct-checkbox']"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void openCheckBoxBlock() throws MalformedURLException {
        LOGGER.info("openCheckBoxBlock starts");
        ThreadsDriver.getWebDriver().get("https://demoqa.com/checkbox");
    }


    public void openHomeStructure() throws MalformedURLException {
        LOGGER.info("openHomeStructure starts");
        ThreadsDriver.getWebDriver().findElement(By.xpath("//button[@title='Toggle']")).click();
    }


    public void selectHomeCheckBox() throws MalformedURLException {
        LOGGER.info("selectHomeCheckBox starts");
        ThreadsDriver.getWebDriver().findElement(By.xpath("//span[@class='rct-checkbox']")).click();
//        LOGGER.debug("");
        Assert.assertTrue("Home check-box isn't selected",
                !ThreadsDriver.getWebDriver().findElement(By.xpath("//span[@class='rct-checkbox']")).getAttribute("class").contains("unchecked")
                );
    }


    public void allCheckBoxesAreSelected() throws MalformedURLException {
        Boolean allCheckBoxSelected = checkboxes.stream()
                .filter(x -> x.getAttribute("class")
                        .contains("unchecked"))
                .count() > 0
                ? false
                : true;

        Assert.assertTrue("Unfortunately not all check-boxes were selected", allCheckBoxSelected);
//                        forEach(checkBox -> checkBox.getAttribute("class").contains("unchecked") ? );
    }


    public void resultMessage() throws MalformedURLException {

        new WebDriverWait(ThreadsDriver.getWebDriver(), 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='result']")));

        Assert.assertTrue("At least one check-boxes wasn't selected",
                (checkboxes.size() == ThreadsDriver.getWebDriver().findElements(By.xpath("//span[@class='text-success']")).size()));

    }

}
