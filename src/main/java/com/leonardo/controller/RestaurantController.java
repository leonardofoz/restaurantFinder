package com.leonardo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import com.leonardo.model.Restaurant;
import com.leonardo.repository.RestaurantRepository;
import com.leonardo.util.Utility;

@RestController
@Scope("request")
@RequestMapping(value = { "/restaurant" })
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<Restaurant> getRestaurantsWithParams(@RequestParam(required = false) String nameSearch,
			@RequestParam(required = false) String sort) throws IOException {

		List<Restaurant> restaurants = new ArrayList<Restaurant>();

		if (nameSearch != null)
			restaurants = restaurantRepository.findRestaurantsByName(nameSearch, sort, RequestContextHolder.currentRequestAttributes().getSessionId());
		else
			restaurants = restaurantRepository.getRestaurant(RequestContextHolder.currentRequestAttributes().getSessionId());

		Utility.sortRestaurants(restaurants, sort);

		return restaurants;
	}

	@PatchMapping(value = "/{id}", headers = "Accept=application/json")
	public ResponseEntity<Restaurant> updateRestaurantPartial(@PathVariable("id") int id,
			@RequestBody Restaurant currentRestaurant) {
		
		Restaurant restaurant = restaurantRepository.findById(id,RequestContextHolder.currentRequestAttributes().getSessionId());
		if (restaurant == null) {
			return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
		}

		restaurantRepository.updatePartially(currentRestaurant, id, RequestContextHolder.currentRequestAttributes().getSessionId());
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

}