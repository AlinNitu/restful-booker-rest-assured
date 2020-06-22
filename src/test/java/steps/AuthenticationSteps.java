package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.TokenCreationDto;
import dto.TokenRetrievalDto;
import io.cucumber.java.en.Given;
import client.HttpConfig;
import utils.SharedState;

public class AuthenticationSteps {

    private SharedState sharedState;

    public AuthenticationSteps(SharedState sharedState) {
        this.sharedState = sharedState;
    }

    @Given("Generate token for authentication")
    public void generateTokenForAuthentication() throws JsonProcessingException {

        TokenCreationDto tokenCreationDto = new TokenCreationDto();
        tokenCreationDto.setUsername("admin"); //could be also stored in a config file
        tokenCreationDto.setPassword("password123");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String tokenRequestBody = mapper.writeValueAsString(tokenCreationDto);

        sharedState.response = HttpConfig.sendPostRequest("/auth", tokenRequestBody);

        sharedState.tokenRetrievalDto = sharedState.response.getBody().as(TokenRetrievalDto.class);
    }
}
