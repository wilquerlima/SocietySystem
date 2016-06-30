package steps

import cucumber.api.PendingException
import societysystem.Usuario
import societysystem.Grupo
import societysystem.UsuarioController
import societysystem.GrupoController


def createUsuario(def cpf, String nome, boolean isOwner, UsuarioController cont)
{
    cont.criarUsuario(cpf, nome, isOwner)
    cont.response.reset()
}

void createGrupo(String nome, int id, Usuario usu, GrupoController cont)
{
    cont.criarGrupo(nome, id)
    usu.isOwner = true
    usu.idGrupo = id
    cont.response.reset()
}

boolean isUsuarioGrupo(Usuario usu, Grupo gru)
{
    def grupo = Grupo.findByNome(gru.nome)
    if (usu.idGrupo == grupo.id)
    {
        return true
    }

    return false
}

void adicionaGrupo(Usuario dono, String cpfNovo)
{
    def novo = Usuario.findByCpf(cpfNovo)
    if (dono.getIsOwner() && novo != null)
    {
        novo.setIdGrupo(dono.getIdGrupo())
    }
}

boolean isOwnerGroup(Usuario usu, String grupoNome)
{
    def grupo = Grupo.findByNome(grupoNome)

    if(grupo.id == usu.idGrupo && usu.isOwner)
    {
        return true;
    }

    return false
}

//test-app -Dgeb.env=chrome functional:cucumber --stacktrace --verbose