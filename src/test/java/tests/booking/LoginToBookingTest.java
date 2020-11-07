package tests.booking;

import drivers.ThreadsDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.booking.LoginToBooking;
import pages.mail.VoidCheckGmail;
import pages.mail.VoidCheckMail;

public class LoginToBookingTest {

    private LoginToBooking loginToBooking = new LoginToBooking();
    private VoidCheckMail checkMail = new VoidCheckMail();


    @Before
    public void initDriver() {
        ThreadsDriver.getWebDriver();
    }

    @After
    public void closeDriver() {
        ThreadsDriver.getWebDriver().close();
        ThreadsDriver.setThreadLocalWebDriver();
    }

    @Test
    public void loginTest() throws InterruptedException {

        loginToBooking.loginToBooking("drusdev@gmail.com");
        checkMail.loginMail("drusdev", "Qwerty1q2w3e4r");
        checkMail.searchLetter("booking.com");
        loginToBooking.loginSuccess();
    }

}
