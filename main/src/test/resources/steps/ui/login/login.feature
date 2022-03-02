Feature: New User Signup
  BDD + DDT

  Scenario Outline: Signup with valid credentials
    Given User is "<id>"
    And User is on Home page
    And User click SignupLogin
    And User enter username
    And User enter password
    And User click Signup
    When User is on Account Information page
    And Select title
    And User re-enter username
    And Enter re-enter email
    And Enter password
    And Select DoB
    And Enter first name
    And Enter last name
    And Enter company
    And Enter address
    And Select country
    And Select state
    And Enter city
    And Enter zipcode
    And Enter mobile
    And Click on Create Account button
    Then I should be on Account page

    Examples:
      | id
      | 1
      | 2
      | 3
