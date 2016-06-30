Feature: Verify the user presency at the game
  As the owner of a group
  I want to manage the frequency of each user
  So that I can see how miss the game

 @ignore
  Scenario: Marking a player present
    Given "time" is the name of existent a group
    And "time" has users
    When I try to mark the user of cpf "88888888888" as present at gameof group "time"
    Then The system add the user of cpf "88888888888"  as present at game of group "time"

  @ignore
    Scenario: [GUI] Seeing the frequency of a specific user
    Given The user of cpf "88888888888" belongs to the group "time"
    When I try to check his frequency at the group "time' plays
    Then It is shown a list with his frequency at each game
