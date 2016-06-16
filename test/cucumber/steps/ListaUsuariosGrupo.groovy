package steps

import cucumber.api.PendingException
import societysystem.Frequencia
import societysystem.FrequenciaController
import societysystem.Grupo
import societysystem.Usuario
import societysystem.UsuarioController
import societysystem.GrupoController
import steps.TesteListagemUsuarios

import static cucumber.api.groovy.EN.*


Given(~/^"([^"]*)" is the name of existent a group$/) {
    String groupName ->
    def grupo = Grupo.findByNome(groupName)
    assert grupo == null
}

And(~/^"([^"]*)" has users$/) {
    String groupName ->
    TesteListagemUsuarios t = new TesteListagemUsuarios()
    assert t.hasMember(groupName) == false
}

When(~/^I try to mark the user of cpf "([^"]*)" as present at game of group "([^"]*)"$/) {
    String cpf, String group ->
    FrequenciaController f = new FrequenciaController()
    def usuario = Usuario.findByCpf(cpf)
    def grupo = Grupo.findByNome(group)
    f.presenca(usuario)
}

Then(~/^The system add the user of cpf "([^"]*)"  as present at game of group "([^"]*)"$/) {
    String cpf, String groupNome ->
        Usuario usuario = Usuario.findByCpf(cpf)
        Frequencia f = Frequencia.findByUsuario(usuario)
        assert f.getPresente() == false
}



Given(~/^The user of cpf "([^"]*)" belongs to the group "([^"]*)"$/) {
    String cpf, String group ->
    TesteListagemUsuarios t = new TesteListagemUsuarios()
    assert t.isMember(cpf, group) == false
}

When(~/^I try to check his frequency at the group "time' plays$/) { ->

}

Then(~/^It is shown a list with his frequency at each game$/) { ->

}

