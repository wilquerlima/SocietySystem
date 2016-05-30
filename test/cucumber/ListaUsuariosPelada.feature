Feature: List of users that used to participating of the same soccer macth
  As a usuers
  I want to send invitation for a specific group of users that play regularly with me, with no need to add a user by user
  So that they participate at this game too

  @ignore
  Scenario: adding user to a existent group
    Given “99999999999” is the cpf of a user registred a at the system
    And there is a group named “Pelada fim de semana” owned by a usuer of cpf “88888888888”
    When “88888888888” adds “99999999999” to the group “Pelada fim de semana”
    Then “99999999999” will pass to recive the game of “88888888888” destinataded to the group “Pelada fim de semana”


  Scenario: Adding inexisting user to a group
   Given "88888888888" is the owner of the group "Pelada fim de semana"
     And "99999999999" is not the cpf of a registred user
   When "88888888888" tries to add "99999999999" to the group "Pelada fim de semana"
   Then The system do not add "99999999999"


  Scenario: [GUI] Adding user to an inexistent group
    Given The user of cpf "88888888888" is at add user to the group "Pelada fim de semana" page
    When "88888888888" tries to add the user to the cpf  "99999999999" to the group "Pelada fim de semana"
    And "88888888888" is not listed between the group member "Pelada fim de semana"
    Then A subscription confirmation message to the group is shown

@ignore
  Scenario: Add inexistent user to a group
  Given The user of cpf “88888888888” is on add user to group "Pelada fim de semana" page
  And The user of cpf "99999999999" is not on allowed people to be added list
  When “88888888888” tries to add "99999999999"
  Then One erro message is shown