Feature: reserva de campo society
  As um usu�rio do sistema de estacionamento
  I quero ser capaz de reservar uma vaga de estacionamento
  so that eu possa me dirigir diretamente para a vaga reservada

  Scenario: reserva com campos cheios
    Given todos os campos est�o ocupados
    When Eu tento reservar um campo
    Then O sistema n�o faz nenhuma reserva