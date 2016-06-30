package steps

import cucumber.api.PendingException
import societysystem.Grupo
import steps.TesteUsuario
import societysystem.UsuarioController
import societysystem.GrupoController
import societysystem.Usuario
import pages.AddUserToGroupPage
import static cucumber.api.groovy.EN.*


Given(~/^"([^"]*)" is the owner of the group "([^"]*)"$/) {
    String cpf, String grupo ->
        def t = new TesteUsuario()
        GrupoController contGrupo = new GrupoController()
        UsuarioController contUsuario = new UsuarioController()
        t.createUsuario(cpf, 'andre', true, contUsuario)
        def usu = Usuario.findByCpf(cpf)
        t.createGrupo(grupo, 1, usu, contGrupo)
        def gru = Grupo.findByNome(grupo)
        assert usu != null
        assert gru != null
        assert t.isUsuarioGrupo(usu, gru) == true

}

And(~/^"([^"]*)" is not the cpf of a registred user$/) {
    String cpf ->
    assert Usuario.findByCpf(cpf) == null
}

When(~/^"([^"]*)" tries to add "([^"]*)" to the group "([^"]*)"$/) {
    String usuNome1, String usuNome2, String grupo ->
    def t = new TesteUsuario()
    def usu1 = Usuario.findByCpf(usuNome1)
    assert t.isOwnerGroup(usu1, grupo) == true
    t.adicionaGrupo(usu1, usuNome2)
}

Then(~/^The system do not add "([^"]*)"$/) {
    String cpf ->
    def usu = Usuario.findByCpf(cpf)
    assert usu == null
}





Given(~/^I am at add user to the group "([^"]*)" page$/) { String arg1 ->
    to AddUserToGroupPage
}


And(~/^"([^"]*)" is not listed between the group member "([^"]*)"$/) {
    String cpf, String group ->
        at AddUserToGroupPage
        page.criarUsuario(cpf)
        page.criarGrupo(group)
        assert page.isMember(cpf, group) == false
}


When(~/^I try to add the user of cpf  "([^"]*)" to the group "([^"]*)"$/) {
    String cpf, String group->
    at AddUserToGroupPage
    page.addPessoa(cpf, group)
}

Then(~/^A subscription confirmation message to the group is shown$/) { ->
    at AddUserToGroupPage
}


