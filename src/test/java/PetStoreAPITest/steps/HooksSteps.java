package PetStoreAPITest.steps;

import PetStoreAPITest.api.utils.EnvConfig;
import cucumber.api.java.Before;
import io.restassured.RestAssured;

public class HooksSteps {


    @Before
    public void before(){
        String baseUri = EnvConfig.getValue("base.uri");
        RestAssured.baseURI = baseUri;
    }
}
