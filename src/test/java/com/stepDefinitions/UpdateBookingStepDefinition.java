package com.stepDefinitions;

import com.Base.EndPoints;
import com.Base.APIServiceLibrary;
import com.Base.ResponseCode;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import static com.Base.APIServiceLibrary.getInvalidAuthToken;
import static com.integration.UpdateBookingController.UpdateBookingRequestBody;
import static org.junit.Assert.assertEquals;

public class UpdateBookingStepDefinition {
    Response response;
    @Then("I update booking")
    public void userUpdatesBooking() {
        String requestBody = UpdateBookingRequestBody();
        response= APIServiceLibrary.sendPutRequestWithOneParameter(String.valueOf(CreateBookingStepDefinition.sessionBookingid),requestBody, EndPoints.UPDATE_BOOKING);
    }
    @Then("I update booking with unauthorized user")
    public void userUpdatesBookingWithDetailsWithInvalidToken() {
        getInvalidAuthToken();
        String requestBody = UpdateBookingRequestBody();
        response= APIServiceLibrary.sendPutRequestWithOneParameter(String.valueOf(CreateBookingStepDefinition.sessionBookingid),requestBody, EndPoints.UPDATE_BOOKING);
    }

    @Then("Booking is updated successfully")
    public void bookingIsUpdatedSuccessfully() {
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_200,response.getStatusCode());
    }
    @Then("Booking is not updated")
    public void bookingIsNotUpdated(){
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_403,response.getStatusCode());
    }
}
