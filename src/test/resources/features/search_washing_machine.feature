Feature: Search for best washing machine

  Scenario: Validate Amazon and Flipkart links in search results
    Given I open Google homepage
    When I search for "Best Washing Machine"
    Then I should see the search results
    And I count the number of Amazon and Flipkart links
    And I verify the titles and number of results on each Amazon and Flipkart link