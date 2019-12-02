package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import utils.IEXRequests;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.net.URISyntaxException;

public class StepDefs {

	private static Response response;

	@Given("I send request GET stock quote for {string}")
    public void i_send_reuest_to_get_quote(String symbol) throws URISyntaxException{
        response=IEXRequests.GetStockQuote(symbol);
    }

	@When("I verify the response to have {string}")
	public void i_verify_the_response_to_have(String symbol) {
		response.then().assertThat().body("symbol",equalTo(symbol));
	}

	@Then("I verify the response has code {int}")
	public void i_verify_the_response_code(int code){
		response.then().statusCode(code);
	}

	@Then("I verify the response has {string} as {string}")
	public void i_verify_the_response_code(String param,String val){
			response.then().assertThat().body(param,equalTo(val));
	}

	@Then("I verify the price response has {string} as {float}")
	public void i_verify_the_price_response_code(String param,float val){
		response.then().assertThat().body(param,equalTo(val));
	}

	@Given("I send request to GET open-close price of {string} stock on {string} date")
	public void i_send_request_to_get_openclose_price_of_stock(String symbol,String dt){
		response=IEXRequests.GetOpenClosePriceOfStockByDay(symbol,dt);
	}

}
