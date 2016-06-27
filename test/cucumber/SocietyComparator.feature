
Feature: As a user,
  I want to see the avaliable societies
  So that i can reserve the most suitable one

  Scenario: Search for societies avaliable at 20:00
    Given The societies "olinda", "recife" and "jaboatao" are created
    And "olinda" and "recife" are avaliable at "20:00"
    When I try to search the avaliable societies at "20:00"
    Then The societies "olinda" and "recife" will be returned


Scenario: List the avaliable societies
  Given The societies "olinda" and "recife" are already created and avaliable at "20:00"
  And I am at Society comparator page
  When try to look at avaliable societies
  Then The societies "olinda" and "recife" will appear


