package com.integration;

import com.Base.APIServiceLibrary;
import com.integration.representation.CreateBooking;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class PartialUpdateBookingController {
    public static String createPartialUpdateRequestBody(){
        APIServiceLibrary apiServiceLibrary = new APIServiceLibrary();
        String request=null;
        CreateBooking createBookingRequestBody = new CreateBooking();
        createBookingRequestBody.setFirstname(APIServiceLibrary.data.getProperty("updatedfirstname"));
        createBookingRequestBody.setLastname(APIServiceLibrary.data.getProperty("updatedlastname"));
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File("src/test/java/com/integration/requests/PartialUpdateBooking.json"),createBookingRequestBody);
            request = mapper.writeValueAsString(createBookingRequestBody);}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return request;
    }
}
