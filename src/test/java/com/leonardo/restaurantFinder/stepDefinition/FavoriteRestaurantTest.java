package com.leonardo.restaurantFinder.stepDefinition;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class FavoriteRestaurantTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private String ENDPOINT_GET = "https://leorestaurantfinder.herokuapp.com/restaurant/";
  
	@Given("^Open browser and access the application at HEROKU adress$")
	public void open_browser_and_access_the_application_at_HEROKU_adress() throws Throwable {
		request = given().param("","");
	}
	
	@When("^user sees list of all restaurants and he/she select restaurant Mama Mia as favorite\\.$")
	public void user_sees_list_of_all_restaurants_and_he_she_select_restaurant_Mama_Mia_as_favorite() throws Throwable {
		//request.body();
		JSONObject requestParams = new JSONObject();
		requestParams.put("favorite", true);

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());

		response = request.when().patch(ENDPOINT_GET + "8");
	
		System.out.println(response.getBody().asString());
	}

	@Then("^user recieves status code (\\d+) \\(updated\\) and restaurant Mama Mia marked as favorite\\.$")
	public void user_recieves_status_code_updated_and_restaurant_Mama_Mia_marked_as_favorite(int arg1) throws Throwable {
		json = response.then().statusCode(arg1);
	}


}
