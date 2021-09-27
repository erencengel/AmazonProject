@regression
Feature: User should able to navigate to homepage and able to search

  Scenario: Go to Amazon.com and verify
    Given Go to homepage
    And Verify that title contains "Amazon.com. Spend less. Smile more."
    When Send "laptop" into the search box
    And Click search box
    And Verify that title contains "Amazon.com : laptop"
    And Select non-discounted products and add into the stock
    And Go to inputbox
    And Take all products and place in a set
    Then Verify the products are right


