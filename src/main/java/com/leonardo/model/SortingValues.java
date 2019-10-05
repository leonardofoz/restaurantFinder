package com.leonardo.model;

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
	
	public Double getBestMatch() {
		return bestMatch;
	}
	public void setBestMatch(Double bestMatch) {
		this.bestMatch = bestMatch;
	}
	public Double getNewest() {
		return newest;
	}
	public void setNewest(Double newest) {
		this.newest = newest;
	}
	public Double getRatingAverage() {
		return ratingAverage;
	}
	public void setRatingAverage(Double ratingAverage) {
		this.ratingAverage = ratingAverage;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getPopularity() {
		return popularity;
	}
	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}
	public Double getAverageProductPrice() {
		return averageProductPrice;
	}
	public void setAverageProductPrice(Double averageProductPrice) {
		this.averageProductPrice = averageProductPrice;
	}
	public Double getDeliveryCosts() {
		return deliveryCosts;
	}
	public void setDeliveryCosts(Double deliveryCosts) {
		this.deliveryCosts = deliveryCosts;
	}
	public Double getMinCost() {
		return minCost;
	}
	public void setMinCost(Double minCost) {
		this.minCost = minCost;
	}
	

	public TopRestaurant getTopRestaurant() {
			return topRestaurant;
		}
		public void setTopRestaurant(TopRestaurant topRestaurant) {
			this.topRestaurant = topRestaurant;
		}
	//	public TopRestaurant getTopRestaurant() {
//		return topRestaurant;
//	}
//	public void setTopRestaurant(TopRestaurant topRestaurant) {
//		this.topRestaurant = topRestaurant;
//	}
	@Override
	public String toString() {
		return "SortingValues [bestMatch=" + bestMatch + ", newest=" + newest + ", ratingAvarege=" + ratingAverage
				+ ", distance=" + distance + ", popularity=" + popularity + ", avarageProductPrice="
				+ averageProductPrice + ", deliveryCosts=" + deliveryCosts + ", minCost=" + minCost + "]";
	}

}
