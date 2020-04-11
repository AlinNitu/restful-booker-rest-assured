package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestAssuredConfig {

    public static RequestSpecification request;

    public RestAssuredConfig() {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://restful-booker.herokuapp.com");
        builder.setContentType(ContentType.JSON);

        var requestSpecification = builder.build();

        request = RestAssured.given().spec(requestSpecification).log().all();
    }


    public static ResponseOptions<Response> sendPostRequest(String url, String reqBody) {

        return request.
                body(reqBody).
                post(url);
    }

    public static ResponseOptions<Response> sendGetRequest(String url, Map<String, String> pathParam) {

        return request.
                pathParams(pathParam).
                get(url);
    }

    public static ResponseOptions<Response> sendDeleteRequest(String url, Map<String, String> pathParam, Map<String, String> cookies) {

        return request.
                pathParams(pathParam).
                cookies(cookies).
                delete(url);
    }
}
