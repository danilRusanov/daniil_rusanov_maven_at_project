package pages.mail;

import drivers.ThreadsDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class VoidCheckGmail {

//    WebDriver driver = new ChromeDriver();

    public void logInGmail(String email, String password) throws InterruptedException {
        ThreadsDriver.getWebDriver().get("https://accounts.google.com/");
        ThreadsDriver.getWebDriver().manage().window().maximize();

        ThreadsDriver.getWebDriver().findElement(By.id("identifierId")).sendKeys(email);
        ThreadsDriver.getWebDriver().findElement(By.id("identifierNext")).click();
        Thread.sleep(2000);
        ThreadsDriver.getWebDriver().findElement(By.xpath("//input[@type='password']")).click();
        Assert.assertTrue("I see password field", ThreadsDriver.getWebDriver().findElement(By.xpath("//input[@type='password']")).isSelected());
        ThreadsDriver.getWebDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        ThreadsDriver.getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ThreadsDriver.getWebDriver().findElement(By.id("passwordNext")).click();

    }

    public void searchLetter(String sender) {

        //div[@data-message-id]//div[@role='button' and @aria-label='Show trimmed content']

        ThreadsDriver.getWebDriver().findElement(By.name("q")).sendKeys(sender);
        ThreadsDriver.getWebDriver().findElement(By.xpath("//button[@aria-label='Search mail']")).click();
        ThreadsDriver.getWebDriver().findElement(By.xpath("//table[@aria-readonly='true']//tr[1]")).click();
        ThreadsDriver.getWebDriver().findElement(By.xpath("//td[contains(@class, 'button-inner')]")).click();
    }



}
