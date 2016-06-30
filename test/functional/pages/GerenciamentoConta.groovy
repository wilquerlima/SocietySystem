package pages
import geb.Page

class GerenciamentoConta extends Page{
    static url = "/society/pessoa/gerenciamento"
    static at = {
        title ==~ /Gerenciamento de Conta/
    }

    def selectPagamento(){
        $("input", name:pagamento).click()
    }
    def selectAlterar(){
        $("input",name: "alterar").click
    }
    def fillLogin(String login){
        $("form").login = login
    }
    def fillSenhaNova(String senha){
        $("form").senha = senha
    }
    def fillSenhaAtual(senhaAtual){
        $("form").senhaAtual = senhaAtual
    }
    def verifiqueFlashMessage(){


    }
}
