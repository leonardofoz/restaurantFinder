package com.leonardo.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

	List<Restaurant> restaurants;
	List<Community> communitys;
	
	public RestaurantServiceImp() throws JsonParseException, JsonMappingException, IOException {
		restaurants = loadRestaurants();
	}

	@Override
	public List<Restaurant> getRestaurant(String session) {
		getSessionRestaurants(session);
		return restaurants;
	}
	
	@Override
	public Restaurant findById(int id, String session) {
		
		getSessionRestaurants(session);
		
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getId() == id) {
				return restaurant;
			}
		}
		return null;
	}

	public List<Restaurant> findRestaurantsByName(String name, String session) {
		
		getSessionRestaurants(session);
		
		List<Restaurant> listRest = new ArrayList<Restaurant>();
		
		for (Restaurant rest : restaurants) {
			if (rest.getName().toUpperCase().contains(name.toUpperCase())) {
				listRest.add(rest);
			}
		}
		return listRest;
	}

	@Override
	public void update(Restaurant restaurant, String session) {
		int index = restaurants.indexOf(restaurant);
		restaurants.set(index, restaurant);
		
		setSessionRestaurants(session);
	}

	public void updatePartially(Restaurant currentRestaurant, int id, String session) {
		
		for (Restaurant rest : restaurants) {
			if (rest.getId() == id) {
				rest.setFavorite(currentRestaurant.getFavorite());
				update(rest, session);
			}
		}
	}

	private List<Restaurant> loadRestaurants() throws JsonParseException, JsonMappingException, IOException {
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
	public List<Restaurant> findRestaurantsByName(String name, String sort, String session) {
		
		getSessionRestaurants(session);
		
		List<Restaurant> listRest = new ArrayList<Restaurant>();

		for (Restaurant rest : restaurants) {
			if (rest.getName().toUpperCase().contains(name.toUpperCase())) {

				if (sort != null) {
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
	
	private void getSessionRestaurants(String session){

		Boolean newSession = true;
		
		if(communitys != null) {
			for (Community community : communitys) {
				if(community.getSession().equals(session)) {
					
					restaurants = community.getRestaurants();
					newSession = false;
					break;
				}
			}
		}
		
		if(newSession) {
			Community comunity = new Community();
			List<Restaurant> newListSession = new ArrayList<Restaurant>();
			try {
				newListSession = loadRestaurants();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comunity.setRestaurants(newListSession);
			comunity.setSession(session);
			
			List<Community> listAuxCommunity = new ArrayList<Community>();
			listAuxCommunity.add(comunity);
			
			if(communitys != null) {
				communitys.addAll(listAuxCommunity);
			} else {
				communitys = new ArrayList<Community>();
				communitys.addAll(listAuxCommunity);
			}

			restaurants = comunity.getRestaurants();
		}

	}

	private void setSessionRestaurants(String session) {
		
		if (communitys != null) {
			for (Community community : communitys) {
				if (community.getSession().equals(session)) {
					community.setRestaurants(restaurants);
					break;
				}
			}
		}
	}

}
