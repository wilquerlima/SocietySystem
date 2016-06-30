package pages
import geb.Page

class CreatePessoa extends Page{
    static url = "/society/pessoa/create"
    static at = {
        title ==~ /Criar pessoa/
    }
    def criar(String nome, String senha){
        $("form").nome = nome
        $("form").senha = senha
        $("input", name: "create").click()
    }
}
