
@tag1
Feature: Test login functionality of e-commerce website
  Description of it

  Background:
    Given I have landed to the home page

  Scenario: Login to application
    Given I'm on the website
    When I set username to "qaautomation@gmail.com" and password to "Java@101"
    Then Verify the if I'm able to login


#  Scenario Outline: Login to application
#    Given I go to to website https://rahulshettyacademy.com/client
#    When I set <username> and <password> is set
#    Then Verify the <status>
#    Examples:
#      |username              |password| status |
#      |qaautomation@gmail.com|Java@101| pass   |
#      |username              |password| fail   |