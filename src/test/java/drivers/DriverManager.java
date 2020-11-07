package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private DriverManager() {
    }

    public static WebDriver getDriver(ConfigWebDrivers config) {

        switch (config != null ? config : ConfigWebDrivers.CHROME) {
            case SAFARY:
                return getSafariDriver();
            case IE:
                return getIEDriver();
            case OPERA:
                return getOperaDriver();
            case FF:
                return getFFDriver();
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

}
