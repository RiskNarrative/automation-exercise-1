SELENIUM CUCUMBER TEST AUTOMATION FRAMEWORK

OVERVIEW:
   This is a Selenium WebDriver and Cucumber-based test automation framework designed for web UI testing. The framework allows writing behavior-driven development (BDD) test cases in Gherkin syntax, improving readability and collaboration among developers, testers, and business stakeholders.

FEATURES: 
    Selenium WebDriver for browser automation.
    Cucumber BDD for writing test scenarios.
    JUnit/TestNG as the test runner.
    Page Object Model (POM) for maintainability.
    WebDriverManager for automatic driver setup.
   
Prerequisities:
    Java JDK
    Selenium(java language known)
    Maven
    Visual Studio Code
    Chrome
    Jar Files
    Dependencies in POM.xml

Project Structure:

selenium-cucumber-framework/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/          
│   │   │   ├── utils/          
│   ├── test/
│   │   ├── java/
│   │   │   ├── stepDefinitions/ 
│   │   │   ├── runners/         
│   │   ├── resources/
│   │   │   ├── features/        
│── pom.xml                      
│── README.md                    


TestCases : 

    Written in Gherkin Syntax
    Login Feature 
    StepDefinitions - LoginSteps

Reports :
    target/cucumber-reports 

Git :

    Feature Branch is created.
    Code is pushed to same branch.

Improvements: 
    Few steps could have been sequesed little to be more preciesed and due to time constraint, have it as readable/executable/ as possible.
