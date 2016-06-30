@ignore
Feature: As a society manager,
  I want to promove, add, delete and remove offers to my society,
  So that i can raise my sells and attract more clients

@ignore
  Scenario: Activate an existing offer
    Given The offer "off" is already created
    And I am at "Offer activation" page
    When i choose the offer "off"
    Then The offer "off" is set as activated

@ignore
  Scenario: Delete an active offer
    Given The offer "off" is already created and activated
    When I try to delete the offer "off"
    Then The system will not delete the offer "off"

  @ignore
  Scenario: Create a new offer from scratch
    Given the system does not have the offer with the description "20off"
    When i create an offer with the description "20off"
    Then the offer "20off" will be properly stored in the system


  Scenario: Delete an existing and active offer
    Given The offer "20off" exists and it is activated
    And i am at "offer edit" page
    When i try to delete
    Then the offer "20off" will not be deleted

