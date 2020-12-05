package tests.booking;

import drivers.ThreadsDriver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.booking.LoginToBookingPage;
import pages.mail.VoidCheckMailPage;

import java.net.MalformedURLException;

public class LoginToBookingPageTest {

    private static Logger logger = Logger.getLogger(LoginToBookingPageTest.class);

    private LoginToBookingPage loginToBooking = new LoginToBookingPage();
    private VoidCheckMailPage checkMail = new VoidCheckMailPage();


    @Before
    public void initDriver() throws MalformedURLException {
        ThreadsDriver.getWebDriver();
        logger.info("Test starting");
    }

    @After
    public void closeDriver() throws MalformedURLException {
        ThreadsDriver.getWebDriver().close();
        ThreadsDriver.setThreadLocalWebDriver();
    }

    @Test
    public void loginTest() throws InterruptedException, MalformedURLException {

        loginToBooking.loginToBooking("drusdev@list.ru");
        checkMail.loginMail("drusdev@list.ru", "Qwerty1q2w3e4r");
        Thread.sleep(10000);
        checkMail.searchLetter("booking.com");
        checkMail.goToBookingViaLink();
        Assert.assertTrue("Login has been successfull: ", loginToBooking.loginSuccess());

    }

    @Test
    public void loginTest1() throws InterruptedException, MalformedURLException {

        loginToBooking.loginToBooking("drusdev@list.ru");
        checkMail.loginMail("drusdev@list.ru", "Qwerty1q2w3e4r");
        Thread.sleep(10000);
        checkMail.searchLetter("booking.com");
        checkMail.goToBookingViaLink();
        Assert.assertTrue("Login has been successfull: ", loginToBooking.loginSuccess());

    }


}
