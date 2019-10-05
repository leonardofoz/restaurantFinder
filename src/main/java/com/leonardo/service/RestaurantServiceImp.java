package com.leonardo.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonardo.model.Community;
import com.leonardo.model.Restaurant;
import com.leonardo.model.SortingValues;
import com.leonardo.model.TopRestaurant;
import com.leonardo.repository.RestaurantRepository;
import com.leonardo.util.Status;

@Service
public class RestaurantServiceImp implements RestaurantRepository {

	private static List<Restaurant> restaurants;

	static {
		try {
			restaurants = listRestaurants();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Restaurant> getRestaurant() {
		return restaurants;
	}

	@Override
	public Restaurant findById(int id) {
		// TODO Auto-generated method stub
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getId() == id) {
				return restaurant;
			}
		}
		return null;
	}

	@Override
	public Restaurant findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Restaurant> findRestaurantsByName(String name) {
		List<Restaurant> listRest = new ArrayList<Restaurant>();
		
		for (Restaurant rest : restaurants) {
			if (rest.getName().contains(name)) {
				listRest.add(rest);
			}
		}
		return listRest;
	}

	@Override
	public void update(Restaurant restaurant) {
		int index = restaurants.indexOf(restaurant);
		restaurants.set(index, restaurant);
	}

	@Override
	public void deleteRestaurantById(int id) {
		// TODO Auto-generated method stub

	}

	public void updatePartially(Restaurant currentRestaurant, int id) {
		for (Restaurant rest : restaurants) {
			if (rest.getId() == id) {
				rest.setFavorite(currentRestaurant.getFavorite());
				update(rest);
			}
		}

	}

	private static List<Restaurant> listRestaurants() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("json/restaurants.json");

		Community comunity = objectMapper.readValue(is, Community.class);

		List<Restaurant> newListRestaurants = new ArrayList<Restaurant>();

		int i = 1;
		for (Restaurant restaurant : comunity.getRestaurants()) {
			Restaurant rest = new Restaurant();
			rest = restaurant;
			rest.setFavorite(false);
			rest.setId(i++);
			
			if(restaurant.getStatus().equals(Status.CLOSED.getStatus()))
				rest.setStatusImportance(Status.CLOSED.getImportance());
			else if(restaurant.getStatus().equals(Status.OPEN.getStatus()))
				rest.setStatusImportance(Status.OPEN.getImportance());
			else if(restaurant.getStatus().equals(Status.ORDER_AHEAD.getStatus()))
				rest.setStatusImportance(Status.ORDER_AHEAD.getImportance());

			SortingValues sort = new SortingValues();
			TopRestaurant top = new TopRestaurant();

			top.setTopRestaurant(
					(restaurant.getSortingValues().getDistance() * restaurant.getSortingValues().getPopularity())
							+ restaurant.getSortingValues().getRatingAverage());

			sort = restaurant.getSortingValues();
			sort.setTopRestaurant(top);

			rest.setSortingValues(sort);

			newListRestaurants.add(rest);

		}

		return newListRestaurants;
	}

	@Override
	public List<Restaurant> findRestaurantsByName(String name, String sort) {
		List<Restaurant> listRest = new ArrayList<Restaurant>();

		for (Restaurant rest : restaurants) {
			if (rest.getName().contains(name)) {

				if (!sort.equals(null)) {
					try {
						if (!sort.equals("topRestaurant")) {
							Field privateField = rest.getSortingValues().getClass().getDeclaredField(sort);
							privateField.setAccessible(true);
							Double value = (Double) privateField.get(rest.getSortingValues());
							rest.setSelectedSortName(sort);
							rest.setSelectedSortValue(value);
						} else {
							rest.setSelectedSortName(sort);
							rest.setSelectedSortValue(rest.getSortingValues().getTopRestaurant().getTopRestaurant());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				listRest.add(rest);

			}
		}
		return listRest;
	}

}
