Feature: As um usu�rio,
  I can criar, alterar, modificar e remover um Campo do meu Society
  so that eu posso administrar o meu society de forma coerente

  Scenario: Atualizar a lista de Campos assim que adicionar um novo Campo
    Given usuario cadastrou o campo com nome "A" ao seu Society
    When  estou na pagina "detalhes do Society X"
    Then uma lista atualizada com todos os campos cadastrados deve aparecer na tela "Campos do Society X"

  Scenario: Cadastrar Campo "B" a Lista de Campos de um Society "C"

    Given eu estou na tela de cadastro de Campos de um Society
    And eu preencho os dados corretamente
    When  �Finalizar Cadastro�
    Then sou enviado � tela de Detalhes do Society e Uma mensagem de Sucesso � mostrada

  Scenario: Cadastrar um mesmo campo duas vezes
    Given eu estou na tela cadastrar campo
    And preencho o nome do campo como campo "A"
    When  cadastro o campo "A"
    Then o sistema exibe uma mensagem "o campo A ja existe"

  Scenario: Cadastrar Campo com dados insuficientes
    Given eu estou na tela de cadastrar campo
    And eu n�o preencho o nome do campo
    When tento cadastrar o campo
    Then o sistem emite uma mensagem de erro