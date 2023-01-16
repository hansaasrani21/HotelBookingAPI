package com.integration;

import com.Base.APIServiceLibrary;
import com.integration.representation.BookingDates;
import com.integration.representation.CreateBooking;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.sql.Date;

public class UpdateBookingController {
    public static String UpdateBookingRequestBody(){
        APIServiceLibrary apiServiceLibrary = new APIServiceLibrary();
        String request=null;
        CreateBooking updateBookingRequestBody = new CreateBooking();
        updateBookingRequestBody.setFirstname(APIServiceLibrary.data.getProperty("updatedfirstname"));
        updateBookingRequestBody.setLastname(APIServiceLibrary.data.getProperty("updatedlastname"));
        updateBookingRequestBody.setTotalprice(Integer.parseInt(APIServiceLibrary.data.getProperty("updatedtotalprice")));
        updateBookingRequestBody.setDepositpaid(Boolean.parseBoolean(APIServiceLibrary.data.getProperty("updateddepositpaid")));
        updateBookingRequestBody.setBookingdates(addDates(APIServiceLibrary.data.getProperty("updatedcheckin"), APIServiceLibrary.data.getProperty("updatedcheckout")));
        updateBookingRequestBody.setAdditionalneeds(APIServiceLibrary.data.getProperty("updatedadditionalneeds"));
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File("src/test/java/com/integration/requests/UpdateBooking.json"),updateBookingRequestBody);
            request = mapper.writeValueAsString(updateBookingRequestBody);}
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
