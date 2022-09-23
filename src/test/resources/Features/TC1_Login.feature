@Login
Feature: Verifying Adactin Login Hotel details

  Scenario Outline: Veryfying Adactin login with valid credentials
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verify after login "Hello Velumani!"

    Examples: 
      | username | password  |
      | Velumani | Mine@123# |

  Scenario Outline: Verifying Adactin login with valid credentials with Enter
    Given User is on the adactin page
    When User should perform login "<username>","<password>" with entry key
    Then User should verify after login "Hello Velumani!"

    Examples: 
      | username | password  |
      | Velumani | Mine@123# |

  Scenario Outline: Verifying Adactin login with invalid credentials
    Given User is on the adactin page
    When User should perform login "<username>","<password>"
    Then User should verifying after login error contains "Invalid Login details or Your Password might have expired. Click here to reset your password"

    Examples: 
      | username | password |
      | Velumani | Came@1   |
