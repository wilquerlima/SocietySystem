Feature: As a user,
  I want to see the avaliable societies depending on the time i choose
  So that i can reserve the most suitable one
@ignore
  Scenario: Search for societies avaliable at 20:00
    Given The societies "olinda", "recife" and "jaboatao" are created
    And "olinda" and "recife" are avaliable at "20:00"
    When I try to search the avaliable societies at "20:00"
    Then The societies "olinda" and "recife" will be returned


Scenario: List the societies avaliable at 20:00
  Given The societies "olinda" and "recife" are already created and avaliable at "20:00"
  And I am at Society comparator page
  When i fill the search form with the time "20:00"
  And Try to search
  Then The societies "olinda" and "recife" will appear