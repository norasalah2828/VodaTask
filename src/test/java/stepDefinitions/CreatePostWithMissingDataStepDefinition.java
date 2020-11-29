package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.runner.RunWith;
import data.Payloads;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
public class CreatePostWithMissingDataStepDefinition {

	RequestSpecification res;
	Response response;
	JsonPath postJS;

		@Given("add post payload with {string} only")
		public void add_post_payload_with_only(String title) throws IOException {
				res=given().log().all().spec(Payloads.requestSpecification())
						.header("Content-Type","application/json")
						.body(Payloads.AddPostWithTitleOnly(title));	
		}
		

			@When("user calls CreatAPostAPI with post http request for mentioned payload")
			public void user_calls_creat_a_post_api_with_post_http_request_for_mentioned_payload() {
				response = res.when().log().all().post("posts");
			}

		
		    @Then("^call will fail with status code 500$")
		    public void call_will_fail_with_status_code_500() throws Throwable {
				assertEquals(response.getStatusCode(),500);
		    }

}