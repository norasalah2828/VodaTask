package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import data.Payloads;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPostByIDStepDefinition {

	RequestSpecification res;
	Response response;
	JsonPath postJS;
	
		@Given("user calls GetPostByIdAPI with {string} Get http request") 
		public void user_calls_get_post_by_id_api_with_get_http_request(String postId) throws Throwable{
			res=given().log().all().spec(Payloads.requestSpecification());
	    	response = res.when().log().all().get("posts/"+postId);
		}
		
		@Then("^api call will success with status code 200$")
		public void api_call_will_success_with_status_code_200() throws Throwable {
			
			assertEquals(response.getStatusCode(),200);
		}
		
		@And("post details will be displayed in the response body")
		public void post_details_will_be_displayed_in_the_response_body() {
			postJS=new JsonPath(response.asString());
			assertEquals(postJS.getString("userId"),"1");
			assertEquals(postJS.getString("id"),"3");
			assertEquals(postJS.getString("title"),"ea molestias quasi exercitationem repellat qui ipsa sit aut");
			assertEquals(postJS.getString("body"),"et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut");

		}



}


