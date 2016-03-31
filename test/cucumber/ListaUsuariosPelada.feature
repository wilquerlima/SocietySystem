Feature: Lista de usuários que costumam participar de uma mesma pelada
As a Usuário
I want to enviar convite para um grupo especifico de usuários que jogam regulamente comigo, sem precisar adiciona usuário a usuário
so that que eles participem desse jogo também.

Scenario: Adicionar usuário a um grupo existente
Given : “André” é um usuário cadastrado no sistema
And “Carlos” tem um grupo com usuários “Pelada fim de semana”
When: “Carlos” adicionar “andre” ao grupo “Pelada fim de semana”
Then: “André” passará a receber convites de jogos de “Carlos” destinados ao grupo “Pelada fim de semana”.
Scenario: Adicionar usuário a um grupo inexistente
Given: “André” é um usuário cadastrado no sistema
And “Carlos” tem nenhum grupo com usuários
When: “Carlos” adicionar “André” ao grupo “Pelada fim de semana”
Then: O sistema não adiciona “André”

Scenario:[GUI] Adicionar usuário a um grupo existente
Given: “Carlos” está no menu de adicionar usuários ao grupo “Pelada fim de semana”
When: “Carlos” tenta adicionar “André” ao grupo
Then: Uma mensagem de confirmação de inscrição ao grupo é mostrada

Scenario:[GUI] Adicionar usuário a um grupo inexistente
Given: “Carlos” está no menu de adicionar grupo
And não há grupos salvos
When: “Carlos” tenda adicionar “André”
Then: Uma mensagem de erro é exibida