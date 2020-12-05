package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterInBookingPage {

    WebDriver driver = new ChromeDriver();

    public void registerAtBooking(String email, String password) {


        driver.get("https://www.booking.com/");
        driver.findElement(By.id("current_account_create")).click();
        driver.findElement(By.id("login_name_register")).sendKeys(email);
        driver.findElement(By.xpath("//form[contains(@class, 'nw-register')]//button")).click();

        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirmed_password")).sendKeys(password);
        driver.findElement(By.xpath("//form[contains(@class, 'nw-register')]//button")).click();

    }

    public boolean popupIsDisplayed() {

        return driver.findElement(By.id("wl252-modal-name")).isDisplayed();
    }

    public void popupClose() {

        driver.findElement(By.xpath("//button[@title='Закрыть']"));
    }








}