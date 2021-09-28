@regression @crawl
Feature: User should able to open up Shop By Department and make sure there are no dead links

  Scenario: Make sure no dead links in the 'Shop By Department' dropdown box
    Given Go to homepage
    And Verify that title contains "Amazon.com. Spend less. Smile more."
    And Click all drop down button
    When Get a list of all department links and verify that no dead link exist