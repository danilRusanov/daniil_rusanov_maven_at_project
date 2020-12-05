package report.custom;

import cucumber.api.Result;
import cucumber.api.event.*;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CustomCuke implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestRunStarted.class, getTestRunStartedHandler());
        publisher.registerHandlerFor(TestCaseStarted.class, getTestCaseStartedHandler());
        publisher.registerHandlerFor(TestStepStarted.class, getTestStepStartedHandler());
        publisher.registerHandlerFor(TestStepFinished.class, getTestStepFinishedHandler());
        publisher.registerHandlerFor(TestCaseFinished.class, getTestCaseFinishedHandler());
        publisher.registerHandlerFor(WriteEvent.class, getWriteEventHandler());
        publisher.registerHandlerFor(EmbedEvent.class, getEmbedEventHandler());
        publisher.registerHandlerFor(TestRunFinished.class, getTestRunFinishedHandler());
    }

    private EventHandler<TestRunStarted> getTestRunStartedHandler() {
        return event -> {
            System.out.println(event.getClass() + " " + event.getTimeStamp());
        };
    }

    private EventHandler<TestCaseStarted> getTestCaseStartedHandler() {
        return event -> {

            System.out.println(event.getClass() + " " + event.getTimeStamp());
        };
    }

    private EventHandler<TestStepStarted> getTestStepStartedHandler() {
        return event -> {

            System.out.println(event.getClass() + " " + event.getTimeStamp());
        };
    }

    private EventHandler<TestStepFinished> getTestStepFinishedHandler() {
        return event -> {

//            System.out.println(event.getClass() + " " + event.getTimeStamp());


        };
    }

    private EventHandler<TestCaseFinished> getTestCaseFinishedHandler() {
        return event -> {

//            System.out.println(event.getClass() + " " + event.getTimeStamp());


            PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
            authScheme.setUserName("fakemail@tech.co");
            authScheme.setPassword("Abc123");

            RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
                    .setBaseUri("http://178.124.206.46")
                    .setPort(8000)
                    .setAccept(ContentType.JSON)
                    .setContentType(ContentType.JSON)
                    .setAuth(authScheme)
                    .log(LogDetail.ALL)
                    .build();

            Result.Type status = event.result.getStatus();
            int st_note = 1;

//            switch (status) {
//                case PASSED: st_note = 1;
//                case FAILED: st_note = 5;
//            }

            if (status.equals(Result.Type.PASSED)) {
                st_note = 1;
            }
            if (status.equals(Result.Type.FAILED)) {
                st_note = 5;
            }

            int caseId = Integer.parseInt(event.testCase.getTags().stream().findFirst().get().getName().substring(1));

            String bofy = "{\"status_id\": " + st_note + ", \"comment\": \"This test failed by Danil\", \"elapsed\": \"15s\", \"defects\":\"TR-7\", \"version\": \"1.0 RC1 build 3724\"}";

            System.out.println(
                    RestAssured
                            .given()
                            .spec(REQUEST_SPECIFICATION)
                            .body(bofy)
                            .when()
//                            .post("index.php?/api/v2/add_result/63842")
//                            index.php?/api/v2/add_result_for_case/:run_id/:case_id
                            .post("index.php?/api/v2/add_result_for_case/411/" + caseId)
//                            .get("index.php?/api/v2/get_cases/7&suite_id=358")
                            .then()
                            .extract().asString()
            );
        };


    }

    private EventHandler<WriteEvent> getWriteEventHandler() {
        return event -> {

            System.out.println(event.getClass() + " " + event.getTimeStamp());
        };
    }

    private EventHandler<EmbedEvent> getEmbedEventHandler() {
        return event -> {

            System.out.println(event.getClass() + " " + event.getTimeStamp());
        };
    }

    private EventHandler<TestRunFinished> getTestRunFinishedHandler() {
        return event -> {

            System.out.println(event.getClass() + " " + event.getTimeStamp());
        };
    }

}
