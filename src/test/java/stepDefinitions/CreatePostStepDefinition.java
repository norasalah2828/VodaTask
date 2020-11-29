package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.runner.RunWith;
import data.Payloads;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
public class CreatePostStepDefinition {

	RequestSpecification res;
	Response response;
	JsonPath postJS;

		@Given("add post payload with {string} {string} {string}")
		public void add_post_payload_with(String title, String body, String userID) throws IOException {
			res=given().log().all().spec(Payloads.requestSpecification())
					.header("Content-Type","application/json")
					.body(Payloads.AddPost(title, body, userID));	
		}


	@When("^user calls CreatAPostAPI with post http request$")
	public void user_calls_creatapostapi_with_post_http_request() throws Throwable {
	response = res.when().log().all().post("posts");
   
	}

	@Then("^the API call will success with status code 201$")
	public void the_api_call_will_success_with_status_code_201() throws Throwable {
		
		assertEquals(response.getStatusCode(),201);
	}

	@And("{string} {string} {string} and {string} will be displayed in the response body")
	public void title_body_userid_and_id_will_be_displayed_in_the_response_body(String title, String body, String userID,String id) throws Throwable {
		postJS=new JsonPath(response.asString());
		assertEquals(postJS.getString("title"),title);
		assertEquals(postJS.getString("body"),body);
		assertEquals(postJS.getString("userId"),userID);
		assertEquals(postJS.getString("id"),id);	
	}
	
	

}