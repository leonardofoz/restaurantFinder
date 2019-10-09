Feature: Testing a REST API for Search Restaurants
  Users should be able to submit GET and PATCH requests to a web service.

Scenario: Find some restaurants named sushi
 Given Open browser and access the application at HEROKU
 When User types sushi in restaurant name and press enter
 Then user recieve the status code 200
 And user should see a list of 4 restaurants with sushi in the name

Scenario: Find some restaurants near the user's home
 Given Open browser and access the application at HEROKU
 When user sees list of all restaurants and selects sort by distance
 Then user recieves status code 200 (sucess)
 And user will realize that restaurant "Tanoshii Sushi" is the closest to their home.
 
Scenario: Favorite one restaurant in the list
 Given Open browser and access the application at HEROKU adress
 When user sees list of all restaurants and he/she select restaurant Mama Mia as favorite.
 Then user recieves status code 200 (updated) and restaurant Mama Mia marked as favorite.