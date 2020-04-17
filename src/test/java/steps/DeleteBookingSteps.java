package steps;

import io.cucumber.java.en.When;
import client.HttpConfig;
import utils.SharedState;

import java.util.HashMap;

public class DeleteBookingSteps {

    private SharedState sharedState;

    public DeleteBookingSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @When("Send DELETE request")
    public void sendDELETERequest() {

        HashMap<String, String> cookies = new HashMap<>();
        cookies.put("token", sharedState.tokenRetrievalDto.token);

        sharedState.response = HttpConfig.sendDeleteRequest("/booking/" + sharedState.bookingResponseBodyDto.bookingId, cookies);
    }
}
