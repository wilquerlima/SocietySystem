Feature: As uma pessoa,
	I want to me cadastrar no sistema, 
	So that eu possa participar da comunidade como um todo

Scenario[GUI] : Erro ao Cadastrar no sistema com um usuário já existente

Given eu estou na tela de Login 
AND preenchi o e-mail com um usuário já existente na base
When eu clico ‘Cadastrar”
Then Uma mensagem “Usuário já cadastrado” é mostrada na tela


Scenario[GUI]: Falha ao logar no sistema com usuario nao cadastrado
Given eu estou na tela de Login 
AND eu preenchi o e-mail com um e-mail que não está cadastrado no sistema, e preenchi o campo de senha
When eu clico ‘Logar’
Then Uma mensagem de erro “Usuário não cadastrado” é mostrada na tela.


Scenario: Colocar dados incompatíveis
Given eu sou uma pessoa
And nao sou cadastrado
When coloco meus dados
And aperto no botao "cadastrar"
Then o sistema não permite o cadastro do usuário


Scenario: Cadastrar no sistema com sucesso através do e-mail

Given eu estou na tela de Login 
AND preenchi o e-mail e senha corretamente
When eu clico ‘Cadastrar’
Then O sistema irá adicionar um novo User ao sistema


