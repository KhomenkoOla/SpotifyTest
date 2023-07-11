Feature: Incorrect login
  As a user
  I want to test incorrect login on spotify login page
  So that I can be sure that  incorrect login popups works correctly

  Scenario Outline: Test Login with incorrect credentials
    Given User open main '<homePage>' page
    When User clicks home page login button
    And User check whether the home page has open '<expectedUrl>'
    And User type any credentials '<login>', '<password>'
    And User clicks login button
    Then The user check the banner error messages

    Examples:
      | homePage                  | expectedUrl                   | login | password |
      | https://open.spotify.com/ | https://accounts.spotify.com/ | 121sd | asdasd   |