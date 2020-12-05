package tests.booking;

import org.junit.Test;
import pages.booking.RegisterInBookingPage;

public class BookingRegisterAccTest {

    private RegisterInBookingPage book = new RegisterInBookingPage();

    @Test
    public void registerAtBookingTest() {

        book.registerAtBooking("drusdev@list.ru", "Qwerty1q2w3e4r");
    }

}
