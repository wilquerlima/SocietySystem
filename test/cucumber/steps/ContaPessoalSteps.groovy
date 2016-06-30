import org.springframework.web.multipart.commons.CommonsMultipartFile
import pages.*
import societysystem.Pessoa
import societysystem.Image
import societysystem.PessoaController
import societysystem.ImageController
import static cucumber.api.groovy.EN.*
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.Hooks)

def criarPessoa(String nome, String senha, PessoaController controlador){
    controlador.params << [nome: nome, senha: senha]
    controlador.save()
    controlador.response.reset()
}
def alterarFoto(String nome, File file,PessoaController controlador){
    controlador.params << [loginImage: nome,file: file]
    controlador.saveImage()
    controlador.response.reset()
}

Given(~'^I am on "([^"]*)" page$'){String pagina ->
    to GerenciamentoConta
    at GerenciamentoConta
}
When(~'^I select the "([^"]*)" option$'){String comando ->
    assert comando == "pagamento"
    page.selectPagamento()
}

Then(~'^I am redirected to the "([^"]*)" page$'){String pagina ->
    to MeioPagamento
    at MeioPagamento
}

Given(~'^"([^"]*)" has not profile picture$'){String nome ->
    def controlador = new PessoaController()
    criarPessoa(nome,"",controlador)
    Pessoa p = Pessoa.findByNome(nome)
    assert p.getImagem() == null
}
When(~'^"([^"]*)" select the photo "([^"]*)" on directory "([^"]*)" and sends the system change the photo$'){
    String nome, String fileName, String dir ->
        def controlador = new PessoaController()
        def file = new File(dir)
        alterarFoto(nome, file,controlador)
}

Then(~'"([^"]*)" has profile picture^$'){
    Pessoa p = Pessoa.findByNome(nome)
    assert p.getImagem() != null
}

Given(~'^"([^"]*)" is a user and his password is "([^"]*)"$'){ String nome, String senhaAtual ->
    PessoaController controlador = new PessoaController()
    criarPessoa(nome,senhaAtual,controlador)
    assert(Pessoa.findByNome(nome))
}

When(~'^"([^"]*)" tries to change his current password "([^"]*)" for new password "([^"]*)$"'){
    String nome, String senhaAtual, String senhaNova ->
    PessoaController controlador = new PessoaController()
    alterarSenha(nome, senhaAtual, controlador)

}
Then(~'^The ""([^"]*)"\'s password is ""([^"]*)"$'){String nome, String senha ->
    Pessoa p = Pessoa.findByNome(nome)
    assert p.getSenha() == senha
}



Given(~'^"([^"]*)" is on "Account Management" page and his password is "([^"]*)"$'){
    String nome, String senha ->
    to CreatePessoa
    at Create Pessoa
    page.criar(nome,senha)

    to GerenciamentoConta
    at GerenciamentoConta

}
And(~'^"([^"]*)" filled the "([^"]*)" field with a wrong password "([^"]*)"$'){String nome, String campo, String senhaAtual ->
    page.fillLogin(nome)
    page.fillSenhaAtual(senhaAtual)
    page.fillSenhaAtual(senhaAtual)
    Pessoa p = Pessoa.findByNome(nome)
    assert (p.getSenha() != senhaAtual)
}
And(~'"([^"]*)" filled the "([^"]*)" field "([^"]*)"$'){String campo, String senha ->
    page.fillSenhaNova(senha)
}
When(~'^"([^"]*)" sends the system change the password$'){String comando ->
    page.selectAlterar()
}
Then(~'^The system shows a error message$'){
    page.verifiqueFlashMessage()
}
