package steps;

import io.cucumber.java.en.When;
import utils.RestAssuredConfig;
import utils.SharedState;

import java.util.HashMap;

public class DeleteBookingSteps {

    private SharedState sharedState;

    public DeleteBookingSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @When("Send DELETE request")
    public void sendDELETERequest() {

        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("id", String.valueOf(sharedState.bookingResponseBody.bookingId));

        HashMap<String, String> cookies = new HashMap<>();
        cookies.put("token", "abc123");

        sharedState.response = RestAssuredConfig.sendDeleteRequest("/booking/{id}", pathParams, cookies);
    }
}
