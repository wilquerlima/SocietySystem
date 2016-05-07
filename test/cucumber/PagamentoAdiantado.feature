Feature: As a dono de uma pelada, I can reservar um horário num campo disponível.
 So that eu tenho que escolher e fazer o pagamento antecipado de uma parte do
 valor para conseguir fazer a reserva.

Scenario: Reservar horário de um campo disponível
Given: “Otávio” está na tela de reservar horário disponível
When: “Otávio” escolhe um horário
Then: o sistema seleciona o horário desejado

Scenario: Fazer pagamento antecipado de uma parte da reserva
Given: “Otávio” já escolheu o horário desejado
And: Deseja fazer o pagamento antecipado
When: “Otávio” clica em “pagar”
Then: O sistema pede para indicar a forma de pagamento

Scenario: Selecionando forma de pagamento antecipado
Given: “Otávio” está na área de pagamento
And: preencheu todos os dados do cartão
When: “Otávio” clica no botão “Confirmar pagamento”
Then: O sistema verifica se pode ser realizado o pagamento


Scenario: O cartão do cliente é aprovado pelo sistema
Given: “Otávio” já clicou em “Confirmar pagamento”
And: Está aguardando a confirmação do sistema
When: O sistema verifica se a transação é aceita
Then: o sistema confirma a reserva

Scenario: O cartão do cliente é recusado pelo sistema
Given: Otávio” já clicou em “Confirmar pagamento”
And: Está aguardando a confirmação do sistema
When: O sistema verifica se a transação é aceita
Then: Como não foi aceita, o sistema não confirma a reserva
