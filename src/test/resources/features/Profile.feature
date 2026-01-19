@smoke @profile
Feature: Edit user profile

  Background:
    Given the user is logged into the application

  @valid
  Scenario: Edit user profile
    When the user clicks on the settings button
    And the user updates the profile details:
      | field      | value        |
      | FirstName  | Cristina     |
      | LastName   | Smarandache  |
    And the user clicks on the update details button
    Then the user should see the message "Details updated!"