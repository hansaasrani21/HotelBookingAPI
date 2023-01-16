package com.stepDefinitions;

import com.Base.APIServiceLibrary;
import com.Base.EndPoints;
import com.Base.ResponseCode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

public class HealthCheckStepDefinition {
    Response response;
    @Given("I hit the restful-booker API")
    public void userPingsTheHealthCheckEndpoint() {
        response = APIServiceLibrary.sendGetRequest(EndPoints.HEALTH_CHECK);
    }
    @Then("I confirm API is up and running")
    public void userConfirmsTheHealthCheck() {
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_201,response.getStatusCode());
    }
}
