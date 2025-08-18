Feature: Practice for tutorials point

  Background:
    Given user has the url and browser for BrowserWindow

  Scenario: New tab automation
    When user clicks on new tab
    Then new tab gets open

  Scenario: New window automation
    When user clicks on new window
    Then new window gets open