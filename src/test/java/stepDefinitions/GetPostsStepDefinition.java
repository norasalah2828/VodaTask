package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import data.Payloads;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
public class GetPostsStepDefinition {
	
	RequestSpecification res;
	Response response;
	JsonPath postJS;

    @Given("^user calls GetAllPostsAPI with Get http request$")
    public void user_calls_getallpostsapi_with_get_http_request() throws Throwable {
    	res=given().log().all().spec(Payloads.requestSpecification());
    	response = res.when().log().all().get("posts");
    			
    }
    
    @Then("^the API call will success with status code 200$")
    public void the_api_call_will_success_with_status_code_200() throws Throwable {
    	assertEquals(response.getStatusCode(),200);
    }
    @And("^posts details will be displayed in the response body$")
    public void posts_details_will_be_displayed_in_the_response_body() throws Throwable {
    	postJS=new JsonPath(response.asString());
    	//assertEquals(postJS.getString("userId"),"1");
    	  String actualUserIds = postJS.getString("userId");
    	  String expectedUserIds = "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]";
    	  assertEquals(expectedUserIds, actualUserIds);
    
    	
    }

}