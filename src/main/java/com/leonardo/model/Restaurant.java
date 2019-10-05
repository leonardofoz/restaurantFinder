package com.leonardo.model;

public class Restaurant{

	private Integer id;
	private String name;
	private String status;
	private Integer statusImportance;
	private Boolean favorite;
	private SortingValues sortingValues;
	private String selectedSortName;
	private Double selectedSortValue;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SortingValues getSortingValues() {
		return sortingValues;
	}
	public void setSortingValues(SortingValues sortingValues) {
		this.sortingValues = sortingValues;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getFavorite() {
		return favorite;
	}
	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}
	public String getSelectedSortName() {
		return selectedSortName;
	}
	public void setSelectedSortName(String selectedSortName) {
		this.selectedSortName = selectedSortName;
	}
	public Double getSelectedSortValue() {
		return selectedSortValue;
	}
	public void setSelectedSortValue(Double selectedSortValue) {
		this.selectedSortValue = selectedSortValue;
	}
	public Integer getStatusImportance() {
		return statusImportance;
	}
	public void setStatusImportance(Integer statusImportance) {
		this.statusImportance = statusImportance;
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", status=" + status + ", favorite=" + favorite
				+ ", sortingValues=" + sortingValues + "]";
	}

}
