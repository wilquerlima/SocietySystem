@ignore
Feature: As a society manager,
  I want to promove, add, delete and remove offers to my society,
  So that i can raise my sells and attract more clients


  Scenario: Activate an existing offer
    Given The offer "off" is already created
    And I am at "Offer activation" page
    When i choose the offer "off"
    Then The offer "off" is set as activated


  Scenario: Delete an active offer
    Given The offer "off" is already created and activated
    When I try to delete the offer "off"
    Then The system will not delete the offer "off"

  @ignore
  Scenario: Create a new offer from scratch
    Given the system does not have the offer with the description "20off"
    When i create an offer with the description "20off"
    Then the offer "20off" will be properly stored in the system

  @ignore
  Scenario: Delete an existing offer
    Given The offer "off" with id "2" exists and it is not activated
    And I am at the "Offer list" page
    When I select the offer "off"
    And try to delete
    Then The offer "off" will be properly deleted from the system

