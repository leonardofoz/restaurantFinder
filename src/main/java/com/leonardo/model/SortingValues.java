package com.leonardo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SortingValues {
	
	private Double bestMatch;
	private Double newest;
	private Double ratingAverage;
	private Double distance;
	private Double popularity;
	private Double averageProductPrice;
	private Double deliveryCosts;
	private Double minCost;
	private TopRestaurant topRestaurant;
}
