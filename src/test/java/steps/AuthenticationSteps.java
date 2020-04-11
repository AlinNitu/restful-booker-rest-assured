package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.TokenCreation;
import dto.TokenRetrieval;
import io.cucumber.java.en.Given;
import utils.RestAssuredConfig;
import utils.SharedState;

public class AuthenticationSteps {

    private SharedState sharedState;

    public AuthenticationSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @Given("Generate token for authentication")
    public void generateTokenForAuthentication() throws JsonProcessingException {

        TokenCreation tokenCreation = new TokenCreation();
        tokenCreation.setUsername("admin");
        tokenCreation.setPassword("password123");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String tokenRequestBody = mapper.writeValueAsString(tokenCreation);



        sharedState.response = RestAssuredConfig.sendPostRequest("/auth", tokenRequestBody);

        sharedState.tokenRetrieval = sharedState.response.getBody().as(TokenRetrieval.class);
        System.out.println(sharedState.tokenRetrieval.token);
    }
}
