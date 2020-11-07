package tests.booking;

import org.junit.Test;
import pages.booking.RegisterInBooking;

public class BookingRegisterAccTest {

    private RegisterInBooking book = new RegisterInBooking();

    @Test
    public void registerAtBookingTest() {

        book.registerAtBooking("drusdev@list.ru", "Qwerty1q2w3e4r");
    }

}
