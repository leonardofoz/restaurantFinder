package com.leonardo.repository;

import java.util.List;

import com.leonardo.model.Restaurant;

public interface RestaurantRepository {
	public List<Restaurant> getRestaurant();
	public Restaurant findById(int id);
	public void update(Restaurant restaurant);
	public void updatePartially(Restaurant restaurant, int id);
	public List<Restaurant> findRestaurantsByName(String name);
	public List<Restaurant> findRestaurantsByName(String name, String sort);
}



