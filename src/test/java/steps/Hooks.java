package steps;

import io.cucumber.java.Before;
import utils.RestAssuredConfig;

public class Hooks {


    @Before
    public void setup() {

        RestAssuredConfig restAssuredConfig = new RestAssuredConfig();
    }

}
