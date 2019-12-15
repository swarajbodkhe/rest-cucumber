package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class TrelloUtils {
    public static RequestSpecification request;

    public TrelloUtils(){
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri("https://api.trello.com/1");
//        builder.addQueryParam("key",TrelloCredentials.getKey());
//        builder.addQueryParam("token",TrelloCredentials.getToken());
        builder.addQueryParam("key","ADD YOUR KEY");
        builder.addQueryParam("token","ADD YOUR TOKEN");
        request= RestAssured.given().spec(builder.build());
    }

    public Response getBoardDetails(String boardId){
        request.pathParam("board","FzFDlcjh");
        return request.get("boards/{board}","board");
    }

    public Response getTrelloResponse(String uri) {
        try{
            return request.get(new URI(uri));
        }catch(Exception URISyntaxException){
            return null;
        }
    }

    public Map<String,Object> convertTableToMap(List<List<String>> table){
        Map<String,Object> jsonMap=new HashMap<String, Object>();

        for (int i=1;i<table.size();i++){
            jsonMap.put(table.get(i).get(0),table.get(i).get(1));
        }
        return jsonMap;
    }

    public void PutRequestBodyForTrello(Map<String,Object> jsonMap){
        request.given().contentType(JSON)
                .body(jsonMap);
    }

    public Response PutResponseForTrello(String url,String key,String value){
        //request.pathParam(key,value);
        return request.put(url+"/"+value);
    }
}
