Feature: Practice for tutorials point

  Background:
    Given user has the url and browser for Buttons

  Scenario: Buttons automation
    When user clicks on "Click Me" button
    Then message returned as "You have done a dynamic click"

  Scenario: Double Click automation
    When user clicks on "Double Click Me" button
    Then message returned as "You have Double clicked"

  Scenario: Right Click automation
    When user clicks on "Right Click Me" button
    Then context menu appears