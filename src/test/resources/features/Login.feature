@smoke @login
Feature: Login to hapifyMe

  Background:
    Given the user opens the login page "https://test.hapifyme.com/login_register.php"

  @valid
  Scenario: Login successfully using valid credentials
    When the user enters email "andreea.cristina86@yahoo.com" to login
    And the user enters password "QAtest4#" to login
    And the user presses the login button
    Then the user should be redirected to the homepage

  @regression @negative
  Scenario Outline: Login failed with invalid data
    When the user enters email "<email>" to login
    And the user enters password "<password>" to login
    And the user presses the login button
    Then the user should see an error message "<error_message>"

    Examples:
      | email                    | password       | error_message                   |
      | user.andreea@test.com    | password123    | Email or password was incorrect |
      | andreea.test@abc.com     | abc#$444       | Email or password was incorrect |
      | cristina.test@yahoo.com  | wrong&1234     | Email or password was incorrect |