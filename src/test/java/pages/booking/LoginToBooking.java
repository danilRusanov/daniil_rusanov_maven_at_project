package pages.booking;

import drivers.ThreadsDriver;
import org.openqa.selenium.By;
import org.junit.Assert;

public class LoginToBooking {

//    WebDriver driver = new ChromeDriver();

    public void loginToBooking(String email){

        ThreadsDriver.getWebDriver().get("https://www.booking.com/");
        ThreadsDriver.getWebDriver().findElement(By.id("current_account")).click();
        ThreadsDriver.getWebDriver().findElement(By.id("username")).sendKeys(email);
        ThreadsDriver.getWebDriver().findElement(By.id("username")).submit();
//        Assert.assertTrue("Check message in your email", driver.findElement(By.xpath("//h1")).getText().equalsIgnoreCase("Проверьте папку «Входящие»"));

    }

    public boolean loginSuccess() {

        return ThreadsDriver.getWebDriver().findElement(By.xpath("//img[@class='user-avatar-header-img']")).isDisplayed();
    }

}
