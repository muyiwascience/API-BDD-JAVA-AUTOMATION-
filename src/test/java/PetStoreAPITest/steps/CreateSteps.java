package PetStoreAPITest.steps;


import PetStoreAPITest.api.model.pet.Category;
import PetStoreAPITest.api.model.pet.Pet;
import PetStoreAPITest.api.utils.JsonReader;
import PetStoreAPITest.api.world.WorldHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateSteps {

    private WorldHelper helper;

    public CreateSteps(WorldHelper helper) {
        this.helper = helper;
    }


    @When("^I create a pet$")
    public void iCreateAPet() throws Throwable {
        String endpoint = "/v2/pet";
        helper.postVerb().postOnApi(endpoint, JsonReader.getData("petMessageBody.json"));
    }

    @Then("^the following result is available$")
    public void theFollowingResultIsAvailable() throws Throwable {
        Response response = helper.postVerb().getResponse();

        //Status Code
        assertEquals(response.getStatusCode(), 200);

        //Get time
       assertTrue(response.getTime() <= 2000);

        //Body Information could be harvested as shown below
        Pet pet = response.as(Pet.class, ObjectMapperType.GSON);
        assertEquals(pet.getName(), "African Dwarf Dog");
        assertEquals(pet.getStatus(), "available");
        Category category = pet.getCategory();
        assertEquals(1L, (long) category.getId());
        assertEquals(category.getName(), "Kumal's Dog");
        pet.getPhotoUrls().forEach(url -> url.equalsIgnoreCase("https://goo.gl/images/fxk2BX"));
    }
}
