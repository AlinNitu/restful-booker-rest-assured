package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfig {

    public static RequestSpecification request;

    public RestAssuredConfig() {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://restful-booker.herokuapp.com");
        builder.setContentType(ContentType.JSON);

        var requestSpecification = builder.build();

        request = RestAssured.given().spec(requestSpecification);
    }


    public static ResponseOptions<Response> sendPostRequest(String url, String reqBody) {

        request.body(reqBody);
        return request.post(url);
    }
}
