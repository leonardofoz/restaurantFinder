$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("List_Restaurants.feature");
formatter.feature({
  "line": 1,
  "name": "Search Restaurants Action",
  "description": "",
  "id": "search-restaurants-action",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Find some restaurants with sushi in the name",
  "description": "",
  "id": "search-restaurants-action;find-some-restaurants-with-sushi-in-the-name",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Open browser and access the application at HEROKU",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "The user type the restaurant name sushi in the field search",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user recieve the status code 200",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user should receive the list of 4 restaurants with sushi in the name",
  "keyword": "And "
});
formatter.match({
  "location": "SmokeTest.open_browser_and_access_the_application_at_HEROKU()"
});
formatter.result({
  "duration": 441302600,
  "status": "passed"
});
formatter.match({
  "location": "SmokeTest.the_user_type_the_restaurant_name_sushi_in_the_field_search()"
});
formatter.result({
  "duration": 3458471300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 29
    }
  ],
  "location": "SmokeTest.user_recieve_the_status_code(int)"
});
formatter.result({
  "duration": 2543556200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 32
    }
  ],
  "location": "SmokeTest.user_should_receive_the_list_of_restaurants_with_sushi_in_the_name(int)"
});
formatter.result({
  "duration": 131272600,
  "status": "passed"
});
});