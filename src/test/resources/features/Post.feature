@smoke @post
Feature: Create a new post on Feed

  Background:
    Given the user is logged into the application

  @valid
  Scenario: Post successfully on Profile Page
    When the user enters a postBody "Hello all! I wish you a pleasant day"
    And the user clicks on the post button
    Then the first post shows the correct body "Hello all! I wish you a pleasant day"
    Then the first post shows Just now