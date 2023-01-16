package com.Base;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.*;
import java.util.Properties;
import static com.integration.AuthenticationController.getAuthRequestBody;
import static com.integration.AuthenticationController.getUnAuthRequestBody;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class APIServiceLibrary {
    public static Properties data=null;
    static String tokenAccess;
    public static RequestSpecification reqSpecs = new RequestSpecBuilder().setBaseUri(EndPoints.baseURI).build();
    public static Response response;

  public APIServiceLibrary(){
        try{
            if(data==null){
            FileInputStream  reader=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData.properties");
            data=new Properties();
            data.load(reader);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static Response sendPostRequest(String requestBody, String resource){
        response =
                RestAssured.given().
                        spec(reqSpecs).
                        contentType(ContentType.JSON).
                        body(requestBody).
                        post(resource);
        return response;
    }
    public static Response sendGetRequest(String resource){
        response =
                RestAssured.given().
                        spec(reqSpecs).
                        contentType(ContentType.JSON).
                        get(resource);
        return response;
    }
    public static Response sendGetRequestWithSingleParameter(int bookingId,String resource){
        response =
                RestAssured.given().
                        spec(reqSpecs).
                        contentType(ContentType.JSON).pathParam("bookingId",bookingId).
                        get(resource);
        return response;
    }
    public static Response sendGetRequestWithQueryParameter(String parameter, String parameterone){
        response = RestAssured.given().
                    spec(reqSpecs).
                    contentType(ContentType.JSON)
                    .queryParam(parameter,parameterone)
                    .get(EndPoints.GET_ALL_BOOKING_IDS);
        return response;
    }
    public static Response sendGetRequestWithMultipleQueryParameter(String queryParamOne,String queryOne,String queryParamTwo, String queryTwo){
        response = RestAssured.given().
                spec(reqSpecs).
                contentType(ContentType.JSON)
                .queryParam(queryParamOne,queryOne).queryParam(queryParamTwo,queryTwo)
                .get(EndPoints.GET_ALL_BOOKING_IDS);
        return response;
    }
    public static Response sendSimpleGetRequest(String resource){
        response =
                RestAssured.given().
                        spec(reqSpecs).
                        contentType(ContentType.JSON).
                        get(resource);
        return response;
    }

    public static Response sendPutRequestWithOneParameter(String bookingid,String requestBody,String resource){
        response =
                RestAssured.given().
                        spec(reqSpecs).
                        contentType(ContentType.JSON).
                        pathParam("bookingId",bookingid).
                        header("Cookie", "token=" + "" + tokenAccess).
                        body(requestBody).
                        put(resource);
        return response;
    }

    public static Response sendPatchRequestWithOneParameter(String bookingid,String requestBody,String resource){
        response =
                RestAssured.given().
                        spec(reqSpecs).
                        contentType(ContentType.JSON).
                        pathParam("bookingId",bookingid).
                        header("Cookie", "token=" + "" + tokenAccess).
                        body(requestBody).
                        patch(resource);
        return response;
    }

    public static Response sendDeleteRequest(String bookingid,String resource){
        response =
                RestAssured.given().
                        spec(reqSpecs).
                        contentType(ContentType.JSON).
                        pathParam("bookingId",bookingid).
                        header("Cookie", "token=" + "" + tokenAccess).
                        delete(resource);
      return response;
    }

    public static String getAuthToken() {
        String requestBody = getAuthRequestBody();
        response = given().
                            spec(reqSpecs).
                            header("Content-Type", "application/json").
                            request().
                            body(requestBody).
                            post(EndPoints.AUTH);
        assertEquals(ResponseCode.RESPONSE_STATUS_CODE_200, response.getStatusCode());
        tokenAccess = response.getBody().jsonPath().get("token").toString();
        return tokenAccess;
    }

    public static String getInvalidAuthToken(){
        String requestBody = getUnAuthRequestBody();
        response = given().
                spec(reqSpecs).
                header("Content-Type", "application/json").
                request().
                body(requestBody).
                post(EndPoints.AUTH);
            tokenAccess = "f1c3a169462b03fab";
            return tokenAccess;
    }
}
