package steps;

import client.HttpConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.flogger.FluentLogger;
import dto.BookingDatesDto;
import dto.BookingDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.SharedState;

import static utils.DateHandler.getNextMonday;
import static utils.DateHandler.getNextSunday;
import static utils.RandomHelper.*;

public class CreateBookingSteps {

    private SharedState sharedState;
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public CreateBookingSteps(SharedState state) {
        this.sharedState = state;
    }


    @Given("Create default request payload")
    public void createDefaultRequestPayload() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        sharedState.jsonRequestBody = mapper.writeValueAsString(createRandomBookingData());
        logger.atInfo().log("Creating request payload with JSON body: %s", sharedState.jsonRequestBody);
    }

    @When("Send POST request")
    public void sendPostRequest() {

        sharedState.response = HttpConfig.sendPostRequest("/booking", sharedState.jsonRequestBody);
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
