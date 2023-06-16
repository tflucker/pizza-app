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
 - customers/{customerId} (GET): returns the customer information based on provided ID
 - customers/{customerName} (GET): returns the customer information based on provided name
 - customers/new (POST): creates a new customer with the provided information
 
 - viewMenu (GET): returns a list of available PizzaOrder objects
 - orderPizza (POST): submit a pizza order 
 - trackOrder/{orderId} (GET): returns OrderStatus object related to the Pizza
 
 
## Database 

The data for this project is located in the `src/main/resources` folder under the `schema.sql` and `data.sql`.  This files are run on project start and are used to create an in-memory H2 database. This database is accessible locally at http://localhost:8080/h2-console with the username and password of `sa` and `password` respectively. Since this DB is in-memory it will be created with the Docker image and requires no additional setup when testing the image or when it is deployed.

## Testing

A Postman collection has been provided in the source code as a way to locally test the application.  It can be found in the `src/main/resources` folder with a `.postman` extension.

## Dockerizing the application

1. Run a clean maven build on the project: `mvn clean install`
2. Run this command to create a new image: `docker build --no-cache -t <your-tag-name> .`
3. Test locally that the image runs: `docker run -p 8080:8080 <your-tag-name>
4. The result of the previous step will run the application at http://localhost:8080.  The postman collection can be used to further verify that the APIs are deployed and querying the database properly.