package pages.mail;

import drivers.ThreadsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class VoidCheckMailPage {

    public void loginMail(String email, String password) throws MalformedURLException {

        ThreadsDriver.getWebDriver().get("https://mail.ru/");

        ThreadsDriver.getWebDriver().findElement(By.id("mailbox:login-input")).sendKeys(email);

//        new WebDriverWait(ThreadsDriver.getWebDriver(), 3)
//                .until(ExpectedConditions.elementToBeClickable(By.id("mailbox:submit-button")));

        ThreadsDriver.getWebDriver().findElement(By.xpath("//input[@class='o-control']")).click();

        new WebDriverWait(ThreadsDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.id("mailbox:password-input")));

        ThreadsDriver.getWebDriver().findElement(By.id("mailbox:password-input")).sendKeys(password);
        ThreadsDriver.getWebDriver().findElement(By.xpath("//input[@class='o-control']")).click();

    }

    public void searchLetter(String sender) throws MalformedURLException, InterruptedException {

        Actions make = new Actions(ThreadsDriver.getWebDriver());
        //div[@data-message-id]//div[@role='button' and @aria-label='Show trimmed content']

        new WebDriverWait(ThreadsDriver.getWebDriver(), 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'search-panel-button__icon')]")));

        ThreadsDriver.getWebDriver().findElement(By.xpath("//span[contains(@class, 'search-panel-button__icon')]")).click();

        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[contains(@class, 'search-panel__layer')]//input")).sendKeys(sender);


        make.sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);
//        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[contains(@class, 'search-panel-button')]")).submit();




    }

    public void goToBookingViaLink() throws MalformedURLException {

        ThreadsDriver.getWebDriver().findElements(By.xpath("//span[text() = 'Ваша ссылка для входа']")).stream().findFirst().get().click();

        new WebDriverWait(ThreadsDriver.getWebDriver(), 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//tr/td/a[contains(@href, 'confirm')]")));
        ThreadsDriver.getWebDriver().findElement(By.xpath("//tr/td/a[contains(@href, 'confirm')]")).click();

    }

    public void aprooveRegLetter(String sender) throws MalformedURLException, InterruptedException {

        searchLetter(sender);

        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@class='llc__content']")).click();
        ThreadsDriver.getWebDriver().findElement(By.xpath("//a[@class='button_mr_css_attr']")).click();

    }

    public void switchToSuccessRegister() throws MalformedURLException {


        //Check that you register email
        String s = ThreadsDriver.getWebDriver().getWindowHandle();
        ThreadsDriver.getWebDriver().getWindowHandles().forEach(x -> {
            if (!x.equals(s)) {
                try {
                    ThreadsDriver.getWebDriver().switchTo();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@class='bui-panel-body']/a"));
    }

}
