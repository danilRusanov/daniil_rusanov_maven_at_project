package pages.mail;

import drivers.ThreadsDriver;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class VoidCheckMail {

    public void loginMail(String email, String password) {

        ThreadsDriver.getWebDriver().get("https://mail.ru/");

        ThreadsDriver.getWebDriver().findElement(By.id("mailbox:login-input")).sendKeys(email);
        ThreadsDriver.getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ThreadsDriver.getWebDriver().findElement(By.xpath("//input[@class='o-control']")).click();
        ThreadsDriver.getWebDriver().findElement(By.id("mailbox:password-input")).sendKeys(password);
        ThreadsDriver.getWebDriver().findElement(By.xpath("//input[@class='o-control']")).click();

    }

    public void searchLetter(String sender) {

        //div[@data-message-id]//div[@role='button' and @aria-label='Show trimmed content']

        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[contains(@class, 'search-panel-button')]")).click();
        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[contains(@class, 'search-panel-button')]")).sendKeys(sender);
        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[contains(@class, 'search-panel-button')]")).submit();

    }

    public void searchResult() {
        //TODO
    }

    public void aprooveRegLetter(String sender) {

        searchLetter(sender);

        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@class='llc__content']")).click();
        ThreadsDriver.getWebDriver().findElement(By.xpath("//a[@class='button_mr_css_attr']")).click();

    }

    public void switchToSuccessRegister() {


        //Check that you register email
        String s = ThreadsDriver.getWebDriver().getWindowHandle();
        ThreadsDriver.getWebDriver().getWindowHandles().forEach(x -> {
            if (!x.equals(s)) {
                ThreadsDriver.getWebDriver().switchTo();
            }
        });
        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@class='bui-panel-body']/a"));
    }
}
