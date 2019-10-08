
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
 
### Estrutura da aplicação
```bash
restaurantFinder                             # — Root of your theme
├───src                                      # — Source files
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───leonardo
│   │   │           ├───config               # — Configuration classes
│   │   │           ├───controller           # Controller class
│   │   │           ├───model                # Pojos classes
│   │   │           ├───repository           # Spring Data repository abstraction
│   │   │           ├───restaurantFinder     # Main class
│   │   │           ├───service              # Implementation of repository
│   │   │           └───util                 # Utiliy classes responsible for organize the data
│   │   └───resources
│   │       ├───features
│   │       ├───json
│   │       └───static
│   │           ├───doc
│   │           └───tests_cases_reports
│   └───test
│       ├───java
│       │   └───com
│       │       └───leonardo
│       │           └───restaurantFinder
│       │               ├───runner
│       │               └───stepDefinition
│       └───resources
│           └───features
└───target
```

### Installation
A instalação poderá ser realizada de duas formas:

1) Baixando o projeto do GIT: https://github.com/leonardofoz/restaurantFinder.git e configurando a aplicação, em seu IDE favorito, como Spring Boot Application.
2) Baixando o jar da aplicação disponível no endereço: https://drive.google.com/open?id=1opGGVRmRfEUVEXCc7cBUI_KZkTzmqJCw

### Execução
Para execução fiz questão de integrar o GIT com o Heroku, para quando tiver qualquer nova implementação automáticamente será realizado o deploy no servidor do HEROKU, no seguinte endereço: https://leorestaurantfinder.herokuapp.com/

Caso tenha interesse de executar localmente a aplicação é só executar o JAR no terminal:
```
java -jar restaurantFinder-1.0.jar
```
A aplicação será inicializada na porta 9090, podendo ser acessada no seguinte endereço: http://localhost:9090/

### Usage
Forma de utilizar a aplicacao

### Documentation
Java Documentation:
https://leorestaurantfinder.herokuapp.com/doc/index.html

Rest API Interactive documentation:
https://leorestaurantfinder.herokuapp.com/swagger-ui.html

### Cases Reports:
https://leorestaurantfinder.herokuapp.com/tests_cases_reports/overview-features.html

### Support
Leonardo Silva Moraes - leonardofoz@gmail.com


