Feature: As an user,
  I want to be able to analyze my Society expenses and Fields
  so that I am able to analyze better my profits

 Scenario: Show the maximum profit of a Society per hour
   Given I am at the Society Show Page
   When I look for the field at the Profit Value
   Then The sum of all Fields Booked values summed is shown