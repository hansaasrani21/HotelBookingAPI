package com.integration;

import com.Base.APIServiceLibrary;
import com.integration.representation.BookingDates;
import com.integration.representation.CreateBooking;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.sql.Date;

public class CreateBookingController {
     public static String createBookingRequestBody() {
        APIServiceLibrary apiServiceLibrary = new APIServiceLibrary();
        String request=null;
        CreateBooking createBookingRequestBody = new CreateBooking();
        createBookingRequestBody.setFirstname(APIServiceLibrary.data.getProperty("firstname"));
        createBookingRequestBody.setLastname(APIServiceLibrary.data.getProperty("lastname"));
        createBookingRequestBody.setTotalprice(Integer.parseInt(APIServiceLibrary.data.getProperty("totalprice")));
        createBookingRequestBody.setDepositpaid(Boolean.parseBoolean(APIServiceLibrary.data.getProperty("depositpaid")));
        createBookingRequestBody.setBookingdates(addDates(APIServiceLibrary.data.getProperty("checkin"), APIServiceLibrary.data.getProperty("checkout")));
        createBookingRequestBody.setAdditionalneeds(APIServiceLibrary.data.getProperty("additionalneeds"));
         ObjectMapper mapper = new ObjectMapper();
        try{
           mapper.writeValue(new File("src/test/java/com/integration/requests/CreateBooking.json"),createBookingRequestBody);
           request = mapper.writeValueAsString(createBookingRequestBody);}
        catch (Exception e){
           System.out.println(e.getMessage());
        }
        return request;
     }
    public static BookingDates addDates(String checkin, String checkout){
        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin(Date.valueOf(checkin));
        bookingDates.setCheckout(Date.valueOf(checkout));
        return bookingDates;
    }
}
