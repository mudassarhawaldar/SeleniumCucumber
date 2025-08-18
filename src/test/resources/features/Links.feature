Feature: Practice for tutorials point

  Background:
    Given user has the url and browser for links

  Scenario: Links automation
    When user clicks on the "Home" link
    Then new windows gets opened
    Then user clicks on "Java" menu
    And closes the window