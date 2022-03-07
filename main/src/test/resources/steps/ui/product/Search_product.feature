@product
Feature: Search Product

  Scenario: Verify all the products related to search are visible
    Given Navigate to home page
    When Click on products button
    Then Verify ALL Products page
    When Entered product name in search input
    And Click search button
    Then Verify SEARCH PRODUCTS is visible
    And Verify all products related to search are visible