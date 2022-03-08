@login
Feature: Invalid user login

  Scenario Outline: Login with invalid credentials
    Given User data initialised
    And User is on Home page
    And User click SignupLogin
    And User enter invalid Email "<email>"
    And User enter invalid Password "<password>"
    When User click Login
    Then I should see on Error message

    Examples:
      | email             | password |
      | ivalid@exaple.com | 1111     |
      | @exaple.com       | 2222     |
      | ivalidexaple.com  | 2222     |