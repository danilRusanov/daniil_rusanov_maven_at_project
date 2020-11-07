package pages.booking;


import drivers.ThreadsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class BookingFilter {

    public void filterAtBooking(String city, Date start, Date end, int adults, int children, int rooms) {

        ThreadsDriver.getWebDriver().get("https://www.booking.com/");
        ThreadsDriver.getWebDriver().findElement(By.xpath("//label['sb-destination-label-sr']//input[@type='search']"))
                .sendKeys(city);
        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@data-mode='checkin']")).click();

        WebElement firstResult = new WebDriverWait(ThreadsDriver.getWebDriver(), 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bui-calendar__content']")));

        //set date start and end
        // TODO
        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@class='bui-calendar__content']//td[(@class='bui-calendar__date') and @data-date='2020-10-30']"))
                .click();
        ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@class='bui-calendar__content']//td[(@class='bui-calendar__date') and @data-date='2020-11-06']"))
                .click();
        ThreadsDriver.getWebDriver().findElement(By.xpath("//label[@id='xp__guests__toggle']"))
                .click();

        if (adults < 2) {
            while (adults > 0) {
                // TODO
            }
        } else {
            for (int i = 2; i <= adults; i++) {
                ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@id='xp__guests__inputs-container']//div[contains(@class, 'sb-group__field-adults')]//button[contains(@aria-label, 'увеличить')]"))
                        .click();
            }
        }

        for (int i = 0; i <= children; i++) {
            // TODO
        }

        for (int i = 1; i <= rooms; i++) {
            ThreadsDriver.getWebDriver().findElement(By.xpath("//div[@id='xp__guests__inputs-container']//div[contains(@class, 'bui-stepper__wrapper')]//button[contains(@aria-label, 'Номера: увели')]"))
                    .click();
        }

        ThreadsDriver.getWebDriver().findElement(By.xpath("//button[@class='sb-searchbox__button ']"))
                .click();
        ThreadsDriver.getWebDriver().findElement(By.xpath("//a[@data-id='pri-5']//div[@class='bui-checkbox__label filter_item css-checkbox']"))
                .click();
    }

}
