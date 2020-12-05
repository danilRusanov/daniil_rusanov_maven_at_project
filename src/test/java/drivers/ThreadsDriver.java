package drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class ThreadsDriver {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ConfigWebDrivers config;


    public static WebDriver getWebDriver() throws MalformedURLException {
        if(webDriver.get() == null) {
            webDriver.set(DriverManager.getDriver(config));
        }
        return webDriver.get();
    }

    public static void setThreadLocalWebDriver() throws MalformedURLException {
        getWebDriver().close();
        webDriver.set(null);
    }

    public static void setConfig(ConfigWebDrivers config) {
        ThreadsDriver.config = config;
    }
}
