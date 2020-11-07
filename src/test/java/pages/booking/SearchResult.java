package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchResult {

    WebDriver driver = new ChromeDriver();


    public List<WebElement> getSearchResult() {

        return driver.findElements(By.xpath("//div[@id='ajaxsrwrap']//div[contains(@class, 'sr_property_block') and @data-score]"));
    }

    public void addToFavorites(int position) {

        getSearchResult().
                get(position)
                .findElement(By.xpath("//div[@id='ajaxsrwrap']//div[contains(@class, 'sr_property_block') and @data-score]//button"))
                .click();

        checkFavoriteList(getSearchResult().get(position).getAttribute("data-hotelid"));
    }

    public void getFavoritesLists() {
        //TODO
    }


    public boolean checkFavoriteList(String attribute) {

        if (driver.findElements(By.xpath("//button[@data-title='Сохранить' and contains(@class, 'saved_in_wl')]"))
                .stream().filter(x -> x.getAttribute("data-hotelid")
                        .equalsIgnoreCase(attribute)).findFirst().isPresent()) {
            return true;
        } else return false;
    }
}
