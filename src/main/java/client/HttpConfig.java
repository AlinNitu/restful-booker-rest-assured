package client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class HttpConfig {

    public static RequestSpecification request;

    public HttpConfig() {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://restful-booker.herokuapp.com"); //could be added from config file for better maintenance
        builder.setContentType(ContentType.JSON);

        var requestSpecification = builder.build();
        request = RestAssured.given().spec(requestSpecification).log().all();
    }


    public static ResponseOptions<Response> sendPostRequest(String url, String reqBody) {

        return request.
                body(reqBody).
                post(url);
    }

    public static ResponseOptions<Response> sendPostRequest(String url, String reqBody, Map<String, String> pathParam) {

        return request.
                pathParams(pathParam).
                body(reqBody).
                post(url);
    }

    public static ResponseOptions<Response> sendGetRequest(String url) {

        return request.
                get(url);
    }

    public static ResponseOptions<Response> sendDeleteRequest(String url, Map<String, String> cookies) {

        return request.
                cookies(cookies).
                delete(url);
    }

    public static ResponseOptions<Response> sendPutRequest(String url, String reqBody, Map<String, String> cookies) {

        return request.
                cookies(cookies).
                body(reqBody).
                put(url);
    }
}
