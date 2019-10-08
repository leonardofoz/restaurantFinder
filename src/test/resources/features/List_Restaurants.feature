Feature: Search Restaurants By Name
 
Scenario: Find some restaurants named sushi
 Given Open browser and access the application at HEROKU
 When User types sushi in restaurant name and press enter
 Then user recieve the status code 200
 And user should see a list of 4 restaurants with sushi in the name
