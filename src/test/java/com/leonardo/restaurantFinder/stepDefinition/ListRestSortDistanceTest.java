package com.leonardo.restaurantFinder.stepDefinition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.assertj.core.api.Assert;

import com.leonardo.model.Restaurant;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ListRestSortDistanceTest {
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private String ENDPOINT_GET = "https://leorestaurantfinder.herokuapp.com/restaurant/";
  
	@Given("^Open browser and access the application at HEROKU and looking$")
	public void open_browser_and_access_the_application_at_HEROKU_and__looking() throws Throwable {
		request = given().param("","");
	}

	@When("^user sees list of all restaurants and selects sort by distance$")
	public void user_see_all_restaurants_and_select_sort_by_Distance() throws Throwable {
		request = given().param("sortBy","distance");
	}
	
	@Then("^user recieves status code (\\d+) \\(sucess\\)$")
	public void user_recieve_the_status_code_sucess(int arg1) throws Throwable {
		response = request.when().get(ENDPOINT_GET);
		json = response.then().statusCode(arg1);
	}
	
	@Then("^user will realize that restaurant \"([^\"]*)\" is the closest to their home\\.$")
	public void user_will_realize_that_restaurant_is_the_closest_to_their_home(String restaurantName) throws Throwable {
	    String restaurantReturn = response.andReturn().jsonPath().get("name[0]");
	    assertThat(restaurantReturn,is(restaurantName));		
	}

}
