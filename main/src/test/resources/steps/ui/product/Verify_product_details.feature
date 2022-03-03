Feature: Verify all products and product description page

  Scenario: Verify all products and product detail page
    Given Navigate to home page
    When Click on products button
    Then Verify ALL Products page
    When Click on View Product of first product
    Then Verify user is landed to product detail page
    And Verify product name is visible
    And Verify category is visible
    And Verify price is visible
    And Verify product availability is visible
    And Verify condition is visible
    And Verify brand is visible
