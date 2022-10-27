Feature: Login
  he as user registed, and i am need log in

  Scenario Outline: Login
    Given he is a user registed and can login
    When he send the credencials of access "<email>" and "<password>"
    Then he access to the page
    Examples:
      | email             | password |
      | jarv078@gmail.com | 123qwe   |




