package pages.booking;

import drivers.ThreadsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class LoginToBookingPage {

//    WebDriver driver = new ChromeDriver();

    public void loginToBooking(String email) throws MalformedURLException {

        ThreadsDriver.getWebDriver().get("https://www.booking.com/");
        ThreadsDriver.getWebDriver().findElement(By.id("current_account")).click();
        ThreadsDriver.getWebDriver().findElement(By.id("username")).sendKeys(email);
        ThreadsDriver.getWebDriver().findElement(By.id("username")).submit();

        new WebDriverWait(ThreadsDriver.getWebDriver(), 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() ='Получить ссылку для входа']")));
        ThreadsDriver.getWebDriver().findElement(By.xpath("//span[text() ='Получить ссылку для входа']")).click();
//        Assert.assertTrue("Check message in your email", driver.findElement(By.xpath("//h1")).getText().equalsIgnoreCase("Проверьте папку «Входящие»"));

    }

    public boolean loginSuccess() throws MalformedURLException {

        return ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@class='bui-avatar-block__text' and contains(., '')]")).isDisplayed();
    }

}
