@regression @Api
Feature: API functionalities
  Background:
    Given Get a list of blog posts

  Scenario Outline: User should able to have posts
    Then Verify "<user>" have numposts as 10
    Examples:
    |user|
    |5   |
    |7   |
    |10  |

  Scenario: Each blog should able to have a unique ID
    Then Verify that per ID is unique


