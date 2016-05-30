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
        t.createGrupo(grupo, 1, contGrupo)
        t.createUsuario(cpf, 'andre', true, 1, contUsuario)
        def usu = Usuario.findByCpf(cpf)
        def gru = Grupo.findByNome(grupo)
        assert usu != null
        assert gru != null
        assert t.isUsuarioGrupo(usu, gru) == true

}

And(~/^"([^"]*)" is not the cpf of a registred user$/) {
    String cpf ->
    assert Usuario.findByCpf(cpf) == true
}

When(~/^"([^"]*)" tries to add "([^"]*)" to the group "([^"]*)"$/) {
    String usu1, usu2, grupo ->
    def t = new TesteUsuario()
    assert t.isOwnerGroup(usu1, grupo) == true
    t.adicionaGrupo(usu1, usu2)
}

Then(~/^The system do not add "([^"]*)"$/) {
    String cpf ->
    def usu = Usuario.findByCpf(cpf)
    assert usu == null
    assert usu.idGrupo != 0
}




Given(~/^The user of cpf "([^"]*)" is at add user to the group "([^"]*)" page$/) {
    String cpf, String group ->
        to AddUserToGroupPage
}

When(~/^"([^"]*)" tries to add the user to the cpf  "([^"]*)" to the group "([^"]*)"$/) {
    String cpf1, String cpf2, String group->
        at AddUserToGroupPage
        page.addPessoa(cpf1, cpf2, group)
}

And(~/^"([^"]*)" is not listed between the group member "([^"]*)"$/) {
    String cpf, String group ->
        at AddUserToGroupPage
        page.isMember(cpf, group)
}

Then(~/^A subscription confirmation message to the group is shown$/) { ->
    at AddUserToGroupPage
    flash.message = "pessoa adicionada ao grupo"
}
