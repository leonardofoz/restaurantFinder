package com.leonardo.restaurantFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/**
 * Main Class responsible for start the application
 * @author lemoraes
 * @since 05/10/2019
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.leonardo.*")
public class RestaurantFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantFinderApplication.class, args);
	}

}

