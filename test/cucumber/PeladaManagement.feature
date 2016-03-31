Feature: As a usuário, I want to criar peladas, apagar peladas, receber notificações da pelada, convocar membros de uma
  pelada, setar os participantes de uma pelada como um “Time”, reservar um campo para uma pelada, cancelar uma reserva
  antes do tempo limite.

  Scenario[GUI]: Receber notificações de Peladas Próximas

    Given Eu estou na tela principal
    AND eu tenha uma pelada no dia
    When Eu logar no sistema
    Then O ícone de notificação deve estar sinalizando(com uma mensagem) que tenho uma pelada no dia

  Scenario: Nome de Society Duplicado

    Given O sistema possui um Society cadastrado com o nome “teste”
    When Eu tento salvar um Society com o nome “teste”
    Then O Sistema não permite e emite uma mensagem de erro

  Scenario: Cancelar reserva de Society

    Given eu estou no Society
    AND a reserva não ultrapassou o horário limite para cancelamento
    When eu clico “Cancelar Reserva”
    Then A Reserva some da minha agenda

  Scenario: Notificar Cancelamento de Reserva

    Given Uma pelada ao qual eu estava cadastrada foi cancelada
    When Eu logo no sistema
    Then Uma mensagem notificando o cancelamento daquela pelada é mostrada


