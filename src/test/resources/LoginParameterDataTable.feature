@smoke
Feature: Test the login feature of shopping website
  Login feature enables user to login to shopping website


  Scenario: Login Successful DataTable
    Given User is on the login page
    When User provides valid credentials and submits form data table
    |qaautomation@gmail.com|Java@101|
    Then User should login