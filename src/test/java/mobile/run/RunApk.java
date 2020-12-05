package mobile.run;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class RunApk {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Emulator");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), caps);

        Thread.sleep(3000);

        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']"))
                .click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))
                .click();

        Thread.sleep(5000);

        driver.quit();

    }


    public static void changeTimeZoneTest() {

    }

}
