package drivers;

import org.openqa.selenium.WebDriver;

public class ThreadsDriver {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ConfigWebDrivers config;


    public static WebDriver getWebDriver() {
        if(webDriver.get() == null) {
            webDriver.set(DriverManager.getDriver(config));
        }
        return webDriver.get();
    }

    public static void setThreadLocalWebDriver() {
        webDriver.set(null);
    }

    public static void setConfig(ConfigWebDrivers config) {
        ThreadsDriver.config = config;
    }
}
