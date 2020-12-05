package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private DriverManager() {
    }

    public static WebDriver getDriver(ConfigWebDrivers config) throws MalformedURLException {

        switch (config != null ? config : ConfigWebDrivers.CHROME) {
            case SAFARY:
                return getSafariDriver();
            case IE:
                return getIEDriver();
            case OPERA:
                return getOperaDriver();
            case FF:
                return getFFDriver();
            case REMOTE:
                return getRemoteDriver();
            default:
                return getChromeDriver();
        }
    }

    private static WebDriver getFFDriver() {
        // TODO
        return null;
    }

    private static WebDriver getSafariDriver() {
        // TODO
        return null;
    }

    private static WebDriver getOperaDriver() {
        // TODO
        return null;
    }

    private static WebDriver getIEDriver() {
        // TODO
        return null;
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        return new ChromeDriver(caps);
    }

    private static WebDriver getRemoteDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver webDriver =
                new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        return webDriver;
    }

}
