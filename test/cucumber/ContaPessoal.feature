Feature: Conta pessoal
  As a usuário do sistema
  I want to gerenciar minha conta pessoal
  So that eu possa inserir e modificar informações para melhorar meu perfil.


  Scenario: Adding payment form
    Given I am on "GerenciamentoConta" page
    When I select the "Adicionar forma de pagamento" option
    Then I am redirected to the "MeioPagamento" page


  @ignore
    Scenario: Adding a photo on profile
    Given "Milton" has not profile picture
    When "Milton" select the photo "Eu.jpg" on directory "C:\Users\MANOEL PERGENTINO\Desktop" and sends the system change the photo
    Then "Milton" has profile picture

  @ignore
  Scenario: Change password successfully
    Given "Milton" is a user and his password is "123"
    When "Milton" tries to change his current password "123" for new password "1234"
    Then The "Milton"'s password is "1234"

  @ignore
  Scenario: Error changing password
    Given "Milton" is on "Account Management" page and his password is "123"
    And "Milton" filled the "senha atual" field with a wrong password "1234"
    And "Milton" filled the "senha nova" field with "321"
    When "Milton" sends the system change the password
    Then The system shows a error message