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
public class ListRestFilterByNameTest {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
    private String ENDPOINT_GET = "https://leorestaurantfinder.herokuapp.com/restaurant/";
 
	
	@Given("^Open browser and access the application at HEROKU$")
	public void open_browser_and_access_the_application_at_HEROKU() throws Throwable {
		request = given().param("nameSearch","sushi");
	}

	@When("^The user type the restaurant name sushi in the field search$")
	public void the_user_type_the_restaurant_name_sushi_in_the_field_search() throws Throwable {
		response = request.when().get(ENDPOINT_GET);
	}
	
	@When("^User types sushi in restaurant name and press enter$")
	public void user_types_sushi_in_restaurant_name_and_press_enter() throws Throwable {
		response = request.when().get(ENDPOINT_GET);
	}

	@Then("^user recieve the status code (\\d+)$")
	public void user_recieve_the_status_code(int arg1) throws Throwable {
		response = request.when().get(ENDPOINT_GET);
		json = response.then().statusCode(arg1);
	}

	@Then("^user should see a list of (\\d+) restaurants with sushi in the name$")
	public void user_should_receive_the_list_of_restaurants_with_sushi_in_the_name(int quantityRestaurant) throws Throwable {

		assertThat(quantityRestaurant, is(response.andReturn().jsonPath().getList("$").size()));

	}

}
