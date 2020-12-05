package api.tests;

import api.object.ResponseUserObj;
import class_work.utilities.example2.Recipe;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BaseSteps {

    public static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
            .setBaseUri("http://178.124.206.46:8001/app/ws/")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

//    public static final ResponseUserObj DATA = parseGSON();

    public static ResponseUserObj parseGSON() throws FileNotFoundException {

        Gson gson = new Gson();

        ResponseUserObj data   = gson.fromJson(new JsonReader(new FileReader("classwork/json/example.json")), ResponseUserObj.class);

        return data;
    }
}
