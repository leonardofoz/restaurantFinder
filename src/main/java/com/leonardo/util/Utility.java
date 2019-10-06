package com.leonardo.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leonardo.model.Restaurant;
/**
 * Utiliy class responsible for organize the data
 * @author lemoraes
 * @since 05/10/2019
 */
public final class Utility {
	
	static String sortType = null;
	
	public static List<Restaurant> sortRestaurants(List<Restaurant> restaurants, String sortType) {
		
		Utility.sortType = sortType;
		
		if(sortType != null) {
		    Collections.sort(restaurants, new FavoriteSorter()
		    		.thenComparing(new OpeningSorter()
		    		.thenComparing(new SortingSorter())));
		} else {
			Collections.sort(restaurants, new FavoriteSorter()
					.thenComparing(new OpeningSorter()));
		}
			

		return restaurants;
	}
	
	private static class FavoriteSorter implements Comparator<Restaurant>
	{
	    public int compare(Restaurant o1, Restaurant o2)
	    {
	        return o2.getFavorite().compareTo(o1.getFavorite());
	    }
	}

	private static class OpeningSorter implements Comparator<Restaurant>
	{
	    public int compare(Restaurant o1, Restaurant o2)
	    {
	        return o1.getStatusImportance().compareTo(o2.getStatusImportance());
	    }
	}
	 
	private static class SortingSorter implements Comparator<Restaurant>
	{

	    public int compare(Restaurant o1, Restaurant o2)
	    {
	    	switch (sortType) {
			case "bestMatch":
				return o2.getSortingValues().getBestMatch().compareTo(o1.getSortingValues().getBestMatch());
			case "newest":
				return o1.getSortingValues().getNewest().compareTo(o2.getSortingValues().getNewest());
			case "ratingAverage":
				return o2.getSortingValues().getRatingAverage().compareTo(o1.getSortingValues().getRatingAverage());
			case "distance":
				return o1.getSortingValues().getDistance().compareTo(o2.getSortingValues().getDistance());
			case "popularity":
				return o2.getSortingValues().getPopularity().compareTo(o1.getSortingValues().getPopularity());
			case "averageProductPrice":
				return o1.getSortingValues().getAverageProductPrice().compareTo(o2.getSortingValues().getAverageProductPrice());
			case "deliveryCosts":
				return o1.getSortingValues().getDeliveryCosts().compareTo(o2.getSortingValues().getDeliveryCosts());
			case "minCost":
				return o1.getSortingValues().getMinCost().compareTo(o2.getSortingValues().getMinCost());
			case "topRestaurant":
				return o2.getSortingValues().getTopRestaurant().getTopRestaurant().compareTo(o1.getSortingValues().getTopRestaurant().getTopRestaurant());
			default:
				return 0;
			}
	        
	    }
	}

}
