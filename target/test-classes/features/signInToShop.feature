Feature: Sign in to shop

  Background:
    Given Home page is opened
    When I open Login Page
    Then Login Page is opened

#  Scenario: Authentication - empty login form
#    And I click Sign In button
#    Then I can see error message "An email address required."

  Scenario Outline: Authentication - incorrect values
    And I fill email address field "<emailAddress>"
    And I fill password field "<password>"
    And I click Sign In button
    Then I can see error message "<errorMessage>"
    Examples:
      | emailAddress  | password | errorMessage               |
      |               |          | An email address required. |
      | invalid email | test     | Invalid email address.     |
      | test_test.pl  | test     | Invalid email address.     |
      | test@test.pl  |          | Password is required.      |
      | test@test.pl  | 1        | Invalid password.          |
      | test@test.pl  | 111111   | Authentication failed.     |


  Scenario: Authentication - positive flow
    When I authenticate using credentials
      | email address     | password |
      | zdautpol4@test.pl | 12345    |
    Then I can see My Account Page



