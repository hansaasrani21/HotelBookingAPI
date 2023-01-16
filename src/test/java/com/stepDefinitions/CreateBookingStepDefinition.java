package com.stepDefinitions;

import com.Base.EndPoints;
import com.Base.APIServiceLibrary;
import com.Base.ResponseCode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import static com.integration.CreateBookingController.createBookingRequestBody;
import static org.junit.Assert.assertEquals;

public class CreateBookingStepDefinition {
    static int sessionBookingid;
    Response response;
    @Given("I create booking")
    public void userCreatesBooking() {
        String requestBody = createBookingRequestBody();
        response= APIServiceLibrary.sendPostRequest(requestBody,EndPoints.CREATE_BOOKING);
        sessionBookingid = response.getBody().jsonPath().get("bookingid");
    }
    @Then("Booking is created successfully")
    public void bookingIsCreatedSuccessfully() {
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_200,response.getStatusCode());
    }

}
