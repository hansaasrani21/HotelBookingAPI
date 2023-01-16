package com.integration;

import com.Base.APIServiceLibrary;
import com.integration.representation.Auth;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class AuthenticationController {
    public static String getAuthRequestBody() {
        String request=null;
        Auth requestBody = new Auth();
        requestBody.setUsername(APIServiceLibrary.data.getProperty("username"));
        requestBody.setPassword(APIServiceLibrary.data.getProperty("password"));
        ObjectMapper mapper = new ObjectMapper();
        try{
        mapper.writeValue(new File("src/test/java/com/integration/requests/auth.json"),requestBody);
        request = mapper.writeValueAsString(requestBody);}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return request;
    }
    public static String getUnAuthRequestBody() {
        String request=null;
        Auth requestBody = new Auth();
        requestBody.setUsername(APIServiceLibrary.data.getProperty("unauthorizedUsername"));
        requestBody.setPassword(APIServiceLibrary.data.getProperty("unauthorizedPassword"));
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File("src/test/java/com/integration/requests/auth.json"),requestBody);
            request = mapper.writeValueAsString(requestBody);}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return request;
    }
}
