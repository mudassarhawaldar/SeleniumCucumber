Feature: Practice for tutorials point

  Scenario: Student registration form
    Given user has the url and browser
    When user enters username "student1"
    And email as "student1@gmail.com"
    And selects gender as "Male"
    And enters mobile number as "1234567890"
    And enters Date of Birth as "21-02-1992"
    And enters subjects
    And checks hobbies as "Sports" and "Music"
    And enters address
    And selects picture from "C:\Users\mudas\Downloads\TestImage.JPEG"
    And selects state and city as "NCR" and "Agra"
    And clicks on login button
    Then Registration is successful