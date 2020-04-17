package client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import utils.HttpRequestType;

public class ClientConfigEXPERIMENTAL {


    private RequestSpecBuilder specBuilder;
    private String httpRequest;
    private String url;


    /**
     *
     * @param httpRequest
     * @param url
     * @param cookie
     */
    public ClientConfigEXPERIMENTAL(String httpRequest, String url, Cookie cookie) {
        this.httpRequest = httpRequest;
        this.url = url;

        if (cookie != null)
            specBuilder.addCookie(cookie);

    }

    public ResponseOptions<Response> sendHttpRequest() {

        RequestSpecification requestSpecification = specBuilder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON).spec(requestSpecification);

        if (this.httpRequest.equalsIgnoreCase(HttpRequestType.POST.getRequestType())) {
            return request.post(this.url);
        } else if (this.httpRequest.equalsIgnoreCase(HttpRequestType.GET.getRequestType())) {
            return request.get(this.url);
        } else if (this.httpRequest.equalsIgnoreCase(HttpRequestType.PUT.getRequestType())) {
            return request.put(this.url);
        } else if (this.httpRequest.equalsIgnoreCase(HttpRequestType.DELETE.getRequestType())) {
            return request.delete(this.url);
        } else {
            return null;
            //add exception handling
        }
    }


}
