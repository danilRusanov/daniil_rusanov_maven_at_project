package api.runner;

import api.object.UserObj;
import class_work.utilities.example3.Search;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static api.tests.BaseSteps.REQUEST_SPECIFICATION;


public class RunRestAssure {
    public static void main(String[] args) {

        RestAssured
                .given()
                .spec(REQUEST_SPECIFICATION)
                .body(new Search("a", true))
                .when()
                .post()
                .then()
                .extract().body().as(UserObj.class);
//                .extract();

//        System.out.println(s);
    }
}
