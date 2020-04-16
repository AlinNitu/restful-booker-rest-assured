package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.BookingDto;
import dto.BookingDatesDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.HttpConfig;
import utils.SharedState;

import java.util.HashMap;

public class UpdateBookingSteps {

    private SharedState sharedState;

    public UpdateBookingSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @Given("Create update request payload")
    public void createUpdateRequestPayload() throws JsonProcessingException {

        BookingDatesDto bookingDatesDto = BookingDatesDto.builder().build();
        bookingDatesDto.setCheckin("01-01-2022");
        bookingDatesDto.setCheckout("02-02-2024");

        BookingDto bookingDto = BookingDto.builder().build();
        bookingDto.setFirstName("alin");
        bookingDto.setLastName("edit");
        bookingDto.setTotalPrice(200);
        bookingDto.setDepositPaid(false);
        bookingDto.setBookingDatesDto(bookingDatesDto);
        bookingDto.setAdditionalNeeds("rum and coke");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        sharedState.jsonRequestBody = mapper.writeValueAsString(bookingDto);
    }

    @When("Send PUT request")
    public void sendPUTRequest() {

        HashMap<String, String> cookie = new HashMap<>();
        cookie.put("token", sharedState.tokenRetrievalDto.token);

        sharedState.response = HttpConfig.sendPutRequest("/booking/" + sharedState.bookingResponseBodyDto.bookingId,
                sharedState.jsonRequestBody ,cookie);
    }
}
