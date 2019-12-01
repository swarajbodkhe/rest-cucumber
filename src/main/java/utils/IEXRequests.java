package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;

public class IEXRequests {

    public static RequestSpecification request;
    private static String publicToken="pk_0b134cbb9f174f2da0bbcd5f421fca89";

     public IEXRequests(){
         RequestSpecBuilder builder=new RequestSpecBuilder();
         builder.setBaseUri("https://cloud.iexapis.com/stable");
//         builder.addQueryParam("token",publicToken);
         RequestSpecification RequestSpec=builder.build();
         request= RestAssured.given().spec(RequestSpec);
     }

     public static Response GetStockQuote(String geturl) throws URISyntaxException {
            request.queryParam("token",publicToken);
            return request.get(new URI(geturl));
     }









}