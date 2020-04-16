package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.BookingDatesDto;
import dto.BookingDto;
import dto.BookingResponseBodyDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.HttpConfig;
import utils.SharedState;

import static org.testng.Assert.*;
import static utils.DateHandler.getNextMonday;
import static utils.DateHandler.getNextSunday;
import static utils.RandomiserHelper.*;

public class CreateBookingSteps {

    private SharedState sharedState;

    public CreateBookingSteps(SharedState state) {
        this.sharedState = state;
    }


    @Given("Create default request payload")
    public void createDefaultRequestPayload() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        sharedState.jsonRequestBody = mapper.writeValueAsString(createRandomBookingData());
    }

    @When("Send POST request")
    public void sendPostRequest() {

        sharedState.response = HttpConfig.sendPostRequest("/booking", sharedState.jsonRequestBody);
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

        sharedState.bookingResponseBodyDto = sharedState.response.getBody().as(BookingResponseBodyDto.class);
        assertNotNull(sharedState.bookingResponseBodyDto.bookingId);
    }

    private BookingDto createRandomBookingData() {

        BookingDatesDto bookingDatesDto = BookingDatesDto.builder().build();
        bookingDatesDto.setCheckin(getNextMonday());
        bookingDatesDto.setCheckout(getNextSunday());

        BookingDto bookingDto = BookingDto.builder().build();
        bookingDto.setFirstName(generateRandomFirstName());
        bookingDto.setLastName(generateRandomLastName());
        bookingDto.setTotalPrice(generateRandomPrice());
        bookingDto.setDepositPaid(generateRandomDepositPaid());
        bookingDto.setBookingDatesDto(bookingDatesDto);
        bookingDto.setAdditionalNeeds("It's always beer");

        return bookingDto;
    }
}
