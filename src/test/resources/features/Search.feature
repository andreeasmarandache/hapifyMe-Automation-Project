@smoke @search
Feature: Search for a user profile

  Background:
    Given the user is logged into the application

  @valid
  Scenario: Search successfully a profile
    When the user searches for a profile named "Andreea Smarandache"
    And the user clicks on the search button
    Then the user profile is displayed