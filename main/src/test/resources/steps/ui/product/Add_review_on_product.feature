Feature: Add review on product

  Scenario: Add review on first product
    Given Navigate to home page
    When Click on products button
    Then Verify ALL Products page
    When Click on View Product of first product
    Then Verify Write Your Review is visible
    When Entered name
    And Entered email
    And Entered review
    Then Click on Submit button
    And Verify success message : Thank you for your review