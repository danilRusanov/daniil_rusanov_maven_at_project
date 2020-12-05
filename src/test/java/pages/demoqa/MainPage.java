package pages.demoqa;

import drivers.ThreadsDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class MainPage {
    private WebElement elements;

    private void initMainPage(){

        try {
            ThreadsDriver.getWebDriver().get("http://tut.by");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void goToElements() throws MalformedURLException {
//        ThreadsDriver.getWebDriver().findElement("")
    }
}
