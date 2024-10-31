Feature: Test the login feature of shopping website
  Login feature enables user to login to shopping website


  Scenario Outline: : Login Successful DDT
    Given User is on the login page
    When User provides valid credentials and submits form "<username>" "<password>"
    Then User should login
    Examples:
      |username  | password |
      | saish | 123 |
      | qaautomation@gmail.com | Java@101 |