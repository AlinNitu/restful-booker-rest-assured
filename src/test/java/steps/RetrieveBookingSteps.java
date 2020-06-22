package steps;

import client.HttpConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.BookingDto;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.SharedState;

import static org.testng.Assert.assertEquals;

public class RetrieveBookingSteps {

    private SharedState sharedState;


    public RetrieveBookingSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @When("Send GET request")
    public void sendGETRequest() {

        sharedState.response = HttpConfig.sendGetRequest("/booking/" + sharedState.bookingResponseBodyDto.bookingId);
    }


    @Then("The retrieved data in payload is the updated one")
    public void theRetrievedDataInPayloadIsTheUpdatedOne() throws JsonProcessingException {

        sharedState.bookingResponseBodyDto.booking = sharedState.response.getBody().as(BookingDto.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        var getResponseBody = mapper.writeValueAsString(sharedState.bookingResponseBodyDto.booking);

        assertEquals(sharedState.updatedResponseBody, getResponseBody,
                "The response from the GET call is not equal to the updated one");
    }
}
