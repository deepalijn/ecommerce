This project is a simple Ecommerce Microservices System built using Spring Boot and Spring Cloud.
It demonstrates fundamental microservice concepts:

Service Discovery (Eureka Server)

API Gateway for routing

Multiple Microservices
    Product Service
    Inventory Service
    Order Service

In-memory H2 Database for each service
Inter-service communication via OpenFeign
Built with Java 17 & Spring Boot 3


How to Run project 
1. Clone the projectgit clone <your-repo-url>
   cd ecommerce
2. Build all modules
   mvn clean install -DskipTests
3.Start services (in this order)
   1. Start Eureka Server
      cd eureka-server
      mvn spring-boot:run
   2. Start api gateway
      cd api-gateway
      mvn spring-boot:run
   3. Start Product Service   
      cd product-service
      mvn spring-boot:run
   4. Start Inventory Service   
      cd inventory-service
      mvn spring-boot:run
   5. Start Order Service   
      cd order-service
      mvn spring-boot:run
      
4. Accessing services
   Product Service(direct)
   http://localhost:8081/products
   Inventory Service(direct)
   http://localhost:8082/inventory
   Order Service(direct)
   http://localhost:8082/orders
   Through API gateway
   http://localhost:8080/product-service/products
   http://localhost:8080/inventory-service/inventory
   http://localhost:8080/order-service/orders

