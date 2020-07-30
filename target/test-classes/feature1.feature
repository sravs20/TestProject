Feature: Test AUT login functionality

  @smoke
  Scenario Outline: Check login behaviour with valid and invalid credentials
    Given I am on AUT login page
    When I enter "<Username>" and "<Password>"
    And I hit Login button
    Then I see successfully login to the application
    Examples:
      | Username                  | Password    |
      | test@qa-experience.com    | Password1   |