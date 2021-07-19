# restapi-cucumber-httpclient
REST API automation framework using Cucumber, Apache Http Client

## Project Description
This project is to implement a framework for REST API automation tests with Cucumber and Apache Http Client for sample ReqRes APIs. Project was developed using:
1. Cucumber - 6.10.4 - latest version
2. Apache Http Components - Http Client - 4.5.13 - latest version
3. Lombok - annotations and clean code
4. Jackson Core Databind - Object Mapper - to serialize objects to json and to deserialize json to objects

_Note:_ RestAssured, the widely used testing library for API automation is a wrapper built on Apache Http Client
## Design

### POJO Classes:
1. To enable easy test creation and maintenance, the request and response json fields are modeled as POJO classes
2. Use of Lombok annotations helps simplify the creation of classes as only the fields need to be declared
3. _Request:_ To create request JSON, it is sufficient to create object(s) for the corresponding request model classes and set values according to the tests. Then Object Mapper (Jackson - databind) can be used to serialize the object(s) to json before submitting API calls
4. _Response:_ To enable ease of access and parsing response JSON, object mapper can parse the response JSON string as object(s) of response model classes
2. POJO classes can be found at _src/test/java/com/automation/demo/models_ package

### Acceptance Tests:
1. Acceptance Tests written as Cucumber feature file can be found at _src/test/resources/features/ReqResApiTests.feature_
2. The tests perform a Get and Post call to APIs hosted at https://reqres.in/

### Assertions:
1. JUnit assertion methods are used to verify response JSON data

### Prerequisites to Run the project
1. Environment Requirements: Maven v3.5.4 or later, Java 1.8 or later, Eclipse or IntelliJ IDE

## Execution Instructions
1. After cloning the project, compile using the IDE Maven plugin or `mvn clean compile`
2. Review the code to understand the flow
3. _src/test/java_ - has the code for Cucumber tests implementation
5. _src/test/resources_ - has the feature file

### Command Line:

`mvn clean test` - This will run the scenarios in Cucumber feature files

### Run Configuration:

Alternative way to run the project is by use of:
TestRunner at _src/test/java/com/automation/demo/TestRunner.java_ or
Using IDE Run configuration, for IntelliJ:

1. Right click project and click Run as
2. Select Maven Build
3. Enter goals - clean test
4. Click Run

### Reports Location:
After execution, reports can be accessible via the link displayed in the maven logs (provided by Cucumber latest version).

When this project is integrated in a Jenkins pipeline, _cucumber.json_ file in _target/cucumber-reports_ can be integrated in the Build using Jenkins Cucumber plugin
