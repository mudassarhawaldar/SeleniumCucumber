Feature: Practice for tutorials point

  Background:
    Given user has the url and browser for UploadDownload

  #Scenario: Download automation
    #When user click on download button
    #Then file gets downloaded in download directory

  Scenario: Upload automation
    When user click on choose file button
    And provides the path
    Then file gets uploaded