package com.stepDefinitions;

import com.Base.EndPoints;
import com.Base.APIServiceLibrary;
import com.Base.ResponseCode;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import static com.Base.APIServiceLibrary.getInvalidAuthToken;
import static com.integration.PartialUpdateBookingController.createPartialUpdateRequestBody;
import static org.junit.Assert.assertEquals;

public class PartialUpdateBookingStepDefinition {
    Response response;
    @Then("I partially update the booking details")
    public void userPartiallyUpdatesTheBookingDetails(){
        String requestBody = createPartialUpdateRequestBody();
        response= APIServiceLibrary.sendPatchRequestWithOneParameter(String.valueOf(CreateBookingStepDefinition.sessionBookingid),requestBody, EndPoints.UPDATE_BOOKING);
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_200,response.getStatusCode());
    }
    @Then("I partially update the booking details with unauthorized user")
    public void userPartiallyUpdatesTheBookingDetailsWithUnAuthorizedUser(){
        getInvalidAuthToken();
        String requestBody = createPartialUpdateRequestBody();
        response= APIServiceLibrary.sendPatchRequestWithOneParameter(String.valueOf(CreateBookingStepDefinition.sessionBookingid),requestBody, EndPoints.UPDATE_BOOKING);
    }
    @Then("Booking is partially updated successfully")
    public void bookingIsPartiallyUpdatedSuccessfully(){
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_200,response.getStatusCode());
    }
    @Then("Booking is not partially updated")
    public void bookingIsNotPartiallyUpdated(){
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_403,response.getStatusCode());
    }
}
