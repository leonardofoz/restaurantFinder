package com.leonardo.repository;

import java.util.List;

import com.leonardo.model.Restaurant;

public interface RestaurantRepository {
	public List<Restaurant> getRestaurant(String session);
	public Restaurant findById(int id, String session);
	public void update(Restaurant restaurant, String session);
	public void updatePartially(Restaurant restaurant, int id, String session);
	public List<Restaurant> findRestaurantsByName(String name, String sort, String session);
}



