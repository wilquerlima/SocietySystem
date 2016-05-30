package steps

import cucumber.api.PendingException
import societysystem.Usuario
import societysystem.Grupo
import societysystem.UsuarioController
import societysystem.GrupoController


def createUsuario(def cpf, String nome, boolean isOwner, int idGrupo, UsuarioController cont)
{
    cont.params << [cpf: cpf, nome: nome, isOwner: isOwner, idGrupo: idGrupo]
    cont.save()
    cont.response.reset()
}

void createGrupo(String nome, int id, GrupoController cont)
{
    cont.params << [nome: nome, id: id]
    cont.save()
    cont.response.reset()
}

boolean isUsuarioGrupo(Usuario usu, Grupo gru)
{
    if (usu.idGrupo == Grupo.findByNome(gru.nome))
    {
        return true
    }

    return false
}

void adicionaGrupo(Usuario dono, Usuario novo)
{
    if (dono.isOwner)
    {
        novo.idGrupo = dono.idGrupo
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