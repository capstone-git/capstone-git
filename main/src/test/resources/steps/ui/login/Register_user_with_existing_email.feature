@login
Feature: Exist user registration

  Scenario: Register exist user
    Given User data initialised
    And User is on Home page
    And User click SignupLogin
    And User enter exist username
    And User enter exist email
    When User click Signup
    Then User should see Error message