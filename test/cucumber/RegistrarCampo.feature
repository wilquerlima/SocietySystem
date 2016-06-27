Feature: As an user,
  I can create, modify and remove a Field on Society
  so that I am able to Manage my Society correctly

  Scenario: Register a Field that does not exist
    Given There is no Field named "A"
    When  I try to register the field "A"
    Then The system does register Field "A"


  Scenario: Try to Register a Field with data missing
    Given I am at Register Field page
    And I do not fill the page name attribute field
    When I try to finish the Registration
    Then The system shows an error message