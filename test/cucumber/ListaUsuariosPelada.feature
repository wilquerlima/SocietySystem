Feature: Lista de usuários que costumam participar de uma mesma pelada
  As a Usuário
  I want to enviar convite para um grupo especifico de usuários que jogam regulamente comigo, sem precisar adiciona usuário a usuário
  so that que eles participem desse jogo também.

  Scenario: Adicionar usuário a um grupo existente
    Given : “André Luna” é um usuário cadastrado no sistema
    And “Carlos Henrique” tem um grupo com usuários “Pelada fim de semana”
    When: “Carlos Henrique” adicionar “André Luna” ao grupo “Pelada fim de semana”
    Then: “André Luna” passará a receber convites de jogos de “Carlos Henrique” destinados ao grupo “Pelada fim de semana”.

  Scenario: Adicionar usuário inexistente a um grupo
    Given: “Pelada fim de semana” é um grupo pertencente a “Carlos Henrique”
    And  "André Luna" não é um usuário cadastrado no sistema
    When: “Carlos” Henrique adiciona “André Luna” ao grupo “Pelada fim de semana”
    Then: O sistema não adiciona “André Luna”

  Scenario:[GUI] Adicionar usuário a um grupo existente
    Given: “Carlos Henrique” está no menu de adicionar usuários ao grupo “Pelada fim de semana”
    When: “Carlos Henrique” tenta adicionar “André Luna” ao grupo “Pelada fim de semana”
  and "Carlos Henrique" não está listado entre os membros do grupo “Pelada fim de semana”
    Then: Uma mensagem de confirmação de inscrição ao grupo é mostrada

  Scenario:[GUI] Adicionar usuário  inexistente a um grupo
    Given: “Carlos Henrique” está no página de adicionar usuário ao grupo “Pelada fim de semana”
    And "André Luna" não aparece na lista de pessoas aptas a ser adicionadas
    When: “Carlos Henrique” tenta adicionar “André Luna”
    Then: Uma mensagem de erro é exibida