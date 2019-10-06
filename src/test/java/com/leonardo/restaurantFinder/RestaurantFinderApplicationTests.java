package com.leonardo.restaurantFinder;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class RestaurantFinderApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getAllRestaurants() throws Exception
	{
	  mvc.perform(get("/"))
          .andExpect(status().isOk());
	}
	
	@Test
	public void getRestaurantByName() throws Exception
	{
	  mvc.perform(get("/?nameSearch=Tanoshii"))
          .andExpect(status().isOk());
	}
	
	@Test
	public void getRestaurantByNameAndSort() throws Exception
	{
	  mvc.perform(get("/?nameSearch=Tanoshii&sort=popularity"))
          .andExpect(status().isOk());
	}
	
	@Test
	public void getRestaurantByWrongName() throws Exception
	{
	  mvc.perform(get("/?nameSearch=Leonardo"))
	      .andExpect(content().string(""));
	}
	
    @Test
    public void updateFavoriteRestaurant() throws Exception {
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.patch("http://localhost:9090/restaurant/2")
				.accept(MediaType.APPLICATION_JSON).content("{\"favorite\": true}")
				.contentType(MediaType.APPLICATION_JSON_VALUE);
    	
    	MvcResult result = mvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
