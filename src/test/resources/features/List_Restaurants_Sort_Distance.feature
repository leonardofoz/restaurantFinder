Feature: Search Restaurants Sort Distance Action
 
Scenario: Find some restaurants near the user's home
 Given Open browser and access the application at HEROKU
 When user sees list of all restaurants and selects sort by distance
 Then user recieves status code 200 (sucess)
 And user will realize that restaurant "Tanoshii Sushi" is the closest to their home.
