package com.leonardo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.model.Restaurant;
import com.leonardo.repository.RestaurantRepository;
import com.leonardo.util.Utility;

@RestController
@RequestMapping(value = { "/restaurant" })
public class RestaurantController {
	@Autowired
	RestaurantRepository restaurantRepository;
	
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	 public String welcome() {
	  return "index.html";
	 }

	@GetMapping(value = "/list", headers = "Accept=application/json")
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> tasks = restaurantRepository.getRestaurant();
		
		Utility.sortRestaurants(tasks, null);

		return tasks;
	}

	@GetMapping(value = "/listWithParameters", headers = "Accept=application/json")
	public List<Restaurant> getWithMultipleRequestParams(@RequestParam(value = "nameSearch") String nameSearch,
			@RequestParam(value = "sort") String sort) throws IOException {
		
		List<Restaurant> tasks = restaurantRepository.findRestaurantsByName(nameSearch,sort);
		
		Utility.sortRestaurants(tasks, sort);
		
		return tasks;
	}

	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<Restaurant> updateRestaurantPartial(@PathVariable("id") int id, @RequestBody Restaurant currentRestaurant){
		Restaurant restaurant = restaurantRepository.findById(id);
		if(restaurant ==null){
			return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
		}
		
		restaurantRepository.updatePartially(currentRestaurant, id);
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

}