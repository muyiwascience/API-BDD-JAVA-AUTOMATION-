package PetStoreAPITest.steps;

import PetStoreAPITest.api.world.WorldHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class FindPetSteps {

    private WorldHelper helper;


    public FindPetSteps(WorldHelper helper) {
        this.helper = helper;
    }

    @Given("^I have access to pet service$")
    public void iHaveAccessToPetService() throws Throwable {
        helper.baseVerb().setUp();
    }

    @When("^I find pet by availability$")
    public void iFindPetByAvailability() throws Throwable {
        String endpoint = "/v2/pet/findByStatus?status=available";
        helper.getVerb().getApi(endpoint);
    }

    @Then("^the pet is available$")
    public void thePetIsAvailable() throws Throwable {
        String body = helper.getVerb().getResponse().asString();
        List<String> names = from(body).get("name");
        System.out.println(names);

        List<String> ids = from(body).get("id");
        System.out.println(ids);

    }
}
