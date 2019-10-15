package com.leonardo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Restaurant{

	private Integer id;
	private String name;
	private String status;
	private Integer statusImportance;
	private Boolean favorite;
	private SortingValues sortingValues;
	private String selectedSortName;
	private Double selectedSortValue;

}
