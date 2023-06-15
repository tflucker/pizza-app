# pizza-app
Simple project to demonstrate deploying an API microservice


# Abstract
This project is meant to be a simple REST API microservice project which allows a customer to submit a pizza order. This microservice will be containerized using Docker and then a Jenkins job will deploy it to a cloud service.  For security and re-usability reasons some things may be genericized. 

## Technology Used
- Java 17 (programming language and version)
- Spring MVC (framework)
- Maven (dependency management)
- Docker (containerization)
- Jenkins (automation server)
- H2 (embedded database)
- Swagger (API documentation / design)


## API Functionality 

 - viewMenu (GET): returns a list of available PizzaOrder objects
 - orderPizza (POST): submit a pizza order 
 - trackOrder/{orderId} (GET): returns OrderStatus object related to the Pizza
 
 
## Database 

The data for this project is located in the `src/main/resources` folder under the `schema.sql` and `data.sql`.  This files are run on project start and are used to create an in-memory H2 database. This database is accessible locally at http://localhost:8080/h2-console with the username and password of `sa` and `password` respectively. 