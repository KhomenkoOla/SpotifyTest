Feature: Login
  As a user
  I want to test error credentials popups on spotify login page
  So that I can be sure that error credentials popups works correctly

  Scenario Outline: Test Login with empty credentials
    Given User open main '<homePage>' page
    When User clicks home page login button
    And User check whether the home page has open '<expectedUrl>'
    And User type any credentials '<login>', '<password>'
    And User clear the inputs
    Then The user check the error messages

    Examples:
      | homePage                  | expectedUrl                   | login | password |
      | https://open.spotify.com/ | https://accounts.spotify.com/ | 121sd | asdasd   |