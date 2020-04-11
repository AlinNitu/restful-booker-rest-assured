package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponseBody {

    public int bookingId;
    public Booking booking;


    @JsonProperty("bookingid")
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
