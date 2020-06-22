package utils;

import dto.BookingResponseBodyDto;
import dto.TokenRetrievalDto;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class SharedState {

    public ResponseOptions<Response> response;
    public String jsonRequestBody;
    public BookingResponseBodyDto bookingResponseBodyDto;
    public String updatedResponseBody;
    public TokenRetrievalDto tokenRetrievalDto;
}
