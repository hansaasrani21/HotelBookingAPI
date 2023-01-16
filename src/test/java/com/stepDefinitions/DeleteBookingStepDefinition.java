package com.stepDefinitions;

import com.Base.EndPoints;
import com.Base.APIServiceLibrary;
import com.Base.ResponseCode;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import static com.Base.APIServiceLibrary.getInvalidAuthToken;
import static org.junit.Assert.assertEquals;

public class DeleteBookingStepDefinition {
    Response response;
    @Then("I delete booking")
    public void userDeletesBooking() {
        response= APIServiceLibrary.sendDeleteRequest(String.valueOf(CreateBookingStepDefinition.sessionBookingid),EndPoints.DELETE_BOOKING);
    }
    @Then("I delete booking with unauthorized user")
    public void userDeletesBookingWithUnAuthorizedUser() {
        getInvalidAuthToken();
        response= APIServiceLibrary.sendDeleteRequest(String.valueOf(CreateBookingStepDefinition.sessionBookingid),EndPoints.DELETE_BOOKING);
    }
    @Then("Booking is deleted successfully")
    public void bookingIsDeleted() {
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_201,response.getStatusCode());
    }
    @Then("Booking is not deleted")
    public void bookingIsNotDeleted() {
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_403,response.getStatusCode());
    }

}
