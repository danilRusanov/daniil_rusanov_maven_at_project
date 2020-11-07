package tests.example_classwork;

import drivers.ThreadsDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Example {

    @Before
    public void initDriver() {
        ThreadsDriver.getWebDriver().get("https://demoqa.com/select-menu");
    }

    @After
    public void closeDriver() {
        ThreadsDriver.getWebDriver().close();
        ThreadsDriver.setThreadLocalWebDriver();
    }

    @Test
    public void demoQaTest() throws InterruptedException {

        Select select = new Select(ThreadsDriver.getWebDriver().findElement(By.xpath("//select[@id='oldSelectMenu']")));
        select.selectByValue("6");
        select.selectByVisibleText("Green");
        Thread.sleep(1000);


        Select select2 = new Select(ThreadsDriver.getWebDriver().findElement(By.name("cars")));
        select2.selectByVisibleText("Volvo");
        select2.selectByVisibleText("Audi");
        Thread.sleep(1000);

    }


    @Test
    public void demoQaTest2() throws InterruptedException {

        Select select = new Select(ThreadsDriver.getWebDriver().findElement(By.xpath("//select[@id='oldSelectMenu']")));
        select.selectByValue("6");
        select.selectByVisibleText("Green");
        Thread.sleep(1000);


        Select select2 = new Select(ThreadsDriver.getWebDriver().findElement(By.name("cars")));
        select2.selectByVisibleText("Volvo");
        select2.selectByVisibleText("Audi");
        Thread.sleep(1000);

    }

    @Test
    public void demoQaTest3() throws InterruptedException {

        Select select = new Select(ThreadsDriver.getWebDriver().findElement(By.xpath("//select[@id='oldSelectMenu']")));
        select.selectByValue("6");
        select.selectByVisibleText("Green");
        Thread.sleep(1000);


        Select select2 = new Select(ThreadsDriver.getWebDriver().findElement(By.name("cars")));
        select2.selectByVisibleText("Volvo");
        select2.selectByVisibleText("Audi");
        Thread.sleep(1000);

    }
}
