package steps;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import steps.hooks.TrelloHooks;

import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TrelloStepDef {

    private Response response;
    private Map map =new HashMap<String,Object>();

    @Given("I send GET Request for {string}")
    public void iSendGETRequestFor(String arg0) {
        response= TrelloHooks.trello.getTrelloResponse(arg0);
    }

    @Then("I verify response code to be {int}")
    public void iVerifyResponseCodeToBe(int arg0) {
        response.then().assertThat().statusCode(arg0);
    }

    @And("I verify {string} to be {string}")
    public void iVerifyToBe(String arg0, String arg1) {
        response.then().assertThat().body(arg0,equalTo(arg1));
    }

    @And("I print list of {string}")
    public void iPrintListOfCardnames(String arg) {
        System.out.println(response.getBody().jsonPath().getList(arg));
    }

    @And("I verify list of {string} to contain {string}")
    public void iVerifyListOfToContain(String arg0, String arrayToVerify) {
        String[] arr=arrayToVerify.split(",",0);
        response.then().body("name",hasItems(arr));
    }

    @And("I store the value of {string} with criteria {string} as {string}")
    public void iStoreTheValueForWithKeyAs(String arg0, String arg1, String arg2) {
        String criteriaKey=arg1.split("=",0)[0];
        String criteriaValue=arg1.split("=",0)[1];
        String val=JsonPath.parse(response.getBody().asString()).read("$.[?(@."+criteriaKey+"=='"+criteriaValue+"')]."+arg0+"").toString();
        map.put(arg2,val);
        Assert.assertNotNull(map.get(arg2));
    }

    @Then("I verify {string} to be equal to {string}")
    public void iVerifyToBeEqualTo(String arg0, String arg1) {
        System.out.println(map.get(arg0));
        System.out.println(map.get(arg1));
        Assert.assertEquals(map.get(arg0),map.get(arg1));
    }


    @And("I send the body as below for PUT request:")
    public void iSendTheBodyAsBelow(DataTable table) {
       List<List<String>> temp= table.asLists();

       TrelloHooks.trello.PutRequestBodyForTrello(TrelloHooks.trello.convertTableToMap(temp));
    }

    @And("I send PUT Request to {string} for {string} with value {string}")
    public void iSendPUTRequestToForWithValue(String arg0, String arg1, String arg2) {
        response=TrelloHooks.trello.PutResponseForTrello(arg0, arg1, map.get(arg2)==null?arg2:map.get(arg2).toString());
    }
}
