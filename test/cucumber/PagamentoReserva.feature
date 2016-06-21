Feature: make a reservation and pay it
  As a owner of a match
  I want to make a reservation of an available time at a field
  So that I have to choose and make the reservation payment to achieve effectuate it

      Scenario: make the payment of the reservation
        Given I have already chosen the available schedule "17/06/2016","17:00","18:00" at field "1"
        When I fill the fields with "100","123342323","André Luna" and "123"
        Then a confirmation message is displayed

      Scenario: make a reservation without availables schedules
        Given that all the schedules are occupied
        When I try to reservate an schedule
        Then The system makes no reservation

      Scenario: reservation with and without available schedules
        Given some schedules are not occupied
        When I try to reservate an schedule
        Then The system makes a reservation