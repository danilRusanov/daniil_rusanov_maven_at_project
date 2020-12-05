package api.tests;



import class_work.utilities.example3.Search;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

import static api.tests.BaseSteps.REQUEST_SPECIFICATION;

public class ApiTest {

    @Given("Search by fullname")
    public void searchByFullNameStep() {

        RestAssured
                .given()
                .spec(REQUEST_SPECIFICATION)
                .body(new Search("a", true))
                .when()
                .post()
                .then()
                .toString();
    }


    public void searchAllUsersTest() {

    }

}
