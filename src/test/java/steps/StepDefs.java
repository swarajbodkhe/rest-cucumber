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

	@Given("I send GET request to {string}")
	public void i_send_GET_request_to(String url) throws URISyntaxException {
		response=IEXRequests.GetStockQuote(url);
	}

	@When("I verify the response to have {string}")
	public void i_verify_the_response_to_have(String symbol) {
		response.then().assertThat().body("symbol",equalTo(symbol));
	}
}
