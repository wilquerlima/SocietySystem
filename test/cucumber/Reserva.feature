Feature: reserva de campo society
  As um usuário do sistema de estacionamento
  I quero ser capaz de reservar uma vaga de estacionamento
  so that eu possa me dirigir diretamente para a vaga reservada

  Scenario: reserva com campos cheios
    Given todos os campos estão ocupados
    When Eu tento reservar um campo
    Then O sistema não faz nenhuma reserva