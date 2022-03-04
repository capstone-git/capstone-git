Feature: View category products

  Scenario: Verify that user is navigated to the specified category page
    Given Navigate to home page
    And Verify that categories are visible on left side bar
    When Click on Women category
    And Click on category link under Women category, ex: Dress
    Then Verify that category page is displayed and confirm text WOMEN-DRESS PRODUCTS
    When Click on any sub-category ex: link of Men jean category
    Then Verify that user is navigated to that category page ex: Men jean category page