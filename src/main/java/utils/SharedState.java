package utils;

import dto.BookingResponseBody;
import dto.TokenRetrieval;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class SharedState {

    public ResponseOptions<Response> response;
    public String jsonRequestBody;
    public BookingResponseBody bookingResponseBody;
    public TokenRetrieval tokenRetrieval;
}
