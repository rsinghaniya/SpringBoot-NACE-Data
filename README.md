# SpringBoot-NACE-Data
This project was generated using spring boot 3.2.0 and Java Version 17 

# Setting up the project
  - Download the project from github to your local or clone using the git clone method
  - Import the project into your IDE as maven project.
  - My SQL DB instance will be required with a database created by name nacedata
  - Once all the dependencies are resolved, Run the project as Spring Boot Project and application will be deployed as http://localhost:8080
  - Once the server is started, you can go and check in mysql db if the table structure is created or not.

## Running the application
  - Run the application as Spring Boot Project.
  - Go to any Rest API Client like Postman
  - Use the APIs end point from the NaceDataController class to execute the endpoints.
  - Initially upload the NACE Data sheet using upload endpoint and then you can call the get endpoints to see the data from database in JSON format.

## Running unit tests
  - JUnit test cases are provided within the project and can be executed locally.
  - This test cases can be configured to be executed in CI/CD pipeline to be executed so that code coverage can also be checked on later.




