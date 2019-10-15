package com.leonardo.repository;

import java.util.List;

import com.leonardo.model.Restaurant;

public interface RestaurantRepository {
	List<Restaurant> getRestaurant(String session);
	Restaurant findById(int id, String session);
	void update(Restaurant restaurant, String session);
	void updatePartially(Restaurant restaurant, int id, String session);
	List<Restaurant> findRestaurantsByName(String name, String sort, String session);
}



