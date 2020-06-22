package steps;

import io.cucumber.java.Before;
import client.HttpConfig;

public class Hooks {


    @Before
    public void setup() {

        HttpConfig httpConfig = new HttpConfig();
    }

}
