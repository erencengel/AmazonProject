@regression
@wip
Feature: User should able to navigate to homepage and able to search

  Scenario: Go to Amazon.com and verify
    Given Go to homepage
    Then Verify that title contains "Amazon.com. Spend less. Smile more."

  Scenario: Search by laptop
    Given Send "laptop" into the search box
    When Click search box
    Then Verify that title contains "Amazon.com : laptop"

  Scenario: Add the non-discounted products in stock on the first page of the search results to the card
    Then Select non-discounted products and add into the stock


