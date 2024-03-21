@db @smoke
Feature: Actor list gathering and controlling process
  Background:
    Given the user has authority to access database
  Scenario: The user wants to gather list of all actors
    When the user sends request to database for actor list
    Then the user should see the list of all actors

  Scenario Outline : The user wants to gather a specific user
    When the user sends request to database to get information of "<actor_id>"
    Then the user should see the correct actor
    Examples:
      | actor_id |