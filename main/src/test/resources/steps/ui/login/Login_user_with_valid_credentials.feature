@login
Feature: Exist user login
  BDD + DDT

  Scenario: Login with valid credentials
    Given User data initialised
    And User is on Home page
    And User click SignupLogin
    And User enter valid email
    And User enter valid password
    When User click Login
    Then User should see valid user name