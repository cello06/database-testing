@db @smoke
Feature: Actor list gathering and controlling process


  Scenario: The user wants to gather list of all actors
    Given the user has authority to access database
    When the user sends request to database for actor list
    Then the user should see the list of all actors

  Scenario Outline: The user wants to gather a specific user
    Given the user has authority to access database
    When the user sends request to database to get information of "<actor_id>"
    Then the user should see the correct actor with "<firs_name>","<last_name>" and "<last_update>"
    Examples:
      | actor_id | firs_name | last_name | last_update            |
      | 1        | Penelope  | Guiness   | 2013-05-26 14:47:57.62 |
      | 11       | Zero      | Cage      | 2013-05-26 14:47:57.62 |
      | 21       | Kirsten   | Paltrow   | 2013-05-26 14:47:57.62 |
      | 23       | Sandra    | Kilmer    | 2013-05-26 14:47:57.62 |
      | 24       | Cameron   | Streep    | 2013-05-26 14:47:57.62 |
      | 25       | Kevin     | Bloom     | 2013-05-26 14:47:57.62 |
