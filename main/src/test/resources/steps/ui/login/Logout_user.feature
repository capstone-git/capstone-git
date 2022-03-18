@login
Feature: Logout user
  BDD + DDT

  Background: Login with valid credentials
    Given User data initialised
    And User is on Home page
    And User click SignupLogin
    And User enter valid email
    And User enter valid password
    When User click Login
    Then User should see valid user name

  Scenario: Logout user
    Given User is on Home page
    When User click Logout
    Then User should be on Login page