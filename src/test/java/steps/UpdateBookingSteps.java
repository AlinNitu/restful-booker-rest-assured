package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.BookingDto;
import dto.BookingDatesDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import client.HttpConfig;
import utils.SharedState;

import java.util.HashMap;

import static utils.DateHandler.*;
import static utils.RandomHelper.*;
import static utils.RandomHelper.generateRandomDepositPaid;

public class UpdateBookingSteps {

    private SharedState sharedState;

    public UpdateBookingSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @Given("Create update request payload")
    public void createUpdateRequestPayload() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        sharedState.jsonRequestBody = mapper.writeValueAsString(createRandomUpdateData());
    }

    @When("Send PUT request")
    public void sendPUTRequest() {

        HashMap<String, String> cookie = new HashMap<>();
        cookie.put("token", sharedState.tokenRetrievalDto.token);

        sharedState.response = HttpConfig.sendPutRequest("/booking/" + sharedState.bookingResponseBodyDto.bookingId,
                sharedState.jsonRequestBody ,cookie);
    }

    private BookingDto createRandomUpdateData() {

        BookingDatesDto bookingDatesDto = BookingDatesDto.builder().build();
        bookingDatesDto.setCheckin(getNextSunday());
        bookingDatesDto.setCheckout(getNextYear());

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
