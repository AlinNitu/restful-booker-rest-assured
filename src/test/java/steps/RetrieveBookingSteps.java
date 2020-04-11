package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import utils.RestAssuredConfig;
import utils.SharedState;

import java.util.HashMap;

public class RetrieveBookingSteps {

    private SharedState sharedState;


    public RetrieveBookingSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @When("Send GET request")
    public void sendGETRequest() {

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("id", String.valueOf(sharedState.bookingResponseBody.bookingId));

        sharedState.response = RestAssuredConfig.sendGetRequest("/booking/{id}", pathParams);
    }


    @And("The retrieved data in payload is the updated one")
    public void theRetrievedDataInPayloadIsTheUpdatedOne() {

    }
}
