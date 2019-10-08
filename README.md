$ tree
.
+-- pom.xml
+-- src
    +-- main
    ¦   +-- java
    ¦   ¦   +-- com
    ¦   ¦       +-- leonardo
    ¦   ¦           +-- RestaurantFinderApplication.java
    ¦   ¦           +-- config
    ¦   ¦               +-- ConfigurationCors.java
    ¦   ¦               +-- SwaggerConfig.java
    ¦   ¦           +-- controller
    ¦   ¦               +-- RestaurantController.java
    ¦   ¦           +-- model
    ¦   ¦               +-- Community.java
    ¦   ¦               +-- Restaurant.java
    ¦   ¦               +-- SortingValues.java
    ¦   ¦               +-- TopRestaurant.java
    ¦   ¦           +-- repository
    ¦   ¦               +-- RestaurantRepository.java
    ¦   ¦           +-- restaurantFinder
    ¦   ¦               +-- RestaurantFinderApplication.java
    ¦   ¦           +-- service
    ¦   ¦               +-- RestaurantServiceImp.java
    ¦   ¦           +-- util
    ¦   ¦               +-- Status.java
    ¦   ¦               +-- Utility.java
    ¦   +-- resources
    ¦       +-- json
    ¦       	+-- restaurants.json
    ¦       +-- static
    ¦           +-- index.html
    ¦           +-- doc
    ¦       +-- application.properties
    +-- test
        +-- java
		+-- com
			+-- leonardo
				+-- restaurantFinder
					RestaurantFinderApplicationTests.java
# Restaurant Search

### Description 
The application shows a list of restaurants. On the top of the list, are the Favorite restaurants, if any were set as. The priority of the exhibition is Openings Status (Open, Order Ahead or Currently Closed), the Sorting List or by the Searching its names.
   ##### Sorting list:
   - Top Restaurants
   - Best match
   - Newest
   - Rating average
   - Distance
   - Popularity
   - Average product price
   - Delivery costs
   - Minimum costs
 

### Installation
Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew. However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a specific context like a particular programming language version or operating system or has dependencies that have to be installed manually, also add a Requirements subsection. 

### Usage
Use examples liberally, and show the expected output if you can. It's helpful to have inline the smallest example of usage that you can demonstrate, while providing links to more sophisticated examples if they are too long to reasonably include in the README. 

### Support
Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address, etc. 
### Roadmap
If you have ideas for releases in the future, it is a good idea to list them in the README. 

### Author
Show your appreciation to those who have contributed to the project.