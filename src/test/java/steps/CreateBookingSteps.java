package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.Booking;
import dto.BookingDates;
import dto.BookingResponseBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.RestAssuredConfig;
import utils.SharedState;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class CreateBookingSteps {

    private SharedState sharedState;

    public CreateBookingSteps(SharedState state) {
        this.sharedState = state;
    }


    @Given("Create default request payload")
    public void createDefaultRequestPayload() throws JsonProcessingException {

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckinDate("01-01-2022");
        bookingDates.setCheckoutDate("02-02-2024");

        Booking booking = new Booking();
        booking.setFirstName("alin");
        booking.setLastName("nitu");
        booking.setTotalPrice(100);
        booking.setDepositPaid(true);
        booking.setBookingDates(bookingDates);
        booking.setAdditionalNeeds("beer");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        sharedState.jsonRequestBody = mapper.writeValueAsString(booking);
    }

    @When("Send POST request")
    public void sendPostRequest() {

        sharedState.response = RestAssuredConfig.sendPostRequest("/booking", sharedState.jsonRequestBody);
    }

    @Then("Status code is {int}")
    public void statusCodeIs(int expectedStatusCode) {

        assertEquals(sharedState.response.statusCode(), expectedStatusCode);
    }

    @Then("The data in the response body is the same as data in the request body")
    public void responseHasSameDataAsRequestBody() {

    }

    @Then("The booking id was saved successfully")
    public void bookingIdWasSavedSuccessfully() {

        sharedState.bookingResponseBody = sharedState.response.getBody().as(BookingResponseBody.class);
        assertNotNull(sharedState.bookingResponseBody.bookingId);
    }
}
