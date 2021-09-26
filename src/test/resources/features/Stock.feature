
Feature: User should able to navigate to homepage and able to search
  @wip
  Scenario: Go to Amazon.com and verify
    Given Go to homepage
    Then Verify that title contains "Amazon.com. Spend less. Smile more."
  @wip
  Scenario: Search by laptop
    Given Send "laptop" into the search box
    When Click search box
    Then Verify that title contains "Amazon.com : laptop"
  @wip
  Scenario: Add the non-discounted products in stock on the first page of the search results to the card
    Then Select non-discounted products and add into the stock
  @wip
  Scenario:  Go to card and checks if the products are right
    Given Go to inputbox
    When Take all products and place in a set
    Then Verify the products are right


