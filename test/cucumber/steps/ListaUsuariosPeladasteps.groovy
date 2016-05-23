package steps

import cucumber.api.PendingException
import steps.TesteUsuario
import societysystem.UsuarioController
import societysystem.GrupoController
import societysystem.Usuario
import static cucumber.api.groovy.EN.*


Given(~/^"([^"]*)" is the owner of the group "([^"]*)"$/) {
    String cpf, grupo ->
        def t = new TesteUsuario()
        def contGrupo = new GrupoController()
        def contUsuario = new UsuarioController()
        t.createGrupo(grupo, 1, contGrupo)
        t.createUsuario(cpf, 'andre', true, 1, contUsuario)
        def usu = Usuario.findByCpf(cpf)
        def gru = Grupo.finfByNome(grupo)
        assert usu == null
        assert gru != null
        //assert t.isUsuarioGrupo(usu, gru) == true

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










