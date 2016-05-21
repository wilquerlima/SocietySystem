Feature: Lista de usuários que costumam participar de uma mesma pelada
  As a Usuário
  I want to enviar convite para um grupo especifico de usuários que jogam regulamente comigo, sem precisar adiciona usuário a usuário
  so that que eles participem desse jogo também.

  Scenario: Adicionar usuário a um grupo existente
    Given : “999.999.999-99” é o cpf de um usuário cadastrado no sistema
    And: O usuario de cpf “888.888.888-88” tem um grupo com usuários “Pelada fim de semana”
    When: “888.888.888-88” adiciona “999.999.999-99” ao grupo “Pelada fim de semana”
    Then: “999.999.999-99” passará a receber convites de jogos de “888.888.888-88” destinados ao grupo “Pelada fim de semana”.

  Scenario: Adicionar usuário inexistente a um grupo
    Given: “Pelada fim de semana” é um grupo pertencente ao usuario de cpf “888.888.888-88”
    And: "999.999.999-99" não cpf de um usuário cadastrado no sistema
    When: “888.888.888-88" tenta adicionar “999.999.999-99” ao grupo “Pelada fim de semana”
    Then: O sistema não adiciona “999.999.999-99”

  Scenario:[GUI] Adicionar usuário a um grupo existente
    Given: O usuario de cpf “888.888.888-88” está no menu de adicionar usuários ao grupo “Pelada fim de semana”
    When: “888.888.888-88” tenta adicionar o usuario de cpf “999.999.999-99” ao grupo “Pelada fim de semana”
    And: "888.888.888-88" não está listado entre os membros do grupo “Pelada fim de semana”
    Then: Uma mensagem de confirmação de inscrição ao grupo é mostrada

  Scenario:[GUI] Adicionar usuário  inexistente a um grupo
    Given: O usuario de cpf “888.888.888-88” está no página de adicionar usuário ao grupo “Pelada fim de semana”
    And: O usuario de cpf "999.999.999-99" não aparece na lista de pessoas aptas a ser adicionadas
    When: “888.888.888-88” tenta adicionar “999.999.999-99”
    Then: Uma mensagem de erro é exibida