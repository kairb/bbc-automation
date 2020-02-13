# new feature
# Tags: optional

Feature: site-navigation

  Background:
    Given the user loads page "https://www.bbc.co.uk/"

  Scenario: homepage loads correctly
    Then the page should render correctly

  Scenario: navigate between main bbc categories
    When the user clicks news
    Then the user should be redirected to the news page