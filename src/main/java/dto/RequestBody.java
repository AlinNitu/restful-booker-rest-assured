package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestBody {

    /*
    {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
     */

    public String firstName;
    public String lastName;
    public int totalPrice;
    public boolean depositPaid;
    public BookingDates bookingDates;
    public String additionalNeeds;

    @JsonProperty("firstname")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastname")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("totalprice")
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @JsonProperty("depositpaid")
    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    @JsonProperty("bookingdates")
    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
    }

    @JsonProperty("additionalneeds")
    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }
}
