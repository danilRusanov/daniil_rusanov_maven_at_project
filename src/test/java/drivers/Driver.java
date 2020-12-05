package drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Driver {

    private static WebDriver webDriver;
    private static ConfigWebDrivers config;

    private Driver() {
    }

    public void setConfig(ConfigWebDrivers config) {
        Driver.config = config;
    }

    public static WebDriver getWebDriver() throws MalformedURLException {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(config);
        }
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        Driver.webDriver = webDriver;
    }
}
