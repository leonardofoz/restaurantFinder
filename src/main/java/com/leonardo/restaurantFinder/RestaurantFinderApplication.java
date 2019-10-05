package com.leonardo.restaurantFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages = {"com.leonardo"}) 

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.leonardo.*")
public class RestaurantFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantFinderApplication.class, args);
	}

}

