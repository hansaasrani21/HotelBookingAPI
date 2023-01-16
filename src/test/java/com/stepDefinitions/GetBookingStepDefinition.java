package com.stepDefinitions;

import com.Base.APIServiceLibrary;
import com.Base.EndPoints;
import com.Base.ResponseCode;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

public class GetBookingStepDefinition {
    Response response;
    int bookingid;
    APIServiceLibrary apiServiceLibrary = new APIServiceLibrary();
    @Given("^I get details of booking by (.*)$")
    public void i_get_details_of_booking_by(String param)
    {
      switch(param) {
          case "id":
          {       userGetsDetailsOfAllBookings();
              response = APIServiceLibrary.sendGetRequestWithSingleParameter(bookingid, EndPoints.GET_BOOKING);
              break;
      }
        case "firstname":
          case "checkin":
          case "checkout":
          case "lastname": {
            response = APIServiceLibrary.sendGetRequestWithQueryParameter(param, APIServiceLibrary.data.getProperty(param));
            break;
        }
          default:
            throw new Error("Invalid Path Parameter");
        }
    }
    @Given("^I get details of booking for (.*) and (.*)$")
    public void i_get_details_of_booking_for_two_paramters(String paramOne,String paramTwo)
    {
        response = APIServiceLibrary.sendGetRequestWithMultipleQueryParameter(paramOne, APIServiceLibrary.data.getProperty(paramOne),paramTwo,APIServiceLibrary.data.getProperty(paramTwo));
    }
    @Given("^I get details of all bookings$")
    public void userGetsDetailsOfAllBookings()
    {
        response = APIServiceLibrary.sendSimpleGetRequest(EndPoints.GET_ALL_BOOKING_IDS);
        bookingid = Integer.parseInt(response.getBody().jsonPath().getList("bookingid").get(0).toString());
    }
    @Then("^I view details of booking successfully$")
    public void viewDetailsOfBookingSuccessfully()
    {
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_200,response.getStatusCode());
    }

}
