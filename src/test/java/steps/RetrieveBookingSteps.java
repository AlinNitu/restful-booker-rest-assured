package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import utils.HttpConfig;
import utils.SharedState;

public class RetrieveBookingSteps {

    private SharedState sharedState;


    public RetrieveBookingSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @When("Send GET request")
    public void sendGETRequest() {

        sharedState.response = HttpConfig.sendGetRequest("/booking/" + sharedState.bookingResponseBodyDto.bookingId);
    }


    @And("The retrieved data in payload is the updated one")
    public void theRetrievedDataInPayloadIsTheUpdatedOne() {



    }
}
