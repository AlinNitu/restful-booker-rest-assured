package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.BookingDates;
import dto.RequestBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utils.RestAssuredConfig;

import static org.testng.Assert.assertEquals;

public class CreateBookingIdSteps {

    static ResponseOptions<Response> response;
    public static String jsonRequestBody;


    @Given("Create default request payload")
    public void createDefaultRequestPayload() throws JsonProcessingException {

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckinDate("01-01-2022");
        bookingDates.setCheckoutDate("02-02-2024");

        RequestBody requestBody = new RequestBody();
        requestBody.setFirstName("alin");
        requestBody.setLastName("nitu");
        requestBody.setTotalPrice(100);
        requestBody.setDepositPaid(true);
        requestBody.setBookingDates(bookingDates);
        requestBody.setAdditionalNeeds("beer");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        jsonRequestBody = mapper.writeValueAsString(requestBody);
    }

    @When("Send POST request")
    public void sendPostRequest() {

        response = RestAssuredConfig.sendPostRequest("/booking", jsonRequestBody);
    }

    @Then("Status code is {int}")
    public void statusCodeIs(int expectedStatusCode) {

        assertEquals(response.statusCode(), expectedStatusCode);
    }

    @Then("The data in the response body is the same as data in the request body")
    public void responseHasSameDataAsRequestBody() {

    }

    @Then("The booking id was saved successfully")
    public void bookingIdWasSavedSuccessfully() {

    }
}
