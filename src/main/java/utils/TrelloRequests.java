package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;

public class TrelloRequests {
    private String key="c7bd875d5f1fc702cf5c58cfcc435e68";
    private String token="3788db4d958244c0ec2feaeda716ba79046f1bb9861072285311c439b87fe909";
    public static RequestSpecification request;

    public TrelloRequests(){
        RequestSpecBuilder builder=new RequestSpecBuilder();
        builder.setBaseUri("https://api.trello.com/1");
        builder.addQueryParam("key",this.key);
        builder.addQueryParam("token",this.token);
        request=RestAssured.given().spec(builder.build());
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
