Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given I open the browser and navigate to "https://www.selenium.dev/selenium/web/web-form.html"
    When I enter Username "testuser" and Password "password123"
    When I select the Textarea and input as "Hello"
    When I set the range to 10
    When I select the radio button with id "my-radio-2"
    When I select the color red in the color picker
    When I select the next day in the date picker
    When I select "One" from the dropdown menu
    # When I select "New York" from the dropdownlist
    And I click on the submit button
    Then I should see the text "Form submitted"
