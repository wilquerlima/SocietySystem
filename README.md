# SocietySystem
sistema de futebol society de ESS

grails version: 2.4.3

JDK 1.7.0_65 SDK 7 (1.8 Não funciona)

Faça o download do chromedriver compatível com sua máquina e coloque ele na pasta chromedrivers.

Em GebConfig.groovy setar caminho do chromeDriver no File

Mark as Test Source todas as subpastas imediatas de test (não as subpastas das subpastas)

Run configurations:

Grails:TA

run-app

Cucumber:TA

(IntelliJ) Para rodar os testes, crie uma configuração do grails com a seguinte linha de comando:

test-app -Dgeb.env=chrome functional:cucumber

Integração com o Travis-ci 
Entre em Travis-CI 
Selecione o botão no canto superior direito "Sign in with github" 
Clique em seu nome no canto superior direito 
Pressione o botão cinza "Sync" caso seus repositórios não estejam aparecendo 
Caso os repositórios não aparecam, dê log out e entre novamente 
Escolha o repositório que deseja testar, no caso o TA, e clique no botão cinza para que ele se torne verde 
Faça um commit qualquer para ativar a build do travis 
Caso você queira ver mais do stacktrace utilize "--verbose" logo após o comando "--stacktrace" no arquivo .travis.yml do seu repositório 
Para receber emails sobre se a build passou ou não, ative seu email no perfil do github 
