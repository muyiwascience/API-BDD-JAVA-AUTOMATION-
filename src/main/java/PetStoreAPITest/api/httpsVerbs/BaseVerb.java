package PetStoreAPITest.api.httpsVerbs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseVerb {

    protected RequestSpecification requestSpecification;
    protected String mediaType = "application/json";



    public RequestSpecification setUp(){
        requestSpecification = given()
                .accept(mediaType)
                .contentType(mediaType);
        //.auth().preemptive().oauth2("");
        //.auth().preemptive().basic("kumal", "password123");
        return requestSpecification;
    }


    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
