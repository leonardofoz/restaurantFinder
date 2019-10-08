package com.leonardo.restaurantFinder.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
	glue = {"com.leonardo.restaurantFinder.stepDefinition"}, 
	plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"})
public class TestRunner {
	

}
