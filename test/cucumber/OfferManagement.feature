Feature: As a society manager,
  I want to promove, add, delete and remove offers to my society,
  So that i can raise my sells and attract more clients


  Scenario: Promove an existing offer
    Given The offer "off" with id "2" exists
    And I am at the "Offer activation" page
    When i choose the offer "off"
    Then The offer "off" is set as activated

  Scenario: Create a new offer from scratch
    Given the system does not have the offer with the description "20off"
    When i create an offer with the description "20off"
    Then the offer "20off" will be properly stored in the system