@smoke @register
Feature: Register to hapifyMe

  Background:
    Given the user opens the login page "https://test.hapifyme.com/login_register.php"
    And the user clicks on the register link

  @valid
  Scenario: Register successfully using valid credentials
    When the user enters first name "random name"
    And the user enters last name "random name"
    And the user enters email "random email"
    And the user enters password "random password"
    And the user presses the register button
    Then the user should see a success message "You're all set! Go ahead and login! Please check your email to activate your account."

  @regression @negative
  Scenario Outline: Register fails when a required field is missing
    When the user enters first name "<firstName>"
    And the user enters last name "<lastName>"
    And the user enters email "<email>"
    And the user enters password "<password>"
    And the user presses the register button
    Then the required field should show the browser validation message "<errorMessage>"

    Examples:
      | firstName | lastName | email           | password | errorMessage                |
      |           | Marin    | test1@mail.com  | Test123# | Please fill in this field.  |
      | Andreea   |          | test2@mail.com  | Test123# | Please fill in this field.  |
      | Andreea   | Marin    |                 | Test123# | Please fill in this field.  |
      | Andreea   | Marin    | test3@mail.com  |          | Please fill in this field.  |