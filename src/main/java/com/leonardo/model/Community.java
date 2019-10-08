package com.leonardo.model;

import java.util.List;

public class Community {
	
	private List<Restaurant> restaurants;
	private String session;

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
	

}
