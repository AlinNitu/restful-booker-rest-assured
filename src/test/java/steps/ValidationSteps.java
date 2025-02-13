package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.flogger.FluentLogger;
import dto.BookingDto;
import dto.BookingResponseBodyDto;
import io.cucumber.java.en.Then;
import utils.SharedState;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ValidationSteps {

    private SharedState sharedState;
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public ValidationSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @Then("Status code is {int}")
    public void statusCodeIs(int expectedStatusCode) {

        assertEquals(sharedState.response.statusCode(), expectedStatusCode);
    }

    @Then("The data in the response body is the same as data in the request body")
    public void responseHasSameDataAsRequestBody() throws JsonProcessingException {

        sharedState.bookingResponseBodyDto = sharedState.response.getBody().as(BookingResponseBodyDto.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String responseBody = mapper.writeValueAsString(sharedState.bookingResponseBodyDto.booking);

        assertEquals(sharedState.jsonRequestBody, responseBody,
                "The expected response json body is not the same as the provided request json body");

        logger.atInfo().log("Request body: %s \n " +
                "Response body: %s",
                sharedState.jsonRequestBody,
                responseBody);
    }

    @Then("The data in the response body after update is the same as data in the request body")
    public void theDataInTheResponseBodyAfterUpdateIsTheSameAsDataInTheRequestBody() throws JsonProcessingException {

        sharedState.bookingResponseBodyDto.booking = sharedState.response.getBody().as(BookingDto.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        sharedState.updatedResponseBody = mapper.writeValueAsString(sharedState.bookingResponseBodyDto.booking);

        assertEquals(sharedState.jsonRequestBody, sharedState.updatedResponseBody,
                "The expected response json body is not the same as the provided request json body");
    }

    @Then("The booking id was saved successfully")
    public void bookingIdWasSavedSuccessfully() {

        sharedState.bookingResponseBodyDto = sharedState.response.getBody().as(BookingResponseBodyDto.class);
        assertNotNull(sharedState.bookingResponseBodyDto.bookingId);

        logger.atInfo().log("Booking id was saved with the value: %s", sharedState.bookingResponseBodyDto.bookingId);
    }
}
