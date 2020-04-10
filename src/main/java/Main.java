import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Main {



    public static void main(String[] args) {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        String reqBody = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

//        String reqBodyUpdate = "{\n" +
//                "    \"name\": \"neo\",\n" +
//                "    \"job\": \"leader\"\n" +
//                "}";

        String response = given().log().all()
                .header("Content-Type", "application/json")
                .body(reqBody).
        when().post("/booking").
        then().log().all().assertThat().statusCode(200).body("booking.firstname", equalTo("Jim"))
                .extract().response().asString();

        JsonPath jsonPath = new JsonPath(response);
        String name = jsonPath.getString("name");
        int bookingId = jsonPath.get("bookingid");

        System.out.println(bookingId);



//        given().header("Content-Type", "application/json").body(reqBodyUpdate)
//        .when().put("/api/users/" + id)
//        .then().log().all().assertThat().statusCode(200).body("name",equalTo("neo"));

        given().log().all()
                .when().log().all().get("/booking/" + bookingId)
                .then().log().all().statusCode(200);

    }

}
