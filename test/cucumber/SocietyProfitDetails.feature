Feature: As an user,
  I want to be able to analyze my Society expenses and Fields
  so that I am able to analyze better my profits

  Scenario: Show the profit of a Society will make on that day
    Given I have a field "f1" that belongs to "s1"
    And I am at the Society Society Show Page of "s1"
    When I look for the field at the Profit Value
    Then The sum of all Fields of "s1" values summed is shown

  Scenario: Show the maximum profit of a Society per hour
    Given I have some Fields Booked that belong to a Society "s1"
    When I want to see how much I am gonna make in total
    Then The system returns the sum of all "s1" Fields Value

  Scenario: Add a field to a Society
    Given I am at the Society Add Field Page of "s1"
    When I try to add a field "f1" on society "s1"
    Then "s1" now has a non empty list of fields