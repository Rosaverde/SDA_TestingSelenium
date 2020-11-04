Feature: First search in Google page

  Scenario Outline: Search for SDA
    Given Google Page is opened
    When I close Cookie frame
    And I search for phrase "<searchPhrase>"
    Then I can see search results
    Examples:
      | searchPhrase                 |
      | Software Development Academy |
      | Selenium Cucumber            |
      | Cucumber Junit manual        |
