# new feature
# Tags: optional

Feature: Sign-in

  Scenario: user can navigate to sign in screen from homepage
    Given the user loads page "https://www.bbc.co.uk/"
    When the user clicks sign in
    Then the user should be shown the login form


  Scenario: user has valid credentials
    Given the user is on the sign in page "https://account.bbc.com/signin"
    When login details are inserted into the login form "d2733549@urhen.com" "4#6c%Lb?Fezb#Q$@"
    And the login button is pressed
    Then the login should be successful

  Scenario: user has invalid credentials
    Given the user is on the sign in page "https://account.bbc.com/signin"
    When login details are inserted into the login form "d2733549@urhen.com" "wrong_password"
    And the login button is pressed
    Then the login should be unsuccessful