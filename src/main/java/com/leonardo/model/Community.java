package com.leonardo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Community {
	
	private List<Restaurant> restaurants;
	private String session;

}
