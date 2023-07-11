Feature: Correct login
  As a user
  I want to test correct login on spotify login page
  So that I can be sure that login works correctly

  Scenario Outline: Test Login with correct credentials
    Given User open main '<homePage>' page
    When User clicks home page login button
    And User check whether the home page has open '<expectedUrl>'
    And User type any credentials '<login>', '<password>'
    And User clicks login button
    Then The user check logged in page with '<userName>' name

    Examples:
      | homePage                  | expectedUrl                   | login                        | password   | userName |
      | https://open.spotify.com/ | https://accounts.spotify.com/ | bnmomrzfwjqyfwxmjk@cazlq.com | HTest@32   | 23423    |