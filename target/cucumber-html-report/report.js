$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("List_Restaurants.feature");
formatter.feature({
  "line": 1,
  "name": "Search Restaurants By Name",
  "description": "",
  "id": "search-restaurants-by-name",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Find some restaurants named sushi",
  "description": "",
  "id": "search-restaurants-by-name;find-some-restaurants-named-sushi",
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
  "name": "User types sushi in restaurant name and press enter",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user recieve the status code 200",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user should see a list of 4 restaurants with sushi in the name",
  "keyword": "And "
});
formatter.match({
  "location": "ListRestFilterByNameTest.open_browser_and_access_the_application_at_HEROKU()"
});
formatter.result({
  "duration": 240945000,
  "status": "passed"
});
formatter.match({
  "location": "ListRestFilterByNameTest.user_types_sushi_in_restaurant_name_and_press_enter()"
});
formatter.result({
  "duration": 2324058000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 29
    }
  ],
  "location": "ListRestFilterByNameTest.user_recieve_the_status_code(int)"
});
formatter.result({
  "duration": 1525788600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 26
    }
  ],
  "location": "ListRestFilterByNameTest.user_should_receive_the_list_of_restaurants_with_sushi_in_the_name(int)"
});
formatter.result({
  "duration": 224710700,
  "status": "passed"
});
formatter.uri("List_Restaurants_Sort_Distance.feature");
formatter.feature({
  "line": 1,
  "name": "Search Restaurants Sort Distance Action",
  "description": "",
  "id": "search-restaurants-sort-distance-action",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Find some restaurants near the user\u0027s home",
  "description": "",
  "id": "search-restaurants-sort-distance-action;find-some-restaurants-near-the-user\u0027s-home",
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
  "name": "user sees list of all restaurants and selects sort by distance",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user recieves status code 200 (sucess)",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user will realize that restaurant \"Tanoshii Sushi\" is the closest to their home.",
  "keyword": "And "
});
formatter.match({
  "location": "ListRestFilterByNameTest.open_browser_and_access_the_application_at_HEROKU()"
});
formatter.result({
  "duration": 356100,
  "status": "passed"
});
formatter.match({
  "location": "ListRestSortDistanceTest.user_see_all_restaurants_and_select_sort_by_Distance()"
});
formatter.result({
  "duration": 255600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 26
    }
  ],
  "location": "ListRestSortDistanceTest.user_recieve_the_status_code_sucess(int)"
});
formatter.result({
  "duration": 1561482800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Tanoshii Sushi",
      "offset": 35
    }
  ],
  "location": "ListRestSortDistanceTest.user_will_realize_that_restaurant_is_the_closest_to_their_home(String)"
});
formatter.result({
  "duration": 155732900,
  "status": "passed"
});
});