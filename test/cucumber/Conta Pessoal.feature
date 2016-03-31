Feature: Conta pessoal
    As a usuário do sistema
    I want to gerenciar minha conta pessoal
    So that eu possa inserir e modificar informações para melhorar meu perfil.

    Scenario: Adicionar uma forma de pagamento
        Given “Milton” está na parte de gerenciamento de conta
        When “Milton” aperta no botão “Adicionar forma de pagamento”
        Then “Milton” é redirecionado para uma página para preencher um formulário sobre o meio de pagamento.

         Scenario: Adicionar uma foto no perfil
         Given “Milton” está na parte de gerenciamento de conta
         And e está no campo de seleção de foto para o perfil
         When “Milton” seleciona uma foto
         And clica em ‘enviar’
         Then a foto enviada aparece como foto de perfil de “Milton”.


        Scenario: Alterar senha com sucesso
        Given “Milton” é um usuário do sistema e está no gerenciamento de conta no campo de trocar senha
        And “Milton” preencheu o campo de ‘senha atual’ corretamente
        And preencheu o campo de ‘senha nova’ respeitando o tamanho permitido e os caracteres válidos
        When “Milton” aperta em ‘alterar’
        Then a senha de “Milton” passa a ser as informações contidas no campo ‘senha nova’.

        Scenario: Erro ao alterar senha
        Given “Milton” é um usuário do sistema e está no gerenciamento de conta no campo de trocar senha
        And “Milton” preencheu o campo de ‘senha atual’ com um valor que não corresponde a sua senha no sistema
        And preencheu o campo de ‘senha nova’
        When “Milton” aperta em ‘alterar’
        Then o usuário vai receber uma mensagem de erro informando que a senha atual está errada
        And a senha permanece a mesma.
