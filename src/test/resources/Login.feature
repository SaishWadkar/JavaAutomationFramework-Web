Feature: Test the login feature of shopping website
  Login feature enables user to login to shopping website


  Scenario: Login Successful
    Given User is on the login page
    When User provides valid credentials and subits form
    Then User should login